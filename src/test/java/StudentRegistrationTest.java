import com.auca.ac.rw.controller.StudentRegistrationController;
import com.auca.ac.rw.model.StudentRegistration;
import com.auca.ac.rw.util.HibernateUtil;
import com.auca.ac.rw.model.Student;
import com.auca.ac.rw.model.Semester;
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.AcademicUnitEnum;
import com.auca.ac.rw.model.Course;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StudentRegistrationTest {
    private final StudentRegistrationController studentRegistrationController = new StudentRegistrationController();
    private Semester testSemester;
    private Student testStudent;
    private Course testCourse;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        // Create and persist a Semester object
        testSemester = new Semester("Fall 2024", LocalDate.of(2024, 9, 1), LocalDate.of(2024, 12, 10), null);
        
        // Create and persist a Student object
        testStudent = new Student("Guilaine", "Ndahiro", new java.util.Date(2008 - 1900, 10 - 1, 20));
        
        
        AcademicUnit academicUnit;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            academicUnit = session.get(AcademicUnit.class, 2); 
        }

        // Create and persist a Course object associated with the AcademicUnit
        testCourse = new Course("CS103", "Linux", testSemester, academicUnit);
        
        // Save to database (Assuming a method to do this)
        saveToDatabase(testSemester);
        saveToDatabase(testStudent);
        saveToDatabase(testCourse);
    }

    @Test
    public void testSaveStudentRegistration() {
        // Create a set of courses and add the test course
        Set<Course> courses = new HashSet<>();
        courses.add(testCourse);

        // Create registration details
        String registrationCode = "REG2024-001";
        Timestamp registrationDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());

        // Create StudentRegistration object
        StudentRegistration studentRegistration = new StudentRegistration(
                registrationCode, 
                registrationDate, 
                testStudent, 
                testSemester, 
                AcademicUnitEnum.Department 
        );
        studentRegistration.setCourses(courses);

        // Save the registration and assert the result
        String result = studentRegistrationController.saveStudentRegistration(studentRegistration);
        assertEquals("Student Registration saved successfully", result);
    }

    
    @SuppressWarnings("deprecation")
    private void saveToDatabase(Object entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
    }
}
