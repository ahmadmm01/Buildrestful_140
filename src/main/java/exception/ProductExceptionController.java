/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author MADD
 */
@ControllerAdvice
public class ProductExceptionController
{
    @ExceptionHandler(value = ProductAlreadyExist.class)
    public ResponseEntity<Object> exception(ProductAlreadyExist exception)
    {
        return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(value = ProductNotfound.class)
    public ResponseEntity<Object> exception(ProductNotfound exception)
    {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
