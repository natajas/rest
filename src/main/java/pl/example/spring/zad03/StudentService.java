package pl.example.spring.zad03;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.example.spring.zad03.db.StudentRepozytory;
import pl.example.spring.zad03.db.StudentRow;

import java.util.function.Function;


@Service
public class StudentService   //<StudentRepository> {
    //private List<Student> students = List.empty();
{
    private final StudentRepozytory repository;

    public StudentService(StudentRepozytory repository) {
        this.repository = repository;
    }


    List<Student> getStudents() {
        this.repository.findAll();
        return   List.ofAll(this.repository.findAll())
                .map(getStudentRowStudentFunction()
                );
    }

    private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj->
                new Student(
                        dbObj.getId(),
                        dbObj.getName(),
                        dbObj.getNumber(),
                        dbObj.getGroup() );
    }

    Student addStudent(final NewStudent newStudent) {
        //Student created = new Student(students.size() +1, newStudent.name, newStudent.number, newStudent.group);
        //students = students.prepend(created);
        //return created;

        StudentRow created= this.repository.save(new StudentRow(
                newStudent.name,
                newStudent.number,
                newStudent.group
        ));

        return getStudentRowStudentFunction().apply(created);



        //throw new UnsupportedOperationException();

    }
}

    // private <R> void getStudentRowStudentFunction() {

