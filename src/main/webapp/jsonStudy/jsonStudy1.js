
$('#btn').click(()=>{
    let productId=$('#productId').val()

    $.ajax({
        type:'get',
        url:'https://dummyjson.com/products/'+productId,
        success:function(response){
            console.log(response);
            console.log(typeof response);

            response = JSON.parse(response);

        }
    })
    // $.get('https://dummyjson.com/products/'+productId, (response)=>{
    //     console.log(response);
    //     console.log(response.title);
    //     alert(response);
    //     let result = JSON.stringify(response);
    //     console.log(result);
    //     alert(result);
    //     console.log(typeof result);
    //     console.log(result.title);
        
    // })
})

$.get('https://dummyjson.com/products',function(response){
    console.log(response.products.length);
    let result='';
    for(let item of response.products){
        console.log(item)
        result = result +'<div class="card" style="width: 18rem;">';
        result = result +'<img src="'+item.thumbnail+'" class="card-img-top" alt="...">';
        result = result +'<div class="card-body">';
        result = result +'<h5 class="card-title">'+item.title+'</h5>';
        result = result +'<p class="card-text">'+item.description+'</p>'
        result = result +'<a href="#" class="btn btn-primary detail" data-product-id="'+item.id+'">'+item.price+'</a>';
        result = result +'</div></div>'
        $('#productList').append(result);
    }
    // $('#productList').html(result);
})

$('#productList').on('click','.detail',function(e){
    console.log('ID : '+$(this).attr('data-product-id'))
    let productId=$('#productId').val();
    $.get('https://dummyjson.com/products/'+productId, (response)=>{
        console.log(response);
        console.log(response.title);
    })
    e.preventDefault()
})
