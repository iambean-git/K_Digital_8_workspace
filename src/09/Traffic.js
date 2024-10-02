import { useEffect, useState } from "react";
import TrafficCatalog from "./TrafficCatalog";
import TrafficToggle from "./TrafficToggle";
import TrafficResult from "./TrafficResult";

export default function Traffic() {
    const [tdata, setTdata] = useState([]);
    const [catalog, setCatalog] = useState();
    const [btnSec, setBtnSec] = useState([]);
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

    //대분류 토글 클릭시 (중분류 뽑아내기)
    const cataFirstClick = (cata) => {
        let catalogSec = tdata.filter(item => item['사고유형대분류'] == cata);
        catalogSec = catalogSec.map(item => item['사고유형중분류']);
        catalogSec = [...new Set(catalogSec)];

        const toggles = catalogSec.map(item => <TrafficToggle key={item}
            txt={item}
            handleClick={() => cataSecClick(cata, item)} />
        );
        setBtnSec(toggles);
    }

    const cataSecClick = (cata1, cata2) => {
        console.log("cata1 is", cata1, " / cata2 is", cata2);
        let info = tdata.filter(item => (item['사고유형대분류'] == cata1) && (item['사고유형중분류'] == cata2));
        setSelected(info);
    }

    //맨처음 한번
    useEffect(() => {
        getFetchData();
    }, []);

    //tdata가 변경되었을 때
    useEffect(() => {
        console.log(tdata);
        let catalogFirst = tdata.map(item => item["사고유형대분류"]);
        catalogFirst = [...new Set(catalogFirst)];
        const toggles = <TrafficCatalog
            title="사고유형대분류"
            contents={catalogFirst}
        />;

        // const toggles = catalogFirst.map(item => <TrafficToggle key={item}
        //     txt={item} 
        //     handleClick={()=>cataFirstClick(item)}/>
        // );
        setCatalog(toggles);
    }, [tdata]);

    return (
        <div className="flex flex-col w-full h-screen justify-center items-center">
            {catalog}
            {/* <TrafficCatalog txt={'교통사고 대분류'} btns={btns}/>
            <TrafficCatalog txt={'교통사고 중분류'} btns={btnSec}/>
            <TrafficResult info={selected}/> */}
        </div>
    )
}
