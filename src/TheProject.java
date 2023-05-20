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


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int W=screenSize.width;
	int H=screenSize.height;

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


    /**<-------------Initial Position--------------------->**/
	int	ground=H-350;
	int X=500, Y=H-350;

	int dir=0;

	public void init() {
		addKeyListener(this);
		this.setSize(new Dimension(1500,2000));
	}

	/**<------------------Control----------------------->**/
    public void keyPressed(KeyEvent e) {
    // Handle key press event
    int keyCode = e.getKeyCode();

    switch (keyCode) {
        case KeyEvent.VK_UP:
        	isJumping=true;

        Thread animationThread = new Thread(() -> {
            while (true) {
                if (isJumping) {
                    // jump
                    for (int i = 0; i < 20; i++) {
                        Y -= 5;
                        repaint();
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ee) {
                            ee.printStackTrace();
                        }
                    }
                    // fall
                    for (int j = 0; j < 20; j++) {
                        Y += 5;
                        repaint();
                        try {
                            Thread.sleep(30);
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
            if(X<1500-150){
        		 X+=50;
            repaint();
        	}

        default:
            break;
    }
}


    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}


	public void paint(Graphics g) {

		Graphics2D g2 =(Graphics2D) g;

	/**Backround---------------------------------------->**/
		g2.setPaint(lightBlue);
		Rectangle2D rect=new Rectangle2D.Double(0,0,W,H);
		g2.fill(rect);

		background(g2);

	/**Backround Elemnts---------------------------------------->**/
		g2.setPaint(lightBlue);
		Ellipse2D circle = new Ellipse2D.Float(700,200,100,100);
		g2.fill(circle);

		RoundRectangle2D cR =new RoundRectangle2D.Float(W-550,20,600,70,60,60);
		g2.fill(cR);
		RoundRectangle2D cL =new RoundRectangle2D.Float(-30,30,400,60,50,50);
		g2.fill(cL);

/**Ground---------------------------------------->**/

	wave(0,H-350,W,H-130,g);

	wave(100,300,400,450,g);
    wave(800,450,1000,600,g);
    wave2(1300,200,1600,300,g);

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




	public void background(Graphics2D ggg){

    int y=H/3;

	ggg.setPaint(darkBlue);
    Rectangle2D rr = new Rectangle2D.Float(0,0,W,y);
    ggg.fill(rr);

	ggg.setPaint(lightBlue);

    Rectangle2D c1 =new Rectangle2D.Float(900,300,300,400);
    ggg.fill(c1);
    ggg.fillArc(900 , 150, 300, 300, 0, 180);

    Rectangle2D c2 =new Rectangle2D.Float(300,300,300,400);
    ggg.fill(c2);
    ggg.fillArc(300 , 150, 300, 300, 0, 180);

    Rectangle2D c3 =new Rectangle2D.Float(1500,300,300,400);
    ggg.fill(c3);
    ggg.fillArc(1500 , 150, 300, 300, 0, 180);

    ggg.setPaint(darkBlue);

    ggg.fillArc(0 ,200, 300, 300, 0, -180);

    ggg.fillArc(600,200, 300, 300, 0, -180);

    ggg.fillArc(1200 ,200, 300, 300, 0, -180);

    ggg.fillArc(1800 ,200, 300, 300, 0, -180);

}






public void wave(int xs,int ys,int xe,int ye,Graphics t){

	Graphics2D gg = (Graphics2D) t;

    int ymid=(ye-ys)/2;

	gg.setPaint(myGreen);
   	Rectangle2D rr = new Rectangle2D.Float(xs,ys,xe-xs,ye-ys);
    gg.fill(rr);

    gg.setPaint(lightGround);
    Rectangle2D ty = new Rectangle2D.Float(xs,(ys+ymid)-20,xe-xs,(ye-(ymid+ys)));
    gg.fill(ty);

    //ground with hight 40
     gg.setPaint(darkGround);
    Rectangle2D aa = new Rectangle2D.Float(xs,ye-40,xe-xs,40);
    gg.fill(aa);

    //down wave
    QuadCurve2D QC = new QuadCurve2D.Float();
   gg.setPaint(myGreen);
    for(int i=0;i+xs<xe;i+=40){
     	   QC.setCurve((xs+i),(ys+ymid-20),(i+xs+10),(ys+ymid),(i+xs+20),(ys+ymid-20));
           gg.fill(QC);
    }
     gg.setPaint(lightGround);
     for(int j=20;j+xs<xe-10;j+=40){
     	   QC.setCurve(xs+j,ys+ymid -20, j+xs+10,(ys+ymid-40), j+xs+20, ys+ymid-20);
           gg.fill(QC);
     }
}

public void wave2(int xs,int ys,int xe,int ye,Graphics t){

	Graphics2D gg = (Graphics2D) t;

    int ymid=(ye-ys)/2;

	gg.setPaint(myGreen);
   	Rectangle2D rr = new Rectangle2D.Float(xs,ys,xe-xs,ye-ys-20);
    gg.fill(rr);

    gg.setPaint(lightGround);
    Rectangle2D ty = new Rectangle2D.Float(xs,(ys+ymid)-20,xe-xs,(ye-(ymid+ys)));
    gg.fill(ty);

    //down wave
    QuadCurve2D QC = new QuadCurve2D.Float();
   gg.setPaint(myGreen);
    for(int i=0;i+xs<xe;i+=40){
     	   QC.setCurve((xs+i),(ys+ymid-20),(i+xs+10),(ys+ymid),(i+xs+20),(ys+ymid-20));
           gg.fill(QC);
    }
     gg.setPaint(lightGround);
     for(int j=20;j+xs<xe-10;j+=40){
     	   QC.setCurve(xs+j,ys+ymid -20, j+xs+10,(ys+ymid-40), j+xs+20, ys+ymid-20);
           gg.fill(QC);
     }
}


}