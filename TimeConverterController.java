package com.example.time;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class TimeConverterController {

    @Autowired
    private ITimeConverterService timeConverterService;

    @GetMapping("/convertedTime")
    public String getTimeInWords(@RequestParam String time) {
        try {
            String timeInWords = timeConverterService.convertToWords(time);
            return "It's " + timeInWords;
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}

