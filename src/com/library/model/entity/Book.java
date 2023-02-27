package com.library.model.entity;

import com.google.gson.Gson;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String writer;
    private int page;
    private LocalDate releaseDate;
    private boolean active;


    public Book(String name, String writer, int page, LocalDate parse) {
    }

    public Book(String name, String writer, int page, LocalDate releaseDate, boolean active) {
        this.name = name;
        this.writer = writer;
        this.page = page;
        this.releaseDate = releaseDate;
        this.active = active;
    }

    public Book(int id, String name, String writer, int page, LocalDate releaseDate, boolean active) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.page = page;
        this.releaseDate = releaseDate;
        this.active = active;
    }

    public Book(String name, String writer, int page, Object o, LocalDate parse) {
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public Book setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public int getPage() {
        return page;
    }

    public Book setPage(int page) {
        this.page = page;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Book setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Book setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
