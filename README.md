# Horns_and_Hooves

Spring Boot Rest JPA
=============================
Пользователь заходит в приложение, выбирает мебель, кладет в корзину, нажимает купить 

-> создается ордер в котором вся мебель из заказа делится на работников по депортаментам

-> они её делают и, когда всё готово, ордер завершается и отправляется смс или email

-> работники могут заходить и просматривать таски, менять статус и оставлять коментарии

-> админ может менять ордера, создавать новую мебель

INSTALLATION
------------
В конфигурационном файле <b>application.properties</b> необходимо заполнить свойство 
spring.profiles.active=postgre (провайдер sql)
Для запуска необходимо создать базу данных и добавить её в конфигурационный файл 

(например <b>application-postgre.properties</b>)

SQL HELP
-----------

WHAT'S NEXT
-----------
- сделать авторизацию и фильтрацию записей из базы по юзеру при выборке(сквозная функциональность проверок)
- починить hsqldb, h2
- сделать в js model.js для сущностей в которых будет метод валидации и проверки на надобность обновления записи
  (возможно ничего не изменилось и не нужно обновлять)
- покрыть тестами
- логирование
- сделать валидацию
- добавить кодаси и прочую хрень
- таблицу заказов и айтемы разбить постранично с помощью спринг пейджинга
- изменить внешний вид на bootstrap 5
- добавить форму логина и регистрации
- при открытии нескольких заказов через ссылку на заказ(в адресной строке /tasks/editTask/100011)
    старое модальное окно  не закрывается
- ! сделать распределение неназначенный ордеров
- решить проблему с добавлением одинаковых айтемов в ордер
- если поставить отображение юзеров по 5, перейти на 2ю страницу, и поставить отображение юзеров по 10, 
  вылезет ошибка что пользователи не найдены (потому что страница вторая, а все записи уместились на 1ой)
- разделить сущность User на ту в которой лежит пароль логин и на ту в которой лежат публичные данные

- при вытаскивании ордеров вытаскивать айдишники айтемов а не сущности, потому что это накладно вытаскивать одни и те же сущности, 
    нужно их вытаскивать 1 раз и потом мапить (или если айтемов будет очень много, то вытаскивать позже при просмотре по айдишникам)
- написать генератор данных, который будет заполнять базу кучей данных
- hibernate N+1
- cascade = all
- сделать несколько картинок у айтема
- переделать выбор количество записей на странице под директиву

Rusfrance inc.
