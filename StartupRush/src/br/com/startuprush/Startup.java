package br.com.startuprush;

public class Startup {
    private int id;
    private String nome;
    private String slogan;
    private int anoFundacao;
    private int pontuacao;
    private int pitchs;
    private int bugs;
    private int tracoes;
    private int investidoresIrritados;
    private int fakeNews;

    // Construtor completo (usado ao buscar do banco)
    public Startup(int id, String nome, String slogan, int anoFundacao, int pontuacao,
                   int pitchs, int bugs, int tracoes, int investidoresIrritados, int fakeNews) {
        this.id = id;
        this.nome = nome;
        this.slogan = slogan;
        this.anoFundacao = anoFundacao;
        this.pontuacao = pontuacao;
        this.pitchs = pitchs;
        this.bugs = bugs;
        this.tracoes = tracoes;
        this.investidoresIrritados = investidoresIrritados;
        this.fakeNews = fakeNews;
    }

    // Construtor para quando o usuário cadastrar uma nova startup
    public Startup(String nome, String slogan, int anoFundacao) {
        this.nome = nome;
        this.slogan = slogan;
        this.anoFundacao = anoFundacao;
        this.pontuacao = 70;
        this.pitchs = 0;
        this.bugs = 0;
        this.tracoes = 0;
        this.investidoresIrritados = 0;
        this.fakeNews = 0;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSlogan() {
        return slogan;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getPitchs() {
        return pitchs;
    }

    public int getBugs() {
        return bugs;
    }

    public int getTracoes() {
        return tracoes;
    }

    public int getInvestidoresIrritados() {
        return investidoresIrritados;
    }

    public int getFakeNews() {
        return fakeNews;
    }

    // Setters
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setPitchs(int pitchs) {
        this.pitchs = pitchs;
    }

    public void setBugs(int bugs) {
        this.bugs = bugs;
    }

    public void setTracoes(int tracoes) {
        this.tracoes = tracoes;
    }

    public void setInvestidoresIrritados(int investidoresIrritados) {
        this.investidoresIrritados = investidoresIrritados;
    }

    public void setFakeNews(int fakeNews) {
        this.fakeNews = fakeNews;
    }

    @Override
    public String toString() {
        return nome + " (" + slogan + ") - Fundada em " + anoFundacao + " - Pontos: " + pontuacao;
    }
}
