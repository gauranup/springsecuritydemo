package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String greet()
    {
        return "hello everyone";
    }

    //doctor
    @GetMapping("/doctor/details")
    public String doctorAPI()
    {
        return "hello doctor";
    }

    // deo
    @GetMapping("/deo/details")
    public String deoAPI()
    {
        return "hello data entry operator";
    }

    //ceo
    @GetMapping("/ceo/details")
    public String ceoAPI()
    {
        return "hello ceo";
    }

    //either doc or deo
    @GetMapping("/schedule/appointments")
    public String scheduleAppointment()
    {
        return "Hi!! your appointment is scheduled!!";
    }



}
