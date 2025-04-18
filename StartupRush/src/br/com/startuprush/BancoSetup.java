package br.com.startuprush;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoSetup {
    public static void criarTabelas() {
        String url = "jdbc:sqlite:startuprush.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Tabela startup
            stmt.execute(
                "CREATE TABLE IF NOT EXISTS startup (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT NOT NULL," +
                        "slogan TEXT NOT NULL," +
                        "ano_fundacao INTEGER NOT NULL," +
                        "pontuacao INTEGER DEFAULT 70," +
                        "pitchs INTEGER DEFAULT 0," +
                        "bugs INTEGER DEFAULT 0," +
                        "tracoes INTEGER DEFAULT 0," +
                        "investidores_irritados INTEGER DEFAULT 0," +
                        "fake_news INTEGER DEFAULT 0" +
                        ");");

            // Tabela batalhas
            stmt.execute(
                "CREATE TABLE IF NOT EXISTS batalhas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "id_startup_a INTEGER NOT NULL," +
                        "id_startup_b INTEGER NOT NULL," +
                        "pontos_a INTEGER DEFAULT 70," +
                        "pontos_b INTEGER DEFAULT 70," +
                        "id_vencedora INTEGER," +
                        "rodada INTEGER NOT NULL," +
                        "status TEXT DEFAULT 'pendente'," +
                        "FOREIGN KEY (id_startup_a) REFERENCES startup(id)," +
                        "FOREIGN KEY (id_startup_b) REFERENCES startup(id)," +
                        "FOREIGN KEY (id_vencedora) REFERENCES startup(id)" +
                        ");");

            // Tabela evento
            stmt.execute(
                "CREATE TABLE IF NOT EXISTS evento (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "id_batalha INTEGER NOT NULL," +
                        "id_startup INTEGER NOT NULL," +
                        "tipo_evento TEXT NOT NULL," +
                        "pontos_aplicados INTEGER NOT NULL," +
                        "FOREIGN KEY (id_batalha) REFERENCES batalhas(id)," +
                        "FOREIGN KEY (id_startup) REFERENCES startup(id)" +
                        ");");

            System.out.println("Tabelas criadas com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao criar tabelas");
            e.printStackTrace();
        }
    }

    public static boolean testarConexao() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:startuprush.db")) {
            return conn != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
