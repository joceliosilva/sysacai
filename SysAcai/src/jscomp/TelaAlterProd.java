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


public class TelaAlterProd extends javax.swing.JFrame {
   
    public TelaAlterProd() {
       
        initComponents();
        TelaAlterProd telaVendaPdv = this;
        telaVendaPdv.setLocationRelativeTo(null);
        telaVendaPdv.setExtendedState(JFrame.MAXIMIZED_BOTH);
        telaVendaPdv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carregarListaProdutos();
           
    cmbProdutos.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            carregarDadosProduto();
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
        String sql = "SELECT nome FROM produto";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        // Limpe o ComboBox antes de adicionar os novos itens
        cmbProdutos.removeAllItems();

        // Preencha o ComboBox com os nomes dos produtos
        while (rs.next()) {
            String nomeProduto = rs.getString("nome");
            cmbProdutos.addItem(nomeProduto);
        }

        // Feche a conexão
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar lista de produtos: " + ex.getMessage());
    }
}
     
     private void carregarDadosProduto() {
    try {
        // Obtém o nome do produto selecionado no ComboBox
        String nomeProdutoSelecionado = (String) cmbProdutos.getSelectedItem();

        // Verifica se um produto foi selecionado
        if (nomeProdutoSelecionado == null || nomeProdutoSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para carregar os dados.");
            return;
        }

        // Estabeleça a conexão com o banco de dados (substitua com suas próprias configurações)
       Connection conn = DriverManager.getConnection(urlBanco, usuario, senha);

        // Crie uma consulta SQL para obter os dados do produto com base no nome
        String sql = "SELECT nome, preco FROM produto WHERE nome = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nomeProdutoSelecionado);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Preenche os campos da interface gráfica com os dados carregados
            txtNome.setText(rs.getString("nome"));
            txtPreco.setText(String.valueOf(rs.getDouble("preco")));
            //txtEstoque.setText(String.valueOf(rs.getInt("estoque")));
        }

        // Feche a conexão
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar dados do produto: " + ex.getMessage());
    }
    
    
}

      private void salvarDadosProduto() {
    try {
        // Obtém o nome do produto selecionado no JComboBox
        String nomeProdutoSelecionado = (String) cmbProdutos.getSelectedItem();

        // Verifica se um produto foi selecionado
        if (nomeProdutoSelecionado == null || nomeProdutoSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para salvar os dados.");
            return;
        }

        // Obtém os novos valores dos campos da interface gráfica
        String novoNome = txtNome.getText();
        double novoPreco = Double.parseDouble(txtPreco.getText());
        //int novoEstoque = Integer.parseInt(txtEstoque.getText());

        // Estabeleça a conexão com o banco de dados (substitua com suas próprias configurações)
        Connection conn = DriverManager.getConnection(urlBanco, usuario, senha);

        // Crie uma consulta SQL para atualizar os dados do produto
        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE nome = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, novoNome);
        pstmt.setDouble(2, novoPreco);
        //pstmt.setInt(3, novoEstoque);
        pstmt.setString(3, nomeProdutoSelecionado);

        // Execute a consulta de atualização
        pstmt.executeUpdate();

        JOptionPane.showMessageDialog(this, "Dados do produto salvos com sucesso.");
        carregarListaProdutos();
        txtNome.setText("");
        txtPreco.setText("");
        // Feche a conexão
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao salvar dados do produto: " + ex.getMessage());
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
        cmbProdutos = new javax.swing.JComboBox<>();
        txtPreco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALTERAR PRODUTO - SYSAÇAÍ");
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

        cmbProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("SELECIONE O PORDUTO"));

        txtPreco.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPreco.setToolTipText("Digite o preço...");
        txtPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("PREÇO"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome)
                    .addComponent(cmbProdutos, 0, 261, Short.MAX_VALUE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterProd, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(cmbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
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
            salvarDadosProduto();
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
            TelaAlterProd telaInicial = new TelaAlterProd();
            telaInicial.setLocationRelativeTo(null); // Centralize a tela
            telaInicial.setVisible(true);
         });
    }
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVoltar;
    public javax.swing.JButton btnAlterProd;
    private javax.swing.JComboBox<String> cmbProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
