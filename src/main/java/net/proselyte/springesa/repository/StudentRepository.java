package net.proselyte.springesa.repository;

import net.proselyte.springesa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
