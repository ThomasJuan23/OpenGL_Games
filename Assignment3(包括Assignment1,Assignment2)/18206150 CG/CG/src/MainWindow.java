import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import objects3D.TexCube;
import objects3D.TexCuboid;
import objects3D.TexSphere;
import objects3D.Tree;
import objects3D.Action1;
import objects3D.Chair;
import objects3D.Football;
import objects3D.Grid;
import objects3D.Human;
import objects3D.SChair;
import objects3D.STree;
import objects3D.Sa1;
import objects3D.Sa2;
import objects3D.Sa3;
import objects3D.Sphere;
import objects3D.Sun; 

//Main windows class controls and creates the 3D virtual world , please do not change this class but edit the other classes to complete the assignment. 
// Main window is built upon the standard Helloworld LWJGL class which I have heavily modified to use as your standard openGL environment. 
// 

// Do not touch this class, I will be making a version of it for your 3rd Assignment 
public class MainWindow {
	private boolean MouseOnepressed = true;
	private boolean dragMode=false;
	private boolean BadAnimation = true;
	private boolean Earth= false;
	/** position of pointer */
	int begin=0;
	int begin2=0;
	int begin3=0;
	float x = 0, y = 0;
	float x2=0, y2=0;
	/** angle of rotation */
	float rotation = 0;
	int human=0;
	/** time at last frame */
	long lastFrame;
	/** frames per second */
	int fps;
	/** last fps time */
	long lastFPS;
	float xx=0, yy=0;
	long  myDelta =0 ; //to use for animation
	float Alpha =0 ; //to use for animation
	long StartTime; // beginAnimiation 
    float thed=0;
    float reduce=0;
	Arcball MyArcball= new Arcball();
	boolean judge=false;
	boolean DRAWGRID =false;
	boolean waitForKeyrelease= true;
	boolean kick2=false;
	/** Mouse movement */
	int LastMouseX = -1 ;
	int LastMouseY= -1;
	int j=0;
	int d=0;
	 float pullX = 0.0f; // arc ball  X cord. 
	 float pullY = 0.0f; // arc ball  Y cord. 
	 boolean shout=false;
	 int a=0;
	 float rotation2=0;
	 float humandelta=0;
	 boolean kick=false;

	 
	int OrthoNumber = 1800; // using this for screen size, making a window of 1200 x 800 so aspect ratio 3:2 // do not change this for assignment 3 but you can change everything for your project 
	//1800
	// basic colours
	static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

	static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

	// primary colours
	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

	// secondary colours
	static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
	static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
	static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

