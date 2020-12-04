package pl.coderslab.qrierapp.service;

import pl.coderslab.qrierapp.entity.Courier;

import java.util.List;

public interface CourierService {

    void save(Courier courier);

    Courier findById(Long id);

    List<Courier> findAll();

    List<Courier> getActiveCouriers();
}
