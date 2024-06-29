package unijui.salao.utils;

import unijui.salao.domain.Periodo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static Date stringParaData(String stringData){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return dateFormat.parse(stringData);
        } catch (ParseException e){
            System.out.println("Erro ao converter a data: " + e.getMessage());
            return null;
        }
    }

    public static String dataParaString(Date data){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return dateFormat.format(data);
        } catch (Exception e){
            System.out.println("Erro ao converter a data: " + e.getMessage());
            return  null;
        }
    }

    public static List<Periodo> getHorarios() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar calendar = Calendar.getInstance();
        Date dataAtual = calendar.getTime();
        String baseDate = sdf.format(dataAtual).substring(0, 10);

        List<Periodo> periodosDisponiveis = new ArrayList<>();
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 08:00"), sdf.parse(baseDate + " 09:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 09:00"), sdf.parse(baseDate + " 10:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 10:00"), sdf.parse(baseDate + " 11:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 11:00"), sdf.parse(baseDate + " 12:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 12:00"), sdf.parse(baseDate + " 13:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 13:00"), sdf.parse(baseDate + " 14:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 14:00"), sdf.parse(baseDate + " 15:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 15:00"), sdf.parse(baseDate + " 16:00")));
        periodosDisponiveis.add(new Periodo(sdf.parse(baseDate + " 16:00"), sdf.parse(baseDate + " 17:00")));

        return periodosDisponiveis;
    }
}
