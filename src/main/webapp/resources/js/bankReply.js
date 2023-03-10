const replyContents = document.getElementById('replyContents');
//const replyAdd = document.getElementById('replyAdd');
const commentListResult = document.getElementById('commentListResult');

const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal')


//댓글 등록
$('#replyAdd').click(function(){

    //JS에서 사용할 가상의 Form 테그 생성
    const form = new FormData(); // <form></form>
    form.append('contents',$('#replyContents').val());//<form><input type="text" name="contents" value="dfds"></input></form>
    form.append('bookNumber', $('#replyAdd').attr('data-book-bookNumber'))// <form><input type="text" name="contents" value="dfds"><input type="text" name="bookNumber" value="dfds"></form>

    //fetch 방식
    fetch('../bankBookComment/add', {
        method:'POST',
        //headers:{'Content-type':'application/x-www-form-urlencoded'},
        body:form
    }).then((response)=> response.text())
    .then((res)=>{
        if(res.trim()==1){
            alert('댓글이 등록 되었습니다.');
            $('#replyContents').val('');
            getList(1);
        } else {
            alert('댓글 등록에 실패하였습니다.')
        }
    }).catch(()=>{
        console.log('error 발생')
    })
    

    //옛날 방식
    // let xhttp = new XMLHttpRequest();

    // xhttp.open('POST','/bankBookComment/add')

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send('contents='+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNumber'));

    // xhttp.addEventListener('readystatechange',function(){
    //     if(this.readyState==4 && this.status==200){
    //         if(this.responseText.trim()=='1'){
    //             alert('댓글이 등록 되었습니다.');
    //             replyContents.value="";
    //             getList(1);
    //         } else {
    //             alert('댓글 등록에 실패하였습니다.')
    //         }
    //     }
    // });

});

getList(1);

function getList(page){

    // let count=0;
    
    // fetch
    fetch('/bankBookComment/list?bookNumber='+$('#replyAdd').attr('data-book-bookNumber')+'&page='+page,{
        method:'GET',
    }).then((response)=>response.text())
    .then((res)=>{
        $('#commentListResult').html(res.trim());
    })

    // 옛날 방식
    // let xhttp = new XMLHttpRequest();

    // xhttp.open('GET','/bankBookComment/list?bookNumber='+replyAdd.getAttribute('data-book-bookNumber')+'&page='+page);

    // xhttp.send();

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4 && this.status==200){
    //         commentListResult.innerHTML=this.responseText.trim();
    //         count++
    //     }
    // })

    // 0이 출력 : 비동기 방식이기 때문
    // console.log('Count : '+count);

}

//page
$('#commentListResult').on('click','.page-link',function(e){
    let page = $(this).attr('data-comment-page')
    getList(page);
    e.preventDefault();
})
// commentListResult.addEventListener('click', function(e){
//     let pageLink = e.target;
//     if(pageLink.classList.contains('page-link')){
//         let page = pageLink.getAttribute('data-comment-page');
//         getList(page);
//     }
//     e.preventDefault();
    
//     // for(let p of pl){
        
            
//     //     let xhttp = new XMLHttpRequest();

//     //     xhttp.open('get', '/bankBookComment/list?page='+p.getAttribute('data-comment-page')+'&bookNumber='+replyAdd.getAttribute('data-book-bookNumber'))

//     //     xhttp.send();

//     //     xhttp.addEventListener('readystatechange', function(){
//     //         if(this.readyState==4 && this.status==200){
//     //             commentListResult.innerHTML=this.responseText.trim();
//     //         }
//     //     })
            
        
//     // };
// });

//delete
$('#commentListResult').on('click','.del',function(e){
    fetch('../bankBookComment/delete', {
        method:'POST',
        headers:{'Content-type':'application/x-www-form-urlencoded'},
        body:'num='+$(this).attr('data-comment-num')
        //응답객체에서 Data 추출
    }).then((response)=>response.text()) //then(function(response){response.text()})
    //추출한 Data 사용
    .then((res)=>{
        if(res.trim()>0){
            alert('댓글이 삭제되었습니다.');
            getList(1);
        } else {
            alert('삭제 실패');
        }
    }).catch(()=>{
        alert('삭제 실패')
    })

    e.preventDefault();

})
// commentListResult.addEventListener('click', function(e){
//     let del = e.target;
//     if(del.classList.contains('del')){

//         //fetch
//         fetch('../bankBookComment/delete', {
//             method:'POST',
//             headers:{'Content-type':'application/x-www-form-urlencoded'},
//             body:'num='+del.getAttribute('data-comment-num')
//             //응답객체에서 Data 추출
//         }).then((response)=>response.text()) //then(function(response){response.text()})
//         //추출한 Data 사용
//         .then((res)=>{
//             if(res.trim()>0){
//                 alert('댓글이 삭제되었습니다.');
//                 getList(1);
//             } else {
//                 alert('삭제 실패');
//             }
//         }).catch(()=>{
//             alert('삭제 실패')
//         })

        

//         // 옛날 방식
//         // let xhttp = new XMLHttpRequest();
//         // xhttp.open('POST','../bankBookComment/delete');
//         // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//         // xhttp.send('num='+del.getAttribute('data-comment-num'))
//         // xhttp.addEventListener('readystatechange', function(){
//         //     if(this.readyState==4 && this.status==200){
//         //         let result=this.responseText.trim();
                
//         //         if(result>=1){
                    
//         //             alert('댓글이 삭제되었습니다.');
//         //             getList(1);
//         //         } else {
//         //             alert('삭제 실패');
//         //         }
//         //     }
//         // })
//     }
//     e.preventDefault();
// });

//update를 누르면 textarea가 뜨는 방식
$('#commentListResult').on('click', '.update', function(e){
    
    let num = $(this).attr('data-comment-num');
    $('#contents').val($('#contents'+num).text().trim());
    
    $('#contentsConfirm').attr('data-comment-num', num);
    console.log($('#contentsConfirm').attr('data-comment-num'))
    

    e.preventDefault();
    
});
$('#contentsConfirm').click(function(){

    console.log("num : "+$(this).attr('data-comment-num'))
    fetch('../bankBookComment/update', {
        method:'POST',
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:'num='+$(this).attr('data-comment-num')+'&contents='+$('#contents').val()
    }).then((response)=>response.text())
    .then((res)=>{
        if(res.trim()>0){
            alert('수정 성공')
            $('#closeModal').click();
            getList(1);
        } else {
            alert('수정 실패')
        }
    }).catch(()=>{
        alert('관리자에게 문의하세요.')
    })
})


//바로 textarea가 뜨는 방식
// commentListResult.addEventListener('click', function(e){
//     let upd = e.target;
//     if(upd.classList.contains('upd')){
        
//         let xhttp = new XMLHttpRequest();
//         xhttp.open('POST','../bankBookComment/update');
//         xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//         xhttp.send('contents='+document.getElementById('replyUpdate').value+'&num='+upd.getAttribute('data-update-num'));
//         xhttp.addEventListener('readystatechange', function(){
//             if(this.readyState==4 && this.status==200){
//                 let result=this.responseText.trim();
//                 if(result>=1){
//                     alert('수정 완료.');
//                     getList(1);
//                 } else {
//                     alert('수정 실패');
//                 }
//             }
//         })
//     }
// });

