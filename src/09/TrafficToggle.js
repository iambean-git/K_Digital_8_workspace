import { useState } from "react";
export default function TrafficToggle({txt, color,handleClick}) {
    const colors = {
        "indigo" : "bg-indigo-600",
        "orange" : "bg-orange-600"
    }

    return (
        <div className="">
            <div className= {`${colors[color]} text-white rounded-md
                            hover:cursor-pointer
                            m-2 p-3`}
                 onClick={handleClick}>
                {txt}
            </div>
        </div>
    )
}
