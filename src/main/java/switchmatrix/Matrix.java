package switchmatrix;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Matrix {

    private int[] a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[][] m;

    public Matrix(int[] a, int[] b, int[] c, int[] d, int[] e, int[] f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;

        this.m = new int[][]{a, b, c, d, e, f};
    }

    public int[][] getM() {
        return m;
    }

    public int getStarterZeros(){
        int zSum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (getM()[i][j] == 0) {
                    zSum++;
                }
            }
        }
        return zSum;
    }

    public void setM(int i, int j, int x) {
        this.m[i][j] = x;
    }

    public void logActualState() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    public void logActualTime(){
        System.out.println(LocalDateTime.now());
    }

    public void switchAllOff() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(m[i][j] == 1){
                    m[i][j] = 0;
                }
            }
        }
    }

    public void switchActualRow() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {                                                       //Adott sor első értéke
                    if(m[i][j] == 1 && m[i][j + 1] == 1){
                        m[i][j] = 0;
                    }
                } else if (0 < j && j < 5) {                                        //Adott sor közbülső értékei
                    if (m[i][j] == 1 && m[i][j - 1] == 1 && m[i][j + 1] == 1) {
                        m[i][j] = 0;
                    }
                }else if (j == 5){                                                  //Adott sor utolsó értéke
                    if(m[i][j] == 1 && m[i][j - 1] == 1){
                        m[i][j] = 0;
                    }
                }
            }
        }
    }

    public void switchByRule2() {
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                if(m[i][j] == 1){
                    m[i][j] = 0;
                }else{
                    m[i][j] = 1;
                }

                if(i >= 1 && m[i-1][j] == 1){     //Fent
                    m[i-1][j] = 0;
                }else if (i>=1 && m[i-1][j] == 0){
                    m[i-1][j] = 1;
                }

                if(j >= 1 && m[i][j-1] == 1){     //Bal
                    m[i][j-1] = 0;
                }else if (j >= 1 && m[i][j-1] == 0){
                    m[i][j-1] = 1;
                }

                if(j <= 4 && m[i][j+1] == 1){     //Jobb
                    m[i][j+1] = 0;
                }else if(j <= 4 && m[i][j+1] == 0){
                    m[i][j+1] = 1;
                }

                if(i <= 4 && m[i+1][j] == 1){     //Lent
                    m[i+1][j] = 0;
                }else if(i <= 4 && m[i+1][j] == 0){
                    m[i+1][j] = 1;
                }
            }

        }
    }

    public void switchByRule() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                if(i == 0 && j == 0){       //Bal felső sarok
                    System.out.print("BF");
                    if(m[0][0] == 1) {
                        m[0][0] = 0;
                    }else {
                        m[0][0] = 1;
                    }
                    if(m[0][1] == 1){
                        m[0][1] = 0;
                    }else{
                        m[0][1] = 1;
                    }
                    if(m[1][0] == 1){
                        m[1][0] = 0;
                    }else{
                        m[1][0] = 1;
                    }
                }

                if(i == 0 && j == 5){       //Jobb felső sarok
                    System.out.print("JF");
                    if(m[0][5] == 1) {
                        m[0][5] = 0;
                    }else {
                        m[0][5] = 1;
                    }
                    if(m[0][4] == 1){
                        m[0][4] = 0;
                    }else{
                        m[0][4] = 1;
                    }
                    if(m[1][5] == 1){
                        m[1][5] = 0;
                    }else{
                        m[1][5] = 1;
                    }
                }

                if((i > 1 && i < 5) && (j > 1 && j < 5)){         //A mátrix bele

                    if(m[i][j] == 1){       //Aktuál
                        m[i][j] = 0;
                    }else{
                        m[i][j] = 1;
                    }

                    if(m[i-1][j] == 1){     //Fent
                        m[i-1][j] = 0;
                    }else{
                        m[i-1][j] = 1;
                    }

                    if(m[i][j-1] == 1){     //Bal
                        m[i][j-1] = 0;
                    }else{
                        m[i][j-1] = 1;
                    }

                    if(m[i][j+1] == 1){     //Jobb
                        m[i][j+1] = 0;
                    }else{
                        m[i][j+1] = 1;
                    }

                    if(m[i+1][j] == 1){     //Lent
                        m[i+1][j] = 0;
                    }else{
                        m[i+1][j] = 1;
                    }
                }

                if(i == 5 && j == 0){       //Bal alsó sarok
                    System.out.print("BA");
                    if(m[5][0] == 1) {
                        m[5][0] = 0;
                    }else {
                        m[5][0] = 1;
                    }
                    if(m[5][1] == 1){
                        m[5][1] = 0;
                    }else{
                        m[5][1] = 1;
                    }
                    if(m[4][0] == 1){
                        m[4][0] = 0;
                    }else{
                        m[4][0] = 1;
                    }
                }

                if(i == 5 && j == 5){       //Jobb alsó sarok
                    System.out.print("JA");
                    if(m[5][5] == 1) {
                        m[5][5] = 0;
                    }else {
                        m[5][5] = 1;
                    }
                    if(m[5][4] == 1){
                        m[5][4] = 0;
                    }else{
                        m[5][4] = 1;
                    }
                    if(m[4][5] == 1){
                        m[4][5] = 0;
                    }else{
                        m[4][5] = 1;
                    }
                }
            }
        }

    }


}
