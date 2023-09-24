package com.miapp.contactos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.miapp.contactos.model.Contacto;
import com.miapp.contactos.service.ContactoS;

@Controller
public class ContactoC {

  @Autowired
  private ContactoS service;

  @GetMapping("/")
  public String index(Model model, @Param("palabra") String palabra){
    model.addAttribute("contactos", this.service.list(palabra));
    model.addAttribute("palabra", palabra);
    return "index";
  }

  @GetMapping("/nuevo")
  public String newForm(Model model){
    model.addAttribute("contacto", new Contacto());
    return "new";
  }

  @PostMapping("/")
  public String newContact(@ModelAttribute("contacto") Contacto contacto){
    String date = this.service.dateString();
    contacto.setR_date(date);
    this.service.save(contacto);
    return "redirect:/";
  }

  @GetMapping("/actualizar/{id}")
  public String updateForm(@PathVariable Integer id, Model model){
    model.addAttribute("contacto", this.service.listById(id));
    return "update";
  }

  @PostMapping("/{id}")
  public String update(@PathVariable Integer id, @ModelAttribute("contacto") Contacto contacto){
    Contacto contacExits = new Contacto();
    contacExits.setId(id);
    contacExits.setName(contacto.getName());
    contacExits.setPhone_number(contacto.getPhone_number());
    contacExits.setEmail(contacto.getEmail());
    contacExits.setR_date(this.service.dateString());
    this.service.save(contacExits);
    return "redirect:/";
  }

  @GetMapping("/{id}")
  public String delete(@PathVariable Integer id){
    this.service.delete(id);
    return "redirect:/";
  }
  
}
