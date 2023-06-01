/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import services.ServicosFactory;
import services.UsuarioServicos;

/**
 *
 * @author sarin
 */
public class jfUsuario extends javax.swing.JFrame {

    /**
     * Creates new form jfUsuario
     */
    public jfUsuario() {
        initComponents();
        addRowToTable();
        jbExcluir.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public boolean validaInputs() {
        if (jtfNome.getText().equals("")) {
            jtfNome.requestFocus();
            return false;
        } else if (jtfEmail.getText().equals("")) {
            jtfEmail.requestFocus();
            return false;
        } else if (new String(jpfSenha.getPassword()).equals("")) {
            jpfSenha.requestFocus();
            return false;
        } else if (new String(jpfConfirmaSenha.getPassword()).equals("")) {
            jpfConfirmaSenha.requestFocus();
            return false;
        }
        return true;
    }//fim validaInputs

    private void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) jtUsuarios.getModel();
        model.getDataVector().removeAllElements();//Remove todas as linhas.
        model.fireTableDataChanged();
        Object rowData[] = new Object[4];//rowData é o vetor para popular a linha da tabela por coluna
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        String mail = MenuPrincipal.emailLogado;
        for (Usuario usu : usuarioS.getUsuarios(mail)) {//O vetor sempre começa em 0
            rowData[0] = usu.getNomeUsuario();
            rowData[1] = usu.getEmail();
            rowData[2] = usu.getSenha();
            rowData[3] = usu.getConfirmaSenha();
            model.addRow(rowData);//Add para popular.
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jpfConfirmaSenha = new javax.swing.JPasswordField();
        jbLimpar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerência Usuário");

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");

        jtfNome.setBackground(new java.awt.Color(93, 153, 184));
        jtfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNome.setForeground(new java.awt.Color(0, 0, 0));
        jtfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfNome.setCaretColor(new java.awt.Color(0, 0, 0));

        jtfEmail.setBackground(new java.awt.Color(93, 153, 184));
        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfEmail.setForeground(new java.awt.Color(0, 0, 0));
        jtfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfEmail.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Senha:");

        jpfSenha.setBackground(new java.awt.Color(93, 153, 184));
        jpfSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpfSenha.setForeground(new java.awt.Color(0, 0, 0));
        jpfSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpfSenha.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar senha:");

        jpfConfirmaSenha.setBackground(new java.awt.Color(93, 153, 184));
        jpfConfirmaSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpfConfirmaSenha.setForeground(new java.awt.Color(0, 0, 0));
        jpfConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpfConfirmaSenha.setCaretColor(new java.awt.Color(0, 0, 0));

        jbLimpar.setBackground(new java.awt.Color(0, 0, 255));
        jbLimpar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbLimpar.setForeground(new java.awt.Color(255, 255, 255));
        jbLimpar.setText("Limpar");
        jbLimpar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbAlterar.setBackground(new java.awt.Color(0, 0, 255));
        jbAlterar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jbAlterar.setText("Alterar");
        jbAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setBackground(new java.awt.Color(0, 0, 255));
        jbExcluir.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("Excluir");
        jbExcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbSalvar.setBackground(new java.awt.Color(0, 0, 255));
        jbSalvar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jbSalvar.setText("Salvar");
        jbSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbFechar.setBackground(new java.awt.Color(232, 0, 0));
        jbFechar.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbFechar.setForeground(new java.awt.Color(255, 255, 255));
        jbFechar.setText("Fechar");
        jbFechar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jtUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jtUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nome", "E-mail", "Senha", "Confirmar senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuarios);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerência Usuário");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfEmail)
                                    .addComponent(jtfNome)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpfSenha))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpfConfirmaSenha)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jpfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFechar)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar)
                    .addComponent(jbAlterar)
                    .addComponent(jbSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        if (jbLimpar.getText().equals("Limpar")) {
            limparCampos();
        } else {
            limparCampos();
            jbLimpar.setText("Limpar");
            jbSalvar.setText("Salvar");
            jbAlterar.setEnabled(false);
            jtfEmail.setEnabled(true);
            jbExcluir.setVisible(false);
        }
    }

    public void limparCampos() {
        jtfNome.setText("");
        jtfEmail.setText("");
        jpfSenha.setText("");
        jpfConfirmaSenha.setText("");
        jtfNome.requestFocus();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        jbSalvar.setText("Confirmar");
        jtfEmail.setEnabled(false);
        jbLimpar.setText("Cancelar");
        jbExcluir.setVisible(false);

        //Pegando dados da tabela e add em variaveis locais.
        int linha;
        linha = jtUsuarios.getSelectedRow();
        String nome = (String) jtUsuarios.getValueAt(linha, 0);
        String email = (String) jtUsuarios.getValueAt(linha, 1);
        String senha = (String) jtUsuarios.getValueAt(linha, 2);
        String confirmarSenha = (String) jtUsuarios.getValueAt(linha, 3);
        //Carregar dados da tabela no form
        jtfNome.setText(nome);
        jtfEmail.setText(email);
        jpfSenha.setText(senha);
        jpfConfirmaSenha.setText(confirmarSenha);
        jtfNome.requestFocus();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        int linha;
        String email;
        linha = jtUsuarios.getSelectedRow();
        email = (String) jtUsuarios.getValueAt(linha, 1);
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this, "Deseja realmente deletar este e-mail? ", "Deletar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
        if (resposta == 0) {
            usuarioS.removerUsuario(email);
            addRowToTable();

            JOptionPane.showMessageDialog(this, "Usuario deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Ok, operação cancelada!");
        }
        jbExcluir.setVisible(false);
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (validaInputs()) {
            //Pegar dados da tela para salvar
            int idUsuario = 0;
            String nomeUsuario = jtfNome.getText().toUpperCase();
            String email = jtfEmail.getText();
            String senha = new String(jpfSenha.getPassword());
            String confirmarSenha = new String(jpfConfirmaSenha.getPassword());
            UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();

            Usuario c = new Usuario(idUsuario, nomeUsuario, email, senha, confirmarSenha, senha, senha, confirmarSenha);
            if (jbSalvar.getText().equals("Salvar")) {
                usuarioS.cadUsuario(c);
            } else {
                usuarioS.atualizarUsuario(c);
                jbLimpar.doClick();
            }
            limparCampos();
            addRowToTable();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        // TODO add your handling code here:
        jbAlterar.setEnabled(true);
        jbExcluir.setVisible(true);
    }//GEN-LAST:event_jtUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(jfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPasswordField jpfConfirmaSenha;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables

}
