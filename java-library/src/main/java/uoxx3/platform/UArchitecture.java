package uoxx3.platform;

import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uoxx3.UAssert;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enumerated type for listing the processor architectures of the
 * platform on which the JVM is running
 */
public enum UArchitecture {
	
	/**
	 * ARM architecture (The new Apple devices run in this architecture)
	 */
	ARM("(arm)"),
	
	/**
	 * 64-bit architecture
	 */
	X64("(x64|amd64|sparc|ppc|aarch64)"),
	
	/**
	 * 32-bit architecture
	 */
	X86("(x86|i386)"),
	
	/**
	 * Unknown architecture. Used only to represent an error
	 */
	UNKNOWN(null);
	
	/* -----------------------------------------------------
	 * Properties
	 * ----------------------------------------------------- */
	
	/**
	 * Regular expression used to detect
	 * the device architecture
	 */
	@Nullable
	private final Pattern pattern;
	
	/* -----------------------------------------------------
	 * Constructor
	 * ----------------------------------------------------- */
	
	/**
	 * Constructor for specific architecture
	 *
	 * @param regex regular expression detector
	 */
	UArchitecture(@Nullable @RegExp String regex) {
		pattern = regex == null ? null :
				  Pattern.compile(regex);
	}
	
	/* -----------------------------------------------------
	 * Static methods
	 * ----------------------------------------------------- */
	
	/**
	 * Retrieves a UArchitecture instance from a given name.
	 *
	 * @param name the name of the architecture
	 * @return an Optional containing the UArchitecture instance if found, otherwise empty
	 * @throws NullPointerException if the name is null
	 */
	public static @NotNull Optional<UArchitecture> fromName(@NotNull CharSequence name) {
		UAssert.paramNotNull(name, "CharSequence name");
		// Clean the architectures and only leave those that are valid and in
		// addition, we verify that the name does not contain foreign elements.
		String clearName = name.toString().toLowerCase().trim();
		
		for (UArchitecture architecture : values()) {
			// Ignore invalid architectures
			if (architecture.pattern == null) continue;
			
			// We verify that the architecture is within the valid elements
			Matcher matcher = architecture.pattern.matcher(clearName);
			if (matcher.find()) {
				return Optional.of(architecture);
			}
		}
		
		return Optional.empty();
	}
	
	/**
	 * Retrieves a UArchitecture instance from a given name, or returns UNKNOWN if not found.
	 *
	 * @param name the name of the architecture
	 * @return the UArchitecture instance if found, otherwise UNKNOWN
	 * @throws NullPointerException if the name is null
	 */
	public static @NotNull UArchitecture fromNameOrUnknown(@NotNull CharSequence name) {
		return fromName(name).orElse(UNKNOWN);
	}
	
	/**
	 * Retrieves the current running architecture based on the JVM properties.
	 *
	 * @return the UArchitecture instance representing the current running architecture
	 */
	public static @NotNull UArchitecture currentRunningArchitecture() {
		// Get platform name from JVM properties
		return fromNameOrUnknown(System.getProperty("os.arch"));
	}
	
}
