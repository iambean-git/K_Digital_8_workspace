let obj = {
    'apple':'🍎', 
    'carrot':'🥕', 
    'banana' : '🍌',
};

//object 접근
console.log(obj['apple']);
console.log(obj.apple);

//object 순회
for(let k in obj){
    console.log(`${k} => ${obj[k]}`);
}

console.log('of사용한for문 + Object.keys')
for(let k of Object.keys(obj)){
    console.log(`${k} => ${obj[k]}`);
}

console.log('of사용한for문 + Object.values')
for(let k of Object.values(obj)){
    console.log(`${k}`);
}

console.log('of사용한for문 + Object.entries')
for(let [k,item] of Object.entries(obj)){
    console.log(`${k} => ${item}`);
}

//자료추가
obj['수박'] = '🍉'
console.log(obj);

//자료수정
obj['수박'] = '🍈';
console.log(obj);

//자료삭제
delete obj['수박'];
console.log(obj);

//object 병합
obj2 = {'orange' : '🍊'};
obj = {...obj, ...obj2};
console.log(obj);