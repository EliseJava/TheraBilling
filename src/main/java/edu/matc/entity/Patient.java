package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Patient.
 */
@Entity(name = "Patient")
@Table(name = "patient")
public class Patient {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "diagnosis")
    private String diagnosis;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name ="native", strategy = "native")
    @Column(name = "patient_id")
    private int patientId;

    /**
     * Contructor: Instantiates a new Patient.
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
     * Gets patient id.
     *
     * @return the patient id
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets patient id.
     *
     * @param patientId the patient id
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
}