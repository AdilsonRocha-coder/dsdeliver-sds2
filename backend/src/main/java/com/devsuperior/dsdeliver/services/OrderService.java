package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service

public class OrderService {
	
	@Autowired   /* o Autowired faz a resolução de dependência */
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;   /*aqui associaremos os produtos aos pedidos */
	
	@Transactional(readOnly=true)
	public List<OrderDTO> findAll(){           /* aqui obteremos a lista de produtos do banco de dados */
		List<Order> list = repository.findOrdersWithProducts(); 
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){     /* esse método retornará um objeto orderDTO correspondente ao pedido e seus itens inserido no BD */
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);  /* aqui salvaremos esse prdido/produto no BD */
		return new OrderDTO(order);
	}
	

}
