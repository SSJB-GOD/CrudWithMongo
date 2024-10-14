## Project Overview
This project is a **CRUD** (Create, Read, Update, Delete) web application for managing students using **Spring Boot** and **MongoDB**. The backend APIs are built with Spring Boot and connected to a MongoDB database to store student information.

---

## Prerequisites

To run this project, ensure you have the following installed on your system:

- **Java Development Kit (JDK) 17 or later**: [Download here](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Apache Maven**: [Download here](https://maven.apache.org/download.cgi)
- **MongoDB** (running locally or on MongoDB Atlas): [Download MongoDB](https://www.mongodb.com/try/download/community) or [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
- **Postman**: [Download here](https://www.postman.com/downloads/)
- **IntelliJ IDEA**: [Download here](https://www.jetbrains.com/idea/download/)

---

## Project Setup Instructions

### 1. Clone the Project Repository

```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Import the Project into IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click `File -> Open` and select the root directory of this project.
3. IntelliJ will automatically detect this as a Maven project. Wait for all dependencies to be downloaded and resolved.

### 3. Configure MongoDB

#### If MongoDB is installed locally:

1. Start MongoDB with the following command:
    ```bash
    mongod
    ```

2. **MongoDB Default Configuration** (inside `src/main/resources/application.properties`):
    ```properties
    spring.data.mongodb.database=studentdb
    spring.data.mongodb.port=27017
    spring.data.mongodb.host=localhost
    ```

#### If you're using MongoDB Atlas:

1. Update the connection string in `application.properties` with your Atlas URI:
    ```properties
    spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/studentdb?retryWrites=true&w=majority
    ```

2. Replace `<username>` and `<password>` with your credentials.

### 4. Run the Application

1. In IntelliJ, go to the `src/main/java/com/jitesh/CrudUsingMongodb/CrudUsingMongodbApplication.java` file.
2. Right-click on the `CrudUsingMongodbApplication.java` class and click `Run`. This will start the Spring Boot server.

   Alternatively, run this command:
   ```bash
   mvn spring-boot:run
   ```

### 5. Verify the MongoDB Schema

MongoDB doesn’t require pre-defined schemas. As soon as you insert your first student document, MongoDB will create the `students` collection inside the `studentdb` database.

You can verify this using the MongoDB shell or MongoDB Compass:

- **MongoDB Shell**:
   ```bash
   use studentdb
   db.students.find()
   ```

- **MongoDB Compass**:
   Open Compass, connect to your local MongoDB instance, and check the `studentdb` database for the `students` collection.

---

## Using Postman to Test the API Endpoints

1. **Open Postman** and set the base URL to `http://localhost:8080`.

### API Endpoints:

#### 1. **Create a new Student (POST)**

**URL**: `POST /api/students`

**Sample Request**:

```json
{
    "name": "Jitesh ",
    "age": 24,
    "email": "jiteshborkar2001@gmail.com"
}
```

**Sample Response**:

```json
"Student with {id} created successfully"
```

#### 2. **Get All Students (GET)**

**URL**: `GET /api/students`

**Sample Response**:

```json
[
    {
        "id": "2",
        "name": "Jitesh Borkar",
        "age": 22,
        "email": "jiteshborkar@example.com"
    }
]
```

#### 3. **Get a Student by ID (GET)**

**URL**: `GET /api/students/{id}`

**Sample Request**: Replace `{id}` with the actual MongoDB `id` of the student, for example:
```
GET /api/students/2
```

#### 4. **Update a Student (PUT)**

**URL**: `PUT /api/students/{id}`

**Sample Request**:

```json
{
    "name": "Jitesh Updated",
    "age": 23,
    "email": "jitesh.updated@gamil.com"
}
```

**Sample Response**:
```
"Student updated successfully."
```

#### 5. **Delete a Student (DELETE)**

**URL**: `DELETE /api/students/{id}`

**Sample Response**:
```
"Student deleted successfully."
```

---

## Key Files and Directories

- `CrudUsingMongodbApplication.java`: Main class to run the Spring Boot application.
- `Students.java`: Model class for student objects.
- `StudentsRepository.java`: Repository interface for MongoDB.
- `StudentsDetails.java`: REST controller defining all the CRUD operations for students.
- `application.properties`: Configuration file for MongoDB settings.

---

## Project Structure

```
src
│
├── main
│   ├── java
│   │   └── com.jitesh.CrudUsingMongodb
│   │       ├── CrudUsingMongodbApplication.java  # Main Application class
│   │       ├── Controllers
│   │       │   └── StudentsDetails.java          # API controller
│   │       ├── Model
│   │       │   └── Students.java                 # Student model class
│   │       └── Repo
│   │           └── StudentsRepository.java       # Repository for MongoDB operations
│   └── resources
│       └── application.properties                # MongoDB configuration
└── test
```

---

## Additional Notes

- **MongoDB Compass**: You can use [MongoDB Compass](https://www.mongodb.com/products/compass) to visually inspect your database.

---

### Common Errors

1. **MongoDB Connection Issues**:
    - Ensure MongoDB is running on port `27017`.
    - If using MongoDB Atlas, ensure your IP is whitelisted.

2. **CORS Issues**:
    - If you encounter CORS issues when testing with Postman or the frontend, ensure that the `@CrossOrigin` annotation is properly set up in the controller:
    ```java
    @CrossOrigin(origins = "http://localhost:3000")
    ```

3. **Database Not Created**:
    - MongoDB doesn't create databases until data is inserted. Ensure that the first POST request inserts data to trigger database creation.

---
