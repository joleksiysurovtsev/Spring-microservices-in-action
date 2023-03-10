II. Зависимости
Явно объявляйте и изолируйте зависимости
Большинство языков программирования поставляются вместе с менеджером пакетов для распространения библиотек, 
таким как **[CPAN](http://www.cpan.org/)** в **Perl** или **[Rubygems](http://rubygems.org/)** в **Ruby**. Библиотеки, устанавливаемые менеджером пакетов, могут быть установлены 
доступными для всей системы (так называемые “системные пакеты”) или доступными только приложению в директорию 
содержащую приложение (так называемые **“vendoring”** и **“bundling”**).

**Приложение двенадцати факторов никогда не зависит от неявно существующих, доступных всей системе пакетов.** 

Приложение объявляет все свои зависимости полностью и точно с помощью манифеста декларации зависимостей. 
Кроме того, оно использует инструмент изоляции зависимостей во время выполнения для обеспечения того, что 
неявные зависимости не “просочились” из окружающей системы. Полная и явная спецификация зависимостей применяется
равным образом как при разработке, так и при работе приложения.

Например, **[Bundler](https://bundler.io/)** в **Ruby** использует `Gemfile` как формат манифеста для объявления зависимостей и `bundle exec` – для 
изоляции зависимостей. **Python** имеет два различных инструмента для этих задач: **[Pip](http://www.pip-installer.org/en/latest/)** используется для объявления и 
**[Virtualenv](http://www.virtualenv.org/en/latest/)** – для изоляции. Даже **C** имеет **[Autoconf](http://www.gnu.org/s/autoconf/)** для объявления зависимостей, и статическое связывание может
обеспечить изоляцию зависимостей. Независимо от того, какой набор инструментов используется, объявление и изоляция 
зависимостей должны всегда использоваться совместно – только одного из них недостаточно, чтобы удовлетворить 
двенадцати факторам.

Одним из преимуществ явного объявления зависимостей является то, что это упрощает настройку приложения для новых 
разработчиков. Новый разработчик может скопировать кодовую базу приложения на свою машину, необходимыми требованиями 
для которой являются только наличие среды выполнения языка и менеджера пакетов. Всё необходимое для запуска кода 
приложения может быть настроено с помощью определённой *команды настройк*и. Например, для **Ruby/Bundler** командой настройки 
является **bundle install**, для **Clojure/[Leiningen](https://github.com/technomancy/leiningen#readme)** это `lein deps`.

Приложение двенадцати факторов также не полагается на неявное существование любых инструментов системы. 
Примером является запуск программ **ImageMagick** и `curl`. Хотя эти инструменты могут присутствовать во многих 
или даже в большинстве систем, нет никакой гарантии, что они будут присутствовать на всех системах, где приложение 
может работать в будущем, или будет ли версия найденная в другой системе совместима с приложением. Если приложению 
необходимо запустить инструмент системы, то этот инструмент должен быть включён в приложение.