export default function TailButton({ caption, color, handleClick }) {
    const btColor = {
        'blue' : 'bg-blue-400/10 border-solid border-blue-400 border-2 text-blue-400',
        'orange' : 'bg-orange-400/10 border-solid border-orange-400 border-2 text-orange-400',
        'indigo' : 'bg-indigo-400/10 border-solid border-indigo-400 border-2 text-indigo-400',
        'violet' : 'bg-violet-400/10 border-solid border-violet-400 border-2 text-violet-400'
    }

    const btColorHover = {
        'blue' : 'hover:bg-blue-400 hover:border-2 hover:border-blue-400 hover:text-white',
        'orange' : 'hover:bg-orange-400 hover:border-2 hover:border-orange-400 hover:text-white',
        'indigo' : 'hover:bg-indigo-400 hover:border-2 hover:border-indigo-400 hover:text-white',
        'violet' : 'hover:bg-violet-400 hover:border-2 hover:border-violet-400 hover:text-white'
    }

    return (
        <button className={`inline-flex justify-center items-center
                        p-2 px-5 mx-1 
                        ${btColor[color]} ${btColorHover[color]} rounded-lg
                        text-white text-sm font-bold`}
                onClick={handleClick}
                        >
            {caption}
        </button>
    )
}
