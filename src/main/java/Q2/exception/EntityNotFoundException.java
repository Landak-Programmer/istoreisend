package Q2.exception;

import java.io.Serializable;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final Serializable id) {
        super(String.format("Id %s is not found", id));
    }
}
