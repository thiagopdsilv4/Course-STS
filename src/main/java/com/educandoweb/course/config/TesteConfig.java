package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")//tem que ser o mesmo nome que está no sprinfprofile
public class TesteConfig implements CommandLineRunner{
	
	@Autowired//resolve a dependencia e associa um userRepository
	private UserRepository userRepository;//userRepository acessa os  dados.
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryReposity;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		categoryReposity.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria", "5199999999", "maria@gmail.com", "12345678");//ID NULL pois o banco de dados que irá gerar 
		User u2 = new User(null, "Alex", "51999999999", "alex@gmail.com", "12345678");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}


//CLASSE DE CONFIGURAÇÃO PARA INSTANCIAR O BANCO DE DADOS