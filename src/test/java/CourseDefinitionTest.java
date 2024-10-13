import com.auca.ac.rw.controller.CourseDefinitionController;
import com.auca.ac.rw.controller.SemesterController;
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.Course;
import com.auca.ac.rw.model.CourseDefinition;
import com.auca.ac.rw.model.Semester;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

import org.hibernate.Session;
import com.auca.ac.rw.util.HibernateUtil;

public class CourseDefinitionTest {
    private final CourseDefinitionController courseDefinitionController = new CourseDefinitionController();
    private final SemesterController semesterController = new SemesterController();

    @Test
    public void testSaveCourseDefinition() {
        // Create and save a semester
        Semester semester = new Semester("Fall 2024", LocalDate.of(2024, 9, 1), LocalDate.of(2024, 12, 10), null);
        semesterController.saveSemester(semester); 

        AcademicUnit academicUnit;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            academicUnit = session.get(AcademicUnit.class, 2); 
        }

        // Create a course associated with the semester and academic unit
        Course course = new Course("CS103", "Linux", semester, academicUnit);
        
        // Create a course definition
        CourseDefinition courseDefinition = new CourseDefinition("DEF101", "This course covers the basics of Linux.", course);

        // Save the course definition
        String result = courseDefinitionController.saveCourseDefinition(courseDefinition);
        
        assertEquals("Course Definition saved successfully", result);
    }
}
