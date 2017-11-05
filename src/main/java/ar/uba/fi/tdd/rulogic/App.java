package ar.uba.fi.tdd.rulogic;

import java.io.IOException;
import java.util.Scanner;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

/**
 * Console application.
 *
 */
public class App {
	private static KnowledgeBase knowledgeBase = null;

	public static void main(String[] args) {
		System.out.println("I shall answer all your questions!");
		System.out.println("Input Knowledge base database path.");
		Scanner sn = new Scanner(System.in);
		getDatabase(sn);
		queryLoop(sn);
		sn.close();
	}

	private static void queryLoop(Scanner sn) {
		System.out.println("Type 'exit' to exit.");
		while (true) {
			System.out.println("Enter your query:");
			String input = sn.nextLine();
			if (input.equals("exit")){
				System.out.println("Goodbye");
				break;
			}
			try {
				String result;
				if(knowledgeBase.answer(input)){
					result = "SI";
				}else{
					result = "NO";
				}
				System.out.println("Answer: "+ result);
			} catch (Exception e) {
				System.out.println("Error processing query: " + e.toString());
			}
		}
	}

	private static void getDatabase(Scanner sn) {
		while (knowledgeBase == null) {
			try {
				knowledgeBase = new KnowledgeBase(sn.nextLine());
			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Database has invalid data: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unknown error: " + e.getMessage());
			}
		}
	}
}
