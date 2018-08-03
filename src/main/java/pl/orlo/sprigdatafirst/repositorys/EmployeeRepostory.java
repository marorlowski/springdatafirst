package pl.orlo.sprigdatafirst.repositorys;

import org.springframework.data.repository.CrudRepository;
import pl.orlo.sprigdatafirst.entitys.Employee;

public interface EmployeeRepostory extends CrudRepository<Employee, Long> {
    Iterable<Employee> findByFirstName(String firstName);
}
