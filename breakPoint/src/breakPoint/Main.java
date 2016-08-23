package breakPoint;

import java.util.Scanner;

public class Main
{
	
	
	public static void main(String[] args){
		int i;
		int flag = 0;
		boolean isDown = false;
		boolean nextIsDown = false;
		Scanner input1 = null;
		Scanner input2 = null;
		try
		{
			input1 = new Scanner(System.in);
			int dayNum = input1.nextInt();

			input2 = new Scanner(System.in);
			String day = input2.nextLine();
		 	char[] ch = day.toCharArray();
		 	if(ch.length != 2*dayNum-1){
		 		System.out.println("The day is to much.");
				System.exit(-1);
		 	}
		 	if(!Character.isDigit(ch[0]) && !Character.isSpaceChar(ch[0])){
	 			System.out.println("The day is not a numble.");
				System.exit(-1);
	 		}else{

				if(ch[0] > ch[2]){
					isDown = true;
				}else if(ch[0] < ch[2]){
					isDown = false;
				}else {
					System.out.println("The Day Num should not be the same.");
					System.exit(-1);
				}
	 		}
				
		 	for(i=2;i<ch.length-2;i+=2){
		 		if(!Character.isDigit(ch[i]) && !Character.isSpaceChar(ch[i])){
		 			System.out.println("The day is not a numble.");
					System.exit(-1);
		 		}else{

					if(ch[i] > ch[i+2]){
						nextIsDown = true;
					}else if(ch[i] < ch[i+2]){
						nextIsDown = false;
					}else {
						System.out.println("The Day Num should not be the same.");
						System.exit(-1);
					}
					
					if(nextIsDown != isDown){
						flag++;
					}
				isDown = nextIsDown;
		 		}
		 	}
		}catch (Exception e)
		{
			System.out.println("error!");
			System.exit(-1);
		}finally {
			System.out.println(flag);
			input1.close();
			input2.close();
		}
		
	}
}
