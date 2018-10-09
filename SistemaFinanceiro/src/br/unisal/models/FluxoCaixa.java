package br.unisal.models;

import java.util.ArrayList;

public class FluxoCaixa {

    private static final String DESPESA = "DESPESA";
    private static final String RECEITA = "RECEITA";
    private double receita;
    private double despesa;

    public FluxoCaixa(ArrayList<ItemFinanceiro> item) {
        atualizarItensFinanceiros(item);
    }

    public void registrarItemFinanceiro(ItemFinanceiro item) {

        if (item.getTipo().toUpperCase().equals(RECEITA)) {
            receita += item.getValor();

        } else {
            despesa += item.getValor();

        }


    }

    public void removerItemFinanceiro(ItemFinanceiro item) {
        if (item.getTipo().toUpperCase().equals(RECEITA)) {
            receita -= item.getValor();
        } else {
            despesa -= item.getValor();
        }
    }

    public void atualizarItensFinanceiros(ArrayList<ItemFinanceiro> itens) {
        receita = despesa = 0;
        for (int i = 0; i < itens.size(); i++) {
            registrarItemFinanceiro(itens.get(i));
        }
    }

    public double getSaldo() {
        return receita - despesa;
    }

    public double getReceita() {
        return receita;
    }

    public double getDespesa() {
        return despesa;
    }
}