	// other colours
	static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
	static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };

	// static GLfloat light_position[] = {0.0, 100.0, 100.0, 0.0};

	//support method to aid in converting a java float array into a Floatbuffer which is faster for the opengl layer to process 
	

	public void start() throws Exception {
		
		StartTime = getTime();
		try {
			Display.setDisplayMode(new DisplayMode(1200, 800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		initGL(); // init OpenGL
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer
		 
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			update(delta);
			renderGL();
			Display.update();
			Display.sync(120); // cap fps to 120fps
		}

		Display.destroy();
	}

	public void update(int delta) {
		// rotate quad
		//rotation += 0.01f * delta;
		  
		  
		int MouseX= Mouse.getX();
		  int MouseY= Mouse.getY();
		  int WheelPostion = Mouse.getDWheel();
	     
		  
		  boolean  MouseButonPressed= Mouse.isButtonDown(0);
		  
		 
		  
		  if(MouseButonPressed && !MouseOnepressed )
		  {
			  MouseOnepressed =true;
			//  System.out.println("Mouse drag mode");
			  MyArcball.startBall( MouseX, MouseY, 1200, 800);
			  
			  dragMode=true;
				
				
		  }else if( !MouseButonPressed)
		  { 
				// System.out.println("Mouse drag mode end ");
			  MouseOnepressed =false;
			  dragMode=false;
		  }
		  
		  if(dragMode)
		  {
			  MyArcball.updateBall( MouseX  , MouseY  , 1200, 800);
		  }
		  
		  if(WheelPostion>0)
		  {
			  OrthoNumber += 10;
			 
		  }
		  
		  if(WheelPostion<0)
		  {
			  OrthoNumber -= 10;
			  if( OrthoNumber<610)
			  {
				  OrthoNumber=610;
			  }
			  
			//  System.out.println("Orth nubmer = " +  OrthoNumber);
			  
		  }
		  
		  /** rest key is R*/
		  if (Keyboard.isKeyDown(Keyboard.KEY_R))
			  MyArcball.reset();
		  
		  /* bad animation can be turn on or off using A key)*/
		  
		  
		 
		 
//			System.out.println("delta:"+delta);
//			x2 -= 0.35f * delta;
//			if(j%2==0)
//			x -= 0.35f * delta;
		  if(humandelta>0.7f) {
			  reduce=reduce+0.005f;
		  }
		  if(humandelta>=0.95f||reduce>=0.35f) {
			  reduce=0;
		  }
		 
		  
//		    
		  if(judge) {
			if (Keyboard.isKeyDown(Keyboard.KEY_A)&&!Keyboard.isKeyDown(Keyboard.KEY_W)&&!Keyboard.isKeyDown(Keyboard.KEY_S)) {
			
				x2 -= (0.35f-reduce) * delta;
				if(j%2==0)
				x -= (0.35f-reduce) * delta;
//				else {
//					x2 -= 0.20f * delta;
				
//					if(j%2==0)
//					x -= 0.20f * delta;
//				}
				d=1;
				
				}
			else if (Keyboard.isKeyDown(Keyboard.KEY_D)&&!Keyboard.isKeyDown(Keyboard.KEY_W)&&!Keyboard.isKeyDown(Keyboard.KEY_S)) {
			    d=0;
			 
			    x2 += (0.35f-reduce) * delta;
				if(j%2==0)
				x += (0.35f-reduce) * delta;
				}
			else if (Keyboard.isKeyDown(Keyboard.KEY_W)&&!Keyboard.isKeyDown(Keyboard.KEY_A)&&!Keyboard.isKeyDown(Keyboard.KEY_D)) {
				y2 += (0.35f-reduce) * delta;
				if(j%2==0)
				y += (0.35f-reduce) * delta;
				d=2;
			
				}
			else if (Keyboard.isKeyDown(Keyboard.KEY_S)&&!Keyboard.isKeyDown(Keyboard.KEY_A)&&!Keyboard.isKeyDown(Keyboard.KEY_D)) {
				y2 -= (0.35f-reduce) * delta;
				if(j%2==0)
				y -= (0.35f-reduce) * delta;
				d=3;
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_A)&&Keyboard.isKeyDown(Keyboard.KEY_W)) {
				x2 -= (0.35f-reduce)* delta;
				if(j%2==0)
				x -= (0.35f-reduce) * delta;
				y2 += (0.35f-reduce) * delta;
				if(j%2==0)
				y +=(0.35f-reduce)* delta;
				d=4;
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_A)&&Keyboard.isKeyDown(Keyboard.KEY_S)) {
				x2 -=(0.35f-reduce) * delta;
				if(j%2==0)
				x -= (0.35f-reduce) * delta;
				y2 -= (0.35f-reduce) * delta;
				if(j%2==0)
				y -= (0.35f-reduce) * delta;
				d=5;
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_D)&&Keyboard.isKeyDown(Keyboard.KEY_W)) {
				 x2 += (0.35f-reduce) * delta;
					if(j%2==0)
					x += (0.35f-reduce) * delta;
					y2 += (0.35f-reduce) * delta;
					if(j%2==0)
					y += (0.35f-reduce)* delta;
				d=6;
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_D)&&Keyboard.isKeyDown(Keyboard.KEY_S)) {
				x2 +=(0.35f-reduce) * delta;
				if(j%2==0)
				x += (0.35f-reduce) * delta;
				y2 -= (0.35f-reduce) * delta;
				if(j%2==0)
				y -= (0.35f-reduce) * delta;
				d=7;
			}
		  }
		
		if (Keyboard.isKeyDown(Keyboard.KEY_T)) {
			if(begin==0) {
		   j++;}
			begin=1;
			
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_T)) {
			begin=0;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
			rotation2 += 0.35f * delta;
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			rotation2 -= 0.35f * delta;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			judge=true;
		}
		
		
	
		 if(waitForKeyrelease) // check done to see if key is released 
		 {
		if (Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			
			DRAWGRID = !DRAWGRID;
			Keyboard.next();
			if(Keyboard.isKeyDown(Keyboard.KEY_G))
			{
				waitForKeyrelease=true;
			}else
			{
				waitForKeyrelease=false;
				
			}
		}
		 }
		 
		 /** to check if key is released */
		 if(Keyboard.isKeyDown(Keyboard.KEY_G)==false)
			{
				waitForKeyrelease=true;
			}else
			{
				waitForKeyrelease=false;
				
			}
		 
		 if(Keyboard.isKeyDown(Keyboard.KEY_J)) {
			 shout=true;
			 if(begin2==0) {
				 human++;
			
			 }
			 begin2=1;
			 
		 }
		 if(!Keyboard.isKeyDown(Keyboard.KEY_J)) {
			 begin2=0;
		 }
		 
		// System.out.println("x: "+x2+"Y: "+y2);
		 
			
		 
		 
		 
              
