package com.auca.university_academic.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "departments")
public class Department {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    
    @Column(nullable = false, unique = true)
    private String code;

    // Head of department: 1:1, FK lives here
    @OneToOne
    @JoinColumn(name = "head_id")
    private Lecturer head;

    @OneToMany(mappedBy = "department")
    private List<Lecturer> lecturers = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();
    
    //constructors,getters, setters
    public Department(String code, Lecturer head, UUID id, String name) {
        this.code = code;
        this.head = head;
        this.id = id;
        this.name = name;
    }
    
    public Department() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Lecturer getHead() {
        return head;
    }

    public void setHead(Lecturer head) {
        this.head = head;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

      


}
