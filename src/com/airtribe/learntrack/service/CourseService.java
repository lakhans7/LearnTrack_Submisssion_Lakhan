package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.List;

/**
 * Service class for course-related business logic
 */
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Adds a new course
     */
    public Course addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, courseName, description, durationInWeeks);
        courseRepository.addCourse(course);
        return course;
    }

    /**
     * Returns all courses
     */
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    /**
     * Finds a course by ID
     */
    public Course findCourseById(int id) throws EntityNotFoundException {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course", id);
        }
        return course;
    }

    /**
     * Toggles course status between ACTIVE and INACTIVE
     */
    public void toggleCourseStatus(int id) throws EntityNotFoundException {
        Course course = findCourseById(id);
        if (course.getStatus() == CourseStatus.ACTIVE) {
            course.setStatus(CourseStatus.INACTIVE);
        } else {
            course.setStatus(CourseStatus.ACTIVE);
        }
    }

    /**
     * Returns only active courses
     */
    public List<Course> getActiveCourses() {
        return courseRepository.getActiveCourses();
    }
}

