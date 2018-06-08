package gerenciadores;

import java.util.ArrayList;
import java.util.Scanner;

import usuarios.CarroAluguel;
import usuarios.Cliente;
import usuarios.ClienteAluguel;

public class GerenciadorClienteAluguel implements GerenciadorClientes {

	private static ArrayList < ClienteAluguel > listClienteAluguel = new ArrayList < ClienteAluguel >();
	
	private int limiteMultas;
	private double taxaMultas;
	private double diariaValor;
	private double seguroValor;
	

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
		 
	@Override
	public double calcularMontante(Cliente cliente) { //inicio metodo calcularMotante
		double difQuilo, quiloAtual,taxa = 1,precoQuilo = 0;
		double diariaPreco = diariaValor;
	
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner (System.in);
		
		
		//Calcular da Diferença da Quilometragem
		quiloAtual = entrada.nextDouble();
		difQuilo = quiloAtual - cliente.getCarro().getQuilometragem();
		
		//Verificar multas
		if(((ClienteAluguel) cliente).getQtdMultas() > limiteMultas) {
			taxa = taxaMultas;
		}
		
		//Verificar Seguro
		if(((ClienteAluguel) cliente).isSeguro()) {
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
		
		
		return precoQuilo*taxa*((ClienteAluguel) cliente).getDiarias()*diariaPreco;
	}//fim do metodo calcularMontate

	@Override
	public void imprimirMontante(Cliente cliente) { //inicio metodo imprimirMontate
		
		System.out.printf("Total (Aluguel): %d", calcularMontante(cliente));
		
	}//fim do metodo imprimirMontate

	@Override
	public void cadastrarCliente(Cliente cliente) { //inicio do metodo cadastrarCliente
		boolean resIdade = cliente.calcularIdade(cliente.getDataDeNascimento());
		
		if(resIdade == true) {
			listClienteAluguel.add((ClienteAluguel) cliente);
		}
		
	}//fim do metodo cadastartCliente

	@Override
	public void descadastrarCliente(Cliente cliente) {
		listClienteAluguel.remove(cliente);
	}

	@Override
	public ClienteAluguel buscaCliente(long cpf) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			
			if(busca.getCPF() == cpf) {
				return busca;
			}
		}
		
		return null;
	}//fim do método buscaCliente pelo cpf

	@Override
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
	
	@Override
	public ClienteAluguel buscaCliente(String placa) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			
			if(busca.getCarro().getPlaca().equalsIgnoreCase(placa)) {
				return busca;
			}
		}
		
		return null;
	}//fim do método buscaCliente pelo cpf
	
	public ClienteAluguel buscaCliente(int IDAluguel) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			CarroAluguel alugado = (CarroAluguel) busca.getCarro();
			if(alugado.getIDAlugado() == IDAluguel) {
				return busca;
			}
		}
		
		return null;
	}//fim do método buscaCliente pelo cpf
	

}//fim classe GerenciadorClienteAluguel