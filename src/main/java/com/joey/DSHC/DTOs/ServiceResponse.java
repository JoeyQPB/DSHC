package com.joey.DSHC.DTOs;

import org.springframework.http.HttpStatus;

public record ServiceResponse<E> (HttpStatus httpStatus, E body) {
}
