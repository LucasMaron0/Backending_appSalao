package unijui.salao.infrastructure.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.domain.funcionario.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Funcionario findById(int id);

    List<Funcionario> findAll();

    List<Funcionario> findAllBySalaoId(int idSalao);
}
