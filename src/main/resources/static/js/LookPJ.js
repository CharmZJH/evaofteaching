$(function () {
    $.ajax({
        async: false,
        type: "POST",
        url: "Coursefind",
        success: function (response) {

            var json = JSON.parse(response);

            var id = 1;
            var coursename;
            var teachername
            var tbody = document.getElementById("model");

            var datax = {};

            for (var key in json) {
                teachername = key;
                coursename = json[key];
                datax["CourseTeacher"] = coursename;
                datax["CourseName"] = teachername;


                var row = document.createElement('tr'); //创建行

                var idCell = document.createElement('td'); //创建列
                var coursenameCell = document.createElement('td');
                var teachernameCell = document.createElement('td');
                var performanceCell = document.createElement('td');

                idCell.innerHTML = id++ + "."; //填充数据
                coursenameCell.innerHTML = coursename;
                teachernameCell.innerHTML = teachername;

                $.ajax({
                    async: false,
                    type: "POST",
                    url: "PJfindSuccess",
                    data: datax,
                    contentType: "application/x-www-form-urlencoded;charset=utf-8",
                    success: function (response) {
                        if (response == "未完成") {
                            performanceCell.innerHTML = "<span style='color:red'>未完成</span>";
                        } else {
                            performanceCell.innerHTML = "<span style='color:green'>完成</span>";
                        }
                    }
                })
                row.appendChild(idCell); //加入行 ，下面类似
                row.appendChild(coursenameCell);
                row.appendChild(teachernameCell);
                row.appendChild(performanceCell);
                tbody.appendChild(row);
            }
            $("#km").html(--id+"门");
        },
        error: function () {
            alert("404");
        }
    })

});