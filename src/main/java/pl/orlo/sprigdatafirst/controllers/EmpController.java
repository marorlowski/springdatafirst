package pl.orlo.sprigdatafirst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.orlo.sprigdatafirst.entitys.Employee;
import pl.orlo.sprigdatafirst.repositorys.EmployeeRepository;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpController {

//    private final EmployeeRepository employeeRepository;
//
//
//    @Autowired
//    public EmpController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }


    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/greeting")
    public String index(){
        return "Spring boot działa";
    }

//    @RequestMapping(value="/all", method = RequestMethod.POST)
//    public @ResponseBody List<Employee> getAllEmpl (@RequestBody List<Employee> jsonString){
//        List<Employee> allEmplList = new ArrayList<>();
//        allEmplList=employeeRepository.findAll();
//
//        return allEmplList;
//    }

    @GetMapping(value = "/empl", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAll(){
        List<Employee> list = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(list::add);
        return list;
    }





}