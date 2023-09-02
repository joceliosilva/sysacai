/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jscomp;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TelaAlterTigela extends javax.swing.JFrame {
   
    public TelaAlterTigela() {
       
        initComponents();
        TelaAlterTigela telaVendaPdv = this;
        telaVendaPdv.setLocationRelativeTo(null);
        telaVendaPdv.setExtendedState(JFrame.MAXIMIZED_BOTH);
        telaVendaPdv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carregarListaProdutos();
           
    cmbTigelas.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
           preencherCamposEdicaoTigela();
        }
    }
});

    }
    
      Preferences prefs = Preferences.userNodeForPackage(ConfiguracaoBancoDados.class);
        String urlBanco = prefs.get("urlBanco", "");
        String host = prefs.get("host", "");
        String porta = prefs.get ("porta", "");
        String nomebd = prefs.get("nomeBanco","" );
        String usuario = prefs.get("usuario", "");
        String senha = prefs.get("senha", "");
     
    
     private void carregarListaProdutos() {
    try {
        // Estabeleça a conexão com o banco de dados (substitua com suas próprias configurações)
      Connection conn = DriverManager.getConnection(urlBanco, usuario, senha);

        // Crie uma consulta SQL para obter os nomes dos produtos da tabela "produto"
        String sql = "SELECT nome FROM tigela";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        // Limpe o ComboBox antes de adicionar os novos itens
        cmbTigelas.removeAllItems();
        cmbTigelas.addItem("Selecione...");
        // Preencha o ComboBox com os nomes dos produtos
        while (rs.next()) {
            String nomeProduto = rs.getString("nome");
            cmbTigelas.addItem(nomeProduto);
        }

        // Feche a conexão
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar lista de produtos: " + ex.getMessage());
    }
}
     
  private void preencherCamposEdicaoTigela() {
    // Obtenha o nome da tigela selecionada no JComboBox
    String nomeTigelaSelecionada = (String) cmbTigelas.getSelectedItem();

    if (nomeTigelaSelecionada != null && !nomeTigelaSelecionada.isEmpty()) {
        try {
            // Estabeleça a conexão com o banco de dados
            Connection conn = DriverManager.getConnection(urlBanco, usuario, senha);

            // Crie uma consulta SQL para selecionar os dados da tigela
            String sql = "SELECT nome, tara, unica FROM tigela WHERE nome = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nomeTigelaSelecionada);

            // Execute a consulta
            ResultSet rs = pstmt.executeQuery();

            // Preencha os campos de edição com os dados da tigela
            if (rs.next()) {
                String nomeTigela = rs.getString("nome");
                double taraTigela = rs.getDouble("tara");
                boolean tigelaUnica = rs.getBoolean("unica");

                // Preencha os campos de edição com os dados da tigela
                txtNome.setText(nomeTigela);
                txtTara.setText(String.valueOf(taraTigela));
                chkUnica.setSelected(tigelaUnica);
            }

            // Feche a conexão
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao preencher os campos de edição: " + ex.getMessage());
        }
    }
}

     
     
     private void salvarAlteracoesTigela() {
    try {
        // Obtenha os dados editados da tigela
        String novoNome = txtNome.getText();
        double novaTara = Double.parseDouble(txtTara.getText());
        boolean tigelaUnica = chkUnica.isSelected(); // Verifique o estado do checkbox
        String nometigela = (String) cmbTigelas.getSelectedItem();
        // Estabeleça a conexão com o banco de dados
        Connection conn = DriverManager.getConnection(urlBanco, usuario, senha);

        // Crie uma consulta SQL para atualizar os dados da tigela
        String sql = "UPDATE tigela SET nome = ?, tara = ?, unica = ? WHERE nome = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, novoNome);
        pstmt.setDouble(2, novaTara);
        pstmt.setBoolean(3, tigelaUnica);
        pstmt.setString(4, nometigela); // Substitua com o ID da tigela que está sendo editada

        // Execute a consulta de atualização
        pstmt.executeUpdate();

        JOptionPane.showMessageDialog(this, "Alterações na tigela salvas com sucesso.");

        txtNome.setText("");
        txtTara.setText("");
        chkUnica.setSelected(false);
        // Feche a conexão
        conn.close();

        // Atualize a tela ou recarregue os dados da tigela
        carregarListaProdutos();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao salvar alterações na tigela: " + ex.getMessage());
    }
}


      



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bntVoltar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAlterProd = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        cmbTigelas = new javax.swing.JComboBox<>();
        txtTara = new javax.swing.JTextField();
        chkUnica = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALTERAR TIGELA - SYSAÇAÍ");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 51, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SYS AÇAÍ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bntVoltar.setText("<");
        bntVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(bntVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(556, 556, 556))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addComponent(bntVoltar))
        );

        jPanel4.setBackground(new java.awt.Color(153, 51, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRAR PRODUTO"));

        btnAlterProd.setText("SALVAR");
        btnAlterProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterProdActionPerformed(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("NOME"));

        cmbTigelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTigelas.setBorder(javax.swing.BorderFactory.createTitledBorder("SELECIONE TIGELA"));

        txtTara.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTara.setToolTipText("Digite o preço...");
        txtTara.setBorder(javax.swing.BorderFactory.createTitledBorder("TARA"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ÚNICA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome)
                    .addComponent(cmbTigelas, 0, 261, Short.MAX_VALUE)
                    .addComponent(txtTara, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAlterProd, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(chkUnica)
                        .addGap(147, 147, 147))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(cmbTigelas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(txtTara, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkUnica)
                    .addComponent(jLabel2))
                .addGap(72, 72, 72)
                .addComponent(btnAlterProd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterProdActionPerformed
            salvarAlteracoesTigela();
    }//GEN-LAST:event_btnAlterProdActionPerformed

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
      TelaInicial ini = new TelaInicial();
      ini.setVisible(true);
      dispose();
    }//GEN-LAST:event_bntVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
         
         java.awt.EventQueue.invokeLater(() -> {
            TelaAlterTigela telaInicial = new TelaAlterTigela();
            telaInicial.setLocationRelativeTo(null); // Centralize a tela
            telaInicial.setVisible(true);
         });
    }
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVoltar;
    public javax.swing.JButton btnAlterProd;
    private javax.swing.JCheckBox chkUnica;
    private javax.swing.JComboBox<String> cmbTigelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTara;
    // End of variables declaration//GEN-END:variables
}
