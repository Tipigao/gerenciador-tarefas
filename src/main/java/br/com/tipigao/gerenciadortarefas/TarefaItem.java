/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tipigao.gerenciadortarefas;

import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author robertosilva
 */
public class TarefaItem {

    public String nomeTarefa;
    public String pid;
    public String nomeSessao;
    public String sessao;
    public String qtdMemoria;
    public String caminhoExecutavel;
    public boolean ehNovaTarefa;

    public TarefaItem() {
        ehNovaTarefa = true;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TarefaItem aux = (TarefaItem) o;

        return ((this.nomeTarefa == null && aux.nomeTarefa == null) || this.nomeTarefa.equals(aux.nomeTarefa))
                && ((this.nomeSessao == null && aux.nomeSessao == null) || this.nomeSessao.equals(aux.nomeSessao))
                && ((this.sessao == null && aux.sessao == null) || this.sessao.equals(aux.sessao))
                && ((this.qtdMemoria == null && aux.qtdMemoria == null) || this.qtdMemoria.equals(aux.qtdMemoria));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.pid);
        hash = 61 * hash + Objects.hashCode(this.sessao);
        return hash;
    }
}

class TarefaItemTableModel extends AbstractTableModel {

    public static final int COLUNA_NOME = 0;
    public static final int COLUNA_PID = 1;
    public static final int COLUNA_NOME_SESSAO = 2;
    public static final int COLUNA_SESSAO = 3;
    public static final int COLUNA_MEMORIA = 4;

    private String[] columnNames = {"Tarefa", "Identificador", "Nome da Sessão", "Sessão", "Memória"};
    private List<TarefaItem> listItens;

    public TarefaItemTableModel(List<TarefaItem> listItens) {
        this.listItens = listItens;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listItens.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listItens.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TarefaItem item = listItens.get(rowIndex);
        Object returnValue = null;

        if (item == null) {
            return null;
        }

        switch (columnIndex) {
            case COLUNA_NOME:
                returnValue = item.nomeTarefa;
                break;
            case COLUNA_PID:
                returnValue = item.pid;
                break;
            case COLUNA_NOME_SESSAO:
                returnValue = item.nomeSessao;
                break;
            case COLUNA_SESSAO:
                returnValue = item.sessao;
                break;
            case COLUNA_MEMORIA:
                returnValue = item.qtdMemoria;
                break;
            default:
                throw new IllegalArgumentException("Índice de coluna inválido");
        }

        return returnValue;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        TarefaItem item = listItens.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_NOME:
                item.nomeTarefa = (String) value;
                break;
            case COLUNA_PID:
                item.pid = (String) value;
                break;
            case COLUNA_NOME_SESSAO:
                item.nomeSessao = (String) value;
                break;
            case COLUNA_SESSAO:
                item.sessao = (String) value;
                break;
            case COLUNA_MEMORIA:
                item.qtdMemoria = (String) value;
                break;
            default:
                throw new IllegalArgumentException("Índice de coluna inválido");
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    public TarefaItem getItem(int i) {
        TarefaItem item = listItens.get(i);
        return item;
    }

    public void addItem(TarefaItem item) {
        listItens.add(item);
    }

    public void removeAt(int i) {
        listItens.remove(i);
    }

    public void remove(TarefaItem item) {
        listItens.remove(item);
    }

}
