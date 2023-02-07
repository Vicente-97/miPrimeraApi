package com.jacaranda.primerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.primerSpring.model.element;

public interface ElementRepository extends JpaRepository<element, Integer> {

	

}
