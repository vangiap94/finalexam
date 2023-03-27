package com.vti.validation;

import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class  AccountUsernameNotExistsValidate implements ConstraintValidator<AccountUsernameNotExists, String> {
    @Autowired
    private IAccountRepository repository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByUsername(name) ;
    }
}
