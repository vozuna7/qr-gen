package com.vozuna.qrgen.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class HexColorValidator implements ConstraintValidator<HexColor, String> {

    private static final String HEX_COLOR_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    @Override
    public void initialize(HexColor constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(final String value,final ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            // Allow empty value
            return true;
        }
        return value.matches(HEX_COLOR_PATTERN);
    }
}
