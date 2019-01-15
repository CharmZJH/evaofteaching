$(function () {
    var CourseAndDepartment;
    var SumCount = new Array();
    var datax = {};
    var dataz = {};
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
        html += "<td>" + (i + 1) + "</td>"
        html += "<td>" + CourseAndDepartment[i] + "</td>"
        html += "<td>" + CourseAndDepartment[i + 1] + "</td>"
        html += "<td>" + SumCount[i] + "</td>"
        html += "<td><input class='btn btn-default' type='button' value='点击查看' id="+i+">"+"</td>"
        html += "</tr>";
    }
    $("#model").html(html);


    $("input").click(function(){
        var id = Number($(this).attr("id"))*2;

        dataz["CourseName"] = CourseAndDepartment[id];
        dataz["Department"] = CourseAndDepartment[id+1];

        $.ajax({
            async: false,
            type: "POST",
            data: dataz,
            url: "/Gradefind",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            success: function (avg) {
                $("#Q1").html(avg[0]);
                $("#Q2").html(avg[1]);
                $("#Q3").html(avg[2]);
                $("#Q4").html(avg[3]);
                $("#Q5").html(avg[4]);
                $("#Q6").html(avg[5]);
                $("#Q7").html(avg[6]);
                $("#Q8").html(avg[7]);
                $("#Q9").html(avg[8]);
                $("#Q10").html(avg[9]);
                $("#Q11").html(avg[10]);
                $("#Q12").html(avg[11]);
                $("#Q13").html(avg[12]);
                $("#Q14").html(avg[13]);
                $("#Q15").html(avg[14]);

            },
            error: function () {
                alert("40404");
            }
        })
    });
});



