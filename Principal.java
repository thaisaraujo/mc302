/*
 * 										  PROJETO COMPUTACIONAL - MC302 - GRUPO10 - ETAPA 2
 * 												  INSTITUTO DE COMPUTACAO - UNICAMP
 * 
 * 											   Caio A. A. Nolasco - RA: 195181 - Lider
 * 													Alvaro P. Tirado - RA: 210656
 * 												   Bernard V. da Costa - RA: 154790
 * 												Fernando H. de M. Bastos - RA: 104923
 * 												     Thais A. Bispo - RA: 187386
 * 
 *  				"Etapa 2: Release 0 (17/04): Apresentar uma versão inicial do software com sua estrutura geral implementada."
 *  
 *  	O codigo a seguir representa o release 0 de um sistema de administracao de um estacionamento, junto a um andar especializado no
 * aluguel de 10 carros ja disponiveis na inicializacao do objeto Estacionamento. As funcoes suportadas consistem em: impressao dos carros
 * estacionados em cada andar, de acordo com sua placa, informando o numero de vagas ainda vazias por andar; estacionamento de um carro
 * pertencente a um cliente, guardando dados pessoais do dono e informacoes sobre o carro. A vaga que o carro ocupara eh procurada
 * linearmente na matriz de carros por andar, sendo escolhida a proxima vaga disponivel. O objeto Cliente eh guardado em uma lista ligada
 * de clientes; Retirada de um carro estacionado , encontrado via sua placa, retornando o objeto Carro em questao, removendo o cliente da
 * lista de clientes, e marcando a vaga como desocupada; Aluguel de um carro a um cliente especifico do sistema de aluguel, buscando o
 * um carro para aluguel que ainda nao foi alugado, assim como suporte para a eventual devolucao desse carro.
 *		Tanto o estacionamento quanto o aluguel sao sujeitos a metodo que calculam o preco a ser pago pelo servico, que aumenta de acordo
 *com o numero de semanas que o carro ficara estacionado ou alugado. O sistema de aluguel ainda inclui uma taxa especial que multiplica
 *o valor total caso o locatario tenha um numero de multas maior do que um limite pre estabelescido arbritario no inicio da execucao.
 * 											
 * 
 * 

*/

import java.util.Scanner;
public class Principal { //inicio da classe Principal
	
	private static Scanner scan; //objeto scanner

	public static void main(String[] args) { //inicio do main
		double[] precoGaragem = {20, 35, 50, 65};
		double[] precoAluguel = {50, 100, 145, 185}; //precos de estacionamento e de aluguel
		
		Estacionamento e1 = new Estacionamento (10, 10, precoGaragem, precoAluguel, 12, 1.5); //inicia objeto estacionamento
		//com limite de multas igual a 12 e taxa de 150% do preco
			
		final int CANCELAR = -1;
		final int ESTACIONAR = 1;
		final int DESESTACIONAR = 2;
		final int ALUGAR = 3;
		final int RETORNAR = 4;
		final int PROCURAR = 5;
		final int IMPRIMIR_CLIENTE = 6;
		final int IMPRIMIR = 7; //designa numero constantes para cada operacao
		
		scan = new Scanner(System.in); int comando; //inteiro que dita a operacao desejada
		System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
				+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
		comando = scan.nextInt();
		while(comando != CANCELAR) { //enquando sistema nao eh parado
			if(comando == ESTACIONAR) {
				
				System.out.println("Entre com dados do carro na ordem: marca, modelo, placa, chassi, cor, nivel de combustivel"
						+ " ,ano, renavam e quilometragem");
						
				Carro novoCarro = new Carro (scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(),
						scan.nextInt(), scan.next(), scan.nextInt());
				//cria um obejeto carro com os dados fornecidos 
				
				System.out.println("Entre com dados pessoais na ordem: nome, data de nascimento, CPF, numero de semanas estacionado" +
				", telefone, endereco");
				
				Cliente novoCliente = new Cliente(scan.next(), scan.next(), scan.next(), scan.nextInt(), scan.next()
						, scan.next());
				novoCliente.setCarro(novoCarro); //cria um novo objeto cliente e atribui a ele o carro anteriormente criado
				
				e1.estacionarCarro(novoCliente);
				//estaciona o novo carro
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
						
			}else if(comando == DESESTACIONAR) {
				
				System.out.println("Entre com placa do carro");
				e1.desestacionarCarro(scan.next()); //le a placa do carro que deve ser retirado
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == ALUGAR) {
				
				System.out.println("Entre com dados pessoais na ordem: nome, data de nascimento, CPF, numero de semanas estacionado" +
						", telefone, endereco, e quantidade de multas");
				
				ClienteAluguel novoCliente = new ClienteAluguel (scan.next(), scan.next(), scan.next(), scan.nextInt(), scan.next()
						, scan.next(), scan.nextInt()); //cria um novo objeto ClienteAluguel com dados fornecidos
				
				e1.alugarCarro(novoCliente); //aluga um carro para cliente
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == RETORNAR) {
				
				System.out.println("Entre com a placa do carro e a nova quilometragem: ");
				e1.devolverCarroAluguel(scan.next(), scan.nextInt()); //le placa do carro retornado
				

				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == PROCURAR) {
				
				System.out.println("Entre com a placa do carro procurado");
				
				Carro procurado = e1.procurarCarro(scan.next()); //le placa do carro procurado
				
				System.out.printf("O carro esta no andar %d, linha %d, coluna %d", procurado.getAndarLocalizado(),
						procurado.getLocalizacao()[0], procurado.getLocalizacao()[1]); //imprime os dados do atributo
				//"localizado" de carro
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			}else if(comando == IMPRIMIR_CLIENTE) {
				
				String CPF; int tipoCliente;
				
				System.out.println("Entre com o CPF do cliente");
				CPF = scan.next(); //le CPF do cleinte
				
				System.out.println("Entre com 0 se cliente eh de estacionamento ou 1 se eh de aluguel");
				tipoCliente = scan.nextInt(); //le o tipo de cliente
				
				e1.imprimirDadosCliente(CPF, tipoCliente); //imprime dados
				
				System.out.println("\nEntre com a operacao desejada\n -1: CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
			}
			else if(comando == IMPRIMIR) {
				
				e1.imprimirEstacionamento(); //imprime matriz de carros de cada andar
				
				System.out.println("\nEntre com a operacao desejada\n -1:CANCELAR\n 1:ESTACIONAR\n 2:DESESTACIONAR\n 3:"
						+ "ALUGAR\n 4:RETORNAR ALUGUEL\n 5:PROCURAR CARRO\n 6:IMPRIMIR_CLIENTE\n 7:IMPRIMIR ANDARES\n");
				comando = scan.nextInt(); //le proximo comando
				
			} 
		} 		
	} //fim do metodo main
} //fim da classe Principal

