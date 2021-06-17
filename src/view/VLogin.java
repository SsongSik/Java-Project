package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import control.CHwewonDeungrok;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {
	
	
	private Scanner scanner;
	private CLogin cLogin;
	   
	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cLogin = new CLogin();
   }

	   public  OHwewon show() {
	      System.out.println("���̵�� ��й�ȣ�� �Է� �ϼ���.");
	      OLogin oLogin = new OLogin();
	      
	      System.out.print("���̵� :");
	      String id = scanner.next();
	      oLogin.setId(id);
	      
	      System.out.print("��й�ȣ :");
	      String password = scanner.next();
	      oLogin.setPassword(password);
	      OHwewon oHwewon = this.cLogin.validate(oLogin);
	      if (oHwewon != null) {
	    	  return oHwewon;
	      }
	      else {
	    	  System.out.println("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
	    	  System.out.println("���̵�ã��(1), ��й�ȣã��(2), �ٽ÷α���(3)");
	    	  int input = this.scanner.nextInt();
	    	  if(input==1) {
	    		  this.Idfound();
	    		  
	    	  }
	    	  else if(input==2){
	    		  this.Pwfound();
	    		  
	    	  }
	    	  else if(input==3) {
	    		  return null;
	    	  }
	    	  return null;
	      }    
	   }
	   public void Pwfound() {
		   Vector vector = new Vector();
			try{
	           File file = new File("hwewon");
	           FileReader fileread = new FileReader(file);
	           BufferedReader bufferead = new BufferedReader(fileread);
	           String data = "";
	           while((data = bufferead.readLine()) != null){
	               vector.add(data);
	       
	           }
	           int i ;
	           System.out.println("���̵� �Է����ּ���.");
			   String id = scanner.next();
	           for(i = 0; i<vector.size(); i++) {
	        	   String textsplit = (String)vector.get(i);
	        	   String [] txt = textsplit.split(" ");
	        	   if(id.equals(txt[0])) {
	        		   break;
	        	   }else{
	        		   if(i+1==vector.size()) {
	        			   System.out.println("���̵� �������� �ʽ��ϴ�.");
	        			   System.exit(0);
	        		   }
	        		   continue;
	        	   }
	           }
	           System.out.println("�̸��� �Է����ּ���.");
			   String name = scanner.next();
			   
        	   String text = (String)vector.get(i);
        	   String [] text2 = text.split(" ");
        	   if(name.equals(text2[2])) {
        		   System.out.println("��й�ȣ : "+text2[1]);
        	   }
        	   else {
        		   System.out.println("�̸��� ���� �ʽ��ϴ�.");
        		   
        	   }
	           
	       }catch (FileNotFoundException e) {
	           // TODO: handle exception
	       }catch(IOException e){
	           System.out.println(e);
	       }
	   }
	   public void Idfound() {
		   Vector vector = new Vector();
			try{
	           File file = new File("hwewon");
	           FileReader fileread = new FileReader(file);
	           BufferedReader bufferead = new BufferedReader(fileread);
	           String data = "";
	           while((data = bufferead.readLine()) != null){
	               vector.add(data);
	       
	           }
	           int i;
	           System.out.println("�̸��� �Է����ּ���.");
			   String name = scanner.next();
	           for(i = 0; i<vector.size(); i++) {
	        	   String textspilt = (String)vector.get(i);
	        	   String [] txt = textspilt.split(" ");
	        	   if(name.equals(txt[2])) {
	        		   break;
	        	   }else{
	        		   if(i+1==vector.size()) {
	        			   System.out.println("�̸��� �������� �ʽ��ϴ�.");
	        			   System.exit(0);
	        		   }
	        		   continue;
	        	   }
	           }
	           
	           System.out.println("��ȭ��ȣ�� �Է����ּ���..");
			   String phone = scanner.next();
			   String text = (String)vector.get(i);
        	   String [] text2 = text.split(" ");
        	   if(phone.equals(text2[5])) {
        		   System.out.println("���̵� : "+text2[0]);
        	   }
        	   else {
        		   System.out.println("��ȭ��ȣ�� �ùٸ��� �ʽ��ϴ�.");
        	   }
        	   

	       }catch (FileNotFoundException e) {
	           // TODO: handle exception
	       }catch(IOException e){
	           System.out.println(e);
	       }
	   }
}
