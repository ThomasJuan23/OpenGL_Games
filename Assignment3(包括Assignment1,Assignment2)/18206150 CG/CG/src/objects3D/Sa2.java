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


public class Sa2{

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

	
	public Sa2() {

	}
	

	public void DrawHuman(float delta,boolean GoodAnimation, Texture t, Texture t2, Texture t3) throws Exception 
 { 
		 //this is a frame of animation
		 float theta = (float) (delta * 2 * Math.PI);
		  float LimbRotation;
	
			 LimbRotation = (float) Math.cos(theta)*45;
	
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
        TexSphere tex=new TexSphere();
        TexCuboid tcu=new TexCuboid();
  
        delta=delta*8;
   	 
		 GL11.glColor3f(black[0], black[1], black[2]);
		 GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
		 GL11.glPushMatrix(); 
		 
		 {
			  GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
			  GL11.glTranslatef(0.0f,0.5f,0.0f);
			
			  GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f); 
			  
			  //rotate the pelvis to let the blue above
			 // Color.white.bind(); //remove the origin color
			    t2.bind(); //bind the texture
			    GL11.glEnable(GL11.GL_TEXTURE_2D);   // the form
			    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
			    if(delta<20.5&&delta>10.56f) {
			    	GL11.glRotatef(-35, 0.0f, 1.0f, 0.0f);
			    	GL11.glTranslatef(0, 0.1f, 0);
			    }
			    
			    if(delta>20&&LimbRotation<0&&delta<=21f)
			    {
			    	GL11.glTranslatef(0.0f, LimbRotation/100, 0.0f);
			    }
			    if(delta>21)
			    {
			    	GL11.glTranslatef(0.0f, -0.2f, 0.0f);
			    }			  
			    tex.DrawTexSphere(0.5f, 32, 32, t2);
			
			    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);  
			 
			
			 GL11.glPushMatrix(); {
				 if(delta<20.5&&delta>10.56f) 
				    	GL11.glRotatef(-35, 0.0f, 1.0f, 0.0f);
		            GL11.glTranslatef(0.0f,0.5f,0.0f);
		        
		            GL11.glRotated(100.0f,0.0f, 1.0f, 0.0f);   
		            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
		        
				    t3.bind(); 
				    GL11.glEnable(GL11.GL_TEXTURE_2D);
				    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
		            tex.DrawTexSphere(0.5f, 32, 32, t3);  
		            GL11.glDisable(GL11.GL_TEXTURE_2D);
		            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);   
		            GL11.glRotated(-100.0f,0.0f, 1.0f, 0.0f);
		           
		      

		        
		      
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(0.0f,0.0f, 0.0f);
		                GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
		          
