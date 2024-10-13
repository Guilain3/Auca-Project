import com.auca.ac.rw.controller.TeacherController;
import com.auca.ac.rw.model.Teacher;
import com.auca.ac.rw.model.QualificationEnum;
import com.auca.ac.rw.model.Course; 
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.util.HibernateUtil;

import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TeacherTest {
    private final TeacherController teacherController = new TeacherController();

    @SuppressWarnings("deprecation")
    @Test
    public void testSaveTeacher() {
       
        Course course;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(Course.class, "CS103"); 
            if (course == null) {
                
                AcademicUnit academicUnit = session.get(AcademicUnit.class, 2); 
                course = new Course("CS103", "Linux", null, academicUnit);
                session.beginTransaction();
                session.save(course);
                session.getTransaction().commit();
            }
        }

        // Create a teacher object
        Teacher teacher = new Teacher("John", "Kamanzi", QualificationEnum.MASTER, course);

        // Save the teacher
        String result = teacherController.saveTeacher(teacher);
        assertEquals("Teacher saved successfully", result);
    }
}
