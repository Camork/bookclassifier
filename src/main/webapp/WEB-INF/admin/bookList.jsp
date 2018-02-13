<%--
  Created by IntelliJ IDEA.
  User: camork
  Date: 10/03/2018
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.camork.core.CoreUtils" %>

<div class="bookContent" style="top: 20%;">
    <div class="row ">
        <c:forEach items="${CoreUtils.bookList}" var="b" varStatus="vs">
            <c:if test="${vs.count<=6}">
                <div class="col s6 m3 l2">
                    <div class="card">
                        <div class="card-image">
                            <img src="${b.images.get('large')}">
                            <a class="btn-floating halfway-fab waves-effect waves-light red"><i
                                    class="material-icons" onclick="addBook('${b.id}')">check</i></a>
                        </div>
                        <div class="card-content">
                            <a style="font-size: smaller">${b.title}</a>
                            <div class="divider"></div>
                            <p class="grey-text">
                                <c:if test="${b.author.size()>0}">
                                    <small>${b.author.get(0)} / ${b.publisher}</small>
                                </c:if>
                            </p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>

    <div class="row ">
        <c:forEach items="${CoreUtils.bookList}" var="b" varStatus="vs">
            <c:if test="${vs.count>6 && vs.count<=12}">
                <div class="col s6 m3 l2">
                    <div class="card">
                        <div class="card-image">
                            <img src="${b.images.get('large')}">
                            <a class="btn-floating halfway-fab waves-effect waves-light red"><i
                                    class="material-icons" onclick="addBook('${b.id}')">check</i></a>
                        </div>
                        <div class="card-content">
                            <a style="font-size: smaller">${b.title}</a>
                            <div class="divider"></div>
                            <p class="grey-text">
                                <c:if test="${b.author.size()>0}">
                                    <small>${b.author.get(0)} / ${b.publisher}</small>
                                </c:if>
                            </p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>

    <div class="row ">
        <c:forEach items="${CoreUtils.bookList}" var="b" varStatus="vs">
            <c:if test="${vs.count>12}">
                <div class="col s6 m3 l2">
                    <div class="card">
                        <div class="card-image">
                            <img src="${b.images.get('large')}">
                            <a class="btn-floating halfway-fab waves-effect waves-light red"><i
                                    class="material-icons" onclick="addBook('${b.id}')">check</i></a>
                        </div>
                        <div class="card-content">
                            <a style="font-size: smaller">${b.title}</a>
                            <div class="divider"></div>
                            <p class="grey-text">
                                <c:if test="${b.author.size()>0}">
                                    <small>${b.author.get(0)} / ${b.publisher}</small>
                                </c:if>
                            </p>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>