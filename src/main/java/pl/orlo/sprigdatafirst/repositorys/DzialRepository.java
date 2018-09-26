package pl.orlo.sprigdatafirst.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.orlo.sprigdatafirst.entitys.Dzial;

import java.util.List;

public interface DzialRepository extends JpaRepository<Dzial, Long> {
}
