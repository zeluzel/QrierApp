package pl.coderslab.qrierapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.qrierapp.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
