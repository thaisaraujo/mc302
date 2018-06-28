package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import locais.Estacionamento;
import usuarios.ClienteGaragem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaProcurarCarro { //inicio da JanelaProcurarCarro

	private JFrame frmProcurar;
	private JTextField textPlaca;
	private JButton btnCancelar;

	public static void dadosProcurar(Estacionamento estacionamento) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaProcurarCarro window = new JanelaProcurarCarro(estacionamento);
					window.frmProcurar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaProcurarCarro(Estacionamento estacionamento) { //construtor de JanelaProcurarCarro
		initialize(estacionamento);
	}

	private void initialize(Estacionamento estacionamento) {
		frmProcurar = new JFrame();
		frmProcurar.setTitle("Procurar");
		frmProcurar.setBounds(100, 100, 288, 437);
		frmProcurar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProcurar.getContentPane().setLayout(null);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(77, 75, 116, 22);
		frmProcurar.getContentPane().add(textPlaca);
		textPlaca.setColumns(10); //campo para leitura da placa do carro do cliente
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(75, 46, 56, 16);
		frmProcurar.getContentPane().add(lblPlaca);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = textPlaca.getText();
				
				ClienteGaragem clienteProcurado = estacionamento.buscaClienteGaragem(placa); //procura o cliente pelo metodo de Estacionamento
				JOptionPane.showMessageDialog(frmProcurar, clienteProcurado);
				frmProcurar.dispose();
				
			}
		});
		btnProcurar.setBounds(31, 158, 207, 87);
		frmProcurar.getContentPane().add(btnProcurar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmProcurar.dispose();
			}
		});
		btnCancelar.setBounds(31, 268, 207, 87);
		frmProcurar.getContentPane().add(btnCancelar); //botao para cancelar operacao
	}

} //fim da classe JanelaProcurarCarro
