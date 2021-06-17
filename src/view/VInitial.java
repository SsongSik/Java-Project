package view;

import java.io.IOException;
import java.util.Scanner;

import valueObject.OHwewon;

public class VInitial {
   
   private Scanner scanner;
   private VHwewonDeungrok hwewonDeungrok;
   private VLogin login;
   private VManager vManager;
   private VHwewoninfo vHwewoninfo;
   
   private VSugangsincheon vSugangsincheon;
   
   public VInitial(Scanner scanner) {
      this.scanner = scanner;
      this.hwewonDeungrok = new VHwewonDeungrok(scanner);
      this.login = new VLogin(scanner);
      this.vManager = new VManager(scanner);
      this.vHwewoninfo = new VHwewoninfo(scanner);
   }

   public void show() {

      while(true) {
    	  System.out.println("���� ����� ���� �ϼ���");
          System.out.println("�α���(1), ȸ�����(2)");
         int menuNum = this.scanner.nextInt();
         
         if (menuNum == 1) {
            OHwewon oHwewon = this.login.show();
            if(oHwewon != null) {
            	if(oHwewon.getId().equals("manager")) {
            		System.out.println("������ �������� �����Ͽ����ϴ�.");
            		while(true) {
            			vManager.show(oHwewon);
            			break;
            		}
            		break;
            	}
            	else {
            		while(true) {
            		System.out.println(oHwewon.getName()+"�� �ȳ��ϼ���..");
            		System.out.println("������ûȭ��(1), ȸ������(2)");
            		int num1 = this.scanner.nextInt();
            		
            		if(num1==1) {
		            	this.vSugangsincheon = new VSugangsincheon(this.scanner);
		            	this.vSugangsincheon.show(oHwewon);
		            	break;
            		}
            		else if(num1==2) {
            			this.vHwewoninfo.show(oHwewon);
            			continue;
            		}
            		else {
            			System.out.println("�߸��Է��Ͽ����ϴ�.");
            			continue;
            		}
            		}
            		break;
            	}
            }
            
         } else if (menuNum == 2) {
            this.hwewonDeungrok.show();
            continue;
         } else {
            System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            continue;
         }
         }
      
   }

}