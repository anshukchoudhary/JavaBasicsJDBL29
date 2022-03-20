package pack11;

@FunctionalInterface
public interface FIinterface {

	String calculate();

	default String calculate2() {
		return "Calculated Value";
	}
}
