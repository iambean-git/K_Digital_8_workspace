import { useState } from "react";

export default function MyListItem({title, content, img}) {
    const [n, setN] = useState(0);
    
    const heartClick = () => {
        setN(n+1);
        console.log('n is', n);
    }

    return (
        <div className='w-full 
                            border border-gray-300
                            flex justify-center items-center'>
            <div className='w-1/3 flex justify-start mb-auto items-start'>
                <img src={img} alt={title} className='w-60 p-2' />
            </div>
            <div className='w-2/3 py-2 pr-2 flex flex-col justify-between items-center '>
                <div>
                    <div className="h-7 text-xl font-bold text-blue-800">
                        {title}
                    </div>
                    <div className="h-32 text-sm">
                        {content}
                    </div>
                </div>
                <div className="flex justify-end ml-auto mr-1 ">
                    <span className="cursor-pointer" onClick={heartClick}>
                        💗 
                    </span>
                    <span className="mx-1 font-bold">좋아요 </span>
                    <span>{n}</span>
                </div>
            </div>
        </div>
    )
}
