package bitlab.kx.hiber.Service;

//Anotation Service
import bitlab.kx.hiber.Country;
import bitlab.kx.hiber.Exceptions.CountryNotFoundException;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    Country getCountry(Long id);

    Country addCountry(Country country);

    Country updateCountry(Country country)
            throws CountryNotFoundException;

    void deleteCountry(Long id)
            throws CountryNotFoundException;
}