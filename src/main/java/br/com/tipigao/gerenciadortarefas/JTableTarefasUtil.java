/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tipigao.gerenciadortarefas;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author robertosilva
 */
public class JTableTarefasUtil {

    private JTable tabela;
    private TarefaItemTableModel tabModel;

    public JTableTarefasUtil(JTable tabela) {
        this.tabela = tabela;
    }

    public void atualizaDados(ArrayList<TarefaItem> itens) {
        boolean ehAtualizacao = tabModel != null;

        tabModel = ehAtualizacao ? tabModel : new TarefaItemTableModel(new ArrayList<TarefaItem>());

        //Atualiza valores nas linhas
        for (int j = 0; j < tabModel.getRowCount(); j++) {

            String pidLn = (String) tabModel.getValueAt(j, TarefaItemTableModel.COLUNA_PID);
            String memoria = (String) tabModel.getValueAt(j, TarefaItemTableModel.COLUNA_MEMORIA);

            boolean pidExiste = false;
            for (int k = 0; k < itens.size(); k++) {
                TarefaItem item = itens.get(k);
                if (pidLn.equals(item.pid)) {
                    pidExiste = true;
                    if (!memoria.equals(item.qtdMemoria)) {
                        tabModel.setValueAt(item.qtdMemoria, j, TarefaItemTableModel.COLUNA_MEMORIA);
                        tabModel.fireTableRowsUpdated(j, j);
                    }
                    itens.remove(k);
                    break;
                }
            }

            if (pidExiste) {
                continue;
            }
            tabModel.removeAt(j);
            tabModel.fireTableRowsDeleted(j, j);
        }

        for (int i = 0; i < itens.size(); i++) {

            TarefaItem item = itens.get(i);

            tabModel.addItem(item);
            //tabModel.fireTableRowsInserted(i, i);
            //tabModel.
        }

        if (!ehAtualizacao) {
            tabela.setModel(tabModel);
        }
        
//        if (numColunaOrdenacao > 0) {
//            ordenarItens();
//        }

        //tabModel.fireTableDataChanged();
    }

//    private void atualizaLinhas(JTable tabela,
//            int[] linhasSelecionadas,
//            ArrayList<Object[]> linhas) {
//
//        DefaultTableModel model = ((DefaultTableModel) tabela.getModel());
//        ArrayList<String> pidsSels = new ArrayList<>();
//        for (int ii = 0; ii < linhasSelecionadas.length; ii++) {
//            int indLnSel = linhasSelecionadas[ii];
//            String pid = (String) model.getValueAt(indLnSel, TarefaItemTableModel.COLUNA_PID);
//            pidsSels.add(pid);
//        }
//
//        marcaLinhasSelecionadasPorPid(tabela, pidsSels);
//    }
//
//    private void marcaLinhasSelecionadasPorPid(JTable tabela, ArrayList<String> pidsSels) {
//
//        TableModel model = tabela.getModel();
//        int maxIndiceModel = model.getRowCount() - 1;
//
//        for (int i = 0; i < maxIndiceModel; i++) {
//            String pid = (String) model.getValueAt(i, TarefaItemTableModel.COLUNA_PID);
//            if (pidsSels.contains(pid)) {
//                tabela.addRowSelectionInterval(i, i);
//            }
//        }
//
//    }

//    public void ordenaPor(int numColuna) {
//        ascendente = !ascendente;
//        numColunaOrdenacao = numColuna;
//    }
//
//    private void ordenarItens() {
////        Collections.sort(nodeList, new Comparator<DataNode>() {
////            public int compare(DataNode o1, DataNode o2) {
////                if (o1.degree == o2.degree) {
////                    return 0;
////                }
////                return o1.degree < o2.degree ? -1 : 1;
////            }
////        });
//    }
}
