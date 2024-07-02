package org.contest.course_project.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "exam_result")
    private int examResult;

    @Column(name = "exam_time")
    private String examTime;

    @Column(name = "minimum_score")
    private int minimumScore;

    @OneToMany(mappedBy = "exam" )
    private Set<Applicant> applicants;

    public Exam(Long id, Discipline discipline, Teacher teacher, int examResult, String examTime, int minimumScore, Set<Applicant> applicants) {
        this.id = id;
        this.discipline = discipline;
        this.teacher = teacher;
        this.examResult = examResult;
        this.examTime = examTime;
        this.minimumScore = minimumScore;
        this.applicants = applicants;
    }

    public Exam() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getExamResult() {
        return examResult;
    }

    public void setExamResult(int examResult) {
        this.examResult = examResult;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public int getMinimumScore() {
        return minimumScore;
    }

    public void setMinimumScore(int minimumScore) {
        this.minimumScore = minimumScore;
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }
    @Override
    public String toString() {
        return discipline.getName();
    }
}
