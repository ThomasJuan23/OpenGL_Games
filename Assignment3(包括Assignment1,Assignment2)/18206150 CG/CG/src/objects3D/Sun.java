package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Utils;

public class Sun {

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

	
	public Sun() {

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
	public void DrawSun() throws Exception 
 { 
		 //this is a frame of animation


		  
		Sphere sphere= new Sphere();
	
       
		 GL11.glPushMatrix(); 
		 
		 {   
			 GL11.glEnable(GL11.GL_LIGHTING);
			  GL11.glTranslatef(0.0f,0.5f,0.0f);
			  GL11.glColor3f(orange[0], orange[1], orange[2]);
			  GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_EMISSION,  Utils.ConvertForGL(orange));
			  sphere.DrawSphere(1.0f, 32, 32); 
     		  GL11.glDisable(GL11.GL_LIGHTING);
		

		 }GL11.glPopMatrix();
           

        
      
	}
	
	
	
}
 
	/*
	 
	 
}

	*/

