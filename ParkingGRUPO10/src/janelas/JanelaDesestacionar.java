package janelas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import locais.Estacionamento;
import usuarios.ClienteGaragem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class JanelaDesestacionar { //inicio da classe JanelaDesestacionar

	private JFrame frmDesestacionar;
	private JTextField textPlaca;
	private JButton btnDesestacionarCarro;
	private JButton btnCancelar;

	public static void dadosDesestacionar(Estacionamento estacionamento) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDesestacionar window = new JanelaDesestacionar(estacionamento);
					window.frmDesestacionar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaDesestacionar(Estacionamento estacionamento) { //construtor de JanelaDesestacionar
		initialize(estacionamento);
	}

	
	private void initialize(Estacionamento estacionamento) {
		frmDesestacionar = new JFrame();
		frmDesestacionar.setTitle("Desestacionar");
		frmDesestacionar.setBounds(100, 100, 263, 370);
		frmDesestacionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesestacionar.getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlaca.setBounds(64, 58, 56, 16);
		frmDesestacionar.getContentPane().add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(64, 87, 116, 22);
		frmDesestacionar.getContentPane().add(textPlaca);
		textPlaca.setColumns(10); //campo para leitura de nome placa do carro
		btnDesestacionarCarro = new JButton("Desestacionar Carro");
		btnDesestacionarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String placaBuscada = textPlaca.getText();
				
				ClienteGaragem desestacionado = estacionamento.desestacionarCarro(placaBuscada); //invoca metodo de Estacionamento para desestacionar carro
				if(desestacionado != null) {
					JOptionPane.showMessageDialog(frmDesestacionar, "Carro desestacionado. Valor a ser pago = " + estacionamento.getClienteGaragem().calcularMontante(desestacionado) + "reais");
				}
				else {
					JOptionPane.showMessageDialog(frmDesestacionar, "Operacao invalida");
				}
				frmDesestacionar.dispose();
			}
		});
		btnDesestacionarCarro.setBounds(12, 141, 221, 70);
		frmDesestacionar.getContentPane().add(btnDesestacionarCarro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDesestacionar.dispose();
			}
		});
		btnCancelar.setBounds(12, 236, 221, 74);
		frmDesestacionar.getContentPane().add(btnCancelar); //botao para cancelar operacao
	}
} //fim da classe JanelaDesestacionar
