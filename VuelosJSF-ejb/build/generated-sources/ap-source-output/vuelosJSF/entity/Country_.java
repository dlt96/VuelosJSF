package vuelosJSF.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vuelosJSF.entity.City;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T19:53:41")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, String> country;
    public static volatile SingularAttribute<Country, String> countryIsoCode;
    public static volatile CollectionAttribute<Country, City> cityCollection;
    public static volatile SingularAttribute<Country, String> region;

}