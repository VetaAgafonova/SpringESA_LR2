package net.proselyte.springesa.controller;

import net.proselyte.springesa.model.Student;
import net.proselyte.springesa.service.DepartmentService;
import net.proselyte.springesa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final DepartmentService departmentService;

    @Autowired
    public StudentController(StudentService studentService, DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    @GetMapping("/students")
    public String findAll(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/student-create")
    public String createStudentForm(Student student, Model model){
        model.addAttribute("departments", departmentService.findAll());
        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("student-delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/student-update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("departments", departmentService.findAll());
        return "student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
