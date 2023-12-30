package in.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.student.dao.IStudentDao;
import in.student.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	
	@Autowired
	private IStudentDao repo;
	
	
	@Override
	public List<Student> getAllStudents() {
		
		Iterable<Student> studentList = repo.findAll();
		
		return (List<Student>) studentList;
	}


	@Override
	public void saveStudentDetails(Student student) {

			repo.save(student);
		
	}


	@Override
	public Student getStudentDetailsById(Integer studentId) {
		
		Optional<Student> studentDetails = repo.findById(studentId);
		
		return studentDetails.get() ;
	}


	@Override
	public void deleteStudentById(Integer studentId) {
		
		repo.deleteById(studentId);
		
	}

}
