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


public class Sa3{

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

	
	public Sa3() {

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
	public void DrawHuman(float delta,boolean GoodAnimation, Texture t, Texture t2, Texture t3) throws Exception 
 { 
		 //this is a frame of animation
		 float theta = (float) (delta * 2 * Math.PI);
		  float LimbRotation;
		 if (GoodAnimation)
		 {
			 LimbRotation =- (float) Math.cos(theta)*45;
		 }else
		 {
			 LimbRotation =0;
		 } 
		  LimbRotation=0;
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
        TexSphere tex=new TexSphere();
        GL11.glColor3f(black[0], black[1], black[2]);
		 GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
		 GL11.glPushMatrix(); 
		 
		 {
			  GL11.glTranslatef(0.0f,0.5f,0.0f);
			  GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);   //rotate the pelvis to let the blue above
		
			    t2.bind(); //bind the texture
			    GL11.glEnable(GL11.GL_TEXTURE_2D);   // the form
			    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
			    tex.DrawTexSphere(0.5f, 32, 32, t2);   //the pelvis with texsphere
			    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);   //make it rotate to the origin position 
			 //sphere.DrawSphere(0.5f, 32, 32); 

		        //  chest
			
			 GL11.glPushMatrix(); {
		            GL11.glTranslatef(0.0f,0.5f,0.0f);
		            GL11.glRotated(84.0f,0.0f, 1.0f, 0.0f);   //rotate the pelvis to let  Doraemon  on the front
		            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
		           
				    t3.bind(); 
				    GL11.glEnable(GL11.GL_TEXTURE_2D);//the form
				    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
		            tex.DrawTexSphere(0.5f, 32, 32, t3);  //the chest with texsphere
		            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);  //make it rotate to the origin position 
		            GL11.glRotated(-84.0f,0.0f, 1.0f, 0.0f);
		           
		        //    sphere.DrawSphere(0.5f, 32, 32); 


		            // neck
		      
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(0.0f,0.0f, 0.0f);
		                GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
		                //                    GL11.glRotatef(45.0f,0.0f,1.0f,0.0f); 
		                cylinder.DrawCylinder(0.15f,0.7f,32);


		                // head
		          
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,1.0f);
		                    GL11.glRotatef(82.0f,0.0f,0.0f,1.0f);   //rotate the head to let the eye On the front
		                
		        		    t.bind(); //bind the texture
		        		    GL11.glEnable(GL11.GL_TEXTURE_2D);//the form
		        		    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
		                    tex.DrawTexSphere(0.5f, 32, 32, t);  //the head with texture
		                  //  sphere.DrawSphere(0.5f, 32, 32); 
		                