//		// keep quad on the screen
//		 System.out.println("x2-------  "+x2);
//		 System.out.println("y2-------  "+y2);
		 if(y2>-630&&y2<-517&&x2>2130&&x2<2377)
		         kick=true;
		 else {
			 kick =false;
		 }
		 if (rotation2 <= -1900)
				rotation2 =-1900;
			if (rotation2 >=700)
				rotation2 = 700;
		if (x < -1000)
			x =-1000;
		if (x > 3500)
			x = 3500;
		if (y < -1000)
			y = -1000;
		if (y > 400)
			y = 400;
		if (x2 < -1000)
			x2 =-1000;
		if(x2<400||x2>600&&x2<3250||x2>3490) {
			if (y2 > 300) {
				y2 = 300;
			
				}
			}
		if(x2>=400&&x2<=600&&y2>400) {
			x2=3400;
			y2=300;
			rotation=3;
			x=x+2500;
		}
		if(x2>=3250&&x2<=3490&&y2>400) {
			x2=500;
			y2=300;
			rotation=3;
			x=x-2500;
		}
//		if(x2>=-70&&x2<=170&&y2>=-412&&y2<=-212) {
//			double min=min((x2-(-70)),(170-x2),(y2-(-412)),(-212-y2));
//			if(min==(y2-(-412))) {
//				System.out.println("d1");
//				y2=-412;
//			}
//			else if(min==(-212-y2)) {
//				System.out.println("d2");
//				y2=-212;
//			}
//			else if(min==x2-(-70)) {
//				System.out.println("d3");
//				x2=-70;
//			}
//			else {
//				System.out.println("d4");
//				x2=170;
//			}
//			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
//				if(j%2==0)
//				x += 0.35f * delta;
//				}
//			else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
//				if(j%2==0)
//				x -= 0.35f * delta;
//				;}
//			else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
//				if(j%2==0)
//				y -= 0.35f * delta;		
//			}
//			else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
//				if(j%2==0)
//				y += 0.35f * delta;
//				d=3;
//			}
//		}
		stop(delta,(-70),170,(-412),(-212));
		stop(delta,260,527,(-557),(-336));
		stop(delta,1971,2175,(-800),(-629));
		stop(delta,2263,2455,(-800),(-629));
		stop(delta,1644,2111,(-158),(101));
		stop(delta,767,1100,(-148),(101));
		
		
