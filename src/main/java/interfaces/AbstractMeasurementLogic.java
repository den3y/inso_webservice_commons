package interfaces;

import java.util.List;

import commons.Measurement;

public interface AbstractMeasurementLogic {

    public List<Measurement> findAll();


    public Measurement findById(Long id);


    public void create(Measurement measurement);


    public void remove(Measurement measurement);

    /*
     * Will be specified in a future release
     * public Boolean get(Object o);
     *
     *
     * public Boolean set(Object o);
     */

}
