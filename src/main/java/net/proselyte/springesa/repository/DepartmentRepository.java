package net.proselyte.springesa.repository;

import net.proselyte.springesa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
