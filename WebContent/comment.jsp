<%@ page import="java.io.*,java.util.*, javax.servlet.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <style>
  <%@ include file="css/theme.css" %>
  </style>
</head>

<body>
<%@include file="parts/front_navbar.jsp"%>
  <div class="py-3" style="	background-image: linear-gradient(to right, rgba(26, 33, 43, 0), rgba(26, 33, 43, 1)), url(../imgs/pic1.jpg);	background-position: top left, left center;	background-size: 100%, 100%;	background-repeat: repeat, no-repeat;	background-attachment: fixed;">
    <div class="container">
      <div class="row">
        <div class="text-center mx-auto col-md-12">
          <h1 class="text-white text-right"></h1>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-10 p-2 col-xs-12">
        </div>
        <div class="col-lg-2 p-2">
          <a class="btn btn-secondary" href="list">回到列表頁</a>
        </div>
      </div>
      <div class="row justify-content-end">
        <div class="col-lg-8 p-2">
          <div class="px-3 py-2 border border-danger" style="background-image: linear-gradient(to bottom, rgba(238,232,218,1), rgba(238,232,218,1));	background-position: top left;	background-size: 100%;	background-repeat: repeat;	box-shadow: 2px 2px 10px  black;">
            <h3 class="my-2">新增留言</h3>
            
            <form action="insert" method="post" id="c_form-h" class="py-2">
              <div class="form-group row"><label for="inputmailh" class="col-3 col-form-label">姓名（必填）</label>
                <div class="col-9">
                  <input type="text" class="form-control" id="inputmailh" name="name" placeholder="您的姓名，綽號可" value="<c:out value='${comment.name}'/>"> </div>
              </div>
              <div class="form-group row"><label for="inputpasswordh" class="col-3 col-form-label">Email</label>
                <div class="col-9">
                  <input type="text" class="form-control" name="email" id="inputpasswordh" placeholder="輸入Email" value="<c:out value='${comment.email}'/>"> </div>
              </div>
              <input type="hidden" class="form-control" name="published_at" value="<c:out value='${comment.published_at}'/>">
              <div>
                <label>留言處</label>
                <textarea class="col-12 p-2" name="comment" rows="5" placeholder="請於此輸入留言內容。"> <c:out value="${comment.name}"/> </textarea>
              </div>
              <button type="submit" class="btn btn-secondary my-2">送出</button>
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>