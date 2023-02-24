
const d1 = document.getElementById("d1");//div
const add = document.getElementById("add");//button
const d1_1 = document.getElementById('d1_1');
const result = document.getElementById('result');

const dels = document.getElementsByClassName('dels');

let idx=0;

result.addEventListener("click", function(e){
    //console.log(e.currentTarget, e.target);
    // console.log(e.target.classList.contains('dels'));
    if(e.target.classList.contains('dels')){
        let id = 'del' + e.target.getAttribute('data-idx-num')
        console.log(id);
        document.getElementById(id).remove();
        console.log('delete', id);
        
        
    }
});

add.addEventListener('click', function(){
   
    
    let d = document.createElement('div');
    let btn = document.createElement('button');

    //button
    let n = document.createTextNode('DELETE');
    btn.appendChild(n);

    let attr = document.createAttribute('class');
    attr.value='dels';
    btn.setAttributeNode(attr);
    
    
    attr = document.createAttribute('data-idx-num');
    attr.value=idx;
    btn.setAttributeNode(attr);
    
    d.appendChild(btn);

    //id
    attr = document.createAttribute('id');
    attr.value='del'+idx
    d.setAttributeNode(attr);
    
    
    result.append(d);
    idx++
});

d1.addEventListener('click', function(){
    d1.removeChild(d1_1);
});
