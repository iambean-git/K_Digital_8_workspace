import './App.css';
import homeImg from'./home.png';

// import Hello from './01/Hello';
//import MyClock from './02/MyClock';
// import MyDiv1 from './03/MyDiv11';
import MyList from './04/MyList';

function App() {
  return (
    <div className="w-full xl:w-10/12 mx-auto h-screen
                    flex flex-col justify-center items-center">

      <header className='w-full h-20 flex justify-between items-center
                        bg-slate-200'> 
        
        <p className='text-3xl font-bold p-5'>
        K-digital 8기
        </p>

        <a href='' className='h-3/6 pr-4'>
          <img src={homeImg} alt='homeImg' className='h-5/6' ></img>
        </a>
      </header>

      <main className='w-full grow flex flex-col justify-center items-center
                        overflow-y-auto'>
      {/* overflow-y-scroll : 해당 부분에서만 스크롤 움직이게 (스크롤이 항상 보임)*/}
      {/* overflow-y-auto : 평소엔 스크롤 안보이다가 화면이 넘치면 스크롤 나타나게 */}
        {/* <MyDiv1/> */}
        <MyList />
      </main>
      
      <footer className='w-full h-20 flex justify-center items-center
                        bg-gray-800 text-white'>
        <p>K-digital 8기 조은빈</p>       
      </footer>
    </div>
  );
}

export default App;
