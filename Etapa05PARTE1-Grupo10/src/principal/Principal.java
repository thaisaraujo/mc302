package principal;

/*
 * 										  PROJETO COMPUTACIONAL - MC302 - GRUPO10 - ETAPA 4
 * 												  INSTITUTO DE COMPUTACAO - UNICAMP
 * 
 * 											   Caio A. A. Nolasco - RA: 195181 - Lider
 * 													Alvaro P. Tirado - RA: 210656
 * 												     Thais A. Bispo - RA: 187386
 * 
 *  		"Etapa 4: Release 2 (07/06): Apresentar uma nova release do software considerando modifica��es e refinamentos discutidos na orienta��o
 *   com o professor. Apresentar a integra��o dos m�dulos de software que comp�em o sistema. Grande parte das funcionalidades do sistema devem ter 
 *   sido implementadas."
 *  
 *  	O codigo a seguir representa o release 2 de um sistema de administracao de um estacionamento, junto a um andar especializado no
 * aluguel de 10 carros ja disponiveis na inicializacao do objeto Estacionamento. As funcoes suportadas consistem em: estacionamento e desestacionamento
 * de um carro, impressao de dados sobre um cliente, aluguel e retorno de um carro, impressao dos andares de garagem e impressao do catalago de carros
 * disponiveis para estacionamento.
 * 		O sistema eh formado por diferenes hierarquias de generalizacao, que descrevem comportamentos espec�ficos e gerais de componentes do estacionamento,
 * Andar, Vaga, Carro, Cliente e suas respectivas subclasses, explorando o uso de classes abstratas e interfaces, especilizadas em garagem ou aluguel, sendo a classe Estacionamento o elo que junta essas 
 * entidades.
 * 		Estas entidades sao gerenciadas por classes separadas, GerenciadorAluguel, GerenciadorGaragem, e duas classes gerenciadores de clientes
 * GerenciadorClienteGaragem, GerenciadorClienteAluguel, unidas por uma interface GerenciadorClientes. Tais agente gerenciadores sao responsaveis
 * por realizar as alteracoes nos atributos das classes mencionadas anteriormente, como a adicao de um carro a um elemento de Vaga de AndarGaragem ou
 * a sele��o de um carro de AndarAluguel disponivel para aluguel sob demanda. Os dados dos clientes tamb�m s�o guardados no gerenciadores propios
 * do servico usado pelo cliente, guardando nao so dados pessoais e do automovel, mas tambem informacoes relevantes ao restante das classes, como 
 * as coordenadas da vaga ou ID do carro alugado, acessiveis por metodos polimorficos de busca.

*/

import java.util.Scanner;

import locais.Estacionamento;
import usuarios.Carro;
import usuarios.ClienteAluguel;
import usuarios.ClienteGaragem;
public class Principal { //inicio da classe Principal
	
	private static Scanner scan = new Scanner(System.in);; //objeto scanner

	public static void main(String[] args) { //inicio do main
		double[] precoGaragem = new double[4];
		double diariaAluguel, taxaMultas, precoSeguro; //valores de precos e taxa de aluguel 
		int linhas, colunas, numeroMultasLimite;
		
		System.out.println("Entre com numero de linhas, colunas: ");
		linhas = scan.nextInt();
		colunas = scan.nextInt(); //leitura do numero de linhas e colunas do estacionamento
		
		System.out.println("Entre com os precos da diaria do aluguel, a taxa de multas, o limite de multas e preco do seguro");
		diariaAluguel = scan.nextDouble();
		taxaMultas = scan.nextDouble();
		numeroMultasLimite = scan.nextInt();
		precoSeguro = scan.nextDouble(); //leitura de valores relacionados ao preco do aluguel e o limite de multas
		
		System.out.println("Entre com quatro valores para cada periodo da tabela de precos do estacionamento");
		for(int i = 0; i < 4; i++) {
			precoGaragem[i] = scan.nextDouble(); //leitura de valores do estacionamento
		}
				
		Estacionamento estacionamentoGeral = new Estacionamento (linhas, colunas, precoGaragem, diariaAluguel, precoSeguro,
				numeroMultasLimite, taxaMultas); //inicia objeto estacionamento
			
		final int CANCELAR = -1;
		final int ESTACIONAR = 1;
		final int DESESTACIONAR = 2;
		final int ALUGAR = 3;
		final int RETORNAR = 4;
		final int PROCURAR = 5;
		final int IMPRIMIR_CLIENTE = 6;
		final int IMPRIMIR_ANDARES = 7; 
		final int IMPRIMIR_ALUGUEIS = 8 ;//designa numero constantes para cada operacao
		
		int comando;


		System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
				+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
				+ " 8:IMPRIMIR ALUGUEIS");			
		
