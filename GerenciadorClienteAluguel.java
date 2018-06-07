package Gerenciador;

import java.util.ArrayList;
import java.util.Scanner;

import Entidades.Cliente;
import Entidades.ClienteAluguel;

public class GerenciadorClienteAluguel extends GerenciadorCliente {

	private static ArrayList < ClienteAluguel > listClienteAluguel = new ArrayList < ClienteAluguel >();
	
	private static int limiteMultas;
	private static double taxaMultas;
	private double diariaValor;
	private double seguroValor;
	

	protected static void setLimiteMultas(int limiteMultas) { //inicio do metodo setLimiteMultas
		GerenciadorClienteAluguel.limiteMultas = limiteMultas;
	}//fim do metodo setLimiteMultas

	protected static void setTaxaMultas(double taxaMultas) { //inicio do metodo setTaxaMultas
		GerenciadorClienteAluguel.taxaMultas = taxaMultas;
	}//fim do metodo setTaxaMultas

	protected void setDiariaValor(double diariaValor) { //inicio do metodo setDiariaValor
		this.diariaValor = diariaValor;
	}//fim do metodo setDiariaValor

	protected void setSeguroValor(double seguroValor) { //inicio do metodo setSeguroValor
		this.seguroValor = seguroValor;
	}//fim do metodo setSeguroValor
		
	
	@Override 
	public double calcularMontate(Cliente cliente) { //inicio metodo calcularMotante
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
	public void imprimirMontate(Cliente cliente) { //inicio metodo imprimirMontate
		
		System.out.printf("Total (Aluguel): %d", calcularMontate(cliente));
		
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
	public Cliente buscaCliente(String cpf) { //inicio do metodo buscaCliente pelo cpf

		for(ClienteAluguel busca : listClienteAluguel) {
			
			if(busca.getCPF().compareToIgnoreCase(cpf) == 0) {
				return busca;
			}
		}
		
		return null;
	}//fim do método buscaCliente pelo cpf

	@Override
	public Cliente buscaCliente(String cpf, String placa) {//inicio do metodo buscaCliente pelo cpf e placa
		String tempPlaca;
		
		for(ClienteAluguel busca : listClienteAluguel) {
			
			tempPlaca = busca.getCarro().getPlaca();
			
			if(busca.getCPF().compareToIgnoreCase(cpf) == 0 && tempPlaca.compareToIgnoreCase(placa) == 0) {
				return busca;
			}
		}
		
		return null;
	}//fim do metodo buscaCliente pelo cpf e placa
	

}//fim classe GerenciadorClienteAluguel
