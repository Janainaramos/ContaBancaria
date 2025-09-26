package model;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Titular: " + getTitular().getNome());
        System.out.println("Número: " + getNumero());
        System.out.println("Saldo: R$ " + getSaldo());
    }
}
