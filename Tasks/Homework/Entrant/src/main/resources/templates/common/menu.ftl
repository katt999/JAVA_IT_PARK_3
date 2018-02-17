<div id="header" class="header-wrapper header1">
    <div class="header-inner-wrapper center">
        <div class="logo">
            <a href="/" title=""><img id="logoImage" src="/images/logo.png" alt="" title="" /><img id="logoImageRetina" src="/images/logo-retina.png" alt="" title="" /></a>
            <div class="logo-text">КАЗАНСКИЙ НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ <br />ТЕХНИЧЕСКИЙ УНИВЕРСИТЕТ ИМ. А. Н. ТУПОЛЕВА ‒ КАИ</div>
        </div> <a class="mobile-menu-show"><i class="fa mobile-menu-icon fa-list"></i></a>
        <div class="main-menu menu-header1">
            <div class="menu-main-navigation-container">
                <ul id="menu-main-navigation" class="sf-menu">
                    <li class="menu-item current-menu-item  menu-item-has-children">ОБРАЗОВАНИЕ
                        <ul class="sub-menu">
                            <li class="menu-item current-menu-item menu-item-home"><a href="#">Бакалавриат/Специалитет</a></li>
                            <li class="menu-item"><a href="#">Магистратура</a></li>
                            <li class="menu-item"><a href="#">Аспирантура</a></li>
                            <li class="menu-item"><a href="#">СПО</a></li>
                            <li class="menu-item"><a href="#">Второе высшее образование</a></li>
                        </ul>
                    </li>
                    <li class="menu-item current-menu-item  menu-item-has-children">ИНСТИТУТЫ
                        <ul class="sub-menu">
                            <li class="menu-item current-menu-item menu-item-home"><a href="/iante">ИАНТЭ</a></li>
                            <li class="menu-item"><a href="#">ИКТЗИ</a></li>
                            <li class="menu-item"><a href="#">ИРЭТ</a></li>
                            <li class="menu-item"><a href="#">ИАЭП</a></li>
                            <li class="menu-item"><a href="#">ИЭУСТ</a></li>
                        </ul>
                    </li>
                    <li class="menu-item"><a href="/contact">Контакты</a></li>
                        <#if model.user??>
                            <li class="menu-item">
                                <a href="/profile">ЛИЧНЫЙ КАБИНЕТ</a>
                            </li>
                            <li class="menu-item">
                                <a href="/logout">ВЫХОД</a>
                            </li>
                        <#else>
                            <li class="menu-item">
                                <a href="/login">ЛИЧНЫЙ КАБИНЕТ</a>
                            </li>
                        </#if>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<div class="clear"></div>