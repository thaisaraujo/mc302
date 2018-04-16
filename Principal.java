
public class Principal {

	public static void main(String[] args) {
		int[] precoGaragem = {20, 35, 50, 65};
		int[] precoAluguel = {50, 100, 145, 190}; //precos de estacionamento e de aluguel
		
		Estacionamento e1 = new Estacionamento (10, 10, precoGaragem, precoAluguel, 12, 1.5);
		
		Carro carro1 = new Carro ("Marca 1", "Modelo", "FKR8241", "8372738", "vermelho", "80%", 1999, "kgm101", "15000");
		Carro carro2 = new Carro ("Marca 2", "Modelo2", "DME8366", "831234738", "verde", "44%", 2006, "fjek1234", "10000");
		
		Cliente cliente1 = new Cliente ("Joao", "09/04/1980", "12345678901", 3, "82838842", "Rua Laranjeiras", carro1);
		Cliente cliente2 = new Cliente ("Maria", "23/04/1992", "12345678976", 1, "949923912", "Rua Montanha", carro2);
		//adiciona dois cliente e estaciona seus carros
		
		e1.estacionarCarro(cliente1);
		e1.estacionarCarro(cliente2);
		e1.imprimirEstacionamento(); //imprime mapa com 2 carros
		
		Carro desestacionado = e1.desestacionarCarro("FKR8241"); //retira um carro
		e1.imprimirEstacionamento(); //imprime mapa com o carro retirado
		System.out.println(desestacionado.getPlaca()); //imprime placa do carro retirado
	}

}
