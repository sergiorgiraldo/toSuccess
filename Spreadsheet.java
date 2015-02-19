package quantcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Spreadsheet {
	
static HashMap<String, String> sheet=new HashMap<>();// for lookup

public static double evalRPN(String[] tokens, String colname,ArrayList<String> check) {
    Stack<Double> aux=new Stack<Double>();
    for(String s:tokens){
        if(s.matches("-?\\d+")){// integer
            aux.push((double) Integer.parseInt(s));
        }else if(s.matches("^[A-Z].*")){// colname
        	check.add(s);
        	if(check.contains(colname)){
        		System.out.println("Interval circle dependency!");
            	System.exit(1);
        	}
        	String[] deref=sheet.get(s).split(" ");
        	double interval;
        	if(deref.length==1&&deref[0].matches("[+-]?\\d*\\.?\\d+")){
        		interval=Double.parseDouble(deref[0]);
        	}else{
        	interval=evalRPN(deref, s, check);
        	}
        	aux.push(interval);
        	sheet.put(s, Double.toString(interval));
       	
        }else if(s.matches("[*-+/]")){
            if(aux.size()<2)
                return -1.0;
            Double right=aux.pop();
            Double left=aux.pop();
            Double val= 0.0;
            if(s.equals("+")){
                val=left+right;
            }else if(s.equals("-")){
                val=left-right;
            }else if(s.equals("*")){
                val=(double)left*right;
            }else if(s.equals("/")){
                val=(double)left/right;
            }
            aux.push(val);
        }else{
        	System.out.println("Invalid Input, not match any operator, number or colname");
        	System.exit(1);
        }
    }
    return aux.pop();    
}

public static void main(String[] args) throws IOException{
	int row = 0, col = 0;
	String[][] input = null;
	String firstline[];
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	firstline = in.readLine().split(" ");
	if (firstline.length < 2) {
			System.out.println("firstline input error");
			System.exit(1);
	}
	col = Integer.parseInt(firstline[0]);
	row = Integer.parseInt(firstline[1]);
	if (row >=1 && row<=26 && col>0) {
			input = new String[row][col];
	} else {
			System.out.println("row or col not qualified");
			System.exit(1);
	}
	
	char c = 'A';
	String tmp;
	for (int i = 0; i < row; ++i) {
		for (int j = 0; j < col; ++j) {
			tmp = in.readLine();
			if ( tmp!= null) {
				String colname = "" + c + (j + 1);
				
				input[i][j] = tmp;
				sheet.put(colname, tmp);
			} else {
				System.out.println("Data not match the number of row and column");
				System.exit(1);
			}
		}
		c = (char) (c + 1);
	}

	c = 'A';
	System.out.println(col + " " + row);
	for (int i = 0; i < row; ++i) {
		for (int j = 0; j < col; ++j) {
			String colname = "" + c + (j + 1);
			ArrayList<String> check =new ArrayList<>();
			double res = evalRPN(input[i][j].split(" "), colname, check);
			System.out.println(String.format("%.5f", res));
		}
		c = (char) (c + 1);
	}


	}
}

