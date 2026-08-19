package bitlab.kx.hiber.Service;

import bitlab.kx.hiber.Country;
import bitlab.kx.hiber.repository.CountryRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
public class CountryComponent {

    private final CountryRepository countryRepository;


    // GET ALL
    public List<Country> getAll() {
        return countryRepository.findAll();
    }


    // GET BY ID
    public Country getById(Long id) {
        return countryRepository
                .findById(id)
                .orElse(null);
    }


    // ADD
    public void add(String name, String code) {
        Country country = Country.builder()
                .name(name)
                .build();

        countryRepository.save(country);
    }
    //Update
    public void update(Long id,
                       String name){
         Country country = countryRepository
                 .findById(id)
                 .orElse(null);
         if (country != null){
             country.setName(name);

             countryRepository.save(country);
         }
    }


    // DELETE
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}