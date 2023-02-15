package com.company;

import java.util.SortedMap;

public class Main {
    public static double[][] a = {{5, 3, 4}, {3, 11, 0}, {15, 9, 7}};
   // public  static double [] array = new double[]{};

    private static void printMatrix(double[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (c[i][j] < 10)
                    System.out.print(" ");
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    /*private static void printMatrix(double[] ar)
    {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]+" ");
        }
    }*/
    public static double [][] Copy_matrix(double [][] ar) {
        double [][] help_matr;
        help_matr = ar;
        return help_matr;
    }
    public static double [] Od_mtr(double [][] ar) {
        //double [] od_matr =  {5 ,3 ,4 ,3 ,11 ,0 ,15 ,9 ,7 };
        double [] help_matrix = new double[ar.length*ar[0].length];
        int c=0;
        for(int i=0;i<ar.length;i++) {
            for (int j = 0; j < ar[0].length; j++) {
                help_matrix[c] = ar[i][j];
                c++;
            }
        }
        return help_matrix;
    }
    public static double[] mergeSort(double[] help_matrix, int n) {
        if (n < 2) {
            return help_matrix;
        }
        int mid = n / 2;
        double[] l = new double[mid];
        double[] r = new double[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = help_matrix[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = help_matrix[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(help_matrix, l, r, mid, n - mid);

        /*array =merge(help_matrix, l, r, mid, n - mid);
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+ " ");
        }*/
        return help_matrix;
    }
    public static double[] merge(double[] help_matrix, double[] l, double[] r, double left, double right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                help_matrix[k++] = l[i++];
            }
            else {
                help_matrix[k++] = r[j++];
            }
        }
        while (i < left) {
            help_matrix[k++] = l[i++];
        }
        while (j < right) {
            help_matrix[k++] = r[j++];
        }
        return help_matrix;
    }

    public static double[][] Matr_2m(double [] ar)
    {
        double [][] Res = new double[Copy_matrix(a).length][Copy_matrix(a)[0].length];
        int iterator =0;
        for (int i =0; i< Res.length;i++)
        {
            for (int j=0;j< Res[0].length;j++)
            {
                Res[i][j]=ar[iterator];
                iterator++;
            }
        }
        return Res;
    }
    public static double[][] mult_matrix_number (double  [][] ar, int a){
        double [][] B =new double [ar.length][ar[0].length];
        for (int i=0; i<ar.length; i++){
            for(int j=0; j<ar[0].length; j++){
                B[i][j]=a*ar[i][j];
            }
        }
        return B;
    }
    public static double [][] mult_matrix (double [][] ar){
        double[][] C = new double[ar.length][ar[0].length];
        for(int i=0;i<ar.length;i++){
            for(int k=0;k<ar[0].length;k++){
                int t=0;
                for(int j=0;j<ar[0].length;j++){
                    t+=ar[i][j]*ar[j][k];
                    C[i][k]=t;
                }
            }
        }
        return C;
    }
    public static double[][] diff_matrix(double[][]mat1,double[][]mat2){
        double [][] Res=new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++) {
                Res[i][j]=mat1[i][j]- mat2[i][j];
            }
        }
        return Res;
    }
    public static double[][] sum_matrix(double[][]mat1,double[][]mat2){
        double [][] Res=new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++) {
                Res[i][j]=mat1[i][j] + mat2[i][j];
            }
        }
        return Res;
    }
    public static double [][] MnM(double[][] a){

        double [][] Res =sum_matrix(diff_matrix(mult_matrix_number(mult_matrix(mult_matrix(mult_matrix(Copy_matrix(a)))),8),mult_matrix(mult_matrix((Copy_matrix(a))))),mult_matrix_number(Copy_matrix(a),64));
        Res[0][0]= Res[0][0]-8;
        Res[1][1]= Res[1][1]-8;
        Res[2][2]= Res[2][2]-8;
        return Res;
    }
    public static double [][]reverse(double [][]ar){
        double [][] Res=new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++) {
               Res[i][j]=ar[a.length - i - 1 ][a[0].length - j - 1];
            }
        }
        return Res;
    }
    public static double [][] Search_el(double [][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                if (ar[i][j] == 9) {
                    i+=1;
                    j+=1;
                    System.out.println("item number:" + "[" + i + "]" + "[" + j + "]");
                }
            }
        }
        return ar;
    }
    public static void Search_el_sort_matrix(double [] help_matrix) {//двоичный поиск
        int first = 0, last = help_matrix.length - 1;
        int position = (first + last) / 2;

        while ((help_matrix[position] != 11) && (first <= last)) {
            position = (first + last) / 2;
            if (help_matrix[position] > 11) {
                last = position - 1;
            } else {
                first = position + 1;
            }
        }
        System.out.println(position);
    }
    public static void proverka(double [] help_martix)
    {
        int chek=0;
        for(int i=0;i<help_martix.length-1;i++) {
            System.out.print(help_martix[i]+" ");
            if (help_martix[i] <= help_martix[i + 1]) {
                chek++;
            }
        }
        if (chek == help_martix.length-1)
        {
            System.out.println("- Sorting is true ");
        }
    }
    public static void main(String[] args) {
        printMatrix(Copy_matrix(a));
        Det determinant = new Det();
        double Res = determinant.det(Copy_matrix(a));
        System.out.println(Res);
        System.out.println("-------------------------------------");
        // printMatrix(Od_mtr(Copy_matrix(a)));
        // mergeSort(Od_mtr(Copy_matrix(a)),Od_mtr(Copy_matrix(a)).length);
        printMatrix(Matr_2m(mergeSort(Od_mtr(Copy_matrix(a)),Od_mtr(Copy_matrix(a)).length)));
        printMatrix(MnM(Copy_matrix(a)));
        printMatrix(reverse(Copy_matrix(a)));
        Search_el(Copy_matrix(a));
        System.out.println("-------------------------------------");
        Search_el_sort_matrix(mergeSort(Od_mtr(Copy_matrix(a)),Od_mtr(Copy_matrix(a)).length));
        System.out.println("-------------------------------------");
        proverka(mergeSort(Od_mtr(Copy_matrix(a)),Od_mtr(Copy_matrix(a)).length));
        System.out.println("-------------------------------------");
    }
}


