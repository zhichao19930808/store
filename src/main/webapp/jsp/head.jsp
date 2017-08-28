<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Glory
  Date: 2017/8/28
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>head</title>
    <script>
        $(function () {
            //发送ajax异步请求
            $.get("${pageContext.request.contextPath}/jsp/Kind?ac=getKind",function (date) {
                //获取ul元素节点
                var $ul =$("#kind");
                //遍历数组
                $(date).each(function () {
                    $ul.append($("<li><a href='${pageContext.request.contextPath}/jsp/Kind?ac=getPage&id="+this.id+"&currPage=1'>"+this.name+"</a></li>"));
                })
            },"json")
        })
    </script>
</head>
<body>
<!--
    时间：2015-12-30
    描述：菜单栏
-->
<div class="container-fluid">
    <div class="col-md-4">
        <img src="${pageContext.request.contextPath}/img/logo2.png" />
    </div>
    <div class="col-md-5">
        <img src="${pageContext.request.contextPath}/img/header.png" />
    </div>
    <div class="col-md-3" style="padding-top:20px">
        <c:if test="${empty sessionScope.user }">
            <ol class="list-inline">
                <li><a href="${pageContext.request.contextPath}/jsp/user?ac=SignInUI">登录</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/user?ac=SignUpUI">注册</a></li>
            </ol>
        </c:if>
        <c:if test="${not empty sessionScope.user }">
            <ol class="list-inline">
                    ${sessionScope.user.name }:你好
                <li><a href="${pageContext.request.contextPath }/jsp/user?ac=logout">退出</a></li>
                <li><a href="${pageContext.request.contextPath }/user?method=registUI">我的订单</a></li>
                <li><a href="cart.htm">购物车</a></li>
            </ol>
        </c:if>

    </div>
</div>
<!--
    时间：2015-12-30
    描述：导航条
-->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="kind" class="nav navbar-nav">
                    <%--<c:forEach items="${requestScope.kind}" var="king">--%>
                    <%--<li><a href="#">${king.name}</a></li>--%>
                    <%--</c:forEach>--%>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>

</body>
</html>
