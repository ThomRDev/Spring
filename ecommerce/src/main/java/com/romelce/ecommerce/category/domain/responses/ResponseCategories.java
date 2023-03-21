package com.romelce.ecommerce.category.domain.responses;

import com.romelce.ecommerce.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCategories {
	private List<Category> categories;
}