		comando = scan.nextInt();
		while(comando != CANCELAR) { //enquando sistema nao eh parado
			if(comando == ESTACIONAR) {
				
				System.out.println("Entre com dados do carro na ordem: marca, modelo, placa, cor,"
						+ ",quilometragem" + "e tipo (pequeno,medio,grande\n)");
						
				Carro novoCarro = new Carro (scan.next(), scan.next(), scan.next(), scan.next(), scan.nextDouble(), scan.nextInt());
				//cria um obejeto carro com os dados fornecidos 
				
				System.out.println("Entre com dados pessoais na ordem: nome, data de nascimento, CPF");
				
				ClienteGaragem novoCliente = new ClienteGaragem(scan.next(), scan.next(), scan.nextLong());
				
				System.out.println("Entre com o numero de semanas estacionado: ");
				novoCliente.setPeriodo(scan.nextInt());
				
				
				System.out.println("Entre com o numero do andar desejado e a posicao da vaga (exemplo: A1): ");
				estacionamentoGeral.estacionarCarro(novoCliente, novoCarro, scan.nextInt(), Character.toUpperCase(scan.next().charAt(0)),scan.nextInt());
				//estaciona o novo carro
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
						
			}else if(comando == DESESTACIONAR) {
				
				System.out.println("Entre com placa do carro");
				estacionamentoGeral.desestacionarCarro(scan.next()); //le a placa do carro que deve ser retirado
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == ALUGAR) {
				
				System.out.println("Entre com dados pessoais na ordem: nome, data de nascimento, CPF"+
						", quantidade de multas, e se quer seguro ou nao (true ou false) :");
				
				ClienteAluguel novoCliente = new ClienteAluguel (scan.next(), scan.next(), scan.nextLong()
						, scan.nextInt(), scan.nextBoolean()); //cria um novo objeto ClienteAluguel com dados fornecidos
				
				System.out.println("Entre com o numero de diarias: ");
				novoCliente.setDiarias(scan.nextInt());
				
				estacionamentoGeral.alugarCarro(novoCliente); //aluga um carro para cliente
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == RETORNAR) {
				
				System.out.println("Entre com a placa do carro: ");
				estacionamentoGeral.devolverCarro(scan.next()); //le placa do carro retornado
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == PROCURAR) {
				
				System.out.println("Entre com a placa do carro procurado");
				
				ClienteGaragem procurado = estacionamentoGeral.buscaClienteGaragem(scan.next()); //le placa do carro procurado
				if(procurado == null) {
					System.out.println("Carro nao esta estacionado");
				}else {
					procurado.imprimirCliente(); //imprime os dados do atributo
					//"localizado" de carro; inteiro da linha eh convertido para um char
				
					System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
							+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
							+ " 8:IMPRIMIR ALUGUEIS");
					
				}
				
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == IMPRIMIR_CLIENTE) {
				
				long CPF; int tipoCliente;
				
				System.out.println("Entre com o CPF do cliente");
				CPF = scan.nextLong(); //le CPF do cleinte
				
				System.out.println("Entre com 0 se cliente eh de estacionamento ou 1 se eh de aluguel");
				tipoCliente = scan.nextInt(); //le o tipo de cliente
				
				if(tipoCliente == 0)
					estacionamentoGeral.imprimirClienteGaragem(CPF); //imprime dados
				else
					estacionamentoGeral.imprimirClienteAluguel(CPF);
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
			}
			else if(comando == IMPRIMIR_ANDARES) { //imprime os andares de estacionamento
				
				estacionamentoGeral.imprimirEstacionamento(); //imprime matriz de carros de cada andar
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
				
			}
			else if(comando == IMPRIMIR_ALUGUEIS) { //imprime o catalogo de carros para aluguel
				estacionamentoGeral.imprimirAlugueis();
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n"
						+ " 8:IMPRIMIR ALUGUEIS");
				comando = scan.nextInt(); //le proximo comando
			}
		} 		
	} //fim do metodo main
} //fim da classe Principal
