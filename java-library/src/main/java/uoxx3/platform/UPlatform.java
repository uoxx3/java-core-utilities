package uoxx3.platform;

import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uoxx3.UAssert;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enumerated type for identification of the operating system on which the JVM is running.
 */
public enum UPlatform {
	/**
	 * Free BSD operating system family
	 */
	FREE_BSD("^(freebsd|free)"),
	
	/**
	 * Linux operating system family (distros)
	 */
	LINUX("^(linux)"),
	
	/**
	 * Mac operating system family (IOS not supported)
	 */
	MACOS("^(mac)"),
	
	/**
	 * Solaris operating system family
	 */
	SOLARIS("^(sunos|sun)"),
	
	/**
	 * Windows operating system family
	 */
	WINDOWS("^(windows|win)"),
	
	/**
	 * Unknown platform. Used only to represent an error
	 */
	UNKNOWN(null);
	
	/* -----------------------------------------------------
	 * Properties
	 * ----------------------------------------------------- */
	
	/**
	 * Platform pattern
	 */
	private final @Nullable Pattern pattern;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructor with regular expression
	 *
	 * @param regex target regular expression to detect the platform
	 */
	UPlatform(@Nullable @RegExp String regex) {
		pattern = regex == null ? null :
				  Pattern.compile(regex);
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Checks if the platform is Unix-like (including FreeBSD, Linux, macOS, and Solaris).
	 *
	 * @return true if the platform is Unix-like, false otherwise
	 */
	public boolean isUnixLike() {
		return switch (this) {
			case FREE_BSD, LINUX, MACOS, SOLARIS -> true;
			default -> false;
		};
	}
	
	/* -----------------------------------------------------
	 * Static methods
	 * ----------------------------------------------------- */
	
	/**
	 * Retrieves a UPlatform instance from a given name.
	 *
	 * @param name the name of the platform
	 * @return an Optional containing the UPlatform instance if found, otherwise empty
	 */
	public static @NotNull Optional<UPlatform> fromName(@NotNull CharSequence name) {
		UAssert.paramNotNull(name, "CharSequence name");
		// Clean the platforms and only leave those that are valid and in
		// addition, we verify that the name does not contain foreign elements.
		String clearName = name.toString().toLowerCase().trim();
		
		for (UPlatform platform : values()) {
			// Ignore invalid platforms
			if (platform.pattern == null) continue;
			
			// We verify that the platform is within the valid elements
			Matcher matcher = platform.pattern.matcher(clearName);
			if (matcher.find()) {
				return Optional.of(platform);
			}
		}
		
		return Optional.empty();
	}
	
	/**
	 * Retrieves a UPlatform instance from a given name, or returns UNKNOWN if not found.
	 *
	 * @param name the name of the platform
	 * @return the UPlatform instance if found, otherwise UNKNOWN
	 */
	public static @NotNull UPlatform fromNameOrUnknown(@NotNull CharSequence name) {
		return fromName(name).orElse(UNKNOWN);
	}
	
	/**
	 * Retrieves the current running platform based on the JVM properties.
	 *
	 * @return the UPlatform instance representing the current running platform
	 */
	public static @NotNull UPlatform currentRunningPlatform() {
		// Get platform name from JVM properties
		return fromNameOrUnknown(System.getProperty("os.name"));
	}
	
}
