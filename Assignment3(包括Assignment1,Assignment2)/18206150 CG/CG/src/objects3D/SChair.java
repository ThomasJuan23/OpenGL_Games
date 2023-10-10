package objects3D;

import org.newdawn.slick.Color;
import  org.newdawn.slick.opengl.Texture;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;

import java.io.IOException;


public class SChair{

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

	
	public SChair() {

	}
	
//	public void init() throws IOException {
//        
//		 
//		  textureface = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/face.png"));
//		    System.out.println("Texture face loaded okay ");
//		    texturebody = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/body.png"));
//			System.out.println("Texture body loaded okay ");
//		}
//	
	// Implement using notes  in Animation lecture  
	public void DrawChair(Texture t, Texture t2) throws Exception 
 { 
		 //this is a frame of animation
		  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
        TexSphere tex=new TexSphere();
        TexCuboid tc=new TexCuboid();
        GL11.glColor3f(black[0], black[1], black[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
		 GL11.glPushMatrix(); 
		 {
			
             cylinder.DrawCylinder(8f, 120f, 36);
             
             GL11.glTranslatef(70, 25, 120);
             
         
          //   Color.white.bind();
  		    t.bind();   //bind the texture
  		    GL11.glEnable(GL11.GL_TEXTURE_2D);    
  		    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
           tc.DrawTexCuboid(t, 100f, 50f, 5f);
           
           GL11.glTranslatef(75, 0, -120);
           cylinder.DrawCylinder(8f, 120f, 36);
           GL11.glTranslatef(0, -50, 0);
     
           cylinder.DrawCylinder(8f, 120f, 36);
           GL11.glTranslatef(-145, 0, 0);
        
           cylinder.DrawCylinder(8f, 120f, 36);
           GL11.glTranslatef(70, 25, 150);
//           Color.white.bind();
 		    t2.bind();   //bind the texture
 		    GL11.glEnable(GL11.GL_TEXTURE_2D);    
          tc.DrawTexCuboid(t2, 100, 1, 40);
           
           
		 }GL11.glPopMatrix();
		 
		 
		 
		 
 }}