package dataAccessObject;

import java.awt.Desktop;
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

public class DSugangsincheon {
	
	private Scanner scanner;
	private MLecture mLecture;
	
	public DSugangsincheon(Scanner scanner) {
		this.scanner =scanner;
	}

	public void DSave(OLecture oLecture, OHwewon oHwewon) {
		try {
			File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
			FileWriter filewriter = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(filewriter);

			bw.write(oLecture.getId()+" "+oLecture.getLectureName()+' '+oLecture.getProfName()+' '+oLecture.getCredits()+' '+oLecture.getTime());
			bw.newLine();
			bw.flush();
			bw.close();
			filewriter.close();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void DDelete(OHwewon oHwewon) {
		Vector v = new Vector();
		int index=0;
        try{
            File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(String.valueOf(index+1)+". "+line);
                v.add(line);
                index++;
            }
            System.out.println("삭제할 과목의 번호를 입력하세요...");
    		int input = this.scanner.nextInt()-1;
    		v.remove(input);
    		file.delete();
    		
            File Newfile = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
            for(int i= 0; i<v.size();i++) {
            String inputString = (String) v.get(i);
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
        System.out.println("삭제 완료.");
	}

	public void DShow(OHwewon oHwewon) {
		System.out.println(oHwewon.getName()+"님 수강신청 목록입니다.");
		System.out.println("현재 신청 학점:" + this.DGrade(oHwewon));
		int index=0;
		Vector vec = new Vector();
		try{
            File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
                vec.add(line);
                index++;
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }	
	}

	public String DGrade(OHwewon oHwewon) {
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

	public boolean DCheak(OLecture oLecture, OHwewon oHwewon) {
		Vector v = new Vector();
		int index=0;
		try {
		File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
        FileReader filereader;
		filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while((line = bufReader.readLine()) != null){
            v.add(line);
            index++;
        }
        String input=oLecture.getId()+' '+oLecture.getLectureName()+' '+oLecture.getProfName()+' '+oLecture.getCredits()+' '+oLecture.getTime();
        for(int i = 0; i<v.size(); i++) {
        	if(input.equals((String)v.get(i))) {
        		System.out.println("이미 신청목록에 있는 과목입니다.");
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

	public void DLecturePlan(OLecture oLecture, OHwewon oHwewon) {
		try{String filename = oLecture.getId()+" "+oLecture.getLectureName();
		
		String filePath = "data/plan/"+filename+".pdf";
		File pdfFile = new File(filePath);
		Desktop.getDesktop().open(pdfFile);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}			
}
