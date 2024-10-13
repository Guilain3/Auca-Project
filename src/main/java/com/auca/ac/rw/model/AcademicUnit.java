package com.auca.ac.rw.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Academic_unit")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Academic_id")
    private Long academicId;

    @Column(name = "academic_code")
    private Long academicCode;

    @Column(name = "academic_name")
    private String academicName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AcademicUnitEnum type;

    @Column(name = "parent_id", nullable = true)
    private Long parentId;

    public AcademicUnit() {
    }

    public AcademicUnit(Long academicCode, String academicName, AcademicUnitEnum type, Long parentId) {
        this.academicCode = academicCode;
        this.academicName = academicName;
        this.type = type;
        this.parentId = parentId;
    }

    public Long getAcademicCode() {
        return academicCode;
    }

    public void setAcademicCode(Long academicCode) {
        this.academicCode = academicCode;
    }

    public Long getAcademicId() {
        return academicId;
    }

    public void setAcademicId(Long academicId) {
        this.academicId = academicId;
    }

    public String getAcademicName() {
        return academicName;
    }

    public void setAcademicName(String academicName) {
        this.academicName = academicName;
    }

    public AcademicUnitEnum getType() {
        return type;
    }

    public void setType(AcademicUnitEnum type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
