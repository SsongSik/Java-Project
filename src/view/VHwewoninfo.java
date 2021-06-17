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
		
		System.out.println(oHwewon.getName()+"�� ȸ���������� ���̽��ϴ�.");
		
		while(true) {
		System.out.println("������ȸ(1), ��й�ȣ����(2), ���� �޴��� ���ư���(3)");
		int input = this.scanner.nextInt();
		if(input==1) {
			System.out.println("���̵� : "+oHwewon.getId());
			System.out.println("��й�ȣ : "+oHwewon.getPassword());
			System.out.println("�̸� : "+oHwewon.getName());
			System.out.println("�ּ� : "+oHwewon.getAddress());
			System.out.println("�а� : "+oHwewon.getHwakgwa());
			System.out.println("�ڵ�����ȣ : "+oHwewon.getPhoneNum());	
		}
		
		if(input==2) {
			String password;
			while(true) {
				  System.out.println("������ ��й�ȣ�� �Է��ϼ���.");
		          password = scanner.next();
		          if(password.length()>=7) {
		        	  break;
		          }
		          else {
		        	  System.out.println("7�ڸ� �̻� �Է��� �ּ���.");
		          }
		      }
			System.out.println("�ѹ� �� �Է����ּ���.");
			String password2 = scanner.next();
			if(password.equals(password2)) {
				cHwewoninfo.changepw(oHwewon, password);
			}
			else {
				System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
			}
		}
		else if(input==3) {
			break;
		}
		}
	}
}
