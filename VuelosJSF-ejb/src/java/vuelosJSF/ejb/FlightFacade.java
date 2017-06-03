/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelosJSF.ejb;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import vuelosJSF.entity.Flight;

/**
 *
 * @author Daniel
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {

    @PersistenceContext(unitName = "VuelosJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }

    public List<Flight> findByCountries(String[] paisesSeleccionados) {
        List<String> paises = Arrays.asList(paisesSeleccionados);
        Query q;
        q = em.createQuery("select f from Flight f where f.origAirport.countryIsoCode IN :paises ");
        q.setParameter("paises", paises);
        return (List<Flight>) q.getResultList();
    }
    
}
