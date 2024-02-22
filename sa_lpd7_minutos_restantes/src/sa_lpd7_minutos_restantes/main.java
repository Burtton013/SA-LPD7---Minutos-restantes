package sa_lpd7_minutos_restantes;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String diaSemana;
        int hora, minutos;

      
        do {
            System.out.println("Por favor, ingresa un día de la semana (lunes a viernes):");
            diaSemana = scanner.nextLine().toLowerCase();
        } while (!esDiaSemanaValido(diaSemana));
        do {
            System.out.println("Por favor, ingresa la hora (formato 24 horas):");
            hora = scanner.nextInt();
            System.out.println("Por favor, ingresa los minutos:");
            minutos = scanner.nextInt();
        } while (!esHoraValida(hora, minutos));

        int minutosHastaFinDeSemana = calcularMinutosHastaFinDeSemana(diaSemana, hora, minutos);
        
        System.out.println("Minutos restantes para el fin de semana: " + minutosHastaFinDeSemana + " minutos.");

        scanner.close();
    }
	
    public static boolean esDiaSemanaValido(String diaSemana) {
        return diaSemana.equals("lunes") || diaSemana.equals("martes") || diaSemana.equals("miércoles") ||
                diaSemana.equals("miercoles") || diaSemana.equals("jueves") || diaSemana.equals("viernes");
    }

    public static boolean esHoraValida(int hora, int minutos) {
        return hora >= 0 && hora < 24 && minutos >= 0 && minutos < 60;
    }

    public static int calcularMinutosHastaFinDeSemana(String diaSemana, int hora, int minutos) {
        int minutosHastaFinDeSemana = 0;

        final int MINUTOS_POR_DIA = 24 * 60;
        final int MINUTOS_POR_HORA = 60;

        switch (diaSemana) {
            case "lunes":
            case "martes":
            case "miércoles":
            case "miercoles":
            case "jueves":
                minutosHastaFinDeSemana = (4 * MINUTOS_POR_DIA + 15 * MINUTOS_POR_HORA) - ((hora * MINUTOS_POR_HORA) + minutos);
                break;
            case "viernes":
                if (hora < 15) {
                    minutosHastaFinDeSemana = (4 * MINUTOS_POR_DIA + 15 * MINUTOS_POR_HORA) - ((hora * MINUTOS_POR_HORA) + minutos);
                } else {
                    minutosHastaFinDeSemana = 0;
                }
                break;
        }

        return minutosHastaFinDeSemana;
    }
}
