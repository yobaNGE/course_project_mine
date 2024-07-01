package org.contest.course_project.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "admission_committee")
public class AdmissionCommittee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "admission_year")
    private int admissionYear;

    @OneToMany(mappedBy = "admissionCommittee")
    private Set<Applicant> applicants;

    public AdmissionCommittee(Long id, String address, int admissionYear, Set<Applicant> applicants) {
        this.id = id;
        this.address = address;
        this.admissionYear = admissionYear;
        this.applicants = applicants;
    }

    public AdmissionCommittee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
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
