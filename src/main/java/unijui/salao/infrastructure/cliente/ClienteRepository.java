package unijui.salao.infrastructure.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.domain.cliente.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findById(int id);

    List<Cliente> findAll();

}
