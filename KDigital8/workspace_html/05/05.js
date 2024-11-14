//dom 생성된 후 이벤트 감지
document.addEventListener('DOMContentLoaded', ()=>{

    const bt = document.querySelector('button');
    const img = document.querySelector('#msg>img');

    bt.addEventListener('click', ()=>{
        let n = Math.floor(Math.random()*6) + 1;
        img.setAttribute('src', `../img/${n}.png`)
        img.setAttribute('alt', `${n}`)

    })

}); 