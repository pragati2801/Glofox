package org.glofox.Exception;

import org.apache.coyote.BadRequestException;

public class UserNotFoundException extends BadRequestException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
