import TailButton from "../UI/TailButton";
import { useRecoilState, useRecoilValue } from "recoil";
import { AtomN, AtomN2 } from "./AtomN";
import { useEffect } from "react";

export default function Rdiv3() {

    const [x, setX] = useRecoilState(AtomN);
    //const [y, setY] = useRecoilState(AtomN2);
    const y = useRecoilValue(AtomN2);

    const handleUp = () => {
        setX(x+1);
    }

    const handleDown = () => {
        setX(x-1);
    }

    useEffect(()=>{
        if(!localStorage.getItem('x')){
            setX(0);
        }
        else{
            setX(parseInt(localStorage.getItem('x')));
        }
    },[])

    useEffect(()=>{
        localStorage.setItem('x', x);
    },[x]);

   

    return (
        <div className="w-10/12 h-5/6 
                    flex flex-col justify-center items-center
                    bg-blue-400 text-white font-bold">
            <div className="w-full h-10 flex justify-start items-center p-5">
                RDiv3 : x={x}, y={y}
            </div>
            <div className="w-full grid grid-cols-2 gap-5 px-10 mt-5">
                <TailButton caption='증가' 
                            color='whiteViolet' 
                            handleClick={handleUp} 
                            size='' />

                <TailButton caption='감소' 
                            color='whiteViolet' 
                            handleClick={handleDown} 
                            size='' />
            </div>
        </div>
    )
}
