package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing enrollment data in memory
 */
public class EnrollmentRepository {
    private List<Enrollment> enrollments;

    public EnrollmentRepository() {
        this.enrollments = new ArrayList<>();
    }

    /**
     * Adds a new enrollment
     */
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    /**
     * Returns all enrollments
     */
    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }

    /**
     * Finds enrollment by ID
     */
    public Enrollment findById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    /**
     * Finds all enrollments for a specific student
     */
    public List<Enrollment> findByStudentId(int studentId) {
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }

    /**
     * Finds all enrollments for a specific course
     */
    public List<Enrollment> findByCourseId(int courseId) {
        List<Enrollment> courseEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId() == courseId) {
                courseEnrollments.add(enrollment);
            }
        }
        return courseEnrollments;
    }
}

