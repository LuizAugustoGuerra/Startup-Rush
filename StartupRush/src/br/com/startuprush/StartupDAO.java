package br.com.startuprush;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StartupDAO {
    private String url = "jdbc:sqlite:startup_rush.db";

    public void inserirStartup(Startup startup) {
        String sql = "INSERT INTO startup (nome, slogan, ano_fundacao, pontuacao, pitchs, bugs, tracoes, investidores_irritados, fake_news) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, startup.getNome());
            pstmt.setString(2, startup.getSlogan());
            pstmt.setInt(3, startup.getAnoFundacao());
            pstmt.setInt(4, startup.getPontuacao());
            pstmt.setInt(5, startup.getPitchs());
            pstmt.setInt(6, startup.getBugs());
            pstmt.setInt(7, startup.getTracoes());
            pstmt.setInt(8, startup.getInvestidoresIrritados());
            pstmt.setInt(9, startup.getFakeNews());

            pstmt.executeUpdate();
            System.out.println(" Startup cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println(" Erro ao inserir startup: " + e.getMessage());
        }
    }

    public List<Startup> listarStartups() {
        List<Startup> startups = new ArrayList<>();
        String sql = "SELECT * FROM startup";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Startup s = new Startup(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("slogan"),
                    rs.getInt("ano_fundacao"),
                    rs.getInt("pontuacao"),
                    rs.getInt("pitchs"),
                    rs.getInt("bugs"),
                    rs.getInt("tracoes"),
                    rs.getInt("investidores_irritados"),
                    rs.getInt("fake_news")
                );
                startups.add(s);
            }

        } catch (SQLException e) {
            System.out.println(" Erro ao listar startups: " + e.getMessage());
        }

        return startups;
    }
}
