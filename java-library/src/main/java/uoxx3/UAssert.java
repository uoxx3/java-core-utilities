package uoxx3;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UAssert {
	
	/**
	 * This class cannot be instantiated
	 */
	private UAssert() {
		throw new Error("cannot be instantiated");
	}
	
	/* -----------------------------------------------------
	 * Parameters methods
	 * ----------------------------------------------------- */
	
	@Contract("null, _ -> fail")
	public static void paramNotNull(@Nullable Object param, @Nullable String name) {
		if (param != null) return;
		throw new IllegalArgumentException(assertParamError(
			name,
			"The parameter must not be <null>.",
			"The parameter \"%s\" must not be <null>."));
	}
	
	@Contract("null -> fail")
	public static void paramNotNull(@Nullable Object param) {
		paramNotNull(param, null);
	}
	
	/* -----------------------------------------------------
	 * Parameter types methods
	 * ----------------------------------------------------- */
	
	@Contract("null, _ -> fail")
	public static void paramArrayType(@Nullable Object param, @Nullable String name) {
		paramNotNull(param, "Object param");
		
		// Check if the parameter is an array
		if (param.getClass().isArray()) return;
		throw new IllegalArgumentException(assertParamError(
			name,
			"The parameter is not an array.",
			"The parameter \"%s\" is not an array."));
	}
	
	public static void paramType(boolean nullable, @Nullable Object param, @NotNull Class<?> type, @Nullable String name) {
		// First check the <nullable> property
		paramNotNull(type, "Class<?> type");
		if (param == null && nullable) return;
		paramNotNull(param, "Object param");
		
		Class<?> paramType = param.getClass();
		boolean typeCheck = type.isInterface() ?
							type.isAssignableFrom(paramType) :
							type.isInstance(param);
		
		if (typeCheck) return;
		throw new IllegalArgumentException(assertParamError(
			name,
			"The parameter \"%s\" is not of type \"%s\". An object of type \"%s\" was passed.",
			"The parameter is not of type \"%s\". An object of type \"%s\" was passed.",
			type.getCanonicalName(),
			paramType.getCanonicalName()));
	}
	
	public static void paramType(@Nullable Object param, @NotNull Class<?> type, @Nullable String name) {
		paramType(false, param, type, name);
	}
	
	public static void paramType(@Nullable Object param, @NotNull Class<?> type) {
		paramType(param, type, null);
	}
	
	/* -----------------------------------------------------
	 * Internal methods
	 * ----------------------------------------------------- */
	
	private static @NotNull String assertParamError(
		@Nullable String name,
		@NotNull String emptyFormat,
		@NotNull String paramFormat,
		Object @NotNull ... args
	) {
		Object[] formatArgs;
		String messageFormat;
		
		if (name == null) {
			messageFormat = emptyFormat;
			formatArgs = args;
		} else {
			messageFormat = paramFormat;
			formatArgs = new Object[args.length + 1];
			
			// The property name always be the first element
			formatArgs[0] = name;
			System.arraycopy(args, 0, formatArgs, 1, args.length);
		}
		
		return messageFormat.formatted(formatArgs);
	}
	
}
