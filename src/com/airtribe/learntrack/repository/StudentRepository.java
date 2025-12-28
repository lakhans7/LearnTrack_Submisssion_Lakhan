package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing student data in memory
 */
public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    /**
     * Adds a new student to the repository
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Returns all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return copy to prevent external modification
    }

    /**
     * Finds a student by ID
     */
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Returns only active students
     */
    public List<Student> getActiveStudents() {
        List<Student> activeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }
}

