package com.airtribe.learntrack.util;

/**
 * Utility class for generating unique IDs
 * Uses static counters to ensure uniqueness
 */
public class IdGenerator {
    // Static counters - shared across all instances
    private static int studentIdCounter = 1000;
    private static int courseIdCounter = 2000;
    private static int enrollmentIdCounter = 3000;

    // Private constructor to prevent instantiation
    private IdGenerator() {
        // Utility class - no instances needed
    }

    /**
     * Generates the next unique student ID
     */
    public static int getNextStudentId() {
        return studentIdCounter++;
    }

    /**
     * Generates the next unique course ID
     */
    public static int getNextCourseId() {
        return courseIdCounter++;
    }

    /**
     * Generates the next unique enrollment ID
     */
    public static int getNextEnrollmentId() {
        return enrollmentIdCounter++;
    }
}

