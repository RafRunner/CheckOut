package dominio;

import java.math.BigDecimal;

public class Item {
	
	private Produto produto;
	private int n;
	
	public Item(Produto produto) 
	{
		this.produto = produto;
		this.n = 0;
	}
	
	public Produto getProduto()
	{
		return produto;
	}
	
	public int getId()
	{
		return produto.getId();
	}

	public int getN() 
	{
		return n;
	}
	
	public void addN(int n) 
	{
		this.n += n;
	}
	
	public void removeN(int n)
	{
		if(n <= this.n) {
			this.n -= n;
		}
	}
	
	public BigDecimal getPrecoItem()
	{
		return produto.getValor().multiply(BigDecimal.valueOf(n));
	}
	
	public BigDecimal getDescontoItem()
	{
		BigDecimal maiorDesconto = new BigDecimal("0");
		
		if(produto.getPromocoes() != null) {
			
			for(Promocao promocao : produto.getPromocoes()) {
			
				if(promocao.getDesconto(n).compareTo(maiorDesconto) > 0) {
					maiorDesconto = promocao.getDesconto(n);
				}
			}
		}
		return maiorDesconto;
	}
	
	@Override
	public String toString()
	{
		return n + " x " + produto.toString() + "\n";
	}
}
