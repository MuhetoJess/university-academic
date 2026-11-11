package com.auca.university_academic.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "registrations", uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id", "academic_year", "semester"}))
public class Registration {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "academic_year", nullable = false)
    private String academicYear;      // e.g. "2026/2027"

    @Column(nullable = false)
    private String semester;          // e.g. "Semester 1"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERegistrationStatus status = ERegistrationStatus.PENDING;

    private Double grade;             // nullable until graded

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;
    
    // constructors, getters, setters
    public Registration() {}

    public Registration(LocalDate registrationDate, String academicYear, String semester, Student student, Course course) {
        this.registrationDate = registrationDate;
        this.academicYear = academicYear;
        this.semester = semester;
        this.student = student;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ERegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(ERegistrationStatus status) {
        this.status = status;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
