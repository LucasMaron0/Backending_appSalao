package unijui.salao.domain;

import lombok.Data;
import unijui.salao.domain.Periodo;
import unijui.salao.utils.DateUtils;

@Data
public class PeriodoDto {

    private String dataInicio;
    private String dataFim;


    public PeriodoDto (Periodo periodo){
        this.dataInicio = DateUtils.dataParaString(periodo.getDataInicio());
        this.dataFim = DateUtils.dataParaString(periodo.getDataFim());
    }
}
