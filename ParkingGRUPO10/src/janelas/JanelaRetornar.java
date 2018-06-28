package janelas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import locais.Estacionamento;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaRetornar { //inicio da classe JanelaRetornar

	private JFrame frmRetornar;
	private JTextField textPlaca;
	private JTextField textQuilo;
	private JButton btnCancelar;

	public static void dadosRetornar(Estacionamento estacionamento) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaRetornar window = new JanelaRetornar(estacionamento);
					window.frmRetornar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaRetornar(Estacionamento estacionamento) { //construtor JanelaRetornar
		initialize(estacionamento);
	}

	private void initialize(Estacionamento estacionamento) {
		frmRetornar = new JFrame();
		frmRetornar.setTitle("Retornar");
		frmRetornar.setBounds(100, 100, 258, 416);
		frmRetornar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRetornar.getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlaca.setBounds(58, 42, 56, 16);
		frmRetornar.getContentPane().add(lblPlaca); 
		
		textPlaca = new JTextField();
		textPlaca.setBounds(58, 63, 116, 22);
		frmRetornar.getContentPane().add(textPlaca);
		textPlaca.setColumns(10); //campo para leitura da placa do carro procurado
		
		JLabel lblQuilometragemAtual = new JLabel("Quilometragem Atual:");
		lblQuilometragemAtual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuilometragemAtual.setBounds(57, 98, 199, 16);
		frmRetornar.getContentPane().add(lblQuilometragemAtual);
		
		textQuilo = new JTextField();
		textQuilo.setBounds(58, 127, 116, 22);
		frmRetornar.getContentPane().add(textQuilo);
		textQuilo.setColumns(10); //campo para leitura da quilometragem atual
		
		JButton btnRetornarCarro = new JButton("Retornar Carro");
		btnRetornarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa; int quiloAtual;
				
				placa = textPlaca.getText();
				quiloAtual = Integer.parseInt(textQuilo.getText());
				
				double montante = estacionamento.devolverCarro(placa, quiloAtual); //invoca metodo de Estacionamento para devolucao de carros alugados
				
				JOptionPane.showMessageDialog(frmRetornar, "O valor a ser pago eh igual a: " + montante + " reais");
				frmRetornar.dispose();
			}
		});
		btnRetornarCarro.setBounds(28, 179, 181, 67);
		frmRetornar.getContentPane().add(btnRetornarCarro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRetornar.dispose();
			}
		});
		btnCancelar.setBounds(28, 270, 181, 72);
		frmRetornar.getContentPane().add(btnCancelar); //botao para cancelar operacao
	}
 
} //fim da classe JanelaRetornar
