import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {

                //TRY CATCH
        try {
            ClientePessoaFisica pf = new ClientePessoaFisica();
            pf.setNome("Maria da Silva");
            pf.setTipo("F");
            pf.setCpf("12345678912");
            pf.setTotalPoupanca(500.00);
            pf.setTotalContaCorrente(1000);
            pf.setTotalInvestimentos(10000);

            ClientePessoaJuridica pj = new ClientePessoaJuridica();
            pj.setNome("Jose da Silva");
            pj.setTipo("J");
            pj.setCnpj("12345678912345");
            pj.setTotalContaCorrente(120000);
            pj.setTotalInvestimentos(500000);

                // ARRAYLIST
            List<Cliente> listaClientes = new ArrayList<>();
            listaClientes.add(pf);
            listaClientes.add(pj);

            Scanner entrada = new Scanner(System.in);

            Cliente clienteAtual = null;

            while (clienteAtual == null) {

                System.out.println("Digite seu CPF ou CPNJ");
                String documento = entrada.nextLine();

                if (documento.length() == 11) {
                    clienteAtual = pf;

                } else if (documento.length() == 14) {
                    clienteAtual = pj;

                } else {
                    System.out.println("CPF ou CNPJ inválido!");
                    clienteAtual = null;
                }
            }
            System.out.println("SELECIONE A OPÇÃO DESEJADA: \n 1 - LISTAR CLIENTES \n 2 - TRANSAÇÕES");
            int menu = Integer.parseInt(entrada.nextLine());

            if (menu == 1) {
                for (int i = 0; i <= listaClientes.size(); i++) {
                    Cliente c = listaClientes.get(i);
                    System.out.println("Nome: " + c.getNome() + " Tipo do Cliente: " + c.getTipo());
                }
            }

            if (menu == 2) {
                System.out.println("SELECIONE O TIPO DE CONTA: \n 1 - CONTA CORRENTE \n 2 - CONTA POUPANÇA \n 3 - CONTA INVESTIMENTO ");

                int tipoConta = Integer.parseInt(entrada.nextLine());

                System.out.println("SELECIONE A OERAÇÃO DESEJADA: \n 1 - ABRIR CONTA \n 2 - SACAR VALOR \n 3 - INVESTIR \n " +
                        "4 - DEPOSITAR VALOR \n 5 - TRANSFERENCIA \n 6 - CONSULTAR SALDO");

                int opcao = Integer.parseInt(entrada.nextLine());


                if (opcao == 1) {
                    if (tipoConta == 1) {
                        ContaCorrente cc = new ContaCorrente();
                        cc.abrirConta(clienteAtual);
                    } else if (tipoConta == 2) {
                        if (clienteAtual.getTipo() == "J") {
                            System.out.println("Você não pode abrir este tipo de conta!");
                        } else {
                            ContaPoupanca cp = new ContaPoupanca();
                            cp.abrirConta(clienteAtual);
                        }
                    } else if (tipoConta == 3) {
                        ContaInvestimento ci = new ContaInvestimento();
                        ci.abrirConta(clienteAtual);
                    }
                }


                if (opcao == 2) {

                    System.out.println("Digite o valor que deseja sacar");
                    double valor = Double.parseDouble(entrada.nextLine());

                    if (tipoConta == 1) {
                        ContaCorrente cc = new ContaCorrente();
                        double saldo = cc.sacarValor(clienteAtual, valor);
                        System.out.println("Seu novo saldo após o saque é: " + saldo);
                    } else if (tipoConta == 2) {
                        if (Objects.equals(clienteAtual.getTipo(), "J")) {
                            System.out.println("Você não pode sacar valor deste tipo de conta!");
                        } else {
                            ContaPoupanca cp = new ContaPoupanca();
                            double saldo = cp.sacarValor(clienteAtual, valor);
                            System.out.println("Seu novo saldo após o saque é: " + saldo);
                        }
                    } else if (tipoConta == 3) {
                        ContaInvestimento ci = new ContaInvestimento();
                        double saldo = ci.sacarValor(clienteAtual, valor);
                        System.out.println("Seu novo saldo após o saque é: " + saldo);
                    }
                }

                if (opcao == 3) { //VER ERRO!!!!

                    System.out.println("Digite o valor que deseja investir:");
                    double valor = Double.parseDouble(entrada.nextLine());

                    System.out.println("Deseja saber o saldo após o investimento? [S/N]");
                    String exibirSaldo = entrada.nextLine();

                        if (tipoConta == 1) {
                            ContaCorrente cc = new ContaCorrente();
                        if (Objects.equals(exibirSaldo, "S")) {
                            double saldo = cc.investir(clienteAtual, valor, true);
                            System.out.println("Depósito realizado com sucesso. Seu novo saldo é: " + saldo);
                        }
                            else {
                            boolean result = cc.investir(clienteAtual, valor);
                            if (result) {
                                System.out.println("Investimento realizado com sucesso.");
                            } else {
                                System.out.println("Não é possível realizar este investimento.");
                            }
                        }

                    } else if (tipoConta == 2) {
                        ContaPoupanca cp = new ContaPoupanca();
                        if (Objects.equals(exibirSaldo, "S")) {
                            double saldo = cp.investir(clienteAtual, valor, true);
                            System.out.println("Depósito realizado com sucesso. Seu novo saldo é: " + saldo);
                        } else {
                            boolean result = cp.investir(clienteAtual, valor);
                            if (result) {
                                System.out.println("Investimento realizado com sucesso.");
                            } else {
                                System.out.println("Não foi possível realizar o investimento");
                            }
                        }
                    } else if (tipoConta == 3) {
                        ContaInvestimento ci = new ContaInvestimento();
                        if (Objects.equals(exibirSaldo, "S")) {
                            double saldo = ci.investir(clienteAtual, valor, true);
                            System.out.println("Investimento realizado com sucesso. Seu novo saldo é: " + saldo);
                        } else {
                            boolean result = ci.investir(clienteAtual, valor);
                            if (result) {
                                System.out.println("Investimento realizado com sucesso.");
                            } else {
                                System.out.println("Não foi possível realizar o investimento");
                            }
                        }
                    }
                }

                if (opcao == 4) {
                    System.out.println("Digite o valor que deseja depositar:");
                    double valor = Double.parseDouble(entrada.nextLine());

                    if (tipoConta == 1) {
                        ContaCorrente cc = new ContaCorrente();
                        double saldo = cc.depositarValor(clienteAtual, valor);
                        System.out.println("Depósito realizado com sucesso. Seu novo saldo é: " + saldo);
                    } else if (tipoConta == 2) {
                        ContaPoupanca cp = new ContaPoupanca();
                        double saldo = cp.depositarValor(clienteAtual, valor);
                        System.out.println("Depósito realizado com sucesso. Seu novo saldo é: " + saldo);
                    } else if (tipoConta == 3) {
                        ContaInvestimento ci = new ContaInvestimento();
                        double saldo = ci.depositarValor(clienteAtual, valor);
                        System.out.println("Depósito realizado com sucesso. Seu novo saldo é: " + saldo);
                    }
                }

                if (opcao == 5) {
                    System.out.println("Digite o valor que deseja transferir:");
                    double valor = Double.parseDouble(entrada.nextLine());

                    if (tipoConta == 1) {
                        ContaCorrente cc = new ContaCorrente();
                        double saldo = cc.transferencia(clienteAtual, valor);
                        System.out.println("Transferencia realizada com sucesso. Seu novo saldo é: " + saldo);
                    } else if (tipoConta == 2) {
                        ContaPoupanca cp = new ContaPoupanca();
                        double saldo = cp.transferencia(clienteAtual, valor);
                        System.out.println("Transferencia realizada com sucesso. Seu novo saldo é: " + saldo);
                    } else if (tipoConta == 3) {
                        ContaInvestimento ci = new ContaInvestimento();
                        double saldo = ci.transferencia(clienteAtual, valor);
                        System.out.println("Transferencia realizada com sucesso. Seu novo saldo é: " + saldo);
                    }
                }

                if (opcao == 6) {
                    if (tipoConta == 1) {
                        ContaCorrente cc = new ContaCorrente();
                        double saldo = cc.consultarSaldo(clienteAtual);
                        System.out.println("Seu saldo é: " + saldo);
                    } else if (tipoConta == 2) {
                        ContaPoupanca cp = new ContaPoupanca();
                        double saldo = cp.consultarSaldo(clienteAtual);
                        System.out.println("Seu saldo é: " + saldo);
                    } else if (tipoConta == 3) {
                        ContaInvestimento ci = new ContaInvestimento();
                        double saldo = ci.consultarSaldo(clienteAtual);
                        System.out.println("Seu saldo é: " + saldo);
                    }

                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}



