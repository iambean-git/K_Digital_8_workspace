import { useEffect, useState } from "react"
import BoxOfficeTr from "./BoxOfficeTr";

export default function BoxOffice() {
    const [tdata, setTdata] = useState([]);
    const [trs, setTrs] = useState([]);
    const [mvInfo, setMvinfo] = useState([]);

    const getFetchData = () => {
        //env에 있는 key 가져오기
        const apiKey = process.env.REACT_APP_MV_KEY;
        const dt = '20240929';

        let url = `https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?`;
        url = `${url}key=${apiKey}&targetDt=${dt}`;

        //console.log('apiKey=',apiKey);
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
        //console.log(movieCd);

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
        getFetchData();
    }, []);


    //fetch 데이터가 채워지면
    useEffect(() => {
        //console.log("tdata is ", tdata);

        //컴포넌트 별도 생성 안하고 만들기
        // const mvList = tdata.map(item => 
        //     <tr key={item.movieNm}
        //     className="bg-white border-b hover:bg-gray-50">
        //                 <th scope="row" className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">
        //                     {item.rank}
        //                 </th>
        //                 <td scope="row" className="px-6 py-4 whitespace-nowrap">
        //                     {item.movieNm}
        //                 </td>
        //                 <td className="px-6 py-4">
        //                     {item.salesAmt}
        //                 </td>
        //                 <td className="px-6 py-4">
        //                     {item.audiCnt}
        //                 </td>
        //                 <td className="px-6 py-4">
        //                     {item.rankInten}
        //                 </td>
        //             </tr>
        // );


        //컴포넌트 생성해서 만들기
        const mvList = tdata.map(item =>  <BoxOfficeTr key={item.movieNm}
                                                       mvitem={item}
                                                       handleClick = {()=>handleTrClick(item.movieCd)}
                                                       />
        );

        setTrs(mvList);
    }, [tdata])


    return (
        <div className="w-full h-screen flex flex-col justify-center items-center">

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
