package unijui.salao.salao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.agendamento.Agendamento;

import java.util.List;

@Repository
public interface SalaoRepository extends JpaRepository<Salao, Integer> {

    List<Salao> findAll();

    Salao findById(int id);

}
