# E-commerce

## Database

* Mysql (local)

```sh
docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -p 3306:3306 \
    mysql
```

application-dev.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/api?createDatabaseIfNotExist=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

## Environment

.env

```
DATABASE_URL=jdbc:mysql://localhost:3306/api?createDatabaseIfNotExist=true
DATABASE_USER=root
DATABASE_PWD=root_pwd
```

* load .env

```sh
export $(cat .env | xargs)
```

## Maven

* run

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```