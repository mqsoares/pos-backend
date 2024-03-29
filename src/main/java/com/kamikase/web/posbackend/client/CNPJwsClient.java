package com.kamikase.web.posbackend.client;

import com.kamikase.web.posbackend.model.dto.CNPJwsResponseDTO;
import com.kamikase.web.posbackend.model.dto.CepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ConsultaCNPJ", url="https://publica.cnpj.ws/cnpj/")
public interface CNPJwsClient {
    @GetMapping("{cnpj}")
    CNPJwsResponseDTO consultaCNPJ(@PathVariable("cnpj") String cnpj);
}
