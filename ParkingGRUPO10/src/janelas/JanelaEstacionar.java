package janelas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import locais.Estacionamento;
import usuarios.Carro;
import usuarios.ClienteGaragem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class JanelaEstacionar { //inicio da classe JanelaEstacionar

	private JFrame frmEstacionar;
	private JTextField textNome;
	private JTextField textPlaca;
	private JTextField textCPF;
	private JTextField textDiarias;
	private JButton btnEstacionarCarro;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textCor;
	private JTextField textQuilometragem;
	private JTextField textData;
	private JLabel lblData;
	private JTextField textAndar;
	private JTextField textLinha;
	private JTextField textColuna;
	private JLabel lblAndar;
	private JLabel lblLinha;
	private JLabel lblColuna;
	private JButton btnCancelar;
	private JTextField textTipo;
	private JLabel lblTipo;

	public static void dadosEstacionar (Estacionamento estacionamento) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEstacionar window = new JanelaEstacionar(estacionamento);
					window.frmEstacionar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JanelaEstacionar(Estacionamento estacionamento) { //construtor de JanelaEstacionar
		initialize(estacionamento);
	}


	private void initialize(Estacionamento estacionamento) {
				
		frmEstacionar = new JFrame();
		frmEstacionar.setTitle("Estacionar");
		frmEstacionar.setBounds(100, 100, 502, 824);
		frmEstacionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEstacionar.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(41, 29, 56, 16);
		frmEstacionar.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(41, 58, 149, 22);
		frmEstacionar.getContentPane().add(textNome);
		textNome.setColumns(10); //campo para leitura de nome do cliente
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlaca.setBounds(41, 95, 56, 16);
		frmEstacionar.getContentPane().add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(41, 124, 149, 22);
		frmEstacionar.getContentPane().add(textPlaca);
		textPlaca.setColumns(10); //campo para leitura de placa do cliente
		
		textCPF = new JTextField();
		textCPF.setBounds(41, 189, 149, 22);
		frmEstacionar.getContentPane().add(textCPF);
		textCPF.setColumns(10); //campo para leitura de CPF do cliente
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPF.setBounds(41, 160, 56, 16);
		frmEstacionar.getContentPane().add(lblCPF); 
		
		textDiarias = new JTextField();
		textDiarias.setBounds(41, 253, 149, 22);
		frmEstacionar.getContentPane().add(textDiarias);
		textDiarias.setColumns(10); //campo para leitura de diarias do cliente
		
		JLabel lblDiarias = new JLabel("Diarias:");
		lblDiarias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiarias.setBounds(41, 224, 56, 16);
		frmEstacionar.getContentPane().add(lblDiarias);
		
		textMarca = new JTextField();
		textMarca.setBounds(285, 58, 149, 22);
		frmEstacionar.getContentPane().add(textMarca);
		textMarca.setColumns(10); //campo para leitura da marca do carro do cliente
		
		textModelo = new JTextField();
		textModelo.setBounds(285, 124, 149, 22);
		frmEstacionar.getContentPane().add(textModelo);
		textModelo.setColumns(10); //campo para leitura de nome do modelo do carro do cliente
		
		textCor = new JTextField();
		textCor.setBounds(285, 189, 149, 22);
		frmEstacionar.getContentPane().add(textCor);
		textCor.setColumns(10); //campo para leitura da cor do carro  do cliente
		 
		textQuilometragem = new JTextField();
		textQuilometragem.setBounds(285, 253, 149, 22);
		frmEstacionar.getContentPane().add(textQuilometragem);
		textQuilometragem.setColumns(10); //campo para leitura da quilometragem do carro do cliente
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(285, 29, 56, 16);
		frmEstacionar.getContentPane().add(lblMarca);
		
		JLabel Modelo = new JLabel("Modelo:");
		Modelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Modelo.setBounds(285, 95, 56, 16);
		frmEstacionar.getContentPane().add(Modelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCor.setBounds(285, 160, 67, 16);
		frmEstacionar.getContentPane().add(lblCor);
		
		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuilometragem.setBounds(285, 224, 149, 16);
		frmEstacionar.getContentPane().add(lblQuilometragem);
		
		textData = new JTextField();
		textData.setBounds(41, 323, 149, 22);
		frmEstacionar.getContentPane().add(textData);
		textData.setColumns(10); //campo para leitura da data de nascimento do cliente
		
		lblData = new JLabel("Data Nascimento:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(41, 294, 149, 16);
		frmEstacionar.getContentPane().add(lblData);
		
		textAndar = new JTextField();
		textAndar.setBounds(285, 323, 149, 22);
		frmEstacionar.getContentPane().add(textAndar);
		textAndar.setColumns(10); //campo para leitura do andar desejado pelo cliente
		
		textLinha = new JTextField();
		textLinha.setBounds(41, 401, 149, 22);
		frmEstacionar.getContentPane().add(textLinha);
		textLinha.setColumns(10); //campo para leitura da linha desejada pelo liente
		
		textColuna = new JTextField();
		textColuna.setBounds(285, 401, 149, 22);
		frmEstacionar.getContentPane().add(textColuna);
		textColuna.setColumns(10); //campo para leitura da coluna desejada pelo cliente
		
		lblAndar = new JLabel("Andar:");
		lblAndar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAndar.setBounds(285, 295, 56, 16);
		frmEstacionar.getContentPane().add(lblAndar);
		
		lblLinha = new JLabel("Linha:");
		lblLinha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLinha.setBounds(41, 372, 56, 16);
		frmEstacionar.getContentPane().add(lblLinha);
		
		lblColuna = new JLabel("Coluna:");
		lblColuna.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColuna.setBounds(285, 372, 56, 16);
		frmEstacionar.getContentPane().add(lblColuna);
		
		btnEstacionarCarro = new JButton("Estacionar Carro");
		btnEstacionarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, placa, dataNascimento, marca, modelo, cor; long CPF; int diarias, andar, coluna, tipo; double quilometragem;
				char linha; boolean estacionadoSucesso;
				
				marca = textMarca.getText();
				modelo = textModelo.getText();
				cor = textCor.getText();
				quilometragem = Double.parseDouble(textQuilometragem.getText());
				placa = textPlaca.getText();
				tipo = Integer.parseInt(textTipo.getText());
				
				
				Carro novoEstacionado = new Carro(marca, modelo, placa, cor, quilometragem, tipo); //cria um objeto Carro com dados fornecidos
				
				nome = textNome.getText();
				CPF = Long.parseLong(textCPF.getText());
				diarias = Integer.parseInt(textDiarias.getText());
				dataNascimento = textData.getText();
				
				ClienteGaragem novoCliente = new ClienteGaragem (nome, dataNascimento, CPF, diarias); //cria um objeto ClienteGaragem com dados fornecidos
				
				andar = Integer.parseInt(textAndar.getText());
				linha = textLinha.getText().charAt(0);
				coluna = Integer.parseInt(textColuna.getText()); //dados da vaga
				
				estacionadoSucesso = estacionamento.estacionarCarro(novoCliente, novoEstacionado, andar, linha, coluna); //invocar metodo de estacionamento
				
				if(estacionadoSucesso) {
					JOptionPane.showMessageDialog(frmEstacionar, "Carro estacionado com sucesso");
				}else {
					JOptionPane.showMessageDialog(frmEstacionar, "Operacao invalida");
				}
				
				frmEstacionar.dispose();
			}
		});
		btnEstacionarCarro.setBounds(67, 524, 350, 111);
		frmEstacionar.getContentPane().add(btnEstacionarCarro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEstacionar.dispose();
			}
		});
		btnCancelar.setBounds(67, 648, 350, 116);
		frmEstacionar.getContentPane().add(btnCancelar); //botao para cancelar operacao
		
		textTipo = new JTextField();
		textTipo.setBounds(285, 474, 149, 22);
		frmEstacionar.getContentPane().add(textTipo);
		textTipo.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(285, 445, 56, 16);
		frmEstacionar.getContentPane().add(lblTipo);
		
	}
} //fim da classe JanelaEstacionar
