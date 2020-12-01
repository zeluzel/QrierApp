package pl.coderslab.qrierapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.qrierapp.entity.Address;

import java.util.List;


@Service
public interface AddressService {

    void save(Address address);
    Address findById(Long id);
    List<Address> findAll();

}
