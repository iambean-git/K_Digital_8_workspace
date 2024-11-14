import TailButton from "../UI/TailButton" ;
import { useState, useEffect, useRef } from "react";
export default function Rest() {

  const txt1Ref = useRef();
  const txt2Ref = useRef();
  const [tdata, setTdata] = useState([]);
  const [trs, setTrs] = useState([]);

  const [isUpdate, setIsUpdate] = useState(false);  //수정 모드 확인하기
  const [putId, setPutId] = useState();             //수정할 때 id를 저장하는 변수

  

  const url = 'http://localhost:3005/posts';
  const idNum = 0;
  useEffect(()=>{
    getFetchData();   
  },[]);

  const getFetchData = async () => {
    const resp = await fetch(url);
    const data = await (resp.json());

    //console.log(data);
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
                  handleClick = {()=>jsonDelete(i['id'])} 
                  size='' /> 
              </td>
            <td scope="col" className="px-6 py-3 w-1/6 font-normal text-center">
              <TailButton caption = "편집"
                  color = "orange"
                  handleClick = {()=>jsonUpdate(i)} 
                  size='' /> 
            </td>
          </tr>
    )
    setTrs(trsText);

        
  },[tdata]);

  const jsonPost = async() =>{

    //입력공백확인
    if(!txt1Ref.current.value){
      alert("제목를 입력하세요.");
      txt1Ref.current.focus();
      return;
    }
    
    if(txt2Ref.current.value === ''){
      alert("작성자를 입력하세요.");
      txt2Ref.current.focus();
      return;
    }

    const postData = {
      title : txt1Ref.current.value,
      author : txt2Ref.current.value
    }

    const resp = await fetch(url, {
      method : 'POST',
      headers : {'Content-Type' : 'application/json'},
      body : JSON.stringify(postData)
    });

    const data = await resp.json();
    console.log(data);

    setTdata([data, ...tdata]);
    txt1Ref.current.value = '';
    txt1Ref.current.focus();
    txt2Ref.current.value = '';
    
  }

  //게시글 삭제
  const jsonDelete = async(id) =>{

    const resp = await fetch(`${url}/${id}`,{
      method : 'DELETE'
    });
    
    //console.log("삭제된 데이터는 : ", await resp.json());

    setTdata(tdata.filter(i=>i.id !== id));
  }

  //게시글 수정
  const jsonUpdate = async(item) => {
    setIsUpdate(true);

    //console.log('수정하기 : ', item);
    txt1Ref.current.value = item.title;
    txt2Ref.current.value = item.author;
    setPutId(item.id);
  }

  //게시글 수정
  const jsonPut = async() => {
    //console.log("수정하기 : handlePut >> ", putId);

    //입력공백확인
    if(!txt1Ref.current.value){
      alert("제목를 입력하세요.");
      txt1Ref.current.focus();
      return;
    }
    
    if(txt2Ref.current.value === ''){
      alert("작성자를 입력하세요.");
      txt2Ref.current.focus();
      return;
    }

    const putData = {
      title : txt1Ref.current.value,
      author : txt2Ref.current.value
    }

    const resp = await fetch(`${url}/${putId}`, {
      method : 'PUT',
      headers : {'Content-Type' : 'application/json'},
      body : JSON.stringify(putData)
    });

    const data = await resp.json();
    console.log(data);

    const tm = tdata.map(item=>item.id === putId ? data : item);


    setTdata(tm);
    txt1Ref.current.value = '';
    txt1Ref.current.focus();
    txt2Ref.current.value = '';

    setIsUpdate(false);
  }

  //입력과 수정 구분하기
  const handleOkBtn = () => {
    if(!isUpdate)
      jsonPost();
    else
      jsonPut();      
  }

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
            ref={txt1Ref} />
        </div>
        <label htmlFor="txt2" className="my-2">작성자</label>
        <div className="flex">
          <input id="txt2"
            type="text"
            className="form-input w-full"
            ref={txt2Ref} />
        </div>
        <TailButton caption = {isUpdate? '수정' : '입력'}
                  color = "violet"
                  handleClick = {handleOkBtn} 
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
