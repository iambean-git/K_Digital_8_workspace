import TailButton from "../UI/TailButton";
import regionData from "./getxy.json";
import { useState, useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";

export default function Fcst() {

    const [options, setOpts] = useState([]);
    const navigate = useNavigate();

    const dtRef = useRef();
    const regionRef = useRef();

    //맨처음
    useEffect(() => {
        let regions = regionData.map(i => <option key={i["행정구역코드"]} value={i["1단계"]}>
            {i["1단계"]}</option>);
        setOpts(regions);
        const dt = getYesterday();
        dtRef.current.min = dt;
        dtRef.current.value = dt;

    }, []);

    //오늘 날짜 구하는 함수
    const getYesterday = () => {
        const yesterday = new Date();
        yesterday.setDate(yesterday.getDate());
        let dateString = '';
        dateString = dateString + yesterday.getFullYear() + "-"
            + (("0" + (yesterday.getMonth() + 1))).slice(-2) + "-"
            + ("0" + yesterday.getDate()).slice(-2)
        return dateString;
    }

    const handleBtnClick = (sortq) =>{
        let nx; let ny;
        //console.log(regionRef.current.value);
        const rg = regionRef.current.value;
        const selDate = dtRef.current.value.replaceAll("-","");
        if(rg=="지역 선택") {
            alert("지역을 선택하세요");
            regionRef.current.focus();
        }
        else{
            regionData.filter(i => {
                if (i["1단계"] == rg ){
                    nx = i["격자 X"];
                    ny = i["격자 Y"];
                }
            });
            //console.log("X: ", nx); console.log("Y: ", ny);
            //getFetchData(nx, ny);
            navigate(`/fcstlist?sortq=${sortq}&date=${selDate}&nx=${nx}&ny=${ny}&area=${rg}`)
        }
    }

    

    return (
        <div className="w-full h-screen flex flex-col justify-start items-center">
            <div className="w-10/12 text-xl font-bold my-20 ">
                일기예보 입력 정보
            </div>
            <div className="w-10/12 grid content-center grid-cols-1 lg:grid-cols-2 gap-2 place-items-center">
                <div className="w-full mb-5">
                    <input type="date" ref={dtRef} className="form-input w-full" />
                </div>
                <div className="w-full mb-5 flex justify-center items-center">
                    <select name="region" ref={regionRef}
                        className="form-select w-full">
                        <option defaultValue='noRegion' hidden >
                            지역 선택
                        </option>
                        {options}
                    </select>
                </div>
                <div className="w-10/12 mt-5">
                    <TailButton caption='초단기예보'
                        color='violet'
                        handleClick={()=>handleBtnClick('ushort')}
                        size='w-full' />
                </div>
                <div className="w-10/12 mt-5">
                    <TailButton caption='단기예보'
                        color='violet'
                        handleClick={()=>handleBtnClick('short')}
                        size='w-full' />
                </div>
            </div>

        </div>
    )
}
