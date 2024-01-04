package net.proselyte.springesa.service;

import net.proselyte.springesa.model.Student;
import net.proselyte.springesa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(Long id){
        return studentRepository.getOne(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
}
