<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>用户收藏列表</title>
    <%@include file="../common/headSources.jsp" %>
</head>
<body>
<%@include file="../common/navTop.jsp" %>

<div class="container">
    <div class="row">

        <div class="col l12">
            <c:forEach items="${orders}" var="o" varStatus="vs">
                <div class="card-panel">
                    <div class="panel-heading">
                        用户:${o.userName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        生成日期：<fmt:formatDate value="${o.orderDate}" type="date"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        订单号：<a>${o.orderCode}</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>
                    <div class="panel-body">
                        <table>
                            <thead>
                            <tr>
                                <th>图片</th>
                                <th>名字</th>
                                <th>单价</th>
                                <th>数量</th>
                                <th>总价</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${o.odetails}" var="od" varStatus="odvs">
                                <tr>
                                    <td><img src="${od.bookPic}" width="50"></td>
                                    <td>${od.bookName}</td>
                                    <td>${od.orderPrice}</td>
                                    <td>${od.bookNum}</td>
                                    <td>${od.bookNum*od.orderPrice}</td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                        <table>
                            <tr>
                                <td>
                                    <a class="btn waves-effect waves-light" id="back" type="button"
                                       href="<%=request.getContextPath()%>/order/outPutExcel?id=${o.orderId}">
                                        导出列表到Excel
                                    </a>
                                </td>
                                <td class="right red-text">合计:${o.totalAmount}元</td>
                            </tr>
                        </table>

                    </div>
                </div>
            </c:forEach>
        </div>
        <c:if test="${empty orders}">
            <h4 style="text-align: center">对不起，暂无此类订单信息</h4>
        </c:if>
    </div>
</div>
</body>
</html>
<script>
    $(".page-title").text("用户收藏列表");
</script>
<style>
    #head_content {
        background-color: #34a853 !important;
    }

    .nav-extended {
        background-color: #34a853 !important;
    }
</style>