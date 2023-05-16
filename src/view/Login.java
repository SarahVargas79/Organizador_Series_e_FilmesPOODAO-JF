/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sarin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);//Para centralizar a janela
    }

    public boolean validaInputs() {
        if (jtfEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher e-mail!");
            jtfEmail.requestFocus();
            return false;
        } else if (new String(jpfSenha.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher senha!");
            jpfSenha.requestFocus();
            return false;
        }
        return true;
    }//fim validaInputs

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jbCriarConta = new javax.swing.JButton();
        jbEntrar = new javax.swing.JButton();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acesso");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-mail");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jtfEmail.setBackground(new java.awt.Color(0, 0, 0));
        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfEmail.setForeground(new java.awt.Color(255, 255, 255));
        jtfEmail.setToolTipText("Informa e-mail cadastrado ");
        jtfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 231, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 231, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 231, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(19, 196, 19));
        jLabel4.setText("Esqueceu a senha?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        jbCriarConta.setBackground(new java.awt.Color(0, 0, 204));
        jbCriarConta.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jbCriarConta.setForeground(new java.awt.Color(255, 255, 255));
        jbCriarConta.setText("Criar Conta");
        jbCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCriarContaActionPerformed(evt);
            }
        });
        jPanel1.add(jbCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        jbEntrar.setBackground(new java.awt.Color(0, 0, 204));
        jbEntrar.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jbEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jbEntrar.setText("Entrar");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jpfSenha.setBackground(new java.awt.Color(0, 0, 0));
        jpfSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpfSenha.setForeground(new java.awt.Color(255, 255, 255));
        jpfSenha.setToolTipText("Informe senha cadastrada");
        jpfSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpfSenha.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jpfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 231, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/capa login.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEntrarActionPerformed
        // TODO add your handling code here:
        // O ? é subtituído pelo conteúdo das variáveis(email e senha). 

        try {
            Connection con = Conexao.getConexao();
            //As linhas abaixo preparam a consulta ao banco em função do que foi digitado nas caixas de texto.
            String sql = "select * from usuarios where email = ? and senha = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jtfEmail.getText());
            pst.setString(2, new String(jpfSenha.getPassword()));
            //A linha abaixo executa a query, vai fazer a pesquisa no BD.
            ResultSet rs = pst.executeQuery();
            //Se existir usuário e senha correspondente.
            if (rs.next()) {
                //Chama a tela 
                MenuPrincipal menuP = new MenuPrincipal();
                menuP.setVisible(true);
                setVisible(false);//Para esconder a tela de Login

                JOptionPane.showMessageDialog(this, "Seja Bem-Vindo");
            } else {
                JOptionPane.showMessageDialog(this, "Email ou senha incorretos.");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {//Caso ocorra alguma exceção.
            ex.printStackTrace();//Variável ex vai exibir a mensagem de erro.
        }
    }//GEN-LAST:event_jbEntrarActionPerformed

    private void jbCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCriarContaActionPerformed
        // TODO add your handling code here:
        TelaCadastro telaCad = new TelaCadastro();
        telaCad.setVisible(true);
    }//GEN-LAST:event_jbCriarContaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCriarConta;
    private javax.swing.JButton jbEntrar;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfEmail;
    // End of variables declaration//GEN-END:variables
}