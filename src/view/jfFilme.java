/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexao.Conexao;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Filme;
import model.Usuario;
import net.proteanit.sql.DbUtils;
import services.FilmeServicos;
import services.ServicosFactory;
import services.UsuarioServicos;

/**
 *
 * @author sarin
 */
public class jfFilme extends javax.swing.JFrame {

    /**
     * Creates new form jfFilme
     */
    public jfFilme() {
        initComponents();
        addRowToTable();
        jbExcluir.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public boolean validaInputs() {
        if (jtfTitulo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher título!");
            jtfTitulo.requestFocus();
            return false;
        } else if (jtfAnoLancamento.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher ano de lançamento!");
            jtfAnoLancamento.requestFocus();
            return false;
        } else if (jtfAtores.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher atores!");
            jtfAtores.requestFocus();
            return false;
        } else if (jtfNacionalidade.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher nacionalidade!");
            jtfNacionalidade.requestFocus();
            return false;
        } else if (jtfGenero.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher gênero!");
            jtfGenero.requestFocus();
            return false;
        } else if (jtfDuracaoTempo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher duração do tempo!");
            jtfDuracaoTempo.requestFocus();
            return false;
        } else if (jtfEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher e-mail!");
            jtfEmail.requestFocus();
            return false;
        }
        return true;
    }//fim validaInputs

    private void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) jtFilmes.getModel();
        model.getDataVector().removeAllElements();//Remove todas as linhas.
        model.fireTableDataChanged();
        Object rowData[] = new Object[8];//rowData é o vetor para popular a linha da tabela por coluna
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        String mail = MenuPrincipal.emailLogado;
        for (Filme f : filmeS.buscaFilmes(mail)) {//O vetor sempre começa em 0           
            rowData[0] = f.getCaminhoImagem();
            rowData[1] = f.getTitulo();
            rowData[2] = f.getAnoLancamento();
            rowData[3] = f.getNomeAtor();
            rowData[4] = f.getNacionalidade();
            rowData[5] = f.getGenero();
            rowData[6] = f.getDuracaoEspera();
            rowData[7] = f.getIdUsuario().getNomeUsuario();
            model.addRow(rowData);//Add para popular.
        }
    }

    public void somenteNum(java.awt.event.KeyEvent evt) {
        String number = "0123456789";
        if (jtfAnoLancamento.getText().length() < 13) {
            if (!number.contains(evt.getKeyChar() + "")) {//evento(evt) a tecla que foi teclada.
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }

    public void somenteLetrasAcentos(java.awt.event.KeyEvent evt) {
        String nletras = "0123456789<>:?/}][{=+-_!|'\'@#$%¨&*()²³£¢¬§º°ª";
        if (nletras.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    /**
     * Método vincula os dados nos campos do formulário na tela.
     */
    public void vincularCampos() {
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        Filme f = filmeS.buscaFilmes(MenuPrincipal.emailLogado).get(jtFilmes.getSelectedRow());//Vai acessar dentro da lista de séries. "getSelectedRow" pega a linha selecionada na tabela e procura o objeto(tipo: filme) correpondente a essa linha dentro da lista e joga dentro dessa váriavel. A linha selecionada vai correposnder a um índice da lista, vai buscar dentro da lista qual objeto correspondente a esse índice.
        ImageIcon imagem = new ImageIcon(f.getCaminhoImagem());
        jlImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jlImagem.getWidth(), jlImagem.getHeight(), Image.SCALE_DEFAULT)));//Setar na jLabel. Pega o objeto imagem que foi declarado
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFilmes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jtfAnoLancamento = new javax.swing.JTextField();
        jtfAtores = new javax.swing.JTextField();
        jtfNacionalidade = new javax.swing.JTextField();
        jtfGenero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfDuracaoTempo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jlImagem = new javax.swing.JLabel();
        jbADDImagem = new javax.swing.JButton();
        jtfCaminho = new javax.swing.JTextField();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerência Filme");

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel3.setBackground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerência Filme");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
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

        jtFilmes.setBackground(new java.awt.Color(255, 255, 255));
        jtFilmes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Caminho ", "Título", "Ano de Lançamento", "Atores", "Nacionalidade", "Gênero", "Duração de Tempo", "Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFilmesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFilmes);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Título:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ano de Lançamento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nacionalidade(s):");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Atores:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gênero:");

        jtfTitulo.setBackground(new java.awt.Color(0, 153, 153));
        jtfTitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jtfTitulo.setToolTipText("Informe o título da série");
        jtfTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfTitulo.setCaretColor(new java.awt.Color(0, 0, 0));

        jtfAnoLancamento.setBackground(new java.awt.Color(0, 153, 153));
        jtfAnoLancamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfAnoLancamento.setForeground(new java.awt.Color(0, 0, 0));
        jtfAnoLancamento.setToolTipText("Informe o ano de lançamento da série");
        jtfAnoLancamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfAnoLancamento.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfAnoLancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnoLancamentoKeyTyped(evt);
            }
        });

        jtfAtores.setBackground(new java.awt.Color(0, 153, 153));
        jtfAtores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfAtores.setForeground(new java.awt.Color(0, 0, 0));
        jtfAtores.setToolTipText("Informe o elenco da série");
        jtfAtores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfAtores.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfAtores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAtoresKeyTyped(evt);
            }
        });

        jtfNacionalidade.setBackground(new java.awt.Color(0, 153, 153));
        jtfNacionalidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNacionalidade.setForeground(new java.awt.Color(0, 0, 0));
        jtfNacionalidade.setToolTipText("Informe a(s) nacionalidade(s) dos atores");
        jtfNacionalidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfNacionalidade.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfNacionalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNacionalidadeKeyTyped(evt);
            }
        });

        jtfGenero.setBackground(new java.awt.Color(0, 153, 153));
        jtfGenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfGenero.setForeground(new java.awt.Color(0, 0, 0));
        jtfGenero.setToolTipText("Informe o gênero da série");
        jtfGenero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfGenero.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfGeneroKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Duração de Tempo:");

        jtfDuracaoTempo.setBackground(new java.awt.Color(0, 153, 153));
        jtfDuracaoTempo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfDuracaoTempo.setForeground(new java.awt.Color(0, 0, 0));
        jtfDuracaoTempo.setToolTipText("Informe o tempo que parou no filme");
        jtfDuracaoTempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfDuracaoTempo.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfDuracaoTempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDuracaoTempoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuário:");

        jtfEmail.setBackground(new java.awt.Color(0, 153, 153));
        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfEmail.setForeground(new java.awt.Color(0, 0, 0));
        jtfEmail.setToolTipText("Informe seu e-mail");
        jtfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfEmail.setCaretColor(new java.awt.Color(0, 0, 0));
        jtfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEmailFocusLost(evt);
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

        jlImagem.setBackground(new java.awt.Color(0, 0, 0));
        jlImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbADDImagem.setBackground(new java.awt.Color(71, 82, 82));
        jbADDImagem.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jbADDImagem.setForeground(new java.awt.Color(255, 255, 255));
        jbADDImagem.setText("Add imagem");
        jbADDImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbADDImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbADDImagemActionPerformed(evt);
            }
        });

        jtfCaminho.setBackground(new java.awt.Color(104, 127, 127));
        jtfCaminho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfCaminho.setForeground(new java.awt.Color(0, 0, 0));
        jtfCaminho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfCaminho.setCaretColor(new java.awt.Color(0, 0, 0));

        jtfPesquisa.setBackground(new java.awt.Color(104, 127, 127));
        jtfPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pesquisa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDuracaoTempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addComponent(jtfGenero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfNacionalidade, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfAtores, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfAnoLancamento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfEmail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbADDImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfAnoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfAtores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jtfDuracaoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbADDImagem)
                            .addComponent(jtfCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbLimpar)
                            .addComponent(jbAlterar)
                            .addComponent(jbSalvar)
                            .addComponent(jbExcluir)
                            .addComponent(jbFechar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(7, Short.MAX_VALUE))
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

    private void jtFilmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFilmesMouseClicked
        // TODO add your handling code here:
        jbAlterar.setEnabled(true);
        jbExcluir.setVisible(true);
        vincularCampos();
    }//GEN-LAST:event_jtFilmesMouseClicked

    private void jtfAnoLancamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnoLancamentoKeyTyped
        // TODO add your handling code here:
        somenteNum(evt);
    }//GEN-LAST:event_jtfAnoLancamentoKeyTyped

    private void jtfAtoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAtoresKeyTyped
        // TODO add your handling code here:
        somenteLetrasAcentos(evt);
    }//GEN-LAST:event_jtfAtoresKeyTyped

    private void jtfNacionalidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNacionalidadeKeyTyped
        // TODO add your handling code here:
        somenteLetrasAcentos(evt);
    }//GEN-LAST:event_jtfNacionalidadeKeyTyped

    private void jtfGeneroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfGeneroKeyTyped
        // TODO add your handling code here:
        somenteLetrasAcentos(evt);
    }//GEN-LAST:event_jtfGeneroKeyTyped

    private void jtfDuracaoTempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDuracaoTempoKeyTyped
        // TODO add your handling code here:
        String numberPonto = "0123456789.";
        if (jtfDuracaoTempo.getText().length() < 13) {
            if (!numberPonto.contains(evt.getKeyChar() + "")) {//evento(evt) a tecla que foi teclada.
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jtfDuracaoTempoKeyTyped

    private void jtfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusLost
        // TODO add your handling code here:
        UsuarioServicos usuS = ServicosFactory.getUsuarioServicos();
        Usuario usu = usuS.buscarUsuariobyEmail(jtfEmail.getText());
        if (usu.getEmail() == null) {
            JOptionPane.showMessageDialog(this, "Usuário não cadastrado!", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Object[] resp = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(this, "Usuario " + usu.getNomeUsuario() + " está correto? ", "Pesquisa", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
            if (resposta == 1) {
                jtfEmail.setText("");
                jtfEmail.requestFocus();
            }
        }
    }//GEN-LAST:event_jtfEmailFocusLost

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        jbSalvar.setText("Confirmar");
        jtfTitulo.setEnabled(false);
        jtfAnoLancamento.setEnabled(false);
        jtfAtores.setEnabled(false);
        jtfNacionalidade.setEnabled(false);
        jtfGenero.setEnabled(false);
        jtfEmail.setEnabled(false);
        jbLimpar.setText("Cancelar");
        jbExcluir.setVisible(false);

        //Pegando dados da tabela e add em variaveis locais.
        int linha;
        linha = jtFilmes.getSelectedRow();
        String titulo = (String) jtFilmes.getValueAt(linha, 1);
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        Filme f = filmeS.buscaFilmeTitulo(titulo);
        //Carregar dados da tabela no form
        jtfCaminho.setText(f.getCaminhoImagem());
        jtfTitulo.setText(f.getTitulo());
        jtfAnoLancamento.setText(String.valueOf(f.getAnoLancamento()));
        jtfAtores.setText(f.getNomeAtor());
        jtfNacionalidade.setText(f.getNacionalidade());
        jtfGenero.setText(f.getGenero());
        jtfDuracaoTempo.setText(String.valueOf(f.getDuracaoEspera()));
        jtfEmail.setText(f.getIdUsuario().getEmail());
        jtfTitulo.requestFocus();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        if (jbLimpar.getText().equals("Limpar")) {
            limparCampos();
        } else {
            limparCampos();
            jbLimpar.setText("Limpar");
            jbSalvar.setText("Salvar");
            jbAlterar.setEnabled(false);
            jtfTitulo.setEnabled(true);
            jbExcluir.setVisible(false);
        }
    }

    public void limparCampos() {
        jlImagem.setIcon(null);
        jtfCaminho.setText("");
        jtfTitulo.setText("");
        jtfAnoLancamento.setText("");
        jtfAtores.setText("");
        jtfNacionalidade.setText("");
        jtfGenero.setText("");
        jtfDuracaoTempo.setText("");
        jtfEmail.setText("");
        jtfTitulo.requestFocus();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        int linha;
        String titulo;
        linha = jtFilmes.getSelectedRow();
        titulo = (String) jtFilmes.getValueAt(linha, 1);
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this, "Deseja realmente deletar este título? ", "Deletar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
        if (resposta == 0) {
            filmeS.removerFilme(titulo);
            addRowToTable();
            JOptionPane.showMessageDialog(this, "Filme deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Ok, operação cancelada!");
        }
        jbExcluir.setVisible(false);
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (validaInputs()) {
            //Pegar dados da tela para salvar
            int idFilme = 0;
            String caminhoImagem = jtfCaminho.getText();
            String titulo = jtfTitulo.getText().toUpperCase();
            int anoLancamento = Integer.parseInt(jtfAnoLancamento.getText());
            String nomeAtor = jtfAtores.getText().toUpperCase();
            String nacionalidade = jtfNacionalidade.getText().toUpperCase();
            String genero = jtfGenero.getText().toUpperCase();
            float duracaoTempo = Float.parseFloat(jtfDuracaoTempo.getText());
            UsuarioServicos usuS = ServicosFactory.getUsuarioServicos();
            Usuario usu = usuS.buscarUsuariobyEmail(jtfEmail.getText());
            FilmeServicos filmeS = ServicosFactory.getFilmeServicos();

            Filme f = new Filme(idFilme, titulo, anoLancamento, nomeAtor, nacionalidade, genero, duracaoTempo, caminhoImagem, usu);
            if (jbSalvar.getText().equals("Salvar")) {
                filmeS.cadFilme(f);
            } else {
                filmeS.atualizarFilme(f);
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

    private void jbADDImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbADDImagemActionPerformed
        // TODO add your handling code here:
        JFileChooser arquivo = new JFileChooser();//Objeto
        arquivo.setDialogTitle("Selecione e carregue uma imagem");//Título da janela que vai ser aberto
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);//Esse componente vai receber uma propriedade para deixar só selecionar um arquivo somente por vez.
        int op = arquivo.showOpenDialog(this);//Variável tipo inteira que ela vai fazer uma verificação que está pedindo para abrir a janela ali mesmo para que se possa escolher uma imagem
        //Verificação se ouve seleção opção 1
        if (op == JFileChooser.APPROVE_OPTION) {
            File file = new File("");//Declaração de objeto
            //Vai receber a variável
            file = arquivo.getSelectedFile();//Traz o arquivo selecionado
            //Armazenar o caminho
            String fileName = file.getAbsolutePath(); //Pegar o caminho absoluto de onde está a imagem
            //Setar "jtfCaminho" caminho absoluto
            jtfCaminho.setText(fileName);
            //Adionar a imagem na jLabel
            ImageIcon imagem = new ImageIcon(file.getPath());//Vai pegar o caminho do arquivo onde ele está
            jlImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jlImagem.getWidth(), jlImagem.getHeight(), Image.SCALE_DEFAULT)));//Seta a imagem. Variável(ImageIcon) o conteúdo("imagem"(imagem que está no caminho)). Vai se ajustar aquela jLabel(Image.SCALE_DEFAULT).

        }
    }//GEN-LAST:event_jbADDImagemActionPerformed

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        // Em quanto vai digitando, o KeyReleased vai dinâmicamente preeechendo a tabela.
        pesquisaSerie();
    }//GEN-LAST:event_jtfPesquisaKeyReleased

    public void pesquisaSerie() {
        String mail = MenuPrincipal.emailLogado;
        String sql = "select filmes.*, e.email from filmes join usuarios e using(idUsuario) where titulo like ? and e.email = ?";//' para executar para o banco(mysql)

        try {//Para tratar erros
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jtfPesquisa.getText() + "%");
            pst.setString(2, mail);
            ResultSet rs = pst.executeQuery();//ResultSet estrutura no java, é um meio de campo entre o banco de dados e o java(aplicação).
            jtFilmes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Filme Pesquisar: " + erro);
        }

    }//fim listar
    
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
            java.util.logging.Logger.getLogger(jfFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbADDImagem;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlImagem;
    private javax.swing.JTable jtFilmes;
    private javax.swing.JTextField jtfAnoLancamento;
    private javax.swing.JTextField jtfAtores;
    private javax.swing.JTextField jtfCaminho;
    private javax.swing.JTextField jtfDuracaoTempo;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfGenero;
    private javax.swing.JTextField jtfNacionalidade;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
