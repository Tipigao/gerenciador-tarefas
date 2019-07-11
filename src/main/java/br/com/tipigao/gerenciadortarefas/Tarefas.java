/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tipigao.gerenciadortarefas;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Field;


/**
 *
 * @author robertosilva
 */
public class Tarefas {

    private ArrayList<TarefaItem> listaTarefasAnterior;

    public Tarefas() {
        listaTarefasAnterior = new ArrayList<TarefaItem>();
    }

    public void mataProcessoPorId(long id) {
        Comando.executaComando(String.format("taskkill /F /PID %d", id));
    }

    public void mataProcessosPorNome(String nomeProcesso) {
        //taskkill /IM "NOME_PROCESSO" /F
    }

    public ArrayList<TarefaItem> obtemTarefas() {
        ArrayList<TarefaItem> itensProcesso = new ArrayList<>();

        ArrayList<String> infoProcessos = obtemListaProcessos();

        int[][] indicesCampos = {
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0}
        };

        int indiceInicial = SO.isWindows() ? 2 : 1;

        for (int i = indiceInicial; i < infoProcessos.size(); i++) {
            String processoItem = infoProcessos.get(i).trim();

            if (processoItem.trim().length() == 0) {
                infoProcessos.remove(i);
                i--;
                continue;
            }

            if (i == indiceInicial) {
                String[] itens = processoItem.split(" ");
                int pos = 1;
                for (int j = 0; j < itens.length; j++) {
                    int tamanho = itens[j].length();

                    indicesCampos[j][0] = pos - 1;
                    indicesCampos[j][1] = pos - 1 + tamanho;

                    pos++;
                    pos += tamanho;
                }
                continue;
            }

            String nmImagem = "",
                    pid = "",
                    nmSessao = "",
                    sessao = "",
                    usoMemoria = "";

            for (int ii = 0; ii < indicesCampos.length; ii++) {
                nmImagem = ii != 0 ? nmImagem : processoItem.substring(indicesCampos[ii][0], indicesCampos[ii][1]);
                pid = ii != 1 ? pid : processoItem.substring(indicesCampos[ii][0], indicesCampos[ii][1]);
                nmSessao = ii != 2 ? nmSessao : processoItem.substring(indicesCampos[ii][0], indicesCampos[ii][1]);
                sessao = ii != 3 ? sessao : processoItem.substring(indicesCampos[ii][0], indicesCampos[ii][1]);
                usoMemoria = ii != 4 ? usoMemoria : processoItem.substring(indicesCampos[ii][0], indicesCampos[ii][1]);
            }

            TarefaItem it = new TarefaItem();
            it.nomeTarefa = nmImagem.trim();
            it.pid = pid.trim();
            it.nomeSessao = nmSessao.trim();
            it.sessao = sessao.trim();
            it.qtdMemoria = usoMemoria.trim();
//            it.ehNovaTarefa = true;
//
//            for (int j = 0; j < listaTarefasAnterior.size(); j++) {
//                TarefaItem itemAnt = listaTarefasAnterior.get(j);
//                if (it.pid.equals(itemAnt.pid)) {
//                    it.ehNovaTarefa = false;
//                    listaTarefasAnterior.remove(j);
//                    break;
//                }
//            }

            itensProcesso.add(it);
        }

        listaTarefasAnterior = itensProcesso;

//        String[] processos = new String[lstPsc.size()];
//        processos = lstPsc.toArray(processos);
//        Arrays.sort(processos);
//        List<String> infoProcessos = Arrays.asList(processos);
//        //ArrayList<String> infoProcessos = new ArrayList<String>(Arrays.asList(processos));
        return itensProcesso;
    }

    private ArrayList<String> obtemListaProcessos() {
        return Comando.executaComando("tasklist");
    }

    
    
    /**
     * https://stackoverflow.com/questions/4750470/how-to-get-pid-of-process-ive-just-started-within-java-program
     * @param p
     * @return 
     */
//    public static long getProcessID(Process p)
//    {
//        long result = -1;
//        try
//        {
//            //for windows
//            if (p.getClass().getName().equals("java.lang.Win32Process") ||
//                   p.getClass().getName().equals("java.lang.ProcessImpl")) 
//            {
//                Field f = p.getClass().getDeclaredField("handle");
//                f.setAccessible(true);              
//                long handl = f.getLong(p);
//                Kernel32 kernel = Kernel32.INSTANCE;
//                WinNT.HANDLE hand = new WinNT.HANDLE();
//                hand.setPointer(Pointer.createConstant(handl));
//                result = kernel.GetProcessId(hand);
//                f.setAccessible(false);
//            }
//            //for unix based operating systems
//            else if (p.getClass().getName().equals("java.lang.UNIXProcess")) 
//            {
//                Field f = p.getClass().getDeclaredField("pid");
//                f.setAccessible(true);
//                result = f.getLong(p);
//                f.setAccessible(false);
//            }
//        }
//        catch(Exception ex)
//        {
//            result = -1;
//        }
//        return result;
//    }

}
