package pl.orlo.sprigdatafirst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import pl.orlo.sprigdatafirst.entitys.Employee;
import pl.orlo.sprigdatafirst.repositorys.DzialRepository;
import pl.orlo.sprigdatafirst.repositorys.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;
    private final EmployeeGenerator employeeGenerator;
    private final Logger logger = LoggerFactory.getLogger(RunAtStart.class);
    private final DzialRepository dzialRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository, EmployeeGenerator employeeGenerator, DzialRepository dzialRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeGenerator = employeeGenerator;
        this.dzialRepository = dzialRepository;
    }

    @PostConstruct
    public void runAtStart() {
//        generowanie pracowników
//        for (int i = 0; i < 100; i++) {
//            employeeRepository.save(employeeGenerator.generate());
//        }

//        List<Employee> sortedByFirstName = employeeRepository.findAll(new Sort(Sort.Direction.ASC, "firstName"));

//        logger.info("UNSORTED");
//        printAll(findAllUnsorted());
//
//        logger.info("SORTED BY FIRST NAME");
//        printAll(getSortedByFirstName());
//
//        logger.info("SORTED BY FIRST NAME AND LAST NAME");
//        printAll(getSortedByFirstNameAndLastName());
//
//        Page<Employee> page = employeeRepository.findAll(new PageRequest(2, 10));
//        logger.info("TOTAL NUMBER OF EMPLOYEES" + page.getTotalElements());
//        logger.info("TOTAL NUMBER OF PAGES" + page.getTotalPages());
//        logger.info("ELEMENTS ON PAGE: ");
//        printAll(page.getContent());
//
//        logger.info("Start Dział");
//        dzialRepository.findAll().forEach(dzial -> logger.info(String.valueOf(dzial)));

        printAll(employeeRepository.findBySalaryBetween(new BigDecimal("1000"), new BigDecimal("2000")));
    }

    private List<Employee> getSortedByFirstNameAndLastName() {
        return employeeRepository.findAll(
                new Sort(
                        new Sort.Order(
                                Sort.Direction.ASC, "firstName"
                        ),
                        new Sort.Order(
                                Sort.Direction.ASC, "lastName"
                        )));
    }

    private List<Employee> getSortedByFirstName() {
        return employeeRepository.findAll(
                new Sort(
                        Sort.Direction.ASC, "firstName"
                )
        );
    }

    private List<Employee> findAllUnsorted() {
        return employeeRepository.findAll();
    }

    private void printAll(List<Employee> allUsorted) {
        allUsorted.forEach((employee) -> logger.info(String.valueOf(employee)));
    }
}
