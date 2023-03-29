package com.romelce.ecommerce.product.domain;


import com.romelce.ecommerce.category.domain.Category;
import com.romelce.ecommerce.purchase.domain.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "stock")
	private Integer stock;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@ManyToMany
	@JoinTable(name = "detail_prod_purchase",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "purchase_id"))
	private Set<Purchase> purchases = new HashSet<>();

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_product_category",
					foreignKeyDefinition = "FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Category category;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
