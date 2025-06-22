
package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaArboles", arbolService.listarTodos());
        return "arbol/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "arbol/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("arbol") Arbol arbol) {
        arbolService.guardar(arbol);
        return "redirect:/arboles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Arbol arbol = arbolService.buscarPorId(id).orElse(null);
        model.addAttribute("arbol", arbol);
        return "arbol/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        arbolService.eliminarPorId(id);
        return "redirect:/arboles";
    }
}
