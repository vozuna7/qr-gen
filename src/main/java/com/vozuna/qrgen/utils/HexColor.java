package com.vozuna.qrgen.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HexColorValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface HexColor {

    String message() default "Invalid hex color";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
