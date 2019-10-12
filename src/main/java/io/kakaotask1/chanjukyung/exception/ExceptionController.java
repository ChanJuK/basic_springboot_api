package io.kakaotask1.chanjukyung.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {

	
	
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = MyException.class)
//    public String handleBaseException(MyException e){
//        return e.getMessage();
//    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Exception handleEmptyEmail(HttpServletRequest req, MyException ex) {
        return new Exception( ex.getLocalizedMessage());
    }
    
    
    /*
        Custom Exception
     */
//    @ExceptionHandler(MyException.class)
//    @ResponseBody
//    public ResponseEntity<?> handleSomeException(HttpServletRequest request, MyException ex) {
//    	
//        // SomeException 예외 발생시 처리 로직 작성
//        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
//    }


}
