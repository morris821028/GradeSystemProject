package gradeClass;

import java.util.Scanner;

/**
 * *********************************************************************** class
 * UI (user interface)
 * 
 * checkID(ID) promptCommand() promptID() showFinishMsg() showWelcomeMsg() UI()
 * 建構子 建構 aGradeSystem
 ************************************************************************ */
import exception.*;

/** ***********************************************************************
class UI (user interface) 

checkID(ID)
promptCommand()
promptID()
showFinishMsg()
showWelcomeMsg()
UI() 建構子 建構 aGradeSystem
************************************************************************ */


public class UI {
	/**
	 * @uml.property name="aGradeSystem"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	GradeSystems aGradeSystem;
	/**
	 * @uml.property name="input"
	 */
	Scanner input;

	/**
	 * 
	 * @throws NoSuchIDExceptions
	 * @throws NoSuchCommandExceptions
	 */
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		// 1.call GradeSystems() to建構 aGradeSystem
		// 2.loop1 until Q (Quit)
		// 2.1. promptID() to get user ID 輸入ID或 Q (結束使用)？
		// 2.2. checkID (ID) 看 ID 是否在 aGradeSystem內
		// 2.3. showWelcomeMsg (ID) ex. Welcome李威廷
		// 2.4. loop2 until E (Exit)
		// promptCommand() to prompt for inputCommand
		// end loop2
		// end loop1
		// 3 .showFinishMsg() 結束了

		input = new Scanner(System.in);
		aGradeSystem = new GradeSystems();
		while (true) {
			String ID = promptID();
			if (ID.equals("Q")) {
				break;
			}
			if (checkID(ID) == true) {
				this.showWelcomeMsg(ID);
				do {
					String cmd = this.promptCommand(ID);
					if (cmd.equals("G")) {
						aGradeSystem.showGrade(ID);
					} else if (cmd.equals("R")) {
						aGradeSystem.showRank(ID);
					} else if (cmd.equals("W")) {
						aGradeSystem.updateWeights();
					} else if (cmd.equals("E")) {
						break;
					}
				} while (true);

			}

		}
		this.showFinishMsg();
	}

	/**-------------------------------------------------------------------------------------------------------------
	checkID (ID) throws NoSuchIDExceptions return Boolean
	parameter: ID   a user ID  ex: 123456789
	time:     O(n)  n is  aGradeSystem 內全班人數
	-----------------------------------------------------------------------------------------------------------------*/

	public boolean checkID(String ID) throws NoSuchIDExceptions {
		// 1. 要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內
		// 2. if not, throw an object of NoSuchIDExceptions
		// 3. 回傳 true
		if (aGradeSystem.containsID(ID)) {
			return true;
		} else {
			throw new NoSuchIDExceptions();
		}
	}

	/**-------------------------------------------------------------------------------------------------------------
	promptCommand () throws NoSuchCommandExceptions
	-----------------------------------------------------------------------------------------------------------------*/

	public String promptCommand(String ID) throws NoSuchCommandExceptions {
		// 1. prompt user for inputCommand
		// 2. if inputCommand is not 'G' (Grade), 'R' (Rank), 'W' (Weights), or
		// 'E' (Exit), throws an object of NoSuchCommandException
		// 3. if inputCommand is E (Exit) then break
		// else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights()
		// end if
		//
		System.out.println("輸入指令 1) G 顯示成績 (Grade)\n"
				+ "      2) R 顯示排名 (Rank)\n" + "      3) W 更新配分 (Weight)\n"
				+ "      4) E 離開選單 (Exit)\n");
		String cmd = input.next();
		if (cmd.equals("G")) {
		} else if (cmd.equals("R")) {
		} else if (cmd.equals("W")) {
		} else if (cmd.equals("E")) {
		} else {
			throw new NoSuchCommandExceptions();
		}
		return cmd;
	}

	/**
	 * 
	 * @return token of user input.
	 */
	public String promptID() {
		System.out.println("輸入ID或 Q (結束使用)？");
		return input.next();
	}

	public void showFinishMsg() {
		System.out.println("結束了");
	}

	/**
	 * Show command style welcome message with ID.
	 * 
	 * @param ID
	 */
	public void showWelcomeMsg(String ID) {
		for (int i = 0; i < aGradeSystem.aList.size(); i++) {
			if (aGradeSystem.aList.get(i).ID.equals(ID)) {
				System.out.println("Welcome " + aGradeSystem.aList.get(i).name);
			}
		}
	}
}
