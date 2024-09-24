import TailButton from "../UI/TailButton"

export default function Lotto() {
  const handleClick1 = () => {
    console.log('handleClick1')
  };

  const handleClick2 = () => {
    console.log('handleClick2')
  };
  
  return (
    <div>
      Lotto
      <div>
        <TailButton caption={'로또번호생성'} color='orange' handleClick={handleClick1} />
        <TailButton caption={'버튼2'} color='indigo' handleClick={handleClick2}/>
      </div>
    </div>
  )
}
