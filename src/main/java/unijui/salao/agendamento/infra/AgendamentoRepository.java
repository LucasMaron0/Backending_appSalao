package unijui.salao.agendamento.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.agendamento.domain.Agendamento;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findAllBySalaoId(int idSalao);

    List<Agendamento> findAllByClienteId(int idCliente);

    List<Agendamento> findAllByFuncionarioId(int idFuncionario);


}
