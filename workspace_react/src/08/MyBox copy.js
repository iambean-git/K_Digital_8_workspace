import { useState, useEffect } from "react";

export default function MyBox() {
    const [blueFlag, setBlueFlag] = useState(false);
    const [orangeFlag, setOrangeFlag] = useState(false);

    const handleBlue = () => {
        setBlueFlag(!blueFlag);
    }

    const handleOrange = () => {
        setOrangeFlag(!orangeFlag);
    }

    useEffect(()=>{
        console.log('useEffect blue -> ', blueFlag);
    },[blueFlag]);

    return (
        <div className="flex justify-center items-center w-full h-screen">
            <div className={`w-2/6 h-3/6 m-5
                            border border-gray-300 ${blueFlag? 'bg-blue-200':''}
                            flex flex-col justify-center items-center `}>
                <h1 className="m-10 border border-gray-400 
                                bg-white px-8 py-5 
                                text-2xl text-blue-700 font-bold"> Blue </h1>
                <div className="w-1/3 h-10 flex justify-center items-center
                                border border-blue-400 bg-blue-100 hover:bg-blue-300
                                rounded-md
                                text-xs font-bold hover:cursor-pointer"
                    onClick={handleBlue}>
                    Blue Toggle
                </div>
            </div>
            <div className={`w-2/6 h-3/6 m-5
                            border border-gray-300 ${orangeFlag? 'bg-orange-200':''}
                            flex flex-col justify-center items-center`} >
                <h1 className="m-10 border border-gray-400 
                                bg-white px-8 py-5
                                text-2xl text-orange-700 font-bold"> Orange </h1>
                <div className="w-1/3 h-10 flex justify-center items-center
                                border border-orange-400 bg-orange-100 hover:bg-orange-300
                                rounded-md
                                text-xs font-bold hover:cursor-pointer"
                    onClick={handleOrange}>
                    Orange Toggle
                </div>
            </div>
        </div>
    )
}
