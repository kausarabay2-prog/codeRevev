package bitlab.kx.hiber.Service;

import bitlab.kx.hiber.Country;
import bitlab.kx.hiber.Item;
import bitlab.kx.hiber.repository.CountryRepository;
import bitlab.kx.hiber.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemComponent {

    private final ItemRepository itemRepository;
    private final CountryRepository countryRepository;


    // GET ALL ITEMS
    public List<Item> getAll() {
        return itemRepository.findAll();
    }


    // GET ITEM BY ID
    public Item getById(Long id) {
        return itemRepository
                .findById(id)
                .orElse(null);
    }


    // ADD ITEM
    public void add(
            String name,
            int price,
            Long countryId
    ) {

        Country country = countryRepository
                .findById(countryId)
                .orElse(null);

        Item item = Item.builder()
                .nameItem(name)
                .priceItem((double) price)
                .country(country)
                .build();

        itemRepository.save(item);
    }


    // UPDATE ITEM
    public void update(
            Long id,
            String name,
            int price,
            Long countryId
    ) {

        Item item = itemRepository
                .findById(id)
                .orElse(null);
        if (item != null) {

            Country country = countryRepository
                    .findById(countryId)
                    .orElse(null);

            item.setNameItem(name);
            item.setPriceItem((double) price);
            item.setCountry(country);

            itemRepository.save(item);
        }
    }


    // DELETE ITEM
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}