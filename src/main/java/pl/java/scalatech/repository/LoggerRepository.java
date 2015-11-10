package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.UnExpectedException;

public interface LoggerRepository extends JpaRepository<UnExpectedException, Long>{

}
