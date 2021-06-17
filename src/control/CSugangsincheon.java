package control;

import java.util.Scanner;

import dataAccessObject.DSugangsincheon;
import valueObject.OHwewon;
import valueObject.OLecture;

public class CSugangsincheon {
	
	private DSugangsincheon dSugangsincheon;
	private Scanner scanner;

	public CSugangsincheon(Scanner scanner) {
		this.scanner=scanner;
		this.dSugangsincheon=new DSugangsincheon(this.scanner);
	}
	
	public void CSave(OLecture oLecture, OHwewon oHwewon) {
		dSugangsincheon.DSave(oLecture, oHwewon);
	}
	public void CDelete(OHwewon oHwewon) {
		dSugangsincheon.DDelete(oHwewon);
	}
	public void CShow(OHwewon oHwewon) {
		dSugangsincheon.DShow(oHwewon);
	}
	public String CGrade(OHwewon oHwewon) {
		return dSugangsincheon.DGrade(oHwewon);
	}
	public boolean CCheck(OLecture oLecture, OHwewon oHwewon) {
		return dSugangsincheon.DCheak(oLecture, oHwewon);
	}

	public void CLecturePlan(OLecture oLecture, OHwewon oHwewon) {
		dSugangsincheon.DLecturePlan(oLecture, oHwewon);
		
	}
}
