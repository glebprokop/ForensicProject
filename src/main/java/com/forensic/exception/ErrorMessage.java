package com.forensic.exception;

import com.forensic.util.uuidgen.UUIDGeneratorInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

/**
 * Class used for generate custom error description with unique UUID id and {@link ApplicationExceptionCodes} error
 * status code
 */
@Data
@AllArgsConstructor
@Builder
public class ErrorMessage implements UUIDGeneratorInterface {

    private String errorId;

    private Integer errorCode;

    private String errorMessage;

    public ErrorMessage(Exception e, Integer errorCode){
        this.errorId = generateUUID();
        this.errorCode = errorCode;
        this.errorMessage = e.getMessage();
    }
}
