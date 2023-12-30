package in.student.service;

import java.util.List;

import in.student.model.Student;

public interface IStudentService {

	public List<Student>  getAllStudents();
	
	public   void    saveStudentDetails(Student student);
	
	public Student getStudentDetailsById(Integer studentId);
	
	public void deleteStudentById(Integer studentId);
}
