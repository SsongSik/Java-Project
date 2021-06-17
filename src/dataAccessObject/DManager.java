package dataAccessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.OHwewon;
import valueObject.OLecture;

public class DManager {
	
	private Scanner scanner;

	public DManager(Scanner scanner) {
		this.scanner=scanner;
	}

	public void DMDelete(OHwewon oHwewon) {
		System.out.println("���� ȸ�� ����Ʈ �Դϴ�.");
		Vector v = new Vector();
		int index=0;
	        try{
	            File file = new File("hwewon");
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	                System.out.println(String.valueOf(index+1)+". "+line);
	                v.add(line);
	                index++;
	            }
	            
	            System.out.println("id�� ã���ðڽ��ϱ�?");
	            System.out.println("��(1), �ƴϿ�(2)");
	            int num1 = this.scanner.nextInt();
	            if(num1==1) {
	            	System.out.println("id�� �Է����ּ���.");
	            	String id = this.scanner.next();
	            	for(int i = 0; i<v.size(); i++) {
	 	        	   String text1 = (String)v.get(i);
	 	        	   String [] text2 = text1.split(" ");
	 	        	   if(id.equals(text2[0])) {
	 	        		   System.out.println("�ش� ��ȣ��"+(i+1)+"�� �Դϴ�.");
	 	        		   break;
	 	        	   }else{
	 	        		   if(i+1==v.size()) {
	 	        			   System.out.println("���̵� �������� �ʽ��ϴ�.");
	 	        			   System.exit(0);
	 	        		   }
	 	        		   continue;
	 	        	   }
	 	           }
	            	System.out.println("ȸ�������� ��ȣ�� ��������.");
		    		int input = this.scanner.nextInt()-1;
		    		System.out.println(v.get(input));
		    		System.out.println("�� ȸ���� �����Ͻðڽ��ϱ�?");
		    		System.out.println("��(1), �ƴϿ�(2)");
		    		int num2 = this.scanner.nextInt();
		    		if(num2==1) {
			    		v.remove(input);
			    		file.delete();
			    	
			            File Newfile = new File("hwewon");
			            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
			            for(int i= 0; i<v.size();i++) {
			            String inputString = (String) v.get(i);
			            bufferedWriter.write(inputString);
			            bufferedWriter.newLine();
			            }
		                bufferedWriter.close();
			            bufReader.close();
			            System.out.println("���� �Ϸ�.");
		    		}
		    		else if(num2==2) {
		    			System.out.println("�������� �ʾҽ��ϴ�.");
		    			System.exit(0);
		    		}
	            }
	            else if(num1==2) {
	            	System.out.println("ȸ�������� ��ȣ�� ��������.");
		    		int input1 = this.scanner.nextInt()-1;
		    		System.out.println(v.get(input1));
		    		System.out.println("�� ȸ���� �����Ͻðڽ��ϱ�?");
		    		System.out.println("��(1), �ƴϿ�(2)");
		    		int num2 = this.scanner.nextInt();
		    		if(num2==1) {
			    		v.remove(input1);
			    		file.delete();
			    	
			            File Newfile = new File("hwewon");
			            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
			            for(int i= 0; i<v.size();i++) {
			            String inputString = (String) v.get(i);
			            bufferedWriter.write(inputString);
			            bufferedWriter.newLine();
			            }
		                bufferedWriter.close();
			            bufReader.close();
			            System.out.println("���� �Ϸ�.");
		    		}
		    		else if(num2==2) {
		    			System.out.println("�������� �ʾҽ��ϴ�.");
		    			return;
		    		}
	            }
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}

