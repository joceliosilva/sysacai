/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jscomp;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TelaAlterarLogo extends javax.swing.JFrame {
   
    public TelaAlterarLogo() {
       
        initComponents();
         TelaAlterarLogo telaVendaPdv = this;
        telaVendaPdv.setLocationRelativeTo(null);
        telaVendaPdv.setExtendedState(JFrame.MAXIMIZED_BOTH);
        telaVendaPdv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
      Preferences prefs = Preferences.userNodeForPackage(ConfiguracaoBancoDados.class);
        String urlBanco = prefs.get("urlBanco", "");
        String host = prefs.get("host", "");
        String porta = prefs.get ("porta", "");
        String nomebd = prefs.get("nomeBanco","" );
        String usuario = prefs.get("usuario", "");
        String senha = prefs.get("senha", "");
        private File arquivoSelecionado; 
    
      private byte[] converterImagemParaBytes(File arquivoImagem) throws IOException {
    FileInputStream fis = new FileInputStream(arquivoImagem);
    byte[] bytesImagem = new byte[(int) arquivoImagem.length()];
    fis.read(bytesImagem);
    fis.close();
    return bytesImagem;
}
    private void exibirImagem(File arquivo) {
    try {
        FileInputStream fis = new FileInputStream(arquivo);
        byte[] bytesImagem = new byte[(int) arquivo.length()];
        fis.read(bytesImagem);
        fis.close();

        ImageIcon imagemIcon = new ImageIcon(bytesImagem);
        Image imagem = imagemIcon.getImage();
        Image novaImagem = imagem.getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon novaImagemIcon = new ImageIcon(novaImagem);

        // Exibir a imagem no JLabel
        jLabelImagem.setIcon(novaImagemIcon);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao exibir a imagem: " + e.getMessage());
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bntVoltar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        selcImg = new javax.swing.JLabel();
        btnAbrirSeletor = new javax.swing.JButton();
        jLabelImagem = new javax.swing.JLabel();
        btnSalvarImagem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADD PRODUTO - SYSAÇAÍ");
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
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("ALTERAR LOGO"));

        selcImg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selcImg.setForeground(new java.awt.Color(255, 255, 255));
        selcImg.setText("SELECIONAR IMAGEM:");

        btnAbrirSeletor.setText("SELECIONAR");
        btnAbrirSeletor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirSeletorActionPerformed(evt);
            }
        });

        btnSalvarImagem.setText("SALVAR");
        btnSalvarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(selcImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirSeletor))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(btnSalvarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(135, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selcImg)
                    .addComponent(btnAbrirSeletor))
                .addGap(38, 38, 38)
                .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(327, 327, 327)
                    .addComponent(btnSalvarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(337, Short.MAX_VALUE)))
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

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
      TelaInicial ini = new TelaInicial();
      ini.setVisible(true);
      dispose();
    }//GEN-LAST:event_bntVoltarActionPerformed

    private void btnAbrirSeletorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirSeletorActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecionar Imagem");
        int resultado = chooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            arquivoSelecionado = chooser.getSelectedFile();

            // Exibir a imagem selecionada ao usuário
            exibirImagem(arquivoSelecionado);
        }
    }//GEN-LAST:event_btnAbrirSeletorActionPerformed

    private void btnSalvarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarImagemActionPerformed
        if (arquivoSelecionado != null) {
            try {
                byte[] bytesImagem = converterImagemParaBytes(arquivoSelecionado);
                java.sql.Connection conexao = DriverManager.getConnection(urlBanco, usuario, senha);
                String sql = "UPDATE loja SET logo = ? WHERE id = 1"; // Supondo que a loja tenha um ID de 1
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setBytes(1, bytesImagem);
                stmt.executeUpdate();
                stmt.close();
                conexao.close();

                // A imagem da loja foi atualizada no banco de dados
                JOptionPane.showMessageDialog(this, "Imagem da loja atualizada com sucesso.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar a imagem da loja: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma imagem selecionada.");
        }
    }//GEN-LAST:event_btnSalvarImagemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
         
         java.awt.EventQueue.invokeLater(() -> {
            TelaAlterarLogo telaInicial = new TelaAlterarLogo();
            telaInicial.setLocationRelativeTo(null); // Centralize a tela
            telaInicial.setVisible(true);
         });
    }
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVoltar;
    private javax.swing.JButton btnAbrirSeletor;
    private javax.swing.JButton btnSalvarImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel selcImg;
    // End of variables declaration//GEN-END:variables
}
