import TailCard from '../UI/TailCard';
import TailButton from '../UI/TailButton';
import { MdTravelExplore } from "react-icons/md";
import { useState, useRef, useEffect } from 'react';

export default function Gallery() {
    const [cards, setCards] = useState([]);
    const handleCheck = () => {
        console.log("click");
        if (kword.current.value == "") {
            alert("검색어를 입력하세요");
            //console.log("입력된 키워드가 없습니다");
            kword.current.focus();
            return;
        }
        else {
            console.log("입력된 키워드 :", kword.current.value);
            const apiKey = process.env.REACT_APP_API_KEY;
            let url = `https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1?`;
            url = `${url}serviceKey=${apiKey}&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A`;
            url = `${url}&keyword=${encodeURI(kword.current.value)}&_type=json`;
            
            console.log(url);

            fetch(url)
                .then(resp => resp.json())
                .then(data => {
                    console.log(data.response.body.items.item);
                    const dataAll = data.response.body.items.item;
                    const dataCards = dataAll.map(item => 
                        //console.log(item['galTitle'])
                        <TailCard
                                key={item['galTitle']} 
                                imgUrl={item['galWebImageUrl']}
                                title={item['galTitle']}
                                content={item['galPhotographyLocation']}
                                hashtags= {item['galSearchKeyword']}
                        />
                    );
                    setCards(dataCards);

                })
                .catch(err=>console.log(err))

        }
    }

    const handleCancle = () => {
        kword.current.value="";
        kword.current.focus();
    }

    const kword = useRef();

    useEffect(() => {
        kword.current.focus();
    }, []);

    return (
        <div className='w-full flex flex-col items-center justify-center'>


            <div className='w-10/12 flex flex-col items-center justify-center'>
                <h1 className=' flex text-2xl font-bold m-10 items-center whitespace-nowrap'>
                    한국관광공사_관광사진 정보 <MdTravelExplore className='ml-2' />
                </h1>
                <div className='w-full grid grid-cols-1 lg:grid-cols-2 gap-2 px-10'>
                    <div className='flex justify-center'>
                        <input ref={kword}
                            type='text' id="kw" name='kw'
                            placeholder='키워드를 입력하세요'
                            className='w-full form-input rounded-md 
                                        autofill:bg-white
                                        border-indigo-400 border-2 text-sm '/>
                    </div>
                    <div className='flex justify-center items-center mx-3 '>
                        <TailButton caption='확인' color='indigo' handleClick={handleCheck} size='w-5/6' />
                        <TailButton caption='취소' color='indigo' handleClick={handleCancle} size='w-5/6' />
                    </div>

                </div>

            </div>

            <div className='grid grid-cols-1 lg:grid-cols-2 xl:grid-cols-3 gap-4 mt-10 '>
                {cards}
                {/* <TailCard imgUrl="http://tong.visitkorea.or.kr/cms2/website/72/3097272.jpg"
                    title="부산불꽃축제"
                    content="부산광역시 수영구 광안동"
                    hashtags="부산불꽃축제, 부산광역시 수영구, 광안리해수욕장, 광안대교, 불꽃놀이, 야경, 11월 추천여행지, 사진기자단, 프레임코리아1기" />
                <TailCard imgUrl="http://tong.visitkorea.or.kr/cms2/website/72/3097272.jpg"
                    title="부산불꽃축제"
                    content="부산광역시 수영구 광안동"
                    hashtags="부산불꽃축제, 부산광역시 수영구, 광안리해수욕장, 광안대교, 불꽃놀이, 야경, 11월 추천여행지, 사진기자단, 프레임코리아1기" />
                <TailCard imgUrl="http://tong.visitkorea.or.kr/cms2/website/72/3097272.jpg"
                    title="부산불꽃축제"
                    content="부산광역시 수영구 광안동"
                    hashtags="부산불꽃축제, 부산광역시 수영구, 광안리해수욕장, 광안대교, 불꽃놀이, 야경, 11월 추천여행지, 사진기자단, 프레임코리아1기" /> */}

            </div>
        </div>
    )
}
