import com.auca.ac.rw.controller.AssistantController;
import com.auca.ac.rw.model.Assistant;
import com.auca.ac.rw.model.QualificationEnum;
import com.auca.ac.rw.model.Teacher;
import com.auca.ac.rw.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AssistantTest {
    private final AssistantController assistantController = new AssistantController();
    private Teacher testTeacher;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        // Create and persist a Teacher object
        testTeacher = new Teacher("John", "Kamanzi", QualificationEnum.MASTER, null); 
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(testTeacher);
            session.getTransaction().commit();
        }
    }

    @Test
    public void testSaveAssistant() {
        // Create a new assistant
        Assistant assistant = new Assistant("Alice", "Smith");
        assistant.setTeacher(testTeacher); 

        // Save the assistant
        String result = assistantController.saveAssistant(assistant);
        assertEquals("Assistant saved successfully", result);
    }

   
}
