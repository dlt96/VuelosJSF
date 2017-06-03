/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import vuelosJSF.ejb.CityFacade;
import vuelosJSF.ejb.CountryFacade;
import vuelosJSF.ejb.FlightFacade;
import vuelosJSF.entity.Country;
import vuelosJSF.entity.Flight;

/**
 *
 * @author Daniel
 */
@Named(value = "paisesBean")
@RequestScoped
public class PaisesBean {

    @EJB
    private CityFacade cityFacade;

    @EJB
    private FlightFacade flightFacade;

    @EJB
    private CountryFacade countryFacade;
    
    
    
    protected List<Country> listaPaises;
    protected String[] paisesSeleccionados;
    
    @Inject
    private VuelosBean vuelosBean;

    /**
     * Creates a new instance of PaisesBean
     */
    public PaisesBean() {
    }

    public List<Country> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Country> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public String[] getPaisesSeleccionados() {
        return paisesSeleccionados;
    }

    public void setPaisesSeleccionados(String[] paisesSeleccionados) {
        this.paisesSeleccionados = paisesSeleccionados;
    }

   
    
    @PostConstruct
    public void init(){
        
        this.listaPaises = this.countryFacade.findAll();
        
    }
    
    public String doListarVuelos(){
        if(paisesSeleccionados.length == 0){
            this.vuelosBean.setListaVuelos(this.flightFacade.findAll());
        }else{
             this.vuelosBean.setListaVuelos(this.flightFacade.findByCountries(paisesSeleccionados));
        }
        this.vuelosBean.setMapeoVueloCanEdit(new HashMap<Flight,Boolean>());
        
         this.vuelosBean.getListaVuelos().forEach(flihgt->{
            this.vuelosBean.getMapeoVueloCanEdit().put(flihgt, Boolean.FALSE);
        });
        
       this.vuelosBean.setListaCiudades(this.cityFacade.findAll());
        return "vuelos";
    }
}
