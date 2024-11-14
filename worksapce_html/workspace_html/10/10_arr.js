let arr= [1,2,3,4,5];

console.log("arr = ", arr);
console.log("arr 개수= ", arr.length);

//배열 요소 접근
console.log("arr[0] is ", arr[0]);

//배열의 전체 요소에 접근 : 배열의 순회
console.log('for문 기본 반복')
for(let i = 0 ; i<arr.length; i++){
    console.log(`${i+1}번째 요소 : ${arr[i]}`);
}
console.log('for문 in 반복')
for(let i in arr){
    console.log(`${parseInt(i)+1}번째 요소 : ${arr[i]}`);
}
console.log('for문 of 반복')
for(let item of arr){
    console.log(`${item} : ${item % 2 ==0 ? "짝" : "홀"}`);
}

console.log('for문 arr.entries 반복')
for (let [i,item] of arr.entries()){
    console.log(`${parseInt(i)+1}번째 : ${item} : ${item % 2 ==0 ? "짝" : "홀"}`);
}

console.log('for문 forEach')
arr.forEach((item,i)=>{
    console.log(`${parseInt(i)+1}번째 : ${item} : ${item % 2 ==0 ? "짝" : "홀"}`);
});

console.log("for문으로 map 구현");
let arr2 = [];
for (let item of arr){
    arr2.push(item*2);
    
}
console.log(arr2);


arr = [4,5,2,1,3];
console.log(`${arr} => 정렬 ${arr.sort()}`);
//내림차순 정렬
console.log(`${arr} => 정렬 ${arr.sort((a,b)=>b-a)}`);

//callback 함수의 매개변수가 1개이면 ()생략가능
//callback 함수의 body에 return만 있으면 {}와 return 생략가능
console.log("map 예시");
arr2 = arr.map(item=>item*2);
console.log("arr map 결과 arr2 : ", arr2);

arr2 = arr.filter(item=>item%2==0);
console.log("arr filter 결과 arr2 : ", arr2);


//arr 지우기
// arr = [];
// arr.length=0;
// console.log("arr = ", arr);

//요소 추가 (맨뒤)
arr.push(6);
console.log("arr push = ", arr);

//요소 삭제 (맨뒤)
arr.pop();
console.log("arr pop = ", arr);

//요소 추가 (맨앞)
arr.unshift(0);
console.log("arr unshift = ", arr);

//요소 삭제 (맨앞)
arr.shift();
console.log("arr shift = ", arr);

//splice로 삭제
arr2 = arr.splice(2,1);
console.log("arr= ", arr);
console.log("arr2 splice = ", arr2);

//splice로 변경
arr.splice(2,1,'a');
console.log("arr splice(2,1,'a') = ", arr);

//splice로 추가
arr.splice(2,0,3);
console.log("arr splice (2,0,3) = ", arr);


