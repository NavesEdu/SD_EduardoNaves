package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class NotaCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Past
	private LocalDate dataEmissao;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@OneToMany
	private List<NotaCompraItem> listaNotaCompraItem;
	
	//Calcula o total da nota somando os totais de cada item
	public BigDecimal getCalculoTotalNota() {
		BigDecimal totalNota = listaNotaCompraItem.stream()
			.map(i -> i.getCalculoTotalItem())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return totalNota;
	}
}
