package compilers_1_assign;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import compilers_1_assign.main_program;
public class parser_final {
	public void parser() throws IOException{
		String tok, sttop="", action="", look_ahead="";
		int step=1,i,j,k,state=0,top;
		Stack<Integer> st = new Stack<Integer>();
		// Syntax Rules
		int[][] rules = {{34,35,37,36},{35,4,5,6,7},{36,8,9,6},{37,39,28,38},{38,39,28,38},{38,0},
				{39,40,},{39,42},{39,43},{39,44},{39,45},{40,4,46,41},{41,11},{41,12},{42,1,9,48},{43,13,27,49,28,29,37,30,10,29,37,30},
				{44,14,15,14,27,49,28,29,37,30},{45,16,46},{45,17,3},{46,1,47},{47,1,47},{47,0},{48,49},{48,52},{49,18,50,},
				{49,19,50},{49,20,49},{49,51,52,52,31},{50,21,49},{50,22,49},{50,0},{51,23},
				{51,9},{51,24},{52,1,53},{52,2,53},{52,32,52,33,53},{53,25,52},{53,26,52},
				{53,0}};
		
		// LL(1) Parse Table
		int[][] table = {{34,4}, {35,4}, {36,8}, {37,4,1,13,14,16,17}, {38,4,1,13,14,16,17}, {38,8,30}, {39,4}, {39,1}, {39,13},
		                  {39,14}, {39,16,17}, {40,4}, {41,11}, {41,12}, {42,1}, {43,13}, {44,14}, {45,16}, {45,17}, {46,1},
		                  {47,1}, {47,11,12,28}, {48,18,19,20,23,9,24}, {48,1,2,32}, {49,18}, {49,19}, {49,20}, {49,23,9,24},
		                  {50,21},{50,22}, {50,28}, {51,23}, {51,9}, {51,24}, {52,1}, {52,2}, {52,32}, {53,25},{53,26},
		                  {53,28,1,2,32,31,33}}; 
		
		// To find the stack top from its type
		String[] sttopname = {"Z0","[id]","[const]","[string]","make","programming","great","again","america","is",
				"else","number","boolean","if","as","long","tell","say","fact","lie","not","and","or","less","more","plus",
				"times",",",";",":","!","?","(",")","<Trump>","<first>","<last>","<stmts>","<more-stmts>","<stmt>","<decl>",
				"<type>","<asmt>","<cond>","<loop>","<output>","<ids>","<more-ids>","<expr>","<bool>","<bool-tail>","<test>","<arith>","<arith-tail>"};
		
		System.out.println("STEP\t\tSTACK TOP\t\t\t\tLOOK_AHEAD\t\t\tACTION");
		st.push(0);
		if(st.peek()== 0){ sttop="Z0"; action="push<scala>";}
		System.out.println(step+"\t\t"+sttop+" "+st.peek()+"\t\t\t\t"+ "\t\t\t\t"+action);
		st.push(42);  
        tok = main_program.scanner();
        
        while(true){
        	
        	switch(state){
        	
        	case 0: 
        		if(st.peek()==45){
    				state=2;
    				break;
    			    }
        		if(st.peek()<42){
				    if(st.peek()== main_program.type){
					    step++;
					    action="match";
					    System.out.println(step+"\t\t"+sttopname[st.peek()]+" "+st.peek()+"\t\t\t\t"+sttopname[main_program.type]+main_program.type+"\t\t\t\tmatch");
					   st.pop();
					   if(st.peek()==45){
		    				state=2;
		    				break;
		    			    } 
					   tok = main_program.scanner();
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
    						if(table[i][j]==main_program.type)
    						{
    							if(i==2||i==4||i==6||i==18||i==33||i==51||i==58)
    							{
    								step++;
    								System.out.println(step+"\t\t"+sttopname[st.peek()]+" "+st.peek()+"\t\t\t\t"+sttopname[main_program.type]+main_program.type+"\t\t\t\trule"+(i+1));
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
    							System.out.println(step+"\t\t"+sttopname[top]+" "+top+"\t\t\t\t"+sttopname[main_program.type]+main_program.type+"\t\t\t\trule"+(i+1));
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
        	
        	if(step==248){
				break;
			}
        }
}		
}
