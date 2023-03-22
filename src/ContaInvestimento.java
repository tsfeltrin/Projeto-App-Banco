import java.util.Objects;

public class ContaInvestimento extends Conta { // HERANÇA

    // SOBRESCRITA
    @Override
    public boolean abrirConta(Cliente cliente) {
        System.out.println("Conta investimento aberta com sucesso!");
        return true;
    }
    @Override
    public double sacarValor(Cliente cliente, double valor) {
        if(Objects.equals(cliente.getTipo(), "J")) {
            double taxa = (valor * 0.5) / 100;
            valor = valor + taxa;
        }
        double novoSaldo = cliente.getTotalInvestimentos() - valor;
        cliente.setTotalInvestimentos(novoSaldo);
        return novoSaldo;
    }
    @Override
    public boolean investir(Cliente cliente, double valor) {
        double novoSaldo = cliente.getTotalInvestimentos() + valor;
        cliente.setTotalInvestimentos(novoSaldo);
        return true;
    }
    @Override
    public double investir(Cliente cliente, double valor, boolean retornaSaldo) {
        double novoSaldo = cliente.getTotalInvestimentos() + valor;
        cliente.setTotalInvestimentos(novoSaldo);

        double saldo = consultarSaldo(cliente);
        return saldo;
    }
    @Override
    public double depositarValor(Cliente cliente, double valor) {

        if(Objects.equals(cliente.getTipo(), "J")) {
            double taxa = (valor * 2) / 100;
            valor = valor + taxa;
        }
        double novoSaldo = cliente.getTotalInvestimentos() + valor;
        cliente.setTotalInvestimentos(novoSaldo);
        return novoSaldo;
    }
    @Override
    public double transferencia(Cliente cliente, double valor) {
        if(Objects.equals(cliente.getTipo(), "J")) {
            double taxa = (valor * 0.5) / 100;
            valor = valor + taxa;
        }
        double novoSaldo = cliente.getTotalInvestimentos() - valor;
        cliente.setTotalInvestimentos(novoSaldo);
        return novoSaldo;
    }
    @Override
    public double consultarSaldo(Cliente cliente) {
        return cliente.getTotalInvestimentos();
    }
}
