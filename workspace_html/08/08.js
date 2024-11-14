const checkAns = (ansN) => {
    if (btn.value == "숫자를 다시 생성합니다"){
        location.reload();
    }   
}

document.addEventListener('DOMContentLoaded', () => {
    const btn = document.querySelector('#btn');
    const img = document.querySelector('#img');
    const num = document.querySelector('#num');

    let ansN = Math.floor(Math.random()*100) + 1;
    // num.addEventListener('keydown', (e) => {
    //     e.preventDefault;
    //     if (e.key === 'Enter') {
    //         console.log('엔터키를 눌렀습니다.');
    //         checkAns(ansN);
    //     }
    // });

    //랜덤수
    let n;
    //flag 변수
    let flag = false;

    num.focus();    //커서 위치하도록
    btn.addEventListener('click', (e)=>{
        e.preventDefault();

        if (!flag){
            n = Math.floor(Math.random()*100) + 1;
            flag = true;
        }
        checkAns(n);
    });
});