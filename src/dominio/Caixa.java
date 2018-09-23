package dominio;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {

	private ArrayList<Item> listaItens;
	private BigDecimal preco;
	private BigDecimal desconto;
	
	public Caixa(ArrayList<Produto> produtos) 
	{
		listaItens = new ArrayList<Item>();
		preco = new BigDecimal("0");
		desconto = new BigDecimal("0");
		
		for(Produto produto : produtos) {
			listaItens.add(new Item(produto));
		}
	}
	
	public Caixa()
	{
		listaItens = new ArrayList<Item>();
		preco = new BigDecimal("0");
		desconto = new BigDecimal("0");
	}
	
	public boolean verificaExistencia(int id)
	{
		for(Item item : listaItens) {
			if(item.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void adicionaProduto (Produto produto, int quantidade) 
	{	
		if(!verificaExistencia(produto.getId())) {
			listaItens.add(new Item(produto));
		}
		for(int i = 0; i < listaItens.size(); i++) {
			
			if(listaItens.get(i).getId() == produto.getId()) {
				listaItens.get(i).addN(quantidade);
				
			}
		}
	}
	
	public void removeProduto (Produto produto, int quantidade) 
	{
		if(verificaExistencia(produto.getId())) {
		
			for(int i = 0; i < listaItens.size(); i++) {
				
				if(listaItens.get(i).getId() == produto.getId()) {
					listaItens.get(i).removeN(quantidade);
				}
				if(listaItens.get(i).getN() == 0) {
					listaItens.remove(i);
				}
			}
		}
	}
	
	public BigDecimal getPreco () 
	{
		preco = new BigDecimal("0");
		for(Item item : listaItens) {
			preco = preco.add(item.getPrecoItem());
		}
		return preco;
	}
	
	public BigDecimal getDesconto () 
	{
		desconto = new BigDecimal("0");
		for(Item item : listaItens) {
			desconto = desconto.add(item.getDescontoItem());
		}
		return desconto;
	}
	
	public BigDecimal getPrecoTotal() 
	{
		return getPreco().subtract(getDesconto());
	}
	
	public Produto getProduto(int id)
	{
		Produto produto = null;
		
		for(Item item : listaItens) {
			if(item.getId() == id) {
				return item.getProduto();
			}
		}
		
		return produto;
	}
	
	public String toString() 
	{
		StringBuilder string = new StringBuilder();
		for(Item item : listaItens) {
				string.append(item.toString());
		}
		
		string.append("Total sem desconto: " + getPreco()
					+ "\nDesconto: " + getDesconto()
					+ "\nPreço a ser pago: " + getPrecoTotal() + "\n");
		return string.toString();
	}
}
