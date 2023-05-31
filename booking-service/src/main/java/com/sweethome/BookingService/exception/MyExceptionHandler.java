package com.sweethome.BookingService.exception;


import com.sweethome.BookingService.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(InvalidBooking.class)
    public final ResponseEntity<ErrorDTO> handleInvalidPayment(InvalidBooking e, WebRequest res){

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Invalid Booking Id");
        errorDTO.setStatusCode(400);
        return new ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPaymentMode.class)
    public final ResponseEntity<ErrorDTO> handleInvalidPaymentMode(InvalidPaymentMode e, WebRequest res){

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Invalid mode of payment");
        errorDTO.setStatusCode(400);
        return new ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
