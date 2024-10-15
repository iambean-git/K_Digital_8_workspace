import { useLocation, useSearchParams } from "react-router-dom";
import getcodeData from './getcode.json';
import { useEffect, useState, useRef } from "react";

export default function FcstList() {

    const [tdata, setTdt] = useState([]);
    const [options, setOpts] = useState([]);
    const [trs, setTrs] = useState([]);
    const selRef = useRef();

    const [sparams] = useSearchParams();

    //쿼리 값 가져오는 쉬운 방법
    const area = sparams.get('area');
    const selDate = sparams.get('date');
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
            .map(i => <option key={i["항목값"]} value={i["항목명"] + "," + i["항목값"]} >{i["항목명"]}({i["항목값"]})</option>);
        setOpts(options);
    }

    const getFetchData = async (sortq, selDate, nx, ny) => {
        const apiKey = process.env.REACT_APP_API_KEY;
        let url = 'https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/';
        url = `${url}${sortq == "초단기예보" ? "getUltraSrtFcst" : "getVilageFcst"}?`
        url = `${url}serviceKey=${apiKey}&pageNo=1&numOfRows=1000&dataType=JSON&`;
        url = `${url}base_date=${selDate}&base_time=0500&nx=${nx}&ny=${ny}`;

        console.log(url);

        const resp = await fetch(url);
        const data = await (resp.json());
        console.log("data 입니다"); console.log(data.response.body.items.item);
        setTdt(data.response.body.items.item);
    }

    const setTableData = () => {
        let tm = selRef.current.value.split(',');
        const code = tm[1];
        const codeTxt = tm[0];
        //console.log("code");     console.log(code);
        //console.log("txt");     console.log(codeTxt);

        const selected = tdata.filter(i => i['category'] == code);
        console.log("selected"); console.log(selected);
        const tags = selected.map(i => <tr className="bg-white border-b">
            <th scope="row" className="px-6 py-4 font-normal whitespace-nowrap ">
                {codeTxt}
            </th>
            <td className="px-6 py-4">
                {i['fcstTime']}
            </td>
            <td className="px-6 py-4">
                {i['fcstValue']}
            </td>
        </tr>);
        setTrs(tags);

    }


    return (
        <div className="w-10/12">
            <div className=" flex justify-between px-10 my-10">
                <h1 className="text-2xl font-bold"> {sortq} : {area} ({selDate})   </h1>
                <select name="sele" onChange={setTableData} ref={selRef}
                    className="form-select w-1/3">
                    <option defaultValue='noRegion' hidden >
                        선택
                    </option>
                    {options}
                </select>
            </div>


            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                <table className="w-full text-sm text-left rtl:text-right text-gray-500">

                    <thead className="text-xs text-gray-700 uppercase bg-gray-50  ">
                        <tr>
                            <th scope="col" className="px-6 py-3">
                                항목명
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
