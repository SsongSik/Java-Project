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
		System.out.println("현재 회원 리스트 입니다.");
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
	            
	            System.out.println("id로 찾으시겠습니까?");
	            System.out.println("예(1), 아니요(2)");
	            int num1 = this.scanner.nextInt();
	            if(num1==1) {
	            	System.out.println("id를 입력해주세요.");
	            	String id = this.scanner.next();
	            	for(int i = 0; i<v.size(); i++) {
	 	        	   String text1 = (String)v.get(i);
	 	        	   String [] text2 = text1.split(" ");
	 	        	   if(id.equals(text2[0])) {
	 	        		   System.out.println("해당 번호는"+(i+1)+"번 입니다.");
	 	        		   break;
	 	        	   }else{
	 	        		   if(i+1==v.size()) {
	 	        			   System.out.println("아이디가 존재하지 않습니다.");
	 	        			   System.exit(0);
	 	        		   }
	 	        		   continue;
	 	        	   }
	 	           }
	            	System.out.println("회원삭제할 번호를 누르세요.");
		    		int input = this.scanner.nextInt()-1;
		    		System.out.println(v.get(input));
		    		System.out.println("이 회원을 삭제하시겠습니까?");
		    		System.out.println("예(1), 아니요(2)");
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
			            System.out.println("삭제 완료.");
		    		}
		    		else if(num2==2) {
		    			System.out.println("삭제하지 않았습니다.");
		    			System.exit(0);
		    		}
	            }
	            else if(num1==2) {
	            	System.out.println("회원삭제할 번호를 누르세요.");
		    		int input1 = this.scanner.nextInt()-1;
		    		System.out.println(v.get(input1));
		    		System.out.println("이 회원을 삭제하시겠습니까?");
		    		System.out.println("예(1), 아니요(2)");
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
			            System.out.println("삭제 완료.");
		    		}
		    		else if(num2==2) {
		    			System.out.println("삭제하지 않았습니다.");
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
	            System.out.println("수정할 회원의 번호를 입력하세요...");
	    		int input = this.scanner.nextInt()-1;
	    		System.out.println("이 회원을 변경합니다.");
	    		file.delete();
	    		
	    		System.out.println(v.get(input));
	    		System.out.println("수정할 이름을 입력하세요.");
	    	    String name = this.scanner.next();
	    	    System.out.println("수정할 주소를 입력하세요.");
	    	    String address = this.scanner.next();
	    	    System.out.println("수정할 학과를 입력하세요.");
	    	    String hwakgwa = this.scanner.next();
	    	    System.out.println("수정할 번호를 입력하세요.");
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
	    		System.out.println("이와 같이 변경하실 겁니까?");
	    		System.out.println("예(1), 아니요(2)");
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
		            System.out.println("변경완료.");
	    		}
	    		else {
	    			System.out.println("변경하지 않았습니다.");
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
	    		System.out.println("이 과목을 변경합니다.");
	    		System.out.println("변경할 강좌번호를 입력하세요.");
	    		String num = this.scanner.next();
	    		for(int j=0; j<v.size(); j++) {
	    			String text1 = (String)v.get(j);
	         	    String [] text2 = text1.split(" ");
	         	    if(num.equals(text2[0])) {
	         	    	System.out.println("이미 강좌번호가 존재합니다.");
	         	    	System.out.println("다시 메뉴를 선택해주세요.");
	         	    	return;
	         	    }
	    		}
	    		System.out.println("변경할 강좌명을 입력하세요.");
	    		String name = this.scanner.next();
	    		System.out.println("변경할 교수님성함을 입력하세요.");
	    		String proname = this.scanner.next();
	    		System.out.println("변경할 학점을 입력하세요.");
	    		String credit = this.scanner.next();
	    		System.out.println("변경할 시간을 입력하세요.");
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
	        	System.out.println("이와 같이 변경됩니다.");
	        	System.out.println("예(1), 아니요(2)");
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
		            System.out.println("변경완료");
	    		}
	    		else {
	    			System.out.println("변경하지 않았습니다.");
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
	            System.out.println("이 과목을 삭제하시겠습니까?");
	            System.out.println("예(1), 아니요(2)");
	            int num1 = this.scanner.nextInt();
	            if(num1==1) {
	            	v.remove(i);
	            	System.out.println("삭제 완료.");
	            }
	            else if(num1==2){
	            	System.out.println("삭제하지 않았습니다.");
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
	            
	            
	    		System.out.println("추가할 강좌번호를 입력하세요.");
	    		String num = this.scanner.next();
	    		for(int j=0; j<v.size(); j++) {
	    			String text1 = (String)v.get(j);
	         	    String [] text2 = text1.split(" ");
	         	    if(num.equals(text2[0])) {
	         	    	System.out.println("이미 강좌번호가 존재합니다.");
	         	    	System.out.println("다시 메뉴를 선택해주세요.");
	         	    	return;
	         	    }
	    		}
	    		
	    		System.out.println("추가할 강좌명을 입력하세요.");
	    		String name = this.scanner.next();
	    		System.out.println("추가할 교수님성함을 입력하세요.");
	    		String proname = this.scanner.next();
	    		System.out.println("추가할 학점을 입력하세요.");
	    		String credit = this.scanner.next();
	    		System.out.println("추가할 시간을 입력하세요.");
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
	        	System.out.println("이 과목을 추가합니다...");
	        	System.out.println("예(1), 아니요(2)");
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
		            System.out.println("추가완료");
	    		}
	    		else {
	    			System.out.println("추가하지 않았습니다.");
	    			return;
	    		}
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}
	
}
