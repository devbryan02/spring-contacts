package com.miapp.contactos.service;

import java.util.List;

import com.miapp.contactos.model.Contacto;

public interface interfaceS {
  
  public List<Contacto> list(String palabra);
  public Contacto save(Contacto contacto);
  public Contacto update(Contacto contacto);
  public Contacto listById(Integer id);
  public void delete(Integer id);
  

}
