package control;

import java.util.Scanner;

import dataAccessObject.DManager;
import valueObject.OHwewon;
import valueObject.OLecture;

public class CManager {
	
	private Scanner scanner;
	private DManager dManager; 

	public CManager(Scanner scanner) {
		this.scanner=scanner;
		this.dManager = new DManager(this.scanner);
	}
	
	public void CMDelete(OHwewon oHwewon) {
		dManager.DMDelete(oHwewon);
	}
	public void CMModify(OHwewon oHwewon) {
		dManager.DMModify(oHwewon);
	}
	public void CMLecturemodify(String filename, OLecture oLecture, OHwewon oHwewon) {
		dManager.DMLecturemodify(filename, oLecture, oHwewon);
	}
	public void CMLecturdelete(String filename, OLecture oLecture, OHwewon oHwewon) {
		dManager.DMLecturdelete(filename, oLecture, oHwewon);
	}

	public void CMLectureplus(String filename, OHwewon oHwewon) {
		// TODO Auto-generated method stub
		dManager.DMLectureplus(filename, oHwewon);
	}
}
