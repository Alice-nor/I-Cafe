<%@ page import="java.io.*,java.util.*, javax.servlet.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <style>
    <%@include file="../theme.css"%>
  </style>
</head>

<body>
<%@include file="../parts/navbar.jsp"%>
  <div class="text-center py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 p-3">
          <h1 class="mb-0 text-left">留言管理</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="<%=request.getContextPath()%>/index.jsp">首頁</a> </li>
            <li class="breadcrumb-item active">留言管理</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a href="<%=request.getContextPath()%>/comment/backend-list" class="btn btn-sm btn-primary my-3">回列表</a>
           
           <form action="update" method="post" class="justify-content-center">
            <h2 class="my-2">編輯留言</h2>
            <input type="hidden" name="c_id" value="<c:out value='${comment.c_id}' />" />
            <div class="form-group"> <label>顧客名稱</label> <input type="text" class="form-control" name="name" placeholder="輸入管理者名稱" value="<c:out value='${comment.name}' />"> </div>
            <div class="form-group"> <label>顧客E-mail</label> <input type="text" class="form-control" name="email" placeholder="輸入管理者名稱" value="<c:out value='${comment.email}' />"> </div>
            <div class="form-group"> <label>留言內容</label> <textarea rows="5" class="form-control" name="comment" placeholder="輸入回覆內容"> <c:out value="${comment.comment}"/> </textarea> </div>
            <div class="form-group"> <label>留言時間</label> <input type="text" class="form-control" name="published_at" placeholder="輸入管理者名稱" value="<c:out value='${comment.published_at}' />"> </div>
            
            <c:if test="${comment.m_name == null}">
            <h2 class="my-2">新增留言回覆</h2>
            </c:if>
            
            <c:if test="${comment.m_name != null}">
            <h2 class="my-2">修改留言回覆</h2>
            </c:if>
            
            <div class="form-group"> <label>管理者姓名</label> <input type="text" class="form-control" name="m_name" placeholder="輸入管理者姓名" value="<c:out value='${comment.m_name}' />"> </div>
            <div class="form-group"> <label>管理者回覆內容</label> <textarea rows="5" class="form-control" name="replyComment" placeholder="輸入管理者回覆內容"> <c:out value="${comment.replyComment}"/> </textarea> </div>
            <input type="hidden" class="form-control" name="ry_published_at" value="<c:out value='${comment.ry_published_at}'/>">

            <div class="col-md-12 d-flex justify-content-end"></div>
            <button type="submit" class="btn btn-primary d-inline-flex">確定送出</button>
            </form>
        </div>
      </div>
    </div>
  </div>
  <div class="py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-center">
          <p class="mb-0">© 2014-2018 MacroViz. All rights reserved</p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>