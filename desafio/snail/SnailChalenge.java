package desafio.snail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnailChalenge {

    public static void main(String[] args) {
        Integer[][] matrix = readMatrix();
        List<Integer> result = orderInSnail(matrix);
        List<String> formatedResult = new ArrayList<>();
        result.forEach(value -> {
            String formatedValue = value !=null ? String.valueOf(value) : " ";
            formatedResult.add(formatedValue);
        });
        System.out.println(formatedResult);
    }

    public static Integer[][] readMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de linhas da matriz: ");
        int line = scanner.nextInt();
        System.out.print("Digite a quantidade de elementos por linha da matriz: ");
        int elementsPerLine = scanner.nextInt();
        scanner.nextLine();
        Integer[][] matrix = new Integer[line][elementsPerLine];
        for(int i = 0; i<line; i++){
            for(int k = 0; k<elementsPerLine; k++){
                System.out.print("Digite o "+(k+1)+"º elemento da linha "+(i+1)+": ");
                String value = scanner.nextLine();
                matrix[i][k] = fromStringToInteger(value);
            }
        }
        scanner.close();
        return matrix;
    }

    private static Integer fromStringToInteger(String value){
        Integer valueFormated;

        try{
            valueFormated = Integer.valueOf(value);
        }catch(NumberFormatException e){
            valueFormated = null;
        }

        return valueFormated;
    }

    public static List<Integer> orderInSnail(Integer[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            addElementsFromTop(matrix, result, top, left, right);
            top++;

            addElementsFromRight(matrix, result, top, bottom, right);
            right--;

            if (top <= bottom) {
                addElementsFromBottom(matrix, result, bottom, right, left);
                bottom--;
            }

            if (left <= right) {
                addElementsFromLeft(matrix, result, top, bottom, left);
                left++;
            }
        }

        return result;
    }

    private static void addElementsFromTop(Integer[][] matrix, List<Integer> result, int top, int left, int right) {
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
    }

    private static void addElementsFromRight(Integer[][] matrix, List<Integer> result, int top, int bottom, int right) {
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
    }

    private static void addElementsFromBottom(Integer[][] matrix, List<Integer> result, int bottom, int right, int left) {
        for (int i = right; i >= left; i--) {
            result.add(matrix[bottom][i]);
        }
    }

    private static void addElementsFromLeft(Integer[][] matrix, List<Integer> result, int top, int bottom, int left) {
        for (int i = bottom; i >= top; i--) {
            result.add(matrix[i][left]);
        }
    }
}
