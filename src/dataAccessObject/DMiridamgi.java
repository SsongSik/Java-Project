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

import model.MLecture;
import valueObject.OHwewon;
import valueObject.OLecture;
import view.VSugangsincheon;

public class DMiridamgi {
	
	private String id;
	 private String lectureName;
	 private String profName;
	 private String credits;
	 private String time;
	 private MLecture mLecture;
	private Scanner scanner;

	public DMiridamgi(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void DMGet(OLecture oLecture, OHwewon oHwewon) {
		this.id=oLecture.getId();
		this.lectureName=oLecture.getLectureName();
		this.profName=oLecture.getProfName();
		this.credits=oLecture.getCredits();
		this.time=oLecture.getTime();
		this.DMSave(oHwewon);
	}
	public void DMSave(OHwewon oHwewon) {
		 try {
	          File file = new File("user/"+oHwewon.getId()+"_bag.txt");
	          FileWriter filewriter = new FileWriter(file, true);
	          BufferedWriter bw = new BufferedWriter(filewriter);
	     
				bw.write(id+' '+lectureName+' '+profName+' '+credits+' '+time);
				bw.newLine();
				bw.flush();
				bw.close();
	          filewriter.close();
	          bw.close();

	          // oHwewond���� mHwewon���� �����͸� �̵�
	          // mHwewon�� ���ؼ� ���Ͽ� ����
	          } catch (IOException e) {
	             e.printStackTrace();
	          }
		
	}

	public boolean DMCheck(OLecture oLecture, OHwewon oHwewon) {
		Vector vector = new Vector();
		int index=0;
		try {
		File file = new File("user/"+oHwewon.getId()+"_bag.txt");
        FileReader filereader;
		filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String text = "";
        while((text = bufReader.readLine()) != null){
            vector.add(text);
            index++;
        }
        String input=oLecture.getId()+' '+oLecture.getLectureName()+' '+oLecture.getProfName()+' '+oLecture.getCredits()+' '+oLecture.getTime();
        for(int i = 0; i<vector.size(); i++) {
        	if(input.equals((String)vector.get(i))) {
        		System.out.println("�̹� å���濡 �ִ� �����Դϴ�.");
            	return false;
        	}
 
        }
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public void DMDelete(OHwewon oHwewon) {
		Vector vector = new Vector();
		int index=0;
	        try{
	            File file = new File("user/"+oHwewon.getId()+"_bag.txt");
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String text = "";
	            while((text = bufReader.readLine()) != null){
	                System.out.println(String.valueOf(index+1)+". "+text);
	                vector.add(text);
	                index++;
	            }
	            System.out.println("������ ������ ��ȣ�� �Է��ϼ���...");
	    		int input = this.scanner.nextInt()-1;
	    		vector.remove(input);
	    		file.delete();
	    	
	            File Newfile = new File("user/"+oHwewon.getId()+"_bag.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
	            for(int i= 0; i<vector.size();i++) {
	            String data = (String) vector.get(i);
	            bufferedWriter.write(data);
	            bufferedWriter.newLine();
	            }
                bufferedWriter.close();
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	        System.out.println("���� �Ϸ�.");
		
	}

	public boolean DMShow(OHwewon oHwewon) {
		System.out.println(oHwewon.getName()+"�� å���� ����Դϴ�.");
		System.out.println("å������ ���� ����:" + this.DMGrade(oHwewon));
		int index=0;
		int index1=0;
		Vector vec = new Vector();
		Vector vector = new Vector();
		try{
            File file = new File("user/"+oHwewon.getId()+"_bag.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String data = "";
            while((data = bufReader.readLine()) != null){
                System.out.println(String.valueOf(index+1)+". "+data);
                vec.add(data);
                index++;
            }
            
            File f = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data1 = "";
            while((data1 = br.readLine()) != null){
//                System.out.println('['+String.valueOf(index)+']'+line1);
                vector.add(data1);
                index1++;
            }

            System.out.println("������û�� ������ ��ȣ�� �Է��ϼ���...");
    		int input = this.scanner.nextInt()-1;
    		String textsplit = (String)vec.get(input);
    		String [] text1 = textsplit.split(" ");
    		if(Integer.parseInt(text1[3])+Integer.parseInt(this.DMGrade1(oHwewon))>=19) {
    			System.out.println("���� �ʰ��Դϴ�.");
    			return false;
    		}
    		else {
	    		for(int j = 0; j<vector.size(); j++) {
	            	if(textsplit.equals((String)vector.get(j))) {
	            		System.out.println("�̹� ��û�� �����Դϴ�.");
	                	return false;
	            	}
	            	else {
	            		continue;
	            	}
	            }
    		}
    		File Newfile = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
    		FileWriter filewriter = new FileWriter(Newfile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
            bufferedWriter.write((String)vec.get(input));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            filewriter.close();
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }	
		return true;
	}

	public String DMGrade(OHwewon oHwewon) {
		String sumgrade = null;
		int sumGrade = 0;
		try {
			File file = new File("user/"+oHwewon.getId()+"_bag.txt");
			   Scanner scan = new Scanner(file);
			   this.mLecture = new MLecture();
		        FileReader filereader;
				filereader = new FileReader(file);
		        BufferedReader bufReader = new BufferedReader(filereader);
			   
			   while(mLecture.read(scan)){
			    OLecture oLecture = new OLecture();
			    oLecture.set(mLecture);
			     sumGrade = sumGrade + Integer.parseInt(oLecture.getCredits());
//			    lectures.add(oLecture);
			   }
			   scan.close();
			   sumgrade = Integer.toString(sumGrade);
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  }
		return sumgrade;
		
	}

	public String DMGrade1(OHwewon oHwewon) {
		String sumgrade = null;
		int sumGrade = 0;
		try {
			File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
			   Scanner scan = new Scanner(file);
			   this.mLecture = new MLecture();
		        FileReader filereader;
				filereader = new FileReader(file);
		        BufferedReader bufReader = new BufferedReader(filereader);
			   
			   while(mLecture.read(scan)){
			    OLecture oLecture = new OLecture();
			    oLecture.set(mLecture);
			     sumGrade = sumGrade + Integer.parseInt(oLecture.getCredits());
//			    lectures.add(oLecture);
			   }
			   scan.close();
			   sumgrade = Integer.toString(sumGrade);
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  }
		return sumgrade;
		
	}

	public boolean DMGradecheak(OLecture oLecture, OHwewon oHwewon) {
		if(Integer.parseInt(this.DMGrade(oHwewon))+Integer.parseInt(oLecture.getCredits())>24) {
			System.out.println("�����ʰ��Դϴ�.");
			return false;
		}
		else {
			return true;
		}
	}
	

}
