package pl.coderslab.qrierapp.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.qrierapp.entity.Client;
import pl.coderslab.qrierapp.service.AddressService;
import pl.coderslab.qrierapp.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientFixture {

    private final ClientService clientService;
    private final AddressService addressService;

    private final List<Client> clients;

    @Autowired
    public ClientFixture(ClientService clientService, AddressService addressService) {
        this.clientService = clientService;
        this.addressService = addressService;
        clients = List.of(
                new Client("Archikom", "Pani", "Sekretarka", "Archikom", "123234345", addressService.findById(1L)),
                new Client("Ventage Development", "Andrzej", "Kowalski", "Ventage", "123234345", addressService.findById(2L)),
                new Client("Panalpina", null, null, "Panalpina", "654543432", addressService.findById(3L)),
                new Client("Wrocławscy Kurierzy Rowerowi", "Paweł", "Puławski", "WKR" , "654543432", addressService.findById(4L))
        );
    }

    public void loadIntoDb() {
        for (Client client : clients) {
            clientService.save(client);
        }
    }
}
