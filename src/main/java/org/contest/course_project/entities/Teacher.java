package org.contest.course_project.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private Set<Exam> exams;

    public Teacher(Long id, String fullName, String phoneNumber, Set<Exam> exams) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.exams = exams;
    }

    public Teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
    @Override
    public String toString() {
        return id.toString();
    }
}
