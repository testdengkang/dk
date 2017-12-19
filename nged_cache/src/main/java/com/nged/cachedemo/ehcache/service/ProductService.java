package com.nged.cachedemo.ehcache.service;

import com.nged.cachedemo.ehcache.model.Product;

public interface ProductService {

	Product getByName(String name);
	void refreshAllProducts();
	Product updateProduct(Product product);
	
}
