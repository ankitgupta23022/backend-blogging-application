package com.api.blog;

import java.util.ArrayList;
import java.util.List;

import com.api.blog.entities.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.blog.config.AppConstants;
import com.api.blog.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {


			List<Role> rolesList = new ArrayList<>();
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");
			rolesList.add(role);

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");
			rolesList.add(role1);


			List<Role> roles = rolesList;

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
