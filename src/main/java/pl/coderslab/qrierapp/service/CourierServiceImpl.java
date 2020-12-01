package pl.coderslab.qrierapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.qrierapp.entity.Courier;
import pl.coderslab.qrierapp.repository.CourierRepository;

import java.util.List;


@Service
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    @Autowired
    public CourierServiceImpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public void save(Courier courier) {
        courierRepository.save(courier);
    }

    @Override
    public Courier findById(Long id) {
        return courierRepository.getOne(id);
    }

    @Override
    public List<Courier> findAll() {
        return courierRepository.findAll();
    }
}
