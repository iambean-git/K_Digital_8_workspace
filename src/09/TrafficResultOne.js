
export default function TrafficResultOne({ cata1 }) {
    return (
        <div className="w-1/5">
            <span className="text-sm mr-1"> 사고건수 </span>
            <span className="text-lg text-indigo-600 font-semibold">
                {parseInt(500).toLocaleString('ko-KR')}
            </span>
        </div>
    )
}
