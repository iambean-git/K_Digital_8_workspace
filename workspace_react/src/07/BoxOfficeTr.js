export default function BoxOfficeTr(props) {
    //console.log("props is", props);
    const txtColors = {
        'red' : 'text-red-600',
        'blue' : 'text-blue-600',
        'black' : ''
    }

    const rankInten = parseInt(props.mvitem.rankInten);
    const txtColor = txtColors[rankInten==0? 'black' : rankInten>0? 'red' : 'blue'];
    
    return (
        <tr onClick={props.handleClick}
            className="bg-white border-b hover:bg-gray-50">
            <th scope="row" className="px-6 py-3 font-medium text-gray-900 whitespace-nowrap text-start">
                {props.mvitem.rank}
            </th>
            <td scope="row" className="px-6 py-3 whitespace-nowrap">
                {props.mvitem.movieNm}
            </td>
            <td className="px-6 py-3 text-b text-right">
                {parseInt(props.mvitem.salesAmt).toLocaleString('ko-KR')}
            </td>
            <td className="px-6 py-3 text-right">
                {parseInt(props.mvitem.audiCnt).toLocaleString('ko-KR')}
                
            </td>
            <td className={`px-6 py-3 text-center ${txtColor}`}>
                {rankInten === 0 ? '': rankInten > 0 ? '▲ ' : '▼ '}
                {rankInten === 0 ? '-' : Math.abs(rankInten)}
            </td>
        </tr>
    )
}
