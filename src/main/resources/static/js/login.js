$(function () {
    $("#login_button").on("click", function () {
        $.get("LoginForm", {
            username: $("#username_login").val(),
            password: $("#password_login").val()
        }, function (data) {
            if (data==="success") {
                window.location.href = "index.html";
            } else {
                alert("账号或密码错误");
                window.location.href = "login.html";
            }
        });
    });
    $("#button_register").on("click", function () {
        $.post("Register", {
            username: $("#username_register").val(),
            password: $("#password_register").val()
        }, function (data) {
            if (data==="success") {
                window.location.href = "index.html";
            } else {
                alert("该账号已存在，请重新注册");
                window.location.href = "login.html";
            }
        });
    });
});