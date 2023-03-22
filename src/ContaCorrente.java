import java.util.Objects;

public class ContaCorrente extends Conta { // HERANÇA


    // SOBRESCRITA
    @Override
    public boolean abrirConta(Cliente c) {
        System.out.println("Conta corrente aberta com sucesso!");
        return true;
    }
    @Override
    public double depositarValor(Cliente cliente, double valor)
    {
        double novoSaldo = cliente.getTotalContaCorrente() + valor;
        cliente.setTotalContaCorrente(novoSaldo);
        return novoSaldo;
    }
    @Override
    public double sacarValor(Cliente cliente, double valor)
    {
        if(Objects.equals(cliente.getTipo(), "J")) {
            double taxa = (valor * 0.5) / 100;
            valor = valor + taxa;
        }
        double novoSaldo = cliente.getTotalContaCorrente() - valor;
        cliente.setTotalContaCorrente(novoSaldo);
        return novoSaldo;
    }
    @Override
    public double transferencia(Cliente cliente, double valor) {
        if(Objects.equals(cliente.getTipo(), "J")) {
            double taxa = (valor * 0.5) / 100;
            valor = valor + taxa;
        }
        double novoSaldo = cliente.getTotalContaCorrente() - valor;
        cliente.setTotalContaCorrente(novoSaldo);
        return novoSaldo;
    }
    @Override
    public boolean investir(Cliente cliente, double valor) {
        double novoSaldo = cliente.getTotalContaCorrente() + valor;
        cliente.setTotalContaCorrente(novoSaldo);
        return true;
    }

    @Override
    public double investir(Cliente cliente, double valor, boolean retornarSaldo) {
        double novoSaldo = cliente.getTotalContaCorrente() + valor;
        cliente.setTotalContaCorrente(novoSaldo);

        double saldo = consultarSaldo(cliente);
        return saldo;
    }
    @Override
    public double consultarSaldo (Cliente cliente)
    {
        return cliente.getTotalContaCorrente();
    }

}











