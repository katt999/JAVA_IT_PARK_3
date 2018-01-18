<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
  <title>КНИТУ-КАИ</title>

  <!-- for mobile devices -->
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <meta name="format-detection" content="telephone=no" />


  <link rel='stylesheet' href='/css/new_style.css' type='text/css' media='all' />
  <link rel='stylesheet' href='/css/vc_carousel.min.css' type='text/css' media='all' />
  <link rel='stylesheet' href='/css/js_composer.min.css' type='text/css' media='all' />

  <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans%3A400%2C300%2C300italic%2C400italic%2C600%2C600italic%2C700italic%2C700%2C800%2C800italic&amp;ver=4.4.2' type='text/css' media='all' />
  <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Playfair+Display%3A400%2C700&amp;ver=4.4.2' type='text/css' media='all' />

</head>

<body class="home page page-id-467 page-template-default wpb-js-composer js-comp-ver-4.9.2 vc_responsive">
<div class="animsition global-wrapper">
  <div id="header" class="header-wrapper header1">
    <div class="header-inner-wrapper center">
      <div class="logo">
        <a href="index.html" title=""><img id="logoImage" src="/images/logo.png" alt="" title="" /><img id="logoImageRetina" src="/images/logo-retina.png" alt="" title="" /></a>
        <div class="logo-text">КАЗАНСКИЙ НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ <br />ТЕХНИЧЕСКИЙ УНИВЕРСИТЕТ ИМ. А. Н. ТУПОЛЕВА ‒ КАИ</div>
      </div> <a class="mobile-menu-show"><i class="fa mobile-menu-icon fa-list"></i></a>
      <div class="main-menu menu-header1">
        <div class="menu-main-navigation-container">
          <ul id="menu-main-navigation" class="sf-menu">
            <li class="menu-item current-menu-item  menu-item-has-children">ОБРАЗОВАНИЕ
              <ul class="sub-menu">
                <li class="menu-item current-menu-item menu-item-home"><a href="#">Бакалавриат/Специалитет</a></li>
                <li class="menu-item"><a href="#">Магистратура</a></li>
                <li class="menu-item"><a href="#">Аспирантура</a></li>
                <li class="menu-item"><a href="#">СПО</a></li>
                <li class="menu-item"><a href="#">Второе высшее образование</a></li>
              </ul>
            </li>
            <li class="menu-item current-menu-item  menu-item-has-children">СПИСКИ ПОСТУПАЮЩИХ
              <ul class="sub-menu">
                <li class="menu-item current-menu-item menu-item-home"><a href="#">ИАНТЭ</a></li>
                <li class="menu-item"><a href="#">ИКТЗИ</a></li>
                <li class="menu-item"><a href="#">ИРЭТ</a></li>
                <li class="menu-item"><a href="#">ИАЭП</a></li>
                <li class="menu-item"><a href="#">ИЭУСТ</a></li>
              </ul>
            </li>
            <li class="menu-item"><a href="#">Документы</a></li>
            <li class="menu-item"><a href="#">Контакты</a></li>
          </ul>
        </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="clear"></div>
  <div class="container-wrapper">
    <div class="page-title-wrapper">
      <div class="center">
        <h1>Справочник типов конкурса</h1>
      </div>
    </div>
    <div class="clear"></div>
    <div id="container">
      <!-- start container -->

      <div class="page-wrapper">
<table style="width: 50%; font-family: 'Open Sans', sans-serif;">
  <tr>
    <th>Id</th>
    <th>Наименование</th>
  </tr>
  <c:forEach items="${competitionTypes}" var="competitionType">
    <tr>
      <td>${competitionType.id}</td>
      <td>${competitionType.title}</td>
    </tr>
  </c:forEach>
</table>
<form action="/competition_type_as_jsp" method="post" class="wpcf7">
  <input type="text" style="width:250px;" name="title" placeholder="Наименование" class="wpcf7-form-control">
  <input type="submit" style="width:250px;" class="wpcf7-form-control wpcf7-submit" value="ДОБАВИТЬ">
</form>
      </div>
    </div>
    <!-- end container -->
    <div class="clear"></div>
  </div>
  <!-- end container-wrapper -->

  <div id="footer" class="under-footer">

    <div class="center">
      <div class="left">
        &copy; КНИТУ-КАИ ${year}</div>
      <div class="right">
        Телефон: 8 (843) 231 00 27, Email: <a href="mailto:pk@kai.ru">pk@kai.ru</a> </div>
      <div class="clear"></div>
    </div>
  </div>
</div>

<script type='text/javascript' src='/js/jquery/jquery.js'></script>
<script type='text/javascript' src='/js/jquery/jquery-migrate.min.js'></script>
<script type='text/javascript' src='/js/jquery/ui/accordion.min.js'></script>
<script type='text/javascript' src='/js/contact-form.js'></script>
<script type='text/javascript' src='/js/waypoints.min.js'></script>
<script type='text/javascript' src='/js/superfish.js'></script>
<script type='text/javascript' src='/js/custom.js'></script>
</body>
</html>
