package br.com.alura.TabelaFipe.principal;

import br.com.alura.TabelaFipe.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    public void exibeMenu() {
        var menu = """
                *** OPÇÕES ***
                Carros
                Motos
                Caminhões
                
                Digite uma das opções para consultar:
                """;
        System.out.println(menu);
        var opcao = scanner.nextLine();
        String endereco;

        if (opcao.toUpperCase().contains("CAR")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toUpperCase().contains("MOT")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

    }
}
