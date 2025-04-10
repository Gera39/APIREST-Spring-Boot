# APIREST-Spring-Boot

# 🏋️‍♂️ Gym Membership API - Spring Boot + JWT

API REST construida con Spring Boot para gestionar usuarios y sus membresías en un gimnasio. Este proyecto incluye autenticación y autorización mediante JWT usando Spring Security.

## 📋 Características

- ✅ CRUD de usuarios
- ✅ CRUD de membresías
- ✅ Relación entre usuarios y membresías
- ✅ Autenticación con JSON Web Tokens (JWT)
- ✅ Seguridad con Spring Security
- ✅ Arquitectura RESTful
- ✅ Manejo de excepciones personalizado
- ✅ Validaciones con Bean Validation



## 📂 Estructura del proyecto
src/

├── main/

│   ├── java/

│   │   └── com.example.gymapi/

│   │       ├── controllers/

│   │       ├── models/

│   │       ├── repositories/

│   │       ├── services/

│   │       ├── security/

│   │       └── GymApiApplication.java

│   └── resources/

│       └── application.properties


## TODO 
- ✅ Seguridad con JWT  
- ✅ CRUD de usuarios  
- ✅ CRUD de membresías  
- [ ] Documentación con Swagger  
- [ ] Implementar roles (admin/usuario)  


## 🔐 Autenticación

Se utiliza **JWT** para proteger los endpoints. Los usuarios deben autenticarse para obtener un token, el cual deben enviar en el header:


Authorization: Bearer <token>

### 🔑 Ejemplo de flujo de autenticación:

1. **Login (obtener token)**

POST /api/v1/auth/login Content-Type: application/json

{
 "username": "usuario1",
 "password": "contraseña123" 
}


2. **Respuesta:**

json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

3. **Usar token para acceder a recursos protegidos**

## 📌 Endpoints de la API

### 🔐 Autenticación

| Método | Endpoint             | Descripción                      |
|--------|----------------------|----------------------------------|
| POST   | `/api/auth/register` | Registro de nuevo usuario        |
| POST   | `/api/auth/login`    | Autenticación y generación JWT   |

---

### 👤 Usuarios

| Método | Endpoint            | Descripción                       |
|--------|---------------------|-----------------------------------|
| GET    | `/api/users`        | Listar todos los usuarios         |
| GET    | `/api/users/{id}`   | Obtener usuario por ID            |
| POST   | `/api/users`        | Crear nuevo usuario               |
| PUT    | `/api/users/{id}`   | Actualizar usuario                |
| DELETE | `/api/users/{id}`   | Eliminar usuario                  |

---

### 💳 Membresías

| Método | Endpoint                 | Descripción                           |
|--------|--------------------------|---------------------------------------|
| GET    | `/api/memberships`       | Listar todas las membresías           |
| GET    | `/api/memberships/{id}`  | Obtener membresía por ID              |
| POST   | `/api/memberships`       | Crear nueva membresía                 |
| PUT    | `/api/memberships/{id}`  | Actualizar membresía                  |
| DELETE | `/api/memberships/{id}`  | Eliminar membresía                    |




## 🛠️ Tecnologías utilizadas
Java 21

Spring Boot

Spring Security

JWT (jjwt)

Spring Data JPA (Hibernate)

MySQL

Maven

