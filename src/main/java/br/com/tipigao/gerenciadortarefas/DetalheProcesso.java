/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tipigao.gerenciadortarefas;

import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 * @author robertosilva
 */
public class DetalheProcesso extends javax.swing.JFrame {

    /**
     * Creates new form DetalheProcesso
     */
    public DetalheProcesso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        pnlDados = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlDados.setContentType("text/html"); // NOI18N
        pnlDados.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n   <table border=\"1\">\n<tr style=\"background-color:#a0a0ff;font:10pt Tahoma;font-weight:bold;\" align=\"left\">\n<td>Node</td>\n</tr>\n</table>\n\n  </body>\r\n</html>\r\n");
        jScrollPane2.setViewportView(pnlDados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.ipady = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPid(String pid){
        String campos = "Caption,CommandLine,CreationClassName,CreationDate,CSCreationClassName,CSName,Description,ExecutablePath,ExecutionState,Handle,HandleCount,InstallDate,KernelModeTime,MaximumWorkingSetSize,MinimumWorkingSetSize,Name,OSCreationClassName,OSName,OtherOperationCount,OtherTransferCount,PageFaults,PageFileUsage,ParentProcessId,PeakPageFileUsage,PeakVirtualSize,PeakWorkingSetSize,Priority,PrivatePageCount,ProcessId,QuotaNonPagedPoolUsage,QuotaPagedPoolUsage,QuotaPeakNonPagedPoolUsage,QuotaPeakPagedPoolUsage,ReadOperationCount,ReadTransferCount,SessionId,Status,TerminationDate,ThreadCount,UserModeTime,VirtualSize,WindowsVersion,WorkingSetSize,WriteOperationCount,WriteTransferCount";
        String cmd = "wmic process "+pid+" get "+campos+" /Format:htable";
        ArrayList<String> retorno = Comando.executaComando(cmd);
        
        StringBuilder sb = new StringBuilder();
        
        for(String s: retorno){
            sb.append(s).append("\n");
        }
        
        pnlDados.setText(sb.toString());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetalheProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalheProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalheProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalheProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalheProcesso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JEditorPane pnlDados;
    // End of variables declaration//GEN-END:variables
}