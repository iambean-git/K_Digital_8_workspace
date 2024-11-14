import MyListData from './MyListData.json';
import MyListItem from './MyListItem';

export default function MyList() {
    //console.log(MyListData);
    
    // MyListData.map( item => console.log(item.title ));
    const tags = MyListData.map( item => <MyListItem 
                                            key = {item.title}
                                            title={item.title} 
                                            content={item.content} 
                                            img={item.imgUrl} 
                                            />);
    return (
        <div className='w-10/12 grid grid-cols-1 lg:grid-cols-2 gap-4'>
            {tags}
        </div>
  )
}
