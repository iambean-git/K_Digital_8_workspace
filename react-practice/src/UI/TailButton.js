export default function TailButton({ caption, color, handleClick, size }) {
    const btColor = {
        'blue' : 'bg-blue-400/10 border-solid border-blue-400 border-2 text-blue-400',
        'orange' : 'bg-orange-400/10 border-solid border-orange-400 border-2 text-orange-400',
        'indigo' : 'bg-indigo-400/10 border-solid border-indigo-400 border-2 text-indigo-400',
        'violet' : 'bg-violet-400/10 border-solid border-violet-400 border-2 text-violet-400',
        'whiteViolet' : 'bg-violet-100 border-solid border-violet-400 border-2 text-violet-400',
        'filledViolet' : 'bg-violet-400 border-2 border-violet-400 text-white',
        'filledorange' : 'bg-orange-400 border-2 border-orange-400 text-white'
    }

    const btColorHover = {
        'blue' : 'hover:bg-blue-400 hover:border-2 hover:border-blue-400 hover:text-white',
        'orange' : 'hover:bg-orange-400 hover:border-2 hover:border-orange-400 hover:text-white',
        'indigo' : 'hover:bg-indigo-400 hover:border-2 hover:border-indigo-400 hover:text-white',
        'violet' : 'hover:bg-violet-400 hover:border-2 hover:border-violet-400 hover:text-white',
        'whiteViolet' : "hover:bg-violet-400 hover:border-2 hover:border-violet-400 hover:text-white",
        'filledViolet' : 'hover:bg-violet-400/10 hover:border-solid hover:border-violet-400 hover:border-2 hover:text-violet-400',
        'filledorange' : 'hover:bg-orange-100 hover:border-solid hover:border-orange-400 hover:border-2 hover:text-orange-400',
    }

    return (
        <button className={`inline-flex justify-center items-center
                        p-2 px-5 mx-1 ${size ? size : ''}
                        ${btColor[color]} ${btColorHover[color]} rounded-lg
                        transition duration-300
                        text-sm font-bold`}
                onClick={handleClick}
                        >
            {caption}
        </button>
    )
}
