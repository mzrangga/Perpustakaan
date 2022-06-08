package com.perpustakaan.Perpustakaan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFound extends ResponseStatusException {
    public EntityNotFound(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}

