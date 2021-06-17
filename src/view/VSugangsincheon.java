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
//		System.out.println(oHwewon.getName()+"님 안녕하세요..");
		File sinchoen = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
		File bag = new File("user/"+oHwewon.getId()+"_bag.txt");
		while(true) {
			if(bag.exists()) {
				System.out.println("현재 책가방 학점 : "+cMiridamgi.CMGrade(oHwewon));
			}
			else {
				System.out.println("현재 책가방 학점 : 0");
			}
		if(sinchoen.exists()) {
			System.out.println("현재 신청된 학점 : "+cSugangsincheon.CGrade(oHwewon));
		}
		else {
			System.out.println("현재 신청된 학점 : 0");
		}
		System.out.println("수강신청 및 미리담기(1) 미리담기에서 강의 삭제(2) 수강신청에서 강의 삭제(3) 책가방 목록(4) 수강신청 목록(5) 강의 계획서 조회(6) 로그아웃(7)");
		int input = this.scanner.nextInt();
		if(input == 1) {
			System.out.println("수강 신청을 시작합니다");
			String campusFileName = this.vCampus.show("root", "캠퍼스를");
			if(campusFileName != null) {
				String collegeFileName = this.vCollege.show(campusFileName, "대학를");
				if(campusFileName != null) {
					String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
					if(campusFileName != null) {
						OLecture oLecture = this.vLecture.show(departmentFileName, "강좌를");
						if(oLecture != null) {
							System.out.println("미리담기 (1), 수강신청(2)");
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
										System.out.println("미리담기 완료");
									}
									else {
										continue;
									}
								}
								else {
									cMiridamgi.CMGet(oLecture, oHwewon);
									System.out.println("미리담기 완료");
								}
							}else if(num==2){
								if(sinchoen.exists()) {
									this.gradecheck(oLecture, oHwewon);
									if(cSugangsincheon.CCheck(oLecture, oHwewon)==true) {
										cSugangsincheon.CSave(oLecture, oHwewon);
										System.out.println("수강신청 완료");
									}
									else {
										continue;
									}
								}
								else {
									cSugangsincheon.CSave(oLecture, oHwewon);
									System.out.println("수강신청 완료");
								}
//								else {
//									System.out.println("학점초과입니다.");
//									continue;
//								}
							}else {
								System.out.println("잘못 입력하셨습니다.");
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
				System.out.println("책가방에 과목이 없습니다.");
				continue;
			}
		}else if(input ==3) {
			if(sinchoen.exists()) {
				cSugangsincheon.CDelete(oHwewon);
			}
			else {
				System.out.println("신청된 과목이 없습니다.");
				continue;
			}
		}
		else if(input == 4) {
//			File ss1 = new File("user/"+oHwewon.getId()+"_bag.txt");
			if(bag.exists()) {
				if(cMiridamgi.CMShow(oHwewon)==true) {
					System.out.println("신청 완료");
				}
				else {
					continue;
				}
			}
			else {
				System.out.println("현재 책가방이 비어있습니다.");
				continue;
			}
		}
		else if(input==5) {
			if(sinchoen.exists()) {
				cSugangsincheon.CShow(oHwewon);
				continue;
			}
			else {
				System.out.println("현재 수강신청목록이 비어있습니다.");
				continue;
			}
		}
		else if(input==6) {
			this.LecturePlan(oHwewon);
			continue;
		}
		
		else if(input==7) {
			System.out.println("로그아웃");
			break;
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			continue;
		}
		}
	}
	public void gradecheck(OLecture oLecture, OHwewon oHwewon) {
		if(Integer.parseInt(cSugangsincheon.CGrade(oHwewon))+Integer.parseInt(oLecture.getCredits())>19) {
			System.out.println("학점초과입니다.");
			this.show(oHwewon);
        	System.exit(0);
		}
	}
	public void LecturePlan(OHwewon oHwewon) {
		System.out.println("깅의 계획서 메뉴");
		System.out.println("강좌를 선택하세요.");
		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학를");
			if(campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				if(campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "병경할 강좌를");
					if(oLecture != null) {
						cSugangsincheon.CLecturePlan(oLecture, oHwewon);
					}
					else {
						System.out.println("올바르지 않은 강좌를 선택하였습니다.");
					}
				}
			}
		}
	}
}