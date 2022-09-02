package com.mochiliando.org.controler;

import com.mochiliando.org.model.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public Double add (@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return num1 + num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double substract (@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return num1 - num2;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply (@RequestBody CalculatorDTO calculatorDTO) {
        return new ResponseEntity<Double>(calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4()  , HttpStatus.CREATED);
    }
}
