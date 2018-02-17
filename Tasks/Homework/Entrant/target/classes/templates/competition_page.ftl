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
                <h1>Конкурс №${model.competition.id} </h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->
            <div class="page-wrapper">
                <table style="width: 100%; font-family: 'Open Sans', sans-serif;">
                    <tr>
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
                    <tr>
                        <td>${model.competition.formativeOrgunit.shortTitle}</td>
                        <td>${model.competition.competitionType.title}</td>
                        <td>${model.competition.programForm.title}</td>
                        <td>${model.competition.programSubject.title}</td>
                        <td>${model.competition.levelType.title}</td>
                        <td>${model.competition.compensationType.title}</td>
                        <td>${model.competition.programSetOuMinisterialPlan}</td>
                        <td>${model.competition.programSetOuTargetAdmPlan}</td>
                        <td>${model.competition.programSetOuExclusivePlan}</td>
                        <td>${model.competition.programSetOuContractPlan}</td>
                    </tr>
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