//		System.out.println("x2-----   "+x2);
//		System.out.println("y2-----   "+y2);
		
		
		if (x2 > 3800)
			x2 = 3800;
		if (y2 < -1000)
			y2 = -1000;
		
		updateFPS(); // update FPS Counter
		
		LastMouseX= MouseX;
		LastMouseY= MouseY ;
	}
	
	
	public void stop(int delta,int a, int b,int c,int d) {
		if(x2>=a&&x2<=b&&y2>=c&&y2<=d) {
			double min=min((x2-a),(b-x2),(y2-c),(d-y2));
			if(min==(y2-c)) {
				y2=c;
			}
			else if(min==(d-y2)) {
				y2=d;
			}
			else if(min==x2-a) {
				x2=a;
			}
			else {
				x2=b;
			}
			if(judge) {
			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				if(j%2==0)
				x += (0.35f-reduce) * delta;
				}
			else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				if(j%2==0)
				x -= (0.35f-reduce) * delta;
				;}
			else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				if(j%2==0)
				y -= (0.35f-reduce) * delta;		
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				if(j%2==0)
				y += (0.35f-reduce) * delta;
				d=3;
			}
			}
		}
	}

	/**
	 * Calculate how many milliseconds have passed since last frame.
	 * 
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
		long time = getTime();
	
		int delta = (int) (time - lastFrame);
	    
		lastFrame = time;

		return delta;
	}

	/**
	 * 
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		changeOrth();
		MyArcball.startBall(0, 0, 1200,800); 
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
		lightPos.put(10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos2 = BufferUtils.createFloatBuffer(4);
		lightPos2.put(0f).put(1000f).put(0).put(-1000f).flip();

		FloatBuffer lightPos3 = BufferUtils.createFloatBuffer(4);
		lightPos3.put(-10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos4 = BufferUtils.createFloatBuffer(4);
		lightPos4.put(1000f).put(1000f).put(1000f).put(0).flip();

		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		// GL11.glEnable(GL11.GL_LIGHT0); // switch light #0 on // I've setup specific materials so in real light it will look abit strange 

		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT1); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, Utils.ConvertForGL(spot));

		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_POSITION, lightPos3); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT2); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));

		GL11.glLight(GL11.GL_LIGHT3, GL11.GL_POSITION, lightPos4); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT3); // switch light #0 on
		 GL11.glLight(GL11.GL_LIGHT3, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));

		GL11.glEnable(GL11.GL_LIGHTING); // switch lighting on
		GL11.glEnable(GL11.GL_DEPTH_TEST); // make sure depth buffer is switched
											// on
	 	GL11.glEnable(GL11.GL_NORMALIZE); // normalize normal vectors for safety
	 	GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		
		   GL11.glEnable(GL11.GL_BLEND);
       GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
          try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //load in texture
          

	}

	 

	public void changeOrth() {

		 GL11.glMatrixMode(GL11.GL_PROJECTION);
		 GL11.glLoadIdentity();
		  GL11.glOrtho(1200 -  OrthoNumber , OrthoNumber, (800 - (OrthoNumber  * 0.66f)) , (OrthoNumber * 0.66f), 100000, -100000);
		 	GL11.glMatrixMode(GL11.GL_MODELVIEW); 
		 	
		 	FloatBuffer CurrentMatrix = BufferUtils.createFloatBuffer(16); 
		 	GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, CurrentMatrix);
		 
		 //	if(MouseOnepressed)
		 //	{
		  
		 	MyArcball.getMatrix(CurrentMatrix); 
		 //	}
		 	
		    GL11.glLoadMatrix(CurrentMatrix);
		 	
	}

	/*
	 * You can edit this method to add in your own objects /  remember to load in textures in the INIT method as they take time to load 
	 * 
	 */
	public void renderGL() throws Exception { 
		changeOrth();                   //The animation is about 40 seconds
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); 
		GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glColor3f(0.5f, 0.5f, 1.0f); 
		 
		 myDelta =   getTime() - StartTime; 
		  float delta =((float) myDelta)/3000; 
		  int i=1;
		  while(delta>16.0f*i) {
			  if(delta==16.0f*i) {
				  i++;
			  }
			  delta=delta-16.0f*i;
		  }
		 
		 
		   
		  // code to aid in animation 
		 float theta = (float) (delta * 2 * Math.PI);
		 float thetaDeg = delta * 360; 
		  float posn_x = (float) Math.cos(theta); // same as your circle code in your notes 
		  float posn_y  = (float) Math.sin(theta);
		  
		  /*
		   * This code draws a grid to help you view the human models movement 
		   *  You may change this code to move the grid around and change its starting angle as you please 
		   */
		if(DRAWGRID)
		{
		GL11.glPushMatrix();
		Grid MyGrid = new Grid();
		GL11.glTranslatef(600, 400, 0); 
		GL11.glScalef(200f, 200f,  200f); 
		 MyGrid.DrawGrid();
		GL11.glPopMatrix();
		}
		
		
		GL11.glRotatef(-rotation2/100, 0, 1, 0);
		GL11.glRotatef(-5, 1.0f, 0.0f, 0.0f);
		GL11.glRotatef(-5, 0.0f, 1.0f, 0.0f);
		if(j%2==0) {
		GL11.glTranslatef(-x/2, 0.0f,-y);
		xx=x;
		yy=y;
		}
		else {
			GL11.glTranslatef(-xx/2, 0.0f,-yy);
		}
	
		GL11.glPushMatrix();
		Human MyHuman = new Human();
		GL11.glTranslatef(500, 50,0 );   
		GL11.glScalef(30f, 30f,  30f); 
	    	GL11.glTranslatef(-25, 0.0f,15);
		//	GL11.glTranslatef(delta*4, 0.0f,0);    
		Sa2 s2=new Sa2();
		
		
		
		GL11.glTranslatef(x2/50, 0, y2/10);
		if(kick) {
			//System.out.println(delta);
			if(delta>13.7f) {
				GL11.glTranslatef((delta-13.7f)/100,(delta-13.7f)*40, -(delta-13.7f)*100);
			    GL11.glRotatef(360*delta*10, 1, 0, 0);
			}
		}
		
		
		
		
	
		if(d==0)
			  GL11.glRotatef(0,0.0f,1.0f, 0.0f);
			if(d==1)
				  GL11.glRotatef(180,0.0f,1.0f, 0.0f);
			if(d==2)
				  GL11.glRotatef(-90,0.0f,1.0f, 0.0f);
			if(d==3)
				  GL11.glRotatef(90,0.0f,1.0f, 0.0f);
			if(d==4)
				  GL11.glRotatef(-135,0.0f,1.0f, 0.0f);
			if(d==5)
				  GL11.glRotatef(135,0.0f,1.0f, 0.0f);
			if(d==6)
				  GL11.glRotatef(-45,0.0f,1.0f, 0.0f);
			if(d==7)
				  GL11.glRotatef(45,0.0f,1.0f, 0.0f);
			if(judge) {
				 humandelta=humandelta+0.01f;
				 
				 
				 
			     MyHuman.DrawHuman(humandelta*4.0f,!BadAnimation,textureface, texturebody,texturebody1);
			     if(humandelta>1) {
			    	 judge=false;
			    	 humandelta=0;
			     }
			}
			else {
				 MyHuman.DrawHuman(0,!BadAnimation,textureface, texturebody,texturebody1);
			}
			
		    if(d==0)
			  GL11.glRotatef(0,0.0f,1.0f, 0.0f);
			if(d==1)
				  GL11.glRotatef(-180,0.0f,1.0f, 0.0f);
			if(d==2)
				  GL11.glRotatef(90,0.0f,1.0f, 0.0f);
			if(d==3)
				  GL11.glRotatef(-90,0.0f,1.0f, 0.0f);
			if(d==4)
				  GL11.glRotatef(135,0.0f,1.0f, 0.0f);
			if(d==5)
				  GL11.glRotatef(-135,0.0f,1.0f, 0.0f);
			if(d==6)
				  GL11.glRotatef(45,0.0f,1.0f, 0.0f);
			if(d==7)
				  GL11.glRotatef(-45,0.0f,1.0f, 0.0f);
		GL11.glRotatef(-90, 1.0f, 0.0f, 0.0f);
		GL11.glScalef(1, 3, 0.1f);
		GL11.glTranslatef( 0.0f, 0.8f, -10f);
	//	GL11.glRotatef(-20, 0.0f, 0.0f, 1.0f);
		//GL11.glRotatef(15, 0.0f, 1.0f, 0.0f);
		
		if(kick) {
			if(delta<13.7f) {
				if(judge) {
					 humandelta=humandelta+0.01f;
					 
					 
					 
				     s2.DrawHuman(humandelta*4.0f,!BadAnimation,textureface, texturebody,texturebody1);
				     if(humandelta>1) {
				    	 judge=false;
				    	 humandelta=0;
				     }
				}
				else {
					 s2.DrawHuman(0,!BadAnimation,textureface, texturebody,texturebody1);
				}
			}
		}
		else {
		if(judge) {
			 humandelta=humandelta+0.01f;
			 
			 
			 
		     s2.DrawHuman(humandelta*4.0f,!BadAnimation,textureface, texturebody,texturebody1);
		     if(humandelta>1) {
		    	 judge=false;
		    	 humandelta=0;
		     }
		}
		else {
			 s2.DrawHuman(0,!BadAnimation,textureface, texturebody,texturebody1);
		}
		}
		GL11.glPopMatrix();
		TexCuboid MyGlobe = new TexCuboid();
	
		GL11.glPushMatrix();
		GL11.glRotatef(90, 1, 0, 0);
		GL11.glRotatef(90, 0, 0, 1);
		GL11.glTranslatef(1700, -50, -110 );  
		 Color.white.bind();
		   gateway.bind();   //bind the texture
		    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		   // GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
     	MyGlobe.DrawTexCuboid(gateway,10f,80f,90f); 
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glRotatef(90, 1, 0, 0);
		GL11.glRotatef(90, 0, 0, 1);
		GL11.glTranslatef(1700, -1800, -110 );  
		 Color.white.bind();
		   g2.bind();   //bind the texture
		    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		   // GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
     	MyGlobe.DrawTexCuboid(g2,10f,80f,90f); 
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glTranslatef(1000, 60, 0);
		Football fb=new Football();
		GL11.glScalef(35f, 35f,  35f);
		GL11.glRotatef(30, 0, 1, 0);
		Sa3 s3=new Sa3();
		if(human%2==1) {
	
		   if(shout) {
				thed=thed+0.01f;	
				  a++;
				if(a<=5) {
				fb.DrawHuman(thed*4.0f,shout,textureface, texturebody,texturebody1); 
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(1.2f, 2f, 0);
				GL11.glScaled(0.2f, 1, 1);
				//GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(30, 1,0 , 0);
				GL11.glRotatef(90, 0,1 , 0);
				GL11.glTranslatef(-1, 0.5f, 0);
				s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
			  
			    }
			   if(a>=5) {
				   fb.DrawHuman(thed*4.0f,false,textureface, texturebody,texturebody1); 
					GL11.glRotatef(-90, 0, 0, 1);
					GL11.glTranslatef(1.2f, 2f, 0);
					GL11.glScaled(0.2f, 1, 1);
					//GL11.glRotatef(90, 1, 0, 0);
					GL11.glRotatef(30, 1,0 , 0);
					GL11.glRotatef(90, 0,1 , 0);
					GL11.glTranslatef(-1, 0.5f, 0);
					//s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
					if(a>5) {
						s3.DrawHuman(0,false,textureface, texturebody,texturebody1); }
				  
				  // thed=0;
				   if(begin3==0) {
					   thed=0;
					   begin3=1;}
				   }	
				   else {
					   begin3=0;
				   }
		   }
		   else {
				fb.DrawHuman(thed*4.0f,false,textureface, texturebody,texturebody1); 
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(1.2f, 2f, 0);
				GL11.glScaled(0.2f, 1, 1);
				//GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(30, 1,0 , 0);
				GL11.glRotatef(90, 0,1 , 0);
				GL11.glTranslatef(-1, 0.5f, 0);
				s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
		   }
		
		}
		else {
			fb.DrawHuman(delta*4.0f,false,textureface, texturebody,texturebody1);
			GL11.glRotatef(-90, 0, 0, 1);
			GL11.glTranslatef(1.2f, 2f, 0);
			GL11.glScaled(0.2f, 1, 1);
			//GL11.glRotatef(90, 1, 0, 0);
			GL11.glRotatef(30, 1,0 , 0);
			GL11.glRotatef(90, 0,1 , 0);
			GL11.glTranslatef(-1f, 0.5f, 0);
			s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
		}
		GL11.glPopMatrix();
		
		STree stree=new STree();
		
		GL11.glPushMatrix();
		Tree tree=new Tree();
	    GL11.glRotatef(-90, 1, 0, 0);
		GL11.glTranslatef(300, -400, 0);
		tree.DrawTree(greens);
		GL11.glRotatef(90, 0, 1,0);
		GL11.glTranslatef(-20, 0, 0);
		GL11.glScalef(0.1f, 1f, 1f);
		GL11.glRotatef(-90, 1, 0,0);
		GL11.glTranslatef(0, 0, 0);
		stree.DrawTree(greens);
		
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		
	    GL11.glRotatef(-90, 1, 0, 0);
		GL11.glTranslatef(3000, 2500, 0);
		tree.DrawTree(greens);
		GL11.glRotatef(90, 0, 1,0);
		GL11.glTranslatef(-20, 0, 0);
		GL11.glScalef(0.1f, 1f, 1f);
		GL11.glRotatef(-90, 1, 0,0);
		GL11.glTranslatef(0, 0, 0);
		stree.DrawTree(greens);
		
		
		
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Chair c=new Chair();
	    GL11.glRotatef(-90, 1, 0, 0);
		GL11.glTranslatef(800, -400,  -40);
		c.DrawChair(chair2,chair);
		SChair schair=new SChair();
		GL11.glRotatef(-90, 1, 0, 0);
		GL11.glTranslatef(0, -50, 0);
	    GL11.glScalef(1, 0.01f, 1f);
	    GL11.glRotatef(30, 1, 0, 0);
		GL11.glTranslatef(0, 0, 0);
		schair.DrawChair(chair2, chair);
		
		
		GL11.glPopMatrix();
		
		
		
		
		
		
		
		GL11.glPushMatrix();
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glTranslatef(500, 60, -250);
		GL11.glScalef(35f, 35f,  35f);
		GL11.glRotatef(-120, 0, 1, 0);
		if(human%2==0) {		 
		   if(shout) {
			   thed=thed+0.01f;		
			   if(a<=5) {
			   fb.DrawHuman(thed*4.0f,shout,textureface, texturebody,texturebody1);
			   GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(1.2f, 2f, 0);
				GL11.glScaled(0.2f, 1, 1);
				//GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(-120, 1,0 , 0);
				GL11.glRotatef(90, 0,1 , 0);
				GL11.glTranslatef(1.5f, 3f, 0);
				GL11.glRotatef(0, 0,0, 1);
				GL11.glTranslatef(0f, 0, 0);
				s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
			   }
			   a++;
			   if(a>=5) {
				   
				   fb.DrawHuman(thed*4.0f,false,textureface, texturebody,texturebody1); 
				   GL11.glRotatef(-90, 0, 0, 1);
					GL11.glTranslatef(1.2f, 2f, 0);
					GL11.glScaled(0.2f, 1, 1);
					//GL11.glRotatef(90, 1, 0, 0);
					GL11.glRotatef(-120, 1,0 , 0);
					GL11.glRotatef(90, 0,1 , 0);
					GL11.glTranslatef(1.5f, 3f, 0);
					GL11.glRotatef(0, 0,0, 1);
					GL11.glTranslatef(0f, 0, 0);
					if(a>5) {
					s3.DrawHuman(0,false,textureface, texturebody,texturebody1); }
				   if(begin3==0) {
				   thed=0;
				   begin3=1;}
			   }	
			   else {
				   begin3=0;
			   }
		   }
		   else {
			   fb.DrawHuman(thed*4.0f,false,textureface, texturebody,texturebody1);
			   GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(1.2f, 2f, 0);
				GL11.glScaled(0.2f, 1, 1);
				//GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(-120, 1,0 , 0);
				GL11.glRotatef(90, 0,1 , 0);
				GL11.glTranslatef(1.5f, 3f, 0);
				GL11.glRotatef(0, 0,0, 1);
				GL11.glTranslatef(0f, 0, 0);
				s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
		   }
		
		}
		else {
			fb.DrawHuman(delta*4.0f,false,textureface, texturebody,texturebody1);
			 GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(1.2f, 2f, 0);
				GL11.glScaled(0.2f, 1, 1);
				//GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(-120, 1,0 , 0);
				GL11.glRotatef(90, 0,1 , 0);
				GL11.glTranslatef(1.5f, 3f, 0);
				GL11.glRotatef(0, 0,0, 1);
				GL11.glTranslatef(0f, 0, 0);
				s3.DrawHuman(0,false,textureface, texturebody,texturebody1); 
		}
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-20, 25, -900);
		TexSphere ts=new TexSphere();
		 Color.white.bind();
		 football.bind();   //bind the texture
		    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);	
		    if(human%2==1) {
		    if(shout) {
		    if(a>=5) {
		    	if(a<40) {
		   
		    GL11.glTranslatef(-thed*3*250, 0, thed*400);
		    thed=thed+0.01f;
		    a++;}
		    if(a>=40) {
		    	a=0;
		    	thed=0;
		    	shout=false;	
		    	
		    }
		    }
		    }
		    else {
		   	 GL11.glTranslatef(-0.35f*3*250, 0, 0.32f*400);
		    }
		    }
		    else {
		    	if(human!=0)
		    	 GL11.glTranslatef(-0.35f*3*250, 0, 0.32f*400);
		    	if(shout) {
				    if(a>=5) {
				    	if(a<40) {
				    GL11.glTranslatef(thed*3*250, 0, -thed*400);
				    thed=thed+0.01f;
				    a++;}
				    if(a>=40) {
				    	a=0;
				    	thed=0;
				    	shout=false;	
				    	
				    }
				    }
				    }
		    	else {
		    		if(human!=0)
		    		 GL11.glTranslatef(0.35f*3*250, 0, -0.32f*400);
		    	}
		    }
		    
	     	ts.DrawTexSphere(15f, 36, 36,football);
	     	GL11.glRotatef(-90,1, 0, 0);
	     	GL11.glRotatef(70,0, 0, 1);
	     	GL11.glTranslatef(25, 15, -15);
	     	GL11.glScalef(1, 1, 0.1f);
	     	Sphere sp=new Sphere();
	     	 GL11.glColor3f(black[0], black[1], black[2]);
			 GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
			
	     	sp.DrawSphere(20f, 36, 36);
	     	
	     	
		   GL11.glPopMatrix();
		
		
		
			GL11.glPushMatrix();
			
			GL11.glTranslatef(1000, 0, -1000 );    
			GL11.glScalef(90f, 90f,  90f);   
			 
			GL11.glTexParameteri(
					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
					GL11.GL_CLAMP); 
		  
			 Color.white.bind();
			    textureGrass.bind();   
			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
			MyGlobe.DrawTexCuboid(textureGrass,50.0f,0.1f,50.0f); 
			
			
		
	
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
			GL11.glTranslatef(1000, 2640, 1700);   
			GL11.glScalef(90f, 90f,  90f);  
			GL11.glRotated(90, 0, 0, 1);
			 Color.white.bind();
			    textureSky.bind();   //bind the texture
			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
			MyGlobe.DrawTexCuboid(textureSky,30.0f,50.0f,0.1f);
			  GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glTranslatef(-1500, 2640, -1000);    //change the position
			GL11.glScalef(90f, 90f,  90f);  
			GL11.glRotated(90, 0, 0, 1);
			GL11.glRotated(90, 1, 0, 0);
			 Color.white.bind();
			    textureSky.bind();   //bind the texture
			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
			MyGlobe.DrawTexCuboid(textureSky,30.0f,30.0f,0.1f);
			   GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			Sun s=new Sun();
			GL11.glTranslatef(800, 800, 1600);    //change the position
			GL11.glScalef(90f, 90f,  90f);  
			s.DrawSun();
		    GL11.glPopMatrix();
		    GL11.glPushMatrix();
		    GL11.glTranslatef(1000, 160, -1500);
		    GL11.glScalef(40f, 40f,  40f);
		    Action1 a1=new Action1();

		    Sa1 s1=new Sa1();
	
		    a1.DrawAction1(delta, !BadAnimation,textureface, texturebody,texturebody1);
		    GL11.glRotatef(90, 1.0f, 0.0f, 0.0f);
		   
			GL11.glScalef(1f, 5f,  0.1f); 
			GL11.glTranslatef(0, -4.3f, 37);
			 
			 GL11.glRotatef(180, 1.0f, 0.0f, 0.0f);
			 GL11.glRotatef(10, 0.0f, 1.0f, 0.0f);
			s1.DrawAction1(delta, !BadAnimation,textureface, texturebody,texturebody1);
	
