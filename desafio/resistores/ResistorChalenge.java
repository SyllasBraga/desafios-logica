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

        return buildColorCode(ohmsValue);
    }

    private static String buildColorCode(Integer ohmsValue) {
        String ohmsString = String.valueOf(ohmsValue);
        StringBuilder colorCode = new StringBuilder();
        int numberOfColorsCode = 0;

        numberOfColorsCode = appendSignificantColors(ohmsString, colorCode, numberOfColorsCode);

        String multiplierColor = calculateMultiplierColor(ohmsString, numberOfColorsCode);

        return colorCode.toString().trim() + " " + multiplierColor + " dourado";
    }

    private static int appendSignificantColors(String ohmsString, StringBuilder colorCode, int numberOfColorsCode) {
        for (int i = 0; i < ohmsString.length(); i++) {
            int digit = Character.getNumericValue(ohmsString.charAt(i));
            if (numberOfColorsCode >= 2) {
                if (digit != 0) {
                    String color = colorMap.get(digit);
                    colorCode.append(color).append(" ");
                    numberOfColorsCode++;
                }
            } else if (numberOfColorsCode < 2) {
                String color = colorMap.get(digit);
                colorCode.append(color).append(" ");
                numberOfColorsCode++;
            }
        }
        return numberOfColorsCode;
    }

    private static String calculateMultiplierColor(String ohmsString, int numberOfColorsCode) {
        int multiplier = ohmsString.length() - numberOfColorsCode;
        return colorMap.get(multiplier);
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

    private static void initializeColorMap() {
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
