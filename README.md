# LearnTrack - Student & Course Management System
#
## Project Description

LearnTrack is a console-based Student & Course Management System built using Core Java. It allows administrators to manage students, courses, and enrollments through a menu-driven interface.

### Features

- **Student Management**
  - Add new students
  - View all students
  - Search student by ID
  - Deactivate students (soft delete)

- **Course Management**
  - Add new courses
  - View all courses
  - Activate/Deactivate courses

- **Enrollment Management**
  - Enroll students in courses
  - View student enrollments
  - Update enrollment status (ACTIVE, COMPLETED, CANCELLED)

## How to Compile and Run

### Prerequisites
- Java JDK 8 or higher installed
- Command line terminal (Command Prompt, PowerShell, or Terminal)

### Compilation

1. Navigate to the project root directory:
```bash
cd LearnTrack_Submisssion_Lakhan
```

2. Compile all Java files:
```bash
javac -d bin src/com/airtribe/learntrack/**/*.java src/com/airtribe/learntrack/*.java
```

Or on Windows PowerShell:
```powershell
javac -d bin -sourcepath src src/com/airtribe/learntrack/**/*.java src/com/airtribe/learntrack/*.java
```

Alternatively, compile from the src directory:
```bash
cd src
javac com/airtribe/learntrack/**/*.java com/airtribe/learntrack/*.java
```

### Running the Application

From the project root:
```bash
java -cp bin com.airtribe.learntrack.Main
```

Or if compiled from src directory:
```bash
java -cp src com.airtribe.learntrack.Main
```

### Using an IDE

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)
2. Set `src` as the source root
3. Run the `Main.java` file directly from the IDE

## Class Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                         Main.java                                │
│                    (Application Entry Point)                    │
└────────────────────────────┬────────────────────────────────────┘
                             │
                             │ uses
                             ▼
        ┌────────────────────────────────────────────┐
        │         Service Layer                       │
        ├────────────────────────────────────────────┤
        │  StudentService    CourseService            │
        │  EnrollmentService                          │
        └────────────┬───────────────────┬───────────┘
                     │                   │
                     │ uses              │ uses
                     ▼                   ▼
        ┌──────────────────────┐  ┌──────────────────────┐
        │  Repository Layer    │  │    Utility Classes   │
        ├──────────────────────┤  ├──────────────────────┤
        │ StudentRepository    │  │ IdGenerator          │
        │ CourseRepository     │  │ InputValidator       │
        │ EnrollmentRepository │  └──────────────────────┘
        └────────────┬─────────┘
                     │
                     │ stores
                     ▼
        ┌────────────────────────────────────────────┐
        │         Entity Layer                       │
        ├────────────────────────────────────────────┤
        │  Person (base class)                       │
        │      ▲                                     │
        │      │ extends                             │
        │  Student                                   │
        │                                            │
        │  Course                                    │
        │  Enrollment                                │
        └────────────────────────────────────────────┘
                     │
                     │ uses
                     ▼
        ┌────────────────────────────────────────────┐
        │         Enums & Constants                  │
        ├────────────────────────────────────────────┤
        │  EnrollmentStatus                          │
        │  CourseStatus                              │
        │  MenuOptions                               │
        │  AppConstants                              │
        └────────────────────────────────────────────┘
                     │
                     │ throws
                     ▼
        ┌────────────────────────────────────────────┐
        │         Exception Layer                    │
        ├────────────────────────────────────────────┤
        │  EntityNotFoundException                   │
        │  InvalidInputException                     │
        └────────────────────────────────────────────┘
```

### Key Relationships

- **Main** orchestrates the application flow and handles user interaction
- **Services** contain business logic and coordinate between repositories
- **Repositories** manage in-memory data storage using ArrayList
- **Entities** represent domain objects (Student extends Person, Course, Enrollment)
- **Utilities** provide helper functions (ID generation, input validation)
- **Exceptions** handle error scenarios gracefully

## Project Structure

```
LearnTrack_Submisssion_Lakhan/
├── src/
│   └── com/
│       └── airtribe/
│           └── learntrack/
│               ├── Main.java
│               ├── entity/
│               │   ├── Person.java
│               │   ├── Student.java
│               │   ├── Course.java
│               │   └── Enrollment.java
│               ├── repository/
│               │   ├── StudentRepository.java
│               │   ├── CourseRepository.java
│               │   └── EnrollmentRepository.java
│               ├── service/
│               │   ├── StudentService.java
│               │   ├── CourseService.java
│               │   └── EnrollmentService.java
│               ├── exception/
│               │   ├── EntityNotFoundException.java
│               │   └── InvalidInputException.java
│               ├── util/
│               │   ├── IdGenerator.java
│               │   └── InputValidator.java
│               ├── constants/
│               │   ├── MenuOptions.java
│               │   └── AppConstants.java
│               └── enums/
│                   ├── EnrollmentStatus.java
│                   └── CourseStatus.java
└── docs/
    ├── Setup_Instructions.md
    ├── JVM_Basics.md
    └── Design_Notes.md
```

## Technologies Used

- Java (Core Java)
- JDK 8+ (Java Development Kit)

## Author

Lakhan

## License

This project is created for educational purposes as part of the AirTribe learning program.

