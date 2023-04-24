package com.ll.simpleDb;

public class Sql {

    private StringBuilder queryBuilder;

    public Sql() {
        queryBuilder = new StringBuilder();
    }

    public long insert() {
        return 0;
    }

    public Sql append(String sqlLine) {
        queryBuilder.append(sqlLine);
        return this;
    }

    public Sql append(String sqlLine, String values) {
        String formatted = String.format(sqlLine, values);
        queryBuilder.append(formatted);
        return this;
    }
}
