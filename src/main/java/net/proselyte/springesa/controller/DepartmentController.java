package net.proselyte.springesa.controller;

import net.proselyte.springesa.model.Department;
import net.proselyte.springesa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String findAll(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "department-list";
    }

    @GetMapping("/department-create")
    public String createDepartmentForm(Department department){
        return "department-create";
    }

    @PostMapping("/department-create")
    public String createDepartment(Department department){
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("department-delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteById(id);
        return "redirect:/departments";
    }

    @GetMapping("/department-update/{id}")
    public String updateDepartmentForm(@PathVariable("id") Long id, Model model){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "department-update";
    }

    @PostMapping("/department-update")
    public String updateDepartment(Department department){
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }
}
