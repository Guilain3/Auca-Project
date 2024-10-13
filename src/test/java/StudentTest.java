import com.auca.ac.rw.controller.StudentController;
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.Course;
import com.auca.ac.rw.model.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudentTest {
    private final StudentController studentController = new StudentController();
    private AcademicUnit department;

    @Before
    public void setUp() {
        department = new AcademicUnit();
        department.setAcademicId(2L); 
    }

    @Test
    public void testSaveStudent() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2008, Calendar.OCTOBER, 20);
        Date dateOfBirth = calendar.getTime();
        
        Student student = new Student("Nestor", "Musa", dateOfBirth);

        String result = studentController.saveStudent(student);
        assertEquals("Student saved successfully", result);
    }

    @Test
    public void testGetStudentsBySemester() {
        int semesterId = 1;

        List<Student> students = studentController.getStudentsBySemester(semesterId);
        assertNotNull(students);
    }

    @Test
    public void testGetCoursesByStudent() {
        int studentId = 1;
        
        List<Course> courses = studentController.getCoursesByStudent(studentId);
        assertNotNull(courses);
    }

    // @Test
    // public void testGetStudentsByDepartmentAndSemester() {
    //     int semesterId = 3;
    
    //     List<Student> students = studentController.getStudentsByDepartmentAndSemester(department, semesterId);
    //     assertNotNull(students);
    // }
}
