package in.student.dao;

import org.springframework.data.repository.CrudRepository;

import in.student.model.Student;

public interface IStudentDao extends CrudRepository<Student, Integer> {

}
