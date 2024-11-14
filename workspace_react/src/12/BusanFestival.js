import TailCard from '../UI/TailCard';
import { useEffect, useRef, useState } from 'react';
export default function BusanFestival() {

    const region = useRef();

    //전체 데이터
    const [tdata, setTdata] = useState([]);
    const [options, setOpt] = useState([]);
    const [cards, setCards] = useState([]);

    //맨처음
    useEffect(() => {
        getFetchData();        
    }, []);

    //tdata 생성 후 구이름 뽑아내기
    useEffect(() => {
        let guNames = tdata.map(i => i['GUGUN_NM']);
        guNames = [...new Set(guNames)];
        guNames.sort();
        //console.log("구 종류:", guNames);

        //뽑아진 구들로 옵션 만들기
        let opts = guNames.map(i => <option key={i} value={i}>{i}</option>);
        setOpt(opts);
        
    }, [tdata]);

    const getFetchData = async () => {
        const apiKey = process.env.REACT_APP_API_KEY;
        let url = `https://apis.data.go.kr/6260000/FestivalService/getFestivalKr?`;
        url = `${url}serviceKey=${apiKey}&pageNo=1&numOfRows=38&resultType=json`;

        //console.log(url);

        const resp = await fetch(url);
        const data = await (resp.json());

        setTdata(data.getFestivalKr.item);
    }

    const handleRegion = () => {
        //console.log("region :", region.current.value);
        let guFestival = tdata.filter(i => i['GUGUN_NM'] == region.current.value);
        //console.log(guFestival);
        let cardDatas = guFestival.map(i =>
            <TailCard
                key={i['MAIN_TITLE']}
                imgUrl={i['MAIN_IMG_THUMB']}
                title={i['TITLE']}
                content={i['TRFC_INFO']}
                hashtags={i['USAGE_DAY_WEEK_AND_TIME']}
            />
        );
        setCards(cardDatas);
    }

    return (
        <div className="w-full flex flex-col items-center justify-center pb-10">
            <h1 className=' flex m-10 items-center whitespace-nowrap
                            text-3xl font-bold text-sky-700'>
                부산축제정보
            </h1>
            <div className="w-full flex items-center justify-center">
                <select name="guSelect" id="guSelect"
                    ref={region}
                    onChange={handleRegion}
                    className="form-select w-1/2">
                    <option defaultValue='' hidden >
                        .. 지역 선택 ..
                    </option>
                    {options}
                </select>
            </div>

            <div className='grid grid-cols-1 lg:grid-cols-2 xl:grid-cols-3 gap-4 mt-10 '>
                {cards}
                {/* <TailCard imgUrl="http://tong.visitkorea.or.kr/cms2/website/72/3097272.jpg"
                    title="부산불꽃축제"
                    content="부산광역시 수영구 광안동"
                    hashtags="부산불꽃축제, 부산광역시 수영구, 광안리해수욕장, 광안대교, 불꽃놀이, 야경, 11월 추천여행지, 사진기자단, 프레임코리아1기" /> */}
            </div>
        </div>
    )
}
