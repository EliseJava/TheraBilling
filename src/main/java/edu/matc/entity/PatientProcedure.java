package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Patient procedures.
 */
@Entity(name = "PatientProcedures")
@Table(name = "patientprocedure")
public class PatientProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name ="native", strategy = "native")
    private int id;

    @OneToOne
    @JoinColumn(name = "procedure_id",
            foreignKey = @ForeignKey(name = "patientprocedure_procedurecode_id___fk"))
    private ProcedureCode procedureCode;

    @Column(name = "appointment_dt")
    private LocalDateTime appointmentDate;

    @Column(name = "billing_status_active")
    private boolean billingStatusActive;

    @ManyToOne
    private Patient patient;


    /**
     * Instantiates a new Patient procedures.
     */
    public PatientProcedure() {
    }

    /**
     * Instantiates a new Patient procedures.
     *
     * @param procCode        the procedure code object
     * @param appointmentDate the appointment date
     * @param patient         the patient object
     */
    public PatientProcedure(ProcedureCode procCode, LocalDateTime appointmentDate, Patient patient) {
        this.procedureCode = procCode;
        this.appointmentDate = appointmentDate;
        this.patient = patient;
    }

    /**
     * Gets id.
     *
     * @return the pp id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setPp_id(int id) {
        this.id = id;
    }

    /**
     * Gets appointment date.
     *
     * @return the appointment date
     */
    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Sets appointment date.
     *
     * @param appointmentDate the appointment date
     */
    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Is billing status active boolean.
     *
     * True=bill the patient
     *
     * False=Not a billable item
     *
     * @return the boolean
     */
    public boolean isBillingStatusActive() {
        return billingStatusActive;
    }

    /**
     * Sets billing status active.
     *
     * True=bill the patient
     *
     * False=Not a billable item
     *
     * @param billingStatusActive the billing status active
     */
    public void setBillingStatusActive(boolean billingStatusActive) {
        this.billingStatusActive = billingStatusActive;
    }

    /**
     * Gets patient.
     *
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient the patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets procedure code.
     *
     * @return the procedure code
     */
    public ProcedureCode getProcedureCode() {
        return procedureCode;
    }

    /**
     * Sets procedure code.
     *
     * @param procedureCode the procedure code
     */
    public void setProcedureCode(ProcedureCode procedureCode) {
        this.procedureCode = procedureCode;
    }

    @Override
    public String toString() {
        return "PatientProcedure{" +
                "procedureCode=" + procedureCode +
                ", appointmentDate=" + appointmentDate +
                ", patient=" + patient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientProcedure that = (PatientProcedure) o;
        return id == that.id &&
                procedureCode == that.procedureCode &&
                Objects.equals(appointmentDate, that.appointmentDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, procedureCode, appointmentDate);
    }
}
