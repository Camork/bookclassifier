/**
 * Created by Camork on 2017-05-01.
 * functions
 */

$(function () {

    // $(".legitRipple").ripple({maxDiameter: "120%"});

    $('.modal').modal({
        opacity: .5, // Opacity of modal background
        in_duration: 300, // Transition in duration
        out_duration: 200, // Transition out duration
    });

    $('.close').click(function () {
        $(this).closest('.register-form').toggleClass('open');
    });

    $("#pass_again").blur(function () {
        if ($('#reg_pass').val() !== $('#pass_again').val()) {
            Materialize.toast('两次密码输入不同', 4000);
        }
    });

    $("#reg_username").blur(function () {
        $.post(getContextPath() + "/user/checkUserName", {
            userName: $("#reg_username").val()
        }, function (result) {
            if (result.available) {
                Materialize.toast('该用户名可用', 4000);
            } else {
                Materialize.toast('对不起，该用户名已被占用，请更换', 4000);
            }
        });
    });

    if (document.readyState === 'complete') {
        $('body').addClass('loaded');
    }

});

function getContextPath() {
    var webroot = document.location.href;
    webroot = webroot.substring(webroot.indexOf('//') + 2, webroot.length);
    webroot = webroot.substring(webroot.indexOf('/') + 1, webroot.length);
    webroot = webroot.substring(0, webroot.indexOf('/'));
    return "/" + webroot;
}

function delayURL(url) {
    setTimeout("top.location.href = '" + url + "'", 500);
}

function refreshURL(url) {
    $('#loaderModal').modal("open");
    $.get(url, function (result) {
        if (result.state === "ok") {
            $('#loaderModal').modal('close');
            location.reload();
        } else {
            Materialize.toast('刷新失败', 4000);
            $('#loaderModal').modal('close');
        }
    });
}

function login() {
    var userName = $("#username").val();
    var userPass = $("#password").val();
    var checked=document.getElementById("filled-box").checked;

    $.post(getContextPath() + "/user/login", {
        userName: userName,
        userPass: userPass,
        checked:checked
    }, function (result) {
        var arr = result.login;
        for (var x in arr) {
            Materialize.toast(arr[x], 4000);
            if (arr[x] === "登录成功") {
                delayURL("index");
            }
        }

    });
}

function reg() {

    var userName = $("#reg_username").val();
    var userPass = $("#reg_pass").val();
    var userPassConfirm = $("#pass_again").val();

    $.post(getContextPath() + "/user/reg",
        {
            userName: userName,
            userPass: userPass,
            userPassConfirm: userPassConfirm
        }, function (result) {
            var arr = result.reg;
            for (var x in arr) {
                Materialize.toast(arr[x], 4000);
                if (arr[x] === "注册成功") {
                    $('#close').click();
                }
            }
        }
    );
}

function updateType() {
    $('#loaderModal').modal("open");
    $.get(getContextPath() + "/admin/updateType", function (result) {
        if (result.state === "ok") {
            Materialize.toast('刷新成功', 4000);
            $('#loaderModal').modal('close');
        } else {
            Materialize.toast('刷新失败', 4000);
            $('#loaderModal').modal('close');
        }
    })
}

function updateBookByType() {
    $('#loaderModal').modal("open");
    var typeName = $('#xxx').val();
    $.post(getContextPath() + "/admin/updateBookByType",
        {
            type: typeName
        }, function (result) {
            if (result.state === "ok") {
                Materialize.toast('刷新成功', 4000);
                $('#loaderModal').modal('close');
            } else {
                Materialize.toast('刷新失败', 4000);
                $('#loaderModal').modal('close');
            }
        })
}

function updateNewBook() {
    $('#loaderModal').modal("open");
    $.get(getContextPath() + "/admin/updateNewBook", function (result) {
        if (result.state === "ok") {
            Materialize.toast('刷新成功', 4000);
            $('#loaderModal').modal('close');
        } else {
            Materialize.toast('刷新失败', 4000);
            $('#loaderModal').modal('close');
        }
    })
}

function bookApi() {

    var urlStr = $('#xxxx').val();
    $.post(getContextPath() + "/admin/bookApi",
        {
            urlStr: urlStr
        }, function (result) {
            if (result.state === "ok") {
                Materialize.toast('刷新成功', 4000);
                $('#loaderModal').modal('close');
            } else {
                Materialize.toast('刷新失败', 4000);
                $('#loaderModal').modal('close');
            }
        })

}

function getTag(typeName) {
    $('body').removeClass("loaded");
    window.location.href = getContextPath() + "/book/type/" + typeName;
}