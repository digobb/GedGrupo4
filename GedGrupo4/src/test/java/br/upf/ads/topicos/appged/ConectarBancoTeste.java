package br.upf.ads.topicos.appged;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.upf.ads.topicos.entities.Produto;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ConectarBancoTeste extends TestCase
{
    
	@org.junit.Test
	public void testCriarBase() {
		Persistence.createEntityManagerFactory("appged");
	}
	
	@org.junit.Test
	public void testInserir() { //não contém produtos neste novo projeto
		EntityManager em = Persistence.createEntityManagerFactory("appged").createEntityManager();
		em.getTransaction().begin();
		em.merge(new Produto(1, "Produto 1", 12.3f));
		em.merge(new Produto(2, "Produto 2", 212.3f));
		em.merge(new Produto(3, "Produto 3", 312.3f)); 
		em.merge(new Produto(4, "Produto 4", 412.3f));
		em.merge(new Produto(5, "Produto 5", 512.3f));
		em.merge(new Produto(6, "Produto 6", 612.3f));
		em.merge(new Produto(7, "Produto 7", 712.3f));
		em.merge(new Produto(8, "Produto 8", 812.3f));
		em.merge(new Produto(9, "Produto 9", 912.3f));
		em.merge(new Produto(10, "Produto 10", 1012.3f));
		em.merge(new Produto(11, "Produto 11", 1112.3f));
		em.merge(new Produto(12, "Produto 12", 1212.3f));
		em.merge(new Produto(13, "Produto 13", 1312.3f));
		em.merge(new Produto(14, "Produto 14", 1412.3f));
		em.merge(new Produto(15, "Produto 15", 1512.3f));
		em.getTransaction().commit(); 
	}
	
	@org.junit.Test
	public void testListar() { //não contém produtos neste novo projeto
		EntityManager em = Persistence.createEntityManagerFactory("appged").createEntityManager();
		List<Produto> l = em.createQuery("from Produto").getResultList();
		for(Produto p : l) {
			System.out.println(p.getId()+" - "+p.getNome());
		}
	}
		
	

}
