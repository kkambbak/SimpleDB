package com.ll.simpleDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDb {
    Connection conn = null;

    public SimpleDb(String localhost, String user, String password, String dbName) {
        String dburl = "jdbc:mysql://localhost/" + dbName;

        try {
            this.conn = DriverManager.getConnection(dburl, user, password);
            System.out.println("데이터 연결 성공");
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패: " + e.getMessage());
        }
    }

    public void setDevMode(boolean b) {
    }

    public void run(String sql, String title, String body, boolean isBlind) {
        String query = sql.replace("title = ?", "title = \"" + title + "\"");
        query = query.replace("`body` = ?", "`body` = \"" + body + "\"");
        query = query.replace("isBlind = ?", "isBlind = " + String.valueOf(isBlind).toUpperCase());

        System.out.println(query);
        try {
            conn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void run(String query) {
        try {
            conn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Sql genSql() {
        return new Sql(conn);
    }
}
