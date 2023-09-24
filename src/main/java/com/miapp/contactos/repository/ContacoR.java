package com.miapp.contactos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miapp.contactos.model.Contacto;

@Repository
public interface ContacoR extends JpaRepository<Contacto, Integer> {

  @Query("SELECT c FROM Contacto c WHERE c.name LIKE %:palabra%"+
                                                      " or c.phone_number like %:palabra%")
  public List<Contacto> findAll(@Param("palabra") String palabra);

}
