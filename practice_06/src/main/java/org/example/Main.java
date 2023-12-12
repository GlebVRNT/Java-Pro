    package org.example;
    import java.sql.*;
    import java.util.Random;

    public class Main {
        static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Orders?serverTimezone=Europe/Kiev&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        static final String DB_USER = "root";
        static final String DB_PASSWORD = "saule1234";
        static Connection conn;

        public static void main(String[] args) throws SQLException {
            try {
                conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                        Statement stat = conn.createStatement();
                        stat.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                        stat.execute("CREATE TABLE Orders (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, client_id INT NOT NULL, product VARCHAR(20) NOT NULL, quantity INT NOT NULL)");

                        Random rand = new Random();
                        for (int i = 0; i < 11; i++) {
                            String name = "test" + i;
                            int age = rand.nextInt(70);
                            String sql = "INSERT INTO Clients (name, age) VALUES (?, ?)";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1, name);
                            ps.setInt(2, age);
                            ps.executeUpdate();
                        }

                        for (int i = 0; i < 11; i++) {
                            int clientID = rand.nextInt(10) + 1;
                            String product = "product" + i;
                            int quantity = rand.nextInt(100);
                            String sql = "INSERT INTO Orders(client_id, product, quantity) VALUES (?,?,?)";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setInt(1, clientID);
                            ps.setString(2, product);
                            ps.setInt(3, quantity);
                            ps.executeUpdate();
                        }
            } catch (SQLException e) {
                System.out.println("MySQL " + e.getMessage());
            }
        }
    }
