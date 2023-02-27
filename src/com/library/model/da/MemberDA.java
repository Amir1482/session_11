package com.library.model.da;

import com.library.model.entity.Member;
import com.library.model.entity.enums.Gender;
import com.library.model.utils.JdbcConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDA {
    private PreparedStatement preparedStatement;

    public Member save(Member member) throws SQLException {
        preparedStatement = JdbcConnector
                .getConnection()
                .prepareStatement("SELECT MEMBER_SEQ.NEXTVAL ID FROM DUAL");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        member.setId(resultSet.getInt("id"));

        preparedStatement = JdbcConnector
                .getConnection()
                .prepareStatement("INSERT INTO MEMBER (id,name,family,gender,birth_date,is_active) VALUES(?,?,?,?,?,?)");
        preparedStatement.setInt(1, member.getId());
        preparedStatement.setString(2, member.getName());
        preparedStatement.setString(3, member.getFamily());
        preparedStatement.setString(4, member.getGender().name());
        preparedStatement.setDate(5, Date.valueOf(member.getBirthDate()));
        preparedStatement.setBoolean(6, member.isActive());
        preparedStatement.execute();
        JdbcConnector.getConnection().close();
        return member;
    }

    public List<Member> findAll() throws SQLException {
        List<Member> memberList = new ArrayList<>();
        preparedStatement = JdbcConnector
                .getConnection()
                .prepareStatement("SELECT * FROM MEMBER ORDER BY family,name");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Member member = new Member(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    Gender.valueOf(resultSet.getString("gender")),
                    resultSet.getDate("birth_date").toLocalDate(),
                    resultSet.getBoolean("is_active"));
            memberList.add(member);
        }
        JdbcConnector.getConnection().close();
        return memberList;
    }
}
