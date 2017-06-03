/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import vuelosJSF.ejb.CityFacade;
import vuelosJSF.ejb.FlightFacade;
import vuelosJSF.entity.City;
import vuelosJSF.entity.Flight;

/**
 *
 * @author Daniel
 */
@Named(value = "vuelosCrudBean")
@RequestScoped
public class VuelosCrudBean {

    @EJB
    private CityFacade cityFacade;

    @EJB
    private FlightFacade flightFacade;
    
    @Inject
    private VuelosBean vuelosBean;
    
     private String origen;
    private String destino; 
    
    
    
    /**
     * Creates a new instance of VuelosCrudBean
     */
    public VuelosCrudBean() {
    }
    
    public String doEliminar(Flight vuelo){
        this.flightFacade.remove(vuelo);
        this.vuelosBean.getListaVuelos().remove(vuelo);
        return "vuelos";
    }
    
   
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
     public String doEditar(Flight vuelo){
        this.vuelosBean.getMapeoVueloCanEdit().put(vuelo, Boolean.TRUE);
        this.origen = vuelo.getOrigAirport().getAirport();
        this.destino = vuelo.getDestAirport().getAirport();
        return "vuelos";
    }

    
    public String doGuardar(Flight vuelo){
        this.vuelosBean.getListaVuelos().remove(vuelo);
        int posicion=0;
        for(int i=0; i<this.vuelosBean.getListaVuelos().size(); i++){
            if(vuelosBean.getListaVuelos().get(i).equals(vuelo)){
                posicion = i;
                this.vuelosBean.getListaVuelos().remove(i);
                break;
            }
        }
        
        City ciudadOrigen = this.cityFacade.find(this.origen);
        City ciudadDestino = this.cityFacade.find(this.destino);
        vuelo.setOrigAirport(ciudadOrigen);
        vuelo.setDestAirport(ciudadDestino);
        this.flightFacade.edit(vuelo);
        this.vuelosBean.getMapeoVueloCanEdit().put(vuelo, Boolean.FALSE);
        this.vuelosBean.getListaVuelos().add(posicion, vuelo);
        
        
        return "vuelos";
    }
    
}
