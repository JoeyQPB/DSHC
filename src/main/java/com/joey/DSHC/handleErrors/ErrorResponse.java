package com.joey.DSHC.handleErrors;

import org.springframework.http.HttpStatus;

public record ErrorResponse<E> (HttpStatus httpStatus, E body) {
}
