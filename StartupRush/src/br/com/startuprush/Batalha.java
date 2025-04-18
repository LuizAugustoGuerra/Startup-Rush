package br.com.startuprush;
public class Batalha {
    private int id;
    private int idStartupA;
    private int idStartupB;
    private int pontosA;
    private int pontosB;
    private Integer idVencedora; // pode ser nulo enquanto batalha não finaliza
    private int rodada;
    private String status; // "pendente" ou "finalizada"

    public Batalha(int idStartupA, int idStartupB,int rodada){
        this.idStartupA = idStartupA;
        this.idStartupB = idStartupB;
        this.rodada=rodada;
        this.pontosA=70;// para comecar ja com 70 pontos iniciais
        this.pontosB=70;
        this.status="Pendente";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStartupA() {
        return idStartupA;
    }

    public int getIdStartupB() {
        return idStartupB;
    }

    public int getPontosA() {
        return pontosA;
    }

    public void setPontosA(int pontosA) {
        this.pontosA = pontosA;
    }

    public int getPontosB() {
        return pontosB;
    }

    public void setPontosB(int pontosB) {
        this.pontosB = pontosB;
    }

    public Integer getIdVencedora() {
        return idVencedora;
    }

    public void setIdVencedora(Integer idVencedora) {
        this.idVencedora = idVencedora;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


