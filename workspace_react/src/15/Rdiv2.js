import { AtomN, AtomN2 } from "./AtomN";
import { useRecoilValue } from "recoil";

export default function Rdiv2() {
    const x = useRecoilValue(AtomN);
    const y = useRecoilValue(AtomN2);
    return (
        <div className="w-4/6 h-5/6 
                    flex flex-col justify-center items-center
                    bg-blue-500 text-white font-bold">
            <div className="w-full h-10 flex justify-start items-center p-5">
                RDiv2 : x={x}, y={y}
            </div>
        </div>
    )
}
