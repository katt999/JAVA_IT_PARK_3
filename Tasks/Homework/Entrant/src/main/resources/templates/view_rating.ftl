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
            <#if model.entrant??>
                <h1>Заявление №${model.entrant.id}</h1>
                <h1>${model.entrant.lastName} ${model.entrant.firstName} ${model.entrant.middleName}</h1><br>
                <#list model.entrant.competitions as competition>
                <table style="width: 50%">
                    <tr><td style="font-weight: bold;text-align: center;" colspan="2">${competition.formativeOrgunit.fullTitle}<br>
                    ${competition.programSubject.code} ${competition.programSubject.title}</td></tr>
                    <tr><td style="font-weight: bold;">Тип конкурса</td><td> ${competition.competitionType.title}</td></tr>
                    <tr><td style="font-weight: bold;">Форма обучения</td><td> ${competition.programForm.title}</td></tr>
                    <tr><td style="font-weight: bold;">Уровень образования</td><td> ${competition.levelType.title}</td></tr>
                    <tr><td style="font-weight: bold;">Тип компенсации</td><td> ${competition.compensationType.title}</td></tr>
                    <tr><td style="font-weight: bold;">Рейтинг</td><td style="font-weight: bold;">
                        <#list model.positions as position>
                            <#if position?index == competition?index>
                            ${position}
                            </#if>
                        </#list>
                        из
                    <#switch competition.competitionType.id>
                    <#case 1>  ${competition.programSetOuMinisterialPlan}
                       <#break>
                    <#case 2>  ${competition.programSetOuExclusivePlan}
                        <#break>
                    <#case 3>  ${competition.programSetOuTargetAdmPlan}
                        <#break>
                    <#case 4>  ${competition.programSetOuMinisterialPlan}
                        <#break>
                    <#case 5>  ${competition.programSetOuContractPlan}
                        <#break>
                    <#case 6>  ${competition.programSetOuContractPlan}
                        <#break>
                    </#switch>
                        бюджетных мест</td></tr>
                </table><br><br>
                </#list>
               <br>

            <#else>
                Номер заявления не соответствует пользователю, обратитесь в приемную комиссию.
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