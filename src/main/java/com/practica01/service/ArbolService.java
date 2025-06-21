
package com.practica01.service;
import com.practica01.domain.Arbol;
import com.practica01.repositorio.ArbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArbolService {

    @Autowired
    private ArbolRepository arbolRepository;

    public List<Arbol> listarTodos() {
        return arbolRepository.findAll();
    }

    public void guardar(Arbol arbol) {
        arbolRepository.save(arbol);
    }

    public Optional<Arbol> buscarPorId(Integer id) {
        return arbolRepository.findById(id);
    }

    public void eliminarPorId(Integer id) {
        arbolRepository.deleteById(id);
    }
}
