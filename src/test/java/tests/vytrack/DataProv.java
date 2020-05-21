package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.text.NumberFormat;
import java.util.*;

public class DataProv {

    @DataProvider(name= "Data2")
    public  Object[][] test(){

        return getData();
    }

    @Test(dataProvider = "Data2")
    public void testMy(@org.jetbrains.annotations.NotNull String[] s){

        System.out.println("Assert: "+s[0]+ " to :"+ s[1]);

    }

    List<String>webelements = new ArrayList<>(Arrays.asList("s","e","r","d","a","r"));

    public String[][] getData(){
        String data[][] = new String[webelements.size()][];
        int i = 0;
        for (String each :
                webelements) {

            data[i] = new String[]{(""+i),each};
            i++;
        }

        return data;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        int res=0;
        for (int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            int s=arr[i];
            if (s<0) res++;
            for (int j=i-1; j>=0; j--){
                s+=arr[j];
                if (s<0) res++;
            }
        }
        System.out.print(res);
    }
}



