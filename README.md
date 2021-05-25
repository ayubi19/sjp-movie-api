# SJP Movie API

## Introduction

> sebuah mini project membuat CRUD movie api menggunakan Spring Boot. sebagai salah satu portfolio untuk bergabung diperusahaan yang saya lamar.

## Prerequisites

1. Maven Build Tool
2. OpenJDK 1.8 (atau lebih)
3. IDE (Intelljidea atau STS)
4. PostgresSQL v.9.6

## Installation

````
Bagi yang ingin menjalankan aplikasi ini, pastikan sudah memiliki database
baik local ataupun cloud sesuaikan confignya pada file application.yml 

  name: sjp_movie_api
  host: localhost
  port: 5432
  username: postgres
  password: postgres
  
 config tersebut disesuaikan sesuai yang saya anjurkan jika ingin menjalankan 
 aplikasi ini  

````

kemudian bisa dibuka menggunakan Intelljidea ataupun STS, atau bisa langsung di build dengan sintak

````
mvn clean install
````

kemudian dilanjut dengan sintaks

```
java -jar target/sjp-movie-api-0.0.1-SNAPSHOT.jar
```

setelah program berhasil dijalankan

```
secara default saya mensetup api ini berada pada alamat
http://localhost:8567/sjp-movie-api

jika ingin masuk kedalam swaggernya bisa akses dengan alamat
http://localhost:8567/sjp-movie-api/swagger-ui.html#
jika diminta sign in, gunakan password yang ada pada console pada 
saat proses service applikasi di jalankan
```


```
lalu sign in menggunakan username : user
dan password :
Using generated security password: 5d3180fe-d47b-4013-9cb9-625cbc16a0ed

```

### Build With

Project ini dibangun menggunakan :

- OpenJDK 1.8
- Spring v2.4.5


