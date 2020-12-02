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
            new Address("Ksawerego Liskego", 7, "Wrocław"),
            new Address("Dąbrowskiego", 44, "Wrocław"),
            new Address("Graniczna", 8, "Wrocław"),
            new Address("Rydygiera", 1, "Wrocław")
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
