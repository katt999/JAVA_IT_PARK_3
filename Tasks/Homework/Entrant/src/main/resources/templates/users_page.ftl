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
                <h1>Пользователи</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->

            <div class="page-wrapper">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Имя</th>
                            <th>Дата регистрации</th>
                            <th>Роль</th>
                        </tr>
                        <#list model.users as user>
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.registrationTime}</td>
                            <td>${user.role}</td>
                        </#list>
                    </table>
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