$(function () {
    var CourseAndDepartment;
    var SumCount = new Array();
    var datax = {};
    var dataz = {};
    var avgdata= new Array();
    $.ajax({
        async: false,
        type: "POST",
        url: "/DataFind",
        success: function (response) {

            CourseAndDepartment = response;

            for (var x = 0; x < response.length - 1; x += 2) {
                datax["CourseName"] = response[x];
                datax["Department"] = response[x + 1];

                $.ajax({
                    async: false,
                    type: "POST",
                    data: datax,
                    url: "/FindCountSum",
                    contentType: "application/x-www-form-urlencoded;charset=utf-8",
                    success: function (Count) {
                        SumCount.push(Count);
                    },
                    error: function () {
                        alert("40404");
                    }
                })

            }
        },
        error: function () {
            alert("404");
        }
    });

    var html = "";
    for (var i = 0; i < SumCount.length; i++) {
        html += "<tr>";
        html += "<td>" + CourseAndDepartment[i] + "</td>"
        html += "<td>" + CourseAndDepartment[i + 1] + "</td>"
        html += "<td><input class='btn btn-default' type='button' value='图表数据' id=" + i + ">" + "</td>"
        html += "</tr>";
    }
    $("#model").html(html);


    /*先生成框*/
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '坐标轴刻度与标签对齐';
    option = {
        color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['Q1', 'Q2', 'Q3', 'Q4', 'Q5', 'Q6', 'Q7', 'Q8', 'Q9', 'Q10', 'Q11', 'Q12', 'Q13', 'Q14', 'Q15'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '平均数值',
                type: 'bar',
                barWidth: '60%',
                data: avgdata
            }
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }











    $("input").click(function () {
        var id = Number($(this).attr("id")) * 2;

        dataz["CourseName"] = CourseAndDepartment[id];
        dataz["Department"] = CourseAndDepartment[id + 1];

        $.ajax({
            async: false,
            type: "POST",
            data: dataz,
            url: "/Gradefind",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            success: function (avg) {
                avgdata = avg;
            },
            error: function () {
                alert("40404");
            }
        })

        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        app.title = '坐标轴刻度与标签对齐';

        option = {
            color: ['#3398DB'],
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['Q1', 'Q2', 'Q3', 'Q4', 'Q5', 'Q6', 'Q7', 'Q8', 'Q9', 'Q10', 'Q11', 'Q12', 'Q13', 'Q14', 'Q15'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '平均数值',
                    type: 'bar',
                    barWidth: '60%',
                    data: avgdata
                }
            ]
        };

        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    });


});




