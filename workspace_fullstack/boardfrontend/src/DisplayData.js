import React, {useState, useRef} from 'react'

export default function DisplayData() {

    const[dataBoard, setDataBoard] = useState([]);
    const txt1Ref = useRef();
    const txt2Ref = useRef();
    const txt3Ref = useRef();

    const loadBoard = async() => {
        await fetch("http://10.125.121.214:8080/board")
        .then(resp=>{
            return resp.json();
        }).then(result=>{
            // console.log("result is " + result);
            setDataBoard(result);
        }).catch(err=>{
            console.error("Error fetching Board:", err);
        });
    };

    const loadData = () => {
        return (
            <table align='center'>
                <thead>
                    <tr>
                        <th>ID</th><th>title</th><th>writer</th>
                        <th>content</th><th>createDate</th>
                    </tr>
                </thead>
                <tbody>
                    {dataBoard.map(board=>(
                        <tr key={board.id}>
                            <td>{board.id}</td>
                            <td>{board.title}</td>
                            <td>{board.writer}</td>
                            <td>{board.content}</td>
                            <td>{board.createDate}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        );
    };
    const setPostData=() => {
        const postData = {
            writer : txt1Ref.current.value,
            title : txt2Ref.current.value,
            content : txt3Ref.current.value
        }

        return postData;
    }
    const postBoard = async() => {
        try {
            const resp = await fetch("http://localhost:8080/board",{
                method:'POST',
                headers:{
                    'Content-Type':'application/json',
                    'Authorization':'Bearer abcd'
                },
                body:JSON.stringify(setPostData())
            });
            if(resp.ok)     loadBoard();
            else            throw new Error("fail to post Board");
        } catch (error) {
            console.error('Error fetching Board:', error);            
        }
    };
  return (
    
    <div className='w-full flex flex-col items-center'>
        <h2 className='text-xl font-bold p-10'> Data Display</h2>
        <div className='flex flex-row items-center justify-between w-10/12'>
            <label htmlFor="txt1" className="my-2">작성자</label> 
            <div className="flex col-span-3">
                <input id="txt1"
                    type="text" 
                    className="w-full"
                    ref={txt1Ref} />
            </div>

            <label htmlFor="txt2" className="my-2">제목</label> 
            <div className="flex col-span-3">
                <input id="txt2"
                    type="text" 
                    className="form-input  w-full"
                    ref={txt2Ref} />
            </div>

            <label htmlFor="txt3" className="my-2">내용</label> 
            <div className="flex col-span-3">
                <input id="txt3"
                    type="text" 
                    className="form-input  w-full"
                    ref={txt3Ref} />
            </div>
        </div>
        
        <div>
            <button onClick={()=>loadBoard()}
                className='m-2 p-2 border-2 border-violet-400  rounded-md bg-purple-50'>
                    getBoard</button>
            <button onClick={()=>postBoard()}
                className='m-2 p-2 border-2 border-violet-400  rounded-md bg-purple-50'>postBoard</button>
            <div>{loadData()}</div>
        </div>
      
    </div>
  )
}
