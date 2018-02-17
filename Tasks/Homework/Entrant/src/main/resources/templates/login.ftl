<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
<#include 'common/head.ftl'/>
</head>

<body class="home page page-id-467 page-template-default wpb-js-composer js-comp-ver-4.9.2 vc_responsive">
<div class="animsition global-wrapper">
<#include 'common/menu.ftl'/>
    <div class="container-wrapper">
        <div class="page-title-wrapper">
            <div class="center">
                <h1>Вход</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->

            <div class="page-wrapper">
                <#if model.error == true>
                <h1>Неверно введен имя пользователяи пароль</h1>
                </#if>
                <form class="wpcf7"  title="Регистрация"
                      name="registrationForm"
                      method="post"
                      action="/login">
                    <br />
                    <input type="text" name="email" placeholder="Почта" class="wpcf7-form-control" style="width:250px;"/>
                    <br />
                    <input type="password" name="password" placeholder="Пароль" class="wpcf7-form-control" style="width:250px;"/>
                    <br />
                    <input type="checkbox" name="remember-me" class="wpcf7-form-control">Запомнить
                    <br />
                    <input type="submit" style="width:250px;" class="wpcf7-form-control wpcf7-submit">
                </form>
                <br><br>
                <a href="/registration"><b>Регистрация</b></a>
            </div>
        </div>
        <!-- end container -->
        <div class="clear"></div>
    </div>
    <!-- end container-wrapper -->

<#include 'common/footer.ftl'/>
</div>


</body>
</html>