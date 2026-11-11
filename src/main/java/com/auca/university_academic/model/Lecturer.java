package com.auca.university_academic.model;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // M:N with Course: Lecturer owns the join table
    @ManyToMany
    @JoinTable(name = "lecturer_courses", joinColumns = @JoinColumn(name = "lecturer_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    // constructors, getters, setters
    public Lecturer() {}

    public Lecturer(UUID id, String fullName, String email, Department department, Set<Course> courses) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.courses = courses;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    
}
