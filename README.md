# ModsenSpringOrder

## ModsenSpringOrder is a Web API for a libraryService imitation with using [Java](https://www.java.com/ru/) [Spring](https://spring.io) framework

It add additional functionality to the [Library](github.com/mrTechnik/ModsenSpring) service.

## Schema:
```code
ModsenSpring
│   .gitignore
│
├───.vscode
│       settings.json
│
└───libraryservice
    │   .gitignore
    │   HELP.md
    │   mvnw
    │   mvnw.cmd
    │   pom.xml
    │
    ├───.mvn
    │   └───wrapper
    │           maven-wrapper.jar
    │           maven-wrapper.properties
    │
    ├───.vscode
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───app
    │   │   │       └───libraryservice
    │   │   │           │   LibraryserviceApplication.java
    │   │   │           │
    │   │   │           ├───domain
    │   │   │           │       BookOrder.java
    │   │   │           │
    │   │   │           ├───repos
    │   │   │           │       BookOrderRepo.java
    │   │   │           │
    │   │   │           ├───securityconfig
    │   │   │           │       SecurityConfiguration.java
    │   │   │           │
    │   │   │           ├───swagger
    │   │   │           │       SwaggerConfiguration.java
    │   │   │           │
    │   │   │           └───webservice
    │   │   │                   MainController.java
    │   │   │
    │   │   └───resources
    │   │       │   application.properties
    │   │       │
    │   │       └───META-INF
    │   └───test
    │       └───java
    │           └───app
    │               └───libraryservice
    │                       LibraryserviceApplicationTests.java
    │
    └───target
        ├───classes
        │   │   application.properties
        │   │
        │   └───app
        │       └───libraryservice
        │           │   LibraryserviceApplication.class
        │           │
        │           ├───domain
        │           │       BookOrder.class
        │           │
        │           ├───repos
        │           │       BookOrderRepo.class
        │           │
        │           ├───securityconfig
        │           │       SecurityConfiguration.class
        │           │
        │           └───webservice
        │                   MainController.class
        │
        ├───generated-sources
        │   └───annotations
        ├───generated-test-sources
        │   └───test-annotations
        └───test-classes
            └───app
                └───libraryservice
                        LibraryserviceApplicationTests.class

```


Main Functionaliti:
1) creating a new book order entry in the PostgreSql;
2) getting a list of all unordered books;

A bookOrder information:
1) ID;
2) bookOrderDate;
3) bookEndOrderDate.

## Endpoints

Endponts description:
1) ```addNewBook``` endpoint:
   It process incoming HTTP POST requests:
   example:
   ```bash
    curl -X POST http://localhost:8081/orderservice/add
    --header "Content-Type: Application/json" --data '{"id": "1005"}'
   ```
      
   !!!Just an Example it can work only with http://localhost:8080. Look [SecurityConfiguration](https://github.com/mrTechnik/ModsenSpringOrder/blob/master/libraryservice/src/main/java/app/libraryservice/securityconfig/SecurityConfiguration.java)

   1) It create a new book and save a book entry in PostgreSQL.
   2) It recieve POST HTTP request from the [Library](https://github.com/mrTechnik/ModsenSpring) service.
   3) Return a status of response.

2) ```getAllUnorderedBooks``` endpoint:
   It process incoming HTTP GET requests:
   example:
   ```bash
    curl -X GET http://localhost:8081/orderservice/get/all_unordered
   ```
      
   ```bash
    !!!Example: {id: 1003, bookOrderDate: 2024-01-09 19:13:54.681, bookEndOrderDate: 7}{id: 1004, bookOrderDate: 2024-01-09 19:15:36.718, bookEndOrderDate: 7}{id: 1005, bookOrderDate: 2024-01-10 02:07:19.497, bookEndOrderDate: 7}
   ```
   1) It get all unordered books from PostgerSQL and generate a response.
   2) Return a status of response.

3) ```updateBookOrder``` endpoint:
   It process incoming HTTP PUT requests:
   example:
   ```bash
    curl -X PUT http://localhost:8081/orderservice/update/1005
    --header "Content-Type: Application/json"
    --data '{"bookOrderDate": "2024-01-09", "bookEndOrderDate": "15"}'
   ```
      
   ```bash
    Updated
   ```
   1) It update containded book order data in PostgerSQL.
   2) Return a status of response.

## Swagger

After after starting the application the ```Swagger``` and ```API-Docs``` are available on the (http://localhost:8081/swagger-ui/index.html) and (http://localhost:8081/api-docs) links.

## Running
For running clone repository:
```bash
https://github.com/mrTechnik/ModsenSpringOrder.git
```
or download a zip file and extract it.
## 
Run the following command in a terminal window (in the ```libraryservice```) directory ([Resource](https://spring.io/guides/gs/spring-boot/)):
```bash
./mvnw spring-boot:run
```
OR
```bash
cd <path_to_directory>; & <path_to_java.exe>\java.exe @<path_to_argfile>\cp_1tvvam5k9pl2shmlz6k99o7r6.argfile app.libraryservice.LibraryserviceApplication
```
Example:
```bash
F:\>f:; cd f:\Just Work\Tests\ModsenSpringOrder; & C:\Users\Администратор\.vscode\extensions\redhat.java-1.15.0-win32-x64\jre\17.0.6-win32-x86_64\bin\java.exe @C:\Users\836D~1\AppData\Local\Temp\cp_1tvvam5k9pl2shmlz6k99o7r6.argfile app.libraryservice.LibraryserviceApplication
```
