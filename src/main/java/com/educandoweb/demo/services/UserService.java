package com.educandoweb.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.demo.entities.User;
import com.educandoweb.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll (){
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User u) {
		return repository.save(u);
	}
	public void delete(long id) {
		repository.deleteById(id);
	}

	public User update(long id, User u) {
		User entity = repository.getReferenceById(id);
		updateData(entity,u);

		return repository.save(entity);
	}

	private void updateData(User entity, User u) {
		entity.setName(u.getName());	
		entity.setEmail(u.getEmail());
		entity.setPhone(u.getPhone());
	}
}
