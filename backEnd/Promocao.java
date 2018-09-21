package backEnd;

import java.math.BigDecimal;

public interface Promocao {

	public BigDecimal getDesconto(int nProdutos);
	public String getTipo();
	public void setValorUnitario(BigDecimal valorUnitario);
	public int getQuantidadeAtivacao();
	public BigDecimal getValorDesconto();
}
