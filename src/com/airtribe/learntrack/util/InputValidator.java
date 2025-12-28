package com.airtribe.learntrack.util;

/**
 * Simple utility class for validating user input
 */
public class InputValidator {
    
    private InputValidator() {
        // Utility class
    }

    /**
     * Checks if a string is not null or empty
     */
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Validates email format (basic check)
     */
    public static boolean isValidEmail(String email) {
        if (!isValidString(email)) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    /**
     * Tries to parse an integer from string
     * Returns true if successful, false otherwise
     */
    public static boolean isValidInteger(String input) {
        if (!isValidString(input)) {
            return false;
        }
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Parses integer from string, returns default if invalid
     */
    public static int parseInt(String input, int defaultValue) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}

