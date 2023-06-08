package pojisteni.app.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceId;
    @Column(nullable = false)
    private String insuranceTitle;
    @Column(nullable = false)
    private String insuranceAmount;
    @Column(nullable = false)
    private String insuranceType;
    @Column(nullable = false)
    private String validFrom;
    @Column(nullable = false)
    private String validTo;

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceTitle() {
        return insuranceTitle;
    }

    public void setInsuranceTitle(String insuranceTitle) {
        this.insuranceTitle = insuranceTitle;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }
}