	public void DMModify(OHwewon oHwewon) {
		Vector v = new Vector();
		int index=0;
	        try{
	            File file = new File("hwewon");
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	                System.out.println(String.valueOf(index+1)+". "+line);
	                v.add(line);
	                index++;
	            }
	            System.out.println("������ ȸ���� ��ȣ�� �Է��ϼ���...");
	    		int input = this.scanner.nextInt()-1;
	    		System.out.println("�� ȸ���� �����մϴ�.");
	    		file.delete();
	    		
	    		System.out.println(v.get(input));
	    		System.out.println("������ �̸��� �Է��ϼ���.");
	    	    String name = this.scanner.next();
	    	    System.out.println("������ �ּҸ� �Է��ϼ���.");
	    	    String address = this.scanner.next();
	    	    System.out.println("������ �а��� �Է��ϼ���.");
	    	    String hwakgwa = this.scanner.next();
	    	    System.out.println("������ ��ȣ�� �Է��ϼ���.");
	    	    String phone = this.scanner.next();
	    	    
	    	    String text1 = (String)v.get(input);
         	    String [] text2 = text1.split(" ");
	    	    text2[2]=name;
	    	    text2[3]=address;
	    	    text2[4]=hwakgwa;
	    	    text2[5]=phone;
	    	    
	    	    text1="";
	    	    for(int i=0; i<6; i++) {
	    	    	text1+=text2[i]+" ";
	    	    }
	    		System.out.println(text1);
	    		System.out.println("�̿� ���� �����Ͻ� �̴ϱ�?");
	    		System.out.println("��(1), �ƴϿ�(2)");
	    		int num = this.scanner.nextInt();
	    		if(num==1) {
	    		
		            File Newfile = new File("hwewon");
		            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
		            for(int i= 0; i<v.size();i++) {
		            	if(i==input) {
		            		bufferedWriter.write(text1);
		            		bufferedWriter.newLine();
		            	}
		            	else {
				            String inputString = (String) v.get(i);
				            bufferedWriter.write(inputString);
				            bufferedWriter.newLine();
		            	}
		            }
	                bufferedWriter.close();
		            bufReader.close();
		            System.out.println("����Ϸ�.");
	    		}
	    		else {
	    			System.out.println("�������� �ʾҽ��ϴ�.");
	    			return;
	    		}
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}

	public void DMLecturemodify(String filename, OLecture oLecture, OHwewon oHwewon) {
		Vector v = new Vector();
		Vector v2 = new Vector();
		int i;
		int index=0;
	        try{
	            File file = new File("data/"+filename);
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	            	v.add(line);
	            	line=line.substring(0, line.indexOf(' ')); 
	            	v2.add(line);
	                index++;
	            }
	            String choice =oLecture.getId();
	            for(i=0; i<=v2.size(); i++) {
	            	if(choice.equals((String)v2.get(i))) {
	            		break;
	            	}
	            }
	    		System.out.println((String)v.get(i));
	    		System.out.println("�� ������ �����մϴ�.");
	    		System.out.println("������ ���¹�ȣ�� �Է��ϼ���.");
	    		String num = this.scanner.next();
	    		for(int j=0; j<v.size(); j++) {
	    			String text1 = (String)v.get(j);
	         	    String [] text2 = text1.split(" ");
	         	    if(num.equals(text2[0])) {
	         	    	System.out.println("�̹� ���¹�ȣ�� �����մϴ�.");
	         	    	System.out.println("�ٽ� �޴��� �������ּ���.");
	         	    	return;
	         	    }
	    		}
	    		System.out.println("������ ���¸��� �Է��ϼ���.");
	    		String name = this.scanner.next();
	    		System.out.println("������ �����Լ����� �Է��ϼ���.");
	    		String proname = this.scanner.next();
	    		System.out.println("������ ������ �Է��ϼ���.");
	    		String credit = this.scanner.next();
	    		System.out.println("������ �ð��� �Է��ϼ���.");
	    		String time = this.scanner.next();
	    		
	    		String text1 = (String)v.get(i);
	        	String [] text2 = text1.split(" ");
	        	
	        	text2[0]=num+" ";
	        	text2[1]=name+" ";
	        	text2[2]=proname+" ";
	        	text2[3]=credit+" ";
	        	text2[4]=time;
	        	String txt="";
	        	for(int j=0; j<5; j++) {
	        		txt+=text2[j];
	        	}
	        	System.out.println(txt);
	        	System.out.println("�̿� ���� ����˴ϴ�.");
	        	System.out.println("��(1), �ƴϿ�(2)");
	    		int num1 = this.scanner.nextInt();
	    		if(num1==1) {
		            File Newfile = new File("data/"+filename);
		            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
		            for(int k= 0; k<v.size();k++) {
		            	if(k==i) {
		            		bufferedWriter.write(txt);
		    	            bufferedWriter.newLine();
		            	}
		            	else {
				            String inputString = (String) v.get(k);
				            bufferedWriter.write(inputString);
				            bufferedWriter.newLine();
		            	}
		            }
	                bufferedWriter.close();
		            bufReader.close();
		            System.out.println("����Ϸ�");
	    		}
	    		else {
	    			System.out.println("�������� �ʾҽ��ϴ�.");
	    			return;
	    		}
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}

