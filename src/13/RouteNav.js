import TailButton from '../UI/TailButton';
import { useNavigate } from 'react-router-dom';

export default function RouteNav() {
    const navigate = useNavigate();
    return (
    <div className='w-full grid grid-cols-3 gap-2 mt-10'>
            <TailButton caption='홈' color='indigo' 
                        handleClick={()=>navigate('/')} size='w-full' />
            <TailButton caption='page1' color='indigo' 
                        handleClick={()=>navigate('/p1')} size='w-full' />
            <TailButton caption='page2' color='indigo' 
                        handleClick={()=>navigate('/p2')} size='w-full' />
    </div>
  )
}
