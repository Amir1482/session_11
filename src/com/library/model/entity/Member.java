package com.library.model.entity;

import com.google.gson.Gson;
import com.library.model.entity.enums.Gender;

import java.time.LocalDate;

//create table member(
// id number primary key,
// name nvarchar2(20),
// family nvarchar2(20),
// gender varchar(6),
// birth_date date,
// is_active number(1));
//create sequence member_seq start with 1 increment by 1;

public class Member {
    private int id;
    private String name;
    private String family;
    private Gender gender;
    private LocalDate birthDate;
    private boolean active;

    public Member() {
    }

    // update
    public Member(int id, String name, String family, Gender gender, LocalDate birthDate, boolean active) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.gender = gender;
        this.birthDate = birthDate;
        this.active = active;
    }

    // insert
    public Member(String name, String family, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.family = family;
        this.gender = gender;
        this.birthDate = birthDate;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
