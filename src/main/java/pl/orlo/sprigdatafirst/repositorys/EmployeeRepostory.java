package pl.orlo.sprigdatafirst.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.orlo.sprigdatafirst.entitys.Employee;

import java.util.List;

//public interface EmployeeRepostory extends CrudRepository<Employee, Long> {
public interface EmployeeRepostory extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

//    Iterable<Employee> findAllByFirstNameIsTrue (String firstName);
}
