package com.kamikase.web.posbackend.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {
    String message() default "Email não é válido tente @soares.com ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
