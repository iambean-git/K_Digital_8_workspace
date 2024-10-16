import './App.css';
import homeImg from'./home.png';

// import Hello from './01/Hello';
import MyClock from './02/MyClock';
// import MyDiv1 from './03/MyDiv11';
// import MyList from './04/MyList';
import Lotto from './05/Lotto';
import FoodMain from './06/FoodMain';
import BoxOffice from './07/BoxOffice';
// import MyBox from './08/MyBox';
import Traffic from './09/Traffic';
// import MyRef from './10/MyRef';
import Gallery from './11/Gallery';
import BusanFestival from './12/BusanFestival';
// import RouteMain from './13/RouteMain';
import Fcst from './14/Fcst';
import FcstList from './14/FcstList';

import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <div className="w-full xl:w-10/12 mx-auto h-screen
                      flex flex-col justify-center items-center">

        <header className='w-full h-20 flex justify-between items-center
                          bg-slate-200'> 
          
          <p className='text-sm whitespace-nowrap lg:text-2xl font-bold p-5'>
          K-digital 8기
          </p>
          <ul className='flex gap-3 text font-semibold'>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/'>시계</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/lotto'>로또</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/foodbank'>푸드뱅크</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/boxoffice'>박스오피스</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/traffic'>교통사고</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/tour'>관광정보</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/festival'>부산축제</Link></li>
            <li className='p-2 hover:bg-slate-700 hover:text-white hover:rounded-md'>
              <Link to='/fcst'>일기예보</Link></li>
          </ul>
          <a href='' className='h-3/6 pr-4'>
            <Link to='/'> <img src={homeImg} alt='homeImg' className='h-5/6' ></img> </Link>
          </a>
        </header>

        <main className='w-full grow flex flex-col items-center
                          overflow-y-auto'>
          
          {/* overflow-y-scroll : 해당 부분에서만 스크롤 움직이게 (스크롤이 항상 보임)*/}
          {/* overflow-y-auto : 평소엔 스크롤 안보이다가 화면이 넘치면 스크롤 나타나게 */}
          {/* <MyDiv1/> */}
          {/* <MyClock/> */}
          {/* <MyList /> */}
          {/* <Lotto /> */}
          {/* <FoodMain/> */}
          {/* <BoxOffice /> */}
          {/* <MyBox /> */}
          {/* <Traffic /> */}
          {/* <MyRef /> */}
          {/* <Gallery /> */}
          {/* <BusanFestival /> */}
          {/* <RouteMain /> */}
          <Routes>
            {/* <Route path='/' element={<App/>} /> */}
            <Route path='/' element={<MyClock/>} />
            <Route path='/lotto' element={<Lotto/>} />
            <Route path='/foodbank' element={<FoodMain/>} />
            <Route path='/boxoffice' element={<BoxOffice/>} />
            <Route path='/traffic' element={<Traffic/>} />
            <Route path='/tour' element={<Gallery/>} />
            <Route path='/festival' element={<BusanFestival/>} />
            <Route path='/fcst' element={<Fcst/>} />
            <Route path='/fcstlist' element={<FcstList/>} />
          </Routes>
          
        </main>
        
        <footer className='w-full h-20 flex justify-center items-center flex-shrink-0
                          bg-gray-800 text-white'>
          <p>K-digital 8기 조은빈</p>       
        </footer>
      </div>
    
    </BrowserRouter>
    
  );
}

export default App;
