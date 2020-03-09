package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	/**
	 * @param args
	 * @throws WrongInputConsoleParametersException 
	 */
	public static void main(String[] args) throws WrongInputConsoleParametersException {
	
		ArrayList<Month> m =new ArrayList<>();
		ArrayList<Seasons> s =new ArrayList<>();
		
		for(Month mon : Month.values()) {
			m.add(mon);
		}
		
		for(Seasons seas : Seasons.values()) {
			s.add(seas);
		}
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			menu();
			String choice=scan.next();
			try {
				Integer.parseInt(choice);
				} catch (Exception e) {
				System.out.println("You entered the wrong number!");
				}
			switch (choice) {
			case "1": {
				String month = askMonth(scan);
				boolean flag = isMonthExisted(m, month);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				}
				break;

			}
			case "2":{
				String month = askMonth(scan);
				boolean flag = isMonthExisted(m, month);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				}
				String season = Month.valueOf(month).getSeasons().toString();
				System.out.println("̳���� 򳺿 � ���� ���� ����: ");
				for (Month mon : m) {
					if(Month.valueOf(mon.toString()).getSeasons().toString().equals(season))
						System.out.println(mon.toString());
				}
				break;
			}
			case "3":{
				String month = askMonth(scan);
				boolean flag = isMonthExisted(m, month);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				}
				int daysNumber=Month.valueOf(month).getDays();
				System.out.println("̳���� � ����� � ����� ������� ���: ");
				for (Month mon : m) {
					if(mon.getDays()==daysNumber)
						System.out.println(mon.toString());
				}
				break;
			}
			case "4":{
				String month = askMonth(scan);
				boolean flag = isMonthExisted(m, month);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				}
				int daysNumber=Month.valueOf(month).getDays();
				System.out.println("̳���� � ������ ������� ���: ");
				for (Month mon : m) {
					if(mon.getDays()<daysNumber)
						System.out.println(mon.toString());
				}
				break;
			}
			case "5":{
				String month = askMonth(scan);
				boolean flag = isMonthExisted(m, month);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				}
				int daysNumber=Month.valueOf(month).getDays();
				System.out.println("̳���� � ������ ������� ���: ");
				for (Month mon : m) {
					if(mon.getDays()>daysNumber)
						System.out.println(mon.toString());
				}
				break;
			}
			case "6":{
				System.out.println("������ ����� ���� ����: ");
				String season = scan.next().toUpperCase();
				boolean flag = isSeasonExisted(s, season);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				} else {
					System.out.println("�������� ���� ����: ");
					Seasons seas = Seasons.valueOf(season);
					int ordinal=seas.ordinal();
					if(ordinal==(s.size()-1)) {
						ordinal=0;
						System.out.println(s.get(ordinal));
					}
					else {
						System.out.println(s.get(ordinal+1));
					}
				}
				
				break;
			}
			case "7":{
				System.out.println("������ ����� ���� ����: ");
				String season = scan.next().toUpperCase();
				boolean flag = isSeasonExisted(s, season);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				} else{
					System.out.println("��������� ���� ����: ");
					Seasons seas = Seasons.valueOf(season);
					int ordinal=seas.ordinal();
					if(ordinal==0) {
						ordinal=s.size()-1;
						System.out.println(s.get(ordinal));
					}
					else {
						System.out.println(s.get(ordinal+1));
					}
				}
				break;
			}
			case "8":{
				System.out.println("̳���� �� ������ ������� ���: ");
				for (Month mon : m) {
					if(mon.getDays()%2==0)
						System.out.println(mon.toString());
				}
				break;
			}
			case "9":{
				System.out.println("̳���� �� �������� ������� ���: ");
				for (Month mon : m) {
					if(mon.getDays()%2!=0)
						System.out.println(mon.toString());
				}
				break;
			}
			case "10":{
				String month = askMonth(scan);
				boolean flag = isMonthExisted(m, month);
				int daysNumber=Month.valueOf(month).getDays();
				if(!flag) {
					throw new WrongInputConsoleParametersException("This season doesn't exist");
				} else {
					if(daysNumber%2==0) {
						System.out.println("�������� ���� ����� �� ����� ������� ���");
					}
					else
						System.out.println("�������� ���� ����� �� ������� ������� ���");
					}
				break;
			
			}
			
			}

		}

	}
	static void menu() {
		System.out.println("������ 1, ���� ������ ��������� �� � ����� �����: ");
		System.out.println("������ 2, ���� ������ ������� �� ����� 򳺿 � ���� ����: ");
		System.out.println("������ 3, ���� ������ ������� �� ����� � �� � ������� ���: ");
		System.out.println("������ 4, ���� ������ ������� �� ����� � ������ ������� ���: ");
		System.out.println("������ 5, ���� ������ ������� �� ����� � ������ ������� ���: ");
		System.out.println("������ 6, ���� ������ ������� �������� ���� ����: ");
		System.out.println("������ 7, ���� ������ ������� ��������� ���� ����: ");
		System.out.println("������ 8, ���� ������ ������� �� ����� �� ������ ������� ���: ");
		System.out.println("������ 9, ���� ������ ������� �� ����� �� �������� ������� ���: ");
		System.out.println("������ 10, ���� ������ ��������� �� �������� ���� ����� �� ����� ������� ���: ");
	}
	
	public static String askMonth(Scanner scan) throws WrongInputConsoleParametersException {
		String paternFormat = "[a-zA-Z]*";
		Exception e=new Exception();
		System.out.println("������ ����� �����: ");
		String month = scan.next();
		if(month.length()<3)
			throw new WrongInputConsoleParametersException("Your input contains less characters than any month...");
		if(!month.matches(paternFormat))
			throw new WrongInputConsoleParametersException("Your input contains unappropriate characters...");
		return month;
	}

	
	public static boolean isMonthExisted(ArrayList<Month> m, String month) {
		boolean flag = false;
		for (Month mon : m) {
			if (mon.name().equalsIgnoreCase(month)) {
				System.out.println("̳���� ����");
				flag = true;
			} 
		}
		return flag;
	}
	public static boolean isSeasonExisted(ArrayList<Seasons> s, String season) {
		boolean flag = false;
		for (Seasons seas : s) {
			if (seas.name().equalsIgnoreCase(season)) {
				System.out.println("���� ���� ����");
				flag = true;
			} 
		}
		return flag;
	}

}
