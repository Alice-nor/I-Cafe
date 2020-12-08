<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container"> <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">
        <b>I Cafe後台管理系統</b>
    </a> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar10">
        <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbar10">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/user/list">使用者管理</a> </li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/comment/backend-list">留言管理</a> </li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/comment/list">留言板</a> </li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">首頁</a> </li>
            </ul>
        </div>
    </div>
</nav>
