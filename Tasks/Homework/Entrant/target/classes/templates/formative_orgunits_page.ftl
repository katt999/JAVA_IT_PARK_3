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
            <h1>Справочник формирующих подразделений</h1>
        </div>
    </div>
    <div class="clear"></div>
    <div id="container">
            <!-- start container -->

      <div class="page-wrapper">
        <table style="width: 50%; font-family: 'Open Sans', sans-serif;">
            <tr>
                <th>Id</th>
                <th>Краткое наименование</th>
                <th>Полное наименование</th>
            </tr>
            <#list model.formativeOrgunits as formativeOrgunit>
                <tr>
                    <td>${formativeOrgunit.id}</td>
                    <td>${formativeOrgunit.shortTitle}</td>
                    <td>${formativeOrgunit.fullTitle}</td>
                </tr>
            </#list>
        </table>
        <form action="/formative_orgunits" method="post" class="wpcf7">
            <input type="text" style="width:250px;" name="shortTitle" placeholder="Краткое наименование" class="wpcf7-form-control">
            <input type="text" style="width:250px;" name="fullTitle" placeholder="Полное наименование" class="wpcf7-form-control">
            <input type="submit" style="width:250px;" class="wpcf7-form-control wpcf7-submit" value="ДОБАВИТЬ">
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