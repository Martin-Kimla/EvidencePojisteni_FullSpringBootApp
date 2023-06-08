package pojisteni.app.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InsuredDTO {

    private long insuredId;
    @NotBlank(message = "Vyplňte jmeno")
    @NotNull(message = "Vyplňte jmeno")
    private String jmeno;
    @NotBlank(message = "Vyplňte příjmení")
    @NotNull(message = "Vyplňte příjmení")
    private String prijmeni;
    @NotBlank(message = "Vyplňte email")
    @NotNull(message = "Vyplňte email")
    private String email;
    @NotBlank(message = "Vyplňte telefon")
    @NotNull(message = "Vyplňte telefon")
    private String telefon;
    @NotBlank(message = "Vyplňte ulici")
    @NotNull(message = "Vyplňte ulici")
    private String ulice;
    @NotBlank(message = "Vyplňte město")
    @NotNull(message = "Vyplňte město")
    private String mesto;
    @NotBlank(message = "Vyplňte PSČ")
    @NotNull(message = "Vyplňte PSČ")
    private String psc;

    public String getJmeno() {
        return jmeno;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }
}
