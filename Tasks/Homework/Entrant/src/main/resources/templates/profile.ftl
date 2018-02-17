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
                <h1>Личный кабинет</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->

            <div class="page-wrapper">
                <h1>Здравствуйте, ${model.user.name}!</h1>
            <#if model.user.role == "ADMIN">
                <div>
                    - <b><a href="/users?order_by=id">Пользователи</a></b>;<br /><br />
                    - <b><a href="/competitions?order_by=id">Справочник конкурсов</a></b>;<br />
                    - <b><a href="/formative_orgunits?order_by=id">Справочник формирующих подразделений</a></b>;<br />
                    - <b><a href="/program_forms?order_by=id">Справочник форм обучения</a></b>;<br />
                    - <b>Справочник уровней образования</b>;<br />
                    - <b>Справочник специальностей</b>;<br />
                    - <b>Справочник типов конкурса</b>;<br />
                    - <b>Справочник типов компенсации</b>;<br /><br />
                    - <b><a href="/list_entrant">Списки участвующих в конкурсах</a></b>;<br />
                    - <b><a href="/entrants?order_by=id">Абитуриенты</a></b>.
                </div>
            <#else>
                <div>
                    - <b><a href="/rating">Рейтинг абитуриента</b>.
                </div>
            </#if>
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