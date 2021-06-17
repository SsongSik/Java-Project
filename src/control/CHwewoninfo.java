package control;

import java.util.Scanner;

import dataAccessObject.DHwewoninfo;
import valueObject.OHwewon;

public class CHwewoninfo {
	
	private Scanner scanner;
	private DHwewoninfo dHwewoninfo;
	
	public CHwewoninfo(Scanner scanner) {
		this.scanner = scanner;
		this.dHwewoninfo = new DHwewoninfo(scanner);
	}
	public void changepw(OHwewon oHwewon, String pw) {
		this.dHwewoninfo.save(oHwewon, pw);
	}
}
