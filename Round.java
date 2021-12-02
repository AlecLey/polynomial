public class Round {
	public static double roundDigits(double k, int d) {
		return Math.round(k * Math.pow(10, d)) / Math.pow(10, d);

	}
}