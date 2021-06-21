package J6L8hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import J6L8hw.model.Customer;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findById(int id);

}
