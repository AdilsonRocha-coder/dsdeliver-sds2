package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service

public class OrderService {
	
	@Autowired   /* o Autowired faz a resolução de dependência */
	private OrderRepository repository;
	
	@Transactional(readOnly=true)
	public List<OrderDTO> findAll(){           /* aqui obteremos a lista de produtos do banco de dados */
		List<Order> list = repository.findOrdersWithProducts(); 
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
