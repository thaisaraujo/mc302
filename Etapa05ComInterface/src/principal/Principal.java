package principal;

import janelas.MenuPrincipal;

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


import locais.Estacionamento;
public class Principal { //inicio da classe Principal
	

	public static void main(String[] args) { //inicio do main
		double[] precoGaragem = {10, 20, 30, 40};
		double diariaAluguel = 15.5, taxaMultas = 1.5, precoSeguro = 4; //valores de precos e taxa de aluguel 
		int limiteMultas = 12;
		
		Estacionamento estacionamento = new Estacionamento (10, 10, precoGaragem, diariaAluguel, precoSeguro, limiteMultas, taxaMultas);
		
		MenuPrincipal.iniciarMenu(estacionamento);
	} //fim do metodo main
} //fim da classe Principal
