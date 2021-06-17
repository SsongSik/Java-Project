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

import control.CManager;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VManager {
	
	private Scanner scanner;
	private CManager cManager;
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	
	public VManager(Scanner scanner) {
		this.scanner = scanner;
		this.cManager = new CManager(this.scanner);
		this.vCampus = new VIndex(this.scanner);
		this.vCollege=new VIndex(this.scanner);
		this.vDepartment=new VIndex(this.scanner);
		this.vLecture=new VLecture(this.scanner);
	}
	public void show(OHwewon oHwewon) {
		while(true) {
			System.out.println("회원삭제(1), 회원수정(2), 강의변경(3), 강의추가(4), 강의삭제(5) 로그아웃(6)");
			int num = this.scanner.nextInt();
			if(num==1) {
				cManager.CMDelete(oHwewon);
				continue;
			}
			else if(num==2){
				cManager.CMModify(oHwewon);
				continue;
    		}
    		else if(num==3) {
    			this.LectureModify(oHwewon);
    			continue;
    		}
    		else if(num==4) {
    			this.Lectureplus(oHwewon);
    			continue;
    		}
    		else if(num==5) {
    			this.LectureDelete(oHwewon);
    			continue;
    		}
    		else if(num==6) {
    			System.out.println("로그아웃 되었습니다.");
    			break;
    		}
    		else {
    			System.out.println("잘못입력하셨습니다.");
    			continue;
    		}
		}
	
	}
	public void LectureModify(OHwewon oHwewon) {
		System.out.println("변경하고자 하는 강좌번호를 선택하세요.");
		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학를");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				if(campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "병경할 강좌를");
					if(oLecture != null) {
						cManager.CMLecturemodify(departmentFileName, oLecture, oHwewon);
					}
					else {
						System.out.println("올바르지 않은 강좌를 선택하였습니다.");
					}
				}
			}
		}
	}
	public void LectureDelete(OHwewon oHwewon) {
		System.out.println("삭제하고자 하는 강좌번호를 선택하세요.");
		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학를");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				if(campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "삭제할 강좌를");
					if(oLecture != null) {
						cManager.CMLecturdelete(departmentFileName, oLecture, oHwewon);
					}
					else {
						System.out.println("올바르지 않은 강좌를 선택하였습니다.");
					}
				}
			}
		}
	}
	
	public void Lectureplus(OHwewon oHwewon) {
		System.out.println("추가하고 하는 강좌목록을 선택하세요.");
		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학를");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				if(campusFileName != null) {
					cManager.CMLectureplus(departmentFileName, oHwewon);
				}
			}
		}
	}
}
