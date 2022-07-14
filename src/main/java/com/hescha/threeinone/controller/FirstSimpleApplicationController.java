package com.hescha.threeinone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first1")
public class FirstSimpleApplicationController {

    @GetMapping("/sum")
    public ResponseEntity<Double> sum(@RequestParam Double firstNumber,
                                      @RequestParam Double secondNumber) {
        return ResponseEntity.ok(firstNumber + secondNumber);
    }

    @GetMapping("/difference")
    public ResponseEntity<Double> difference(@RequestParam Double firstNumber,
                                             @RequestParam Double secondNumber) {
        return ResponseEntity.ok(firstNumber - secondNumber);
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestParam Double firstNumber,
                                           @RequestParam Double secondNumber) {
        return ResponseEntity.ok(firstNumber * secondNumber);
    }
}
