import Tailbutton from '../UI/TailButton';
import { useState, useRef, useEffect } from 'react';
export default function MyRef() {

    //컴포넌트 변수
    let valC = 0;

    //State 변수
    const [valS, setValS] = useState(0);

    //Ref 변수
    const valR = useRef(0);

    const btnBClick = () => {
        valC = valC + 1;
        console.log("valC = ", valC);
        //화면의 값은 안바뀜
    }

    const btnSClick = () => {
        setValS(valS + 1);
        console.log("valS = ", valS);
    }

    const btnRClick = () => {
        valR.current += 1;
        console.log("valR = ", valR);
        //버튼을 누르면 값은 증가하지만 화면에 반영이 안됨
        //state 변수 등에 의해 화면이 변경될 때 바뀐 값을 볼 수 있음
        //매번 rendering이 필요없을 때 사용
    }

    //ref변수 (더하기)
    const x = useRef();
    const y = useRef();
    const z = useRef();

    const btnAdd = () => {
        if(x.current.value==""){
            alert('값을 입력하세요.');
            x.current.focus();
            return;
        }

        if(y.current.value==""){
            alert('값을 입력하세요.');
            y.current.focus();
            return;
        }

        z.current.value = parseInt(x.current.value) + parseInt(y.current.value);
    }

    const handleFocus = () => {
        z.current.value = '';
    }


    useEffect(()=>{
        x.current.focus();
    },[]);

    return (
        <>
            <div className='w-3/5 grid grid-cols-3 gap-5 mt-10'>
                {/* 텍스트 영역 */}
                <div className='flex justify-center items-center
                                text-xl font-bold text-blue-600'>
                    컴포넌트 변수 : {valC}
                </div>
                <div className='flex justify-center items-center
                                text-xl font-bold text-indigo-600'>
                    State 변수 : {valS}
                </div>
                <div className='flex justify-center items-center
                                text-xl font-bold text-violet-600'>
                    Ref 변수: {valR.current}
                </div>

                {/* 버튼 영역 */}
                <div className='flex justify-center items-center'>
                    <Tailbutton caption="컴포넌트 변수" color="blue" handleClick={btnBClick} />
                </div>

                <div className='flex justify-center items-center'>
                    <Tailbutton caption="State 변수" color="indigo" handleClick={btnSClick} />
                </div>

                <div className='flex justify-center items-center'>
                    <Tailbutton caption="Ref 변수" color="violet" handleClick={btnRClick} />
                </div>
            </div>

            <div className='w-3/5 grid grid-cols-5 gap-5 p-2 mt-10
                             bg-amber-50'>
                <div className='flex justify-center items-center'>
                    <input ref={x} type='number' id="txt1" name='txt1'
                            onFocus={handleFocus}
                            className='h-12 w-24 pl-2
                                 border rounded-lg border-slate-300 '  />
                </div>
                <div className='flex justify-center items-center
                                text-2xl font-bold text-center'>
                    +
                </div>
                <div className='flex justify-center items-center'>
                    <input ref={y} type='number' id="txt2" name='txt2'
                        onFocus={handleFocus}
                        className='h-12 w-24 pl-2
                                    border rounded-lg border-slate-300' />
                </div>
                <div className='flex justify-center items-center'>
                    <Tailbutton caption="=" color="orange" handleClick={btnAdd} />
                </div>
                <div className='flex justify-center items-center'>
                <input ref={z} type='number' id="txt2" name='txt2' readOnly
                        className='h-12 w-24 pl-2
                                    border rounded-lg border-slate-300' />
                </div>
            </div>
        </>
    )
}
