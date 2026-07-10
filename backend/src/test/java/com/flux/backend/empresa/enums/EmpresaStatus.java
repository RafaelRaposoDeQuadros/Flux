package com.flux.backend.empresa.enums;

public enum EmpresaStatus {

    // Os códigos não devem ser alterados após entrarem em produção.

    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3);

    private final int code;

    private EmpresaStatus(int code){
        this.code = code;
    }

    public  int getCode(){
        return code;
    }

    public static EmpresaStatus valueOf(int code){
        for(EmpresaStatus value: EmpresaStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid EmpresaStatus code "+code);
    }
}
