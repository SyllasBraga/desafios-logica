package desafio.resistores;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResistorChalenge {
    private static final Map<Integer, String> colorMap = new HashMap<>();

    public static void main(String[] args) {
        initializeColorMap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor do resistor: ");
        String resistorValue = scanner.nextLine();
        scanner.close();

        System.out.println(convertOhmsToColors(resistorValue));
    }

    public static String convertOhmsToColors(String resistorValue) {
        Integer ohmsValue = calculateOhms(resistorValue);
        if (ohmsValue == -1) {
            return "Valor de resistor inválido!";
        } else if (ohmsValue == -2) {
            return "Valor fora do formato suportado!";
        }
        
        String ohmsString = String.valueOf(ohmsValue);
        int firstDigit = Character.getNumericValue(ohmsString.charAt(0));
        int secondDigit = Character.getNumericValue(ohmsString.charAt(1));
        int multiplier = ohmsString.length() - 2;
        
        String color1 = colorMap.get(firstDigit);
        String color2 = colorMap.get(secondDigit);
        String multiplierColor = colorMap.get(multiplier);
        
        return color1 + " " + color2 + " " + multiplierColor + " dourado";
    }
    
    public static int calculateOhms(String resistorValue) {
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)([kM])?\\s*ohms?");
        Matcher matcher = pattern.matcher(resistorValue);

        if (matcher.matches()) {
            double value = Double.parseDouble(matcher.group(1));
            String multiplier = matcher.group(3);

            if (multiplier == null) {
                return value >= 1000 ? -2 : (int) Math.round(value);
            } else if (multiplier.equals("k")) {
                double omhs = value * 1000;
                return omhs >= 1000000 ? -2 : (int) omhs;
            } else {
                return (int) value * 1000000;
            }
        } else {
            return -1;
        }
    }

    private static void initializeColorMap(){
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }
}
