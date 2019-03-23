package edu.wm.cs.cs301.KristineTseng.AMazeByKristineTseng.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Custom view for drawing the maze as the player moves through it
 */
public class MazePanel extends View {

    /* Panel operates a double buffer see
     * http://www.codeproject.com/Articles/2136/Double-buffer-in-standard-Java-AWT
     * for details
     */
    // bufferImage can only be initialized if the container is displayable,
    // uses a delayed initialization and relies on client class to call initBufferImage()
    // before first use
    // private Image bufferImage;
    // private Graphics2D graphics; // obtained from bufferImage,
    // graphics is stored to allow clients to draw on the same graphics object repeatedly
    // has benefits if color settings should be remembered for subsequent drawing operations

    //paint object used to draw
    private Paint paint;
    //canvas that we're drawing on
    private Canvas canvas;
    //the bitmap
    private Bitmap bitmap;

    public MazePanel(Context context, AttributeSet attrs) {
        //setFocusable(false);
        //bufferImage = null; // bufferImage initialized separately and later
        //graphics = null;	// same for graphics

        super(context, attrs);
        init();
    }

    /**
     * Initialize fields
     */
    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = Bitmap.createBitmap(Constants.VIEW_WIDTH,Constants.VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //testDraw();
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    /**
     * Tests implemented drawing capabilities
     */
    private void testDraw() {
        //draw a red circle
        setColor("red");
        fillOval(0,0,100,100);

        //draw a black line
        setColor("black");
        drawLine(20,20,300,300);

        //draw a dark gray 4-sided polygon
        setColor("darkGray");
        int[] xPoints = {400, 500, 550, 450};
        int[] yPoints = {400, 450, 600, 650};
        fillPolygon(xPoints, yPoints, 4);

        //draw a white square on top of the dark gray polygon
        setColor("white");
        int[] xPoints2 = {420, 520, 520, 420};
        int[] yPoints2 = {500, 500, 600, 600};
        fillPolygon(xPoints2, yPoints2, 4);

        //draw a yellow oval
        setColor("yellow");
        fillOval(400, 100,500,200);

        //draw a blue circle
        int[] color = {0,127,255}; //should make blue
        setColor(color);
        fillOval(100, 600, 300,300);

        //draw a green square
        setColor(0x9000ff80);  //should make a transparent green - can see the line under it
        fillRect(100,100,200,200);
    }

    //@Override
    //public void update(Graphics g) {
    //    paint(g);
    //}

    /**
     * Method to draw the buffer image on a graphics object that is
     * obtained from the superclass.
     * Warning: do not override getGraphics() or drawing might fail.
     */
    public void update() {
        //paint(getGraphics());
        invalidate();
    }

    /**
     * Draws the buffer image to the given graphics object.
     * This method is called when this panel should redraw itself.
     * The given graphics object is the one that actually shows
     * on the screen.
     */
    //@Override
    //public void paint(Graphics g) {
        /*
        if (null == g) {
            System.out.println("MazePanel.paint: no graphics object, skipping drawImage operation");
        }
        else {
            g.drawImage(bufferImage,0,0,null);
        }
        */
    //}

    /**
     * Obtains a graphics object that can be used for drawing.
     * This MazePanel object internally stores the graphics object
     * and will return the same graphics object over multiple method calls.
     * The graphics object acts like a notepad where all clients draw
     * on to store their contribution to the overall image that is to be
     * delivered later.
     * To make the drawing visible on screen, one needs to trigger
     * a call of the paint method, which happens
     * when calling the update method.
     * @return graphics object to draw on, null if impossible to obtain image
     */
    //public Graphics getBufferGraphics() {
        /*
        // if necessary instantiate and store a graphics object for later use
        if (null == graphics) {
            if (null == bufferImage) {
                bufferImage = createImage(Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT);
                if (null == bufferImage)
                {
                    System.out.println("Error: creation of buffered image failed, presumedly container not displayable");
                    return null; // still no buffer image, give up
                }
            }
            graphics = (Graphics2D) bufferImage.getGraphics();
            if (null == graphics) {
                System.out.println("Error: creation of graphics for buffered image failed, presumedly container not displayable");
            }
            else {
                // System.out.println("MazePanel: Using Rendering Hint");
                // For drawing in FirstPersonDrawer, setting rendering hint
                // became necessary when lines of polygons
                // that were not horizontal or vertical looked ragged
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            }
        }
        return graphics;
        */
    //}

    /**
     * Sets the color of the paint object using a string
     * @param string the color
     */
    public void setColor(String string) {
        /*
        Color color = null;
        if (string.equals("black")) {
            color = Color.black;
        }
        else if (string.equals("darkGray")) {
            color = Color.darkGray;
        }
        else if (string.equals("white")) {
            color = Color.white;
        }
        else if (string.equals("gray")) {
            color = Color.gray;
        }
        else if (string.equals("yellow")) {
            color = Color.yellow;
        }
        else if (string.equals("red")) {
            color = Color.red;
        }
        graphics.setColor(color);
        */
        if (string.equals("black")) {
            paint.setColor(Color.BLACK);
        }
        else if (string.equals("darkGray")) {
            paint.setColor(Color.DKGRAY);
        }
        else if (string.equals("white")) {
            paint.setColor(Color.WHITE);
        }
        else if (string.equals("gray")) {
            paint.setColor(Color.GRAY);
        }
        else if (string.equals("yellow")) {
            paint.setColor(Color.YELLOW);
        }
        else if (string.equals("red")) {
            paint.setColor(Color.RED);
        }

    }

    /**
     * Sets the color of the paint object with an integer
     * array
     * @param rgb an array with red, blue, and green values
     */
    public void setColor(int[] rgb) {
        /*
        int r = rgb[0];
        int g = rgb[1];
        int b = rgb[2];
        Color color = new Color(r, g, b);
        graphics.setColor(color);
        */
        int r = rgb[0];
        int g = rgb[1];
        int b = rgb[2];
        paint.setColor(Color.rgb(r, g, b));
    }

    /**
     * Sets the color of the paint object with an integer
     * @param rgb integer specifying the ARGB color
     */
    public void setColor(int rgb) {
        /*
        Color color = new Color(rgb);
        graphics.setColor(color);
        */
        paint.setColor(rgb);
    }

    /**
     * Returns the integer RGB value of the given array
     * @param rgb an array of 3 integers with the r, g, b values of the color
     * @return the sRGB value of the color
     */
    public static int getRGB(int[] rgb) {
        /*
        int r = rgb[0];
        int g = rgb[1];
        int b = rgb[2];
        Color color = new Color(r, g, b);
        return color.getRGB();
        */
        int r = rgb[0];
        int g = rgb[1];
        int b = rgb[2];
        return Color.rgb(r, g, b);
    }

    /**
     * Draws a filled rectangle
     * @param x x coordinate of top left corner
     * @param y y coordinate of top left corner
     * @param width width of rectangle
     * @param height height of rectangle
     */
    public void fillRect(int x, int y, int width, int height) {
        //graphics.fillRect(x, y, width, height);
        canvas.drawRect(x, y, x+width, y+height, paint);

    }

    /**
     * Draws a line
     * @param x1 x coordinate of first endpoint
     * @param y1 y coordinate of first endpoint
     * @param x2 x coordinate of second endpoint
     * @param y2 y coordinate of second endpoint
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        //graphics.drawLine(x1, y1, x2, y2);
        paint.setStrokeWidth(5);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    /**
     * Draws an oval
     * @param x x coordinate of top left corner
     * @param y y coordinate of top left corner
     * @param width width of oval
     * @param height height of oval
     */
    public void fillOval(int x, int y, int width, int height) {
        //graphics.fillOval(x, y, width, height);
        RectF oval = new RectF(x, y, x+width, y+height);
        canvas.drawOval(oval, paint);
    }

    /**
     * Draws a filled polygon defined by the given x and y coordinates of each point
     * and the given number of points
     * @param xPoints array of x coordinates
     * @param yPoints array of y coordinates
     * @param nPoints number of points
     */
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(xPoints[0], yPoints[0]); //move beginning of path to the first point
        for (int i = 1; i < nPoints; i++) {  //connect the points with lines
            path.lineTo(xPoints[i], yPoints[i]);
        }
        path.lineTo(xPoints[0], yPoints[0]); //connect back to first point to close the shape
        canvas.drawPath(path, paint);        //draw the path on the canvas
    }
}
