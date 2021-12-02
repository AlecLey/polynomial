import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project06 extends Frame implements ActionListener {
	// Shape Parameters
	String command = "";

	int xOrigin = 0;
	int yOrigin = 0;
	int ww;
	int wh;
	Poly p;
	Trigonometry t;
	Font f = new Font("SansSerif", Font.BOLD, 12);
	Font f1 = new Font("SansSerif", Font.BOLD, 14);
	// Colors

	public static void main(String[] args) {
		Frame frame = new Project06();
		frame.setResizable(true);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}

	public Project06() {
		setTitle("Polynomial");
		// Create Menu

		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu menu = new Menu("File");
		mb.add(menu);
		// File Menu items
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		menu.add(miAbout);

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		menu.add(miExit);
		// Polynomial
		Menu polyMenu = new Menu("Polynomial");
		mb.add(polyMenu);

		MenuItem miCoeff = new MenuItem("Get Coefficients");
		miCoeff.addActionListener(this);
		polyMenu.add(miCoeff);

		MenuItem miDisplay = new MenuItem("Display Polynomial");
		miDisplay.addActionListener(this);
		polyMenu.add(miDisplay);

		// Trigonometry Menu
		Menu trigMenu = new Menu("Trignometric Functions");
		mb.add(trigMenu);

		MenuItem miSin = new MenuItem("Sin");
		miSin.addActionListener(this);
		trigMenu.add(miSin);
		
		MenuItem miCosin = new MenuItem("Cosin");
		miCosin.addActionListener(this);
		trigMenu.add(miCosin);
		
		MenuItem miTangent = new MenuItem("Tangent");
		miTangent.addActionListener(this);
		trigMenu.add(miTangent);
		
		MenuItem miSecant = new MenuItem("Secant");
		miSecant.addActionListener(this);
		trigMenu.add(miSecant);
		
		MenuItem miCosecant = new MenuItem("Cosecant");
		miCosecant.addActionListener(this);
		trigMenu.add(miCosecant);
		
		// End program when window is closed
		WindowListener l = new WindowAdapter() {

			// window closed - exit program
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}

			// menu option selected - go to redraw and display method
			public void listener(WindowEvent ev) {
				repaint();
			}

			// window resized or refocused - redraw
			public void windowStateChanged(WindowEvent ev) {
				repaint();
			}

		};

		ComponentListener k = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		};

		// register listeners

		this.addWindowListener(l);
		this.addComponentListener(k);
	}

	// ******************************************************************************
	// called by windows manager whenever the application window performs an action
	// (select a menu item, close, resize, ....
	// ******************************************************************************
	public void actionPerformed(ActionEvent ev) {
		// figure out which command was issued

		command = ev.getActionCommand();

		// take action accordingly
		switch (command) {
		case "About": {
			repaint();
			break;
		}
		case "Exit": {
			System.exit(0);
			break;
		}
		case "Get Coefficients": {
			p = new Poly();
			p.readCoefficients();
			break;
		}
		case "Display Polynomial": {
			repaint();
			break;
		}
		case "Sin":
		case "Cosin":
		case "Tangent":
		case "Secant":
		case "Cosecant": {
			t = new Trigonometry();
			repaint();
			break;
		}

		}

	}

	// ********************************************************
	// called by repaint() to redraw the screen
	// ********************************************************
	public void paint(Graphics g) {
		// Draw Axis Lines
		int ww = (int) this.getWidth();
		int wh = (int) this.getHeight() - 40;
		g.setFont(f);
		// Draw Axis
		xOrigin = ww / 2;
		yOrigin = wh / 2 + 40;
		
		g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight() + 40);
        g.drawLine(0, (getHeight() + 40) / 2, getWidth(), (getHeight() + 40) / 2);        

		// Check Command issued, take action accordingly
		switch (command) {
		case "About": {
			g.drawString(" Graphs of polynomials and trigonometric function", 200, 100);
			g.drawLine(350, 120, 550, 120);
			g.drawString(
					" This program supports the support drawing the graph of polynomials and trigonometric function ",
					200, 140);
			g.drawString(" attributes (degree of polynomial and a list of present exponents and their associated coefficient): ", 200,
					160);
			g.drawString(" 1.      Sin --- draws the graph of Sin function.", 400, 200);
			g.drawString(" 2.      Cosin --- draws the graph of Cosin function.", 400, 220);
			g.drawString(" 3.      Tangent --- draws the graph of Tangent function.", 400, 240);
			g.drawString(" 4.      Secant --- draws the graph of Secant ( 1/cos(x) ) function.", 400, 260);
			g.drawString(" 5.      Cosecant --- draws the graph of Cosecant ( 1/sin(x) ) function.", 400, 280);
			break;
		}
		case "Display Polynomial": {
			// calculate x and y based on current width of the window
			p.calculateY(ww);
			// draw Y-Axis labels

			// draw polynomial
			displayGraph(g, xOrigin, yOrigin, "P(x) = " + p.toString(), p.getX(), p.getY());
			break;
		}
		case "Sin": {
			t.calculateSin(ww);
			int[] xs = t.getX();
			double[] ys = t.getY();

			displayGraph(g, xOrigin, yOrigin, "F(x) = sin(x)", xs, ys);
			break;
		}
		case "Cosin": {
			t.calculateCos(ww);
			int[] xs = t.getX();
			double[] ys = t.getY();

			displayGraph(g, xOrigin, yOrigin, "F(x) = cos(x)", xs, ys);
			break;
		}
		case "Tangent": {
			t.calculateTan(ww);
			int[] xs = t.getX();
			double[] ys = t.getY();

			displayGraph(g, xOrigin, yOrigin, "F(x) = tan(x)", xs, ys);
			break;
		}
		case "Secant": {
			t.calculateSec(ww);
			int[] xs = t.getX();
			double[] ys = t.getY();

			displayGraph(g, xOrigin, yOrigin, "F(x) = sec(x)", xs, ys);
			break;
		}
		case "Cosecant": {
			t.calculateCosec(ww);
			int[] xs = t.getX();
			double[] ys = t.getY();

			displayGraph(g, xOrigin, yOrigin, "F(x) = cosec(x)", xs, ys);
			break;
		}

		}
	}

	public void displayGraph(Graphics g, int xOrigin, int yOrigin, String label, int[] x, double[] y) {
		g.setColor(Color.RED);
		g.setFont(f1);
		g.drawString(label, 40, 100);
		int xp = x[0];
		int yp = (int) y[0];
		for (int i = 1; i < x.length; i++) {
			g.drawLine(xp + xOrigin, yOrigin - yp, x[i] + xOrigin, yOrigin - (int) y[i]);
			xp = x[i];
			yp = (int) y[i];
		}
		g.setFont(f);
		g.setColor(Color.BLACK);
	}
}
