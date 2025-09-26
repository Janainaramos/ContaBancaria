package model;

public abstract class Conta {
    private int numero;
    private Cliente titular;
    private double saldo;

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumero() { return numero; }
    public Cliente getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    protected void setSaldo(double saldo) { this.saldo = saldo; }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
        else System.out.println("Valor inválido!");
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
            return false;
        }
    }

    public boolean transferir(double valor, Conta destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public abstract void imprimirExtrato();
}
