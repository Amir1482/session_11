package com.library.controller;

import com.library.model.da.BookDA;
import com.library.model.entity.Book;
import com.library.model.utils.DataValidator;

import java.time.LocalDate;

public class BookController {
    public static String save(String name, String writer,int page, String birthDate) {
        try {
            if (!DataValidator.stringValidator(name)) {
                throw new Exception("Invalid Name");
            }
            if (!DataValidator.stringValidator(writer)) {
                throw new Exception("Invalid Family");
            }

            if (DataValidator.dateValidator(birthDate)) {
                throw new Exception("Invalid BirthDate");
            }
            if (DataValidator.genderValidator(String.valueOf(page))){
                throw new Exception("Invalid Page");
            }

            Book book = new Book(
                    name,
                    writer,
                    page,
                    LocalDate.parse(birthDate));

            BookDA bookDA = new BookDA();
            return bookDA.save(book) + " Saved";

        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public static String findAll() {
        try {
            BookDA bookDA = new BookDA();
            return BookDA.findAll().toString();
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
