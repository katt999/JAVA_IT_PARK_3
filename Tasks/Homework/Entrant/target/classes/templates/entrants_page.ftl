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
                <h1>Абитуриенты</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->
            <div class="page-wrapper">
                <table style="width: 100%; font-family: 'Open Sans', sans-serif;">
                    <tr>
                        <th>Id</th>
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Отчество</th>
                        <th>Гражданство</th>
                        <th>№ документа об образовании</th>
                        <th>E-mail</th>
                        <th>Конкурсы</th>
                        <th>ЕГЭ</th>
                    </tr>
                <#list model.entrants as entrant>
                    <tr>
                        <td>${entrant.id}</td>
                        <td>${entrant.lastName}</td>
                        <td>${entrant.firstName}</td>
                        <td>${entrant.middleName}</td>
                        <td>${entrant.citizenship}</td>
                        <td>${entrant.eduDocumentNumber}</td>
                        <td>${entrant.email}</td>
                        <td>
                       <#list entrant.competitions as competition>
                         <a href="/competitions/${competition.id}" target="_blank">${competition.id}</a><br>
                       </#list>
                        </td>
                        <td>
                        <#list entrant.examEntrants as examEntrant>
                        ${examEntrant.discipline.title} - ${examEntrant.mark}<br>
                        </#list>
                        </td>
                    </tr>
                </#list>
                </table>
                <form action="/entrants" method="post" class="wpcf7">
                    <input type="text" style="width:250px;" name="lastName" placeholder="Фамилия" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="firstName" placeholder="Имя" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="middleName" placeholder="Отчество" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="citizenship" placeholder="Гражданство" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="eduDocumentNumber" placeholder="№ документа об образовании" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="email" placeholder="E-mail" class="wpcf7-form-control">
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