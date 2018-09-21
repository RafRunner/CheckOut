package backEnd;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Produto {

	private int identificador;
	private String  nome;
	private BigDecimal valorUnitario;
	private ArrayList<Promocao> promocoes = new ArrayList<Promocao>();

	public Produto(int identificador, String nome, BigDecimal valorUnitario,  ArrayList<Promocao> promocoes) 
	{
		this.identificador = identificador;
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		this.promocoes = promocoes;
	}
	
	public Produto(int identificador, String nome, BigDecimal valorUnitario, Promocao promocao) 
	{
		this.identificador = identificador;
		this.valorUnitario = valorUnitario;
		this.nome = nome;
		if(promocao != null) {
			this.promocoes.add(promocao);
		}
	}

	public int getId()
	{
		return identificador;
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
	
	public void setPromocoes(ArrayList<Promocao> promocoes)
	{
		this.promocoes = promocoes;
	}
	
	public void adicionarPromocao(Promocao promocao)
	{
		promocoes.add(promocao);
	}
	
	public String toString()
	{
		StringBuilder string = new StringBuilder("identificador = " + identificador
				+ "\nnome = " + nome
				+ "\nvalor unitario = " + valorUnitario + "\nPromoções:\n");
		
		if(promocoes != null) {
			for(Promocao promocao : promocoes) {
				string.append(promocao.toString());
			}
		}
		
		return string.toString();
	}
}
