package pl.orlo.sprigdatafirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.orlo.sprigdatafirst.entitys.Employee;
import pl.orlo.sprigdatafirst.repositorys.EmployeeRepostory;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class RunAtStart {
    private final EmployeeRepostory employeeRepostory;

    @Autowired
    public RunAtStart(EmployeeRepostory employeeRepostory) {
        this.employeeRepostory = employeeRepostory;
    }

    @PostConstruct
    public void runAtStart(){
        Employee employee = new Employee();
        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(new BigDecimal("3000.0"));

        employeeRepostory.save(employee);

        Iterable<Employee> jans = employeeRepostory.findByFirstName("Jan");
        Employee jan = jans.iterator().next();
        System.out.println("Janek: "+ jan);

    }
}
