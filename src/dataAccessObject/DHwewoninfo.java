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

public class DHwewoninfo {

	public DHwewoninfo(Scanner scanner) {
		// TODO Auto-generated constructor stub
	}
	public void save(OHwewon oHwewon, String pw) {
		Vector v = new Vector();
		try{
           File f = new File("hwewon");
           FileReader fr = new FileReader(f);
           BufferedReader br = new BufferedReader(fr);
           String line1 = "";
           while((line1 = br.readLine()) != null){
               v.add(line1);
           }
           String id = oHwewon.getId();
           int i;
           String txt1 ="";
           for(i = 0; i<v.size(); i++) {
        	   String text1 = (String)v.get(i);
        	   String [] text2 = text1.split(" ");
        	   if(id.equals(text2[0])) {
        		   text2[1] = pw;
        		   txt1=pw;
        		   break;
        	   }
           }
           String txt ="";
           for(int k=0; k<=5; k++) {
        	   String text1 = (String)v.get(i);
        	   String [] text2 = text1.split(" ");
        	   if(k==1) {
        		   txt+=txt1+" ";
        	   }
        	   else {
        		   txt+=text2[k]+" ";
        	   }
           }
           File Newfile = new File("hwewon");
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
           int j;
           for(j= 0; j<v.size();j++) {
        	   if(i==j) {
        		   bufferedWriter.write(txt);
        		   bufferedWriter.newLine();
        	   }
        	   else {
		           String inputString = (String) v.get(j);
		           bufferedWriter.write(inputString);
		           bufferedWriter.newLine();
        	   }
           }
           bufferedWriter.close();
           br.close();
           System.out.println("비밀번호 변경");
           
       }catch (FileNotFoundException e) {
           // TODO: handle exception
       }catch(IOException e){
           System.out.println(e);
       }
   }
}
