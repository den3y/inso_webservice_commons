package commons;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfaces.AbstractMeasurementLogic;

@Model
public class MeasurementLogic implements AbstractMeasurementLogic {

    @PersistenceContext(name = "prod")
    EntityManager em;


    public List<Measurement> findAll() {
        return this.em.createNamedQuery(Measurement.FIND_ALL).getResultList();
    }


    public Measurement findById(Long id) {
        return this.em.find(Measurement.class, id);
    }


    public void create(Measurement measurement) {
        this.em.persist(measurement);
    }


    public void createWithParams(String hardwareAdress, int soilMoistureValue, int power, String date) {
        Measurement measurement = new Measurement();
        measurement.setHardwareAdress(hardwareAdress);
        measurement.setSoilMoistureValue(soilMoistureValue);
        measurement.setPower(power);
        measurement.setDate(date);
        this.em.persist(measurement);
    }


    public void remove(Measurement measurement) {
        this.em.remove(measurement);
    }
}
