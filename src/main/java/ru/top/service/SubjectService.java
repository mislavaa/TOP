package ru.top.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SubjectService {

    public void createSubject() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                String sqlQuery = """
                        CREATE TABLE IF NOT EXISTS subject (
                        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        name VARCHAR(100) UNIQUE NOT NULL)
                        """;
                int createRows = statement.executeUpdate(sqlQuery);
                System.out.println("Created " + createRows + " rows in database table subject");

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertInSubject() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                         INSERT INTO subject(name)
                         VALUES  ('JavaCore'),
                                 ('BD'),
                                 ('Python'),
                                 ('JavaScript'),
                                 ('C#');
                        """;

                int insertRows = statement.executeUpdate(sqlQuery);
                System.out.println("Inserted " + insertRows + " rows in database table subject");

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectFromSubject() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                         SELECT * FROM subject
                         ORDER BY id;
                        """;
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    System.out.println("Subject - " + resultSet.getInt("id") + " " +
                            resultSet.getString("name"));
                }

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSubject() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                        UPDATE subject SET name = 'DataBase' WHERE id = 2;
                        """;
                int updateRows = statement.executeUpdate(sqlQuery);
                System.out.println("Updated rows in subject: " + updateRows);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFromSubject() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                        DELETE FROM subject WHERE id = 4;
                        """;
                int deleteRows = statement.executeUpdate(sqlQuery);
                System.out.println("Deleted " + deleteRows + " rows in database table subject");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
