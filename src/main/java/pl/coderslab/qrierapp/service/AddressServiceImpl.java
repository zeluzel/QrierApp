package pl.coderslab.qrierapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.qrierapp.entity.Address;
import pl.coderslab.qrierapp.repository.AddressRepository;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.getOne(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

}
