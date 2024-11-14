import { useLocation, useSearchParams } from "react-router-dom";

export default function RoutePage2() {
    const loc = useLocation();
    console.log(loc);
    console.log(loc.pathname);
    console.log(loc.search);

    const [sparams] = useSearchParams();
    const qlist = [...sparams];
    console.log("sparams is " ,sparams);
    console.log("qlist is", qlist);

    return (
        <div>
            RoutePage2
            {qlist.map(i=><span key={i[0]}> {i[1]} </span>)}
        </div>
    )
}
