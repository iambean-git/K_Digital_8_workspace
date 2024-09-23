import MyListData from './MyListData.json';
import MyListItem from './MyListItem';

export default function MyList() {
    console.log(MyListData);
    
    MyListData.map( item => console.log(item.title ));
    return (
        <div className='w-10/12 grid grid-cols-2 gap-4'>
            <MyListItem/>
            <MyListItem/>
            <MyListItem/>
            <MyListItem/>
            
        </div>
  )
}
