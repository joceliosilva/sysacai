
package jscomp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mysql.cj.jdbc.DatabaseMetaData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.prefs.Preferences;


public class TelaLogin extends javax.swing.JFrame {
    
    public TelaLogin() {
        initComponents();
            addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
          
            txtSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   logar();
                }
            }  
        } 
        );
    }
    
      
        Preferences prefs = Preferences.userNodeForPackage(ConfiguracaoBancoDados.class);
        String urlBanco = prefs.get("urlBanco", "");
        String host = prefs.get("host", "");
        String porta = prefs.get ("porta", "");
        String nomebd = prefs.get("nomeBanco","" );
        String usuario = prefs.get("usuario", "");
        String senha = prefs.get("senha", "");
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
    try {
        Connection conexao = DriverManager.getConnection(urlBanco, usuario, senha);
        
        DatabaseMetaData metaData = (DatabaseMetaData) conexao.getMetaData();
        String host = metaData.getURL();
        host = host.replaceFirst("^jdbc:mysql://(.*?):.*", "$1");
        host = host.toUpperCase();
        txtDbConected.setText("DB: " + host);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
    }
    }
        
        public void logar (){
             String username = txtUsername.getText();
        String senha1 = new String(txtSenha.getPassword());
        
          try {
            Connection conexao = DriverManager.getConnection(urlBanco, usuario, senha);
            String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, senha1);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Login bem-sucedido, redirecionar para a próxima tela
               TelaInicial telainicial = new TelaInicial();
               telainicial.setLocationRelativeTo(null); // Centralize a tela
               telainicial.setVisible(true);
               dispose(); // Feche a tela de login
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtDbConected = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN -SYSACAI");

        jPanel1.setBackground(new java.awt.Color(153, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, 30));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Senha");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuário");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 190, 30));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 90, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtDbConected.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDbConected.setForeground(new java.awt.Color(0, 204, 51));
        txtDbConected.setText("AGUARDANDO...");

        jButton1.setText("CONFIG BD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtDbConected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtDbConected, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
      logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
          System.exit(0); // Fechar o aplicativo
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ConfiguracaoBancoDados telaConfig = new ConfiguracaoBancoDados();
    telaConfig.setVisible(true);
    telaConfig.setLocationRelativeTo(null);
    telaConfig.txtHost.setText(host);
    telaConfig.txtPorta.setText(porta);
    telaConfig.txtNomeBanco.setText(nomebd);
    telaConfig.txtUsuario.setText(usuario);
    telaConfig.txtSenha.setText(senha);
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setLocationRelativeTo(null); // Centralize a tela
                   telaLogin.setVisible(true);

            }
        });
    }


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    public javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtDbConected;
    public javax.swing.JPasswordField txtSenha;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
