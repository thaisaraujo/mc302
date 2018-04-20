
public class Carro { //inicio da classe Carro
	
	private String marca;
	private String modelo;
	private String placa;
	private String chassi;
	private String cor;
	private String combustivel;
	private int ano;
	private String renavam;
	private String quilometragem; //dados do carro
	private AndarGaragem andarLocalizado;
	private int[] localizacao; //dados de carro, com objetos para o andar que esta estacionado e vetor
	
	public Carro (String marca, String modelo, String placa, String chassi, String cor, String combustivel, int ano, String renavam, String quilometragem) {
		//inicio do metodo construtor
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.chassi = chassi;
		this.cor = cor;
		this.combustivel = combustivel;
		this.ano = ano;
		this.renavam = renavam;
		this.quilometragem = quilometragem;
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
	
	public String getChassi() { //inicio do metodo getChassi
		return chassi;
	} //fim do metodo getChassi
	
	public String getCor() { //inicio do metodo getCor
		return cor;
	} //fim do metodo getCor
	
	public String getCombustivel() { //inicio do metodo getCombustivel
		return combustivel;
	} //fim do metodo getCombustivel
	 
	public int getAno() { //inicio do metodo getAno
		return ano;
	} //fim do metodo getAno
	
	public String getRenavam() { //inicio do metodo getRenavam
		return renavam;
	} //fim do metodo getRenavam
	
	public String getQuilometragem() { //inicio do metodo getQuilometragem
		return quilometragem;
	} //fim do metodo getQuilometragem

	public void imprimeCarro() { //inicio do metodo imprimeCarro
		System.out.printf("%s  ", getPlaca());
	} //fim do metodo imprimeCarro
	
	public AndarGaragem getAndarLocalizado() { //inicio do metodo getAndarLocalizado
		return andarLocalizado;
	} //fim do metodo getAndarLocalizado

	public void setAndarLocalizado(AndarGaragem andarLocalizado) { //inicio do metodo setAndarLocalizado
		this.andarLocalizado = andarLocalizado;
	} //fim do metodo setAndarLocalizado

	public int[] getLocalizacao() { //inicio do metodo getLocalizacao
		return localizacao; //vetor de duas posicoes que marca posicao do carro na matriz
	} //fim do metodo getLocalizacao

	public void setLocalizacao(int[] localizacao) { //inicio do metodo setLocalizacao
		this.localizacao = localizacao;
	} //fim do metodo setLocalizacao
} //fim da classe Carro
