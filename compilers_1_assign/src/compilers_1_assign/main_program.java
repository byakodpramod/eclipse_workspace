package compilers_1_assign;
import java.io.*;
import java.util.*;
public class main_program 
{
	static BufferedReader buf_temp, buf;
	static int state= 1,type=0,error=0;
	public static char ch;
	public static boolean status = true;
	public static Map<String, String> map = new HashMap();
	public static String [] type_list= {"Keyword","Identifier","Constant","String","Special Symbol","This is a country where we speak English","I’m really rich, part of the beauty of me is I’m very rich","Trump doesn’t want to hear it"};
	public static void main(String[] args)
	{
		try 
		{ 
			buf_temp = new BufferedReader(new FileReader("source_code"));
			System.out.println("=============");
			System.out.printf("%s","FILE CONTENT");
		    System.out.println();
		    System.out.println("=============");
			for(String line; (line = buf_temp.readLine()) != null;)
			{
				if(!(line.equals("$")))
				{
					System.out.print(line+"\n");
				}
			}
			buf_temp.close();
			buf = new BufferedReader(new FileReader("source_code"));
			parser_final P= new parser_final();
			P.parser();
//			System.out.println();
//			System.out.println("======");
//			System.out.printf("%s","OUTPUT");
//		    System.out.println();
//		    System.out.println("======");
//			System.out.println("==================================================================================");
//		    System.out.printf("%s %15s %s %60s %s","|","TOKEN","|","TYPE","|");
//		    System.out.println();
//		    System.out.println("==================================================================================");
//			while (type != 8)
//			{
//				String temp_tok = scanner();
//				if (ch!='$')
//				{
//					System.out.printf("%s %15s %s %60s %s","|",temp_tok,"|",type_list[type-1],"|");
//					System.out.println();
//					System.out.println("----------------------------------------------------------------------------------");
//				}
//			}
//			System.out.println();
//			System.out.println();
		    System.out.printf("%36s","SYMBOL TABLE");
		    System.out.println();
			System.out.println("==============================================================");
		    System.out.printf("%s %15s %s %40s %s","|","TOKEN","|","TYPE","|");
		    System.out.println();
		    System.out.println("==============================================================");
			for(String key: map.keySet())
			{
				String value = map.get(key).toString();
				System.out.printf("%s %15s %s %40s %s","|",key,"|",value,"|");
				System.out.println();
				System.out.println("--------------------------------------------------------------");
			}
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	} //end of main() function
	
	public static String scanner() throws IOException
	{
		String token = ""; 
		ch = (char) buf.read();
		state=1;
		while (status = true)
		{
			switch(state)
			{
			case 1:
				if(Character.toLowerCase(ch) == 'm')
				{
					state = 2; token+=ch;		
				}
				else if(Character.toLowerCase(ch) == 'p')
				{
					state = 9; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'g')
				{
					state = 23; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'a')
				{
					state = 28; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'n')
				{
					state = 49; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'b')
				{
					state = 57; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'i')
				{
					state = 42; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'e')
				{
					state = 45; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'l')
				{
					state = 64; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 't')
				{
					state = 73; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 's')
				{
					state = 81; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'f')
				{
					state = 84; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'o')
				{
					state = 88; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'c' || Character.toLowerCase(ch) == 'd' || Character.toLowerCase(ch) == 'h' || Character.toLowerCase(ch) == 'j' || Character.toLowerCase(ch) == 'k' || Character.toLowerCase(ch) == 'q' || Character.toLowerCase(ch) == 'r' || Character.toLowerCase(ch) == 'u' || Character.toLowerCase(ch) == 'v' || Character.toLowerCase(ch) == 'w' || Character.toLowerCase(ch) == 'x' || Character.toLowerCase(ch) == 'y' || Character.toLowerCase(ch) == 'z')
				{
					state = 100; token+=ch;
				}
				else if(ch == '#')
				{
					state=90;
				} 
				else if(ch ==' '|| ch == '\t')
				{
					ch=(char) buf.read(); 
					state=1;
				}
				else if(ch=='\r')
				{
					ch=(char) buf.read(); 
					state=1;
				}
				else if(ch== '\n')
				{
					ch=(char) buf.read(); 
					state=1;
				}
				else if(ch ==',' || ch == ':' || ch== ';' || ch== '!' || ch=='?' || ch=='(' || ch==')')
				{
					state = 91; token+=ch;
				}
				else if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 92; token+=ch;	
				}
				else if(ch == '“')
				{
					state = 99; token+=ch;
				}
				else
				{
					state = 1; 
					token+=ch; 
					error = 3;
					type=errorhandler(error);
					return token;
				}
				break;
				
			case 2:
				buf.mark(1);
				ch = (char) buf.read();
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 3; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'o')
				{
					state = 6; token+=ch;
				}
				break;
				
			case 3:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'k')
				{
					state = 4; token+=ch;
				}
				break;
				
			case 4:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 5; token+=ch;
				}
				break;
				
