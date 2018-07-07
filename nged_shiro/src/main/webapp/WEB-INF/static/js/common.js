$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded;charset=utf-8",
    complete:function(XMLHttpRequest,textStatus){
    },
    statusCode: {
        401: function() {
            alert('权限验证不通过。401');
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