package ru.top.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GroupService {

    public void createGroup() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                String sqlQuery = """
                        CREATE TABLE IF NOT EXISTS "group" (
                        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        name VARCHAR(50) UNIQUE NOT NULL,
                        year INT NOT NULL CHECK (year BETWEEN 1 AND 5),
                        department_id INT)
                        --FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE)
                        """;
                int createRows = statement.executeUpdate(sqlQuery);
                System.out.println("Created " + createRows + " rows in database table group");

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertInGroup() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                         INSERT INTO "group"(name, year, department_id)
                         VALUES  ('Java411', 1, 1),
                                 ('Java413', 3, 1),
                                 ('Python511', 4, 2),
                                 ('Python513', 2, 2),
                                 ('JS311', 5, 3);
                        """;

                int insertRows = statement.executeUpdate(sqlQuery);
                System.out.println("Inserted " + insertRows + " rows in database table group");

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectFromGroup() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                         SELECT * FROM "group"
                         ORDER BY id;
                        """;
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    System.out.println("Group - " + resultSet.getInt("id") + " " +
                            resultSet.getString("name") + " " +
                            resultSet.getInt("year") + " " +
                            resultSet.getInt("department_id"));
                }

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGroup() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                        UPDATE "group" SET name = 'JavaScript313' WHERE id = 5;
                        """;
                int updateRows = statement.executeUpdate(sqlQuery);
                System.out.println("Updated rows in group: " + updateRows);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFromGroup() {

        try {
            String url = "jdbc:postgresql://localhost:5432/TOP";
            String username = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                String sqlQuery = """
                        DELETE FROM "group" WHERE id = 5;
                        """;
                int deleteRows = statement.executeUpdate(sqlQuery);
                System.out.println("Deleted " + deleteRows + " rows in database table group");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
