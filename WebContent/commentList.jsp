<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <style>
  <%@ include file="css/theme.css" %>
<%--   <%@ include file="../../css/my.css" %> --%>
  </style>
  
</head>

<body>
<%@ include file="parts/front_navbar.jsp" %>
  <div class="py-3" id="frontComment" style="background-image: linear-gradient(to right, rgba(26, 33, 43, 0), rgba(26, 33, 43, 1)), url(../imgs/pic1.jpg);	background-position: top left, left center;	background-size: cover;	background-repeat: no-repeat;	background-attachment: fixed;">
    <div class="container">
      <div class="row">
        <div class="text-center mx-auto col-md-12 col-xs-12">
          <h1 class="text-white text-right">I Cafe 留言板</h1>
        </div>
      </div>
      <div>
      </div>
      <div class="row">
        <div class="col-lg-10 p-2 col-xs-12">
        </div>
        <div class="col-lg-2 p-2">
          <a class="btn btn-secondary" href="new">新 增 留 言</a>
        </div>
      </div>
      
      
      
      <c:forEach var="comment" items="${listComment}" varStatus="loop">
      <div class="row justify-content-end">
        <div class="col-lg-8 p-2 ">
          <div class="px-3 py-2 border border-warning" style="	background-image: linear-gradient(to bottom, rgba(238,232,218,1), rgba(238,232,218,1));	background-position: top left;	background-size: 100%;	background-repeat: repeat;	box-shadow: 2px 2px 10px  black;">
            <div class="cardp-1">
              <div class="d-inline-flex">
                <h3 class="my-2"><c:out value="${comment.name}"/></h3>
                <b class="text-center p-1 px-3 my-2">日期：<c:out value="${comment.published_at}"/></b>
              </div>
            </div>
            <p><c:out value="${comment.comment}"/></p>
            <c:if test="${comment.m_name != null}">
            <hr style="width:100%" class="text-danger">
            <div class="cardp-1">
              <div class="d-inline-flex">
                <h3 class="my-2 text-danger">回覆:</h3>
                <h3 class="m-2 my-2 px-1"><c:out value="${comment.m_name}"/></h3>
                <b class="text-center my-2 p-1 px-2">日期：<c:out value="${comment.ry_published_at}"/></b>
              </div>
            <p><c:out value="${comment.replyComment}"/></p>
            </div>          
           </c:if>
          </div>
        </div>
      </div>
      </c:forEach>
      
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>