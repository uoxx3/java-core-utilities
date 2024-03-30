package uoxx3;

import androidx.annotation.NonNull;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class UError {
	
	/**
	 * This class cannot be instantiated
	 */
	private UError() {
		throw new Error("cannot be instantiated");
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Extracts the stack trace of a Throwable up to a specified depth.
	 *
	 * @param throwable the Throwable to extract the stack trace from, not null
	 * @param deep      the maximum depth to search for the root cause, >= 0
	 * @return the stack trace of the Throwable as a CharSequence
	 */
	public static @NonNull CharSequence extractStackTrace(@NonNull Throwable throwable, int deep) {
		UAssert.paramNotNull(throwable, "Throwable throwable");
		// We generate the objects in charge of extracting the error stack
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		Throwable se = rootError(throwable, deep);
		
		// Using the method itself to print the error stack, it is used to extract the stack
		se.printStackTrace(pw);
		pw.flush();
		
		return sw.getBuffer();
	}
	
	/**
	 * Extracts the full stack trace of a Throwable.
	 *
	 * @param throwable the Throwable to extract the stack trace from, not null
	 * @return the full stack trace of the Throwable as a CharSequence
	 */
	public static @NonNull CharSequence extractStackTrace(@NonNull Throwable throwable) {
		return extractStackTrace(throwable, 0);
	}
	
	/**
	 * Returns the root cause of a Throwable up to a specified depth.
	 *
	 * @param throwable the Throwable to get the root cause from, not null
	 * @param deep      the maximum depth to search for the root cause, >= 0
	 * @return the root cause of the Throwable, or the Throwable itself if no root cause is found
	 */
	public static @NonNull Throwable rootError(@NonNull Throwable throwable, int deep) {
		UAssert.paramNotNull(throwable, "Throwable throwable");
		// We limit the depth of the parameter so that unexpected errors do not occur
		deep = Math.max(0, deep);
		
		// Determine the current value and the next iteration using temporary variables
		Throwable current = throwable;
		int iteration = 0;
		
		// Perform an iteration until some of the conditions are true:
		//     - That the iteration number is equal to the established limit
		//     - Let the error be the base error of the stack <null>
		while (deep == 0 || iteration < deep) {
			if (current.getCause() == null) break;
			
			current = current.getCause();
			iteration++;
		}
		
		return current;
	}
	
	/**
	 * Returns the root cause of a Throwable up to a specified depth.
	 *
	 * @param throwable the Throwable to get the root cause from, not null
	 * @return the root cause of the Throwable, or the Throwable itself if no root cause is found
	 */
	public static @NonNull Throwable rootError(@NonNull Throwable throwable) {
		return rootError(throwable, 0);
	}
	
}
