import TailButton from "../UI/TailButton" ;
import { useState, useEffect, useRef } from "react";
export default function Rest() {

  const txt1Ref = useRef();
  const txt2Ref = useRef();
  const [tdata, setTdata] = useState([]);
  const [trs, setTrs] = useState([]);
  const url = 'http://localhost:3005/posts';

  useEffect(()=>{
    getFetchData();   
  },[]);

  const getFetchData = async () => {
    const resp = await fetch(url);
    const data = await (resp.json());

    console.log(data);
    setTdata(data);
  }

  useEffect(()=>{
    const trsText = tdata.map(i=>
      <tr className="bg-white text-black text-center border-b" key={i['id']}>
            <td scope="col" className="px-6 py-3 w-3/6 font-normal text-center">{i['title']}</td>
            <td scope="col" className="px-6 py-3 w-1/6 font-normal text-center">{i['author']}</td>
            <td scope="col" className="px-6 py-3 w-1/6 font-normal text-center">
              <TailButton caption = "삭제"
                  color = "blue"
                  handleClick = '' 
                  size='' /> 
              </td>
            <td scope="col" className="px-6 py-3 w-1/6 font-normal text-center">
              <TailButton caption = "편집"
                  color = "orange"
                  handleClick = '' 
                  size='' /> 
              
            </td>
          </tr>
    )
    setTrs(trsText);
  },[tdata]);
  return (
    <div className="w-full flex flex-col justify-center items-center">
      <div className="w-11/12 grid grid-cols-1 md:grid-cols-7 
                      bg-slate-100
                      text-center my-5 p-5">
        <label htmlFor="txt1" className="my-2">제목</label>
        <div className="flex col-span-3">
          <input id="txt1"
            type="text" 
            className="form-input  w-full"
            inRef={txt1Ref} />
        </div>
        <label htmlFor="txt2" className="my-2">작성자</label>
        <div className="flex">
          <input id="txt2"
            type="text"
            className="form-input w-full"
            inRef={txt2Ref} />
        </div>
        <TailButton caption = "입력"
                  color = "violet"
                  handleClick = '' 
                  size='' />  
      </div>
      <table
        className="w-11/12 text-left text-sm font-light text-surface">
        <thead
          className="border-b border-neutral-200 font-medium">
          <tr className="bg-black text-white font-bold text-center">
            <th scope="col" className="px-6 py-3 w-3/6 text-center">제목</th>
            <th scope="col" className="px-6 py-3 w-1/6 text-center">작성자</th>
            <th scope="col" className="px-6 py-3 w-1/6 text-center">삭제</th>
            <th scope="col" className="px-6 py-3 w-1/6 text-center">편집</th>
          </tr>
          
        </thead>
        <tbody>
        
          {trs}
        </tbody>
      </table>
    </div>
  )
}
