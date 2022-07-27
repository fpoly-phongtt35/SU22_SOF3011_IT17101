package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

	private final ProductRepository productRepo
		= new ProductRepository();
	
	public List<Product> getAllProduct() {
		return productRepo.getAll();
	}
}
