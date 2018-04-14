package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Patient.
 */
@Entity(name = "Patient")
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name ="native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "notes")
    private String notes;

    @Column(name = "referred_by")
    private String referredBy;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private int postalCode;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy(clause = "appointment_dt ASC")
    private Set<PatientProcedure> treatmentPlan = new HashSet<>();

    /**
     * Empty Contructor: Instantiates a new Patient.
     */
    public Patient() {
    }

    /**
     * Contructor2: Create a new Patient with values.
     */
    public Patient(String firstName, String lastName, String diagnosis, String referredBy, String streetName, String city, String state, int postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.diagnosis = diagnosis;
        this.referredBy = referredBy;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    /**
     * Gets patient id.
     *
     * @return the patient id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets patient id.
     *
     * @param patientId the patient id
     */
    public void setId(int patientId) {
        this.id = patientId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets diagnosis.
     *
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets diagnosis.
     *
     * @param diagnosis the diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }


    /**
     * Gets referred by.
     *
     * @return the referred by
     */
    public String getReferredBy() {
        return referredBy;
    }

    /**
     * Sets referred by.
     *
     * @param referredBy the referred by
     */
    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }



    /**
     * Gets street name.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets postal code.
     *
     * @return the postal code
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postal code.
     *
     * @param postalCode the postal code
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets treatment plan.
     *
     * @return the treatment plan
     */
    public Set<PatientProcedure> getTreatmentPlan() {
        return treatmentPlan;
    }

    /**
     * Sets treatment plan.
     *
     * @param treatmentPlan the treatment plan
     */
    public void setTreatmentPlan(Set<PatientProcedure> treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    /**
     * Add procedures.
     * @param patientProcedures the patient procedures
     */
    public void addProcedures(PatientProcedure patientProcedures) {
        treatmentPlan.add(patientProcedures);
        patientProcedures.setPatient(this);
    }

    /**
     * Remove procedures.
     *
     * @param patientProcedures the patient procedures
     */
    public void removeProcedures(PatientProcedure patientProcedures) {
        treatmentPlan.remove(patientProcedures);
        patientProcedures.setPatient(null);
    }

    @Override
    public String toString() {
        return "Patient {" +
                "First Name ='" + firstName + '\'' +
                ", Last Name ='" + lastName + '\'' +
                ", Diagnosis ='" + diagnosis + '\'' +
                ", Referred by='" + referredBy + '\'' +
                ", Street Name ='" + streetName + '\'' +
                ", City        ='" + city   + '\'' +
                ", State       ='" + state  + '\'' +
                ", Postal Code ='" + postalCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                postalCode == patient.postalCode &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(diagnosis, patient.diagnosis) &&
                Objects.equals(referredBy, patient.referredBy) &&
                Objects.equals(streetName, patient.streetName) &&
                Objects.equals(city, patient.city) &&
                Objects.equals(state, patient.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, diagnosis, referredBy, streetName, city, state, postalCode);
    }
}