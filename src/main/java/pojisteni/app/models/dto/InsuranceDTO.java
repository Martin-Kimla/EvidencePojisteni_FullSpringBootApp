package pojisteni.app.models.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class InsuranceDTO {

    private long insuranceId;
    @NotBlank(message = "Vyplňte titulek")
    @NotNull(message = "Vyplňte titulek")
    @Size(max = 100, message = "Titulek je příliš dlouhý")
    private String insuranceTitle;
    @NotBlank(message = "Vyplňte pojistný limit")
    @NotNull(message = "Vyplňte pojistný limit")
    private String insuranceAmount;
    @NotBlank(message = "Vyplňte název")
    @NotNull(message = "Vyplňte název")
    private String insuranceType;
    @NotBlank(message = "Vyplňte počátek platnosti")
    @NotNull(message = "Vyplňte počátek platnosti")
    private String validFrom;
    @NotBlank(message = "Vyplňte konec platnosti")
    @NotNull(message = "Vyplňte konec platnosti")
    private String validTo;

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

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }
}
