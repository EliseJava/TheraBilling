package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Patient procedures.
 */
@Entity(name = "PatientProcedures")
@Table(name = "patientprocedure")
public class PatientProcedures {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name ="native", strategy = "native")
    private int pp_id;

    @Column(name = "procedure_code")
    private int procedureCode;
    @Column(name = "appointment_dt")
    private LocalDateTime appointmentDate;

    @ManyToOne
    private Patient patient;

    /**
     * Instantiates a new Patient procedures.
     */
    public PatientProcedures() {
    }

    /**
     * Instantiates a new Patient procedures.
     *
     * @param procedureCode   the procedure code
     * @param appointmentDate the appointment date
     * @param patient         the patient
     */
    public PatientProcedures(int procedureCode, LocalDateTime appointmentDate, Patient patient) {
        this.procedureCode = procedureCode;
        this.appointmentDate = appointmentDate;
        this.patient = patient;
    }

    /**
     * Gets pp id.
     *
     * @return the pp id
     */
    public int getPp_id() {
        return pp_id;
    }

    /**
     * Sets pp id.
     *
     * @param pp_id the pp id
     */
    public void setPp_id(int pp_id) {
        this.pp_id = pp_id;
    }

    /**
     * Gets procedure code.
     *
     * @return the procedure code
     */
    public int getProcedureCode() {
        return procedureCode;
    }

    /**
     * Sets procedure code.
     *
     * @param procedureCode the procedure code
     */
    public void setProcedureCode(int procedureCode) {
        this.procedureCode = procedureCode;
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

    @Override
    public String toString() {
        return "PatientProcedures{" +
                "procedureCode=" + procedureCode +
                ", appointmentDate=" + appointmentDate +
                ", patient=" + patient +
                '}';
    }
}
