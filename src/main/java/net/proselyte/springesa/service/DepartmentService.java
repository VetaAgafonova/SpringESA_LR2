package net.proselyte.springesa.service;

import net.proselyte.springesa.model.Department;
import net.proselyte.springesa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department findById(Long id){
        return departmentRepository.getOne(id);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public void deleteById(Long id){
        departmentRepository.deleteById(id);
    }
}