			case 5:
				buf.mark(1);
				ch = (char) buf.read();
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
				
		        break;
			case 6:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 7; token+=ch;
				}
				break;
				
			case 7:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 8; token+=ch;
				}
				break;
				
			case 8:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        	//String token1 =""+ch;
			        return token;
		        	}
		        break;
		        
			case 9:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 10; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'l')
				{
					state = 20; token+=ch;
				}
		        break;
		        
			case 10:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'o')
				{
					state = 11; token+=ch;
				}
				break;
				
			case 11:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'g')
				{
					state = 12; token+=ch;
				}
				break;
				
			case 12:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 13; token+=ch;
				}
				break;
				
			case 13:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 14; token+=ch;
				}
				break;
				
			case 14:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'm')
				{
					state = 15; token+=ch;
				}
				break;
				
			case 15:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'm')
				{
					state = 16; token+=ch;
				}
				break;
				
			case 16:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'i')
				{
					state = 17; token+=ch;
				}
				break;
				
			case 17:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'n')
				{
					state = 18; token+=ch;
				}
				break;
				
			case 18:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'g')
				{
					state = 19; token+=ch;
				}
				break;
				
			case 19:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        	//String token1 =""+ch;
			        return token;
		        	}
		        break;
		        
			case 20:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'u')
				{
					state = 21; token+=ch;
				}
				break;
				
			case 21:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 's')
				{
					state = 22; token+=ch;
				}
				break;
				
			case 22:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 23:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 24; token+=ch;
				}
				break;
				
			case 24:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 25; token+=ch;
				}
				break;
			
			case 25:
				buf.mark(1);
				ch = (char) buf.read();			
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 26; token+=ch;
				}
				break;
				
			case 26:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 't')
				{
					state = 27; token+=ch;
				}
				break;
				
			case 27:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
				else { status = false; type=1; return token; }
		        
			case 28:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'n')
				{
					state = 29; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'g')
				{
					state = 31; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'm')
				{
					state = 35; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 's')
				{
					state = 41; token+=ch;
				}
				else if(ch == ' ') 
				{
	        			state=1;
	        			type=2;
	        			bookkeeper(token, type_list[type-1]);
	        			buf.reset();
	        			return token;
				}
				break;
			
			case 29:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'd')
				{
					state = 30; token+=ch;
				}
				break;
				
			case 30:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		       
			case 31:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 32; token+=ch;
				}
				break;
				
			case 32:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'i')
				{
					state = 33; token+=ch;
				}
				break;
			
			case 33:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'n')
				{
					state = 34; token+=ch;
				}
				break;
				
			case 34:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 35:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 36; token+=ch;
				}
				break;
				
			case 36:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 37; token+=ch;
				}
				break;
			
			case 37:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'i')
				{
					state = 38; token+=ch;
				}
				break;
				
			case 38:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'c')
				{
					state = 39; token+=ch;
				}
				break;
				
			case 39:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 40; token+=ch;
				}
				break;
				
			case 40:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 41:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r'||ch==',')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        }
				else
		        {
		        		buf.reset();
		        		state=1;
		        		type=5;
		        		return token;
		        	}
		        
			case 42:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 's')
				{
					state = 43; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'f')
				{
					state = 44; token+=ch;
				}
				break;
				
			case 43:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 44:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
				
		        
			case 45:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'l')
				{
					state = 46; token+=ch;
				}
				break;
				
			case 46:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 's')
				{
					state = 47; token+=ch;
				}
				break;
				
			case 47:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 48; token+=ch;
				}
				break;
				
			case 48:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 49:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'u')
				{
					state = 50; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'o')
				{
					state = 55; token+=ch;
				}
				else
				{
					state=100; token+=ch;
				}
				break;
				
			case 50:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'm')
				{
					state = 51; token+=ch;
				}
				break;
				
			case 51:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'b')
				{
					state = 52; token+=ch;
				}
				break;
				
			case 52:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 53; token+=ch;
				}
				break;
				
			case 53:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 54; token+=ch;
				}
				break;
				
			case 54:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r'||ch==';')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
				else if(Character.toLowerCase(ch) =='s')
				{
					state=101; token+=ch;
				}
		        break;
		        
			case 55:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 't')
				{
					state = 56; token+=ch;
				}
				break;
				
			case 56:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 57:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'o')
				{
					state = 58; token+=ch;
				}
				else if(ch == ' ' || ch==';') 
				{
	        			state=1;
	        			type=2;
	        			bookkeeper(token, type_list[type-1]);
	        			buf.reset();
	        			return token;
				}
				break;
				
			case 58:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'o')
				{
					state = 59; token+=ch;
				}
				break;
				
			case 59:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'l')
				{
					state = 60; token+=ch;
				}
				break;
				
			case 60:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 61; token+=ch;
				}
				break;
				
			case 61:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 62; token+=ch;
				}
				break;
				
			case 62:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'n')
				{
					state = 63; token+=ch;
				}
				break;
				
			case 63:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r'||ch==';')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 64:
				buf.mark(1);
				ch = (char) buf.read();			
				if(Character.toLowerCase(ch) == 'o')
				{
					state = 65; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'i')
				{
					state = 68; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'e')
				{
					state = 70; token+=ch;
				}
				break;
				
			case 65:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'n')
				{
					state = 66; token+=ch;
				}
				break;
				
			case 66:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'g')
				{
					state = 67; token+=ch;
				}
				break;
				
			case 67:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 68:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 69; token+=ch;
				}
				break;
				
			case 69:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r' || ch==';')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
				else
		        {
		        		buf.reset();
		        		state=1;
		        		type=5;
		        		return token;
		        	}
		        
			case 70:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 's')
				{
					state = 71; token+=ch;
				}
				break;
				
			case 71:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 's')
				{
					state = 72; token+=ch;
				}
				break;
				
			case 72:
				buf.mark(1);
				ch = (char) buf.read();			
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 73:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 74; token+=ch;
				}
				else if(Character.toLowerCase(ch) == 'i')
				{
					state = 77; token+=ch;
				}
				break;
				
			case 74:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'l')
				{
					state = 75; token+=ch;
				}
				break;
				
			case 75:
				buf.mark(1);
				ch = (char) buf.read();
				
				if(Character.toLowerCase(ch) == 'l')
				{
					state = 76; token+=ch;
				}
				break;
				
			case 76:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 77:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'm')
				{
					state = 78; token+=ch;
				}
				break;
				
			case 78:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'e')
				{
					state = 79; token+=ch;
				}
				break;
				
			case 79:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 's')
				{
					state = 80; token+=ch;
				}
				break;
				
			case 80:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 81:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 82; token+=ch;
				}
				break;
				
			case 82:
				buf.mark(1);
				ch = (char) buf.read();
				if(Character.toLowerCase(ch) == 'y')
				{
					state = 83; token+=ch;
				}
				break;
				
			case 83:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 84:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'a')
				{
					state = 85; token+=ch;
				}
				break;
				
			case 85:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'c')
				{
					state = 86; token+=ch;
				}
				break;
				
			case 86:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 't')
				{
					state = 87; token+=ch;
				}
				break;
				
			case 87:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r'||ch==';')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 88:
				buf.mark(1);
				ch = (char) buf.read();				
				if(Character.toLowerCase(ch) == 'r')
				{
					state = 89; token+=ch;
				}
				break;
				
			case 89:
				buf.mark(1);
				ch = (char) buf.read();				
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
		        	 	buf.reset(); 
			        	type=1;
			        return token;
		        	}
		        break;
		        
			case 90:
				buf.mark(1);
				if(ch== '#')
				{
					while(ch!= '\n'){ch= (char) buf.read();}
					
				}
				state = 1;
				break;
				
			case 91:
				buf.mark(1);
				state = 1;
				type = 5;
				buf.reset(); 
				return token;
				
			case 92:
				buf.mark(1);
				ch = (char) buf.read();				
				if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 93; token+=ch;	
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
					error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				break;
				
			case 93:
				buf.mark(1);
				ch = (char) buf.read();				
				if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 94; token+=ch;	
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
					error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				break;
			
			case 94:
				buf.mark(1);
				ch = (char) buf.read();				
				if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 95; token+=ch;	
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
					error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				break;
				
			case 95:
				buf.mark(1);
				ch = (char) buf.read();
				
				if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 96; token+=ch;	
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
					error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				break;
				
			case 96:
				buf.mark(1);
				ch = (char) buf.read();				
				if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 97; token+=ch;	
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
					error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				break;
				
			case 97:
				buf.mark(1);
				ch = (char) buf.read();				
				if( ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 98; token+=ch;	
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
					error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				break;
				
			case 98:
				buf.mark(1);
				ch = (char) buf.read();
				if(ch == '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9')
				{
					state = 98; token+=ch;
				}
				else if (Integer.parseInt(token) <= 1000000)
				{
					error =2;
        			type=errorhandler(error);
        			buf.reset();
        			return token;
				}	
				else if(ch == ' ' || ch =='\n' || ch==';')
				{
	        			state=1;
	        			type=3;
	        			bookkeeper(token, type_list[type-1]);
	        			buf.reset();
	        			return token;
				}
				else if(Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z')
				{
					state=92; token+=ch;		
				}
				else
				{
						error =2;
	        			type=errorhandler(error);
	        			buf.reset();
	        			return token;
				}
				
				break;
				
			case 99:
				buf.mark(1);
				if(ch== '“')
				{
					ch= (char) buf.read();
					token+=ch;
					while(ch!= '”')
					{
						ch= (char) buf.read();
						token+=ch;
					}
					
					buf.mark(1);
					type = 4;
					bookkeeper(token,type_list[type-1]);
				}
				state = 1;
				return token;
				
			case 100:
				buf.mark(1);
				ch=(char) buf.read();   	
		        if(ch== '0' ||ch == '1' ||ch == '2' ||ch == '3' ||ch == '4' ||ch == '5' ||ch == '6' ||ch == '7' ||ch == '8' || ch == '9') 
		        {
		        		state=100;token+=ch;
		        	}
		        else if (Character.toLowerCase(ch) =='a'||Character.toLowerCase(ch) =='b'||Character.toLowerCase(ch) =='c'||Character.toLowerCase(ch) =='d'||Character.toLowerCase(ch) =='e'||Character.toLowerCase(ch) =='f'||Character.toLowerCase(ch) =='g'||Character.toLowerCase(ch) =='h'||Character.toLowerCase(ch) =='i'||Character.toLowerCase(ch) =='j'||Character.toLowerCase(ch) =='k'||Character.toLowerCase(ch) =='l'||Character.toLowerCase(ch) =='m'||
		        		Character.toLowerCase(ch) =='n'||Character.toLowerCase(ch) =='o'||Character.toLowerCase(ch) =='p'||Character.toLowerCase(ch) =='q'||Character.toLowerCase(ch) =='r'||Character.toLowerCase(ch) =='s'||Character.toLowerCase(ch) =='t'||Character.toLowerCase(ch) =='u'||Character.toLowerCase(ch) =='v'||Character.toLowerCase(ch) =='w'||Character.toLowerCase(ch) =='x'||Character.toLowerCase(ch) =='y'||Character.toLowerCase(ch) =='z') 
		        {
		        		state= 100;token+=ch;
		        	}
		        else
		        {
		        		buf.reset();
		        		state=1;
		        		type=2;
		        		bookkeeper(token, type_list[type-1]);
		        		return token;
		        	}   
		        break;
		        
			case 101:
				buf.mark(1);
				ch = (char) buf.read();
				if(ch==' '||ch=='\n'||ch=='\r')
		        {	          
		        	 	state = 1;
			        	type=2;
			        	bookkeeper(token,type_list[type-1]);
			        	buf.reset();
			        return token;
		        	}
			}//end of switch
			type =8;
		}// end of while loop
		return token;
	}//end of scanner function

	public static void bookkeeper(String token, String type)
	{
		if(!map.containsKey(token.toLowerCase()))
			map.put(token, type);
	}

	public static int errorhandler(int error)
	{
		if(error == 1) {return 6;}
		else if(error ==2 ) {return 7;}
		else return 8;
    }
}

