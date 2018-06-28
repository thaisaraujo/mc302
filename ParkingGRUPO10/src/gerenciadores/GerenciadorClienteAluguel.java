package gerenciadores;

import java.util.ArrayList;
import usuarios.CarroAluguel;
import usuarios.Cliente;
import usuarios.ClienteAluguel;

public class GerenciadorClienteAluguel implements GerenciadorClientes {

	private static ArrayList < ClienteAluguel > listClienteAluguel = new ArrayList < ClienteAluguel >();
	private static GerenciadorClienteAluguel gerenciadorClienteAluguel;
	private int limiteMultas;
	private double taxaMultas;
	private double diariaValor;
	private double seguroValor;
	
	
	//Construtor
	public GerenciadorClienteAluguel() {
			
	}

	/*
	 * Aplicação de Padrão: Singleton
	 */
	public static GerenciadorClienteAluguel getInstance() {
		if(GerenciadorClienteAluguel.gerenciadorClienteAluguel == null) {
			GerenciadorClienteAluguel.gerenciadorClienteAluguel = new GerenciadorClienteAluguel(); 
		}
	
		return GerenciadorClienteAluguel.getInstance();
	}

	

	public void setLimiteMultas(int limiteMultas) { //inicio do metodo setLimiteMultas
		this.limiteMultas = limiteMultas;
	}//fim do metodo setLimiteMultas

	public void setTaxaMultas(double taxaMultas) { //inicio do metodo setTaxaMultas
		this.taxaMultas = taxaMultas;
	}//fim do metodo setTaxaMultas

	public void setDiariaValor(double diariaValor) { //inicio do metodo setDiariaValor
		this.diariaValor = diariaValor;
	}//fim do metodo setDiariaValor

	public void setSeguroValor(double seguroValor) { //inicio do metodo setSeguroValor
		this.seguroValor = seguroValor;
	}//fim do metodo setSeguroValor
		 
	
	/*
	 * Metodo calcularMontate: calcula o montante do valor deo aluguel
	 * param: cliente
	 * retun: valor do montante
	 */
	public double calcularMontante(Cliente cliente, double quiloAtual, double quiloAntiga, int tipo) { //inicio metodo calcularMotante
		double difQuilo, taxa = 1, precoQuilo = 0;
		double diariaPreco = diariaValor;
		boolean res;
		
				
		//Calcular da Diferença da Quilometragem;
		difQuilo = quiloAtual - quiloAntiga;
		
		//Verificar multas
		if(((ClienteAluguel) cliente).getQtdMultas() > limiteMultas) {
			taxa = taxaMultas;
		}
		
		//Verificar Seguro
		res = ((ClienteAluguel) cliente).isSeguro();
		if(res == true) {
			precoQuilo += seguroValor;
		}
	
		
		//Verificar valor por quilometagem
		if(difQuilo < 500) {
			precoQuilo += difQuilo*1.99;
		}else if(difQuilo >= 500 && difQuilo < 1000) {
			precoQuilo += difQuilo*2.99;
		}else if(difQuilo >= 1000) {
			precoQuilo += difQuilo*3.5;
		}
		
		//Verificar tipo do carro
		if(tipo == 1) {
			taxa +=taxa*0.15;
		}else if(tipo == 2) {
			taxa +=taxa*0.20;
		}else if(tipo == 3) {
			taxa +=taxa*0.30;
		}
		
		return taxa * (precoQuilo + ((ClienteAluguel) cliente).getDiarias() * diariaPreco);
	}//fim do metodo calcularMontate

	
	
	/*
	 * Metodo imprimirMontate: mostrar o valor calculado
	 * param: cliente aluguel
	 * return: String
	 */
	/*public String imprimirMontante(Cliente cliente) { //inicio metodo imprimirMontate
		double montante = calcularMontante(cliente);
		
		String saida = "Total (Aluguel):" + montante + "\n";
		
		return saida;
	//System.out.printf("Total (Aluguel): %d", calcularMontante(cliente));
		
	}//fim do metodo imprimirMontate

	
	
	/*
	 * Metodo cadastrarCliente: método para cadastrar cliente no sistema
	 * param: cliente
	 * return: void
	 */
	public void cadastrarCliente(Cliente cliente) { //inicio do metodo cadastrarCliente
		boolean resIdade = cliente.calcularIdade(cliente.getDataDeNascimento());
		
		if(resIdade == true) {
			listClienteAluguel.add((ClienteAluguel) cliente);
		}
		
	}//fim do metodo cadastartCliente

	
	
	/*
	 * Metodo descadastrarCliente: remover cliente da lista de ClienteAlguel
	 * param: cliente
	 * return void
	 */
	public void descadastrarCliente(Cliente cliente) {
		listClienteAluguel.remove(cliente);
	}

	
	
	/*
	 * Metodo buscaClinte: busca cliente com base nos dados do param na lista de clienteAluguel
	 * param: cpf
	 * return: clienteAluguel
	 */
	public ClienteAluguel buscaCliente(long cpf) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			
			if(busca.getCPF() == cpf) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf

	
	
	/*
	 * Metodo buscaCliente: busca cliente com base nos dados do param na lista de clienteAlguel
	 * param: cpf, placa
	 * return: clienteAluguel
	 */
	public ClienteAluguel buscaCliente(long cpf, String placa) {//inicio do metodo buscaCliente pelo cpf e placa
		String tempPlaca;
		
		for(ClienteAluguel busca : listClienteAluguel) {
			
			tempPlaca = busca.getCarro().getPlaca();
			
			if(busca.getCPF() ==  cpf && tempPlaca.compareToIgnoreCase(placa) == 0) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf e placa
	
	
	
	/*
	 * Metodo buscaCliente: busca cliente com base nos dados do param na lista de clienteAlguel
	 * param: placa
	 * return: clienteAluguel
	 */
	public ClienteAluguel buscaCliente(String placa) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			
			if(busca.getCarro().getPlaca().equalsIgnoreCase(placa)) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf
	
	
	
	/*
	 * Metodo buscaCliente: busca cliente com base nos dados do param na lista de clienteAlguel
	 * param: IDAluguel
	 * return: clienteAluguel
	 */
	public ClienteAluguel buscaCliente(int IDAluguel) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			CarroAluguel alugado = (CarroAluguel) busca.getCarro();
			if(alugado.getIDAlugado() == IDAluguel) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf
	

}//fim classe GerenciadorClienteAluguel