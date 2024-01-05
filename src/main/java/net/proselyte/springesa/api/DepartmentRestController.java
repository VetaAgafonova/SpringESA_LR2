package net.proselyte.springesa.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import net.proselyte.springesa.model.Department;
import net.proselyte.springesa.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.List;

@RestController
@RequestMapping(value = "/api/department")
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentService departmentService;
    private XmlMapper xmlMapper;

    @GetMapping(path = "/all", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> findAllDepartments(@RequestHeader("Accept") String acceptHeader) {
        List<Department> departments = departmentService.findAll();
        if (acceptHeader.equals(MediaType.APPLICATION_XML_VALUE)) {
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Source xsltSource = new StreamSource("src/main/resources/templates/departments.xslt");
                Transformer transformer = transformerFactory.newTransformer(xsltSource);
                Source xmlSource = new StreamSource(new ByteArrayInputStream(xmlMapper.writeValueAsBytes(departments)));
                StringWriter outWriter = new StringWriter();
                Result result = new StreamResult(outWriter);
                transformer.transform(xmlSource, result);
                return new ResponseEntity<>(outWriter.toString(), HttpStatus.OK);
            } catch (TransformerException | JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.ok(departments);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Department getByIdDepartment(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void createDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
    }
}

