package Practice;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		String[][] arr=new String[2][2];
		arr[0][0]="a1";
		arr[0][1]="a2";
		arr[1][1]="b1";
		arr[1][2]="b2";
		
		for(int i=0;i<arr.length;i++) {
			 System.out.println(arr[i][i]);
		}
		
	}

}
