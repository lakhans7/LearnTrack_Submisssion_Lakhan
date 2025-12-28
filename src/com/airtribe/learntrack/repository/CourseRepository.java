package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing course data in memory
 */
public class CourseRepository {
    private List<Course> courses;

    public CourseRepository() {
        this.courses = new ArrayList<>();
    }

    /**
     * Adds a new course to the repository
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Returns all courses
     */
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    /**
     * Finds a course by ID
     */
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    /**
     * Returns only active courses
     */
    public List<Course> getActiveCourses() {
        List<Course> activeCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.isActive()) {
                activeCourses.add(course);
            }
        }
        return activeCourses;
    }
}

