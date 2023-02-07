package com.jacaranda.primerSpring.service;

import java.util.List;

import javax.lang.model.element.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.element;
import com.jacaranda.primerSpring.repository.ElementRepository;

	@Service
	public class ElementService {
		
	@Autowired
	private ElementRepository repository;

	public element add(element s) {
	return repository.save(s);
	}

	public List<element> findAll() {
	return repository.findAll();
	}
	
	

	public element findById(Integer id) {
	return repository.findById(id).orElse(null);
	}

	public element save(element e) {
	return repository.save(e);
	}

	public void delete(element e) {
	repository.delete(e);
	}

}
