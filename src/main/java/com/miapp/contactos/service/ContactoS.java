package com.miapp.contactos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miapp.contactos.model.Contacto;
import com.miapp.contactos.repository.ContacoR;

@Service
public class ContactoS implements interfaceS {

  @Autowired
  private ContacoR repo;

  @Override
  public List<Contacto> list(String palabra) {
    if(palabra != null){
      return this.repo.findAll(palabra);
    }
    return this.repo.findAll();
  }

  @Override
  public Contacto save(Contacto contacto) {
    return this.repo.save(contacto);
  }

  @Override
  public Contacto update(Contacto contacto) {
    return this.repo.save(contacto);
  }

  @Override
  public Contacto listById(Integer id) {
    return this.repo.findById(id).get();
  }

  @Override
  public void delete(Integer id) {
    this.repo.deleteById(id);
  }

  public String dateString(){
    LocalDate date = LocalDate.now();
    String fechaActual = date.toString();
    return fechaActual;
  }

}
