package com.educandoweb.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.educandoweb.demo.entities.User;
import com.educandoweb.demo.repositories.UserRepository;
import com.educandoweb.demo.resources.exceptions.DatabaseException;
import com.educandoweb.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll (){
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public User insert(User u) {
		return repository.save(u);
	}
	public void delete(long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(repository)	;
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(long id, User u) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity,u);

		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(repository)	;

		}
	}

	private void updateData(User entity, User u) {
		entity.setName(u.getName());	
		entity.setEmail(u.getEmail());
		entity.setPhone(u.getPhone());
	}
}
