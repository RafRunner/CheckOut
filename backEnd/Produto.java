package backEnd;
import java.util.ArrayList;

public class Produto {

	private String  nome;
	private double valorUnitario;
	private ArrayList<Promocao> promocoes = new ArrayList<Promocao>();

	public Produto(String nome, double valorUnitario,  ArrayList<Promocao> promocoes) 
	{
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		this.promocoes = promocoes;
	}
	
	public Produto(String nome, double valorUnitario, Promocao promocao) 
	{
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		if(promocao != null) {
			this.promocoes.add(promocao);
		}
	}
	
	//Construtor temporário para o emum(simulação do banco de dados)
	public Produto(Produtos nome) 
	{
		this.nome = nome.getNome();
		this.valorUnitario = nome.getValorUnitario();
		if(nome.getPromocao() != null) {
			this.promocoes.add(nome.getPromocao());
		}
	}

	public String getNome()
	{
		return nome;
	}
	
	public double getValor()
	{
		return valorUnitario;
	}

	public  ArrayList<Promocao> getPromocoes() 
	{
		return promocoes;
	}
}
