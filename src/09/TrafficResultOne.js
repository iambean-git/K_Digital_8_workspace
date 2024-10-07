
export default function TrafficResultOne({ txt, num }) {
    return (
        <div className="w-1/5 ">
            <span className="text-sm mr-1 whitespace-nowrap"> {txt} </span>
            <span className="text-lg text-indigo-600 font-semibold whitespace-nowrap">
                {num=="0"? "-" : parseInt(num).toLocaleString('ko-KR')}
            </span>
        </div>
    )
}
