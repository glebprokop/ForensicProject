package com.forensic.exception;

/**
 * Special exception used in validation of {@link com.forensic.repository.CRUDRepository} implemented classes.
 * We can throw this exception in case then our repository can`t find the entity in datasource
 *
 */
public class EntityNotFoundException extends RuntimeException{

    /**
     * Main constructor class used for throwing new exception.
     *
     * @param message String message used for info about exception
     * @param err the fundamental reason of exception
     */
    public EntityNotFoundException(String message, Throwable err) {
        super(message, err);
    }
}