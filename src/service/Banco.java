package service;

import model.Conta;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) return c;
        }
        return null;
    }

    public void listarContas() {
        System.out.println("=== Contas do Banco " + nome + " ===");
        for (Conta conta : contas) {
            conta.imprimirExtrato();
            System.out.println("---------------------");
        }
    }
}
