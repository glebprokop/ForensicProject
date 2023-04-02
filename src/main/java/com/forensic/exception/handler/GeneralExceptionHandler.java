package com.forensic.exception.handler;

import com.forensic.exception.ApplicationExceptionCodes;
import com.forensic.exception.ErrorMessage;
import com.forensic.exception.custom.EntityNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.forensic.exception.ApplicationExceptionCodes.DATA_NOT_FOUND_ERROR;
import static com.forensic.exception.ApplicationExceptionCodes.ERROR;
import static com.forensic.exception.ApplicationExceptionCodes.HTTP_BAD_PARAM_TYPE_ERROR;
import static com.forensic.exception.ApplicationExceptionCodes.HTTP_CLIENT_ERROR;

/**
 * Exception handler class using to work with exceptions thrown by methods of controllers. This class
 * "listen" all controller methods, catch exceptions and return the special {@link ResponseEntity} object
 * contains information about the exception <p>
 * see - {@link ApplicationExceptionCodes} class - enum contains unique application codes of errors <p>
 * see - {@link ErrorMessage} class - class used for generating application error message (with uniq UUID id,
 * error code and exception message)
 *
 */
@ControllerAdvice
public class GeneralExceptionHandler {

    private static final Logger log = Logger.getLogger(GeneralExceptionHandler.class);

    /**
     * Method for handling all non-specific exceptions. This method return the
     * "internal server error" http status (status code 500) in request
     *
     * @param e any general non-specific exception
     * @return {@link ResponseEntity} object contains the {@link ApplicationExceptionCodes} "ERROR" code
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAnyGeneralException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(e, ERROR.getCode());
        log.error(errorMessage.getErrorId() + e.getMessage(), e);

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Method for handling exceptions type of "data not found in data source". This method return the
     * "internal server error" http status (status code 500) in request
     * @param e {@link EntityNotFoundException} object usually thrown by repositories
     * @return {@link ResponseEntity} object contains the {@link ApplicationExceptionCodes} "DATA_NOT_FOUND_ERROR" code
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e, DATA_NOT_FOUND_ERROR.getCode());
        log.error(errorMessage.getErrorId() + e.getMessage(), e);

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Method for handling non-specific exceptions of http client/requests (http status code 4**)
     * @param e {@link HttpClientErrorException} object usually thrown during the incorrect client actions
     * @return {@link ResponseEntity} object contains the {@link ApplicationExceptionCodes} "HTTP_CLIENT_ERROR" code
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(HttpClientErrorException e) {
        ErrorMessage errorMessage = new ErrorMessage(e, HTTP_CLIENT_ERROR.getCode());
        log.error(errorMessage.getErrorId() + e.getMessage(), e);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method for handling exceptions of http client/requests, when client use incorrect data type in
     * request (use String instead of Integer f.e.)
     * @param e {@link MethodArgumentTypeMismatchException} object usually thrown during the incorrect request data
     * @return {@link ResponseEntity} object contains the {@link ApplicationExceptionCodes} "HTTP_BAD_PARAM_TYPE_ERROR"
     * code
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(MethodArgumentTypeMismatchException e) {
        ErrorMessage errorMessage = new ErrorMessage(e, HTTP_BAD_PARAM_TYPE_ERROR.getCode());
        log.error(errorMessage.getErrorId() + e.getMessage(), e);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
