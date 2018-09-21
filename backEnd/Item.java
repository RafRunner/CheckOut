package backEnd;

public class Item {
	
	private Produto produto;
	private int n;
	
	public Item(Produto produto) 
	{
		this.produto = produto;
		this.n = 0;
	}
	
	public void addProduto()
	{
		n++;
	}
	
	public void rmProduto()
	{
		if (n!=0) {
			n--;
		}
	}
	
	public Produto getProduto() 
	{
		return produto;
	}

	public int getN() 
	{
		return n;
	}
}
