package vuelosJSF.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vuelosJSF.entity.Country;
import vuelosJSF.entity.Flight;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T19:53:41")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, String> country;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SingularAttribute<City, Country> countryIsoCode;
    public static volatile CollectionAttribute<City, Flight> flightCollection1;
    public static volatile SingularAttribute<City, String> language;
    public static volatile CollectionAttribute<City, Flight> flightCollection;
    public static volatile SingularAttribute<City, String> airport;

}