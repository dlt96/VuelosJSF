/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import vuelosJSF.ejb.CityFacade;
import vuelosJSF.ejb.FlightFacade;
import vuelosJSF.entity.City;
import vuelosJSF.entity.Flight;

/**
 *
 * @author Daniel
 */
@Named(value = "vuelosBean")
@SessionScoped
public class VuelosBean implements Serializable {

    @EJB
    private CityFacade cityFacade;
  
    
    private List<Flight> listaVuelos;
    private List<City> listaCiudades;
    private Map<Flight,Boolean> mapeoVueloCanEdit; 

    /**
     * Creates a new instance of VuelosBean
     */
    public VuelosBean() {
    }
    
    @PostConstruct
    public void init(){
       
    }

    public Map<Flight, Boolean> getMapeoVueloCanEdit() {
        return mapeoVueloCanEdit;
    }

    public void setMapeoVueloCanEdit(Map<Flight, Boolean> mapeoVueloCanEdit) {
        this.mapeoVueloCanEdit = mapeoVueloCanEdit;
    }

    
    
    public List<Flight> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<Flight> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public List<City> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<City> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }
   
    
}
