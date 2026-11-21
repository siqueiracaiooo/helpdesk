package io.github.siqueiracaiooo.helpdesk;

import io.github.siqueiracaiooo.helpdesk.usr.AccountType;
import io.github.siqueiracaiooo.helpdesk.usr.Admin;
import io.github.siqueiracaiooo.helpdesk.usr.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskApplication {


	public static void main(String[] args) {
		//SpringApplication.run(HelpdeskApplication.class, args);
		User user = new User("nome teste da silva", "teste@teste.com", "senha123", AccountType.ADMIN);
		System.out.println(user);


	}

}
