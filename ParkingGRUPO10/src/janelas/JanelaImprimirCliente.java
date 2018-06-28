package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import locais.Estacionamento;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaImprimirCliente { //inicio da classe JanelaImprimirCliente

	private JFrame frmImprimir;
	private JTextField textCPF;
	private JButton btnCancelar;

	public static void dadosImprimir(Estacionamento estacionamento) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaImprimirCliente window = new JanelaImprimirCliente(estacionamento);
					window.frmImprimir.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaImprimirCliente(Estacionamento estacionamento) { //construtor de JanelaImprimirCliente
		initialize(estacionamento);
	}

	private void initialize(Estacionamento estacionamento) {
		frmImprimir = new JFrame();
		frmImprimir.setTitle("Imprimir");
		frmImprimir.setBounds(100, 100, 235, 370);
		frmImprimir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImprimir.getContentPane().setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPF.setBounds(49, 53, 90, 16);
		frmImprimir.getContentPane().add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setBounds(49, 82, 116, 22);
		frmImprimir.getContentPane().add(textCPF);
		textCPF.setColumns(10); //campo para leitura do CPF do cliente desejado
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long CPF; String saida;
				
				CPF = Long.parseLong(textCPF.getText());
				
				saida = estacionamento.imprimirClienteGaragem(CPF); //invoca metodo de Estacionamento para impressao de clientes
				JOptionPane.showMessageDialog(frmImprimir, saida);
				frmImprimir.dispose();
			}
		});
		btnImprimir.setBounds(18, 153, 180, 72);
		frmImprimir.getContentPane().add(btnImprimir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmImprimir.dispose();
			}
		});
		btnCancelar.setBounds(18, 238, 180, 72);
		frmImprimir.getContentPane().add(btnCancelar); //botao para cancelar operacao
	}

} //fim da classe JanelaImprimirCliente
