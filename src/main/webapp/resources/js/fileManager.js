//FileManager
// const fileAdd=document.getElementById('fileAdd');
//const fileList=document.getElementById('fileList');
const dels = document.getElementsByClassName('dels');

let count = 0;
let max=1;
let param='files';
let idx=0;
function setParam(p){
    param=p
}
function setMax(m){
    max=m;
}

function setCount(c){
    count=c;
}

$('.deleteCheck').click(function(){
    let result=confirm('파일이 영구 삭제 됩니다')
    let ch = $(this)
    if(result){
        let fileNum = $(this).val();
        $.ajax({
            type:'POST',
            url:'./boardFileDelete',
            data:{
                fileNum:fileNum
            },
            success:function(response){
                if(response.trim()>0){
                    alert('삭제되었습니다')
                    //this : ajax객체 자기 자신
                    console.log(ch)
                    ch.parent().parent().remove();
                    count--;
                } else {
                    alert('삭제 실패<br> 관리자에게 문의하세요')
                }
            },
            error:function(){

            }
        })

        //ajax DB에서 삭제
        // fetch
        // fetch('URL?p=1', {
        //     method:'GET'
        // }).then((response)=>response.text())
        // .then((res)=>{

        // })
        // get
        // $.get('URL?p=1', function(response){
        //     //
        // })
        //fetch
        // fetch("URL", {
        //     method:'Post',
        //     headers:{
        //         'content-type':'X,,,'
        //     },
        //     body:'p=1'
        // }).then((Response)=>Response.text())
        // .then((res)=>{

        // })
        // $.post('URL',{p:1}, function(res){})
    } else {
        $(this).prop('checked', false);
    }
})

$('#fileList').on('click','.dels',function(e){
    // let id = $(this).attr('data-button-idx');
    // $('#del'+id).remove();
    $(this).parent().remove();
    count--;
})

// fileList.addEventListener('click',function(e){
    
//     if(e.target.classList.contains('dels')){
//         console.log(e.target.parentNode);
//         e.target.parentNode.remove();
//         // let id = 'del' + e.target.getAttribute('data-button-idx')
//         // document.getElementById(id).remove();
//         // console.log('delete',id)
//         count--;
//     }
    

// })

$('#fileAdd').click(()=>{

    if(count>=max){
        alert('첨부파일은 최대 '+max+'까지만 가능합니다');
        return;
    }

    count++;
    let child = '<div class="mb-3" id="del'+idx+'">'
        child = child + '<input type="file" class="form-control" name="'+param+'">'
        child = child + '<button type="button" class="btn btn-outline-danger dels" data-button-idx="'+idx+'">X</button>'
        child = child + '</div>'
    $('#fileList').append(child)

    idx++;

});

// fileAdd.addEventListener('click', function(){
    
//     if(count>=max){
//         alert('첨부파일은 최대 '+max+'까지만 가능합니다');
//         return;
//     }

    

    
//     //Element, text 들을 생성
//     let div = document.createElement('div');//부모 DIV
//     //let label = document.createElement('label');//label
//     //let text = document.createTextNode('Image');
//     let inptut = document.createElement('input');//input
//     let btn = document.createElement('button');//button

//     //Element들을 조합
//     //div.appendChild(label);
//     div.appendChild(inptut);
//     div.appendChild(btn);
//     //label.appendChild(text);
//     text = document.createTextNode('X');
//     btn.appendChild(text);

//     //attribute 생성 적용
//     //div
//     let attr = document.createAttribute('class');
//     attr.value='mb-3';
//     div.setAttributeNode(attr);
    
//     attr = document.createAttribute('id')
//     attr.value = 'del'+idx;
//     div.setAttributeNode(attr);

//     //label
//     // attr = document.createAttribute('class');
//     // attr.value='form-label';
//     // label.setAttributeNode(attr);

//     // attr = document.createAttribute('for');
//     // attr.value='files';
//     // label.setAttributeNode(attr);


//     //input
//     attr = document.createAttribute('type');
//     attr.value='file';
//     inptut.setAttributeNode(attr);

//     attr = document.createAttribute('class');
//     attr.value='form-control';
//     inptut.setAttributeNode(attr);

//     attr = document.createAttribute('id');
//     attr.value='files'
//     inptut.setAttributeNode(attr);

//     attr = document.createAttribute('name');
//     attr.value='files';
//     inptut.setAttributeNode(attr);

//     //button
//     attr = document.createAttribute('type');
//     attr.value='button';
//     btn.setAttributeNode(attr);

//     attr = document.createAttribute('class');
//     attr.value = 'btn btn-outline-danger dels';
//     btn.setAttributeNode(attr);

//     attr = document.createAttribute('data-button-idx');
//     attr.value=idx;
//     btn.setAttributeNode(attr);



//     fileList.prepend(div);
//     check=true;
//     idx++;
//     count++;
    
// });




