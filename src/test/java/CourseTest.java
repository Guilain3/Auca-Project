import com.auca.ac.rw.controller.CourseController;
import com.auca.ac.rw.model.Course;
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.Semester;
import com.auca.ac.rw.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

public class CourseTest {
    private final CourseController courseController = new CourseController();

    @Test
    public void testSaveCourse() {
        // Create a semester instance
        Semester semester = new Semester("Fall 2024", LocalDate.of(2024, 9, 1), LocalDate.of(2024, 12, 10), Collections.emptyList());
        semester.setId(2); 

        // Retrieve a department (AcademicUnit)
        AcademicUnit department;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           
            department = session.get(AcademicUnit.class, 5); 
            assertNotNull("Department should not be null", department); 
        }

        // Create a new course with the retrieved department
        Course course = new Course("CS103", "Linux", semester, department);
        
        String result = courseController.saveCourse(course);
        assertEquals("Course saved successfully", result);
    }

    @Test
    public void testGetCoursesByDepartmentAndSemester() {
        AcademicUnit department;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            department = session.get(AcademicUnit.class, 5); 
            assertNotNull("Department should not be null", department); 
        }

        int semesterId = 1; // Replace with a valid semester ID
        List<Course> courses = courseController.getCoursesByDepartmentAndSemester(department, semesterId);
        assertNotNull("Course list should not be null", courses); // Ensure that the list is not null
    }
}
