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
                <h1>Рейтинг абитуриента</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->
            <div class="page-wrapper">
                Для просмотра рейтинга введите номер заявления:<br><br>
                <form  class="wpcf7" title="Рейтинг"
                       name="ratingForm"
                       method="post"
                       action="/rating">
                    <input type="text" name="application" placeholder="Номер заявления" class="wpcf7-form-control" style="width:250px;"/>
                    <br>
                    <input type="submit" style="width:250px;" class="wpcf7-form-control wpcf7-submit"/>
                </form>

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