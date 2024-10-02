import { useState, useEffect } from "react";
import TrafficResultOne from "./TrafficResultOne"

export default function TrafficResult({ info }) {
    const [tags, setTags] = useState([]);
    console.log("item is", info);

    const cataObj = ["사고건수", "사망자수", "중상자수", "경상자수", "부상신고자수"];

    //맨처음 한번
    useEffect(() => {
        console.log("useeffect");
    }, []);

    useEffect(() => {
        if (!info.length) return
        else {
            console.log("useeffect info", info);
            console.log("사고건수 : ", info[0]['사고건수']);
            let tmp = cataObj.map(i=> <TrafficResultOne key={i} txt={i} num={info[i]} />);
            console.log(setTags);
            setTags(tmp);
        }


    }, [info]);



    return (
        <div className="w-5/6 h-14 m-6 
                            flex">

            {tags}
        </div>
    )
}
