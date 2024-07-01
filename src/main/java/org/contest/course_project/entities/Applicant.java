package org.contest.course_project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gold_medal")
    private Boolean goldMedal;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Column(name = "score")
    private int score;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "admission_committee_id")
    private AdmissionCommittee admissionCommittee;

    public Applicant(Long id, Boolean goldMedal, Specialty specialty, int score, String fullName, Exam exam, AdmissionCommittee admissionCommittee) {
        this.id = id;
        this.goldMedal = goldMedal;
        this.specialty = specialty;
        this.score = score;
        this.fullName = fullName;
        this.exam = exam;
        this.admissionCommittee = admissionCommittee;
    }

    public Applicant() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getGoldMedal() {
        return goldMedal;
    }

    public void setGoldMedal(Boolean goldMedal) {
        this.goldMedal = goldMedal;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public AdmissionCommittee getAdmissionCommittee() {
        return admissionCommittee;
    }

    public void setAdmissionCommittee(AdmissionCommittee admissionCommittee) {
        this.admissionCommittee = admissionCommittee;
    }
    @Override
    public String toString() {
        return id.toString();
    }
}
