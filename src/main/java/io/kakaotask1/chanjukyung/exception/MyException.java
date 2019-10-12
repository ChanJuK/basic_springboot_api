package io.kakaotask1.chanjukyung.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class MyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
    public MyException(String message) {
        super(message);
    }

}
