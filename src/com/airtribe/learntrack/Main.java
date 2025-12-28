package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;
import java.util.Scanner;

/**
 * Main entry point for LearnTrack application
 * Console-based menu-driven Student & Course Management System
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService;
    private static CourseService courseService;
    private static EnrollmentService enrollmentService;

    public static void main(String[] args) {
        // Initialize repositories and services
        initializeServices();
        
        System.out.println("========================================");
        System.out.println("  Welcome to " + AppConstants.APP_NAME + " v" + AppConstants.VERSION);
        System.out.println("  Student & Course Management System");
        System.out.println("========================================\n");

        // Main menu loop
        boolean running = true;
        while (running) {
            showMainMenu();
            try {
                String input = scanner.nextLine().trim();
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case MenuOptions.STUDENT_MANAGEMENT:
                        handleStudentMenu();
                        break;
                    case MenuOptions.COURSE_MANAGEMENT:
                        handleCourseMenu();
                        break;
                    case MenuOptions.ENROLLMENT_MANAGEMENT:
                        handleEnrollmentMenu();
                        break;
                    case MenuOptions.EXIT:
                        System.out.println("\nThank you for using LearnTrack! Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println(AppConstants.INVALID_OPTION);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    /**
     * Initialize all repositories and services
     */
    private static void initializeServices() {
        StudentRepository studentRepo = new StudentRepository();
        CourseRepository courseRepo = new CourseRepository();
        EnrollmentRepository enrollmentRepo = new EnrollmentRepository();
        
        studentService = new StudentService(studentRepo);
        courseService = new CourseService(courseRepo);
        enrollmentService = new EnrollmentService(enrollmentRepo, studentService, courseService);
    }

    /**
     * Display main menu
     */
    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handle student management menu
     */
    private static void handleStudentMenu() {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case MenuOptions.ADD_STUDENT:
                        addStudent();
                        break;
                    case MenuOptions.VIEW_ALL_STUDENTS:
                        viewAllStudents();
                        break;
                    case MenuOptions.SEARCH_STUDENT:
                        searchStudent();
                        break;
                    case MenuOptions.DEACTIVATE_STUDENT:
                        deactivateStudent();
                        break;
                    case MenuOptions.BACK_TO_MAIN:
                        backToMain = true;
                        break;
                    default:
                        System.out.println(AppConstants.INVALID_OPTION);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Handle course management menu
     */
    private static void handleCourseMenu() {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add New Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Activate/Deactivate Course");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case MenuOptions.ADD_COURSE:
                        addCourse();
                        break;
                    case MenuOptions.VIEW_ALL_COURSES:
                        viewAllCourses();
                        break;
                    case MenuOptions.TOGGLE_COURSE_STATUS:
                        toggleCourseStatus();
                        break;
                    case MenuOptions.BACK_TO_MAIN_COURSE:
                        backToMain = true;
                        break;
                    default:
                        System.out.println(AppConstants.INVALID_OPTION);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Handle enrollment management menu
     */
    private static void handleEnrollmentMenu() {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Student Enrollments");
            System.out.println("3. Update Enrollment Status");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case MenuOptions.ENROLL_STUDENT:
                        enrollStudent();
                        break;
                    case MenuOptions.VIEW_STUDENT_ENROLLMENTS:
                        viewStudentEnrollments();
                        break;
                    case MenuOptions.UPDATE_ENROLLMENT_STATUS:
                        updateEnrollmentStatus();
                        break;
                    case MenuOptions.BACK_TO_MAIN_ENROLLMENT:
                        backToMain = true;
                        break;
                    default:
                        System.out.println(AppConstants.INVALID_OPTION);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Student operations
    private static void addStudent() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        
        System.out.print("Enter email (optional, press Enter to skip): ");
        String email = scanner.nextLine().trim();
        
        System.out.print("Enter batch: ");
        String batch = scanner.nextLine().trim();

        if (!InputValidator.isValidString(firstName) || !InputValidator.isValidString(lastName) 
                || !InputValidator.isValidString(batch)) {
            System.out.println("Error: First name, last name, and batch are required.");
            return;
        }

        Student student;
        if (email.isEmpty()) {
            student = studentService.addStudent(firstName, lastName, batch);
        } else {
            student = studentService.addStudent(firstName, lastName, email, batch);
        }
        
        System.out.println("Student added successfully! ID: " + student.getId());
    }

    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println("\n--- All Students ---");
        System.out.println(String.format("%-5s %-15s %-15s %-25s %-10s %-8s", 
                "ID", "First Name", "Last Name", "Email", "Batch", "Active"));
        System.out.println("--------------------------------------------------------------------------------");
        for (Student student : students) {
            System.out.println(String.format("%-5d %-15s %-15s %-25s %-10s %-8s",
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail() != null ? student.getEmail() : "N/A",
                    student.getBatch(),
                    student.isActive() ? "Yes" : "No"));
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID: ");
        String input = scanner.nextLine().trim();
        
        if (!InputValidator.isValidInteger(input)) {
            System.out.println("Invalid student ID.");
            return;
        }

        try {
            int id = Integer.parseInt(input);
            Student student = studentService.findStudentById(id);
            System.out.println("\n--- Student Details ---");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getDisplayName());
            System.out.println("Email: " + (student.getEmail() != null ? student.getEmail() : "N/A"));
            System.out.println("Batch: " + student.getBatch());
            System.out.println("Active: " + (student.isActive() ? "Yes" : "No"));
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deactivateStudent() {
        System.out.print("Enter student ID to deactivate: ");
        String input = scanner.nextLine().trim();
        
        if (!InputValidator.isValidInteger(input)) {
            System.out.println("Invalid student ID.");
            return;
        }

        try {
            int id = Integer.parseInt(input);
            studentService.deactivateStudent(id);
            System.out.println("Student deactivated successfully!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Course operations
    private static void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine().trim();
        
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        
        System.out.print("Enter duration in weeks: ");
        String durationInput = scanner.nextLine().trim();

        if (!InputValidator.isValidString(courseName) || !InputValidator.isValidString(description)) {
            System.out.println("Error: Course name and description are required.");
            return;
        }

        if (!InputValidator.isValidInteger(durationInput)) {
            System.out.println("Error: Invalid duration. Please enter a number.");
            return;
        }

        int duration = Integer.parseInt(durationInput);
        Course course = courseService.addCourse(courseName, description, duration);
        System.out.println("Course added successfully! ID: " + course.getId());
    }

    private static void viewAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        
        System.out.println("\n--- All Courses ---");
        System.out.println(String.format("%-5s %-20s %-30s %-10s %-10s",
                "ID", "Course Name", "Description", "Duration", "Status"));
        System.out.println("--------------------------------------------------------------------------------");
        for (Course course : courses) {
            System.out.println(String.format("%-5d %-20s %-30s %-10d %-10s",
                    course.getId(),
                    course.getCourseName(),
                    course.getDescription().length() > 28 ? 
                        course.getDescription().substring(0, 28) + ".." : course.getDescription(),
                    course.getDurationInWeeks(),
                    course.getStatus()));
        }
    }

    private static void toggleCourseStatus() {
        System.out.print("Enter course ID: ");
        String input = scanner.nextLine().trim();
        
        if (!InputValidator.isValidInteger(input)) {
            System.out.println("Invalid course ID.");
            return;
        }

        try {
            int id = Integer.parseInt(input);
            courseService.toggleCourseStatus(id);
            Course course = courseService.findCourseById(id);
            System.out.println("Course status updated to: " + course.getStatus());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Enrollment operations
    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentInput = scanner.nextLine().trim();
        
        System.out.print("Enter course ID: ");
        String courseInput = scanner.nextLine().trim();

        if (!InputValidator.isValidInteger(studentInput) || !InputValidator.isValidInteger(courseInput)) {
            System.out.println("Invalid student ID or course ID.");
            return;
        }

        try {
            int studentId = Integer.parseInt(studentInput);
            int courseId = Integer.parseInt(courseInput);
            Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
            System.out.println("Student enrolled successfully! Enrollment ID: " + enrollment.getId());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewStudentEnrollments() {
        System.out.print("Enter student ID: ");
        String input = scanner.nextLine().trim();
        
        if (!InputValidator.isValidInteger(input)) {
            System.out.println("Invalid student ID.");
            return;
        }

        try {
            int studentId = Integer.parseInt(input);
            List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
            
            if (enrollments.isEmpty()) {
                System.out.println("No enrollments found for this student.");
                return;
            }
            
            System.out.println("\n--- Student Enrollments ---");
            System.out.println(String.format("%-5s %-10s %-10s %-15s %-12s",
                    "ID", "Student ID", "Course ID", "Enrollment Date", "Status"));
            System.out.println("--------------------------------------------------------------------------------");
            for (Enrollment enrollment : enrollments) {
                System.out.println(String.format("%-5d %-10d %-10d %-15s %-12s",
                        enrollment.getId(),
                        enrollment.getStudentId(),
                        enrollment.getCourseId(),
                        enrollment.getEnrollmentDate(),
                        enrollment.getStatus()));
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateEnrollmentStatus() {
        System.out.print("Enter enrollment ID: ");
        String enrollmentInput = scanner.nextLine().trim();
        
        System.out.println("Select new status:");
        System.out.println("1. ACTIVE");
        System.out.println("2. COMPLETED");
        System.out.println("3. CANCELLED");
        System.out.print("Enter choice: ");
        String statusInput = scanner.nextLine().trim();

        if (!InputValidator.isValidInteger(enrollmentInput) || !InputValidator.isValidInteger(statusInput)) {
            System.out.println("Invalid input.");
            return;
        }

        try {
            int enrollmentId = Integer.parseInt(enrollmentInput);
            int statusChoice = Integer.parseInt(statusInput);
            
            EnrollmentStatus newStatus;
            switch (statusChoice) {
                case 1:
                    newStatus = EnrollmentStatus.ACTIVE;
                    break;
                case 2:
                    newStatus = EnrollmentStatus.COMPLETED;
                    break;
                case 3:
                    newStatus = EnrollmentStatus.CANCELLED;
                    break;
                default:
                    System.out.println("Invalid status choice.");
                    return;
            }
            
            enrollmentService.updateEnrollmentStatus(enrollmentId, newStatus);
            System.out.println("Enrollment status updated successfully!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

