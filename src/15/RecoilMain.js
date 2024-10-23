import Rdiv1 from "./Rdiv1";
import { RecoilRoot } from "recoil";

export default function RecoilMain() {
    return (
        <RecoilRoot>
            <div className="w-full h-screen flex flex-col justify-center items-center">
                <Rdiv1 />
            </div>
        </RecoilRoot>
    )
}
