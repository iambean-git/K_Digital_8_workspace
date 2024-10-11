import RouteNav from "./RouteNav";
import RouteHome from "./RouteHome";
import RoutePage1 from "./RoutePage1";
import RoutePage2 from "./RoutePage2";

import { BrowserRouter, Routes, Route } from "react-router-dom";


export default function RouteMain() {
    return (
        <BrowserRouter>
            <div className="w-10/12 flex flex-col justify-center items-center ">
                <RouteNav />
                <Routes>
                    <Route path="/" element={<RouteHome/>} />
                    <Route path="/p1" element={<RoutePage1/>} />
                    <Route path="/p1/:item/:item2" element={<RoutePage1/>} />
                    <Route path="/p2" element={<RoutePage2/>} />
                </Routes>
            </div>

        </BrowserRouter>

    )
}
