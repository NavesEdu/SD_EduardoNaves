package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class NotaCompraService {

	@PersistenceContext
	private EntityManager em; 
	
	public NotaCompra salvarNotaCompra(NotaCompra f) {
		f = em.merge(f);
		return f;
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		NotaCompra f = em.find(NotaCompra.class, id);
		return f;
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		NotaCompra f = em.find(NotaCompra.class, id);
		f.getListaNotaCompraItem().size();
		return f;
	}
	
	public List<NotaCompra> listarNotaCompra(){
		List<NotaCompra> resultList = em.createQuery("select f from NotaCompra f", NotaCompra.class).getResultList(); //JPQL
		return resultList;
	}
	
	public void remover(NotaCompra f) {
		f = em.merge(f);
		em.remove(f);
	}
	
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem f) {
		f = em.merge(f);
		return f;
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		NotaCompraItem f = em.find(NotaCompraItem.class, id);
		return f;
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		List<NotaCompraItem> resultList = em.createQuery("select f from NotaCompraItem f", NotaCompraItem.class).getResultList(); //JPQL
		return resultList;
	}
	
}
