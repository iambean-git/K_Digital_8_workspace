export default function MyDiv3(probs) {
    //console.log(probs);
    return (
        <div className="w-4/6 h-3/6 
                    flex flex-col justify-center items-center
                 bg-blue-200 text-white font-bold text-left">
            <div className="w-full h-10 flex justify-start items-center
                        p-5">
                {`${probs.dn1} > ${probs.dn2} > ${probs.dn3}`}
            </div>

        </div>
    )
}
