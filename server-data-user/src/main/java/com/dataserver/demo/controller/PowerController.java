package com.dataserver.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerController {

    @Value("${paramone}")
    String configname;
}
