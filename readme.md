Система Команда разработчиков.


Структура проекта:
-
**pom.xml** - дескриптор Maven 

**src.main.java.com.ep.proj**
- **Model** - Пакет модели данных, содержит в себе класы всех сущностей 
- **Repository** - Пакет хранилище (DAO), интерыейсы и реализации 
- **Controller** - Пакет контроллеров (бизнес-логика приложения)
- **Utils** - Пакет вспомогательных классов (Exceptions, Connections, Authorization, etc)
- **Web** - Пакет для работы с веб (сервлеты) 

**src.main.resources** - Пакет ресурсов системы (илициализация и заполнение бд, локализация, ....)

**src.main.webapp** - Пакет внешнего отображения, содержит JSP, CSS 

**src.main.webapp.web-inf** - дескриптор развёртывания web.xml

**src.main.test.java.com.ep.proj** - junit тесты


Сущности проекта:
- 
- **Role** (enum) таблица ролей пользователей, используется для ограничения прав доступа 
- **Position** (enum) таблица квалификаций пользователей испальзуется в справочнике пользовалей и процессов  
- **BaseEntity** - абстрактный клас, родитель всех сущностей, содержит поля Id, Name
- **User** (class) клас пользователей системы, хранит пользователей, их роли и квалификации
- **Process** (class) клас процессов разработки с указанием требуемой квалификации. 
- **Specification** (class) клас спецификаций (Техических заданий) содержащие перечень необходимых работ. Создаются Клиентом
- **Project** (class) клас проектов, основанных на спецификациях, с указанием конкретных исполнителей и затраченых часов. 
Создаются Менеджером, затраченные часы проставляют разработчики
- **Invoice** (class) клас инвойсов, включает проект, его сроки и стоимость. Создается Менеджером.


