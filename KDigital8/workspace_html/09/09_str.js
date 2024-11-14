//문자열 연습

let s = "Hello JS!!" ;

console.log('문자열 : ', s);
console.log('문자열길이 : ', s.length );
console.log('문자열문자변환 : ', s.toUpperCase() );
console.log("숫자 확인 : ", isNaN(s));
console.log("첫글자 : ", s.charAt(0));
console.log("첫글자 : ", s[0]);
console.log("마지막 글자 : ", s[s.length-1]);
console.log("마지막 글자 : ", s.charAt(s.length-1));
console.log("마지막 글자 : ", s.slice(-1));     //slice는 -1 사용 가능
console.log("(**중요) 문자열 분리 : ",s.split('') );    //한글자씩 분리해서 배열로 반환

//문자열 순회
for(let c of s){
    console.log(c);         //of는 값을 가짐 (글자 그 자체)
}

for(let i in s ){
    console.log(i ,"=>", s[i]); // in은 인덱스를 가짐 
}

//문자열 확인 (존재 확인)
console.log("h문자열 확인 : ", s.includes('h'));    //false
console.log("h문자열 확인 : ", s.includes('e'));    //true
console.log("JS문자열 확인 : ", s.includes('JS'));    //문자열로도 사용 가능
console.log("h문자열 확인 : ", s.indexOf('h'));     //-1 (위치를 나타내는데 글자를 포함하지 않으면 -1)
console.log("JS문자열 확인 : ", s.indexOf('JS'));    //문자열로도 사용 가능

//문자열 자르기(추출)
console.log("문자열 자르기 : ", s.slice(0,3));
console.log("문자열 자르기 : ", s.substring(3,0));  //slice는 (3,0)안됨!! substring은(3,0) 입력하면 자동으로 순서바꿔서 처리

// s = '1234';
// console.log('문자열 : ', s);        //숫자로 된 문자열일 때 false 뜸
// console.log("숫자 확인 : ", isNaN(s));
