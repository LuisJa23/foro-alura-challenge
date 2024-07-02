# Foro Alura

![Portada](https://user-images.githubusercontent.com/91544872/209678377-70b50b21-33de-424c-bed8-6a71ef3406ff.png)

[![Estado del Proyecto](https://img.shields.io/badge/Estado-Activo-brightgreen.svg)](#)
[![Versión](https://img.shields.io/badge/Versión-1.0-yellow.svg)](#)
[![Spring Framework](https://img.shields.io/badge/Spring_Framework-3.3.1-brightgreen.svg)](#)
[![JDK](https://img.shields.io/badge/JDK-20-blue.svg)](#)
[![Maven](https://img.shields.io/badge/Maven-3.8.8-blue.svg)](#)


## Índice
- [Descripción del Proyecto](#descripción-del-proyecto)
- [Estado del Proyecto](#estado-del-proyecto)
- [Funcionalidades](#funcionalidades)
- [Integración con Base de Datos](#integración-con-base-de-datos)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Personas Desarrolladoras del Proyecto](#personas-desarrolladoras-del-proyecto)


## Descripción del Proyecto
Foro Alura es una api REST estructurada con Spring que posee diferentes endpoint. Además, cuenta con autenticación mediante JWT para el acceso a la api REST. 

## Estado del Proyecto
Actualmente finalizado con la posibilidad de agregar nuevas funciones

## Funcionalidades
Las entradas deben estar en formato JSON. Para mas informacion consulte la documentación.

- **Endpoints:**
   - /login
        - POST - Genera un token de acceso para hacer uso de los diferentes endpoints mediante usuario y contraseña.
    - /topics
        - POST - Permite la creación de un tópico.
        - GET - Obtine un listado de los tópicos ordenados por paginas de 10 elementos.
          
    - /topics/{id}
        - PUT - Permite la actualización de los datos de un tópico perteneciente al id.
        - DELETE - Permite la eliminación de un tópico perteneciente al id
 

## Integración con Base de Datos

El proyecto está integrado con PostgreSQL para el almacenamiento de datos, incluyendo información sobre los tópicos, usuarios, perfiles, cursos y respuestas.

![Modelo Relacional](https://github.com/LuisJa23/foro-alura-challenge/blob/main/diagrama_base_de_datos_forohub.png)


## Tecnologías Utilizadas
- **Spring Framework** - Versión 3.3.1
- **Maven**
- **JDK** - Versión 20
- **Dependencias:**
  - spring-boot-starter-data-jpa
  - spring-boot-starter-security
  - spring-boot-starter-validation
  - spring-boot-starter-web
  - spring-boot-devtools
  - postgresql
  - lombok
  - spring-boot-starter-test
  - spring-security-test
  - java-jwt (versión 4.2.0)
  - springdoc-openapi-starter-webmvc-ui (versión 2.1.0)
 
## Personas Desarrolladoras del Proyecto
- Luis Javier Lopez Galindo https://github.com/LuisJa23

