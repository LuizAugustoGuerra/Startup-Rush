package br.com.startuprush;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // URL do banco de dados SQLite
        String url = "jdbc:sqlite:db/startuprush.db";  // Ele vai criar o arquivo .db na pasta /db

        // Tente conectar ao banco de dados
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados!");
            e.printStackTrace();
        }
    }
}