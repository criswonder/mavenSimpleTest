package com.hongyun.javaVo2flexVo;

public class MonthsGettor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getPeriodMonths(8, 8));
        
    }
    private static int[] getPeriodMonths(int start,int end){
        int[] arr = new int[12];
        int length;
        if(start<end){
            length = end - start +1;
            for(int i=0;i<length;i++){
                arr[i]=start;
                start++;
            }
        }else{
            length= 12-start+1+end;
            for(int j=0;j<length;j++){
                if(start%12==0)
                    arr[j]=12;
                else
                    arr[j]=start%12;
                start++;
            } 
        }
        return arr;
    }

}
