package pl.coderslab.qrierapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.qrierapp.entity.Courier;

import java.util.List;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    List<Courier> getAllByActiveIsTrue();
}
