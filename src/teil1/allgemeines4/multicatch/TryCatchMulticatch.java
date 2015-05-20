package teil1.allgemeines4.multicatch;

import java.time.format.DateTimeParseException;

public class TryCatchMulticatch {

	public static void main(String[] args) {
		try {

			dangerousCode();

		} catch (NumberFormatException | DateTimeParseException e) {
			handleFormatException(e);

		} catch (Exception e) {
			handleTechnicalException(e);
		}
	}

	private static void dangerousCode() throws Exception {
		System.out.println("don't execute me, i could throw an exception!!!");
	}

	private static void handleFormatException(Exception e) {
		System.out.println("Format error: " + e.getMessage());
	}

	private static void handleTechnicalException(Exception e) {
		System.err.println("Technical error: " + e.getMessage());
	}
}
