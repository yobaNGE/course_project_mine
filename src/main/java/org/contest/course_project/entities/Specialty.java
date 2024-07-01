package org.contest.course_project.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "passing_score")
    private int passingScore;

    @Column(name = "seats")
    private int seats;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "specialty")
    private Set<Discipline> disciplines;

    @OneToMany(mappedBy = "specialty")
    private Set<Applicant> applicants;

    public Specialty(Long id, int number, int passingScore, int seats, String name, Set<Discipline> disciplines, Set<Applicant> applicants) {
        this.id = id;
        this.number = number;
        this.passingScore = passingScore;
        this.seats = seats;
        this.name = name;
        this.disciplines = disciplines;
        this.applicants = applicants;
    }

    public Specialty() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(int passingScore) {
        this.passingScore = passingScore;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }
    @Override
    public String toString() {
        return id.toString();
    }
}
