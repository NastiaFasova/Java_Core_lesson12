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
				System.out.println("ћ≥с€ц≥ т≥Їњ ж самоњ пори року: ");
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
				System.out.println("ћ≥с€ц≥ з такою ж самою к≥льк≥стю дн≥в: ");
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
				System.out.println("ћ≥с€ц≥ з меншою к≥льк≥стю дн≥в: ");
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
				System.out.println("ћ≥с€ц≥ з б≥льшою к≥льк≥стю дн≥в: ");
				for (Month mon : m) {
					if(mon.getDays()>daysNumber)
						System.out.println(mon.toString());
				}
				break;
			}
			case "6":{
				System.out.println("¬вед≥ть назву пори року: ");
				String season = scan.next().toUpperCase();
				boolean flag = isSeasonExisted(s, season);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				} else {
					System.out.println("Ќаступна пора року: ");
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
				System.out.println("¬вед≥ть назву пори року: ");
				String season = scan.next().toUpperCase();
				boolean flag = isSeasonExisted(s, season);
				if(!flag) {
					throw new WrongInputConsoleParametersException("This month doesn't exist");
				} else{
					System.out.println("ѕопередн€ пора року: ");
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
				System.out.println("ћ≥с€ц≥ ≥з парною к≥льк≥стю дн≥в: ");
				for (Month mon : m) {
					if(mon.getDays()%2==0)
						System.out.println(mon.toString());
				}
				break;
			}
			case "9":{
				System.out.println("ћ≥с€ц≥ ≥з непарною к≥льк≥стю дн≥в: ");
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
						System.out.println("¬ведений вами м≥с€ць маЇ парну к≥льк≥сть дн≥в");
					}
					else
						System.out.println("¬ведений вами м≥с€ць маЇ непарну к≥льк≥сть дн≥в");
					}
				break;
			
			}
			
			}

		}

	}
	static void menu() {
		System.out.println("¬вед≥ть 1, €кщо хочете перев≥рити чи Ї такий м≥с€ць: ");
		System.out.println("¬вед≥ть 2, €кщо хочете вивести вс≥ м≥с€ц≥ т≥Їњ ж пори року: ");
		System.out.println("¬вед≥ть 3, €кщо хочете вивести вс≥ м≥с€ц≥ з т≥Їю ж к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 4, €кщо хочете вивести вс≥ м≥с€ц≥ з меншою к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 5, €кщо хочете вивести вс≥ м≥с€ц≥ з б≥льшою к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 6, €кщо хочете вивести наступну пору року: ");
		System.out.println("¬вед≥ть 7, €кщо хочете вивести попередню пору року: ");
		System.out.println("¬вед≥ть 8, €кщо хочете вивести вс≥ м≥с€ц≥ ≥з парною к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 9, €кщо хочете вивести вс≥ м≥с€ц≥ ≥з непарною к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 10, €кщо хочете перев≥рити чи введений вами м≥с€ць маЇ парну к≥льк≥сть дн≥в: ");
	}
	
	public static String askMonth(Scanner scan) throws WrongInputConsoleParametersException {
		String paternFormat = "[a-zA-Z]*";
		Exception e=new Exception();
		System.out.println("¬вед≥ть назву м≥с€ц€: ");
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
				System.out.println("ћ≥с€ць ≥снуЇ");
				flag = true;
			} 
		}
		return flag;
	}
	public static boolean isSeasonExisted(ArrayList<Seasons> s, String season) {
		boolean flag = false;
		for (Seasons seas : s) {
			if (seas.name().equalsIgnoreCase(season)) {
				System.out.println("ѕора року ≥снуЇ");
				flag = true;
			} 
		}
		return flag;
	}

}
