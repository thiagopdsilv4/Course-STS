package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")//tem que ser o mesmo nome que está no sprinfprofile
public class TesteConfig implements CommandLineRunner{
	
	@Autowired//resolve a dependencia e associa um userRepository
	private UserRepository userRepository;//userRepository acessa os  dados.

	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria", "5199999999", "maria@gmail.com", "12345678");//ID NULL pois o banco de dados que irá gerar 
		User u2 = new User(null, "Alex", "51999999999", "alex@gmail.com", "12345678");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}


//CLASSE DE CONFIGURAÇÃO PARA INSTANCIAR O BANCO DE DADOS