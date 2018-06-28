package janelas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import locais.Estacionamento;
import usuarios.ClienteAluguel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JanelaAlugar { //inicio da classe JanelaAlugar

	private JFrame frmAlugar;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textMultas;
	private JTextField textDiarias;
	private JButton btnAlugarCarro;
	private JComboBox<?> comboBoxSeguro;
	private JTextField textData;
	private JLabel lblDataNascimento;

	public static void dadosAlugar(Estacionamento estacionamento) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAlugar window = new JanelaAlugar(estacionamento);
					window.frmAlugar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaAlugar(Estacionamento estacionamento) { //construtor de JanelaAlugar
		initialize(estacionamento);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize(Estacionamento estacionamento) {
		frmAlugar = new JFrame();
		frmAlugar.setTitle("Alugar");
		frmAlugar.setBounds(100, 100, 418, 721);
		frmAlugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlugar.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(37, 29, 56, 16);
		frmAlugar.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(125, 58, 150, 22);
		frmAlugar.getContentPane().add(textNome);
		textNome.setColumns(10); //campo para leitura de nome do cliente
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPF.setBounds(37, 95, 56, 16);
		frmAlugar.getContentPane().add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setBounds(125, 124, 150, 22);
		frmAlugar.getContentPane().add(textCPF);
		textCPF.setColumns(10); //campo para leitura de CPF do cliente
		
		JLabel lblMultas = new JLabel("Numero Multas:");
		lblMultas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMultas.setBounds(37, 227, 123, 16);
		frmAlugar.getContentPane().add(lblMultas);
		
		textMultas = new JTextField();
		textMultas.setBounds(125, 256, 150, 22);
		frmAlugar.getContentPane().add(textMultas);
		textMultas.setColumns(10); //campo para leitura do numero de multas do cliente
		
		JLabel lblDiarias = new JLabel("Diarias:");
		lblDiarias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiarias.setBounds(37, 291, 56, 16);
		frmAlugar.getContentPane().add(lblDiarias);
		
		textDiarias = new JTextField();
		textDiarias.setBounds(125, 320, 150, 22);
		frmAlugar.getContentPane().add(textDiarias);
		textDiarias.setColumns(10); //campo para leitura do numero de diarias do cliente
		
		JLabel lblSeguro = new JLabel("Seguro:");
		lblSeguro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeguro.setBounds(37, 355, 56, 16);
		frmAlugar.getContentPane().add(lblSeguro);
		
		btnAlugarCarro = new JButton("Alugar Carro");
		btnAlugarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, data; long CPF; int multas, diarias; boolean seguro, aluguelSucesso;
				
				nome = textNome.getText();
				CPF = Long.parseLong(textCPF.getText());
				multas = Integer.parseInt(textMultas.getText());
				diarias = Integer.parseInt(textDiarias.getText());
				data = textData.getText();
				if(comboBoxSeguro.getSelectedIndex() == 0) {
					seguro = true;
				}else {
					seguro = false;
				}
				ClienteAluguel novoAluguel = new ClienteAluguel (nome, data, CPF, multas, seguro, diarias); //cria um objeto ClienteAluguel com dados fornecidos
				aluguelSucesso = estacionamento.alugarCarro(novoAluguel); //chama metodo de Estacionamento
				if(aluguelSucesso) {
					JOptionPane.showMessageDialog(frmAlugar, "Carro alugado com sucesso");
				}else {
					JOptionPane.showMessageDialog(frmAlugar, "Operacao invalida");
				}
				frmAlugar.dispose();
			}
		});
		btnAlugarCarro.setBounds(51, 431, 302, 108);
		frmAlugar.getContentPane().add(btnAlugarCarro);
		
		comboBoxSeguro = new JComboBox();
		comboBoxSeguro.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Nao"}));
		comboBoxSeguro.setToolTipText("");	
		comboBoxSeguro.setBounds(125, 384, 150, 22);
		frmAlugar.getContentPane().add(comboBoxSeguro); //opcao de com ou sem seguro
		
		textData = new JTextField();
		textData.setBounds(125, 192, 150, 22);
		frmAlugar.getContentPane().add(textData);
		textData.setColumns(10); //campo para leitura da data de nascimento do cliente
		
		lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataNascimento.setBounds(37, 163, 150, 16);
		frmAlugar.getContentPane().add(lblDataNascimento);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAlugar.dispose();
			}
		});
		btnCancelar.setBounds(51, 546, 302, 115);
		frmAlugar.getContentPane().add(btnCancelar); //botao para cancelar operacao
	}
}
