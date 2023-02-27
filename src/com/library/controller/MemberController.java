package com.library.controller;

import com.library.model.da.MemberDA;
import com.library.model.entity.Member;
import com.library.model.entity.enums.Gender;
import com.library.model.utils.DataValidator;

import java.time.LocalDate;

public class MemberController {
    public static String save(String name, String family, String gender, String birthDate) {
        try {
            if (!DataValidator.stringValidator(name)) {
                throw new Exception("Invalid Name");
            }
            if (!DataValidator.stringValidator(family)) {
                throw new Exception("Invalid Family");
            }

            if (DataValidator.dateValidator(birthDate)) {
                throw new Exception("Invalid BirthDate");
            }
            if (DataValidator.genderValidator(gender)){
                throw new Exception("Invalid Gender");
            }

            Member member = new Member(
                    name,
                    family,
                    Gender.valueOf(gender),
                    LocalDate.parse(birthDate));

            MemberDA memberDA = new MemberDA();
            return memberDA.save(member) + " Saved";

        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public static String findAll() {
        try {
            MemberDA memberDA = new MemberDA();
            return memberDA.findAll().toString();
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
