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
                <h1>1Справочник конкурсов</h1>
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
                        <td>${competition.formativeOrgunit.shortTitle}</td>
                        <td>${competition.competitionType.title}</td>
                        <td>${competition.programForm.title}</td>
                        <td>${competition.programSubject.title}</td>
                        <td>${competition.levelType.title}</td>
                        <td>${competition.compensationType.title}</td>
                        <td>${competition.programSetOuMinisterialPlan}</td>
                        <td>${competition.programSetOuTargetAdmPlan}</td>
                        <td>${competition.programSetOuExclusivePlan}</td>
                        <td>${competition.programSetOuContractPlan}</td>
                    </tr>
                </#list>
                </table>
                <form action="/competitions" method="post" class="wpcf7">
                    <select style="width:250px;" name="formativeOrgunit"  class="wpcf7-form-control">
                        <option disabled selected>Формирующее подразделение</option>
                    <#list model.formativeOrgunits as formativeOrgunit>
                           <option value="${formativeOrgunit.id}">${formativeOrgunit.shortTitle}</option>
                        </#list>
                    </select>
                    <select style="width:250px;" name="competitionType"  class="wpcf7-form-control">
                        <option disabled selected>Тип конкурса</option>
                    <#list model.competitionTypes as competitionType>
                        <option value="${competitionType.id}">${competitionType.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" name="programForm" class="wpcf7-form-control">
                        <option disabled selected>Форма обучения</option>
                    <#list model.programForms as programForm>
                        <option value="${programForm.id}">${programForm.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" name="programSubject" class="wpcf7-form-control">
                        <option disabled selected>Специальность</option>
                    <#list model.programSubjects as programSubject>
                        <option value="${programSubject.id}">${programSubject.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" name="levelType"  class="wpcf7-form-control">
                        <option disabled selected>Уровень образования</option>
                    <#list model.levelTypes as levelType>
                        <option value="${levelType.id}">${levelType.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" name="compensationType"  class="wpcf7-form-control">
                        <option disabled selected>Тип компенсации</option>
                    <#list model.compensationTypes as compensationType>
                        <option value="${compensationType.id}">${compensationType.title}</option>
                    </#list>
                    </select>
                    <input type="text" style="width:250px;" name="programSetOuMinisterialPlan" placeholder="Общий план приема" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="programSetOuTargetAdmPlan" placeholder="Целевых мест" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="programSetOuExclusivePlan" placeholder="Льготных мест" class="wpcf7-form-control">
                    <input type="text" style="width:250px;" name="programSetOuContractPlan" placeholder="Мест по договору" class="wpcf7-form-control">
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