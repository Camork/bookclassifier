<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>管理员后台</title>
    <%@include file="../common/headSources.jsp" %>
</head>

<style>
    #head_content {
        background-color: #673ab7 !important;
    }

    .nav-extended {
        background-color: #673ab7 !important;
    }
</style>
<body>

<%@include file="../common/navTop.jsp" %>
<%@include file="../common/preloader.jsp" %>

<div class="container" style="margin-left: 40%">
    <div class="row" style="margin-top: 100px">
        根据类型更新数据:
        <div class="input-field">
            <input id="xxx" type="text" style="width:15%"/>
            <label for="xxx">类型</label>
            <a class="btn waves-effect waves-light " onclick="updateBookByType()">获取数据</a>
        </div>
        <a class="btn waves-effect waves-light" onclick="updateNewBook()">首页新书刷新</a>
    </div>

    <button class="btn modal-trigger row" data-target="modalPop">图书识别录入</button>

</div>

</body>

<script>
    $(".page-title").text("管理员后台");
</script>
</html>
