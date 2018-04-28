package compilersscanner;
import java.io.*;
import java.util.*;


public class Mainprogram {
	public static Map<String, String> map = new HashMap();
	static BufferedReader buf;
	public static char ch;
	static String word, ty="" ;
	static int state= 0,line=1,type=1;
	static int i=1;

	public static void main(String[] args){
		
		
		try { 
			buf = new BufferedReader(new FileReader("input.txt"));
			for(int i= 0; i<409; i++){
				ch = (char) buf.read();
				System.out.print( ch );
			}
			buf.close();
			buf = new BufferedReader(new FileReader("input.txt"));
			Parser P= new Parser();
			P.parser();
			
			// System.out.println("Step \tToken  \t\t\t  Type \t\t\tLine no.");
			/* while(true){
				
					
					word = scanner();
					
					if(type==1){ty="key";}
					if(type==2){ty="const";}
					if(type==3){ty="id";}
					if(type==4){ty="S.S.";}
					if(type==5){ty="error: First character of an id cannot be a number";}
					if(type==6){ty="error: A number cannot have two decimal points";}
					if(type==7){ty="error: Its an illegal symbol";}
					if(type==8){ty="error: Reached end of file";}
					if(type==9){ty="error: Lexical analyser could not resolve this";}
					
					System.out.println(i+ "\t" +word+  "\t\t\t"  +ty+ "\t\t\t" +line); i++;
					
					
					
					if(ch == '$'){
						break;
					}
				
			} */
			
			System.out.println("\n SYMBOL TABLE \n ");
			System.out.println("\nToken \t  Type ");
			
			for(String key: map.keySet())
			{
				String value = map.get(key).toString();
				System.out.println(key + " \t "+ value);
				
			}
		    
		
		
			} catch (IOException e) {
			e.printStackTrace();
			
		}

	}	
	
	public static String scanner() throws IOException{
		
		String tok= "";
		ch  = (char) buf.read() ;
		
		state=0;
		
		while( ch  != '$')
			{
			
		    switch(state){
			
			case 0: 
				
			if(ch == 'p'){
				state= 1;tok+=ch;
				
				
			}
			
			else if(ch == 'i'){
				state= 23;tok+=ch;
				
							}
			
			else if(ch == 'a'){
				state= 31;tok+=ch;
				
				
			}
			
			else if(ch == 'f'){
				state= 41;tok+=ch;
				
				
			}
			
			else if(ch == 'c'){
				state= 50;tok+=ch;
				
				
			}
			
			else if(ch == 'o'){
				state= 58;tok+=ch;
				
				
			}
			
			else if(ch == 's'){
				state= 65;tok+=ch;
				
				
			}
			
			else if(ch == 'v'){
				state= 71;tok+=ch;
				
				
			}
			
			else if(ch == 'd'){
				state= 74;tok+=ch;
		
			
		
			}
			
			else if(ch == 'e'){
				state= 77;tok+=ch;
		
			}
			
			
			else if(ch == 'w'){
				state= 81;tok+=ch;
	
				
			}
			
			else if(ch == 'r'){
				state= 86;tok+=ch;
				
			}
			else if( ch == 'n'){
				state = 92;tok+=ch;
				
			}
			else if( ch == 'b'){
				state= 111;tok+=ch;
				
			}
			else if( ch == 't'){
				state= 95;tok+=ch;
				
			}
			else if( ch == '<'){
				state= 99;tok+=ch;
				
			}
			else if( ch == '='){
				state = 101;tok+=ch;
				
			}
			else if( ch == '.'){
				state = 103;tok+=ch;
						}
			else if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'){
				state = 104;tok+=ch;
				
			}
			else if( ch ==';' || ch == '{' || ch == '}' || ch =='(' || ch ==')'||ch == ':' || ch == ',' ||ch =='+' ||ch == '*'||ch == '@'){
				state = 106; tok+=ch;
			
			}
			
			else if( ch == '#'){
				state=106;
			} 
			
			else if(ch ==' '|| ch== '\t'||ch== '\t'){
				ch=(char) buf.read(); 
								
				
				
			
	           state=0;
			}
			else if(ch=='\r'){
				//ch = (char) buf.read();
				ch=(char) buf.read(); state=0;
				
				
			}
			else if(ch== '\n'){
				//ch = (char) buf.read();
				ch=(char) buf.read(); state=0;
				
				line++;
			}
				
				
			
			else if(ch =='f'||ch =='g'||ch =='h'||ch =='j'||
					ch =='k'||ch =='l'||ch =='m'||ch =='u'||ch =='x'||ch =='y'||ch =='z'){
				state= 107;tok+=ch;
			}
			
			else{
				
				state = 0; 
				tok+=ch; 
				type=errorhandler(ch);
				return tok;
				}
			
			
			break;
			
			case 1: buf.mark(1);
			ch=(char) buf.read(); 
			        if(ch== 'a') state=2;
			        else if(ch== 'r') state=8;
			        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
			        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
			        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'|| ch=='\r'){
			        	buf.reset();
				           state = 0;
				           type=1;
				           bookkeeper(tok, "identifier");
				           return tok;
				           }
			        else{ 
			        	state=0; tok+=ch; type=errorhandler(ch);
			        	return tok;}
			        
			        tok+=ch;
			        break;
				
			case 2: buf.mark(1);
			ch=(char) buf.read(); 
	                if(ch== 'c') state=3;
	                else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
			        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	                else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
			        	buf.reset();
				           state = 0;
				           type=1;
				           
				           bookkeeper(tok, "identifier");
				           return tok;}
			        else{
			        	state=0; 
			        	tok+=ch; 
			        	type=errorhandler(ch);
		        	return tok;}
	                tok+=ch;
	                break;
	        
