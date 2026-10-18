# Batch & Student Management System (JPA / Hibernate Many-to-Many Unidirectional)

A Java application demonstrating **Many-to-Many Unidirectional Mapping** between `Batch` and `Student` entities using **JPA (Java Persistence API)** and **Hibernate ORM**.

## 📌 Project Overview

In this unidirectional design:
* **`Batch` Entity:** Actively manages the association to multiple `Student` instances using `@ManyToMany(cascade = CascadeType.ALL)`.
* **`Student` Entity:** Operates as an independent entity with no inverse reference back to `Batch`.

This setup allows seamless creation, deletion, and query operations on batches and their associated students without needing explicit inverse mapping handling.

## 🛠️ Tech Stack & Prerequisites

* **Language:** Java (JDK 8 or higher)
* **Framework:** JPA 2.0+ / Hibernate ORM
* **Query Language:** JPQL (Java Persistence Query Language)
* **Persistence Management:** `EntityManager` & `EntityManagerFactory`
* **Database:** MySQL / PostgreSQL / Oracle (or any standard RDBMS)

## 📂 Repository File Structure

```
src/
└── org/jsp/manytomanyuni/
    ├── Batch.java                            # Entity managing Many-to-Many mapping
    ├── Student.java                          # Independent Student Entity
    ├── InsertData.java                       # Main class to seed batches and students
    │
    ├── Batch Lookups:
    │   ├── FindBatchById.java                # Lookup Batch by Primary Key ID
    │   ├── FindBatchByBatchCode.java         # Lookup Batch by unique Batch Code
    │   ├── FindBatchBySubject.java           # Lookup Batch by Subject
    │   └── FindBatchByTrainerName.java       # Lookup Batch by Trainer Name
    │
    └── Student Lookups & Filters:
        ├── FindStudentById.java              # Lookup Student by Primary Key ID
        ├── FindStudentByName.java            # Lookup Student(s) by Name
        ├── FindStudentByBatchId.java         # Fetch Students belonging to a Batch ID
        ├── FindStudentByBatchCode.java       # Fetch Students belonging to a Batch Code
        ├── FindStudentWhosePerMore60.java    # Query Students with Percentage >= 60%
        └── FilterStudentBetweenPercentRange.java # Query Students within custom percentage range
```

## ⚙️ JPA Configuration (`persistence.xml`)

Place this file in `src/META-INF/persistence.xml` configured with the persistence unit name `"M15"`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                                 http://xmlns.jcp.org/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="M15">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        
        <!-- Entity Classes -->
        <class>org.jsp.manytomanyuni.Batch</class>
        <class>org.jsp.manytomanyuni.Student</class>

        <properties>
            <!-- Database Connection Details -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/your_database" />
            <property name="javax.persistence.jdbc.user" value="your_username" />
            <property name="javax.persistence.jdbc.password" value="your_password" />

            <!-- Hibernate Settings -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
        </properties>
    </persistence-unit>
</persistence>
```

## 📊 Database Schema Summary

### `Batch` Table

| Column Name | Data Type | Description |
| :--- | :--- | :--- |
| `id` | `INT` | Primary Key (`AUTO_INCREMENT`) |
| `batchCode` | `VARCHAR` | Unique Batch Identifier |
| `subject` | `VARCHAR` | Subject Name |
| `trainer` | `VARCHAR` | Trainer Name |

### `Student` Table

| Column Name | Data Type | Description |
| :--- | :--- | :--- |
| `id` | `INT` | Primary Key (`AUTO_INCREMENT`) |
| `name` | `VARCHAR` | Student Name |
| `phone` | `BIGINT` | Mobile Number |
| `marks` | `DOUBLE` | Student Marks / Percentage |

### `Batch_Student` (Join Table)

| Column Name | References |
| :--- | :--- |
| `Batch_id` | Foreign Key to `Batch(id)` |
| `std_id` | Foreign Key to `Student(id)` |

## 🚀 Getting Started

1. **Database Setup:** Ensure your target relational database is running and update credentials in `persistence.xml`.
2. **Seed Initial Data:** Run `org.jsp.manytomanyuni.InsertData` to populate sample batches and students.
3. **Run Query Utilities:** Execute any of the lookup or filter classes (`FindBatchById`, `FindStudentByBatchCode`, `FilterStudentBetweenPercentRange`, etc.) to interact with the database via console prompts.
