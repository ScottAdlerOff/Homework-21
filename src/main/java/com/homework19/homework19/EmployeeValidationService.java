package com.homework19.homework19;

public class EmployeeValidationService {
    public void validate(String firstName, String lastName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name не может быть пустым");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name не может быть пустым");
        }
    }
}