	public void DMLecturdelete(String filename, OLecture oLecture, OHwewon oHwewon) {
		Vector v = new Vector();
		Vector v2 = new Vector();
		int i;
		int index=0;
	        try{
	            File file = new File("data/"+filename);
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
//	                System.out.println(String.valueOf(index+1)+". "+line);
	            	v.add(line);
	            	line=line.substring(0, line.indexOf(' ')); 
	            	v2.add(line);
	                index++;
	            }
	            
	            String choice =oLecture.getId();
	            for(i=0; i<=v2.size(); i++) {
	            	if(choice.equals((String)v2.get(i))) {
	            		break;
	            	}
	            }
	            System.out.println(v.get(i));
	            System.out.println("�� ������ �����Ͻðڽ��ϱ�?");
	            System.out.println("��(1), �ƴϿ�(2)");
	            int num1 = this.scanner.nextInt();
	            if(num1==1) {
	            	v.remove(i);
	            	System.out.println("���� �Ϸ�.");
	            }
	            else if(num1==2){
	            	System.out.println("�������� �ʾҽ��ϴ�.");
	            }
	            File Newfile = new File("data/"+filename);
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
	            for(int k= 0; k<v.size();k++) {
			        String inputString = (String) v.get(k);
			        bufferedWriter.write(inputString);
			        bufferedWriter.newLine();
	            }
                bufferedWriter.close();
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
		
	}

	public void DMLectureplus(String filename, OHwewon oHwewon) {
		Vector v = new Vector();
		int i;
		int index=0;
	        try{
	            File file = new File("data/"+filename);
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	            	v.add(line);
	                index++;
	            }
	            
	            
	    		System.out.println("�߰��� ���¹�ȣ�� �Է��ϼ���.");
	    		String num = this.scanner.next();
	    		for(int j=0; j<v.size(); j++) {
	    			String text1 = (String)v.get(j);
	         	    String [] text2 = text1.split(" ");
	         	    if(num.equals(text2[0])) {
	         	    	System.out.println("�̹� ���¹�ȣ�� �����մϴ�.");
	         	    	System.out.println("�ٽ� �޴��� �������ּ���.");
	         	    	return;
	         	    }
	    		}
	    		
	    		System.out.println("�߰��� ���¸��� �Է��ϼ���.");
	    		String name = this.scanner.next();
	    		System.out.println("�߰��� �����Լ����� �Է��ϼ���.");
	    		String proname = this.scanner.next();
	    		System.out.println("�߰��� ������ �Է��ϼ���.");
	    		String credit = this.scanner.next();
	    		System.out.println("�߰��� �ð��� �Է��ϼ���.");
	    		String time = this.scanner.next();
	    		
//	    		String text1 = (String)v.get(i);
//	        	String [] text2 = text1.split(" ");
//	        	
//	        	text2[0]=num+" ";
//	        	text2[1]=name+" ";
//	        	text2[2]=proname+" ";
//	        	text2[3]=credit+" ";
//	        	text2[4]=time;
//	        	String txt="";
//	        	for(int j=0; j<5; j++) {
//	        		txt+=text2[j];
//	        	}
	    		String txt = num+" "+name+" "+proname+" "+credit+" "+time;
	        	System.out.println(txt);
	        	System.out.println("�� ������ �߰��մϴ�...");
	        	System.out.println("��(1), �ƴϿ�(2)");
	    		int num1 = this.scanner.nextInt();
	    		if(num1==1) {
		            File Newfile = new File("data/"+filename);
		            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
		            for(int k= 0; k<v.size()+1;k++) {
		            	if(k==v.size()) {
				            bufferedWriter.write(txt);
				            bufferedWriter.newLine();
		            	}
		            	else {
		            		String inputString = (String) v.get(k);
				            bufferedWriter.write(inputString);
				            bufferedWriter.newLine();
		            	}
		            	
		            }
	                bufferedWriter.close();
		            bufReader.close();
		            System.out.println("�߰��Ϸ�");
	    		}
	    		else {
	    			System.out.println("�߰����� �ʾҽ��ϴ�.");
	    			return;
	    		}
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}
	
}
