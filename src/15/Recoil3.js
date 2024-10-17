import TailButton from '../UI/TailButton';
import { useState, useEffect, useRef } from 'react';
import { AtomN,AtomN2 } from './AtomN';
import { useRecoilState } from 'recoil';    //setter도 같이 설정하기 위해서 State

export default function Recoil3({ x3, y3 }) {
    const [x, setX] = useState(x3);
    const [y, setY] = useState(y3);
    const inRef = useRef();
    
    const[n, setN] = useRecoilState(AtomN);
    const[n2, setN2] = useRecoilState(AtomN2);

    const handleUp = () => {
        //x변경하려면 setX로 변경
        setX(x + 1);
        setN(n + 1);
    }
    const handleDown = () => {
        setX(x - 1);
        setN(n - 1);
    }

    useEffect(() => {
        setY(x * parseInt(inRef.current.value));
        setN2(n * parseInt(inRef.current.value));
    }, [x])

    return (
        <div className="w-full h-4/5 flex flex-col 
                    mt-10 p-5
                    bg-lime-300 text-gray-700 font-bold">
            Recoil3 (x={x}, y={y})
            <div className='grid grid-cols-1 md:grid-cols-3 gap-4 m-5'>
                <input type="number"
                    ref={inRef}
                    defaultValue={2}
                    min={2} max={5}
                    className='form-input text-black' />

                <TailButton caption='증가'
                    color='whiteViolet'
                    handleClick={handleUp}
                    size='w-10/12' />
                <TailButton caption='감소'
                    color='whiteViolet'
                    handleClick={handleDown}
                    size='w-10/12' />
            </div>
        </div>
    )
}
