package compilersscanner;

import java.io.IOException;
import java.util.Stack;
public class Parser{
	public void parser() throws IOException{
		String tok, sttop="", action="";
		int step=1,i,j,k,state=0,top;
		Stack<Integer> st = new Stack<Integer>();
		
				
				// Syntax Rules
				int[][] rules = {{42,43,44,45},{43,3,1,31,43},{43,0},{44,4,1,31,44},{44,0},{45,46,45},
						{45,0},{46,47,48},{47,5},{47,6},{47,7},{47,8},{47,9},{48,49,50},{49,10},{49,11},
						{50,32,51,33},{51,52,31,51},{51,0},{52,53},{52,58},{52,59},{52,60},{52,61},{52,62},
						{52,63},{52,64},{52,50},{53,12,54},{53,13,1,34,55,35,50},{54,55,36,57},{55,1,56},
						{56,37,1,56},{56,0},{57,28},{57,29},{57,30},{58,1,14,65},{59,15,34,65,35,52,31,16,52},
						{60,17,34,65,35,52},{61,18,1,38,65,19,52},{62,20,34,55,35},{63,21,34,55,35},{64,22,34,65,35},
						{65,66},{65,68},{66,1,67},{66,2,67},{66,34,66,35,67},{67,39,66},{67,40,66},{67,0},
						{68,23,34,68,35,69},{68,24,69},{68,25,69},{68,41,66,66},{69,26,68},{69,27,68},{69,0}};
				
				// LL(1) Parse Table
				int[][] table = {{42,3,4,5,6,7,8,9},{43,3},{43,4,5,6,7,8,9},{44,4},{44,5,6,7,8,9},{45,5,6,7,8,9},
						{45,0},{46,5,6,7,8,9},{47,5},{47,6},{47,7},{47,8},{47,9},{48,10,11},{49,10},{49,11},
						{50,32},{51,12,13,1,15,17,18,20,21,22,32},{51,33},{52,12,13},{52,1},{52,15},{52,17},
						{52,18},{52,20},{52,21},{52,22},{52,32},{53,12},{53,13},{54,1},{55,1},{56,37},{56,36,35},
						{57,28},{57,29},{57,30},{58,1},{59,15},{60,17},{61,18},{62,20},{63,21},{64,22},{65,1,2,34},
						{65,23,24,25,41},{66,1},{66,2},{66,34},{67,39},{67,40},{67,31,35,19,1,2,34},{68,23},{68,24},
						{68,25},{68,41},{69,26},{69,27},{69,31,35,19}}; 
				
				// To find the stack top from its type
				String[] sttopname = {"Z0","[id]","[const]","package","import","abstract","final","sealed","private","protected",
						"class","object","val","def","<=","if","else","while","case","=>","in","print","return","not","true","false",
						"and","or","int","real","bool",";","{","}","(",")",":",",","=","+","*","@","<scala>","<packages>","<imports>",
						"<scala-body>","<subbody>","<modifier>","<subbody-tail>","<tail-type>","<block>","<stmts>","<stmt>","<dcl>",
						"<dcl-tail>","<ids>","<more-ids>","<type>","<asmt>","<if>","<while>","<case>","<in>","<out>","<return>",
						"<expr>","<arith-expr>","<arith>","<bool-expr>","<bool>"};
				
				System.out.println("STEP\t\tSTACK TOP\t\t\t\tLOOK_AHEAD\t\t\tACTION");
				st.push(0);
				if(st.peek()== 0){ sttop="Z0"; action="push<scala>";}
				System.out.println(step+"\t\t"+sttop+" "+st.peek()+"\t\t\t\t"+ "\t\t\t\t"+action);
				st.push(42);  
		        tok = Mainprogram.scanner();
		        
		        while(true){
		        	
		        	switch(state){
		        	
		        	case 0: 
		        		if(st.peek()==45){
		    				state=2;
		    				break;
		    			    }
		        		if(st.peek()<42){
						    if(st.peek()== Mainprogram.type){
							    step++;
							    action="match";
							    System.out.println(step+"\t\t"+sttopname[st.peek()]+" "+st.peek()+"\t\t\t\t"+sttopname[Mainprogram.type]+Mainprogram.type+"\t\t\t\tmatch");
							   st.pop();
							   if(st.peek()==45){
				    				state=2;
				    				break;
				    			    } 
							   tok = Mainprogram.scanner();
							    state = 0;
							    
							    break;
						    }
		        		}
		        		else state=1;    
		        		break;
		        	
		        	case 1: 
		        		top = st.peek();//System.out.println(+top);
		    			outerloop:for(i=0; i<table.length ; i++)
		    			{ 
		    				if(table[i][0]==st.peek())
		    				{
		    					for(j=1; j <table[i].length; j++ )
		    					{   
		    						if(table[i][j]==Mainprogram.type)
		    						{
		    							if(i==2||i==4||i==6||i==18||i==33||i==51||i==58)
		    							{
		    								step++;
		    								System.out.println(step+"\t\t"+sttopname[st.peek()]+" "+st.peek()+"\t\t\t\t"+sttopname[Mainprogram.type]+Mainprogram.type+"\t\t\t\trule"+(i+1));
		    								st.pop();
		    								
		    								//tok = Mainprogram.scanner();pa++;
		    								state = 0;
		    								if(st.peek()==0){
		    				    				state=2;
		    				    				break;
		    				    			    }
		    								break outerloop;
		    							}
		    							st.pop();
		    							for(k =rules[i].length; k>1; k--){
		    							    st.push(rules[i][k-1]);
		    							   System.out.println(st.peek());
		    								action="rule";
		    								
		    							}
		    							state=0;
		    							step++;
		    							System.out.println(step+"\t\t"+sttopname[top]+" "+top+"\t\t\t\t"+sttopname[Mainprogram.type]+Mainprogram.type+"\t\t\t\trule"+(i+1));
		    							//System.out.println(state+" "+ pars[pa]+" "+st.peek());
		    							
		    						}
		    						
		    					}
		    				}
		    			}
		        		break;
		        	
		        	case 2: 
		        		System.out.println(step+"\t\t"+sttopname[st.peek()]+" "+st.peek()+"\t\t\t\t\t\t\t\trule7");
		        		System.out.println("Program accepted");
		        		step++;
				          break;
		        		
		        	}
		        	
		        	if(step==262){
						break;
					}
		        }
		        
		        int[][] QT = new int[22][17];
		        for(int a=0; a<QT.length;a++){
		        	for(int b=0; b<QT[a].length;b++){
		        		QT[a][b]= 0;
		        	}
		        }
		        QT[0][8]=1; QT[0][9]=1; QT[0][4]=1; QT[0][5]=1; QT[0][6]=1; QT[0][7]=1; QT[0][10]=1;
		        QT[2][0]=1; QT[2][5]=1; QT[2][6]=1; QT[2][10]=1;
		        QT[3][0]=1;  QT[3][11]=1;  QT[3][12]=1; 
		        QT[4][5]=1; QT[4][6]=1; QT[4][2]=1; QT[4][0]=1;
		        QT[5][5]=1; QT[5][6]=1; QT[5][10]=1; QT[5][4]=1;
		        QT[6][10]=1; QT[6][5]=1; QT[6][6]=1; QT[6][2]=1; QT[6][0]=1;
		        QT[7][5]=1; QT[7][6]=1; QT[7][1]=1; QT[7][2]=1; QT[7][0]=1;
		        QT[8][6]=1; QT[8][5]=1; QT[8][4]=1; QT[8][2]=1; QT[8][1]=1; QT[8][0]=1;
		        QT[9][5]=1; QT[9][6]=1; QT[9][0]=1; QT[9][8]=1;
		        QT[11][14]=1; QT[11][0]=1; QT[11][11]=1; QT[11][12]=1; QT[11][10]=1;
		        QT[13][5]=1; QT[13][6]=1; QT[13][1]=1; QT[13][10]=1; 
		        QT[16][5]=1; QT[16][1]=1; QT[16][4]=1;
		        QT[17][0]=1; QT[17][4]=1; 
		        QT[18][5]=1; QT[18][6]=1; QT[18][1]=1; QT[18][4]=1; QT[18][14]=1; QT[18][13]=1;
		        QT[19][4]=1; QT[19][1]=1; QT[19][2]=1; QT[19][10]=1;
		        QT[20][2]=1; QT[20][0]=1; QT[20][12]=1; QT[20][11]=1;
		    
		        for(int a=0; a<QT.length;a++){
		        	for(int b=0; b<QT[a].length;b++){
		        		System.out.print(QT[a][b]);
		        		
		        	}System.out.println();
		        }
		        
		        
	}		
}
