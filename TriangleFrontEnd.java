//written by ty west
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class TriangleFrontEnd extends Canvas{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fractal Triangle");
		frame.setSize(900,900);
		TriangleFrontEnd TF = new TriangleFrontEnd();
		frame.add(TF);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) 
	{
		drawTriangle(0,0,this.getSize().height, g);
		drawWhite(0,this.getSize().height,this.getSize().height,g);
	}
	public void drawTriangle(int x, int y, int side, Graphics g) {
		int sub = side;
		int n = 3;
		int[] XB = new int[]{x, sub/2, sub};
		int[] YB = new int[] {y+side, y, y+side};
		Polygon B = new Polygon(XB, YB, n);
		g.fillPolygon(B);	
		}
	
	public void drawWhite(int x, int y, int side, Graphics g) {
		Color white = new Color(255,255,255);
		if(side >= 4) {
		g.setColor(white);
		int xsub = side/4;
		int ysub = side/2;
		int[] X = new int[] {x +xsub , x +(side-xsub), x+ysub};
		int[] Y = new int[] {y-ysub, y-ysub, y};
		Polygon W = new Polygon(X,Y,3);
		g.fillPolygon(W);
		if(xsub >= 4) {
			drawWhite(x+xsub,y-ysub,ysub,g); //up triangle
			drawWhite(x,y,ysub,g);//down left triangle
			drawWhite(x+ysub,y,ysub,g);
		}
		}
	}
}