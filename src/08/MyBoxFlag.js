import { useState, useEffect } from "react";

export default function MyBoxFlag({color}) {
    //console.log(color);
    const [Flag, setFlag] = useState(false);

    const handleClick = () => {
        setFlag(!Flag);
    }

    useEffect(() => {
        console.log(`useEffect ${color} -> `, Flag);
    }, [Flag]);

    const colorObj = {
        'blue' :{
            'bg100' : 'bg-blue-100',
            'bg200' : 'bg-blue-200',
            'text700' : 'text-blue-700',
            'border400' : 'border-blue-400',
            'hover300' : 'hover:bg-blue-300'
        },

        'orange' :{
            'bg100' : 'bg-orange-100',
            'bg200' : 'bg-orange-200',
            'text700' : 'text-orange-700',
            'border400' : 'border-orange-400',
            'hover300' : 'hover:bg-orange-300'
        },
        
        'lime' :{
            'bg100' : 'bg-lime-100',
            'bg200' : 'bg-lime-200',
            'text700' : 'text-lime-700',
            'border400' : 'border-lime-400',
            'hover300' : 'hover:bg-lime-300'
        },
    }

    let colorSet = colorObj[color];
    
    return (
        <div className={`w-2/6 h-3/6 m-5
                            border border-gray-300 ${Flag ? colorSet['bg200'] : ''}
                            flex flex-col justify-center items-center `}>
            <h1 className={`m-10 border border-gray-400 
                                bg-white px-8 py-5 
                                text-2xl ${colorSet['text700']} font-bold`}> {color} </h1>
            <div className={`w-1/3 h-10 flex justify-center items-center
                                border ${colorSet['border400']} ${colorSet['bg100']} ${colorSet['hover300']}
                                rounded-md 
                                text-xs font-bold hover:cursor-pointer `}
                onClick={handleClick}>
                {color} Toggle
            </div>
        </div>
    )
}
