package alejandro.course.projects.microservicesproject.controllers.dto;


import javax.validation.constraints.NotBlank;

public class InsuranceDto {

    @NotBlank
    private String id;

    @NotBlank
    private String vehicleId;

    @NotBlank
    private Boolean coverage;

    @NotBlank
    private Boolean premiumCoverage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Boolean getCoverage() {
        return coverage;
    }

    public void setCoverage(Boolean coverage) {
        this.coverage = coverage;
    }

    public Boolean getPremiumCoverage() {
        return premiumCoverage;
    }

    public void setPremiumCoverage(Boolean premiumCoverage) {
        this.premiumCoverage = premiumCoverage;
    }
}
