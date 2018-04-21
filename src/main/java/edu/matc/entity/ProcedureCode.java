package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a procedure code with pricing info.
 *
 * @author Elise Strauss
 */
@Entity(name = "ProcedureCode")
@Table(name = "procedurecode")
public class ProcedureCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "code")
    private int code;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private float unitPrice;


    /**
     * Instantiates a new procedure code.
     */
    public ProcedureCode() {
    }

    /**
     * Instantiates a new procedure code.
     *
     * @param code        the procedure code
     * @param description the procedure description
     * @param price       the unit price
     */
    public ProcedureCode(int code, String description, float price) {
        this.code = code;
        this.description = description;
        this.unitPrice = price;
    }
    /**
     * Gets procedure code id.
     *
     * @return the procedure code id
     */
    public int getId() {
        return id;
    }


    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets unit price.
     * @return the unit price
     */
    public float getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets unit price.
     *
     * @param unitPrice the unit price
     */
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ProcedureCode{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}