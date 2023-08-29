package jscomp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class ConfiguracaoBancoDados extends JFrame {
    public JTextField txtHost;
    public JTextField txtPorta;
    public JTextField txtNomeBanco;
    public JTextField txtUsuario;
    public JPasswordField txtSenha;

    public ConfiguracaoBancoDados() {
        // Configurar a janela
        setTitle("Configuração do Banco de Dados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criar painel
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2));

        // Adicionar componentes
        painel.add(new JLabel("Host:"));
        txtHost = new JTextField();
        painel.add(txtHost);

        painel.add(new JLabel("Porta:"));
        txtPorta = new JTextField();
        painel.add(txtPorta);

        painel.add(new JLabel("Nome do Banco de Dados:"));
        txtNomeBanco = new JTextField();
        painel.add(txtNomeBanco);

        painel.add(new JLabel("Nome de Usuário:"));
        txtUsuario = new JTextField();
        painel.add(txtUsuario);

        painel.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        painel.add(txtSenha);

        JButton btnSalvar = new JButton("Salvar Configurações");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarConfiguracoes();
                TelaLogin login = new TelaLogin();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
                dispose();
            }
        });
        painel.add(btnSalvar);
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin login = new TelaLogin();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
                dispose();
            }
        });
        painel.add(btnVoltar);

        add(painel);
    }

    private void salvarConfiguracoes() {
        // Aqui você deve implementar a lógica para salvar as configurações
        String host = txtHost.getText();
        String porta = txtPorta.getText();
        String nomeBanco = txtNomeBanco.getText();
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        Preferences prefs = Preferences.userNodeForPackage(ConfiguracaoBancoDados.class);
        prefs.put("host", host);
        prefs.put("porta", porta);
        prefs.put("nomeBanco", nomeBanco);
        prefs.put("usuario", usuario);
        prefs.put("senha", senha);
        String urlBanco = "jdbc:mysql://" + host + ":" + porta + "/" + nomeBanco;
        prefs.put("urlBanco", urlBanco);
        JOptionPane.showMessageDialog(this, "Configurações Salvas com Sucesso!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConfiguracaoBancoDados telaConfig = new ConfiguracaoBancoDados();
                telaConfig.setVisible(true);
            }
        });
    }
}