		                cylinder.DrawCylinder(0.15f,0.7f,32);


		              
		            	 
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,1.0f);
		                    GL11.glRotatef(82.0f,0.0f,0.0f,1.0f);   //rotate the head to let the eye On the front
		       
		        		    t.bind(); //bind the texture
		        		    GL11.glEnable(GL11.GL_TEXTURE_2D);//the form
		        		    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
		                    tex.DrawTexSphere(0.5f, 32, 32, t);  //the head with texture
		                  //  sphere.DrawSphere(0.5f, 32, 32); 
		                    GL11.glDisable(GL11.GL_TEXTURE_2D);
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
		                        
		                        if(delta<10.56f)
		                        GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f);
		                        if(delta>=10.56) {
 		                        	 GL11.glRotatef(30,1.0f,0.0f,0.0f);
 		                        }
		                   
		                        cylinder.DrawCylinder(0.15f,0.7f,32);


		                        // left elbow
		                   	
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.75f);
		                            sphere.DrawSphere(0.2f, 32, 32); 
		                            
		                            //left forearm
		                       
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.0f);
		                                               GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
		                          
		                                               if(delta>=10.56) {
			              		                        	 GL11.glRotatef(-90,1.0f,0.0f,0.0f);
			              		                        }
		                                               
		                                cylinder.DrawCylinder(0.1f,0.7f,32);

		                                // left hand
		                         
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
				                        GL11.glRotatef(90.0f,1.0f,-0.5f,0.0f);   
				                          if(delta<10.56f)
				                    	  GL11.glRotatef(LimbRotation,-1.0f,0.0f,0.0f);    
				                   
				                          if(delta>=10.56) {
			 		                        	 GL11.glRotatef(-30,1.0f,0.0f,0.0f);
			 		                        }
				                        cylinder.DrawCylinder(0.15f,0.7f,32);


				                        // right elbow
				                  
				                        GL11.glPushMatrix(); {
				                            GL11.glTranslatef(0.0f,0.0f,0.75f);
				                            sphere.DrawSphere(0.2f, 32, 32); 
				                            
				                            //right forearm
				                     
				                            GL11.glPushMatrix(); {
				                                GL11.glTranslatef(0.0f,0.0f,0.0f);
				                                               GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
				                             
				                                               if(delta>=10.56) {
					              		                        	 GL11.glRotatef(-90,1.0f,0.0f,0.0f);
					              		                        }
				                                cylinder.DrawCylinder(0.1f,0.7f,32);

				                                // right hand
				                           
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


		         

		            // right hip
		  
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(-0.5f,-0.2f,0.0f);
		               
		                sphere.DrawSphere(0.25f, 32, 32); 


		                // right high leg
		        
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,0.0f);
		                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
		                
		                    if(delta<=10.56f) {
		                    GL11.glRotatef((LimbRotation/2)+90,1.0f,0.0f,0.0f); }
		                    
		                    if(delta>10.56f) {
		                    	GL11.glRotatef(90,1.0f, 0.0f, 0.0f);
		                    	GL11.glRotatef(30,0.0f, 0.0f, 1.0f);
		                
		                    }
		                    
		                    
		                    if(delta>20.5) {
		                    	GL11.glRotatef(30,0.0f, 1.0f, 0.0f);
		                    }
		                    cylinder.DrawCylinder(0.15f,0.7f,32);


		                    // right knee

		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.75f);
		                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
		                       
		                        sphere.DrawSphere(0.25f, 32, 32); 

		                        //right low leg
		                   	
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.0f);
		                         
		                            if(LimbRotation<0.0f&&delta<=10.56f) {  //Avoid abnormal knee bending
		                            GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f);}
		                            if(delta>10.56f&&delta<20.5f) {
		                            	 GL11.glRotatef(-60,1.0f,0.0f,0.0f);
		                            }
		                           
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


		    
			            GL11.glPushMatrix(); {
			                GL11.glTranslatef(0.5f,-0.2f,0.0f);
			               
			                sphere.DrawSphere(0.25f, 32, 32); 


			                // left high leg
			          
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(0.0f,0.0f,0.0f);
			                    GL11.glRotatef(150.0f,1.0f,0.0f,0.0f);
			                    if(delta>10.56f) {
			                    	GL11.glRotatef(30,0.0f, 0.0f, 1.0f);
			                    }
			                    if(delta>20.5f) {
			                    	GL11.glRotatef(-30,1.0f, 0.0f, 0.0f);
			                    }
			                    
			                    
			      
			                    cylinder.DrawCylinder(0.15f,0.7f,32);


			                    // left knee
			            
			                    GL11.glPushMatrix(); {
			                        GL11.glTranslatef(0.0f,0.0f,0.75f);
			                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
			                        sphere.DrawSphere(0.25f, 32, 32); 

			                        //left low leg
			              
			                        GL11.glPushMatrix(); {
			                            GL11.glTranslatef(0.0f,0.0f,0.0f);
			                            if(delta<20.5f)
			                            GL11.glRotatef(-60.0f,1.0f,0.0f,0.0f);
			                            
//			                           
			                            cylinder.DrawCylinder(0.15f,0.7f,32);

			                            // left foot
			                       	
			                            GL11.glPushMatrix(); {
			                                GL11.glTranslatef(0.0f,0.0f,0.75f);
			                                sphere.DrawSphere(0.3f, 32, 32);  
			                              
                                               GL11.glPushMatrix();{
                                            	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
                                            	GL11.glTranslatef(-0.3f, 0.0f, 0.0f);
                                            	GL11.glTranslatef(0.0f, 0.4f, 0.0f);
                                            	if(delta>10.56f) {
                                            		GL11.glRotatef(26, 0.0f, 1.0f, 0.0f);
                                            		GL11.glRotatef(-25, 1.0f, 0.0f, 0.0f);
                                            		GL11.glRotatef(3, 0.0f, 0.0f, 1.0f);
                                            	}
                                            	if(delta>20.5f) {
                                            		 GL11.glRotatef(60.0f,1.0f,0.0f,0.0f);
                                            		 //GL11.glRotatef(-30.0f,0.0f,1.0f,0.0f);
                                            		 GL11.glRotatef(-22.0f,0.0f,0.0f,1.0f);
                                            		 GL11.glRotatef(-14.0f,0.0f,1.0f,0.0f);
                                            		 GL11.glTranslatef(0.0f, 0.6f, 0.2f);
                                            	
                                            	}
                                            	tcu.DrawTexCuboid(t3, 0.05f, 1.4f, 0.3f);
                                        
                                            	GL11.glPushMatrix();{
                                                    GL11.glTranslatef(-0.2f, 0.7f, -0.3f);
                                            		cylinder.DrawCylinder(0.15f, 0.2f, 36);

                                            	}GL11.glPopMatrix();
                                            	GL11.glPushMatrix();{
                                                    GL11.glTranslatef(-0.2f, -0.7f, -0.3f);
                                            		cylinder.DrawCylinder(0.15f, 0.2f, 36);

                                            	}GL11.glPopMatrix();
                                            	GL11.glPushMatrix();{
                                                    GL11.glTranslatef(-0.2f, 0.7f, 0.15f);
                                            		cylinder.DrawCylinder(0.15f, 0.2f, 36);

                                            	}GL11.glPopMatrix();
                                            	GL11.glPushMatrix();{
                                                    GL11.glTranslatef(-0.2f, -0.7f, 0.15f);
                                            		cylinder.DrawCylinder(0.15f, 0.2f, 36);

                                            	}GL11.glPopMatrix();
   	
                                            }GL11.glPopMatrix();
			                            } GL11.glPopMatrix();
			                        } GL11.glPopMatrix();
			                    } GL11.glPopMatrix();
			                } GL11.glPopMatrix();
			            } GL11.glPopMatrix();
		        } GL11.glPopMatrix();
		         
		    } 

		

	}
	
	
	
}
 
	/*
	 
	 
}

	*/
	 
