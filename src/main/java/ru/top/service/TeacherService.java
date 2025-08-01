package ru.top.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherService {

    public void createTeacher() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                String sqlQuery = """
                        CREATE TABLE IF NOT EXISTS teacher (
                        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        salary MONEY NOT NULL CHECK (salary > '0'::MONEY),
                        surname VARCHAR(50) NOT NULL)
                        """;
                int createRows = statement.executeUpdate(sqlQuery);
                System.out.println("Created " + createRows + " rows in database table teacher");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertInTeacher() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                         INSERT INTO teacher(name, salary, surname)
                         VALUES  ('Ivan', 100000, 'Ivanov'),
                                 ('Petr', 150000, 'Petrov'),
                                 ('Anna', 150000, 'Sidorova'),
                                 ('Maksim', 200000, 'Semenov'),
                                 ('Stepan', 300000, 'Stepanov');
                        """;

                int insertRows = statement.executeUpdate(sqlQuery);
                System.out.println("Inserted " + insertRows + " rows in database table teacher");

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectFromTeacher() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                         SELECT * FROM teacher
                         ORDER BY id;
                        """;
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    System.out.println("Teacher - " + resultSet.getInt("id") + " " +
                            resultSet.getString("name") + " " +
                            resultSet.getString("surname") + " " +
                            resultSet.getString("salary"));
                }

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTeacher() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                        UPDATE teacher 
                        SET surname = 'Romanova' 
                        WHERE id = 3;
                        """;
                int updateRows = statement.executeUpdate(sqlQuery);
                System.out.println("Updated rows in teacher: " + updateRows);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFromTeacher() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                        DELETE FROM teacher WHERE id = 4;
                        """;
                int deleteRows = statement.executeUpdate(sqlQuery);
                System.out.println("Deleted " + deleteRows + " rows in database table teacher");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
