function Hello() {
    return (
        //jsx 는 최상위 부모 코드가 무조건 하나여야함
        //fragment tag <></> (의미없는 태그 : 묶어주는 용도로만 사용)
        //class 속성은 className 으로 사용
        <>  
            <p className="p1">
                Hello React!! 
            </p>
            <p className="text-2xl text-orange-200">
                CHO EUNBIN!
            </p>
        </>
    );
}
export default Hello;