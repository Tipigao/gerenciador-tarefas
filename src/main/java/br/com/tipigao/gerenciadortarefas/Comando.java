/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tipigao.gerenciadortarefas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author robertosilva
 */
public class Comando {
    
    public static ArrayList<String> executaComando(String comando) {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;

        ArrayList<String> lstProcessos = new ArrayList<>();
        try {
            Runtime rt = Runtime.getRuntime();

            Process p = rt.exec(comando);
            
            //long pid = getProcessID(p);

            inputStream = p.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            br = new BufferedReader(inputStreamReader);

            String ln;
            while ((ln = br.readLine()) != null) {
                lstProcessos.add(ln);
            }

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro ao executar o comando " + comando, JOptionPane.ERROR_MESSAGE);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lstProcessos;
    }
}
