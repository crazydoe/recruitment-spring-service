package com.michal.simpleCrudApplication;

public interface Validator<T> {

    void validate(T dto);
}
