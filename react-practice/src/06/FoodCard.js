import { useState } from 'react';
import bank from './img/bank.png';
import busan from './img/busan.png';
import market from './img/market.png';

export default function FoodCard({foodItem}) {
    //console.log(foodItem);
    const sortF = foodItem["구분"];
    const name = foodItem["사업장명"];
    const operName = foodItem["운영주체명"];
    const place = foodItem["사업장 소재지"];
    const telN = foodItem["연락처(대표번호)"];

    const objImg = {
        "광역지원센터" : busan,
        "기초푸드뱅크" : bank,
        "기초푸드마켓" : market
    }
    const [isTel, setIsTel] = useState(false);

    const handleTel = () => {
        // console.log('click');
        setIsTel(!isTel);
    }

    return (
        <div className="w-full border border-gray-300 rounded-md p-2
                        flex items-center">
            {/* imgDiv */}
            <div className="w-1/5 m-2">
                {/* <img src={sortF=="광역지원센터" ? busan : sortF =="기초푸드뱅크"? bank : market} alt={sortF}></img> */}
                <img src = {objImg[sortF]} alt={sortF} />
            </div>

            {/* textDiv */}
            <div className="w-4/5 flex flex-col m-2">
                
                <div className='text-xl font-bold text-gray-600'>
                    {name}
                </div>
                <div className='font-bold text-gray-600'>
                    {operName}
                </div>
                <div className='text-xs text-gray-400 mb-2'>
                    {place}
                </div>
                <div className="w-full h-6 bg-slate-500
                                text-white text-sm p-2
                                flex justify-end items-center
                                cursor-pointer" onClick={handleTel}>
                {/* {isTel? telN : ""} */}
                { isTel && telN }
                </div>
            </div>

        </div>
    )
}


// "구분": "광역지원센터",
//     "시군구": "부산시",
//     "사업장명": "부산광역푸드뱅크",
//     "신고기준": "당연",
//     "사업장 소재지": "부산광역시 동래구 낙민로 25, 부산사회복지종합센터 302호",
//     "연락처(대표번호)": "051-791-1377",
//     "팩스번호": "051-714-3096",
//     "운영주체 분류": "1. 사회복지법인",
//     "운영주체명": "부산광역시사회복지협의회"