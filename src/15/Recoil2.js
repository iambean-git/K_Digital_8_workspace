import { AtomN } from "./AtomN";
import { useRecoilValue } from "recoil";
export default function Recoil2(props) {
    const n = useRecoilValue(AtomN);
    return (
        <div className="w-1/3 h-4/5 flex flex-col 
                    mt-10 p-5
                    bg-lime-600 text-white font-bold">
            Recoil2 ({props.y2}, n={n})
        </div>
    )
}
