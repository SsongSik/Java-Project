package control;

import java.util.Scanner;

import dataAccessObject.DMiridamgi;
import valueObject.OHwewon;
import valueObject.OLecture;

public class CMiridamgi {
	private DMiridamgi dMiridamgi;
	private Scanner scanner;
	
	public CMiridamgi(Scanner scanner) {
		this.scanner=scanner;
		this.dMiridamgi=new DMiridamgi(this.scanner);
	}
	public void CMSave(OHwewon oHwewon) {
		dMiridamgi.DMSave(oHwewon);
	}
	public void CMGet(OLecture oLecture, OHwewon oHwewon) {
		dMiridamgi.DMGet(oLecture, oHwewon);
	}
	public boolean CMCheck(OLecture oLecture, OHwewon oHwewon) {
		return dMiridamgi.DMCheck(oLecture, oHwewon);
	}
	public void CMDelete(OHwewon oHwewon) {
		dMiridamgi.DMDelete(oHwewon);
	}
	public boolean CMShow(OHwewon oHwewon) {
		return dMiridamgi.DMShow(oHwewon);
	}
	public String CMGrade(OHwewon oHwewon) {
		return dMiridamgi.DMGrade(oHwewon);
	}
	public void CMGrade1(OHwewon oHwewon) {
		dMiridamgi.DMGrade1(oHwewon);
	}
	public boolean CMGradecheak(OLecture oLecture, OHwewon oHwewon) {
		return dMiridamgi.DMGradecheak(oLecture, oHwewon);
	}
}
