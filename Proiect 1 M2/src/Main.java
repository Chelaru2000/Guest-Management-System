import java.util.Scanner;

public class Main {

	private static void showCommands() {
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println("add          - Adauga o noua persoana (inscriere)");
		System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
		System.out.println("remove       - Sterge o persoana existenta din lista");
		System.out.println("update       - Actualizeaza detaliile unei persoane");
		System.out.println("guests       - Lista de persoane care participa la eveniment");
		System.out.println("waitlist     - Persoanele din lista de asteptare");
		System.out.println("available    - Numarul de locuri libere");
		System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
		System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
		System.out.println("subscribe_no - Numarul total de persoane inscrise");
		System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
		System.out.println("save         - Salveaza lista cu invitati");
		System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
		System.out.println("reset        - Sterge informatiile salvate despre invitati");
		System.out.println("quit         - Inchide aplicatia");
	}

	private static void addNewGuest(Scanner sc, GuestsList list) {
		System.out.println("Introduceti prenumele: ");
		String firstName = sc.nextLine();

		System.out.println("Introduceti numele: ");
		String lastName = sc.nextLine();

		System.out.println("Introduceti adresa email: ");
		String email = sc.nextLine();

		System.out.println("Introduceti numarul de telefon: ");
		String phoneNumber = sc.nextLine();

		list.add(new Guest(firstName, lastName, email, phoneNumber));
	}

	private static void checkGuest(Scanner sc, GuestsList list) {
		System.err.println("1 for name, 2 for email and 3 for phone number");
		int var = sc.nextInt();
		sc.nextLine();

		switch(var) {
		case 1:
			System.out.println("First name: ");
			String firstName = sc.next();
			System.out.println("Last name: ");
			String lastName = sc.next();
			if(list.search(firstName, lastName) != null) {
				System.out.println(list.search(firstName, lastName));
				break;
			}
			else {
				System.out.println("Guest not found");
				break;
			}

		case 2:
			String var2 = sc.next();
			if(list.search(var, var2) != null) {
				System.out.println(list.search(var, var2).toString());
				break;
			} else {
				System.out.println("Guest not found");
				break;
			}

		case 3:
			String var3 = sc.next();
			if(list.search(var, var3) != null) {
				System.out.println(list.search(var, var3).toString());
				break;
			} else {
				System.out.println("Guest not found");
				break;
			}
		default:
			break;
		}
	}



	private static void removeGuest(Scanner sc, GuestsList list) {
		System.err.println("1 for name, 2 for email and 3 for phone number");
		int var = sc.nextInt();
		sc.nextLine();
		switch(var) {
		case 1:
			System.out.println("First name: ");
			String firstName = sc.next();
			System.out.println("Last name: ");
			String lastName = sc.next();
			list.remove(firstName, lastName);
			break;
		case 2:
			String email = sc.next();
			list.remove(var, email);
			break;
		case 3:
			String phoneNumber = sc.next();
			list.remove(var, phoneNumber);
			break;
		default:
			break;
		}

	}

	private static void updateGuest(Scanner sc, GuestsList list) {
		System.err.println("1 for name, 2 for email and 3 for phone number");
		int var = sc.nextInt();
		sc.nextLine();

		switch(var) {
		case 1:
			System.out.println("First name: ");
			String firstName = sc.next();
			System.out.println("Last name: ");
			String lastName = sc.next();
			if(list.search(firstName, lastName) != null) {

				System.err.println("1 for name, 2 for email and 3 for phone number");
				int var2 = sc.nextInt();
				sc.nextLine();

				switch(var2) {
				case 1:
					list.search(firstName, lastName).setFirstName(sc.nextLine());
					break;
				case 2:
					list.search(firstName, lastName).setLastName(sc.nextLine());
					break;
				case 3:
					list.search(firstName, lastName).setEmail(sc.nextLine());
					break;
				case 4:
					list.search(firstName, lastName).setPhoneNumber(sc.nextLine());
					break;
				default:
					break;
				}
			}else {
				break;
			}
		case 2:
			String email = sc.nextLine();
			System.err.println("1 for name, 2 for email and 3 for phone number");
			int var3 = sc.nextInt();
			if(list.search(var, email) != null) {
				sc.nextLine();

				switch(var3) {
				case 1:
					list.search(var, email).setFirstName(sc.nextLine());
					break;
				case 2:
					list.search(var, email).setLastName(sc.nextLine());
					break;
				case 3:
					list.search(var, email).setEmail(sc.nextLine());
					break;
				case 4:
					list.search(var, email).setPhoneNumber(sc.nextLine());
					break;

				default:
					break;
				}
			}else {
				break;
			}
		case 3:
			String phoneNumber = sc.nextLine();
			System.err.println("1 for name, 2 for email and 3 for phone number");
			int var4 = sc.nextInt();
			if(list.search(var, phoneNumber) != null) {
				sc.nextLine();

				switch(var4) {
				case 1:
					list.search(var, phoneNumber).setFirstName(sc.nextLine());
					break;
				case 2:
					list.search(var, phoneNumber).setLastName(sc.nextLine());
					break;
				case 3:
					list.search(var, phoneNumber).setEmail(sc.nextLine());
					break;
				case 4:
					list.search(var, phoneNumber).setPhoneNumber(sc.nextLine());
					break;

				default:
					break;
				}
			}else {
				break;
			}
		default:
			break;
		}
	}

	private static void searchList(Scanner sc, GuestsList list) {

		System.out.println("Insert string value: ");
		String match = sc.nextLine();
		System.out.println(list.partialSearch(match));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		scanner.nextLine();

		GuestsList list = new GuestsList(size);

		boolean running = true;
		while (running) {
			String command = scanner.nextLine();

			switch (command) {
			case "help":
				showCommands();
				break;
			case "add":
				addNewGuest(scanner, list);
				break;
			case "check":
				checkGuest(scanner, list);
				break;
			case "remove":
				removeGuest(scanner, list);
				break;
			case "update":
				updateGuest(scanner, list);
				break;
			case "guests":
				list.showGuestsList();
				break;
			case "waitlist":
				list.showWaitingList();
				break;
			case "available":
				System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
				break;
			case "guests_no":
				System.out.println("Numarul de participanti: " + list.numberOfGuests());
				break;
			case "waitlist_no":
				System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
				break;
			case "subscribe_no":
				System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
				break;
			case "search":
				searchList(scanner, list);
				break;
			case "quit":
				System.out.println("Aplicatia se inchide...");
				scanner.close();
				running = false;
				break;
			default:
				System.out.println("Comanda introdusa nu este valida.");
				System.out.println("Incercati inca o data.");

			}
		}
	}
}
