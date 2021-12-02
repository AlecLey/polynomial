public class Trigonometry {
	// data members
	private int[] x;
	private double[] y;

	// constructors
	public Trigonometry() {
		x = new int[10];
		y = new double[10];
	}

	// accessors
	public int[] getX() {
		return x;
	}

	public double[] getY() {
		return y;
	}

	public void calculateSin(int ww) {
		x = new int[ww];
		y = new double[ww];
		for (int i = -ww / 2; i < ww / 2; i++) {
			x[i + ww / 2] = i;
			y[i + ww / 2] = Math.sin(Math.toRadians(i));
		}
	}
	
	public void calculateCos(int ww) {
		x = new int[ww];
		y = new double[ww];
		for (int i = -ww / 2; i < ww / 2; i++) {
			x[i + ww / 2] = i;
			y[i + ww / 2] = Math.cos(Math.toRadians(i));
		}
	}
	
	public void calculateTan(int ww) {
		x = new int[ww];
		y = new double[ww];
		for (int i = -ww / 2; i < ww / 2; i++) {
			x[i + ww / 2] = i;
			y[i + ww / 2] = Math.tan(Math.toRadians(i));
		}
	}
	
	public void calculateSec(int ww) {
		x = new int[ww];
		y = new double[ww];
		for (int i = -ww / 2; i < ww / 2; i++) {
			x[i + ww / 2] = i;
			y[i + ww / 2] = 1 / Math.cos(Math.toRadians(i));
		}
	}
	
	public void calculateCosec(int ww) {
		x = new int[ww];
		y = new double[ww];
		for (int i = -ww / 2; i < ww / 2; i++) {
			x[i + ww / 2] = i;
			y[i + ww / 2] = 1 / Math.sin(Math.toRadians(i));
		}
	}
}

