---
marp: true
paginate: true
theme: default
math: katex
style: |
  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }
---

# Язык Java

## Осенний семестр 2023, магистратура, 1 курс

### Лекция 7: Spring MVC

---

## Содержание

1. HTTP-запросы
2. Архитектура Spring MVC
3. Демо-проект

---

## HTTP-запросы

- Удобная программа для выполнения HTTP запросов: [Postman](https://www.postman.com/)
- Пример API: [Open Library Search API](https://openlibrary.org/dev/docs/api/search)
- Пример GET запроса: поиск книг по названию и имени автора:

    ```java
    GET http://openlibrary.org/search.json?title=Clean%20Code&author=Martins
    ```

  - Протокол: `http`
  - Хост: `openlibrary.org`
  - Путь к ресурсу: `/search.json`
  - Параметры поиска (query params):
    - `title=Clean%20Code`
    - `author=Martins`

---

## Структура HTTP сообщений

- Запрос (request)
  ![height:100px](img/HttpRequestRaw.png)

- Ответ (response)
  ![height:300px](img/HttpResponseRaw.png)

---

## Основные задачи веб-приложения

1. Следить за входящими HTTP запросами от клиентов
2. Чтение параметров HTTP-запроса
3. Валидация (проверка корректности) запроса (в т.ч. аутентификация и авторизация)
4. **Обработка запроса (чтение или запись в БД, вызов внешних API, ...)**
5. Формирование HTTP сообщения для ответа клиенту
6. Отправка HTTP-ответа клиенту

Spring MVC берет на себя обработку шагов 1-3 и 5-6.

---

## Архитектура Spring MVC

![height:600px](img/SpringMVCArchitecture.png)

---

## Демо-проект: "Course API"

- Создание REST API для чтения/создания/изменения/удаления информации о курсах

  ![height:250px](img/CoursesApi.png)

- Используемые технологии:
  - Spring MVC
  - Spring Data JPA
  - База данных H2

---

## Создание приложения

![height:500px](img/SpringInitializr.png)

---

## Структура приложения

![height:500px](img/ProjectStructure.png)

**Внимание**: дополнительная зависимость `springdoc-openapi-starter-webmvc-ui` для автоматического создания документации API.

---

## Архитектура приложения

![height:600px](img/AppArchitecture.png)

---

## `CourseController`

![height:600px](img/CourseController.png)

---

## `CourseEntity` - модель для таблицы БД

![height:600px](img/CourseEntity.png)

---

## `CourseRepository`

![height:100px](img/CourseRepository.png)

---

## `CourseService`

![height:600px](img/CourseService.png)

---

## `CourseMapper`

![height:600px](img/CourseMapper.png)

---

## Конфигурационные параметры

![height:150px](img/ApplicationProperties.png)

---

## SwaggerUI

![height:600px](img/SwaggerUI.png)

---

## Упражнение

1. Добавить API для управления студентами (чтение данных, добавление, изменение, удаление)
2. (**Более сложное задание**) Добавить API для регистрации студентов на курсы

Демо-проект с Course API доступен [здесь](https://github.com/perevos/java-master-23/tree/main/lectures/lecture7/code)
