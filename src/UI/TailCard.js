export default function TailCard({imgUrl, title, content, hashtags}) {
    //console.log(hashtags);
    
    //if-else로 단어 짜르기
    // let words = []
    // if hashtags.indexOf(',') != -1{
    //     words = hashtags.split(',');
    // } else words.push(hashtags);

    //삼항연산자로 자르기
    const words = hashtags.indexOf(',') != -1 ? hashtags.split(',') : [hashtags];

    // console.log("완성된 리스트 : ", words);

    
    //태그가 없는 경우 빈 span이 출력되지 않도록 
        let tags =  words.length == 1 && words[0] == "" ? "":        
        words.map(item => 
        <span key={item}
              className="inline-flex text-xs text-gray-700 bg-gray-200 px-2 py-1 m-1 rounded-lg ">
            {item}
        </span>
    );

    return (

        <div className="max-w-sm bg-white border border-gray-200 rounded-lg shadow ">

            <img className="rounded-t-lg" 
                 src={imgUrl} 
                 alt="" />

            <div className="p-5">
                <h1 className="mb-2 text-2xl font-bold tracking-tight text-gray-900">
                    {title}
                </h1>
                
                <p className="mb-3 font-normal text-gray-700 ">
                    {content}
                </p>

                <div className="">
                    {tags}
                </div>
            </div>
        </div>

    )
}