		                    GL11.glPopMatrix();
		                } GL11.glPopMatrix();


		                // left shoulder
		         
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.5f,0.4f,0.0f);
		                    sphere.DrawSphere(0.25f, 32, 32); 
		                    

		                    // left arm
		            
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.0f);
		                        GL11.glRotatef(90.0f,1.0f,0.5f,0.0f);  //Avoid wearing die
		                        
		                        
		                        GL11.glRotatef(0,1.0f,0.0f,0.0f); 
		                     //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
		                        cylinder.DrawCylinder(0.15f,0.7f,32);


		                        // left elbow
		                  
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.75f);
		                            sphere.DrawSphere(0.2f, 32, 32); 
		                            
		                  
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.0f);
		                                               GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
		                             //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
		                                cylinder.DrawCylinder(0.1f,0.7f,32);

		                                // left hand
		                         
		                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                                GL11.glPushMatrix(); {
		                                    GL11.glTranslatef(0.0f,0.0f,0.75f);
		                                    sphere.DrawSphere(0.2f, 32, 32); 
		                                    


		                                } GL11.glPopMatrix();
		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix ();
		                } GL11.glPopMatrix ();
		                // to chest
		               
		                GL11.glTranslatef(-1.0f, 0.0f, 0.0f);   //move to the right position 
		                // right shoulder
		       
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(0.5f,0.4f,0.0f);
			                    sphere.DrawSphere(0.25f, 32, 32); 

		                    // right arm
			                  	
				                    GL11.glPushMatrix(); {
				                        GL11.glTranslatef(0.0f,0.0f,0.0f);
				                        GL11.glRotatef(90.0f,1.0f,-0.5f,0.0f);   //Avoid wearing die
				                        
				                    	  GL11.glRotatef(0,-1.0f,0.0f,0.0f);     //Avoid turning straight
				                     //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
				                        cylinder.DrawCylinder(0.15f,0.7f,32);


				                        // right elbow
				                   	
				                        GL11.glPushMatrix(); {
				                            GL11.glTranslatef(0.0f,0.0f,0.75f);
				                            sphere.DrawSphere(0.2f, 32, 32); 
				                            
				                            //right forearm
				                      
				                            GL11.glPushMatrix(); {
				                                GL11.glTranslatef(0.0f,0.0f,0.0f);
				                                               GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
				                             //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
				                                cylinder.DrawCylinder(0.1f,0.7f,32);

				                         
				                                GL11.glPushMatrix(); {
				                                    GL11.glTranslatef(0.0f,0.0f,0.75f);
				                                    sphere.DrawSphere(0.2f, 32, 32); 
				                                    


				                                } GL11.glPopMatrix();
				                            } GL11.glPopMatrix();
				                        } GL11.glPopMatrix();
				                    } GL11.glPopMatrix ();
		                       
		                                    
		                                   
		                         
			                } GL11.glPopMatrix();
		                //chest


		            } GL11.glPopMatrix();


		            // pelvis

		            // right hip
		    
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(-0.5f,-0.2f,0.0f);
		               
		                sphere.DrawSphere(0.25f, 32, 32); 


		                // right high leg
		          
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,0.0f);
		                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
		                
		                    
		                    GL11.glRotatef((0)+90,1.0f,0.0f,0.0f);    //Avoid turning straight
		                            //   GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
		                    GL11.glRotatef(LimbRotation/2, 1f, 0f, 0);
		                    cylinder.DrawCylinder(0.15f,0.7f,32);


		                    // right knee
		           
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.75f);
		                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
		                       
		                        sphere.DrawSphere(0.25f, 32, 32); 

		                        //right low leg
		                  
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.0f);
		                         
		                         
		                           
		                            cylinder.DrawCylinder(0.15f,0.7f,32);
		                          
		                            // right foot
		                      
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.75f);
		                                sphere.DrawSphere(0.3f, 32, 32);  

		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix();
		                } GL11.glPopMatrix();
		            } GL11.glPopMatrix();

		            // pelvis


		            // left hip
			      
			            GL11.glPushMatrix(); {
			                GL11.glTranslatef(0.5f,-0.2f,0.0f);
			               
			                sphere.DrawSphere(0.25f, 32, 32); 


			                // left high leg
			         
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(0.0f,0.0f,0.0f);
			                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
			                
			                    
			                    GL11.glRotatef((-0/2)+90,1.0f,0.0f,0.0f);    //Avoid turning straight
			                            //   GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
			                    cylinder.DrawCylinder(0.15f,0.7f,32);


			                    // left knee
			              
			                    GL11.glPushMatrix(); {
			                        GL11.glTranslatef(0.0f,0.0f,0.75f);
			                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
			                        sphere.DrawSphere(0.25f, 32, 32); 

			                        //left low leg
			                   	
			                        GL11.glPushMatrix(); {
			                            GL11.glTranslatef(0.0f,0.0f,0.0f);
			                            
			                            cylinder.DrawCylinder(0.15f,0.7f,32);

			                   
			                            GL11.glPushMatrix(); {
			                                GL11.glTranslatef(0.0f,0.0f,0.75f);
			                                sphere.DrawSphere(0.3f, 32, 32);  

			                            } GL11.glPopMatrix();
			                        } GL11.glPopMatrix();
			                    } GL11.glPopMatrix();
			                } GL11.glPopMatrix();
			            } GL11.glPopMatrix();
		        } GL11.glPopMatrix();
		         
		    } 

		

	}
	
	
	
}
