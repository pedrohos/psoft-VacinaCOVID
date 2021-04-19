import Controllers.RegistroController;

import java.util.ArrayList;

public class Main {

    private static RegistroController registroController = new RegistroController();

    public static void main(String[] args) {

        ArrayList<String> comorbidades1 = new ArrayList<>();
        ArrayList<String> comorbidades2 = new ArrayList<>();
        comorbidades1.add("Hipertensão");

        comorbidades2.add("Diabetes");
        comorbidades2.add("Gonorreia");

        registroController.inserirRegistro("Carlos", 123456789, "Rua Nova Catedral",
                435123452, "calros@email.com", "3255-9393", 27,"Enfermeiro",
                comorbidades1);

        registroController.inserirRegistro("Marcela", 987654321, "Rua Maria Aparecida",
                513412343, "marcela@email.com", "3829-2293", 42,"Artista",
                new ArrayList<>());

        registroController.inserirRegistro("Cleiton", 518402934, "Rua Damião Fonseca",
                543534341, "clieton@email.com", "3239-2509", 33,"Professor",
                comorbidades2);

        System.out.println(registroController.getStatusPessoa(123456789));
        System.out.println("-----------------------------------------");
        System.out.println(registroController.toString());
        System.out.println("-----------------------------------------");
        registroController.setMinIdadeVacinacao(42);
        System.out.println(registroController.toString());
        System.out.println("-----------------------------------------");
        registroController.vacina(987654321);
        System.out.println(registroController.toString());
        System.out.println("-----------------------------------------");
        registroController.inserirProfissao("Enfermeiro");
        System.out.println(registroController.toString());
        System.out.println("-----------------------------------------");
        registroController.inserirComorbidade("Diabetes");
        registroController.inserirComorbidade("Asma");
        System.out.println(registroController.toString());
    }
}
