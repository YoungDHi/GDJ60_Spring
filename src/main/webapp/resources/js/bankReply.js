const replyContents = document.getElementById('replyContents');
const replyAdd = document.getElementById('replyAdd');
const commentListResult = document.getElementById('commentListResult');

const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal')



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
                getList(1);
            } else {
                alert('댓글 등록에 실패하였습니다.')
            }
        }
    });

});

getList(1);

function getList(page){

    let count=0;

    let xhttp = new XMLHttpRequest();

    xhttp.open('GET','/bankBookComment/list?bookNumber='+replyAdd.getAttribute('data-book-bookNumber')+'&page='+page);

    xhttp.send();

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4 && this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
            count++
        }
    })

    //0이 출력 : 비동기 방식이기 때문
    console.log('Count : '+count);

}

//page
commentListResult.addEventListener('click', function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains('page-link')){
        let page = pageLink.getAttribute('data-comment-page');
        getList(page);
    }
    e.preventDefault();
    
    // for(let p of pl){
        
            
    //     let xhttp = new XMLHttpRequest();

    //     xhttp.open('get', '/bankBookComment/list?page='+p.getAttribute('data-comment-page')+'&bookNumber='+replyAdd.getAttribute('data-book-bookNumber'))

    //     xhttp.send();

    //     xhttp.addEventListener('readystatechange', function(){
    //         if(this.readyState==4 && this.status==200){
    //             commentListResult.innerHTML=this.responseText.trim();
    //         }
    //     })
            
        
    // };
});

//delete
commentListResult.addEventListener('click', function(e){
    let del = e.target;
    if(del.classList.contains('del')){
        console.log('delete')
        let xhttp = new XMLHttpRequest();
        xhttp.open('POST','../bankBookComment/delete');
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send('num='+del.getAttribute('data-comment-num'))
        xhttp.addEventListener('readystatechange', function(){
            if(this.readyState==4 && this.status==200){
                let result=this.responseText.trim();
                console.log('first check')
                if(result>=1){
                    console.log('last')
                    alert('댓글이 삭제되었습니다.');
                    getList(1);
                } else {
                    alert('삭제 실패');
                }
            }
        })
    }
    e.preventDefault();
});

//update를 누르면 textarea가 뜨는 방식
commentListResult.addEventListener('click', function(e){
    let upd = e.target;
                       
    if(upd.classList.contains('update')){

        
        let num = upd.getAttribute('data-comment-num');
        let contents = document.getElementById('contents'+num);//td
        console.log('contents : '+contents, 'num : '+num);
        let contentsTextarea = document.getElementById('contents');//modal textarea
        contentsTextarea.value=contents.innerText;      
        contentsConfirm.setAttribute('data-comment-num', num);
        

        

        
       



    }

    e.preventDefault();
    
});


//바로 textarea가 뜨는 방식
// commentListResult.addEventListener('click', function(e){
//     let upd = e.target;
//     if(upd.classList.contains('upd')){
        
//         console.log('update');
//         let xhttp = new XMLHttpRequest();
//         xhttp.open('POST','../bankBookComment/update');
//         xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//         xhttp.send('contents='+document.getElementById('replyUpdate').value+'&num='+upd.getAttribute('data-update-num'));
//         xhttp.addEventListener('readystatechange', function(){
//             if(this.readyState==4 && this.status==200){
//                 let result=this.responseText.trim();
//                 console.log('first check')
//                 if(result>=1){
//                     console.log('last')
//                     alert('수정 완료.');
//                     getList(1);
//                 } else {
//                     alert('수정 실패');
//                 }
//             }
//         })
//     }
// });

contentsConfirm.addEventListener('click', function(){
    console.log("Update Post");
    let updateContents = document.getElementById('contents').value;
    let num = contentsConfirm.getAttribute('data-comment-num');
    console.log(num)
    
    let xhttp = new XMLHttpRequest();
        xhttp.open('POST','../bankBookComment/update');
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send('num='+num+'&contents='+updateContents)
        xhttp.addEventListener('readystatechange', function(){
            if(this.readyState==4 && this.status==200){
                let result=this.responseText.trim();
                console.log('first check')
                if(result>=1){
                    console.log('last')
                    alert('수정 성공');
                    closeModal.click();
                    getList(1);
                } else {
                    alert('수정 실패');
                }
            }
        })

})

