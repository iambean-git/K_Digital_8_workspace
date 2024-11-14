import fooddata from './fooddata.json';
import FoodCard from './FoodCard';
import { useState } from 'react';
import Tailbutton from '../UI/TailButton';

export default function FoodMain() {
    // console.log(fooddata);
    const [tags, setTags] = useState();

    let btnText = fooddata.map(item => item["운영주체 분류"]);
    btnText = [...new Set(btnText)];    //중복 제거 후 다시 리스트화(전개연산자 사용)
    //console.log(btnText);

    const btns = btnText.map(item => <Tailbutton key={item}
        caption={item}
        color="indigo"
        handleClick={() => btnClick(item)}
    />);

    const btnClick = (catalog) => {
        //console.log("btnClick", catalog);
        const tagsList = fooddata.filter(item => item['운영주체 분류'] === catalog);
        //console.log("tagsList", tagsList);

        const Foodtags = tagsList.map(item => <FoodCard
            key={item["사업장명"]}
            foodItem={item}
        />);

        // const Foodtags = tagsList.map(item => <FoodCard
        //     key={item["사업장명"]}
        //     sortF={item["구분"]}
        //     name={item["사업장명"]}
        //     operName={item["운영주체명"]}
        //     place={item["사업장 소재지"]}
        //     telN={item["연락처(대표번호)"]}
        // />);
        setTags(Foodtags);
    }

    return (
        <div className='w-10/12 flex flex-col justify-start items-center'>
            <div className='w-full h-20
                            flex justify-center items-center'>
                {btns}
            </div>

            <div className='m-2  
                        grid grid-cols-1 lg:grid-cols-2 gap-1
                        '>
                {tags}
            </div>
        </div>
    )
}
