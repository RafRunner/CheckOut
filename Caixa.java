import java.util.ArrayList;

public class Caixa {

	private ArrayList<Item> listaItens;
	private double preco;
	private double desconto;
	
	public Caixa(ArrayList<Produto> produtos) 
	{
		listaItens = new ArrayList<Item>();
		
		for(Produto produto : produtos) {
			listaItens.add(new Item(produto));
		}
	}
	
	public void adicionaProduto (String nome) 
	{
		for(int i = 0; i < listaItens.size(); i++) {
			if(listaItens.get(i).getNome().equals(nome)) {
			
				listaItens.get(i).addProduto();
				
			}
		}
	}
	
	public void removeProduto (String nome) 
	{
		for(int i = 0; i < listaItens.size(); i++) {
			if(listaItens.get(i).getNome().equals(nome)) {
			
				listaItens.get(i).rmProduto();
				
			}
		}
	}
	
	public double getPreco () 
	{
		preco = 0;
		for(Item item : listaItens) {
			preco += item.getProduto().getValor() * item.getN();
		}
		return preco;
	}
	
	public double getDesconto () 
	{
		desconto = 0;
		for(Item item : listaItens) {
			if(item.getProduto().getPromocao() != null)
				desconto += item.getProduto().getPromocao().getDesconto(item.getN());
		}
		return desconto;
	}
	
	public double getPrecoTotal() 
	{
		return getPreco() - getDesconto();
	}
	
	public String toString() 
	{
		StringBuilder string = new StringBuilder();
		for(Item item : listaItens) {
			string.append(item.getNome() + ", " +  item.getN());
		}
		return string.toString();
	}

}
