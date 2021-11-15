package kz.alfabank.integration.telegrambotbirthday.controller;

import kz.alfabank.integration.telegrambotbirthday.model.Employees;
import kz.alfabank.integration.telegrambotbirthday.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeesService dayService;

    @GetMapping(value = "/test")
    public List<Employees> getName(@RequestParam(name="month")Integer month,@RequestParam(name = "day") Integer day){
        return dayService.getAll(month,day);
    }
}
