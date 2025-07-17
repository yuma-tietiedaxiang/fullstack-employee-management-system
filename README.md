# fullstack-employee-management-system
Full-stack employee management system built with Java, Spring Boot, MySQL, and React. Simulates a modular ERP component with CRUD operations, RESTful APIs, and responsive UI.

## 🚀 Tech Stack

### Backend
- Java 17
- Spring Boot 3.5.0
- RESTful API
- MySQL
- Maven

### Frontend
- React 19
- React Router DOM
- Bootstrap 5
- Axios
- Vite
- ESLint

---

## 🛠️ Getting Started

1. Clone the Repository

2. Backend Setup (`ems-backend`)

   - Prerequisites

     - Java 17

     - MySQL

   - Steps

     - Create MySQL database: 

       `CREATE DATABASE ems_db;`

     - Configure DB connection in `ems-backend/src/main/resources/application.properties`:

       ```
       spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
       spring.datasource.username=your_username
       spring.datasource.password=your_password
       ```

     - Run backend server:

       ```
       cd ems-backend
       mvn spring-boot:run
       ```

   3. Frontend Setup (`ems-frontend-react`)

      - Prerequisites

        - Node.js & npm

      - Steps

        ```
        cd ems-frontend-react/ems-frontend
        npm install
        npm run dev
        ```

        Visit: http://localhost:5173
