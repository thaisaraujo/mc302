package gerenciadores;

import java.util.ArrayList;

import usuarios.Cliente;
import usuarios.ClienteGaragem;

public class GerenciadorClienteGaragem implements GerenciadorClientes {
	
	//Atributo Static
	private static ArrayList < ClienteGaragem > listClienteGaragem = new ArrayList < ClienteGaragem >();
	private static GerenciadorClienteGaragem gerenciadorClienteGaragem;
	
	//Construtor
	public GerenciadorClienteGaragem() {
		
	}

	/*
	 * Aplicação de Padrão: Singleton
	 */
	public static GerenciadorClienteGaragem getInstance() {
		if(GerenciadorClienteGaragem.gerenciadorClienteGaragem == null) {
			GerenciadorClienteGaragem.gerenciadorClienteGaragem = new GerenciadorClienteGaragem(); 
		}
		
		return GerenciadorClienteGaragem.getInstance();
	}
	
	double precoGaragem[] = new double[4];
	
	
	public double[] getPrecoGaragem() { //inicio do metodo getPrecoGaragem
		return precoGaragem;
	}//fim do metodo getPrecoGaragem

	public void setPrecoGaragem(double[] precoGaragem) { //inicio do metodo setPrecoGaragem
		this.precoGaragem = precoGaragem;
	}//fim do metodo setPrecoGagram

	
	
	/*
	 * Método calcularMontate: calcular montante com base no periodo de tempo 
	 * param: cliente
	 * return: double
	 */
	public double calcularMontante(Cliente cliente) { 
		int periodo = ((ClienteGaragem) cliente).getPeriodo(); //posicao do vetor referente a posicao a ser paga
		
		/*perido em dias 
		* posicao 0 : 0 a 1 semanas
		* posicao 1 : 1 a 2 semanas
		* posicao 2 : 2 a 3 semanas
		* posicao 3 : 3 a 4 semanas
		*/
		
		if (periodo <= 7) {
				return precoGaragem[0];
		}else if(periodo > 7 && periodo <= 15) {
			return precoGaragem[1];
		}else if(periodo > 15 && periodo <= 21) {
			return precoGaragem[2];
		}else if(periodo > 21 && periodo <= 28) {
			return precoGaragem[3];
		}
		return -1.0; //periodo n�o reconhecido pelo sistema
	
	}//fim do metodoCalculaMontante

	
	
	/*
	 * Metodo imprimirMontate: mostrar o valor calculado
	 * param: cliente aluguel
	 * return: void
	 */
	public String imprimirMontante(Cliente cliente) { 
		double montante = calcularMontante(cliente);
		
		String saida = "Total (Estacionamento):" + montante + "\n";
		return saida;
		
	}//fim do metodo imprimirMontate
	
	
	
	/*
	 * Metodo cadastraCliente: acrescenta cliente na list de clienteGaragem
	 * param: cliente
	 * return: void
	 */
	public void cadastrarCliente(Cliente cliente) { //inicio do metodo cadastraCliente
		boolean resIdade = cliente.calcularIdade(cliente.getDataDeNascimento());
		
		if(resIdade == true) {
			listClienteGaragem.add((ClienteGaragem) cliente);
		}
				
	}//fim do metodo cadastraCliente
	
	
	
	/*
	 * Metodo descadastrarCliente: remove cliente na list de clienteGaragem
	 * param: cliente
	 * return: void
	 */
	public void descadastrarCliente(Cliente cliente) { 
		listClienteGaragem.remove(cliente);
	}//fim do metodo descadastrarCliente

	
	
	/*
	 * Metodo buscaCliente: busca cliente com base no cpf
	 * param: cpf
	 * return: return ClienteGaragem
	 */
	public ClienteGaragem buscaCliente(long cpf) { 
		
		for(ClienteGaragem busca : listClienteGaragem) {
				
			if(busca.getCPF() == cpf) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf

	
	
	/*
	 * Metodo buscaCliente: busca cliente com base no cpf, placa
	 * param: cpf, placa
	 * return clienteGaragem
	 */
	public ClienteGaragem buscaCliente(long cpf, String placa) { //inicio metodo buscaCliente pelo cpf e carro
		String tempPlaca;
		
		for(ClienteGaragem busca : listClienteGaragem) {
			
			tempPlaca = busca.getCarro().getPlaca();
			
			if(busca.getCPF() == cpf && tempPlaca.compareToIgnoreCase(placa) == 0) {
				return busca;
			}
		}
		
		return null;
	}//fim metodo buscaCliente pelo cpf e carro
	
	
	
	/*
	 * Metodo buscaCliente: busca cliente com base na placa
	 * param: placa
	 * return clienteGaragem
	 */
	public ClienteGaragem buscaCliente(String placa) { //inicio metodo buscaCliente pelo cpf
		
		for(ClienteGaragem busca : listClienteGaragem) {
				
			if(busca.getCarro().getPlaca().equalsIgnoreCase(placa)) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf

	
}//fim classe gerenciadorClienteGaragem
