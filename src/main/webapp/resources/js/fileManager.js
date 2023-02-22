//FileManager
const fileAdd=document.getElementById('fileAdd');
const fileList=document.getElementById('fileList');

let count = 0;
let max=1;
let param='pic';

function setParam(p){
    param=p
}
function setMax(m){
    max=m;
}

fileAdd.addEventListener('click', function(){
    
    if(count>=max){
        alert('첨부파일은 최대 '+max+'까지만 가능합니다');
        return;
    }

    count++;

    console.log('click')
    //Element, text 들을 생성
    let div = document.createElement('div');//부모 DIV
    let label = document.createElement('label');//label
    let text = document.createTextNode('Image');
    let inptut = document.createElement('input');//input

    //Element들을 조합
    div.appendChild(label);
    div.appendChild(inptut);
    label.appendChild(text);

    //attribute 생성 적용
    //div
    let attr = document.createAttribute('class');
    attr.value='mb-3';
    div.setAttributeNode(attr);

    //label
    attr = document.createAttribute('class');
    attr.value='form-label';
    label.setAttributeNode(attr);

    attr = document.createAttribute('for');
    attr.value='files';
    label.setAttributeNode(attr);


    //input
    attr = document.createAttribute('type');
    attr.value='file';
    inptut.setAttributeNode(attr);

    attr = document.createAttribute('class');
    attr.value='form-control';
    inptut.setAttributeNode(attr);

    attr = document.createAttribute('id');
    attr.value='files'
    inptut.setAttributeNode(attr);

    attr = document.createAttribute('name');
    attr.value='param';
    inptut.setAttributeNode(attr);

    fileList.prepend(div);
    check=true;
    
    
});