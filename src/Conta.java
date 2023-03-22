public abstract class Conta { // CONTA ABSTRATA
    private double saldo;
    private int agencia;
    private int numero;
    private String titular;

    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    public int getAgencia() {return agencia;}
    public void setAgencia(int agencia) { this.agencia = agencia;}
    public int getNumero() { return numero;}
    public void setNumero(int numero) {this.numero = numero;}
    public String getTitular() {return titular;}
    public void setTitular(String titular) {this.titular = titular;}

    public abstract boolean abrirConta(Cliente cliente);
    public abstract double sacarValor(Cliente cliente, double valor);
    public abstract boolean investir(Cliente cliente, double valor);
    public abstract double investir(Cliente cliente, double valor, boolean retornaSaldo); //SOBRECARGA
    public abstract double depositarValor(Cliente cliente, double valor);
    public abstract double transferencia(Cliente cliente, double valor);
    public abstract double consultarSaldo(Cliente cliente);
}
