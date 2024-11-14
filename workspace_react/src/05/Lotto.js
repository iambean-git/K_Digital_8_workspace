import TailButton from "../UI/TailButton"
import TailBall from "../UI/TailBall";
import { useState } from "react";

export default function Lotto() {
  const[tags, setTags] = useState();
  const[bonus, setBonus] = useState();
  const[plus, setPlus] = useState();

  const handleClick1 = () => {
    //console.log('handleClick1')
    let arr=[];

    //랜덤번호 7개 생성(중복 없이)
    while(arr.length<7){
      let num = Math.floor(Math.random() * 45) + 1 ; //1~45
      if( !arr.includes(num) ) arr.push(num);
    }

    //보너스번호 분리
    let bonusNum = arr.splice(6,1) ;
  
    //console.log(arr);
    arr.sort((a,b) => a - b);

    const Balls = arr.map(item => <TailBall key={item} n={item} />);
    setTags(Balls);
    const spanPlus = <span className="mx-2 text-3xl text-slate-500 font-bold"> + </span>;
    setPlus(spanPlus);
    const secBonus = bonusNum.map(item => <TailBall key='bonus' n={item} />);
    setBonus(secBonus);
    //console.log("bonus is ", bonusNum);
    
    //교수님은 + 넣는거 다른 방식으로 하셨음
    //보너스를 arr에 다시 합쳐서 7개의 숫자 배열에
    //splice 통해서 + 를 보너스 앞에 끼워넣기
  };

   
  return (
    <div className="w-full h-screen flex flex-col justify-center items-center">
      <div className="flex justify-center items-center mb-14">
        {tags}
        {plus}
        {bonus}
        
      </div>
      <div className="flex justify-center items-center mb-14">
        <TailButton caption={'로또번호생성'} color='indigo' handleClick={handleClick1} />
      </div>
    </div>
  )
}
