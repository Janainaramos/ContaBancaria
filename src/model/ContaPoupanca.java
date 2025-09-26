package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Titular: " + getTitular().getNome());
        System.out.println("Número: " + getNumero());
        System.out.println("Saldo: R$ " + getSaldo());
    }
}

