package org.contest.course_project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groupa")
    private String group;

    @Column(name = "competition_position")
    private int competitionPosition;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Student(Long id, String group, int competitionPosition, Applicant applicant) {
        this.id = id;
        this.group = group;
        this.competitionPosition = competitionPosition;
        this.applicant = applicant;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCompetitionPosition() {
        return competitionPosition;
    }

    public void setCompetitionPosition(int competitionPosition) {
        this.competitionPosition = competitionPosition;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
    @Override
    public String toString() {
        return id.toString();
    }
}
