package com.kamikase.web.posbackend.controller;

//import com.kamikase.web.posbackend.client.GetCampeonatoExternalAPIClient;
import com.kamikase.web.posbackend.model.Clube;
//import com.kamikase.web.posbackend.model.dto.CampeonatoResponseExternalApiDTO;
import com.kamikase.web.posbackend.service.ClubeService;
//import com.kamikase.web.posbackend.model.dto.ClubeResponseDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clube")
public class ClubeController {
    @Autowired
    private ClubeService clubeService;

    @PostMapping
    public ResponseEntity<Clube> cadastrar(@RequestBody Clube clube) {
        clube = clubeService.cadastrar(clube);
        return ResponseEntity.ok(clube);
    }

    @GetMapping("buscar/todos")
    public ResponseEntity<List<Clube>> buscarTodos() {
        List<Clube> lista = clubeService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("buscar/nome/{nome}")
    public ResponseEntity<Clube> buscarPorNome(String nome) {
        Clube clube = clubeService.listarPorNome(nome);
        return ResponseEntity.ok(clube);
    }

    @GetMapping("buscar/id/{id}")
    public ResponseEntity<Clube> buscarPorId(Integer id) {
        Clube clube = clubeService.listarPorId(id);
        return ResponseEntity.ok(clube);
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<Clube> alterar(Integer id, @RequestBody Clube clube) {
        clube.setId(id);
        Clube alteracao = clubeService.alterar(clube);
        return ResponseEntity.ok(alteracao);
    }

    @DeleteMapping("apagar/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        clubeService.apagar(id);
        return ResponseEntity.noContent().build();
    }

}