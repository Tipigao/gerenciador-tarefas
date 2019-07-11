/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tipigao.gerenciadortarefas;

/**
 *
 * @author robertosilva
 */
public class SO {

    private static String SO = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return (SO.contains("win"));
    }

    public static boolean isMac() {
        return (SO.contains("mac"));
    }

    public static boolean isUnix() {
        return (SO.contains("nix") || SO.contains("nux") || SO.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (SO.contains("sunos"));
    }
    
    public static void propriedadesGerais(){
        System.getProperties().list(System.out);
    }
}