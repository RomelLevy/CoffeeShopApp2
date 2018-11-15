package co.coffeeshop.coffeeshopapp;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CartItemDAO {

	@PersistenceContext
	private EntityManager em;

	public List<CartItem> findAll() {
		return em.createQuery("FROM CartItem", CartItem.class).getResultList();
	} // create query //get results from query

	public CartItem findById(Long id) {
		return em.find(CartItem.class, id);
	}

	public List<CartItem> findByCategory(String category) {
		return em.createQuery("FROM CartItem WHERE category = :category", CartItem.class)
				.setParameter("category", category).getResultList();
	}

	public List<CartItem> findByKeyword(String keyword) {
		return null;

	}

	public void create(CartItem cartItem) {
		em.persist(cartItem);
	}// persist=create

	public void update(CartItem cartItem) {
		em.merge(cartItem);
		// merge=update
	}

	public void delete(Long id) {
		CartItem cartItem = em.getReference(CartItem.class, id);
		em.remove(cartItem);
	}

	public Set<String> findAllCategories() {
		// This query returns a list of Strings, so I give it String.class
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM CartItem", String.class)
				.getResultList();
		// Convert the List to a Set.
		return new TreeSet<>(categoryList);

	}
}
