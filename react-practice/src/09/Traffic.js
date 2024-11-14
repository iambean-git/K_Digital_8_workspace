import { useEffect, useState } from "react";
import TrafficCatalog from "./TrafficCatalog";
import TrafficToggle from "./TrafficToggle";
import TrafficResult from "./TrafficResult";

export default function Traffic() {
    //전체 데이터
    const [tdata, setTdata] = useState([]);

    //대분류 데이터
    const [c1, setC1] = useState([]);
    const [selC1, setSelC1] = useState([]);

    //중분류 데이터(사고유형)
    const [c2, setC2] = useState([]);
    const [selC2, setSelC2] = useState([]);

    const [selected, setSelected] = useState([]);

    const getFetchData = () => {
        const apiKey = process.env.REACT_APP_API_KEY;
        let url = `https://api.odcloud.kr/api/15070282/v1/uddi:8449c5d7-8be5-4712-9093-968fc0b2d9fc?`;
        url = `${url}page=1&perPage=18&serviceKey=${apiKey}`;

        fetch(url)
            .then(resp => resp.json())
            .then(jdata => {
                //console.log(jdata.data);
                setTdata(jdata.data);
            })
            .catch(err => console.log(err))
    }

    //맨처음 한번
    useEffect(() => {
        getFetchData();
    }, []);

    //tdata가 변경되었을 때
    useEffect(() => {
        //console.log(tdata);
        let catalogFirst = tdata.map(item => item["사고유형대분류"]);
        catalogFirst = [...new Set(catalogFirst)];

        setC1(catalogFirst);
    }, [tdata]);


    //대분류 하나가 선택되었을 때
    useEffect(()=>{
        //console.log("selC1 is, ",selC1);

        let catalogSec = tdata.filter(item => item['사고유형대분류'] == selC1);
        catalogSec = catalogSec.map(item => item['사고유형']);
        catalogSec = [...new Set(catalogSec)];

        //console.log("중분류 is ", catalogSec);
        setC2(catalogSec);
        setSelC2("");
        setSelected(""); 
        

    },[selC1]);

    //중분류 하나가 선택되었을 때
    useEffect(()=>{
        //console.log("selC1 is", selC1, " / selC2 is", selC2);
        let info = tdata.filter(item => (item['사고유형대분류'] == selC1) && (item['사고유형'] == selC2));
        //console.log("info is ",[...new Set(info)]);
        setSelected(info);       

    },[selC2]);



    return (
        <div className="flex flex-col w-full h-screen justify-center items-center">
            <TrafficCatalog title={'교통사고 대분류'} contents={c1} sel={selC1} setSel ={setSelC1}/>
            <TrafficCatalog title={'교통사고 중분류'} contents={c2} sel={selC2} setSel ={setSelC2}/>
            <TrafficResult info={selected}/>
        </div>
    )
}
