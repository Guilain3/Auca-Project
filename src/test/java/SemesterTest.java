import com.auca.ac.rw.controller.SemesterController;
import com.auca.ac.rw.model.Semester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.Collections;

public class SemesterTest {
    private final SemesterController semesterController = new SemesterController();

    @Test
    public void testSaveSemester() {
        Semester semester = new Semester(
                "Summer 2023",
                LocalDate.of(2023,9, 1),
                LocalDate.of(2023, 12, 10),
                Collections.emptyList()
        );

        String result = semesterController.saveSemester(semester);
        assertEquals("Semester saved successfully", result);
    }
}
