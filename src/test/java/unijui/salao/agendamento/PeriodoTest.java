package unijui.salao.agendamento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import unijui.salao.agendamento.domain.Agendamento;
import unijui.salao.utils.DateUtils;
import unijui.salao.domain.Periodo;
import unijui.salao.domain.PeriodoDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PeriodoTest {

    private List<Agendamento> agendamentos;
    private List<Periodo> horariosBase;
    private List<Periodo> horariosAgendados;

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        Agendamento agendamento1 = Mockito.mock(Agendamento.class);
        Agendamento agendamento2 = Mockito.mock(Agendamento.class);
        Mockito.when(agendamento1.getDataInicio()).thenReturn(DateUtils.stringParaData(today + " 09:00"));
        Mockito.when(agendamento1.getDataFim()).thenReturn(DateUtils.stringParaData(today + " 10:00"));
        Mockito.when(agendamento2.getDataInicio()).thenReturn(DateUtils.stringParaData(today + " 11:00"));
        Mockito.when(agendamento2.getDataFim()).thenReturn(DateUtils.stringParaData(today + " 12:00"));

        agendamentos = new ArrayList<>();
        agendamentos.add(agendamento1);
        agendamentos.add(agendamento2);

        horariosBase = DateUtils.getHorarios();

        horariosAgendados = new ArrayList<>();
        horariosAgendados.add(new Periodo(DateUtils.stringParaData(today + " 09:00"), DateUtils.stringParaData(today + " 10:00")));
    }

    @Test
    public void testBuscarPeriodosAgendadosFuncionario() {
        List<Periodo> result = Periodo.buscarPeriodosAgendadosFuncionario(agendamentos);
        assertEquals(2, result.size());
        assertEquals(agendamentos.get(0).getDataInicio(), result.get(0).getDataInicio());
        assertEquals(agendamentos.get(0).getDataFim(), result.get(0).getDataFim());
        assertEquals(agendamentos.get(1).getDataInicio(), result.get(1).getDataInicio());
        assertEquals(agendamentos.get(1).getDataFim(), result.get(1).getDataFim());
    }

    @Test
    public void testFiltrarHorariosLivresFuncionario() throws ParseException {
        List<PeriodoDto> result = Periodo.filtrarHorariosLivresFuncionario(horariosBase, horariosAgendados);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        assertEquals(8, result.size());
        assertEquals(today + " 08:00", result.get(0).getDataInicio());
        assertEquals(today + " 09:00", result.get(0).getDataFim());
        assertEquals(today + " 10:00", result.get(1).getDataInicio());
        assertEquals(today + " 11:00", result.get(1).getDataFim());
    }
}
