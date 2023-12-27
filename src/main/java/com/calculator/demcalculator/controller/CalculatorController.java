package com.calculator.demcalculator.controller;

import com.calculator.demcalculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/calculator")
    public String hello() {
        return "Добро пожаловать";
    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан";
        }
        return num1 + "+" + num2 + "=" + service.plus(num1, num2);
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан";
        }
        return num1 + "-" + num2 + "=" + service.minus(num1, num2);
    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false)Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан";
        }
        return num1 + "*" + num2 + "=" + service.multiply(num1, num2);
    }

    @GetMapping("/calculator/division")
    public String division(@RequestParam(required = false) Integer num1, @RequestParam(required = false)Integer num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        return num1 + "/" + num2 + "=" + service.division(num1, num2);
    }
}

