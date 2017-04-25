package com.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CART")
public class CartAnnotation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long id;
	@Column(name = "total")
	private double total;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "cart")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	// both from org.hibernate.annotations.
	private Set<ItemsAnnotation> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ItemsAnnotation> getItems() {
		return items;
	}

	public void setItems(Set<ItemsAnnotation> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartAnnotation [id=" + id + ", total=" + total + ", name="
				+ name + "]";
	}

	
	
}
