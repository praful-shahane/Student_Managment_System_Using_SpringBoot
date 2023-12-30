package in.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.student.model.Student;
import in.student.service.IStudentService;

@Controller
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private IStudentService service;
	
	 /*
	 * To get all students data from Database and show on UI Side.
	 */
	
	@GetMapping("/getallstudents")
	public String showStudentList(Map<String, Object> model) {
		
		List<Student> allStudents = service.getAllStudents();
		model.put("allStudents", allStudents);
		System.out.println(allStudents);
		return "students/student-list";
	}
	
	@GetMapping("/showFormForStudent")
	public String showStudentForm(Map<String, Object> model) {
		/*
		 * 
		 * When user Click on Add Student Button,
		 * Student Form will be Open.
		 * we show dummy data of Student. 
		 * 
		 */
		
		Student student = new Student();
		model.put("student", student);
		System.out.println(student);
		return "students/student-form";
	}
	
	
	@PostMapping("/saveStudent")
	public String saveStudentFormInfo(@ModelAttribute("student") Student student) {
		
		 System.out.println(student);
		/*
		 * if we click on add student it will save as new  data.
		 * but if click on Update, it will update the record.
		 */
		service.saveStudentDetails(student);
		/*
		 * After we save/Update data, it will redirect to  getallstudents url mapping,
		 * i.e we get getallstudents() method will be executed.
		 */
		
		return "redirect:/api/student/getallstudents";
	}
	
	
	@PostMapping("/showFormForUpdate")
	public String updateStudentDetails(@RequestParam Integer studentId,Map<String, Object> model) {
		/*
		 * when we click on update, 
		 * according to studentid our data which is stored previously 
		 *  will be displayed on Ui side.
		 * 
		 */
		System.out.println(studentId);
		Student student = service.getStudentDetailsById(studentId);
		model.put("student", student);
		
		return "students/student-form";
		
	}
	
	@PostMapping("/showFormForDelete")
	public String deleteStudentDetails(@RequestParam Integer studentId,Map<String, Object> model) {
		
		/*
		 * when user click on delete button, it will delete record of student
		 * according to their id.
		 */
		service.deleteStudentById(studentId);
		return "redirect:/api/student/getallstudents";
	}
	
	
	
	
	
}
