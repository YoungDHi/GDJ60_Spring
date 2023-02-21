console.log('memberAdd');
const id=document.getElementById("id");
const idResult=document.getElementById("idResult");

const pw=document.getElementById("pw");
const pwResult=document.getElementById("pwResult");

const pwCheck=document.getElementById("pwCheck");
const pwCheckResult=document.getElementById("pwCheckResult");

const userName=document.getElementById("userName");
const userNameResult=document.getElementById("userNameResult");

const phone=document.getElementById("phone");
const phoneResult=document.getElementById("phoneResult");

const email=document.getElementById("email");
const emailResult=document.getElementById("emailResult");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

// let idCheck=false;
// let pwLengthCheck=false;
// let pwNullCheck=false;
// let pwEqualCheck=false;
let checks = [false,false,false,false];

//ID 검증
id.addEventListener("blur",function(){
     if(id.value.length !=0){
        idResult.innerHTML='정상적인 ID';
        idResult.classList.add('blueResult');
        idResult.classList.remove('redResult');
        //idCheck=true;
        checks[0]=true;
        }else{
        idResult.innerHTML="ID는 필수사항입니다";
        idResult.classList.add('redResult');
        idResult.classList.remove('blueResult')
        checks[0]=false;
    }
});

//PW 검증
pw.addEventListener("keyup", function(){
    if(pw.value.length>5 && pw.value.length<13){
        pwResult.innerHTML="정상 비번"
        pwResult.classList.toggle('blueResult');
        //pwLengthCheck=true;
        checks[1]=true;
    }else{
        pwResult.innerHTML="비번은 6글자이상 13글자 이하여야합니다."
        pwResult.classList.toggle('redResult');
        checks[1]=false;
    }
});

pw.addEventListener("blur",function(){
    if(pw.value!=''){
        //pwNullCheck=true;
        checks[2]=true;
    }else{
        pwResult.innerHTML="비밀번호는 필수사항입니다";
        checks[2]=false;
   }
});

pw.addEventListener("change",function(){
    checks[3]=false;
    pwCheck.value='';
    pwCheckResult.innerHTML='동일한 비밀번호를 입력해주세요';
})

//pw Equal 검증
pwCheck.addEventListener("blur", function(){
    if(pw.value==pwCheck.value){
        pwCheckResult.innerHTML="동일한 PW"
        //pwEqualCheck=true;
        checks[3]=true;
    }else{
        pwCheckResult.innerHTML="동일한 비밀번호를 입력해주세요"
        checks[3]=false;
    }

});



//name 검증
userName.addEventListener("blur",function(){
    if(userName.value.length!=0){
        userNameResult.innerHTML='';
    }else{
        userNameResult.innerHTML="이름은 필수사항입니다";
   }
});

//전화번호 검증
phone.addEventListener("blur",function(){
    if(phone.value.length!=0){
        phoneResult.innerHTML='';
    }else{
        phoneResult.innerHTML="전화번호는 필수사항입니다";
   }
});

//email 검증
email.addEventListener("blur",function(){
    if(email.value.length!=0){
        emailResult.innerHTML='';
    }else{
        emailResult.innerHTML="Email은 필수사항입니다";
   }
});

//form 검증
btn.addEventListener("click", function(){
    //idCheck && pwLengthCheck && pwNullCheck && pwEqualCheck
    if(!checks.includes(false)){
        alert("회원가입 성공");
        //frm.submit();
    }else {
        alert("필수 사항을 입력하세요")
    }
});
