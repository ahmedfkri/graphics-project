/**
 * @(#)Final.java
 *
 * Final Applet application
 *
 * @author
 * @version 1.00 2023/5/14
 */

import java.awt.*;
import java.awt.geom.*;
import java.applet.*;

import java.awt.image.BufferedImage;

import java.awt.geom.AffineTransform;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TheProject extends Applet implements KeyListener {




//	private BufferedImage offscreenImage;
//    private Graphics offscreenGraphics;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int W=screenSize.width;
	int H=screenSize.height;

    private int dy = 0;
    private int groundLevel = 300;

    private boolean isJumping = false;


	/**---------------Set Custom Colors-----------------**/
	Color lightBlue = Color.decode("#00A7C7");
	Color darkBlue = Color.decode("#0980B8");
	Color myGreen = Color.decode("#A6CE39");
	Color lightGround = Color.decode("#7F1333");
	Color darkGround = Color.decode("#320003");
	Color myPurple = Color.decode("#3B0457");
	Color myYellow = Color.decode("#FCB117");
	Color myYellowD = Color.decode("#F47E36");


    /**-------------Initial Position---------------------**/
	int start =50;
	int	ground=H-350;

	int X=500, Y=H-350;

	int dir=0;

	public void init() {
		addKeyListener(this);
	}

	/**------------Control---------------**/
    public void keyPressed(KeyEvent e) {
    // Handle key press event
    int keyCode = e.getKeyCode();
    switch (keyCode) {
        case KeyEvent.VK_UP:
        	isJumping=true;

        Thread animationThread = new Thread(() -> {
            while (true) {
                if (isJumping) {
                    // jump for 100 frames
                    for (int i = 0; i < 20; i++) {
                        Y -= 5;
                        repaint();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ee) {
                            ee.printStackTrace();
                        }
                    }
                    // fall for 100 frames
                    for (int j = 0; j < 20; j++) {
                        Y += 5;
                        repaint();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException eee) {
                            eee.printStackTrace();
                        }
                    }
                    isJumping = false;
                    Y=H-350;
                    repaint();
                }

            }
        });
        animationThread.start();
            break;

        case KeyEvent.VK_DOWN:
            break;
           //Handle Left Key
        case KeyEvent.VK_LEFT:
        	if(X>0){
        		 X-=50;
            repaint();
        	}
            break;
           //Handle Right Key
        case KeyEvent.VK_RIGHT:
            if(X<W-150){
        		 X+=50;
            repaint();
        	}

        default:

            break;
    }
}


    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}


    Shape[] shape = new Shape[]{
			new RoundRectangle2D.Float(100,200,400,800,500,500),
			new RoundRectangle2D.Float(8*100,200,400,800,500,500),
			new RoundRectangle2D.Float(16*100,200,400,800,500,500)
		};


	public void paint(Graphics g) {

		Graphics2D g2 =(Graphics2D) g;

		g2.setPaint(darkBlue);
		Rectangle2D rect=new Rectangle2D.Double(0,0,W,H);
		g2.fill(rect);

	/**Backround Elemnts---------------------------------------->**/
		g2.setPaint(lightBlue);
		Ellipse2D circle = new Ellipse2D.Float(W/2-50,200,100,100);
		g2.fill(circle);

		RoundRectangle2D cR =new RoundRectangle2D.Float(W-240,80,270,70,60,60);
		g2.fill(cR);
		RoundRectangle2D cL =new RoundRectangle2D.Float(-30,30,400,60,50,50);
		g2.fill(cL);



		g2.setPaint(darkGround);
		Rectangle2D rect1=new Rectangle2D.Double(0,H-200,W,100);
		g2.fill(rect1);

		g2.setPaint(lightGround);
		Rectangle2D rect2=new Rectangle2D.Double(0,ground,W,150);
		g2.fill(rect2);

		drawCharacter(g2);

	}

	void drawCharacter(Graphics2D gg){

	/**Band Tail---------------------------------------->**/
		gg.setPaint(myYellowD);
		Ellipse2D bCircle = new Ellipse2D.Float(X-28,Y-120,40,40);
		gg.fill(bCircle);

 		gg.setPaint(myYellow);
 		RoundRectangle2D rect4 =new RoundRectangle2D.Float(X-45,Y-90,50,70,60,60);
		gg.fill(rect4);
		Rectangle2D rect5=new Rectangle2D.Double(X-45,Y-60,30,40);
		gg.fill(rect5);
		Rectangle2D rect6=new Rectangle2D.Double(X-28,Y-88.25,28,60);
		gg.fill(rect6);
 	/**Main Body---------------------------------------->**/
		gg.setPaint(myPurple);
		RoundRectangle2D character =new RoundRectangle2D.Float(X,Y-165,150,150,50,50);
		gg.fill(character);

		Rectangle2D leg1=new Rectangle2D.Double(X+30,Y-40,40,40);
		gg.fill(leg1);

		Rectangle2D leg2=new Rectangle2D.Double(X+85,Y-40,40,40);
		gg.fill(leg2);
	/**Eyes---------------------------------------->**/
		gg.setPaint(Color.WHITE);
		Ellipse2D eye1 = new Ellipse2D.Float(X+80,Y-120,60,60);
		gg.fill(eye1);
		Ellipse2D eye2 = new Ellipse2D.Float(X+40,Y-120,60,60);
		gg.fill(eye2);

		gg.setPaint(Color.BLACK);
		Ellipse2D b1 = new Ellipse2D.Float(X+100,Y-100,20,20);
		gg.fill(b1);
		Ellipse2D b2 = new Ellipse2D.Float(X+60,Y-100,20,20);
		gg.fill(b2);
	/*--Band--------------------------------------->**/
		gg.setPaint(myYellow);
		Rectangle2D rect3=new Rectangle2D.Double(X-5,Y-135,155,40);
		gg.fill(rect3);
	}


}