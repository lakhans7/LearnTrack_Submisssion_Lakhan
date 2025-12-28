package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import java.time.LocalDate;
import java.util.List;

/**
 * Service class for enrollment-related business logic
 */
public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, 
                            StudentService studentService, 
                            CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    /**
     * Enrolls a student in a course
     */
    public Enrollment enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
        // Validate that student and course exist
        studentService.findStudentById(studentId);
        courseService.findCourseById(courseId);

        int enrollmentId = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, LocalDate.now());
        enrollmentRepository.addEnrollment(enrollment);
        return enrollment;
    }

    /**
     * Gets all enrollments for a specific student
     */
    public List<Enrollment> getEnrollmentsByStudent(int studentId) throws EntityNotFoundException {
        // Validate student exists
        studentService.findStudentById(studentId);
        return enrollmentRepository.findByStudentId(studentId);
    }

    /**
     * Updates enrollment status
     */
    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus newStatus) 
            throws EntityNotFoundException {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment", enrollmentId);
        }
        enrollment.setStatus(newStatus);
    }

    /**
     * Marks enrollment as completed
     */
    public void markEnrollmentCompleted(int enrollmentId) throws EntityNotFoundException {
        updateEnrollmentStatus(enrollmentId, EnrollmentStatus.COMPLETED);
    }

    /**
     * Marks enrollment as cancelled
     */
    public void markEnrollmentCancelled(int enrollmentId) throws EntityNotFoundException {
        updateEnrollmentStatus(enrollmentId, EnrollmentStatus.CANCELLED);
    }

    /**
     * Returns all enrollments
     */
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }
}

