package unijui.salao.infrastructure.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.domain.agendamento.Agendamento;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findAllBySalaoId(int idSalao);

    List<Agendamento> findAllByClienteId(int idCliente);

    List<Agendamento> findAllByFuncionarioId(int idFuncionario);


}
