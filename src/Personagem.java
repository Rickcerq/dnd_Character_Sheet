
public class Personagem {

    private String nome;
    private Raça raça;
    private Classe classe;
    private int nivel = 0;
    private String antecendente;
    private Alinhamento alinhamento;
    private int pontosExp = 0;

    public Personagem(String nome, Raça raça, Classe classe, String antecendente, Alinhamento alinhamento) {
        this.nome = nome;
        this.raça = raça;
        this.classe = classe;
        this.antecendente = antecendente;
        this.alinhamento = alinhamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Raça getRaça() {
        return raça;
    }

    public void setRaça(Raça raça) {
        this.raça = raça;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getAntecendente() {
        return antecendente;
    }

    public void setAntecendente(String antecendente) {
        this.antecendente = antecendente;
    }

    public Alinhamento getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(Alinhamento alinhamento) {
        this.alinhamento = alinhamento;
    }

    public int getPontosExp() {
        return pontosExp;
    }

    public void setPontosExp(int pontosExp) {
        this.pontosExp = pontosExp;
    }
}
