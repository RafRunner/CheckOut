
public class Produto {

	private double valorUnitario;
	private String  nome;
	private Promocao promocao;

	public Produto( String nome, double valorUnitario, Promocao promocao) 
	{
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		this.promocao = promocao;
	}
	
	//Construtor temporário para o emum(simulação do banco de dados)
	public Produto(Produtos nome) 
	{
		this.nome = nome.getNome();
		this.valorUnitario = nome.getValorUnitario();
		this.promocao = nome.getPromocao();
	}

	public String getNome()
	{
		return nome;
	}
	
	public double getValor()
	{
		return valorUnitario;
	}

	public Promocao getPromocao() 
	{
		return promocao;
	}
}
