// package com.auca.ac.rw.view;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// import com.auca.ac.rw.model.Student;

// public class StudentView {

	
// 	Student student = new Student();
	
// 	public Student setStudentNames(
// 			String firstName, String lastName,
// 			Date dateOfBirth, String address ) {
		
// 		student.setFirstName(firstName);
// 		student.setLastName(lastName);
// 		student.setDateOfBirth(dateOfBirth);
// 		return student;
// 	}
	
// 	public Student addStudent() throws ParseException {
		
		
// 		SimpleDateFormat dateformat =
// 				new SimpleDateFormat("MM-dd-YYYY");
		
// 		Date dob = dateformat.parse("12-10-2024");
// 	   return setStudentNames("Lewis",
// 			   "Dushime",dob, "Kigali");
// 	}
// 	public String getLastName(String firstName) throws ParseException 
// 	{
// 		Student student = addStudent();
// 		if(student.getFirstName().
// 				equalsIgnoreCase(firstName)) {
// 			return student.getLastName();
// 		}else {
// 			return "not found";
// 		}
// 	}
	
// }
