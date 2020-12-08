<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
  <nav class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container"> <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">
        <b> I Cafe</b>
      </a> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar16">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbar16">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/aboutUs.jsp">關於我們</a> </li>
          <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/product.jsp">商品介紹</a> </li>
          <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/sale.jsp">優惠活動</a> </li>
          <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/comment/list">留言板</a> </li>
        </ul>
      </div>
    </div>
  </nav>