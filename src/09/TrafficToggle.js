import { useState } from "react";
export default function TrafficToggle({txt, color,handleClick}) {
    const colors = {
        "indigo" : "bg-indigo-600 text-white ",
        "orange" : "bg-orange-600 text-white"
    }

    return (
        <div className="">
            <div className= {`${colors[color]}  rounded-md
                            hover:cursor-pointer 
                            m-2 p-3 whitespace-nowrap `}
                 onClick={handleClick}>
                {txt}
            </div>
        </div>
    )
}
