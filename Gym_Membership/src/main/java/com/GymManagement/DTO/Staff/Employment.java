package com.GymManagement.DTO.Staff;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employment")
public class Employment {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employment_id", nullable = false)
    private Integer employmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(name = "start_date")
    private LocalDate empStartDate;

    @Column(name = "end_date")
    private LocalDate empEndDate;

    @Column(name = "hourly_rate", precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    //GETTER METHODS
    public Integer getEmpId() {
        return employmentId;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public Staff getStaff() {
        return staff;
    }

    public LocalDate getEmpStartDate() {
        return empStartDate;
    }

    public LocalDate getEmpEndDate() {
        return empEndDate;
    }

    //SETTER METHODS
    public void setEmpId(Integer employmentId) {
        this.employmentId = employmentId;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setEmpStartDate(LocalDate empStartDate) {
        this.empStartDate = empStartDate;
    }

    public void setEmpEndDate(LocalDate empEndDate) {
        this.empEndDate = empEndDate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

}