package dataAccessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class WindowDAO {

	public void windowDMSave(String filename, String text) {
		try {
	          File file = new File(filename);
	          FileWriter filewriter = new FileWriter(file, true);
	          BufferedWriter bw = new BufferedWriter(filewriter);
	     
				bw.write(text);
				bw.newLine();
				bw.flush();
				bw.close();
	          filewriter.close();
	          bw.close();

	          // oHwewond에서 mHwewon으로 데이터를 이동
	          // mHwewon을 통해서 파일에 저장
	          } catch (IOException e) {
	             e.printStackTrace();
	          }
	}

	public void windowDMDelete(String filename, String text) {
		Vector v = new Vector();
		int index=0;
	        try{
	            File file = new File(filename);
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	                v.add(line);
	                index++;
	            }
	            int i;
	            for(i=0; i<v.size(); i++) {
	            	if(text.equals(v.get(i))) {
	            		break;
	            	}
	            }
	    		v.remove(i);
	    		file.delete();
	            File Newfile = new File(filename);
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
	            for(int j= 0; j<v.size();j++) {
	            String inputString = (String) v.get(j);
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

	

}
