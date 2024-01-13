package classy.classyapp.BackendApi.controller;

import classy.classyapp.BackendApi.exception.global.InternalServerError;
import classy.classyapp.BackendApi.exception.global.BadRequestException;
import classy.classyapp.BackendApi.globalResponse.BadRequestExceptionResponse;
import classy.classyapp.BackendApi.globalResponse.InternalServerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionResponse> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(BadRequestExceptionResponse.builder()
                        .message(ex.getMessage())
                        .build());
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<InternalServerErrorResponse> handleInternalServerErrorResponse(InternalServerError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(InternalServerErrorResponse.builder()
                        .message(ex.getMessage())
                        .build());
    }
}
