package com.springboot.petclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RuntimeCustomException extends RuntimeException {


  public RuntimeCustomException(String message){
      super(message);
  }


}
