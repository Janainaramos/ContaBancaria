package app;

import model.*;
import service.Banco;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco Digital");

        // Contas iniciais
        Cliente cliente1 = new Cliente("Janaina");
        Conta cc = new ContaCorrente(1, cliente1);
        Conta cp = new ContaPoupanca(2, cliente1);

        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Menu Banco Digital ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Ver extrato");
            System.out.println("5 - Listar todas contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    int numDep = sc.nextInt();
                    System.out.print("Valor a depositar: ");
                    double valorDep = sc.nextDouble();
                    Conta contaDep = banco.buscarConta(numDep);
                    if (contaDep != null) {
                        contaDep.depositar(valorDep);
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    int numSaq = sc.nextInt();
                    System.out.print("Valor a sacar: ");
                    double valorSaq = sc.nextDouble();
                    Conta contaSaq = banco.buscarConta(numSaq);
                    if (contaSaq != null) {
                        contaSaq.sacar(valorSaq);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 3:
                    System.out.print("Conta de origem: ");
                    int numOrigem = sc.nextInt();
                    System.out.print("Conta de destino: ");
                    int numDestino = sc.nextInt();
                    System.out.print("Valor a transferir: ");
                    double valorTransf = sc.nextDouble();
                    Conta origem = banco.buscarConta(numOrigem);
                    Conta destino = banco.buscarConta(numDestino);
                    if (origem != null && destino != null) {
                        origem.transferir(valorTransf, destino);
                    } else {
                        System.out.println("Conta de origem ou destino não encontrada!");
                    }
                    break;
                case 4:
                    System.out.print("Número da conta: ");
                    int numExtrato = sc.nextInt();
                    Conta contaExtrato = banco.buscarConta(numExtrato);
                    if (contaExtrato != null) {
                        contaExtrato.imprimirExtrato();
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 5:
                    banco.listarContas();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Obrigado por usar o Banco Digital!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
