# Gestor Deportivo - Spring Sport Flow 🏋️‍♂️⚽🏀

Plataforma para la gestión integral de equipos, deportistas y competiciones. Diseñada para proporcionar herramientas de
organización, administración de torneos y estadísticas para clubes e instituciones deportivas.

---

## Descripción General 📖

**Spring Sport Flow** es una aplicación backend desarrollada con una arquitectura robusta y flexible utilizando **Spring
Boot**, enfocada en la gestión deportiva.

### ¡Qué puedes hacer! 🚀

- **Gestión de deportistas**: Crear, modificar y eliminar jugadores.
- **Administración de equipos**: Añadir o quitar miembros y gestionar equipos de manera eficiente.
- **Organización de torneos**: Crear, actualizar, eliminar y planificar torneos y partidos.
- **Acceso Seguro**: Implementación de autenticación mediante **JWT (Json Web Tokens)** y autorización basada en roles y
  permisos con **Spring Security**.
- **Interfaz RESTful**: API para interactuar de forma automática con el sistema.
- **Actuator**: Probar endpoints de la aplicación y monitorear su estado en tiempo real.

---

## Tecnologías Utilizadas 🛠️

### Core

- **Java 21**: Base del proyecto.
- **Spring Boot 3.4.0**: Framework principal de desarrollo.
    - *Spring Security*: Control de autenticación/roles.
    - *Spring Data JPA*: Gestión de bases de datos.
    - *Spring Web*: Creación de endpoints RESTful.
    - *Spring Boot Actuator*: Monitorización de la aplicación.

### Base de Datos

- **PostgreSQL**: Sistema de gestión relacional para almacenar datos estructurados.

### Dependencias clave

- **Hibernate**: Relación robusta ORM mediante JPA.
- **Lombok**: Reducción de código repetitivo.
- **JSON Web Token (JWT)**: Seguridad de autenticación.
- **MapStruct**: Mappeo eficiente de DTOs.
- **Test automatizados**: Spring Boot Starter Test y Spring Security Test.

### Gestión del proyecto

- **Maven**: Coordinación de dependencias y compilación.

### Infraestructura

- **Docker Compose**: Contenedores para facilitar la configuración y despliegue de la aplicación.

---

## Instalación 🚀

La manera más rápida y sencilla de arrancar el proyecto es mediante **Docker Compose**. Sigue los pasos:

### Instalación con Docker Compose 🐳

1. Asegúrate de tener Docker y Docker Compose instalados.
2. Construye y levanta los contenedores:

   ```bash
   docker-compose up --build
   ```

   En caso de error durante la inicialización, descomenta las siguientes líneas en el archivo `create_schema.sql` para
   eliminar la base de datos previa y volver a intentar:

   ```postgresql
   \c postgres;
   DROP DATABASE sportflow_db;
   ```

3. Una vez listo, accede a los servicios disponibles:
    - **API REST**: [http://localhost:8080](http://localhost:8080).
    - **Actuator** para monitorear y probar los endpoints
      en [http://localhost:8080/actuator](http://localhost:8080/actuator).
    - **Base de Datos PostgreSQL**: Puerto `5432`.

---

### Instalación Manual (Opcional) 💻

Si prefieres no trabajar con Docker, puedes seguir estos pasos:

1. Clona este repositorio:

   ```bash
   git clone https://github.com/javierdesant/spring-sport-flow.git
   cd spring-sport-flow
   ```

2. Instala **Java 21** o superior y verifica la versión instalada:

   ```bash
   java -version
   ```

3. Instala las dependencias y compila el proyecto con Maven:

   ```bash
   mvn clean install
   ```

4. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

5. Accede a la aplicación en **[http://localhost:8080](http://localhost:8080)**.

---

## Estructura del Proyecto 🗂️

```plaintext
spring-sport-flow/
│
├── db/                         # Archivos relacionados con la base de datos
│   ├── design/                 # Modelado, diagramas o diseños de base de datos
│   └── sql/                    # Scripts SQL para la base de datos
│
├── docs/                       # Documentación del proyecto
│
└── src/
    ├── main/
    │   ├── java/com/javierdesant/spring_sport_flow/
    │   │   ├── api/            # Interfaces RESTful y DTOs
    │   │   │   ├── dto/        # Objetos de Transferencia de Datos (DTOs)
    │   │   │   │   ├── auth/
    │   │   │   │   ├── mappers/
    │   │   │   │   ├── requests/
    │   │   │   │   ├── responses/
    │   │   │   │   └── validation/
    │   │   ├── domain/         # Entidades principales y repositorios
    │   │   │   ├── entities/  # Modelos o entidades del dominio
    │   │   │   └── repositories/ # Interfaces JPA o repositorios
    │   │   ├── infrastructure/ # Implementaciones de bajo nivel
    │   │   │   ├── config/     # Configuración general de Spring Boot
    │   │   │   │   └── security/
    │   │   │   │       └── filter/ # Filtros relacionados con la seguridad/JWT
    │   │   │   ├── controllers/ # Controladores RESTful
    │   │   │   └── services/   # Lógica de negocio y servicios
    │   │   │       ├── exceptions/ # Excepciones específicas de negocio
    │   │   │       └── internal/   # Métodos o servicios internos
    │   │   └── utils/          # Utilidades compartidas
    │   └── resources/          # Configuración y recursos de la aplicación
    └── test/
        └── java/com/javierdesant/spring_sport_flow/ 
```

---

## Seguridad 🔒

Para el control y acceso seguro:

- **Filtros JWT** para verificación de autenticación.
- **Roles y permisos personalizados (RolePermission.java)**: Control granular sobre acciones específicas.
- **Endpoints Excluidos**:
    - `GET /tournaments/**`
    - `POST /auth/authenticate`

---

## Próximas Funcionalidades 🚧

1. Continuar el desarrollo del **frontend** del proyecto, actualmente alojado en *
   *[Spring Sport Flow Frontend](https://github.com/javierdesant/Spring-Sport-Flow-fe)**.
2. Añadir soporte para exportar informes en formatos **PDF/Excel**.
3. Integración con servicios de correo para notificaciones.
4. Ampliar endpoints públicos y mejorar la escalabilidad en entornos con autenticación.

---

## Créditos ✍️

Desarrollado y mantenido por **Javier de Santiago**.

- **Email**: [javier.desantiago@alumnos.upm.es](mailto:javier.desantiago@alumnos.upm.es)
- **GitHub**: [Visítame aquí](https://github.com/javierdesant)

### Profesor

- Luis Fernández Muñoz