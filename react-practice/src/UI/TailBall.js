export default function TailBall({ n }) {
    const ballColor = {
        'b0' : 'bg-amber-400',
        'b1' : 'bg-lime-400',
        'b2' : 'bg-purple-400',
        'b3' : 'bg-rose-400',
        'b4' : 'bg-indigo-400'
    }
    return (
        <div className={`w-16 h-16 m-1
                    flex justify-center items-center
                    rounded-full
                    font-bold
                    ${ballColor['b'+ Math.floor(n/10)]}
                    text-white text-xl`}
    >
            {n}
        </div>
    )
}
