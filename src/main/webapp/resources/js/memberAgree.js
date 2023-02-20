const checkAll = document.getElementById("checkAll");
const checks = document.getElementsByClassName("checks");
const agree = document.getElementById("agree");

checkAll.addEventListener("click", function(){
    console.log(this.checked)
    for(let i=0;i<checks.length;i++){
        checks[i].checked=this.checked;
    }
})

for(let i=0;i<checks.length;i++){
    checks[i].addEventListener("click",function(){
        let result = true;
        for(let j=0;j<checks.length;j++){
            if(!checks[j].checked){
                result=checks[j].checked;
                break;
            }
        }
        checkAll.checked=result;
    })
}

agree.addEventListener("click", function(){
    if(checkAll.checked){
        //alert('모두 동의함');
        location.href="./memberAdd"
    } else{alert('모든 약관에 동의해주세요')}
})
