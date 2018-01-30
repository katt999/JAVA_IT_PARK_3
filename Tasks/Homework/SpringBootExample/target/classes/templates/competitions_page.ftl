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
            <h1>Справочник конкурсов</h1>
        </div>
    </div>
    <div class="clear"></div>
    <div id="container">
            <!-- start container -->
      <div class="page-wrapper">
        <table style="width: 100%; font-family: 'Open Sans', sans-serif;">
            <tr>
                <th>Id</th>
                <th>Формирующее подразделение</th>
                <th>Тип конкурса</th>
                <th>Форма обучения</th>
                <th>Специальность</th>
                <th>Уровень образования</th>
                <th>Тип компенсации</th>
                <th>Общий план приема</th>
                <th>Целевых мест</th>
                <th>Льготных мест</th>
                <th>Мест по договору</th>
            </tr>
            <#list model.competitions as competition>
                <tr>
                    <td>${competition.id}</td>
                    <td>${competition.formativeOrgUnitId}</td>
                    <td>${competition.competitionTypeId}</td>
                    <td>${competition.programFormId}</td>
                    <td>${competition.programSubjectId}</td>
                    <td>${competition.levelTypeId}</td>
                    <td>${competition.compensationTypeId}</td>
                    <td>${competition.programSetOuMinisterialPlan}</td>
                    <td>${competition.programSetOuTargetAdmPlan}</td>
                    <td>${competition.programSetOuExclusivePlan}</td>
                    <td>${competition.programSetOuContractPlan}</td>
                </tr>
            </#list>
        </table>
        <form action="/competitions" method="post" class="wpcf7">
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