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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import services.ServicosFactory;
import services.UsuarioServicos;
import util.Validadores;

/**
 *
 * @author 182010049
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
        this.setLocationRelativeTo(null);//Para centralizar a janela
    }

    public boolean validaInputs() {
        if (jtfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher nome!");
            jtfNome.requestFocus();
            return false;
        } else if (jtfEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher e-mail!");
            jtfEmail.requestFocus();
            return false;
        } else if (new String(jpfSenha.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher senha!");
            jpfSenha.requestFocus();
            return false;
        } else if (new String(jpfConfirmaSenha.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher confirmar senha!");
            jpfConfirmaSenha.requestFocus();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jpfConfirmaSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jbLimpar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Cadastro");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Usuário");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome:");

        jtfNome.setBackground(new java.awt.Color(165, 66, 0));
        jtfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNome.setForeground(new java.awt.Color(0, 0, 0));
        jtfNome.setToolTipText("Informe nome completo");
        jtfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfNome.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("E-mail:");

        jtfEmail.setBackground(new java.awt.Color(165, 66, 0));
        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfEmail.setForeground(new java.awt.Color(0, 0, 0));
        jtfEmail.setToolTipText("Informe e-mail válido");
        jtfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfEmail.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEmailFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Senha:");

        jpfSenha.setBackground(new java.awt.Color(165, 66, 0));
        jpfSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpfSenha.setForeground(new java.awt.Color(0, 0, 0));
        jpfSenha.setToolTipText("Informe senha válida");
        jpfSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpfSenha.setCaretColor(new java.awt.Color(0, 0, 0));
        jpfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfSenhaFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Confirmar senha:");

        jpfConfirmaSenha.setBackground(new java.awt.Color(165, 66, 0));
        jpfConfirmaSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpfConfirmaSenha.setForeground(new java.awt.Color(0, 0, 0));
        jpfConfirmaSenha.setToolTipText("Informe a mesma senha do campo acima");
        jpfConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpfConfirmaSenha.setCaretColor(new java.awt.Color(0, 0, 0));
        jpfConfirmaSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfConfirmaSenhaFocusLost(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cadastro-48 .png"))); // NOI18N

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbLimpar.setBackground(new java.awt.Color(128, 128, 128));
        jbLimpar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbLimpar.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbSalvar.setBackground(new java.awt.Color(128, 128, 128));
        jbSalvar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbSalvar.setForeground(new java.awt.Color(0, 0, 0));
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(new java.awt.Color(252, 0, 0));
        jbCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jbLimpar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jbSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jbCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar)
                    .addComponent(jbCancelar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLayeredPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNome)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        // TODO add your handling code here:
        //Só vai aceitar letras.
        String nletras = "0123456789<>:?/}][{=+-_!|'\'@#$%¨&*()²³£¢¬§º°ª";
        if (nletras.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jtfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusLost
        // TODO add your handling code here:
        if (!jtfEmail.getText().equals("")) {
            if (!Validadores.isValidEmailAddressRegex(jtfEmail.getText())) {
                JOptionPane.showMessageDialog(this, "E-mail inválido. Digite o formato correto!", "Erro e-mail", JOptionPane.ERROR_MESSAGE);
                jtfEmail.requestFocus();
            }
        }
    }//GEN-LAST:event_jtfEmailFocusLost

    private void jpfSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfSenhaFocusLost
        // TODO add your handling code here:
        if (!new String(jpfSenha.getPassword()).equals("")) {
            if (!Validadores.senhaForte(new String(jpfSenha.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Sua senha deve conter no mínimo 8 caracteres, \nletra maiúscula e minúscula, \nnúmero e caractér especial .", "Erro senha", JOptionPane.ERROR_MESSAGE);
                jpfSenha.requestFocus();
            }
        }
    }//GEN-LAST:event_jpfSenhaFocusLost

    private void jpfConfirmaSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfConfirmaSenhaFocusLost
        // TODO add your handling code here:
        String senha = new String(jpfSenha.getPassword());
        String confirSenha = new String(jpfConfirmaSenha.getPassword());

        if (senha.equals(confirSenha)) {
            JOptionPane.showMessageDialog(this, "Senhas conferem");
        } else {
            JOptionPane.showMessageDialog(this, "Senhas não conferem", "Erro confirmar senha", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jpfConfirmaSenhaFocusLost

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        if (jbLimpar.getText().equals("Limpar")) {
            limparCampos();
        } else {
            limparCampos();
            jbLimpar.setText("Limpar");
            jbSalvar.setText("Salvar");
        }
    }

    public void limparCampos() {
        jtfNome.setText("");
        jtfEmail.setText("");
        jpfSenha.setText("");
        jpfConfirmaSenha.setText("");
        jtfNome.requestFocus();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        if (validaInputs()) {
            //Pegar dados da tela para salvar
            int idUsuario = 0;
            String nomeUsuario = jtfNome.getText().toUpperCase();
            String email = jtfEmail.getText();
            String senha = new String(jpfSenha.getPassword());
            String confirmarSenha = new String(jpfConfirmaSenha.getPassword());
            UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
            Usuario usu = new Usuario(idUsuario, nomeUsuario, email, senha, confirmarSenha, senha, senha, confirmarSenha);

            Usuario usuarios = new Usuario();
            usuarios.setNomeUsuario(jtfNome.getText());
            usuarios.setEmail(jtfEmail.getText());
            usuarios.setSenha(new String(jpfSenha.getPassword()));
            usuarios.setConfirmaSenha(new String(jpfConfirmaSenha.getPassword()));

            if ((jtfNome.getText().isEmpty()) || (jtfEmail.getText().isEmpty()) || (new String(jpfSenha.getPassword()).isEmpty()) || (new String(jpfConfirmaSenha.getPassword()).isEmpty())) {
                usuarioS.cadUsuario(usu);
            } else if (usuarioS.buscarUsuariobyEmail(email).getEmail() != null) {
                JOptionPane.showMessageDialog(this, "Usuário " + jtfNome.getText() + " e-mail já está cadastrado!");
            } else {
                usuarioS.cadUsuario(usu);
                JOptionPane.showMessageDialog(this, "Usuário " + jtfNome.getText() + " cadastro realizado com sucesso!");
                jbLimpar.doClick();
            }

            limparCampos();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPasswordField jpfConfirmaSenha;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
