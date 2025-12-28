# Design Notes

## Why ArrayList Instead of Array?

We chose **ArrayList** over regular arrays for several important reasons:

### 1. Dynamic Size
- **Arrays** have a fixed size that must be declared at creation time
- **ArrayList** can grow and shrink dynamically as elements are added or removed
- In our system, we don't know how many students, courses, or enrollments will be created beforehand

### 2. Ease of Use
- Arrays require manual size management and index tracking
- ArrayList provides convenient methods like `add()`, `remove()`, `size()`, `isEmpty()`
- Less error-prone - no need to worry about array bounds manually

### 3. Built-in Functionality
- ArrayList comes with many useful methods out of the box
- Easy iteration using enhanced for loops
- Better integration with Java Collections framework

### Example Comparison:
```java
// Array - need to track size manually
Student[] students = new Student[100];
int count = 0;
students[count++] = newStudent; // Manual tracking

// ArrayList - much simpler
List<Student> students = new ArrayList<>();
students.add(newStudent); // Automatic size management
```

### When Arrays Are Better:
- When you know the exact size and it won't change
- Performance-critical code (arrays are slightly faster)
- Working with primitive types in tight loops

For our use case (dynamic data management), ArrayList is the clear choice.

## Where We Used Static Members and Why

### 1. IdGenerator Class
**Static fields:**
```java
private static int studentIdCounter = 1000;
private static int courseIdCounter = 2000;
private static int enrollmentIdCounter = 3000;
```

**Why static?**
- These counters need to be **shared across all instances** of the application
- We want a **single source of truth** for ID generation
- No need to create an instance - we can call `IdGenerator.getNextStudentId()` directly
- Ensures unique IDs even if multiple IdGenerator instances existed (though we prevent instantiation)

**Static methods:**
```java
public static int getNextStudentId()
public static int getNextCourseId()
public static int getNextEnrollmentId()
```

- These methods don't need instance data
- Can be called without creating an object: `IdGenerator.getNextStudentId()`
- More efficient and cleaner API

### 2. InputValidator Class
**Static methods:**
```java
public static boolean isValidString(String input)
public static boolean isValidEmail(String email)
public static int parseInt(String input, int defaultValue)
```

**Why static?**
- These are **utility functions** that don't need instance state
- They operate only on input parameters
- No need to create a validator object - just call `InputValidator.isValidString(str)`
- Follows the utility class pattern

### 3. Constants Classes (MenuOptions, AppConstants)
**Static final fields:**
```java
public static final int ADD_STUDENT = 1;
public static final String APP_NAME = "LearnTrack";
```

**Why static final?**
- Constants that are **shared across the entire application**
- **final** ensures they can't be changed (immutable)
- **static** means they belong to the class, not instances
- Accessed directly: `MenuOptions.ADD_STUDENT`

## Where We Used Inheritance and What We Gained

### Inheritance Hierarchy:
```
Person (base class)
    ↓ extends
Student
```

### What We Gained:

#### 1. Code Reusability
- Common fields (`id`, `firstName`, `lastName`, `email`) are defined once in `Person`
- `Student` inherits these fields without rewriting them
- Reduces code duplication

#### 2. Polymorphism
- We can treat `Student` as a `Person` when needed
- Method overriding allows specialized behavior:
  ```java
  // In Person
  public String getDisplayName() {
      return firstName + " " + lastName;
  }
  
  // In Student (overridden)
  public String getDisplayName() {
      return super.getDisplayName() + " (Batch: " + batch + ")";
  }
  ```

#### 3. Extensibility
- Easy to add new person types (e.g., `Trainer extends Person`)
- All person types share common structure
- Can add person-specific features without modifying base class

#### 4. Maintainability
- Changes to common person attributes only need to be made in `Person` class
- All subclasses automatically benefit from base class improvements

### Example of Polymorphism:
```java
Person person = new Student(1, "John", "Doe", "john@email.com", "Batch2024");
System.out.println(person.getDisplayName()); 
// Calls Student's overridden method, not Person's
```

### Future Extensibility:
We could easily add:
```java
public class Trainer extends Person {
    private String specialization;
    // Inherits id, firstName, lastName, email from Person
    // Can override getDisplayName() for trainer-specific display
}
```

## Design Principles Applied

### 1. Separation of Concerns
- **Entity classes**: Represent data (what it is)
- **Repository classes**: Handle data storage (where it's stored)
- **Service classes**: Contain business logic (what can be done)
- **Main class**: Handles user interaction (how user interacts)

### 2. Encapsulation
- All entity fields are `private`
- Access through `public` getters and setters
- Prevents direct modification and maintains data integrity

### 3. Single Responsibility
- Each class has one clear purpose
- `IdGenerator` only generates IDs
- `InputValidator` only validates input
- Services handle specific business domains

### 4. DRY (Don't Repeat Yourself)
- Common code extracted to base classes or utility methods
- Reusable validation logic in `InputValidator`
- Shared ID generation in `IdGenerator`

