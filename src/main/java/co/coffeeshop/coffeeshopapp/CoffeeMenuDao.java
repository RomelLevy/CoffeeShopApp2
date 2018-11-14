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
public class CoffeeMenuDao {

	@PersistenceContext
	private EntityManager em;

	public List<MenuItem> findAll() {
		return em.createQuery("FROM MenuItem", MenuItem.class).getResultList();
	} // create query //get results from query

	public MenuItem findById(Long id) {
		return em.find(MenuItem.class, id);
	}

	public List<MenuItem> findByCategory(String category) {
		return em.createQuery("FROM MenuItem WHERE category = :category", MenuItem.class)
				.setParameter("category", category).getResultList();
	}

	public List<MenuItem> findByKeyword(String keyword) {
		return null;

	}

	public void create(MenuItem menuItem) {
		em.persist(menuItem);
	}// persist=create

	public void update(MenuItem menuItem) {
		em.merge(menuItem);
		// merge=update
	}

	public void delete(Long id) {
		MenuItem menuItem = em.getReference(MenuItem.class, id);
		em.remove(menuItem);
	}

	public Set<String> findAllCategories() {
		// This query returns a list of Strings, so I give it String.class
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM MenuItem", String.class)
				.getResultList();
		// Convert the List to a Set.
		return new TreeSet<>(categoryList);
	}

}
