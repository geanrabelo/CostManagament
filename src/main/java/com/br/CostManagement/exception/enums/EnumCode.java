package com.br.CostManagement.exception.enums;

public enum EnumCode {
    USR000("User find by id not found"),
    USR001("User already exists in database"),
    CAT000("Category find by id not found"),
    CAT001("Category already exists in database"),
    CST000("Cost find by id not found"),
    CST001("Cost alrady exists in database");

    private String message;

    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
