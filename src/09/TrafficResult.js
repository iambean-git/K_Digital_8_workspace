import { useState, useEffect } from "react";
import TrafficResultOne from "./TrafficResultOne"

export default function TrafficResult({ info }) {
    const [tags, setTags] = useState([]);
    //console.log("selected item is", info[0]);

    const cataObj = ["사고건수", "사망자수", "중상자수", "경상자수", "부상신고자수"];

    //맨처음 한번
    useEffect(() => {}, []);

    useEffect(() => {
        let tmp = cataObj.map(i=> <TrafficResultOne key={i} txt={i} num={ !info.length? "0" : info[0][i]} />);
        setTags( info=="" ? ""  :tmp);
    }, [info]);



    return (
        <div className="w-5/6 h-14 m-6 flex">
            {tags}
        </div>
    )
}
