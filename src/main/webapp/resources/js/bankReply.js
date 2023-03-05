const replyContents = document.getElementById('replyContents');
const replyAdd = document.getElementById('replyAdd');
const commentListResult = document.getElementById('commentListResult');
const pl = document.getElementsByClassName('page-link');

replyAdd.addEventListener('click',function(){

    let xhttp = new XMLHttpRequest();

    xhttp.open('POST','/bankBookComment/add')

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send('contents='+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNumber'));

    xhttp.addEventListener('readystatechange',function(){
        if(this.readyState==4 && this.status==200){
            if(this.responseText.trim()=='1'){
                alert('댓글이 등록 되었습니다.');
                replyContents.value="";
                getList();
            } else {
                alert('댓글 등록에 실패하였습니다.')
            }
        }
    });

});

getList();

function getList(){
    let xhttp = new XMLHttpRequest();

    xhttp.open('GET','/bankBookComment/list?bookNumber='+replyAdd.getAttribute('data-book-bookNumber'));

    xhttp.send();

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4 && this.status==200){
            commentListResult.innerHTML=this.responseText.trim();

        }
    })

}

commentListResult.addEventListener('click', function(e){
    e.preventDefault();
    console.log('CurrentTarget : '+e.currentTarget, 'Target : '+e.target);
    for(let p of pl){
        
            
        let xhttp = new XMLHttpRequest();

        xhttp.open('get', '/bankBookComment/list?page='+p.getAttribute('data-comment-page')+'&bookNumber='+replyAdd.getAttribute('data-book-bookNumber'))

        xhttp.send();

        xhttp.addEventListener('readystatechange', function(){
            if(this.readyState==4 && this.status==200){
                commentListResult.innerHTML=this.responseText.trim();
            }
        })
            
        
    };
});