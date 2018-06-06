/*
 * 										  PROJETO COMPUTACIONAL - MC302 - GRUPO10 - ETAPA 3
 * 												  INSTITUTO DE COMPUTACAO - UNICAMP
 * 
 * 											   Caio A. A. Nolasco - RA: 195181 - Lider
 * 													Alvaro P. Tirado - RA: 210656
 * 												   Bernard V. da Costa - RA: 154790
 * 												Fernando H. de M. Bastos - RA: 104923
 * 												     Thais A. Bispo - RA: 187386
 * 
 *  		"Etapa 3: Release 1 (17/05): Apresentar uma segunda versão refinada do software com as principais funcionalidades implementadas."
 *  
 *  	O codigo a seguir representa o release 1 de um sistema de administracao de um estacionamento, junto a um andar especializado no
 * aluguel de 10 carros ja disponiveis na inicializacao do objeto Estacionamento. As funcoes suportadas consistem em: impressao dos carros
 * estacionados em cada andar, de acordo com sua placa, informando o numero de vagas ainda vazias por andar; estacionamento de um carro
 * pertencente a um cliente, guardando dados pessoais do dono e informacoes sobre o carro. A vaga que o carro eh escolhida pelo cliente,
 * assim como seu andar. O objeto Cliente eh guardado em uma lista ligada
 * de clientes; Retirada de um carro estacionado , encontrado via sua placa, retornando o objeto Carro em questao, removendo o cliente da
 * lista de clientes, e marcando a vaga como desocupada; Aluguel de um carro a um cliente especifico do sistema de aluguel, buscando o
 * um carro para aluguel que ainda nao foi alugado, assim como suporte para a eventual devolucao desse carro.
 *		Tanto o estacionamento quanto o aluguel sao sujeitos a metodo que calculam o preco a ser pago pelo servico, que aumenta de acordo
 *com o numero de semanas que o carro ficara estacionado ou alugado. O sistema de aluguel ainda inclui uma taxa especial que multiplica
 *o valor total caso o locatario tenha um numero de multas maior do que um limite pre estabelescido arbritario no inicio da execucao, e um preco
 *propocional a quilometragem percorrido pelo locatario.
 * 											
 * 
 * 

*/

import java.util.Scanner;
public class Principal { //inicio da classe Principal
	
	private static Scanner scan; //objeto scanner

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
				
		Estacionamento e1 = new Estacionamento (linhas, colunas, precoGaragem, diariaAluguel, precoSeguro,
				numeroMultasLimite, taxaMultas); //inicia objeto estacionamento
		//com limite de multas igual a 12 e taxa de 150% do preco
			
		final int CANCELAR = -1;
		final int ESTACIONAR = 1;
		final int DESESTACIONAR = 2;
		final int ALUGAR = 3;
		final int RETORNAR = 4;
		final int PROCURAR = 5;
		final int IMPRIMIR_CLIENTE = 6;
		final int IMPRIMIR_ANDARES = 7; //designa numero constantes para cada operacao
		
		scan = new Scanner(System.in); int comando; //inteiro que dita a operacao desejada
		System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
				+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
		comando = scan.nextInt();
		while(comando != CANCELAR) { //enquando sistema nao eh parado
			if(comando == ESTACIONAR) {
				
				System.out.println("Entre com dados do carro na ordem: marca, modelo, placa, cor,"
						+ " e quilometragem");
						
				Carro novoCarro = new Carro (scan.next(), scan.next(), scan.next(), scan.next(), scan.nextDouble());
				//cria um obejeto carro com os dados fornecidos 
				
				System.out.println("Entre com dados pessoais na ordem: nome, data de nascimento, CPF");
				
				Cliente novoCliente = new Cliente(scan.next(), scan.next(), scan.next());
				
				System.out.println("Entre com o numero de semanas estacionado: ");
				novoCliente.setPeriodo(scan.nextInt());
				
				novoCliente.setCarro(novoCarro); //cria um novo objeto cliente e atribui a ele o carro anteriormente criado
				
				System.out.println("Entre com o numero do andar desejado e a posicao da vaga (exemplo: A1): ");
				e1.estacionarCarro(novoCliente, scan.nextInt(), Character.toUpperCase(scan.next().charAt(0)), scan.nextInt());
				//estaciona o novo carro
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
						
			}else if(comando == DESESTACIONAR) {
				
				System.out.println("Entre com placa do carro");
				Carro desestacionado = e1.desestacionarCarro(scan.next()); //le a placa do carro que deve ser retirado
				
				if(desestacionado == null)
					System.out.println("Carro nao encontrado");
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == ALUGAR) {
				
				System.out.println("Entre com dados pessoais na ordem: nome, data de nascimento, CPF"+
						", quantidade de multas, e se quer seguro ou nao (true ou false) :");
				
				ClienteAluguel novoCliente = new ClienteAluguel (scan.next(), scan.next(), scan.next()
						, scan.nextInt(), scan.nextBoolean()); //cria um novo objeto ClienteAluguel com dados fornecidos
				
				System.out.println("Entre com o numero de diarias: ");
				novoCliente.setPeriodo(scan.nextInt());
				
				e1.alugarCarro(novoCliente); //aluga um carro para cliente
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == RETORNAR) {
				
				System.out.println("Entre com a placa do carro e a quilometragem atual dele: ");
				e1.devolverCarroAluguel(scan.next(), scan.nextDouble()); //le placa do carro retornado
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == PROCURAR) {
				
				System.out.println("Entre com a placa do carro procurado");
				
				Carro procurado = e1.procurarCarro(scan.next()); //le placa do carro procurado
				if(procurado == null) {
					System.out.println("Carro nao esta estacionado");
				}else {
					System.out.printf("O carro esta no andar %d, linha %c, coluna %d\n", procurado.getAndarLocalizado(),
							(char) (procurado.getLocalizacao()[0] + 65) , procurado.getLocalizacao()[1]); //imprime os dados do atributo
					//"localizado" de carro; inteiro da linha eh convertido para um char
				
					System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
							+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
					
				}
				
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == IMPRIMIR_CLIENTE) {
				
				String CPF; int tipoCliente;
				
				System.out.println("Entre com o CPF do cliente");
				CPF = scan.next(); //le CPF do cleinte
				
				System.out.println("Entre com 0 se cliente eh de estacionamento ou 1 se eh de aluguel");
				tipoCliente = scan.nextInt(); //le o tipo de cliente
				
				e1.imprimirDadosCliente(CPF, tipoCliente); //imprime dados
				
				System.out.println("\nEntre com a operacao desejada\n -1: CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
			}
			else if(comando == IMPRIMIR_ANDARES) {
				
				e1.imprimirEstacionamento(); //imprime matriz de carros de cada andar
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			} 
		} 		
	} //fim do metodo main
} //fim da classe Principal
