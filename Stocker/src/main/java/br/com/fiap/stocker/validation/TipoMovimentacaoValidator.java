package br.com.fiap.stocker.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoMovimentacaoValidator implements ConstraintValidator <TipoMovimentacao, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("DEBITO") || value.equals("CREDITO");
    }

}
