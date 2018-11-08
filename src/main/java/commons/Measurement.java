package commons;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Messung")
@NamedQuery(name = Measurement.FIND_ALL, query = "select m from Measurement m")
public class Measurement {

    public static final String FIND_ALL = "findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String hardwareAdress;

    @NotNull
    private int soilMoistureValue;

    @NotNull
    private int power;

    @NotNull
    private String date;


    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("hardwareAdress", this.hardwareAdress)
                .add("soilMoisture", this.soilMoistureValue)
                .add("power", this.power)
                .add("date", this.date)
                .build();
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getHardwareAdress() {
        return this.hardwareAdress;
    }


    public void setHardwareAdress(String hardwareAdress) {
        this.hardwareAdress = hardwareAdress;
    }


    public int getSoilMoistureValue() {
        return this.soilMoistureValue;
    }


    public void setSoilMoistureValue(int soilMoistureValue) {
        this.soilMoistureValue = soilMoistureValue;
    }


    public int getPower() {
        return this.power;
    }


    public void setPower(int power) {
        this.power = power;
    }


    public String getDate() {
        return this.date;
    }


    public void setDate(String date) {
        this.date = date;
    }
}
