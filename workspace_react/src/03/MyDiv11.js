// rfc 입력 후 탭하면 기본 틀 만들어줌 (extension:es7 snippets 덕분)
import MyDiv2 from './MyDiv2';

export default function MyDiv11() {
  const d1 = 'div1';
  const d2 = 'div2';
  const d3 = 'div3';
  return (
    <div className="w-4/6 h-5/6 
                    flex flex-col justify-center items-center
                    bg-blue-800 text-white font-bold">
      <div className="w-full h-10 flex justify-start items-center p-5">
        MyDiv1
      </div>
      <MyDiv2 dn1={d1} dn2={d2} dn3={d3}/>
    </div>
  )
}
