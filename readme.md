# 🧾 Lab Assignment 2 — Student Management System (Java)

## 📘 Overview
This project implements a **Student Management System** using advanced **Object-Oriented Programming principles**.  
It demonstrates **inheritance, abstract classes, interfaces, method overriding, method overloading, and polymorphism**.

The user can:
- Add student records
- Update student details
- Delete records
- Search students by roll number
- View all stored students

---

## 🧠 Concepts Demonstrated

### 🔹 Abstract Class
**Person**
- Common student attributes: name, email
- Abstract method: `displayInfo()`

### 🔹 Inheritance
**Student extends Person**
- Adds rollNo, course, marks, grade
- Overrides the parent `displayInfo()` method

### 🔹 Interface
**RecordActions**
- Defines CRUD operations:
  - `addStudent()`
  - `deleteStudent()`
  - `updateStudent()`
  - `searchStudent()`
  - `viewAllStudents()`

### 🔹 Implementation Class
**StudentManager (implements RecordActions)**
- Stores student records
- Prevents duplicate roll numbers
- Performs all CRUD actions

### 🔹 Polymorphism
- **Method Overriding** → Student’s `displayInfo()`
- **Method Overloading** → Multiple display methods

---

## 🏗️ Class Design Summary

### 1️⃣ Person (abstract)
Fields:
- name
- email

Method:
- `displayInfo()` — abstract

---

### 2️⃣ Student (child class)
Fields:
- rollNo
- course
- marks
- grade

Methods:
- `displayInfo()` — override
- `displayInfo(extra)` — overloaded
- `calculateGrade()`

---

### 3️⃣ RecordActions (interface)
Defines:
- addStudent
- deleteStudent
- updateStudent
- searchStudent
- viewAllStudents

---

### 4️⃣ StudentManager
Handles:
- Data storage (ArrayList or HashMap)
- CRUD operations
- Duplicate roll check

--
