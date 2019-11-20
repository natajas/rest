package pl.example.spring.zad03.db;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepozytory extends CrudRepository <StudentRow,Long>
{
}
