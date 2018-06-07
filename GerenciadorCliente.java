package Gerenciador;


import Entidades.Cliente;


public abstract class GerenciadorCliente {

	
	//Métodos Abstract 
	public abstract double calcularMontate(Cliente cliente);
	public abstract void imprimirMontate(Cliente cliente);
	public abstract void cadastrarCliente(Cliente cliente);
	public abstract void descadastrarCliente(Cliente cliente);
	public abstract Cliente buscaCliente(String cpf);
	public abstract Cliente buscaCliente(String cpf, String placa);
		


	
}
