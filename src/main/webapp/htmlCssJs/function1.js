
const d1 = document.getElementById("d1");

//전역변수
let n = 'iu';
var old = 'iu';
// function 선언
function f1 (){
    console.log("function Test")
    console.log(n);
    var old="winter"
}

//매개변수 선언시 let, const는 생략해야함
function f2 (n1, n2){
    //지역변수
    let name='iu';
    return n1+n2;
}

//function 호출
f1();
let result =f2(1,2);
console.log(result);
console.log(name)
//console.log(n1);
console.log("Old : "+old);

let fun = function (){
    console.log('익명함수');
    return 1;
}

fun();

function f3 (f){
    console.log("f3 : ",f,1);
}

//다른곳에서도 같은 함수를 사용하고 싶을 때
//d1.addEventListener("click", callback1);
//d1.addEventListener("click", callback2);

//여기에서만 사용하는 함수
d1.addEventListener("click", function(){
    callback1();
    callback2();
});

function callback1(){
    console.log("callback1")
}

let callback2=function(){
    console.log("callback2")
}
