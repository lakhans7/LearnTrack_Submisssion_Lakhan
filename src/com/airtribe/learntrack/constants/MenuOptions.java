package com.airtribe.learntrack.constants;

/**
 * Constants for menu options
 */
public class MenuOptions {
    // Student menu options
    public static final int ADD_STUDENT = 1;
    public static final int VIEW_ALL_STUDENTS = 2;
    public static final int SEARCH_STUDENT = 3;
    public static final int DEACTIVATE_STUDENT = 4;
    public static final int BACK_TO_MAIN = 5;

    // Course menu options
    public static final int ADD_COURSE = 1;
    public static final int VIEW_ALL_COURSES = 2;
    public static final int TOGGLE_COURSE_STATUS = 3;
    public static final int BACK_TO_MAIN_COURSE = 4;

    // Enrollment menu options
    public static final int ENROLL_STUDENT = 1;
    public static final int VIEW_STUDENT_ENROLLMENTS = 2;
    public static final int UPDATE_ENROLLMENT_STATUS = 3;
    public static final int BACK_TO_MAIN_ENROLLMENT = 4;

    // Main menu options
    public static final int STUDENT_MANAGEMENT = 1;
    public static final int COURSE_MANAGEMENT = 2;
    public static final int ENROLLMENT_MANAGEMENT = 3;
    public static final int EXIT = 4;

    private MenuOptions() {
        // Constants class - no instantiation
    }
}

