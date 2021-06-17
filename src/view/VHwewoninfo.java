package view;

import java.util.Scanner;

import control.CHwewoninfo;
import valueObject.OHwewon;

public class VHwewoninfo {

	private Scanner scanner;
	private CHwewoninfo cHwewoninfo;
	
	public VHwewoninfo(Scanner scanner) {
		this.scanner = scanner;
		this.cHwewoninfo= new CHwewoninfo(this.scanner);
	}
	
	public void show(OHwewon oHwewon) {
		// TODO Auto-generated method stub
		
		System.out.println(oHwewon.getName()+"님 회원정보란에 오셨습니다.");
		
		while(true) {
		System.out.println("정보조회(1), 비밀번호수정(2), 이전 메뉴로 돌아가기(3)");
		int input = this.scanner.nextInt();
		if(input==1) {
			System.out.println("아이디 : "+oHwewon.getId());
			System.out.println("비밀번호 : "+oHwewon.getPassword());
			System.out.println("이름 : "+oHwewon.getName());
			System.out.println("주소 : "+oHwewon.getAddress());
			System.out.println("학과 : "+oHwewon.getHwakgwa());
			System.out.println("핸드폰번호 : "+oHwewon.getPhoneNum());	
		}
		
		if(input==2) {
			String password;
			while(true) {
				  System.out.println("변경할 비밀번호를 입력하세요.");
		          password = scanner.next();
		          if(password.length()>=7) {
		        	  break;
		          }
		          else {
		        	  System.out.println("7자리 이상 입력해 주세요.");
		          }
		      }
			System.out.println("한번 더 입력해주세요.");
			String password2 = scanner.next();
			if(password.equals(password2)) {
				cHwewoninfo.changepw(oHwewon, password);
			}
			else {
				System.out.println("비밀번호가 맞지 않습니다.");
			}
		}
		else if(input==3) {
			break;
		}
		}
	}
}
