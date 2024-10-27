package org.glofox.Exception;

import org.apache.coyote.BadRequestException;

public class ClassesNotFoundException extends BadRequestException {
    public ClassesNotFoundException(String message) {
        super(message);
    }
}
