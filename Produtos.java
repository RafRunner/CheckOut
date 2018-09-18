
public enum Produtos {
	
	A("A", 50.0, new PagueXPorY(50, 130, 3)), 
	B("B", 30.0, new PagueXPorY(30, 45, 2)),
	C("C", 20.0, new LeveXPagueY(20, 3, 2)),
	D("D", 15.0, null);
	
	private String nome;
	private double valorUnitario;
	private Promocao promocao;
	
	Produtos(String nome, double valorUnitario, Promocao promocao)
	{
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.promocao = promocao;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public double getValorUnitario()
	{
		return valorUnitario;
	}
	
	public Promocao getPromocao()
	{
		return promocao;
	}
}
