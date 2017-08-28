package webapp.test;

import java.util.Scanner;

public class Game {

	private char[] randomString;
	private int charSize = 5; 
	private int personScore = 100;
	private int errCutScore = 10;
	
	public void start(){
		randomString = new char[5];
		for(int i=0;i<charSize;i++){
			randomString[i] = (char)((int)(Math.random() * 26) + 97);
			System.out.print(randomString[i]+","); 
		}
		System.out.println();
		
		System.out.println("猜字母游戏，请输入五个任意字母:");
		while(true){
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String inString = scan.next();
			
			if(inString.equals("exit")){
				System.out.println("退出游戏.");
				break;
			}
			
			CharSequence cs = (CharSequence)inString;
			
			StringBuilder err = new StringBuilder();
			for(int i=0;i<cs.length()&&i<5;i++){
				char current = cs.charAt(i);
				if(randomString[i] != current){ 
					err.append((i+1)+",");
				}
			} 
			
			if(err.length() > 0){
				System.err.println(String.format("位置[%1$s]错误",err.toString()));
				personScore-=errCutScore;
				if(personScore <= 0){
					System.out.println("猜字母游戏的错误次数已经超过最大允许的次数，游戏结束！");
					break;
				}
			}else{
				System.out.println("恭喜你，猜对了字母，你的得分为"+personScore+"，游戏结束！");
				break;
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Game gm = new Game();
		gm.start();
	}
}


