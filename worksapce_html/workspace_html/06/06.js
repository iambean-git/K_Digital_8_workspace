//dom 생성된 후 이벤트 감지
document.addEventListener('DOMContentLoaded', ()=>{

    //이미지 가져오기
    const imgs = document.querySelectorAll('.dice>img');
    
    //버튼 가져오기
    const btns = document.querySelectorAll('.btn');
        
    //결과확인 텍스트
    const msg = document.getElementById('msg');
    console.log(msg);

    for (let bt of btns){
        //console.log(bt);
        bt.addEventListener('click', ()=>{
            let comN = Math.floor(Math.random()*6) + 1;
            //console.log(bt.textContent.charAt(0));        //글 내용에서 첫글자 가져옴
            let userN = parseInt(bt.textContent.charAt(0));
            imgs[0].setAttribute('src', `../img/${comN}.png`);
            imgs[0].setAttribute('alt', `${comN}.png`);

            imgs[1].setAttribute('src', `../img/${userN}.png`);
            imgs[1].setAttribute('alt', `${userN}.png`);
            if (comN===userN) {
                msg.innerHTML = '맞았어요!';
            } else {
                msg.textContent = '틀렸어요!';            
            }
        });
    }

}); 