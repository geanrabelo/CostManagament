package com.br.CostManagement.exception.enums;

public enum EnumCode {
    USR000("User find by id not found"),
    USR001("User already exists in database");

    private String message;

    EnumCode(String message){
        this.message = message;
    }
}
