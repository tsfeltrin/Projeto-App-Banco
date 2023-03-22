public class Cliente {
    private String nome;
    private double totalContaCorrente;
    private double totalPoupanca;
    private double totalInvestimentos;
    private String tipo; //F - FISICA e J - JURIDICA

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getTotalContaCorrente() {
        return totalContaCorrente;
    }
    public void setTotalContaCorrente(double totalContaCorrente) {
        this.totalContaCorrente = totalContaCorrente;
    }
    public double getTotalPoupanca() {
        return totalPoupanca;
    }
    public void setTotalPoupanca(double totalPoupanca) {
        this.totalPoupanca = totalPoupanca;
    }
    public double getTotalInvestimentos() {
        return totalInvestimentos;
    }
    public void setTotalInvestimentos(double totalInvestimentos) {
        this.totalInvestimentos = totalInvestimentos;
    }




}
