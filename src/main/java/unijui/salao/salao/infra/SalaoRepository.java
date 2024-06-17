package unijui.salao.salao.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unijui.salao.salao.domain.Salao;

import java.util.List;

@Repository
public interface SalaoRepository extends JpaRepository<Salao, Integer> {

    List<Salao> findAll();

    Salao findById(int id);

    Salao findByUserId(int userId);

}
