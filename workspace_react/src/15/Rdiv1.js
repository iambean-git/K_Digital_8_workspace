import Rdiv2 from "./Rdiv2";
import Rdiv3 from "./Rdiv3";

import { AtomN, AtomN2 } from "./AtomN";
import { useRecoilValue } from "recoil";

export default function Rdiv1() {
    const x = useRecoilValue(AtomN);
    const y = useRecoilValue(AtomN2);
    
    return (
        <div className="w-4/6 h-5/6 
                    flex flex-col justify-center items-center
                    bg-blue-200 text-white font-bold">
            <div className="w-full h-10 flex justify-start items-center p-5">
                RDiv1 : x={x}, y={y}
            </div>
            <div className="w-full h-1/4 grid grid-cols-2 gap-3 place-items-center">
                <Rdiv2 />
                <Rdiv2 />

            </div>
            <div className="w-full h-1/2 flex justify-center mt-10">
                <Rdiv3 />
            </div>
        </div>
    )
}
