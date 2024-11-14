//폭탄게임
let arr = [0,0,0,0,0,0,0,0,1];
let isShuffle = false;
let cnt = 0;

//배열섞기 함수
function shuffle(arr) {
    arr.sort(() => Math.random() - 0.5);
}

document.addEventListener('DOMContentLoaded', () => {
    btnMain = document.querySelector('button');
    boxes = document.querySelectorAll('.col');
    msg = document.querySelector('#msg');

    //버튼클릭 이벤트
    btnMain.addEventListener('click', () => {
        //isShuffle 값 확인 후 폭탄 섞기
        if(!isShuffle) {
            shuffle(arr);
            console.log(arr);
            isShuffle = true; 
            btnMain.textContent = '게 임 중 ...';
            msg.innerHTML = '';
        } else { 
            if(btnMain.innerHTML === '다시하기'){
                //박스들 초기화 (숫자로 초기화)
                for(let box of boxes){
                    box.innerHTML = `${box.getAttribute('id').slice(-1)}`;
                }
                cnt = 0;
                isShuffle = false;
                btnMain.innerHTML = '폭탄섞기';
                msg.innerHTML = ''
                msg.style.fontSize = '130%';
                msg.style.color ='black';
            }
        }
    }); 

    for(let box of boxes){
        box.addEventListener('click', () => {
            //console.log('box number is ', box.getAttribute('id').slice(-1));
            if(!isShuffle) {
                msg.innerHTML = '폭탄 섞기 버튼을 클릭해주세요';
                return;
            }
            //실패시 더이상 클릭 안되도록 하기
            if(msg.innerHTML=='실패!!!!')   return;

            //이미 이미지로 바뀌어있으면 클릭이벤트 실행X (중복 실행 방지)
            if (box.innerHTML.includes('img'))  return;

            //박스 클릭시 박스 번호 확인
            boxNum = box.getAttribute('id').slice(-1);

            //배열의 해당 번호가 0이면 하트로 바꾸기
            if(arr[boxNum-1] === 0){
                box.innerHTML = `<img src="../img/hart.png" />`;
                cnt++;
                if(cnt === 8){
                    arr.indexOf(1);
                    msg.innerHTML = '✨성공!!!!✨';
                    msg.style.fontSize = '250%';

                    console.log('성공 나머지는: ',arr.indexOf(1));
                    let left = document.querySelector(`#box${arr.indexOf(1)+1}`);
                    left.innerHTML = `<img src="../img/hart.png" />`;

                    //초기화
                    btnMain.textContent = '다시하기';                 
                } 
                
            } else if (arr[boxNum-1] === 1) {    //폭탄클릭
                box.innerHTML = `<img src="../img/boom.png" />`;
                msg.innerHTML = '💣실패!!!!💣'
                msg.style.fontSize = '250%';
                msg.style.color ='red';
                
                //초기화
                btnMain.textContent = '다시하기';
            }
        });
    }
});