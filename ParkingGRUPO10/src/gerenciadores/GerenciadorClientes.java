package gerenciadores;

import usuarios.Cliente;

public interface GerenciadorClientes { //inicio da interface GerenciadorClientes
	
	public void cadastrarCliente(Cliente cliente);
	public void descadastrarCliente(Cliente cliente);
	public Cliente buscaCliente(long cpf);
	public Cliente buscaCliente(long cpf, String placa);
	public Cliente buscaCliente(String placa); //metodos abstratos da classe GerenciadorClientes

} //fim da interface GerenciadorClientes
