package view;

import java.io.File;
import java.util.Scanner;

import control.CMiridamgi;
import control.CSugangsincheon;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheon {

	private static final char[] Text = null;

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
//	private CLecture cLecture;
	private CSugangsincheon cSugangsincheon;
	private CMiridamgi cMiridamgi;
	
	
	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege=new VIndex(this.scanner);
		this.vDepartment=new VIndex(this.scanner);
		this.vLecture=new VLecture(this.scanner);
		this.cSugangsincheon=new CSugangsincheon(this.scanner);
		this.cMiridamgi=new CMiridamgi(this.scanner);
		
	}

	public void show(OHwewon oHwewon) {
//		System.out.println(oHwewon.getName()+"�� �ȳ��ϼ���..");
		File sinchoen = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
		File bag = new File("user/"+oHwewon.getId()+"_bag.txt");
		while(true) {
			if(bag.exists()) {
				System.out.println("���� å���� ���� : "+cMiridamgi.CMGrade(oHwewon));
			}
			else {
				System.out.println("���� å���� ���� : 0");
			}
		if(sinchoen.exists()) {
			System.out.println("���� ��û�� ���� : "+cSugangsincheon.CGrade(oHwewon));
		}
		else {
			System.out.println("���� ��û�� ���� : 0");
		}
		System.out.println("������û �� �̸����(1) �̸���⿡�� ���� ����(2) ������û���� ���� ����(3) å���� ���(4) ������û ���(5) ���� ��ȹ�� ��ȸ(6) �α׾ƿ�(7)");
		int input = this.scanner.nextInt();
		if(input == 1) {
			System.out.println("���� ��û�� �����մϴ�");
			String campusFileName = this.vCampus.show("root", "ķ�۽���");
			if(campusFileName != null) {
				String collegeFileName = this.vCollege.show(campusFileName, "���и�");
				if(campusFileName != null) {
					String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
					if(campusFileName != null) {
						OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
						if(oLecture != null) {
							System.out.println("�̸���� (1), ������û(2)");
							int num = this.scanner.nextInt();
							if(num==1) {
								if(bag.exists()) {
									if(cMiridamgi.CMGradecheak(oLecture, oHwewon)==true) {
										
									}
									else {
										continue;
									}
								}
								if(bag.exists()) {
									if(cMiridamgi.CMCheck(oLecture, oHwewon)==true) {
										cMiridamgi.CMGet(oLecture, oHwewon);
										System.out.println("�̸���� �Ϸ�");
									}
									else {
										continue;
									}
								}
								else {
									cMiridamgi.CMGet(oLecture, oHwewon);
									System.out.println("�̸���� �Ϸ�");
								}
							}else if(num==2){
								if(sinchoen.exists()) {
									this.gradecheck(oLecture, oHwewon);
									if(cSugangsincheon.CCheck(oLecture, oHwewon)==true) {
										cSugangsincheon.CSave(oLecture, oHwewon);
										System.out.println("������û �Ϸ�");
									}
									else {
										continue;
									}
								}
								else {
									cSugangsincheon.CSave(oLecture, oHwewon);
									System.out.println("������û �Ϸ�");
								}
//								else {
//									System.out.println("�����ʰ��Դϴ�.");
//									continue;
//								}
							}else {
								System.out.println("�߸� �Է��ϼ̽��ϴ�.");
							}
						}
					}
				}
			}
		}else if(input == 2) {
			if(bag.exists()) {
				cMiridamgi.CMDelete(oHwewon);
			}
			else {
				System.out.println("å���濡 ������ �����ϴ�.");
				continue;
			}
		}else if(input ==3) {
			if(sinchoen.exists()) {
				cSugangsincheon.CDelete(oHwewon);
			}
			else {
				System.out.println("��û�� ������ �����ϴ�.");
				continue;
			}
		}
		else if(input == 4) {
//			File ss1 = new File("user/"+oHwewon.getId()+"_bag.txt");
			if(bag.exists()) {
				if(cMiridamgi.CMShow(oHwewon)==true) {
					System.out.println("��û �Ϸ�");
				}
				else {
					continue;
				}
			}
			else {
				System.out.println("���� å������ ����ֽ��ϴ�.");
				continue;
			}
		}
		else if(input==5) {
			if(sinchoen.exists()) {
				cSugangsincheon.CShow(oHwewon);
				continue;
			}
			else {
				System.out.println("���� ������û����� ����ֽ��ϴ�.");
				continue;
			}
		}
		else if(input==6) {
			this.LecturePlan(oHwewon);
			continue;
		}
		
		else if(input==7) {
			System.out.println("�α׾ƿ�");
			break;
		}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			continue;
		}
		}
	}
	public void gradecheck(OLecture oLecture, OHwewon oHwewon) {
		if(Integer.parseInt(cSugangsincheon.CGrade(oHwewon))+Integer.parseInt(oLecture.getCredits())>19) {
			System.out.println("�����ʰ��Դϴ�.");
			this.show(oHwewon);
        	System.exit(0);
		}
	}
	public void LecturePlan(OHwewon oHwewon) {
		System.out.println("���� ��ȹ�� �޴�");
		System.out.println("���¸� �����ϼ���.");
		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "���и�");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if(campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "������ ���¸�");
					if(oLecture != null) {
						cSugangsincheon.CLecturePlan(oLecture, oHwewon);
					}
					else {
						System.out.println("�ùٸ��� ���� ���¸� �����Ͽ����ϴ�.");
					}
				}
			}
		}
	}
}