package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class NotaCompraItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Positive
	private BigDecimal valorCompraProduto;
	
	@NotNull
	@Positive
	private Integer quantidade;
	
	@ManyToOne
	private NotaCompra notaCompra;
	
	@ManyToOne
	private Produto produto;
	
	//Calculo do total do item em tempo de execução:
	public BigDecimal getCalculoTotalItem() {
		return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
	}
	
}
