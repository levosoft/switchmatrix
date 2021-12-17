package switchmatrix;

import java.util.Random;

public class Solution {

    static int starterZeros;

    public static void main(String[] args) {

        Matrix matrix = new Matrix(new int[]{1,1,0,1,0,1}, new int[]{0,1,0,1,1,1}, new int[]{1,1,0,1,0,1}, new int[]{0,0,0,0,1,1}, new int[]{1,0,0,0,1,1}, new int[]{1,0,0,0,0,0});
        starterZeros = matrix.getStarterZeros();

        matrix.logActualState();
        matrix.logActualTime();
        switchMatrixAndLog(matrix, 0, zeroCounter(matrix));
    }

    public static int zeroCounter(Matrix matrix){
        int zSum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (matrix.getM()[i][j] == 0) {
                    zSum++;
                }
            }
        }
        return zSum;
    }

    public static void switchMatrixAndLog(Matrix matrix, int starterCol, int currentZeros) {
        int allZeros = 36;

        if (starterCol > 5){
            Random rnd = new Random();
            starterCol = rnd.nextInt(6);
        }

        for (int i = 0; i < 6; i++) {

            for (int j = starterCol; j < 6; j++) {

                if(matrix.getM()[i][j] == 1){                       //Actual
                    matrix.setM(i, j, 0);

                    if(i >= 1 && matrix.getM()[i-1][j] == 1){       //Up
                        matrix.setM(i-1,j,0);
                    }else if (i>=1 && matrix.getM()[i-1][j] == 0){
                        matrix.setM(i-1,j,1);
                    }

                    if(j >= 1 && matrix.getM()[i][j-1] == 1){       //Left
                        matrix.setM(i,j-1, 0);
                    }else if (j >= 1 && matrix.getM()[i][j-1] == 0){
                        matrix.setM(i,j-1, 1);
                    }

                    if(j <= 4 && matrix.getM()[i][j+1] == 1){       //Right
                        matrix.setM(i,j+1,0);
                    }else if(j <= 4 && matrix.getM()[i][j+1] == 0){
                        matrix.setM(i,j+1,1);
                    }

                    if(i <= 4 && matrix.getM()[i+1][j] == 1){       //Down
                        matrix.setM(i+1,j,0);
                    }else if(i <= 4 && matrix.getM()[i+1][j] == 0){
                        matrix.setM(i+1,j,1);
                    }
                }

            }
        }

        System.out.println(currentZeros);
        if((zeroCounter(matrix) < allZeros)){
            if((currentZeros <= starterZeros)) {
                switchMatrixAndLog(matrix, starterCol + 1, zeroCounter(matrix));
            }
        }else{
            matrix.logActualState();
            System.out.println(zeroCounter(matrix));
            matrix.logActualTime();
        }
    }


}
