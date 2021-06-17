package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {
   
   private Scanner scanner;
   private CHwewonDeungrok cHwewonDeungrok;
   
   public VHwewonDeungrok(Scanner scanner) {
      this.scanner = scanner;
      this.cHwewonDeungrok = new CHwewonDeungrok();
   }
   public void check(OHwewon oHwewon) {
	   
		Vector v = new Vector();
		try{
           File f = new File("hwewon");
           FileReader fr = new FileReader(f);
           BufferedReader br = new BufferedReader(fr);
           String line1 = "";
           while((line1 = br.readLine()) != null){
               v.add(line1);
       
           }
           String text = oHwewon.getId();
           for(int i = 0; i<v.size(); i++) {
        	   String text1 = (String)v.get(i);
        	   String [] text2 = text1.split(" ");
        	   if(text.equals(text2[0])) {
        		   System.out.println("중복된 id입니다.");
        		   this.show();
        		   System.exit(0);
        	   }
           }
       }catch (FileNotFoundException e) {
           // TODO: handle exception
       }catch(IOException e){
           System.out.println(e);
       }	
   }
   public void show() {
      System.out.println("회원정보를 입력하세요");
      OHwewon oHwewon = new OHwewon();
  
    
	  System.out.print("아이디 : ");
      String id = scanner.next();
      oHwewon.setId(id);
      check(oHwewon);
     
      while(true) {
    	  System.out.print("비밀번호 : ");
          String password = scanner.next();
          if(password.length()>=7) {
        	  oHwewon.setPassword(password);
        	  break;
          }
          else {
        	  System.out.println("7자리 이상 입력해 주세요.");
          }
      }
      
      System.out.print("이름 : ");
      String name = scanner.next();
      oHwewon.setName(name);
      
      System.out.print("주소 : ");
      String address = scanner.next();
      oHwewon.setAddress(address);
      
      System.out.print("학과 : ");
      String hwakgwa = scanner.next();
      oHwewon.setHwakgwa(hwakgwa);
      
      System.out.print("전화번호 : ");
      String PhoneNum = scanner.next();
      oHwewon.setPhoneNum(PhoneNum);
      // 사용자 정보 입력 받아
      // oHwewon에 저장

      this.cHwewonDeungrok.saveHwewon(oHwewon);
	  System.out.println("회원등록 되었습니다.");
   }
}