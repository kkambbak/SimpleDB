package com.ll.simpleDb;

import java.sql.Connection;
import java.sql.SQLException;

public class Sql {

    private StringBuilder queryBuilder;
    Connection conn;

    public Sql(Connection conn) {
        queryBuilder = new StringBuilder();
        this.conn = conn;
    }

    public long insert() {
        String query = queryBuilder.toString();
        int result = 0;
        try {
            System.out.println(query);

            System.out.println("쿼리 생성");

            result = conn.createStatement().executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Sql append(String sqlLine) {
        queryBuilder.append(sqlLine);
        return this;
    }

    public Sql append(String sqlLine, String values) {
        String formatted = sqlLine.replace("?", "\"" + values + "\"");
        queryBuilder.append(formatted);
        return this;
    }
}
