package br.unisal.tables;

import br.unisal.models.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ItemFinanceiroTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_DESCRICAO = 1;
    private static final int COL_TIPO = 2;
    private static final int COL_VALOR = 3;
    private static final int COL_CATEGORIA = 4;
    private static final int COL_DATA = 5;
    private static final String[] colunas = new String[]{
        "Id", "Descrição", "Tipo", "Valor", "Categoria", "Data"
    };

    public ItemFinanceiroTableModel(ArrayList<ItemFinanceiro> linhas) {
        this.linhas = linhas;
    }
    private ArrayList<ItemFinanceiro> linhas;

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemFinanceiro item = getItem(rowIndex);

        if (columnIndex == COL_ID) {
            return item.getId();
        } else if (columnIndex == COL_CATEGORIA) {
            return item.getCategoria();
        } else if (columnIndex == COL_DATA) {
            return item.getData();
        } else if (columnIndex == COL_DESCRICAO) {
            return item.getDescricao();
        } else if (columnIndex == COL_TIPO) {
            return item.getTipo();
        } else if (columnIndex == COL_VALOR) {
            return item.getValor();
        }


        return null;
    }

    @Override
    public String getColumnName(int posicao) {
        return colunas[posicao]; //To change body of generated methods, choose Tools | Templates.
    }

    public void adicionar(ItemFinanceiro item) {
        linhas.add(item);
        int posicao = getRowCount() - 1;
        fireTableRowsInserted(posicao, posicao);
    }

    public ItemFinanceiro getItem(int posicao) {

        return linhas.get(posicao);
    }

    public void atualizar(int posicao, ItemFinanceiro item) {
        linhas.set(posicao, item);
        fireTableRowsUpdated(posicao, posicao);
    }

    public void excluir(int posicao) {
        linhas.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }
}
