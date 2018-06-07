package alv_PROJETO;

import java.util.ArrayList;

public class GerenciadorAluguel {
	
	private int linhas;
	private int colunas;
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private ArrayList < ClienteGaragem > listaClientesGaragem; //lista ligada de clientes cadastrados
	private ArrayList < ClienteAluguel > listaClientesAluguel; //lista ligada de clientes de aluguel
	
	
public void alugarCarro(ClienteAluguel cliente) { //inicio do metodo alugarCarro
		
		if(!andarDeAluguel.getAluguelDisponivel())
			System.out.println("Nao ha carros para aluguel"); //se nao ha carros para aluguel
		else {
			cliente.setCarro(andarDeAluguel.buscaCarroDisponivel(cliente));	//se tem carro disponivel, chama funcao que atribui um carro a ele
			System.out.printf("Carro de placa %s, ID de numero %d, alugado para %s", cliente.getCarro().getPlaca(),
				cliente.getIDAlugado(), cliente.getNome());
			this.cadastrarClienteAluguel(cliente); //cadastra cliente a lista de cliente aluguel
		}
	} //fim do metodo alugarCarro
		
	public void devolverCarroAluguel(String placa, double quilometragem) { //inicio do metodo devolverCarroAluguel
		
		for(ClienteAluguel clienteTemp : listaClientesAluguel) {
			if(placa.equals(clienteTemp.getCarro().getPlaca())) { //busca carro alugado com placa especificada
				andarDeAluguel.retornaAlugado(clienteTemp.getIDAlugado(), quilometragem); //marca carro como disponivel
				
				System.out.printf("Carro %s retornado. O valor a ser pago eh igual a %f \n", 
						clienteTemp.getCarro().getPlaca() , andarDeAluguel.calcularMontante(clienteTemp));
				
				this.descadastrarClienteAluguel(clienteTemp.getCPF()); //cobra o cliente e o retira da lista
				
				break;
			}
		}		
	} //fim do metodo devolverCarroAluguel
	
	public void cadastrarClienteAluguel(ClienteAluguel cliente) { //inicio do metodo cadastrarClienteAluguel
		listaClientesAluguel.add(cliente);
	} //fim do metodo devolverCarroAluguel

	
	public ClienteAluguel descadastrarClienteAluguel (String CPF) {
		//inicio do metodo descadastrarClienteAluguel
		
		ClienteAluguel clienteRemovido = null;
		for(ClienteAluguel clienteTemp : listaClientesAluguel){
			if(clienteTemp.getCPF().equals(CPF)) {
				clienteRemovido = clienteTemp;
				listaClientesAluguel.remove(clienteTemp); //busca cliente pela placa de seu carro e o retira da lista de cliente aluguel
				break;
			}
		}
		
		return clienteRemovido;
	} //fim de descadastrarClienteAluguel
}
