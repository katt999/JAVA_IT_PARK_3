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
                <h1>Списки поступающих</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->
            <div class="page-wrapper">
                <script>
                    <#--Функция принимает на вход два параметра - имя и фамилию -->
                    function sendParameterForm() {
                        var formativeOrgunit = $("#formativeOrgunit").val();
                        var programForm = $("#programForm").val();
                        var compensationType = $("#compensationType").val();
                        var levelType = $("#levelType").val();
                        var programSubject = $("#programSubject").val();
                        $.ajax({
                            type: "POST",
                            url: "/list_entrant",
                            data: {
                                "formativeOrgunit": formativeOrgunit,
                                "programForm": programForm,
                                "compensationType": compensationType,
                                "levelType": levelType,
                                "programSubject": programSubject
                            },
                            error: function (data) {
                                alert('Выберите данные для списка');
                            },
                            success: function (response) {
                                $('#result_id').empty();
                                $('#result_id').show();
                                $('#result_id').append("<tr><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Сумма баллов ЕГЭ</th></tr>");
                                response.forEach(function(data) {
                                    var sum_mark = data.exams[0].mark +  data.exams[1].mark +  data.exams[2].mark;
                                    $("#result_id").append("<tr><td>" + data.lastName + "</td><td>" + data.firstName + "</td><td>" + data.middleName + "</td><td align='center'>" + sum_mark + "</td></tr>");
                                });
                            }
                        });
                    }
                </script>
                <div class="wpcf7">
                    <select style="width:250px;" id="formativeOrgunit"  class="wpcf7-form-control">
                        <option disabled selected>Формирующее подразделение</option>
                    <#list model.formativeOrgunits as formativeOrgunit>
                        <option value="${formativeOrgunit.id}">${formativeOrgunit.shortTitle}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" id="programForm" class="wpcf7-form-control">
                        <option disabled selected>Форма обучения</option>
                    <#list model.programForms as programForm>
                        <option value="${programForm.id}">${programForm.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" id="programSubject" class="wpcf7-form-control">
                        <option disabled selected>Специальность</option>
                    <#list model.programSubjects as programSubject>
                        <option value="${programSubject.id}">${programSubject.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" id="levelType"  class="wpcf7-form-control">
                        <option disabled selected>Уровень образования</option>
                    <#list model.levelTypes as levelType>
                        <option value="${levelType.id}">${levelType.title}</option>
                    </#list>
                    </select>
                    <select style="width:250px;" id="compensationType"  class="wpcf7-form-control">
                        <option disabled selected>Тип компенсации</option>
                    <#list model.compensationTypes as compensationType>
                        <option value="${compensationType.id}">${compensationType.title}</option>
                    </#list>
                    </select><br><br>
                    <button  onclick="sendParameterForm()" style="width:250px;" class="wpcf7-form-control wpcf7-submit">ВЫБРАТЬ</button>
                     </div>
                    <br><br>
                    <table id="result_id" style="width: 70%; font-family: 'Open Sans', sans-serif; display: none;">
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