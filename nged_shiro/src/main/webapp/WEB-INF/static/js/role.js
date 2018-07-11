$(document).ready( function() {

     var rt= $('#roleTable').dataTable( {
                "lengthMenu": [[5, 10, 50, -1], [5, 10, 50, "All"]],
                "pagingType":   "full_numbers" ,//分页样式
                 stateSave: true ,//保留页面上一次的状态
                 
                "ajax": '/role/queryAll',
                "columns":[
                    {"data":"id"},
                    {"data":"role"},
                    {"data":"description"}
                ],
                 "language": {
                     "lengthMenu": "每页 _MENU_ 条记录",
                     "zeroRecords": "没有找到记录",
                     "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                     "infoEmpty": "无记录",
                     "infoFiltered": "(从 _MAX_ 条记录过滤)",
                     "paginate": {
                         "first":    "首页",
                         "previous": "上页",
                         "next":     "下页",
                         "last":     "末页",
                         "jump":     "跳转"
                     },
                     "aria": {
                         "sortAscending":  ": 以升序排列此列",
                         "sortDescending": ": 以降序排列此列"
                     }
                 }
         } );
   } );




