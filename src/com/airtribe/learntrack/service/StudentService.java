package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.List;

/**
 * Service class for student-related business logic
 */
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Adds a new student
     */
    public Student addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.addStudent(student);
        return student;
    }

    /**
     * Overloaded method - add student without email
     */
    public Student addStudent(String firstName, String lastName, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, batch);
        studentRepository.addStudent(student);
        return student;
    }

    /**
     * Returns all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    /**
     * Finds a student by ID, throws exception if not found
     */
    public Student findStudentById(int id) throws EntityNotFoundException {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student", id);
        }
        return student;
    }

    /**
     * Deactivates a student (soft delete)
     */
    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setActive(false);
    }

    /**
     * Returns only active students
     */
    public List<Student> getActiveStudents() {
        return studentRepository.getActiveStudents();
    }
}

