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
			System.out.println("ȸ������(1), ȸ������(2), ���Ǻ���(3), �����߰�(4), ���ǻ���(5) �α׾ƿ�(6)");
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
    			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
    			break;
    		}
    		else {
    			System.out.println("�߸��Է��ϼ̽��ϴ�.");
    			continue;
    		}
		}
	
	}
	public void LectureModify(OHwewon oHwewon) {
		System.out.println("�����ϰ��� �ϴ� ���¹�ȣ�� �����ϼ���.");
		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "���и�");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if(campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "������ ���¸�");
					if(oLecture != null) {
						cManager.CMLecturemodify(departmentFileName, oLecture, oHwewon);
					}
					else {
						System.out.println("�ùٸ��� ���� ���¸� �����Ͽ����ϴ�.");
					}
				}
			}
		}
	}
	public void LectureDelete(OHwewon oHwewon) {
		System.out.println("�����ϰ��� �ϴ� ���¹�ȣ�� �����ϼ���.");
		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "���и�");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if(campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "������ ���¸�");
					if(oLecture != null) {
						cManager.CMLecturdelete(departmentFileName, oLecture, oHwewon);
					}
					else {
						System.out.println("�ùٸ��� ���� ���¸� �����Ͽ����ϴ�.");
					}
				}
			}
		}
	}
	
	public void Lectureplus(OHwewon oHwewon) {
		System.out.println("�߰��ϰ� �ϴ� ���¸���� �����ϼ���.");
		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "���и�");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if(campusFileName != null) {
					cManager.CMLectureplus(departmentFileName, oHwewon);
				}
			}
		}
	}
}
