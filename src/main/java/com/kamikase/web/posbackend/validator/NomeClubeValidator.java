package com.kamikase.web.posbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class NomeClubeValidator implements
        ConstraintValidator<NomeClubeValidation, String> {

    List<String> clubesBarrados = Arrays.asList("Flamengo", "Palmeiras", "Fluminense", "Botafogo");
    private String message;

    @Override
    public void initialize(NomeClubeValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if (!clubesBarrados.contains(nome)) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return false;
    }
}