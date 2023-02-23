const pl=document.getElementsByClassName("page-link");
const searchForm = document.getElementById('searchForm');
const page = document.getElementById('page');
//for
    // for(let i=0;i<pl.length;i++){
    //     pl[i].addEventListener('click',function(){
    //         console.log("Click");
    //     });
    // };

//for of  -- for(꺼낸타입명 변수명 : CollectType 명)
for(let p of pl){
    p.addEventListener('click',function(e){
        e.preventDefault();
        let v = p.getAttribute('data-board-page');
        page.value=v;
        searchForm.submit();
    });
};

