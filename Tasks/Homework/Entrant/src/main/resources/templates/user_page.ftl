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
                <h1>Регистрация</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container">
            <!-- start container -->

            <div class="page-wrapper">
                <script>
                    <#--Функция принимает на вход два параметра - имя и фамилию -->
                    function sendNewNameOrSurName(name, surname) {
                        // Оотправляем ajax-запорс на сервер
                        $.ajax({
                            type: "POST",
                            url: "/users/${model.user.id}",
                            data: {
                                "name": name,
                                "surname": surname
                            },
                            error: function (data) {
                                alert(data.status)
                            },
                            success: function (data) {
                                alert("Wow!" + data.status)
                            }
                        });
                    }
                </script>
            <div>
                <form  class="wpcf7">
                <input type="text" id="name" name="name" value="${model.user.name}" class="wpcf7-form-control" style="width:250px;" />
                <input type="text" id="surname" name="surname" value="${model.user.surname}" class="wpcf7-form-control" style="width:250px;"/>
                <button onclick="sendNewNameOrSurName(
                    document.getElementById('name').value,
                    document.getElementById('surname').value)" style="width:250px;" class="wpcf7-form-control wpcf7-submit">Отправить</button>
                </form>
            </div>
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