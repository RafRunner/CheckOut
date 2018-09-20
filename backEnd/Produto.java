package backEnd;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Produto {

	private int id;
	private String  nome;
	private BigDecimal valorUnitario;
	private ArrayList<Promocao> promocoes = new ArrayList<Promocao>();

	public Produto(int id, String nome, BigDecimal valorUnitario,  ArrayList<Promocao> promocoes) 
	{
		this.id = id;
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		this.promocoes = promocoes;
	}
	
	public Produto(String nome, BigDecimal valorUnitario,  ArrayList<Promocao> promocoes) 
	{
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		this.promocoes = promocoes;
	}
	
	public Produto(int id, String nome, BigDecimal valorUnitario, Promocao promocao) 
	{
		this.id = id;
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		if(promocao != null) {
			this.promocoes.add(promocao);
		}
	}

	public int getId()
	{
		return id;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public BigDecimal getValor()
	{
		return valorUnitario;
	}

	public  ArrayList<Promocao> getPromocoes() 
	{
		return promocoes;
	}
	
	public String toString()
	{
		return "id = " + id
				+ "\nnome = " + nome
				+ "\nvalor unitario = " + valorUnitario;
	}
}