			case 3: buf.mark(1);
			ch=(char) buf.read(); 
	                if(ch== 'k') state=4;
	                else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='l'||ch =='m'||
			        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	                else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
			        	buf.reset();
				           state = 0;
				           type=1;
				           
				           bookkeeper(tok, "identifier");
				           return tok;}
			        else{state=0; tok+=ch; type=errorhandler(ch);
		        	return tok;}
	        tok+=ch;
	        break;
				
			case 4:buf.mark(1);
				ch=(char) buf.read(); 
		        if(ch== 'a') state=5;
		        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
		        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
		        	buf.reset();
			           state = 0;
			           type=1;
			           
			           bookkeeper(tok, "identifier");
			           return tok;}
		        else{ 
		        	state=0; 
		        	tok+=ch; 
		        	type=errorhandler(ch);
	        	return tok;}
		        tok+=ch;
		        break;
		        
			case 5:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'g') state=6;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; 
	        tok+=ch; 
	        type=errorhandler(ch);
        	return tok;}
	        tok+=ch;
	        break;
			
			case 6:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=7;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           type=1;
		           return tok;}
	        
	        else{state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}
	        tok+=ch;
	        break;
	        
			case 7:  buf.mark(1);
			         ch = (char) buf.read();
			
			         if(ch==' '||ch=='\n'||ch=='\r'){
			        	  
				          
			        	 state = 0;				      
			        	 buf.reset(); 
			        	 type=3;
			        	 
			        	 return tok;
			
				     } 
			
			        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
				       
				       
				       buf.reset();
			           state = 0;bookkeeper(tok, "identifier");
			           return tok;
				      } 
			         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
				        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107; tok+=ch;}*/
			         
			         
			         
			         break;

				
			case 8: buf.mark(1);
			ch=(char) buf.read(); 
	                if(ch== 'o') state=9;
	                else if(ch== 'i') state=16;
	                else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
			        		ch =='n'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	                else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
			        	buf.reset();
				           state = 0;
				           type=1;
				           
				           bookkeeper(tok, "identifier");
				           return tok;}
			        else{ state=0; 
			        tok+=ch; 
			        type=errorhandler(ch);
		        	return tok;}tok+=ch;
	                break;
	                
			case 9:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=10;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 10:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=11;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 11:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'c') state=12;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}  tok+=ch;
	        break;
	        
			case 12:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=13;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}  tok+=ch;
	        break;
	        
			case 13:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=14;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 14:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'd') state=15;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 15: buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; 
				           type=9;
				           
				           return tok;
			       
		     } 
	
	         /*if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;bookkeeper(tok, "identifier");
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107; tok+=ch;} */
	         
	         break;
				
			case 16:buf.mark(1);
			ch=(char) buf.read(); 
            if(ch== 'v') state=17;
            else if(ch== 'n') state=21;
            else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
            else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
            break;
				
			case 17:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'a') state=18;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}  tok+=ch;
	        break;
	        
			case 18:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=19;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 19:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=20;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}  tok+=ch;
	        break;
	        
			case 20:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=8;
				           
				           return tok;
			      
		     } 
	
	         /*if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		     
		       buf.reset();
	           state = 0;type=3;bookkeeper(tok, "identifier");
	           return tok;
		      }
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;} */
	         break;
		      
			case 21:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=22;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 22:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	
			        	buf.reset();
				           state = 0;
				           type=21;
				           
				           return tok;
			        
		     } 
	
	         /*if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;bookkeeper(tok, "identifier");
	           return tok;
		      }
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107; tok+=ch;} */
	         break;
		      
			case 23:buf.mark(1);
			ch=(char) buf.read(); 
            if(ch== 'm'){ state=24;tok+=ch;}
            else if(ch== 'f') {state=29;tok+=ch;}
            else if(ch== 'n') {state=30; tok+=ch;}           
            else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||
	        		ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}
            else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'||ch==')'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ 
	        	state=0; tok+=ch; type=errorhandler(ch);
	        	return tok;}
            
            break;
            
			case 24:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'p') state=25;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 25:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'o') state=26;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 26:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'r') state=27;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 27:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=28;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 28:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; 
				           type=4;
				         
				           return tok;
			        
		     } 
	
	        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;type=1;bookkeeper(tok, "identifier");
	           return tok;
		      }
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch; */
	         break;
		      
			case 29:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=15;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;type=15;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107; tok+=ch;}
	         break;
		      
			case 30:buf.mark(1);
	         ch = (char) buf.read();
	         if(ch== 't'){ state=108;tok+=ch;}
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;
				           type=20;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=20;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.'){ state=107;tok+=ch;}
	         break;
		      
			case 31:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'b') state=32;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
	        	type=1;
	        	bookkeeper(tok, "identifier");
		           state = 0;
		           
		           return tok;}
	        else{ 
	        	state=0; 
	        tok+=ch; 
	        type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 32:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 's') state=33;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           type=1;
		           bookkeeper(tok, "identifier");
		           return tok;}
	        else{
	        	state=0; 
	        	tok+=ch; 
	        	type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 33:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=34;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
	        	type=1;
	        	bookkeeper(tok, "identifier");
		           state = 0;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}  tok+=ch;
	        break;
	        
			case 34:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'r') state=35;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;type=1;bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 35:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'a') state=36;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;type=1;bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 36:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'c') state=37;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;type=1;bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 37:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=38;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;type=1;bookkeeper(tok, "identifier");
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 38:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=5;
				           return tok;
			        
		     } 
	
	        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;type=1; bookkeeper(tok, "identifier");
	           return tok;
		      } else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}*/
	         break;
		      
			case 39:
				buf.mark(1);
				ch=(char) buf.read(); 
	        if(ch== 'd') state=40;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 40:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=26;
				           return tok;
			        
		     } 
	
	         /*if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;bookkeeper(tok, "identifier");type=1;
	           return tok;
		      }else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}*/
	         break;
		      
			case 41:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'i') state=42;
	        else if(ch=='a') state=46; 
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;   
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 42:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'n') state=43;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 43:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'a') state=44;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 44:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=45;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 45:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;
				           type=6;
				           return tok;
			        
		     } 
	
	         /*if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;bookkeeper(tok, "identifier");type=1;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}*/
	         break;
		      
			case 46:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=47;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 47:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 's') state=48;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 48:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=49;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 49:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;
				           type=25;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}
	         break;
		      
			case 50:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=51;
	        else if(ch=='a') state=55; 
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           bookkeeper(tok, "identifier");
		           type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 51:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'a') state=52;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");
		           type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 52:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 's') state=53;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 53:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 's') state=54;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 54:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=10;
				           return tok;
			        
		     } 
	
	        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'||ch=='{'|| ch=='}'){
		       
		       
		       buf.reset();
	           state = 0;bookkeeper(tok, "identifier");type=1;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}*/
	         
	         break;
		      
			case 55:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 's') state=56;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 56:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=57;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 57:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=18;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;type=18;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}
	         break;
		      
			case 58:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'b') state=59;
	        else if(ch=='r') state=64;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 59:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'j') state=60;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}  tok+=ch;
	        break;
	        
			case 60:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=61;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 61:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'c') state=62;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 62:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=63;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 63:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;
				           type=11;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=11;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}
	         break;
	        
			case 64:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=27;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=27;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}
	         break;
	        
		      
			case 65:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=66;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{state=0; tok+=ch; type=errorhandler(ch);
        	return tok;}tok+=ch;
	        break;
	        
			case 66:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'a') state=67;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 67:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=68;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
				
			case 68:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=69;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 69:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'd') state=70;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
        	return tok;} tok+=ch;
	        break;
	        
			case 70:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	
			        	buf.reset();
				           state = 0;
				           type=7;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=7;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}
	         break;
	        
			case 71:buf.mark(1);
			ch=(char) buf.read(); 
		        if(ch== 'a') state=72;
		        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
		        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
		        	buf.reset();
			           state = 0;bookkeeper(tok, "identifier");type=1;
			           return tok;}
		        else{ state=0; tok+=ch; type=errorhandler(ch);
	        	return tok;}  tok+=ch;
		        break;
		        
			case 72:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=73;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 73:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=12;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=12;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;
	         tok+=ch;}
	         break;
	        
			case 74:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=75;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 75:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'f') state=76;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 76:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	
			        	buf.reset();
				           state = 0; type=13;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=13;
	           return tok;
		      } 
	         /*else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;
	         tok+=ch;}*/
	         break;
	        
			case 77:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=78;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 78:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 's') state=79;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 79:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=80;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 80:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=16;
				           return tok;
			        
		     } 
	
	        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;type=16;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.'){ state=107;
	         tok+=ch;} */
	         break;
	        
			case 81:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'h') {state=82; tok+=ch;}
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        
	        else if(ch==')'){
	        	buf.reset();
	        	state=0;bookkeeper(tok, "identifier");type=1;
	        	return tok;
	        }
	       // else{state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}tok+=ch;
	        break;
	        
			case 82:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'i') state=83;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 83:
				buf.mark(1);
				ch=(char) buf.read(); 
	        if(ch== 'l') state=84;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 84:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=85;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 85:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=17;
				           return tok;
			        
		     } 
	
	        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;bookkeeper(tok, "identifier");type=17;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;
	         tok+=ch;}*/
	         break;
	        
			case 86:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=87;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	       // else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 87:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=88;
	        if(ch=='a') state=109;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 88:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'u') state=89;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 89:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'r') state=90;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 90:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'n') state=91;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 91:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=22;
				           return tok;
			        
		     } 
	
	        /* if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=22;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.'){ state=107;tok+=ch;}*/
	         break;
	        
			case 92:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'o') state=93;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 93:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 't') state=94;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 94:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=23;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0; type=23;
	           return tok;
		      } 
	         else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;
	      tok+=ch;}
	         break;
	        
			case 95:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'r') state=96;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
			case 96:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'u') state=97;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 97:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'e') state=98;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	        
			case 98:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=24;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0; type=24;
	           return tok;
		      } 
	        /* else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}*/
	         break;
	        
			case 99:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== '=') state=100;
	        
	        else{
	        	buf.reset();
		           state = 0; type=errorhandler(ch);
		           return tok;
	        }tok+=ch;
	        break;
	        
			case 100:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=14;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'||ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=14;
	           return tok;
		      } 
	         //else{state=0; tok+=ch; type=errorhandler(ch);
	        	//return tok;}
	         
	        
			case 101:buf.mark(1);
				ch=(char) buf.read(); 
	            if(ch== '>')
	            {
	            	state=102;
	            	tok+=ch;}
	            
	            else if(ch==' ') {
	            	state=106;
	            }
	            else{
	            	buf.reset();
	            state=0; type=errorhandler(ch);
	            return tok;}
	            
	        break;
	        
			case 102:buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=19;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'||ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.'){
		       
		       
		       buf.reset();
	           state = 0;type=19;
	           return tok;
		      } 
	         
	        	 else{
	 	        	type=errorhandler(ch);
	 		           state = 0;
	 		           return tok;
	 	        }
	         
	        
			case 103:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9') state=105;
	        else{
	        	type=errorhandler(ch);
		           state = 0;
		           return tok;
	        }
	        tok+=ch;
	        break;
	        
			case 104: buf.mark(1); 
				ch=(char) buf.read(); 
		        if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9') {state=104; tok+=ch;}
		        
		        else if(ch== '.') {state = 105;tok+=ch; }
		        
		        else if( ch== ' '|| ch== '\n'){
		        	buf.reset();
		        	state=0; bookkeeper(tok, "constant");type=2;
		        	return tok;
		        	}
		        else if(ch == '#' || ch ==';' || ch == '{' || ch == '}' || ch =='(' ||ch == ':' || ch == ',' ||ch =='+' ||ch == '*'||ch == '@'){
		        	buf.reset();
		        	state=0;
		        	bookkeeper(tok, "identifier");type=2;
		        	return tok;
		        }
		        else if( ch ==')'){
		        	buf.reset();
		        	state=0;
		        	bookkeeper(tok, "constant");type=2;
		        	return tok;
		        }
		        
		        else{
		        	
		        	state=0; tok+=ch; type=errorhandler(ch);
		        	return tok;
		        }
		        
			       
		        break;
		        
			case 105: buf.mark(1); 
				ch=(char) buf.read(); 
	        if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9') {state=105; tok+=ch;}
	        
	        else if( ch== ' '|| ch== '\n'){
		        	buf.reset();
			           state = 0;bookkeeper(tok, "constant");type=2;
			           return tok;
		        
	        }
	        else if(ch=='.'){
	        	type=errorhandler(ch);
	        	while(ch!=')'){
	        		
	        	tok+=ch; 
	        	buf.mark(1);
	        	ch= (char) buf.read();
	        	}
	        	state=0;
	        
	          
	           
	        	return tok;
	        	}   
	        
	        break;
	
			case 106:  buf.mark(1);
	        
			if(ch== '#'){
	        	while(ch!= '\n'){
	        		ch= (char) buf.read();
	        	}
	        }
	        
			else if( ch ==';') {
	        
	        	state =0;  type=31;
			     return tok; 
			     
			     }

			else if(ch == '{'  ) {
		        
	        	state =0;  type=32;
			     return tok; 
			     
			     }
			else if(ch == '}'  ) {
		        
	        	state =0;  type=33;
			     return tok; 
			     
			     }
			else if( ch =='(' ) {
		        
	        	state =0;  type=34;
			     return tok; 
			     
			     }
			else if(ch ==')' ) {
		        
	        	state =0;  type=35;
			     return tok; 
			     
			     }
			else if(ch == ':'  ) {
		        
	        	state =0;  type=36;
			     return tok; 
			     
			     }
			else if(ch == ','  ) {
		        
	        	state =0;  type=37;
			     return tok; 
			     
			     }
			else if( ch == '=') {
		        
	        	state =0;  type=38;
			     return tok; 
			     
			     }
			else if(ch =='+' ) {
		        
	        	state =0;  type=39;
			     return tok; 
			     
			     }
			else if(ch =='*' ) {
		        
	        	state =0;  type=40;
			     return tok; 
			     
			     }
			else if(ch == '@') {
		        
	        	state =0;  type=41;
			     return tok; 
			     
			     }

	        else if(  ch=='\n') {
	        
		           state = 0;
		            
		           line++;
		           
		           }
	        else if( ch== ' ') {
		        
		           state = 0;
		           buf.reset();type=4;
		           return tok; 
		           }
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
			
	        break;
		      
		     
		       
	        case 107:buf.mark(1);
	        	ch=(char) buf.read();
	        	
	        if(ch== '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9') {state=107;tok+=ch;}
	        else if (ch =='.') {state=107;tok+=ch;}
	        else if (ch =='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch =='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z') {state= 107;tok+=ch;}
	        else {
	        	buf.reset();
	        	state=0;
	        	bookkeeper(tok, "identifier");type=1;
	        	
	        	return tok;
	        	}   
	        
	        break;
	        	
	        case 111:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'o') state=112;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;
		           bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;}
	        tok+=ch;
	        break;
	        
	        case 112:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'o') state=113;
	       /* else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
		        	return tok;}*/
	        tok+=ch;
	        break;
	        
				
	        case 113:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=114;
	       /* else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='o'||ch =='m'||
	        		ch =='n'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        else{ state=0; tok+=ch; type=errorhandler(ch);
		        	return tok;}*/
	        tok+=ch;
	        break;
				
	        case 114: buf.mark(1);
	         ch = (char) buf.read();
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;type=30;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;type=30;
	           
	           return tok;
		      } 
	        /* else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.'){ state=107;
	         tok+=ch;}*/
	         break;
			
	        case 108:buf.mark(1);
	         ch = (char) buf.read();
	         
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0;
				           type=28;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0;
	           type=28;
	           return tok;
		      } 
	        /* else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;tok+=ch;}*/
	         break;
	         
	        case 109:buf.mark(1);
			ch=(char) buf.read(); 
	        if(ch== 'l') state=110;
	        else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
	        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
	        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') state=107;
	        else if( ch== ' '|| ch=='\n'|| ch==','||ch==';'|| ch==':'){
	        	buf.reset();
		           state = 0;bookkeeper(tok, "identifier");type=1;
		           return tok;}
	        //else{ state=0; tok+=ch; type=errorhandler(ch);
        	//return tok;} 
	        tok+=ch;
	        break;
	         
	        case 110:buf.mark(1);
	         ch = (char) buf.read();
	         
				
	         if(ch==' '||ch=='\n'||ch=='\r'){
	        	 
			        	buf.reset();
				           state = 0; type=29;
				           return tok;
			        
		     } 
	
	         if(ch==':'||ch==','||ch==';'||ch=='('||ch==')'||ch=='='||ch=='<'||ch=='>'||ch=='+'||ch=='*'||ch=='@'){
		       
		       
		       buf.reset();
	           state = 0; type=29;
	           return tok;
		      } 
	        /* else if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9'
		        		||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z'|| ch=='.') {state=107;
	        tok+=ch;}*/
	         break;
	        
	        
       } // switch case ends
       
			
			} //while loop ends

		return tok;
     }
	public static int errorhandler(char ch){
		
	
		if(ch=='.') return 6;
			
		else if(ch=='a'||ch=='b'||ch=='c'||ch=='d'||ch=='e'||ch=='f'||ch=='g'||ch=='h'||ch=='i'||ch=='j'||ch=='k'||ch=='l'||ch=='m'||
					ch=='n'||ch=='o'||ch=='p'||ch=='q'||ch=='r'||ch=='s'||ch=='t'||ch=='u'||ch=='v'||ch=='w'||ch=='x'||ch=='y'||ch=='z') return 5;
			
		else if (ch== '$') return 8;
		
		else if (ch != '#' || ch !=';' || ch != '{' || ch != '}' || ch !='(' || ch !=')'||ch != ':' || ch != ',' ||ch !='+' ||ch != '*'||ch != '@') return 7;
		
		else return 9;
		
}
	
	
	public static void bookkeeper(String token, String type){
		if(!map.containsKey(token))
			map.put(token, type);
	}
}