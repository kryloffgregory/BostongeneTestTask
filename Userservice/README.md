Сборка и запуск: 

mvn clean install
mvn spring-boot:run -e


Примеры curl-запросов для windows(через Postman удобнее):

1) Добавление пользователя

curl -H "Content-Type: application/json" -d "{\"name\": \"Ivan\",\"surname\": \"Ivanov\",\"email\": \"IvanovIvan@yandex.ru\",\"birthDate\":\"1997-04-29\",\"password\":\"qwerty\"}" localhost:8080/api/add

2) Поиск по email

curl -H "Content-Type: application/json" -d "IvanovIvan@yandex.ru" localhost:8080/api/find

3) Удаление

curl -H "Content-Type: application/json" -d "IvanovIvan@yandex.ru" localhost:8080/api/delete