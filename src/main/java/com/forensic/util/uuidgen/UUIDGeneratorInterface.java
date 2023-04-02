package com.forensic.util.uuidgen;

import java.util.UUID;

/**
 * Interface for UUID generators class. Has default realisation of getting the UUID
 */
public interface UUIDGeneratorInterface {

    /**
     * Method for generating the UUID
     *
     * @return string contains the uniq UUID
     */
    default String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
