package com.library.model.utils;

import com.library.model.entity.enums.Gender;

import java.time.LocalDate;

public class DataValidator {
    public static boolean stringValidator(String text) {
        return (text != null && !text.isEmpty()) ? true : false;
    }

    public static boolean positiveNumberValidator(int number) {
        return (number > 0) ? true : false;
    }

    public static boolean dateValidator(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean genderValidator(String gender) {
        try {
            Gender.valueOf(gender);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
