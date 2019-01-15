var teachers = [];
$(function () {
    $.ajax({
        async: false,
        type: "POST",
        url: "Coursefind",
        success: function (response) {
            var json = JSON.parse(response);
            document.getElementById("CourseName").options.length = 0;
            var first;
            var x = 0;

            for (var key in json) {
                if (x == 0) {
                    first = key;
                }
                document.getElementById("CourseName").options.add(new Option(key, key));
                teachers.push(json[key]);
                x++;
            }
            document.getElementById("CourseTeacher").value = json[first];
        },
        error: function () {
            alert("404");
        }
    })

});


$("#CourseName").change(function () {
    var checkValue = document.getElementById("CourseName").selectedIndex;

    document.getElementById("CourseTeacher").value = teachers[checkValue];

});


$("#su").click(function () {
    var same = 3;
    var flag2;
    for (var i = 1; i <= 15; i++) {
        var flag = $("input[name='no" + i + "']:checked").val();
        if (flag2 != flag) {
            same--;
        }
        flag2 = flag;
        if (flag == null) {
            alert("您还有未填项，无法提交!");
            return false;
        }
    }
    if (same == 2) {
        alert("请认真评教!");
        return false;
    }
    $.ajax({
        async: false,
        type: "POST",
        url: "Gradeinset",
        data: $("#suform").serialize(),
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        success: function (response) {
            alert(response);
        },
        error: function () {
            alert("404");
        }
    })
});

$("#su").click(function(){
    var same=3;
    var flag2;
    for(var i =1;i<= 15;i++){
        var flag = $("input[name='no"+i+"']:checked").val();
        if(flag2!=flag){
            same--;
        }
        flag2=flag;
        if(flag==null){
            alert("您还有未填项，无法提交!");
            return false;
        }
    }
    if(same==2){
        alert("请认真评教!");
        return false;
    }
    $.ajax({
        async : false,
        type : "POST",
        url : "Gradeinset",
        data:$("#suform").serialize(),
        contentType : "application/x-www-form-urlencoded;charset=utf-8",
        success : function(response) {
            alert(response);
        },
        error : function() {
            alert("404");
        }
    })
});
