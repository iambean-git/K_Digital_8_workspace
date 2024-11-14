document.addEventListener('DOMContentLoaded', () => {
    const txt1 = document.querySelector('#txt1');
    const txt2 = document.querySelector('#txt2');
    const btn1 = document.querySelector('#bt1');
    const btn2 = document.querySelector('#bt2');



    //회문확인
    btn1.addEventListener('click', (e)=> {
        e.preventDefault();
        let s1 = txt1.value.replaceAll(' ',''); //공백 날리기
        let s2 = '';

        //반복문 이용
        // for(let i=s1.length-1; i>=0; i--){
        //     s2 = s2 + s1[i];
        // }

        s2 = s1.split('').reverse().join('');    //한글자씩 쪼개서 배열로 반환 후 다시 합치기
        
        if (s1==s2) txt2.value = "회문입니다";
        else txt2.value = "회문이 아닙니다";
        console.log('s1 = ',s1);
        console.log('s1 = ',s2);
    });


    //숫자합계
    btn2.addEventListener('click', (e)=>{
        let sum = 0;
        let cnt = 0;
        e.preventDefault();
        for(let c of txt1.value){
            if(c!=' ' && !isNaN(c)){
                sum += parseInt(c);
                cnt ++;
            }
        }
        
        if (cnt==0) {
            txt2.value = "숫자가 존재하지 않습니다.";
        } else        txt2.value = sum;
    });

        
    // }
});