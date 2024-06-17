package unijui.salao.cliente.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.cliente.domain.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findById(int id);

    List<Cliente> findAll();

    Cliente findByUserId(int userId);
}
