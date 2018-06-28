package janelas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import locais.Estacionamento;

import java.awt.Font;

public class MenuPrincipal { //inicio da classe de interface grafica MenuPrincipal

	private JFrame frmParking; //frame principal
	
	public static void iniciarMenu(Estacionamento estacionamento) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal(estacionamento); //instacia do menu principal
					window.frmParking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal(Estacionamento estacionamento) { //construtor de MenuPrincipal
		initialize(estacionamento);
	}

	private void initialize(Estacionamento estacionamento) {
		frmParking = new JFrame();
		frmParking.getContentPane().setForeground(Color.WHITE);
		frmParking.getContentPane().setBackground(new Color(153, 153, 255));
		frmParking.setTitle("Parking");
		frmParking.setBounds(100, 100, 831, 746);
		frmParking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //informacoes da janela de menu principal
		
		JButton btnEstacionar = new JButton("Estacionar");
		btnEstacionar.setBounds(12, 110, 254, 182);
		btnEstacionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaEstacionar.dadosEstacionar(estacionamento);
			}
		});
		frmParking.getContentPane().setLayout(null);
		frmParking.getContentPane().add(btnEstacionar); //botao para opcao de estacionamento
		
		JButton btnDesestacionar = new JButton("Desestacionar");
		btnDesestacionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaDesestacionar.dadosDesestacionar(estacionamento);
				
			}
		});
		btnDesestacionar.setBounds(278, 110, 254, 182);
		frmParking.getContentPane().add(btnDesestacionar); //botao para opcao de desestacionar
		
		JButton btnAlugar = new JButton("Alugar");
		btnAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaAlugar.dadosAlugar(estacionamento);
			}
		});
		btnAlugar.setBounds(544, 110, 254, 182);
		frmParking.getContentPane().add(btnAlugar); //botao para opcao de alugar
		
		JButton btnRetornar = new JButton("Retornar Carro");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaRetornar.dadosRetornar(estacionamento);
			}
		});
		btnRetornar.setBounds(12, 309, 254, 182);
		frmParking.getContentPane().add(btnRetornar); //botao para opcao de retornar aluguel
		
		JButton btnProcurarCarro = new JButton("Procurar Carro");
		btnProcurarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaProcurarCarro.dadosProcurar(estacionamento);
			}
		});
		btnProcurarCarro.setBounds(278, 309, 254, 182);
		frmParking.getContentPane().add(btnProcurarCarro); //botao para funcao de procurar carro estacionado
		
		JButton btnImprimirCliente = new JButton("Imprimir Cliente");
		btnImprimirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaImprimirCliente.dadosImprimir(estacionamento);
			}
		});
		btnImprimirCliente.setBounds(544, 309, 254, 182);
		frmParking.getContentPane().add(btnImprimirCliente); //botao para impressao de cliente
		
		JButton btnImprimirAndares = new JButton("Imprimir Andares");
		btnImprimirAndares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saida = estacionamento.imprimirEstacionamento();
				JOptionPane.showMessageDialog(frmParking, saida);
			}
		});
		btnImprimirAndares.setBounds(12, 504, 254, 182);
		frmParking.getContentPane().add(btnImprimirAndares); //botao para impressao dos andares do estacionamento
		
		JButton btnImprimirAlugueis = new JButton("Imprimir Alugueis");
		btnImprimirAlugueis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saida = estacionamento.imprimirAlugueis();
				JanelaCatalogoAluguel.mostrarCatalogo(saida);
			}
		});
		btnImprimirAlugueis.setBounds(278, 504, 254, 182);
		frmParking.getContentPane().add(btnImprimirAlugueis); //botao para impressao de informacoes de locatarios
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmParking.dispose();
			}
		});
		btnSair.setBounds(544, 504, 254, 182);
		frmParking.getContentPane().add(btnSair); //botao para saida do programa
		
		JLabel lblNewLabel = new JLabel("Parking");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(208, 26, 396, 71);
		frmParking.getContentPane().add(lblNewLabel);
	}

} //fim da classe MenuPrincipal
