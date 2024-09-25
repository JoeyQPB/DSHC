package com.joey.DSHC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> handleRootRequest() {
        return ResponseEntity.ok().build();
    }
}

