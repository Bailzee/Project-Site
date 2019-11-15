package hello;

import java.util.*;

public class hellos {
	public static void main(String [] args) {


        String firstName = "Bailey";
        String lastName = "Gallitto";
        String prob;
        String ans;
        int diff = 2;
        int numCorr = 0;
        int numIncorr = 0;
        int score = 0;
        Boolean correct = false;
        Scanner next = new Scanner(System.in);
        
        
	
        //System.out.println(problem(diff).substring(7, 19));
        
        for (int i = 0; i <= 10; i++) {
        	prob = problem(diff);
        	if (diff == 1) {
        		ans = answer(prob.substring(7, 13), diff);
        		System.out.println(ans + " " + diff);
        	}
        	else {
        		ans = answer(prob.substring(7, 19), diff);
        		System.out.println(ans + " " + diff);
        	}
        	System.out.println(prob + "  SCORE: " + score);
        	correct = userAns(ans);
        	
        	
        	if (correct == true) {
        		numCorr += 1;
        		numIncorr -= numIncorr;
        		score += diff;
        		
        		if (numCorr == 2 && diff != 3) {
        			diff += 1;
        			numCorr -= 2;
        		}
        		
        		System.out.print("Enter next to continue: ");
        		next.next();
        	}
        	else {
        		numIncorr += 1;
        		numCorr -= numCorr;
        		
        		if (numIncorr == 2 && diff != 1) {
        			numIncorr -= 2;
        			diff -= 1;
        		}
        		
        		System.out.println("Don't forget, when solving an equation do add and sub before mult and divide.");
        		System.out.print("Enter next to continue: ");
        		next.next();
        	}
        }
    }
	
	private static int getRan(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static String problem(int diff) {
		String prob = new String();
		int x;
		int y;
		int z;
			if (diff == 1) {
				x = getRan(1, 9);
				y = getRan(1, 9);
				z = getRan(1, 9);

				prob = (x + "x+" + y + "=" + z);
			}
			else if (diff == 2) {
				x = getRan(10, 20);
				y = getRan(10, 20);
				z = getRan(30, 50);
				
				prob = (x + "x/" + y + "-" + (z-x) + "=" + z);
			}
			else {
				prob = "hi";
			}
		
		return ("Solve: " + prob + " and leave the solution as a fraction if necassary");
		}
	
	public static String answer(String prob, int diff) {
		String ans = new String();
		
		if (diff == 1) {
			int x = Integer.parseInt(prob.substring(0, 1));
			int y = Integer.parseInt(prob.substring(3, 4));
			int z = Integer.parseInt(prob.substring(5));
			int num = (z-y);
			int gcf = gcf(num, x);
			
			if ((z-y) == x) {
				ans = "1";
			}
			else if ((z-y) == (-1 * x)) {
				ans = "-1";
			}
			else if (x == 1){
				ans = Integer.toString((z-y));
			}
			else if (z-y == 0) {
				ans = "0";
			}
			else if ((z-y % x) == 0) {
				ans = Integer.toString((z-y)/x);
			}
			else {
				ans = (num/gcf + "/" + x/gcf);
			}
		}
		else if (diff == 2) {
			int x = Integer.parseInt(prob.substring(0, 2));
			int y = Integer.parseInt(prob.substring(4, 6));
			int z = Integer.parseInt(prob.substring(10));
			int w = (z-x);
			int num = (y*(z+w));
			int gcf = gcf(num, x);
			
			if (num == x) {
				ans = "1";
			}
			else if (x == 1){
				ans = Integer.toString(y*(z+w));
			}
			else if (y*(z+w) == 0) {
				ans = "0";
			}
			else if ((y*(z+w) % x) == 0) {
				ans = Integer.toString((num/x));
			}
			else {
				ans = (num/gcf + "/" + x/gcf);
			}
		}
		else {
			ans = "hi";
		}
		
		return ans;
	}
	
public static Boolean userAns(String ans) {
    	Boolean correct = false;
    	String ansUser;
	
    	Scanner ansSc = new Scanner(System.in);
    	
    	System.out.print("Enter your answer: ");
    	ansUser = ansSc.next();
    	
    	if (ansUser.contentEquals(ans)) {
    		correct = true;
    	}
    	
    	return correct;
    }
public static int gcf(int m, int n) {
	int gcf = 1;
	int lesser;
	int greater;
	
	if (m < n) {
		lesser = m;
		greater = n;
	}
	else {
		lesser = n;
		greater = n;
	}
	
	for (int x = 2; x < lesser; x++) {
		if (lesser % x == 0 && greater % x == 0) {
			gcf = x;
		}
	}
	
	return gcf;
}
	
}
