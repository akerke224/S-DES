import java.util.ArrayList;
import java.util.Arrays;
public class Main  {
    public static void main(String args[]) {
        генерация сабключей к1 и к2
        int [] k = new int[] {0,1,0,1,1,1,0,1,0,1}; основной ключ
        System.out.println(Key +Arrays.toString(k));
        int [] PT = new int[] {1,0,0,1,0,1,1,0}; основной текст
        System.out.println(Plain text +Arrays.toString(PT));
        генерация первого сабключа к1
            int [] p10 = new int[k.length]; перестановка р10
            p10[0] = k[2];
            p10[1] = k[4];
            p10[2] = k[1];
            p10[3] = k[6];
            p10[4] = k[3];
            p10[5] = k[9];
            p10[6] = k[0];
            p10[7] = k[8];
            p10[8] = k[7];
            p10[9] = k[5];
        int[] l1 = Arrays.copyOfRange(p10, 0, p10.length2);
        int[] r1 = Arrays.copyOfRange(p10, p10.length2, p10.length);
        сдвиги на 1 позицию левой и правой части р10
        int [] ls1l = new int[l1.length];
        ls1l[0] = l1[1];
        ls1l[1] = l1[2];
        ls1l[2] = l1[3];
        ls1l[3] = l1[4];
        ls1l[4] = l1[0];
        int [] ls1r = new int[r1.length];
        ls1r[0] = r1[1];
        ls1r[1] = r1[2];
        ls1r[2] = r1[3];
        ls1r[3] = r1[4];
        ls1r[4] = r1[0];
        int [] k1 = new int[8]; перестановка р8
        k1[0] = ls1r[0];
        k1[1] = ls1l[2];
        k1[2] = ls1r[1];
        k1[3] = ls1l[3];
        k1[4] = ls1r[2];
        k1[5] = ls1l[4];
        k1[6] = ls1r[4];
        k1[7] = ls1r[3];
         генерация второго сабключа к2
        сдвиги на 2 позиции левой и правой части после первого сдвига
        int [] ls2l = new int[ls1l.length];
        ls2l[0] = ls1l[2];
        ls2l[1] = ls1l[3];
        ls2l[2] = ls1l[4];
        ls2l[3] = ls1l[0];
        ls2l[4] = ls1l[1];
        int [] ls2r = new int[ls1r.length];
        ls2r[0] = ls1r[2];
        ls2r[1] = ls1r[3];
        ls2r[2] = ls1r[4];
        ls2r[3] = ls1r[0];
        ls2r[4] = ls1r[1];
        int [] k2 = new int[8]; перестановка р8
        k2[0] = ls2r[0];
        k2[1] = ls2l[2];
        k2[2] = ls2r[1];
        k2[3] = ls2l[3];
        k2[4] = ls2r[2];
        k2[5] = ls2l[4];
        k2[6] = ls2r[4];
        k2[7] = ls2r[3];
        s-des шифрование
        1 этап IP перестановка РТ 2.6.3.1.8.5.7
        int [] IP = new int[8];
        IP[0] = PT[1];
        IP[1] = PT[5];
        IP[2] = PT[2];
        IP[3] = PT[0];
        IP[4] = PT[3];
        IP[5] = PT[7];
        IP[6] = PT[4];
        IP[7] = PT[6];
        2 этап делим на две части IP
        int[] lt = Arrays.copyOfRange(IP, 0, IP.length2);
        int[] rt = Arrays.copyOfRange(IP, IP.length2, IP.length);
        3 этап берем правую часть и делаем ЕР
        int[] EP = new int[8];
        EP[0] = rt[3];
        EP[1] = rt[0];
        EP[2] = rt[1];
        EP[3] = rt[2];
        EP[4] = rt[1];
        EP[5] = rt[2];
        EP[6] = rt[3];
        EP[7] = rt[0];
        4 этап делаем xor  с первым ключом
        int[] xor_k1 = new int[8];
        for(int i = 0;i EP.length;i++){
         xor_k1[i]=EP[i] ^ k1[i];
        }
        5 этап делим на S0 и S1
        int[] S0 = Arrays.copyOfRange(xor_k1, 0, xor_k1.length2);
        int[] S1 = Arrays.copyOfRange(xor_k1, xor_k1.length2, xor_k1.length);
        6 этап находим элементы в матрице
        int[] column0= new int[2];
        column0[0] =  S0[0];
        column0[1] = S0[3];
        int[] row0= new int[2];
        row0[0] =  S0[1];
        row0[1] = S0[2];
        int[] column1= new int[2];
        column1[0] =  S1[0];
        column1[1] = S1[3];
        int[] row1= new int[2];
        row1[0] =  S1[1];
        row1[1] = S1[2];
        final int[][] S0matrix = { {1,0,11,10} ,
                                   {11,10,1,0} ,
                                   {0,10,1,11} ,
                                   {11,1,11,1} } ;
        final int[][] S1matrix = { {1,1,10,11},
                                   {10,0,1,11},
                                   {11,0,1,0},
                                   {10,1,0,11}} ;
        int col0 = 0;
        if(column0[0] == 0 & column0[1]==0){
            col0 = 0;
        } else if (column0[0] == 0 & column0[1]==1){
            col0 = 1;
        } else if (column0[0] == 1 & column0[1]==0){
            col0 = 2;
        } else if (column0[0] == 1 & column0[1]==1){
           col0 = 3;
        }
        int col1=0;
        if(column1[0] == 0 & column1[1]==0){
            col1 = 0;
        } else if (column1[0] == 0 & column1[1]==1){
            col1 = 1;
        } else if (column1[0] == 1 & column1[1]==0){
           col1 = 2;
        } else if (column1[0] == 1 & column1[1]==1){
            col1 = 3;
        }
        int roww0 = 0;
        if(row0[0] == 0 & row0[1]==0){
            roww0 = 0;
        } else if (row0[0] == 0 & row0[1]==1){
            roww0 = 1;
        } else if (row0[0] == 1 & row0[1]==0){
            roww0 = 2;
        } else if (row0[0] == 1 & row0[1]==1){
            roww0 = 3;
        }
        int roww1=0;
        if(row1[0] == 0 & row1[1]==0){
             roww1 = 0;
        } else if (row1[0] == 0 & row1[1]==1){
            roww1 = 1;
        } else if (row1[0] == 1 & row1[1]==0){
            roww1 = 2;
        } else if (row1[0] == 1 & row1[1]==1){
            roww1 = 3;
        }
        int S0L = S0matrix[col0][roww0];
        int S0R = S1matrix[col1][roww1];
        int[] S0L1 = new int[2];
        if(S0L  10 ) {
            S0L1[0] = 0;
            S0L1[1] = S0L;
        }
        else {
            String[] str1 = Integer.toString(S0L).split();
            int [] arr1 = new int [str1.length];
            for(int i=0; i str1.length; i++) {
                arr1[i] = Integer.parseInt(str1[i]);
            }
            System.arraycopy(arr1,0,S0L1,0,2);
        }
        int[] S0R1 = new int[2];
        if (S0R  10 ) {
            S0R1[0] = 0;
            S0R1[1] = S0R;
        }
        else {
            String[] str2 = Integer.toString(S0R).split();
            int [] arr2 = new int [str2.length];
            for(int i=0; i str2.length; i++) {
                arr2[i] = Integer.parseInt(str2[i]);
            }
            System.arraycopy(arr2,0,S0R1,0,2);
        }
        7 этап перестановка Р4
        int[] P4=new int[4];
        P4[0]=S0L1[1];
        P4[1]=S0R1[1];
        P4[2]=S0R1[0];
        P4[3]=S0L1[0];
        8 этап xor результата Р4 и левой части после IP
        int[] xor_L = new int[4];
        for(int i = 0;i P4.length;i++){
            xor_L[i]=P4[i] ^ lt[i];
        }
        9 этап берем правую часть и делаем ЕР
        int[] EP2 = new int[8];
        EP2[0] = xor_L[3];
        EP2[1] = xor_L[0];
        EP2[2] = xor_L[1];
        EP2[3] = xor_L[2];
        EP2[4] = xor_L[1];
        EP2[5] = xor_L[2];
        EP2[6] = xor_L[3];
        EP2[7] = xor_L[0];
        10 этап xor результата EP и второго ключа
        int[] xor_k2 = new int[8];
        for(int i = 0;i EP2.length;i++){
            xor_k2[i]=k2[i] ^ EP2[i];
        }
        11 этап делим на S0 и S1
        int[] S02 = Arrays.copyOfRange(xor_k2, 0, xor_k2.length2);
        int[] S12 = Arrays.copyOfRange(xor_k2, xor_k2.length2, xor_k2.length);
        12 этап находим элементы в матрице
        int[] column00= new int[2];
        column00[0] =  S02[0];
        column00[1] = S02[3];
        int[] row00= new int[2];
        row00[0] =  S02[1];
        row00[1] = S02[2];
        int[] column11= new int[2];
        column11[0] =  S12[0];
        column11[1] = S12[3];
        int[] row11= new int[2];
        row11[0] =  S12[1];
        row11[1] = S12[2];
        int coll0 = 0;
        if(column00[0] == 0 & column00[1]==0){
            coll0 = 0;
        } else if (column00[0] == 0 & column00[1]==1){
            coll0 = 1;
        } else if (column00[0] == 1 & column00[1]==0){
            coll0 = 2;
        } else if (column00[0] == 1 & column00[1]==1){
            coll0 = 3;
        }
        int coll1=0;
        if(column11[0] == 0 & column11[1]==0){
            coll1 = 0;
        } else if (column11[0] == 0 & column11[1]==1){
            coll1 = 1;
        } else if (column11[0] == 1 & column11[1]==0){
            coll1 = 2;
        } else if (column11[0] == 1 & column11[1]==1){
            coll1 = 3;
        }
        int rowww0 = 0;
        if(row00[0] == 0 & row00[1]==0){
            rowww0 = 0;
        } else if (row00[0] == 0 & row00[1]==1){
            rowww0 = 1;
        } else if (row00[0] == 1 & row00[1]==0){
            rowww0 = 2;
        } else if (row00[0] == 1 & row00[1]==1){
            rowww0 = 3;
        }
        int rowww1=0;
        if(row11[0] == 0 & row11[1]==0){
            rowww1 = 0;
        } else if (row11[0] == 0 & row11[1]==1){
            rowww1 = 1;
        } else if (row11[0] == 1 & row11[1]==0){
            rowww1 = 2;
        } else if (row11[0] == 1 & row11[1]==1){
            rowww1 = 3;
        }
        int S0L2  = S0matrix[coll0][rowww0];
        int S0R2 = S1matrix[coll1][rowww1];
        int[] S0L12 = new int[2];
        if(S0L2  10 ) {
            S0L12[0] = 0;
            S0L12[1] = S0L2;
        }
        else {
            String[] str3 = Integer.toString(S0L2).split();
            int [] arr3 = new int [str3.length];
            for(int i=0; i str3.length; i++) {
                arr3[i] = Integer.parseInt(str3[i]);
            }
            System.arraycopy(arr3,0,S0L12,0,2);
        }
        int[] S0R12 = new int[2];
        if(S0R2  10 ) {
            S0R12[0] = 0;
            S0R12[1] = S0R2;
        }
        else {
            String[] str4 = Integer.toString(S0R2).split();
            int [] arr4 = new int [str4.length];
            for(int i=0; i str4.length; i++) {
                arr4[i] = Integer.parseInt(str4[i]);
            }
            System.arraycopy(arr4,0,S0R12,0,2);
        }
        13 этап перестановка Р4
        int[] P42=new int[4];
        P42[0]=S0L12[1];
        P42[1]=S0R12[1];
        P42[2]=S0R12[0];
        P42[3]=S0L12[0];
        14 этап xor результата Р42 и левой части
        int[] xor_L2 = new int[4];
        for(int i = 0;i P42.length;i++){
            xor_L2[i]=rt[i] ^ P42[i];
        }
        int [] IP1 = new int[8];
        IP1[0] = xor_L2[3];
        IP1[1] = xor_L2[0];
        IP1[2] = xor_L2[2];
        IP1[3] = xor_L[0];
        IP1[4] = xor_L[2];
        IP1[5] = xor_L2[1];
        IP1[6] = xor_L[3];
        IP1[7] = xor_L[1];
        System.out.println(cipher text +Arrays.toString(IP1));
    }
}
