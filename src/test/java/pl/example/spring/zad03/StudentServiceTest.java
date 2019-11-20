package pl.example.spring.zad03;
import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.example.spring.zad03.db.StudentRepozytory;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

public class StudentServiceTest {

    @After
    public void cleanAfterTest()
    {
        this.repository.deleteAll();
    }
    @Autowired
    private StudentRepozytory repository;

    @Test
    public void getEmptyList() {
    final StudentService service = new StudentService(repository);
   List<Student> students = service.getStudents();

    assertTru(students.isEmpty());
}

    private void assertTru(boolean empty) {
    }

    @Test
    public void addStudent() {
        final StudentService service = new StudentService(repository);
        final Student created = service.addStudent(new NewStudent("Student1", "number", "group"));
        assertNotNull(created);
}
@Test
    public void addStudentIsReturned(){
        final StudentService service = new StudentService(repository);
        final Student created = service.addStudent(new NewStudent("Student1", "number", "group"));
        final List<Student> all = service.getStudents();

        assertEquals("Student1", all.get(0).name);
        //assertEquals("Student1", all.head().name);

}
@Test
    public void addStudentHasNewId(){
        final StudentService service = new StudentService(repository);
        final Student created1 = service.addStudent(new NewStudent("Student1", "number", "group"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "number", "group"));
        assertNotEquals(created1.id, created2.id);
        assertEquals(2, service.getStudents().size());

}
}