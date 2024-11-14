import TrafficToggle from "./TrafficToggle";

export default function TrafficCatalog({ title, contents, sel, setSel}) {
    //console.log("contents is" ,contents);

    const handleTgClick = (item) => {
        setSel(item);
    }
    const toggles = contents.map(i => <TrafficToggle
                                            key={i}
                                            txt={i}
                                            color={i == sel ? 'orange' : 'indigo'}
                                            handleClick={() => handleTgClick(i)}
    />
    );
    

    return (
        <div className="flex w-5/6 h-14 justify-start items-center m-3">
            <h2 className="w-1/3 font-bold text-lg "> {title} </h2>
            <div className="w-2/3 pr-3 flex justify-end ">
                {toggles}
            </div>
        </div>
    )
}
