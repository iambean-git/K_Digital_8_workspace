import { useEffect, useState, useRef } from "react"
import BoxOfficeTr from "./BoxOfficeTr";

export default function BoxOffice() {
    const [tdata, setTdata] = useState([]);
    const [trs, setTrs] = useState([]);
    const [mvInfo, setMvinfo] = useState([]);

    const dtRef = useRef();

    //어제 날짜 구하는 함수
    const getYesterday = () => {
        const yesterday = new Date();
        yesterday.setDate(yesterday.getDate() -1);    
        let dateString = '';
        dateString = dateString + yesterday.getFullYear() +"-"
                    +(("0" +(yesterday.getMonth()+1))).slice(-2) + "-"
                    +("0" +yesterday.getDate()).slice(-2)
        return dateString;
    }


    const getFetchData = (dt) => {
        //env에 있는 key 가져오기
        const apiKey = process.env.REACT_APP_MV_KEY;
                
        let url = `https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?`;
        url = `${url}key=${apiKey}&targetDt=${dt}`;
        //console.log('url=',url);

        //데이터 가져오기 (fetch)
        fetch(url)
            .then(resp => resp.json())
            .then(data => {
                //console.log(data);
                setTdata(data.boxOfficeResult.dailyBoxOfficeList);
            })
            .catch(err => console.log(err))
    }

    const handleTrClick = (movieCd) => {
        const apiKey = process.env.REACT_APP_MV_KEY;

        let url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?';
        url = `${url}key=${apiKey}&movieCd=${movieCd}`
        //console.log('url=',url);

        fetch(url)
            .then(resp => resp.json())
            .then(data =>{
                //console.log(data.movieInfoResult.movieInfo);
                let mvInfos = data.movieInfoResult.movieInfo;
                const detailInfo = <td colSpan={5} className="pl-2">{mvInfos.movieNm}
                ({mvInfos.movieNmEn}) / {mvInfos.nations[0].nationNm} / {mvInfos.showTm}분
                            <br/> 감독 | {mvInfos.directors[0].peopleNm}({mvInfos.directors[0].peopleNmEn})
                    </td>
                
                ;
                setMvinfo(detailInfo);
                
            })
            .catch(err => console.log(err))

    }

    //맨처음 한번 실행
    useEffect(() => {
        const ydt= getYesterday();
        // console.log("Yesterday Date : ", ydt);

        //input부분에 어제 날짜를 default로 넣어주기
        dtRef.current.value = ydt;
        dtRef.current.max = ydt;
        getFetchData(ydt.replaceAll("-",""));
    }, []);


    //fetch 데이터가 채워지면
    useEffect(() => {
        //console.log("tdata is ", tdata);

        //컴포넌트 생성해서 만들기
        const mvList = tdata.map(item =>  <BoxOfficeTr key={item.movieNm}
                                                       mvitem={item}
                                                       handleClick = {()=>handleTrClick(item.movieCd)}
                                                       />
        );

        setTrs(mvList);
    }, [tdata])

    //날짜 변경되면 
    const handleDateChange = () => {
        //console.log("선택된 날짜", dtRef.current.value.replaceAll("-",""));
        getFetchData(dtRef.current.value.replaceAll("-",""));
        
    }

    return (
        <div className="w-full h-screen flex flex-col justify-center items-center">
            <div className="flex flex-row justify-between items-center
                            w-10/12 mb-10">
                <div className="text-2xl font-bold text-indigo-500
                                px-6">
                    🎬 박스오피스 🎬
                </div>
                <div className="px-6">
                    <input ref={dtRef} type="date" id='dt' name="dt" 
                            onChange={handleDateChange}/>
                </div>
            </div>

            <table className="w-10/12 text-sm text-left rtl:text-right text-gray-500">
                <thead className="text-sm text-gray-700 uppercase whitespace-nowrap bg-gray-300">
                    <tr>
                        <th scope="col" className="px-6 py-3">
                            순위
                        </th>
                        <th scope="col" className="px-6 py-3">
                            영화명
                        </th>
                        <th scope="col" className="px-6 py-3">
                            매출액
                        </th>
                        <th scope="col" className="px-6 py-3">
                            관객수
                        </th>
                        <th scope="col" className="px-6 py-3">
                            증감율
                        </th>
                        
                    </tr>
                </thead>
                <tbody>
                    {trs}
                    {/* <tr className="bg-white border-b hover:bg-gray-50">
                        <th scope="row" className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">
                            1
                        </th>
                        <td scope="row" className="px-6 py-4 whitespace-nowrap">
                            Apple MacBook Pro 17"
                        </td>
                        <td className="px-6 py-4">
                            Silver
                        </td>
                        <td className="px-6 py-4">
                            Laptop
                        </td>
                        <td className="px-6 py-4">
                            $2999
                        </td>
                        
                    </tr> */}

                </tbody>
                <tfoot>
                    <tr className="bg-gray-600 text-white w-full text-left h-14 p-2 ">
                        {mvInfo}
                        
                    </tr>
                    
                </tfoot>
            </table>
            {/* <div className=" w-10/12 border border-slate-400 mt-3">
                <div>
                제목 (영어제목) / 나라 / 분
                </div>
            </div> */}
        </div>

    )
}
