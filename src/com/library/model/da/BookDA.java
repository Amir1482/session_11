package com.library.model.da;

import com.library.model.entity.Book;
import com.library.model.entity.Member;
import com.library.model.entity.enums.Gender;
import com.library.model.utils.JdbcConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class BookDA {
    static PreparedStatement preparedStatement;
    public Book save(Book book) throws SQLException {
        preparedStatement = JdbcConnector
                .getConnection().
                prepareStatement("SELECT BOOK_SEQ.NEXTVAL ID FROM DUAL");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        resultSet.getInt("id");




        preparedStatement = JdbcConnector.getConnection()
                .prepareStatement("INSERT INTO BOOK (id,name,writer,page,release_date,is_active)); VALUES(?,?,?,?,?,?)");

        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3,book.getWriter());
        preparedStatement.setInt(4,book.getPage());
        preparedStatement.setDate(5, Date.valueOf(book.getReleaseDate()));
        preparedStatement.setBoolean(6,book.isActive());
        preparedStatement.execute();
        return book;
    }

    public static List<Book> findAll() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        preparedStatement = JdbcConnector
                .getConnection()
                .prepareStatement("SELECT * FROM BOOK ORDER BY name");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Book book = new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("writer"),
                    resultSet.getInt("page"),
                    resultSet.getDate("release_date").toLocalDate(),
                    resultSet.getBoolean("is_active"));
            bookList.add(book);
        }
        JdbcConnector.getConnection().close();
        return bookList;
    }

}
