package unijui.salao.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
