package org.contest.course_project.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @OneToMany(mappedBy = "discipline")
    private Set<Exam> exams;

    public Discipline(Long id, String name, Specialty specialty, Set<Exam> exams) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.exams = exams;
    }

    public Discipline() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
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
