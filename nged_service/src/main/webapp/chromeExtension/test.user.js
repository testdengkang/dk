//var script = document.createElement("script");
//script.type="text/javascript";
//script.src="https://webimg.91160.com/static/v4/common/jquery-1.9.1.min.js";
//document.getElementsByTagName('head')[0].appendChild(script);
var xzurl="https://www.91160.com/dep/getschmast/uid-21/depid-384/date-2018-01-18/p-0/doc_ids-1252,1251,1253,13760,14790,200008048,200115226.html";
var kqurl="https://www.91160.com/dep/getschmast/uid-21/depid-4380/date-2018-02-01/p-0/doc_ids-9154,9156,5195,9175,9155,18008,9181,14629,200011554,200123174,200002519.html";
//y_state 0 约满 1可预约 -1过期

var count=0;
function queryData(){
    console.info("第"+count+"次查询开始...");
    $.ajax({
        type: "GET",
        url: kqurl,

        success: function(result) {
            if (result != "") {

                var data = eval('(' + result + ')');
                if (data != null) {
                    var sch = data.sch;
                    var doctor = data.doc;
                    var doctorId = data.doc_ids;
                    var doctorList = doctorId.split(",");
                    for (i = 0; i < doctorList.length; i++) {
                        //解析上午
                        var pam = sch[doctorList[i]].am;
                        //解析下午
                        var ppm = sch[doctorList[i]].pm
                        if (pam != null) {

                            for (j = 0; j < 7; j++) {
                                if (pam[j] != null) {
                                    var record = pam[j];
                                    if (record.y_state == 1) {
                                        console.info(record.to_date + "_" + record.time_type_desc +
                                            "_" + record.doctor_name + " 挂号费用：" + record.guahao_amt + "总共名额：" + record.yuyue_max + "_剩余：" + record.left_num + "_已预约：" + record.yuyue_num +
                                            "预约地址：" + "https://www.91160.com/guahao/ystep1/uid-" + record.unit_id + "/schid-" + record.schedule_id + ".html");
                                    }
                                }
                                if (ppm[j] != null) {
                                    var record = ppm[j];
                                    if (record.y_state == 1) {
                                        console.info(record.to_date + "_" + record.time_type_desc +
                                            "_" + record.doctor_name + " 挂号费用：" + record.guahao_amt + "总共名额：" + record.yuyue_max + "_剩余：" + record.left_num + "_已预约：" + record.yuyue_num +
                                            "预约地址：" + "https://www.91160.com/guahao/ystep1/uid-" + record.unit_id + "/schid-" + record.schedule_id + ".html");
                                    }
                                }
                            }
                        }


                    }
                }
                //console.info(data)
            }
        }
    });
    console.info("第"+count+"次查询结束...");
    count++;
}

 setInterval("queryData()", 800);