//		    }
		    GL11.glPopMatrix();

		    
		    
		//   System.out.println(delta);
	}
		  
	

	
	
	public static void main(String[] argv) throws Exception {
		MainWindow hello = new MainWindow();
	    //System.out.println(hello.min(8,9,10,4));
		hello.start();
	}
	 
	Texture texture;   //this  is the earth
	Texture textureface;  // this is the face
	Texture texturebody;  //this is the pelvis 
	Texture texturebody1;//this is the chest
	Texture textureGrass;
	Texture textureSky;
	Texture gateway;
	Texture g2;
	Texture football;
	Texture greens;
	Texture chair;
	Texture chair2;

	/*
	 * Any additional textures for your assignment should be written in here. 
	 * Make a new texture variable for each one so they can be loaded in at the beginning 
	 */
	
	public double min(double d1, double d2, double d3, double d4) {
		double min=d1;
		double[] ds= {d1,d2,d3,d4};
		for(int i=0;i<4;i++) {
			if(ds[i]<min) {
				min=ds[i];
			}		
		}
		return min;
	}
	
	
	public void init() throws IOException {
	  texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/earthspace.png"));
	  System.out.println("Texture loaded okay ");
	  textureface = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/face.png"));  //get the face pictue
	    System.out.println("Texture face loaded okay "); 
	    texturebody = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/body.png"));
		System.out.println("Texture body loaded okay ");          //get the pelvis picture
		texturebody1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/body1.png"));
		System.out.println("Texture body1 loaded okay "); 
		textureGrass = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/grass.jpg"));
		System.out.println("Texture grass loaded okay "); 
		textureSky = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/sky.jpg"));
		System.out.println("Texture sky loaded okay "); 
		gateway = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/g2.png"));
		System.out.println("Texture gate loaded okay "); 
		g2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/g1.png"));
		System.out.println("Texture gate loaded okay "); 
		football = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/football.jpg"));
		System.out.println("Texture football loaded okay "); 
		greens = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/green.png"));
		System.out.println("Texture green loaded okay "); 
		chair = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/chair.jpg"));
		System.out.println("Texture chair loaded okay "); 
		chair2 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/chair2.jpg"));
		System.out.println("Texture chair loaded okay "); 
		
		
		
		//get the chest picture
	}
}
