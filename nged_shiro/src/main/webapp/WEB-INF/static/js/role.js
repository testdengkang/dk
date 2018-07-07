$(document).ready( function() {

     var rt= $('#roleTable').dataTable( {
                "lengthMenu": [[15, 25, 50, -1], [15, 25, 50, "All"]]
         } );


    roleIndex();
   } );


function roleIndex(){

    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/role/queryAll" ,//url
        data: "",
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            if (result.code == 2002) {
                if(result.data!=null&&result.data.length>0){
                    var dt = result.data;
                    var content="";
                    for(var i=0;i<dt.length;i++){
                        content+="<tr><td>"+dt[i].id+"</td>";
                        content+="<td>"+dt[i].role+"</td>";
                        content+="<td>"+dt[i].description+"</td></tr>";
                    }
                    $("#roleTable tbody").empty().append(content);
                }

            }else {
                alert(result.message);
            }

        }
    });
}


