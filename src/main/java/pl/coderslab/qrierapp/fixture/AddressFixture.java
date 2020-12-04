package pl.coderslab.qrierapp.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.qrierapp.entity.Address;
import pl.coderslab.qrierapp.service.AddressService;

import java.util.List;

@Component
public class AddressFixture {

    private final AddressService addressService;

    List<Address> addresses = List.of(
            new Address("Ksawerego Liskego", 7, 13, "53-123", "Wrocław", null),
            new Address("Dąbrowskiego", 44, null, "52-543", "Wrocław", null),
            new Address("Graniczna", 8, null, "12-587", "Wrocław", null),
            new Address("Rydygiera", 1, 1, "13-755", "Wrocław", "fajne ziomeczki")
    );

    @Autowired
    public AddressFixture(AddressService addressService) {
        this.addressService = addressService;
    }

    public void loadIntoDb() {
        for (Address address : addresses) {
            addressService.save(address);
        }
    }
}
