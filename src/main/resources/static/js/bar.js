$("#changepassword").click(function () {
    $.ajax({
        async: false,
        type: "POST",
        url: "/updatepassword",
        data: $('#pdform').serialize(),
        success: function (response) {
            if("密码修改成功，请重新登录"==response){
                alert(response);
                window.location.href="http://localhost:8080/index";
            }else{
                alert(response);
            }
        },
        error:function () {
            alert(404)
        }
    });
})

$("#msg").click(function () {
    $.ajax({
        async: false,
        type: "GET",
        url: "/TSfind",
        success: function (response) {
            var json = JSON.parse(response);
            $("#account").val(json.Account);
            $("#name").val(json.Name);
            $("#sex").val(json.Sex);
            $("#department").val(json.Department);
            $("#year").val(json.Year);
        },
        error:function () {
            alert(404)
        }
    });
})

