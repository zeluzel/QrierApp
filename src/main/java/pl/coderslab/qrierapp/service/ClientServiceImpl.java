package pl.coderslab.qrierapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.qrierapp.entity.Client;
import pl.coderslab.qrierapp.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

}
