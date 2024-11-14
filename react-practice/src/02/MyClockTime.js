import { useState, useEffect } from "react";

function MyClockTime() {
    const[cTime, setCTime] = useState(new Date());
    // useEffect(()=>{}, []);       //useEffect형식
    useEffect(()=>{
        const tm = setInterval(()=>{
            setCTime(new Date());
        },1000);   //1000ms 즉,1초에 한번 함수 실행

        return () => {clearInterval(tm)};   //컴포넌트가 없어질 때 클리어(setInterval 종료)됨
    }, []);

    return (
        <div className="text-2xl font-bold my-5">
        현재시각 : {cTime.toLocaleTimeString()}
        </div>
    );
}

export default MyClockTime;