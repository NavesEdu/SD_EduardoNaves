package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import jakarta.persistence.EntityManager;

@Service
@Transactional
public class ProdutoService {
	
	private EntityManager em;
	
	public Produto salvar(Produto p) {
		p = em.merge(p);
		return p;
	}
	
	public Produto buscarPeloId(Long id) {
		Produto find = em.find(Produto.class, id);
		return find;
	}
	
	
	public List<Produto> listar(){
		List<Produto> resultList = em.createQuery("select p from Produto p", Produto.class).getResultList(); //JPQL
		return resultList;
	}
	
	
	public void remover(Produto p) {
		p = em.merge(p);
		em.remove(p);
	}
	
	
}
