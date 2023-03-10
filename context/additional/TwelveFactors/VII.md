# VII. Привязка портов (Port binding) #

## Экспортируйте сервисы через привязку портов ##

Иногда веб-приложения запускают внутри контейнера веб-сервера. Например, **PHP**-приложение может быть запущено как модуль
внутри **[Apache HTTPD](http://httpd.apache.org/)**, или Java-приложение может быть запущено внутри [Tomcat](http://tomcat.apache.org/).

**Приложение двенадцати факторов является полностью самодостаточным** и не полагается на инъекцию веб-сервера во время
выполнения для того, чтобы создать веб-сервис. Веб-приложение **экспортирует HTTP-сервис путём привязки к порту** и
прослушивает запросы, поступающих на этот порт.

Во время локальной разработки разработчик переходит по URL-адресу вида `http://localhost:5000/`, чтобы получить доступ к
сервису, предоставляемым его приложением. При развёртывании слой маршрутизации обрабатывает запросы к общедоступному
хосту и перенаправляет их к привязанному к порту веб приложению.

Это обычно реализуется с помощью объявления зависимости для добавления библиотеки веб-сервера к приложению такой, как
[Tornado](http://www.tornadoweb.org/) в Python, [Thin](http://code.macournoyer.com/thin/) в Ruby,
и [Jetty](http://www.eclipse.org/jetty/) в Java и других языках на основе JVM. Это происходит полностью в пространстве
пользователя, то есть в коде приложения. Контрактом со средой исполнения является привязка приложения к порту для
обработки запросов.

HTTP – это не единственный сервис, который может быть экспортирован посредством привязки порта. Почти любой тип
серверного ПО может быть запущен как процесс, привязанный к порту и ожидающий входящих запросов. Примеры этого включают
[ejabberd](http://www.ejabberd.im/) (предоставляет [XMPP протокол](http://xmpp.org/)) и [Redis](http://redis.io/)
(предоставляет [Redis протокол](http://redis.io/topics/protocol)).

Также обратите внимание, что подход привязки к порту означает, что одно приложение может выступать сторонней службой для
другого приложения путём предоставления URL-адреса стороннего приложения как идентификатор ресурса в конфигурации
потребляющего приложения.