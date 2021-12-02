import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Poly {
	// Data Members
	private int degree;
	private double[] coefficients;
	private int[] x;
	private double[] y;

	// constructors
	public Poly() {
		degree = 3;
		coefficients = new double[4];
		x = new int[3];
		y = new double[3];
	}

	public Poly(int d) {
		degree = d;
		coefficients = new double[d + 1];
		x = new int[d];
		y = new double[d];
	}

	// Accessors
	public int getDegree() {
		return degree;
	}

	public double[] getCoefficients() {
		return coefficients;
	}

	public int[] getX() {
		return x;
	}

	public double[] getY() {
		return y;
	}

	// Other Methods
	public void readCoefficients() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setDialogTitle("Open Data File");
		String DataFilePath = "";
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			DataFilePath = chooser.getSelectedFile().getPath();
		}

		// read data file and copy it to original array
		if (DataFilePath != null) {
			try {
				int i = 0;
				Scanner textFile = new Scanner(new File(DataFilePath));
				degree = textFile.nextInt();
				coefficients = new double[degree + 1];
				while (textFile.hasNext()) {
					// read the exponent
					i = textFile.nextInt();
					// read coefficient
					coefficients[i] = textFile.nextDouble();
				}
				// end of file detected
				textFile.close();

			} catch (IOException ioe) {
				System.exit(0);
			}

		} else
			degree = 0;
	}

	public void calculateY(int ww) {
		x = new int[ww];
		y = new double[ww];
		for (int i = -ww / 2; i < ww / 2; i++) {
			x[i + ww / 2] = i;
			y[i + ww / 2] = evaluate(i);
		}
	}

	public double evaluate(int x) {
		double result = 0;
		for (int i = coefficients.length - 1; i > 0; i--) {
			result += coefficients[i];
			result *= x;
		}
		result += coefficients[0];
		return result;
	}

	public String toString() {
		String sign = "";
		String poly = "";

		for (int i = 0; i < coefficients.length; i++) {
			if (!(coefficients[i] == 0.0)) {
				if (poly.length() > 0) {
					poly = poly + "+";
				}
				poly = poly + coefficients[i];
				if (i > 0) {
					poly = poly + "X";
					if (i > 1) {
						poly = poly + "^";
						poly = poly + i;
					}
				}
			}
		}
		System.out.println("Poly = " + poly);
		return poly;
	}
}
