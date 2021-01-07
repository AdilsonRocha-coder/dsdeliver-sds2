package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service

public class ProductService {
	
	@Autowired   /* o Autowired faz a resolução de dependência */
	private ProductRepository repository;
	
	@Transactional(readOnly=true)
	public List<ProductDTO> findAll(){           /* aqui obteremos a lista de produtos do banco de dados */
		List<Product> list = repository.findAllByOrderByNameAsc(); /* copiamos o método da Classe ProductRepository */
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}
