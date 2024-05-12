package unijui.salao.utils.enums;


import java.util.List;
import java.util.stream.Collectors;

public enum Servicos {
    CORTE_CABELO,
    MANICURE;

    public static List<Servicos> converterParaEnum(List<String> strings) {
        return strings.stream()
                .map(Servicos::valueOf)
                .collect(Collectors.toList());
    }

}
