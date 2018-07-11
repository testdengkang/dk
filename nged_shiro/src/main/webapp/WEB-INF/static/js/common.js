$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded;charset=utf-8",
    complete:function(XMLHttpRequest,textStatus){
    },
    statusCode: {
        401: function() {
            alert('权限验证不通过。401');
            window.location.href='login';
        },
        404: function() {
            alert('数据获取/输入失败，没有此服务。404');
        },
        504: function() {
            alert('数据获取/输入失败，服务器没有响应。504');
        },
        500: function() {
            alert('服务器有误。500');
        }
    }
});

$("#logoutButton").click(function(){

    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/user/logout" ,//url
        data: "",
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            window.location.href='login';

        }
    });

});