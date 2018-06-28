package usuarios;

public class Carro { //inicio da classe Carro
	
	//tipos de carros
	public static final int PEQUENO = 1;
	public static final int MEDIO = 2;
	public static final int GRANDE = 3;
	
	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private int tipo;
	private double quilometragem; //dados do carro
	private int andarLocalizado;
	private int[] localizacao; //dados de carro, com objetos para o andar que esta estacionado e vetor
	
	public Carro (String marca, String modelo, String placa, String cor, double quilometragem, int tipo) {
		//inicio do metodo construtor
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.quilometragem = quilometragem;
		this.tipo = tipo;
	} //fim do metodo construtor
	
	public String getMarca() { //inicio do metodo getMarca
		return marca;
	} //fim do metodo getMarca
	
	public String getModelo(){ //inicio do metodo getModelo
		return modelo;
	} //fim do metodo getModelo
	
	public String getPlaca() { //inicio do metodo getPlaca
		return placa;
	} //fim do metodo getPlaca
	
	public String getCor() { //inicio do metodo getCor
		return cor;
	} //fim do metodo getCor
	
	public double getQuilometragem() { //inicio do metodo getQuilometragem
		return quilometragem;
	} //fim do metodo getQuilometragem
	
	public int getTipo() { //inicio do metodo getTipo
		return tipo;
	} //fim do metodo getTipo
	
	public void setQuilometragem(double quilometragem) { //inicio do metodo setQuilometragem
		if(quilometragem > this.quilometragem) {
			this.quilometragem = quilometragem;
		}
		else {
			System.out.println("Quilometragem invalida");
		}
	} //fim do metodo quilometragem

	public String imprimirCarro() { //inicio do metodo imprimeCarro
		String saida = "Carro placa:" + placa + " esta na linha" + ((char)localizacao[0]+65) + ", coluna" + localizacao[1] + "andar" + andarLocalizado + "\n";
		
		if(getTipo() == 1) {
			saida = saida + "Tipo: Pequeno\n";
		}else if(getTipo() == 2) {
			saida = saida + "Tipo: Médio\n";
		}else if(getTipo() == 3) {
			saida = saida + "Tipo: Grande\n";
		}
		
		return saida;
		
	//	System.out.println("Carro placa" + placa +" esta na linha " + ((char) localizacao[0] + 65) + ", coluna " + localizacao[1] +
	//	", andar " + andarLocalizado);
	} //fim do metodo imprimeCarro
	
	public int getAndarLocalizado() { //inicio do metodo getAndarLocalizado
		return andarLocalizado;
	} //fim do metodo getAndarLocalizado

	public void setAndarLocalizado(int andarLocalizado) { //inicio do metodo setAndarLocalizado
		this.andarLocalizado = andarLocalizado;
	} //fim do metodo setAndarLocalizado

	public int[] getLocalizacao() { //inicio do metodo getLocalizacao
		return localizacao; //vetor de duas posicoes que marca posicao do carro na matriz
	} //fim do metodo getLocalizacao

	public void setLocalizacao(int[] localizacao) { //inicio do metodo setLocalizacao
		this.localizacao = localizacao;
	} //fim do metodo setLocalizacao


} //fim da classe Carro
