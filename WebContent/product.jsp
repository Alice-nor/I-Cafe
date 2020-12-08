<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css" type="text/css">
</head>

<body>
<%@include file="parts/front_navbar.jsp"%>
  <div class="py-5 text-center text-white" style="	position: relative;	overflow: hidden;	background-image: linear-gradient(to left, rgba(35, 16, 9, 0.2), rgba(35, 16, 9, 0.8));	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
    <video autoplay="" loop="" muted="" plays-inline="" width="120%" style="position: absolute; right: 0; top: 0; min-width:100%; z-index: -100;">
      <source src="video/coffee.mp4" type="video/mp4"> </video>
    <div class="container py-5">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <h1 class="mb-4 display-3" style="text-shadow: 0px 0px 6px black;">Every cup a<br><b>masterpiece</b></h1>
          <p class="lead mb-3" style="text-shadow: 0px 0px 4px black;">I Cafe 為您提供精心挑選香醇濃郁的咖啡豆，<br>嚴選自阿拉比卡、賴比瑞亞、夏威夷、肯亞等咖啡豆，<br>提倡公平交易原則，您的每一杯咖啡，都有助於環境的永續，<br>而每一杯咖啡本身，也都是一個精緻的傑作。<br></p>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5" style="	background-image: linear-gradient(to bottom, rgba(35,16,9,1), rgba(35,16,9,1));	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
    <div class="container">
      <div class="row">
        <div class="text-center mx-auto col-md-8">
          <h1 class="mb-2 text-white"><b>多種咖啡品項 任您挑選</b></h1>
          <p class="lead text-light">每杯咖啡都為專人挑選、製作完成，數量限制，售完不補。</p>
        </div>
      </div>
      
      <div class="row">
        <div class="col-lg-6 col-md-6 p-2" style="position:relative">
          <div style="position: absolute;	left: 5%;	top: 86%;	color: #fff;	text-shadow: 0px 0px 6px black;">
            <h1>Cappuccino</h1>
          </div>
          <div class="mr-3" style="	position: absolute;	left: 30%;	top: 5%;color: #fff;	text-shadow: 0px 0px 6px black; text-align:right">倒入濃縮咖啡、淋上熱奶茶，並在卡布奇諾上撒上肉桂粉增添香氣。</div>
          <img class="img-fluid d-block" src="imgs/cappuccino.jpg">
        </div>
        <div class="col-lg-3 col-md-6 p-2" style="position:relative">
          <img class="img-fluid d-block" src="imgs/espresso.jpg">
          <div style="color: #fff;	text-shadow: 0px 0px 6px black; ">
            <h1 class="pt-3 pl-3">Espresso</h1>
            <p class="px-3 pt-2">通過迫使接近沸騰的高壓水流通過磨成細粉的咖啡製作而成。過程中伴隨著產生深紅棕色或鵝黃色的泡沫，添加糖漿、生奶油、濃縮風味、豆奶、以及香料，具濃厚香氣與口味。</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 p-2" style="position:relative">
          <img class="img-fluid d-block" src="imgs/latte.jpg">
          <div style="color: #fff;	text-shadow: 0px 0px 6px black; ">
            <h1 class="pt-3 pl-3">Latte</h1>
            <p class="px-3 pt-2">通過迫使接近沸騰的高壓水流通過磨成細粉的咖啡製作而成。過程中伴隨著產生深紅棕色或鵝黃色的泡沫，添加糖漿、生奶油、濃縮風味、豆奶、以及香料，具濃厚香氣與口味。</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 p-2" style="color: #fff;	text-shadow: 0px 0px 6px black; ">
          <h1 class="px-3 pt-2">Macchiato</h1>
          <p class="px-3 pt-2">使用少量牛奶或奶泡加上濃縮咖啡製作而成。傳統上，瑪琪雅朵咖啡是以一杯濃縮咖啡，上面加上大約一茶匙牛奶，讓牛奶浮在咖啡表面作為點綴裝飾。<br><br><br>The intent is that the milk moderates, rather than overwhelms, the taste of the coffee while adding a touch of sweetness.</p>
        </div>
        <div class="col-lg-9 col-md-6 p-2"> <img class="img-fluid d-block" src="imgs/macchiato.jpg"> </div>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </div>
</body>
</html>