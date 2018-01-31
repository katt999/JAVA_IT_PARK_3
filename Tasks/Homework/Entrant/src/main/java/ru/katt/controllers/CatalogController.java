package ru.katt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

  @GetMapping("")
  public String getIndexPage() {
    return "index";
  }

}
