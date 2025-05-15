# Biblioteca API

## Descripción
Este proyecto es una API REST para la gestión de una biblioteca, desarrollada con **Spring Boot**, **Hibernate** y **MySQL**. Implementa operaciones CRUD para autores, libros y préstamos.

## Funcionalidades
✅ Registro de autores, libros y préstamos.  
✅ Relaciones entre entidades mediante JPA.  
✅ Exposición de endpoints REST con Spring Boot.  
✅ Persistencia de datos en MySQL.

## Estado Actual
- Se han implementado **todos los requisitos** de la práctica.
- La aplicación **compila correctamente**, pero al ejecutarla se presenta el siguiente error:
  
cannot find symbol symbol:   method getLibroId() location: variable prestamoDTO of type com.biblioteca.dto.PrestamoDTO

- Se verificó que la clase `PrestamoDTO` **tiene correctamente el atributo `libroId`**, así como la anotación `@Data` de Lombok.
- Queda pendiente revisar posibles problemas de compilación o generación de métodos getter en `PrestamoDTO`.

## Próximos Pasos
1. Revisar la generación automática de getters en `PrestamoDTO`.
2. Probar alternativas como la implementación manual del método `getLibroId()`.
3. Hacer pruebas con **Postman** para validar la funcionalidad de los endpoints.

