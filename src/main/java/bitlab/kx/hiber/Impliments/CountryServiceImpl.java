package bitlab.kx.hiber.Impliments;
//Anotation Service
import bitlab.kx.hiber.Country;
import bitlab.kx.hiber.Exceptions.CountryNotFoundException;

import bitlab.kx.hiber.Service.CountryService;
import bitlab.kx.hiber.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country)
            throws CountryNotFoundException {

        Country checkCountry =
                getCountry(country.getId());

        if (Objects.isNull(checkCountry)) {
            throw new CountryNotFoundException();
        }

        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id)
            throws CountryNotFoundException {

        Country checkCountry = getCountry(id);

        if (Objects.isNull(checkCountry)) {
            throw new CountryNotFoundException();
        }

        countryRepository.deleteById(id);
    }
}