package com.kamikase.web.posbackend.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.kamikase.web.posbackend.client.CNPJwsClient;
import com.kamikase.web.posbackend.model.Clube;

import com.kamikase.web.posbackend.model.dto.CNPJwsResponseDTO;
import com.kamikase.web.posbackend.model.dto.ClubeDTO;
import com.kamikase.web.posbackend.service.ClubeService;

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

    @Autowired
    private CNPJwsClient cnpjService;

    @PostMapping
    public ResponseEntity<Clube> cadastrar(@RequestBody Clube clube) {
        clube = clubeService.cadastrar(clube);
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
    @GetMapping("buscar/todos")
    public ResponseEntity<List<ClubeDTO>> buscarTodos() {

        List<Clube> lista = clubeService.listar();
        List<ClubeDTO> clubes = new ArrayList<>();


        for (Clube clube : lista) {
            ClubeDTO clubeDTO = new ClubeDTO();
            var cnpjResponse = cnpjService.consultaCNPJ(clube.getCnpj());

            clubeDTO.setNome(clube.getNome());
            clubeDTO.setEmail(clube.getEmail());
            clubeDTO.setCnpj(clube.getCnpj());
            clubeDTO.setRazao_social(cnpjResponse.getRazao_social());
            clubeDTO.setDetalhes_empresa(cnpjResponse.getEstabelecimento());

            clubes.add(clubeDTO);
        }
        return ResponseEntity.ok(clubes);
    }

    @GetMapping("buscar/todos/asc")
    public ResponseEntity<List<ClubeDTO>> buscarTodosAsc() {

        List<Clube> lista = clubeService.listarAsc();
        List<ClubeDTO> clubes = new ArrayList<>();


        for (Clube clube : lista) {
            ClubeDTO clubeDTO = new ClubeDTO();
            var cnpjResponse = cnpjService.consultaCNPJ(clube.getCnpj());

            clubeDTO.setNome(clube.getNome());
            clubeDTO.setEmail(clube.getEmail());
            clubeDTO.setCnpj(clube.getCnpj());
            clubeDTO.setRazao_social(cnpjResponse.getRazao_social());
            clubeDTO.setDetalhes_empresa(cnpjResponse.getEstabelecimento());

            clubes.add(clubeDTO);
        }
        return ResponseEntity.ok(clubes);
    }

    @GetMapping("buscar/nome/{nome}")
    public ResponseEntity<ClubeDTO> buscarPorNome(String nome) {
        Clube clube = clubeService.listarPorNome(nome);
        ClubeDTO clubeDTO = new ClubeDTO();
        clubeDTO.setNome(clube.getNome());
        clubeDTO.setEmail(clube.getEmail());
        clubeDTO.setCnpj(clube.getCnpj());

        return ResponseEntity.ok(clubeDTO);
    }

    @GetMapping("buscar/id/{id}")
    public ResponseEntity<ClubeDTO> buscarPorId(Integer id) {
        Clube clube = clubeService.listarPorId(id);
        ClubeDTO clubeDTO = new ClubeDTO();
        clubeDTO.setNome(clube.getNome());
        clubeDTO.setEmail(clube.getEmail());
        clubeDTO.setCnpj(clube.getCnpj());

        return ResponseEntity.ok(clubeDTO);
    }



}