package pl.orlo.sprigdatafirst.repositorys;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import pl.orlo.sprigdatafirst.entitys.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameByIgnoreCase(String firstName);

    List<Employee> findBySalaryBetween(BigDecimal salary1, BigDecimal salary2);

    @Async
    CompletableFuture<Employee> findByFirstByFirstNameIgnoreCase(String firstName);


}
