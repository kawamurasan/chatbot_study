package com.example.hello.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dao.Product;

@RestController
@RequestMapping("api/product")
public class ProductController {

	private Map<String, Product> products = new HashMap<String, Product>() {
		  private static final long serialVersionUID = 1L;
		  {
		    put("1", new Product("1", "商品A", 2000));
		    put("2", new Product("2", "商品B", 3000));
		    put("3", new Product("3", "商品C", 4000));
		  }
	};

	@GetMapping
	@CrossOrigin
	public List<Product> getAll() {
	  return new ArrayList<>(products.values());
	}

	@GetMapping("{id}")
	@CrossOrigin
	public Product getById(@PathVariable("id") String id) {
	  return products.get(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	public void create(Product product) {
	  products.put(product.getId(), product);
	}

	@PutMapping
	@CrossOrigin
	public ResponseEntity<Object> update(Product product) {
	  HttpStatus status = products.containsKey(product.getId())
	                    ? HttpStatus.NO_CONTENT : HttpStatus.CREATED;
	  products.put(product.getId(), product);
	  return ResponseEntity.status(status).body(null);
	}

	@DeleteMapping("{id}")
	@CrossOrigin
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
	  products.remove(id);
	}
}
