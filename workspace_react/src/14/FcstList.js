import { useSearchParams } from "react-router-dom";
import getcodeData from './getcode.json';
import { useEffect, useState, useRef } from "react";

export default function FcstList() {
    const skyValue = ['','🌞 맑음','⛅ 구름약간','☁ 구름많음','🌫 흐림'];
    const ptyValueShort = ['없음', '☂ 비', '🌨 비/눈', '❄ 눈', '🌧 소나기'];
    const ptyValueUshort = ['없음', '비', '비/눈','눈','-',
                            '빗방울', '빗방울눈날림','눈날림'];
    const [tdata, setTdt] = useState([]);
    const [options, setOpts] = useState([]);
    const [trs, setTrs] = useState([]);
    const selRef = useRef();

    const [sparams] = useSearchParams();

    //쿼리 값 가져오는 쉬운 방법
    const area = sparams.get('area');
    const selDate = sparams.get('date');
    const dateText = selDate.substring(0,4)+"-"+selDate.substring(4,6)+"-"+selDate.substring(6,8);
    const gubun = sparams.get('sortq');
    const nx = sparams.get('nx');
    const ny = sparams.get('ny');
    let sortq = (gubun == "ushort") ? "초단기예보" : "단기예보";

    useEffect(() => {
        getFetchData(sortq, selDate, nx, ny);
        setOptions(sortq);
    }, []);

    const setOptions = (sortq) => {
        let options = getcodeData.filter(i => i["예보구분"] == sortq)
            .map(i => <option key={i["항목값"]} value={i["항목값"]} >{i["항목명"]}({i["항목값"]})</option>);
        setOpts(options);
    }

    const getFetchData = async (sortq, selDate, nx, ny) => {
        const apiKey = process.env.REACT_APP_API_KEY;
        let url = 'https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/';
        url = `${url}${sortq == "초단기예보" ? "getUltraSrtFcst" : "getVilageFcst"}?`
        url = `${url}serviceKey=${apiKey}&pageNo=1&numOfRows=1000&dataType=JSON&`;
        url = `${url}base_date=${selDate}&base_time=0500&nx=${nx}&ny=${ny}`;

        //console.log(url);

        const resp = await fetch(url);
        const data = await (resp.json());
        //console.log("data 입니다"); console.log(data.response.body.items.item);
        setTdt(data.response.body.items.item);
    }

    const setTableData = () => {
        let code = selRef.current.value;
        //console.log("txt");     console.log(codeTxt);

        const selected = tdata.filter(i => i['category'] == code);
        const codeInfo = getcodeData.filter(i=>i['항목값']===code)[0];
        //console.log("selected"); console.log(selected);
        //console.log("codeInfo"); console.log(codeInfo);
        const tags = selected.map((i,idx) => <tr key={i['category']+idx} className="bg-white border-b hover:bg-gray-50">
            <th scope="row" className="px-6 py-4 font-normal whitespace-nowrap ">
                {codeInfo.항목명 }
            </th>
            <td className="px-6 py-4">
                {i['fcstDate'].substring(0,4)+"-"+i['fcstDate'].substring(4,6)+"-"+i['fcstDate'].substring(6,8)}
            </td>
            <td className="px-6 py-4">
                {i['fcstTime'].substring(0,2) + " : " + i['fcstTime'].substring(2,)}
            </td>
            <td className="px-6 py-4">
                {code==="SKY"? skyValue[i['fcstValue']]:
                code==='PTY'&&sortq==='단기예보'?  ptyValueShort[i['fcstValue']] : 
                code==='PTY'&&sortq==='초단기예보'?  ptyValueUshort[i['fcstValue']] : 
                i['fcstValue'] + codeInfo.단위}
            </td>
        </tr>);
        setTrs(tags);
    }

    return (
        <div className="w-10/12">
            <div className=" flex justify-between px-10 my-10">
                <h1 className="text-2xl font-bold whitespace-nowrap"> {sortq} : {area} ({dateText})   </h1>
                <select name="sele" onChange={setTableData} ref={selRef}
                    className="form-select w-1/3
                                bg-gray-50 border-2 border-gray-300  text-gray-900 text-sm rounded-lg">
                    <option defaultValue='noRegion' hidden >
                        선택
                    </option>
                    {options}
                </select>
            </div>

            <div className="relative overflow-x-auto shadow-md sm:rounded-lg mb-10">
                <table className="w-full text-sm text-left rtl:text-right text-gray-500">

                    <thead className="text-xs text-gray-700 uppercase bg-gray-50  ">
                        <tr>
                            <th scope="col" className="px-6 py-3">
                                항목명
                            </th>
                            <th scope="col" className="px-6 py-3">
                                예측날짜
                            </th>
                            <th scope="col" className="px-6 py-3">
                                예측시간
                            </th>
                            <th scope="col" className="px-6 py-3">
                                항목값
                            </th>

                        </tr>
                    </thead>
                    <tbody>
                        {trs}
                    </tbody>
                </table>
            </div>

        </div>
    )
}
