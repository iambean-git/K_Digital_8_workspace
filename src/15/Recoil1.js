import Recoil2 from "./Recoil2";
import Recoil3 from "./Recoil3";
import { AtomN,AtomN2 } from "./AtomN";
import { useRecoilValue } from "recoil";  //값만 가져오는 방법

export default function Recoil1() {
  const x = 1;
  const y = 2;

  const n = useRecoilValue(AtomN);  //atom 변수 쓰는 방법 (setter가 없는 경우) - 값만 가져오는 방법
  const n2 = useRecoilValue(AtomN2);

  return (
    <div className="w-10/12 h-4/5 flex flex-col 
                    mt-10 p-5
                    bg-lime-800 text-white font-bold">
      Recoil1 (X={x}, N={n}, N2={n2})
      <div className="flex justify-center gap-1">
        <Recoil2 y2={y}/>
        <Recoil2 y2={1}/>
        <Recoil2 y2={"test"}/>
      </div>
      <Recoil3 x3={x} y3={y}/>
    </div>
  )
}
