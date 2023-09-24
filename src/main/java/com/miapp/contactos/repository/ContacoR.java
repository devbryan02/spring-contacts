package com.miapp.contactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.contactos.model.Contacto;

public interface ContacoR  extends JpaRepository<Contacto, Integer>{
  
}
