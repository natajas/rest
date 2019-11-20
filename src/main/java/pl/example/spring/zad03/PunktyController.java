package pl.example.spring.zad03;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")

public class PunktyController
{
    private final StudentService service;
   /* private static CopyOnWriteArrayList
            <String> students = new CopyOnWriteArrayList<>(new String[]{
            "Student 1",
            "Student 2",
            "Student 3",
            "Jan B",
            "Max C",
            "Alex D"
    });*/

    //private StudentService service=new StudentService(repository);

    public PunktyController(StudentService service)
    {
        this.service = service;

    }

    private CopyOnWriteArrayList<String> users= new CopyOnWriteArrayList<>();
    {
        this.users.addAll(Arrays.asList("Student1","Student2","Student3","Student4","Student5"));
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)//produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
       // return students;
        return service.getStudents().asJava();
    }

    @PostMapping( value ="/students/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Student addUser(@RequestBody NewStudent student){

        return service.addStudent(student);
    }}


   /* @PutMapping(path = "/students/users/{id}", consumes = "application/json", produces = "application/json")

    public boolean modifyStudent(@RequestBody String name, @PathVariable int id){

        return !students.set(id, name).equals(name);
    }

    @DeleteMapping(path = "/students/users/{id}")

    public String modifyStudent(@PathVariable int id)
    {
        return students.remove(id);
    }
}*/