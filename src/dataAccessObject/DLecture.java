package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import model.MLecture;
import valueObject.OIndex;
import valueObject.OLecture;

public class DLecture {
	private MLecture mLecture;
	
	private static final String PATHNAME="data/";
 public DLecture() {
	 
 }
 
 public Vector<OLecture> readAll(String fileName){
  Vector<OLecture> lectures = new Vector<OLecture>();
  
  try {
   File file = new File(PATHNAME+fileName);
   Scanner scan = new Scanner(file);
   this.mLecture = new MLecture();
   while(mLecture.read(scan)){
    OLecture oLecture = new OLecture();
    oLecture.set(mLecture);
    lectures.add(oLecture);
   }
   scan.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  return lectures;
 }
 
 public Vector<OLecture> Windowgetall(String fileName){
	  Vector<OLecture> lectures = new Vector<OLecture>();
	  
	  try {
	   File file = new File(fileName);
	   Scanner scan = new Scanner(file);
	   this.mLecture = new MLecture();
	   while(mLecture.read(scan)){
	    OLecture oLecture = new OLecture();
	    oLecture.set(mLecture);
	    lectures.add(oLecture);
	   }
	   scan.close();
	  } catch (FileNotFoundException e) {
	   e.printStackTrace();
	  }
	  return lectures;
	 }
 
}