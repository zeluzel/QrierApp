package pl.coderslab.qrierapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.qrierapp.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
