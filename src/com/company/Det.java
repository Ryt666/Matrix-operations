package com.company;

public class Det{
    //раскладываем на миноры, для каждого минора вычисляем определитель, рекурсивно вызывая функцию
    public double det(double[][] matrix){
        double Result=0.0;
        if (matrix.length==2){
            Result=matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        }
        else {
            int k = 1;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 1) {  //разложение по первой строке
                    k = -1;
                } else {
                    k = 1;
                }
                Result += k * matrix[0][i] * this.det(this.GetMinor(matrix, 0, i));
                //разложение
            }
        }
        return Result;
    }

    //функция, к-я возвращает минор. На входе - определитель, из к-го надо достать минор и номера строк-столбцов, к-е надо вычеркнуть.
    private double[][] GetMinor(double[][] matrix, int row, int column){
        int minorLength = matrix.length-1;
        double[][] minor = new double[minorLength][minorLength];
        int delete_i=0;//эти переменные для того, чтобы пропускать ненужные строку и столбец
        int delete_j=0;
        for(int i=0; i<=minorLength; i++){
            delete_j=0;
            for(int j=0; j<=minorLength; j++){
                if(i==row){
                    delete_i=1;
                }
                else{
                    if(j==column){
                        delete_j=1;
                    }
                    else{
                        minor[i-delete_i][j-delete_j] = matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }
}
