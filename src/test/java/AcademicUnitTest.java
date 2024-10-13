import com.auca.ac.rw.controller.AcademicUnitController;
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.AcademicUnitEnum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AcademicUnitTest {
    private final AcademicUnitController academicUnitController = new AcademicUnitController();

    @Test
    public void testSaveHierarchicalAcademicUnits() {
        AcademicUnit faculty = new AcademicUnit(101L, "Information Technology", AcademicUnitEnum.Faculty, null);
        String facultyResult = academicUnitController.saveAcademicUnits(faculty);
        assertEquals("Academic Units saved successfully", facultyResult);

        AcademicUnit department = new AcademicUnit(203L, "Information Management", AcademicUnitEnum.Department, faculty.getAcademicId());
        String departmentResult = academicUnitController.saveAcademicUnits(department);
        assertEquals("Academic Units saved successfully", departmentResult);

        AcademicUnit programme = new AcademicUnit(301L, "Bachelors Programme", AcademicUnitEnum.Programme, department.getAcademicId());
        String programmeResult = academicUnitController.saveAcademicUnits(programme);
        assertEquals("Academic Units saved successfully", programmeResult);
    }
}
