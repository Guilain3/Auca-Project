package com.auca.ac.rw.model;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @Column(name = "course_code", length = 50)
    private String courseCode;

    @Column(name = "course_name", length = 50)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

    @OneToOne(mappedBy = "course")
    private CourseDefinition courseDefinition;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentRegistration> registrations;

    // Constructors
    public Course() {}

    public Course(String courseCode, String courseName, Semester semester, AcademicUnit department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.department = department;
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

   
    public AcademicUnit getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit department) {
        this.department = department;
    }

    public CourseDefinition getCourseDefinition() {
        return courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public Set<StudentRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<StudentRegistration> registrations) {
        this.registrations = registrations;
    }
}
