package co.coffeeshop.coffeeshopapp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="menu_item")
public class MenuItem {

	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name="category", length=40)
	private String category;
	@Column(name="description")
	private String description;
	private Double price;

	public MenuItem() {}
	
	
	public MenuItem(Long id, String name, String category, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	
	
	public MenuItem(String name, String category, String description) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + "]";
	}

	// TODO Auto-generated constructor stub
}
