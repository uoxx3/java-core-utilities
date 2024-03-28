module uo.core.utilities {
	/* Library module dependencies */
	requires static org.jetbrains.annotations;
	
	/* Library module package exports */
	exports uoxx3;
	exports uoxx3.error;
	exports uoxx3.functional;
	exports uoxx3.functional.consumer;
	exports uoxx3.functional.function;
	exports uoxx3.functional.supplier;
	exports uoxx3.platform;
	exports uoxx3.wrapper;
	
	/* Resource module exports */
	opens uoxx3;
}