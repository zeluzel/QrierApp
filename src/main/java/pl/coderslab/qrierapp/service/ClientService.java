package pl.coderslab.qrierapp.service;

import pl.coderslab.qrierapp.entity.Client;

import java.util.List;

public interface ClientService {

    void save(Client client);
    Client findById(Long id);
    List<Client> findAll();

}
