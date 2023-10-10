package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Utils;

public class Action1 {
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

	
	public Action1() {

	}

	public void DrawAction1(float delta,boolean GoodAnimation, Texture t, Texture t2, Texture t3) throws Exception 
 { 

		 float theta = (float) (delta * 2 * Math.PI);
		  float LimbRotation;
		
			 LimbRotation = (float) Math.cos(theta)*45;
		
		  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
        TexSphere tex=new TexSphere();
        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
        GL11.glPushMatrix();{
            GL11.glTranslatef(0.0f, 1.3f, 0.0f);
            GL11.glRotatef(90, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(90,1.0f,0.0f,0.0f);
            cylinder.DrawCylinder(0.15f, 4.0f, 36);
           
       
        GL11.glColor3f(blue[0], blue[1], blue[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
        GL11.glPushMatrix();{
        	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.2f, 0.0f, 0.0f);
            sphere.DrawSphere(0.25f, 36, 36);
        
        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
        GL11.glPushMatrix();{
        	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
        	GL11.glTranslatef(0.2f, 0.0f, 0.0f);
        	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
        	cylinder.DrawCylinder(0.15f, 5.0f, 36);
        }GL11.glPopMatrix();}
        GL11.glPopMatrix();
        
        GL11.glColor3f(blue[0], blue[1], blue[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
        GL11.glPushMatrix();{
        	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-4.2f, 0.0f, 0.0f);
            sphere.DrawSphere(0.25f, 36, 36);
        
        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
        GL11.glPushMatrix();{
        	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
        	GL11.glTranslatef(0.2f, 0.0f, 0.0f);
        	GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
        	cylinder.DrawCylinder(0.15f, 5.0f, 36);
        }GL11.glPopMatrix();}
        
        GL11.glPopMatrix();
        
        GL11.glColor3f(blue[0], blue[1], blue[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
        GL11.glPushMatrix();{
        GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-1.2f, 0.0f, 0.0f);
        if(delta<=5.7f&&delta>=5.0f)
            GL11.glRotatef(-LimbRotation*8, 1.0f, 0.0f, 0.0f);
        if(delta>5.7f&&delta<=14.65f) {
            GL11.glRotatef(-185, 1.0f, 0.0f, 0.0f);
            if(delta>=13.5f&&delta<=14.65f) {
                GL11.glRotatef(LimbRotation*8, 1.0f, 0.0f, 0.0f);}}
        sphere.DrawSphere(0.2f, 36, 36);
     	GL11.glColor3f(orange[0], orange[1], orange[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
        GL11.glPushMatrix();{
        GL11.glRotatef(180, 1.0f, 0.0f, 0.0f);
        cylinder.DrawCylinder(0.15f, 0.7f, 36);
        GL11.glColor3f(blue[0], blue[1], blue[2]);
        GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
        GL11.glPushMatrix();{
        	     GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
                 GL11.glTranslatef(-0.7f, 0.0f, 0.0f);
                 sphere.DrawSphere(0.2f, 36, 36);
             	 GL11.glColor3f(orange[0], orange[1], orange[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
           GL11.glPushMatrix();{
        	 GL11.glRotatef(90, 0.0f, 0.0f,1.0f);
        	 GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        	 GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
        	 GL11.glRotatef(-90, 1.0f, 0.0f, 0.0f);
        	 if(LimbRotation>0&&delta<=4.4)
        	 GL11.glRotatef(-LimbRotation*8/3, 1.0f, 0.0f, 0.0f);
        	 GL11.glRotatef(20, 0.0f, 0.6f, 0.0f);
        	 cylinder.DrawCylinder(0.15f, 0.7f, 36);
        	  GL11.glColor3f(blue[0], blue[1], blue[2]);
              GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
        	 GL11.glPushMatrix();{
        		 GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
                 GL11.glTranslatef(-0.8f, 0.0f, 0.0f);
      
        		 sphere.DrawSphere(0.2f, 36, 36);
        		 
        		 GL11.glPushMatrix(); 
        		 
        		 {    
        			 GL11.glRotatef(90, 0.0f, 0.0f, 1.0f);
        			 GL11.glRotatef(90, 1.0f, 0.0f, 0.0f);

        			  Color.white.bind(); 
        			    t3.bind(); 
        			    GL11.glEnable(GL11.GL_TEXTURE_2D); 
        			    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
        			    GL11.glRotatef(180, 0.0f, 1.0f, 0.0f);
        			    GL11.glRotatef(18, 1.0f, 0.0f, 0.0f);
        			    if(LimbRotation>0&&delta<=4.4)
        			    GL11.glRotatef(LimbRotation*8/3, 0.0f,1.0f,0.0f);
        			    GL11.glTranslatef(0.0f,0.48f,0.3f);
        			    tex.DrawTexSphere(0.5f, 32, 32, t3);
        			    GL11.glDisable(GL11.GL_TEXTURE_2D);
        				 GL11.glColor3f(orange[0], orange[1], orange[2]);
      		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
      		            GL11.glPushMatrix(); {
      		                GL11.glTranslatef(0.0f,0.0f, 0.0f);
      		                GL11.glRotatef(-180.0f,1.0f,0.0f,0.0f);

      		                cylinder.DrawCylinder(0.15f,0.7f,32);
      		              GL11.glColor3f(red[0], red[1], red[2]);
   		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
   		                GL11.glPushMatrix(); {
   		                    GL11.glTranslatef(0.0f,0.0f,1.0f);
   		                    GL11.glRotatef(-3,0.0f,0.0f,1.0f); 
   		                    Color.white.bind();
   		        		    t.bind();
   		        		    GL11.glEnable(GL11.GL_TEXTURE_2D);
   		        		    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
   		                    tex.DrawTexSphere(0.5f, 32, 32, t); 
   		                  
   		                    GL11.glDisable(GL11.GL_TEXTURE_2D);}
   		                    GL11.glPopMatrix();
        			  
      		            }GL11.glPopMatrix();
      		             
      		            
      		          GL11.glTranslatef(0.0f,0.0f,0.5f);
      		        GL11.glRotatef(90, 0.0f, 0.0f, 1.0f);
      		         GL11.glRotatef(-90, 1.0f, 0.0f, 0.0f);
      		        GL11.glRotatef(180, 0.0f, 0.0f, 1.0f);
      		      if(delta>=10.75f&&delta<=12.78f)
      		      {
        		        GL11.glRotatef(LimbRotation*2, 0.0f, 1.0f, 0.0f);} 
      		      GL11.glTranslatef(0, 0, 0);
      		          Color.white.bind();
      			    t2.bind();
      			    GL11.glEnable(GL11.GL_TEXTURE_2D); 
      			    GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST);
      			    tex.DrawTexSphere(0.5f, 32, 32, t2);  
      			    GL11.glDisable(GL11.GL_TEXTURE_2D);
      			  GL11.glRotatef(-180, 0.0f, 0.0f, 1.0f);
      			  GL11.glRotatef(90, 1.0f, 0.0f, 0.0f);
      			 
      			 
      			 GL11.glColor3f(blue[0], blue[1], blue[2]);
		           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(-0.5f,-0.2f,0.0f);
		               
		                sphere.DrawSphere(0.25f, 32, 32); 


		           	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                GL11.glPushMatrix(); {
		                	if(LimbRotation>0&&delta>=6.55f&&delta<=10.053f)
			                    GL11.glRotatef(-LimbRotation*2, 0.0f, 1.0f, 0.0f);
		                	if(LimbRotation>0&&delta>=12.78f&&delta<=13f)
			                    GL11.glRotatef(LimbRotation*2, 0.0f, 1.0f, 0.0f);
		                	if(delta>10.053f&&delta<=13f)
		                		GL11.glRotatef(-90, 0.0f, 1.0f, 0.0f);
		                    GL11.glTranslatef(0.0f,0.0f,0.0f);
		                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);

		                    cylinder.DrawCylinder(0.15f,0.7f,32);

		               	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.75f);
		                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
		                       
		                        sphere.DrawSphere(0.25f, 32, 32); 
		                   	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.0f);
		                         
		                            cylinder.DrawCylinder(0.15f,0.7f,32);
		                          
		                       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.75f);
		                                sphere.DrawSphere(0.3f, 32, 32);  

		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix();
		                } GL11.glPopMatrix();
		            } GL11.glPopMatrix();

			       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			            GL11.glPushMatrix(); {
			                GL11.glTranslatef(0.5f,-0.2f,0.0f);
			               
			                sphere.DrawSphere(0.25f, 32, 32); 

			           	 GL11.glColor3f(orange[0], orange[1], orange[2]);
			               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
			                GL11.glPushMatrix(); {
			                	
			                	if(LimbRotation>0&&delta>=6.55f&&delta<=10.053f)
				                    GL11.glRotatef(LimbRotation*2, 0.0f, 1.0f, 0.0f);
			                	
			                	if(LimbRotation>0&&delta>=12.78f&&delta<=13f)
				                    GL11.glRotatef(-LimbRotation*2, 0.0f, 1.0f, 0.0f);
			                	if(delta>=10.053f&&delta<=13f)
			                		GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
			                    GL11.glTranslatef(0.0f,0.0f,0.0f);
			                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
			                

			                    cylinder.DrawCylinder(0.15f,0.7f,32);


			               	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                    GL11.glPushMatrix(); {
			                        GL11.glTranslatef(0.0f,0.0f,0.75f);
			                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
			                        sphere.DrawSphere(0.25f, 32, 32); 

			                   	 GL11.glColor3f(orange[0], orange[1], orange[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
			                        GL11.glPushMatrix(); {
			                            GL11.glTranslatef(0.0f,0.0f,0.0f);

			                            cylinder.DrawCylinder(0.15f,0.7f,32);

			                           
			                       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                            GL11.glPushMatrix(); {
			                                GL11.glTranslatef(0.0f,0.0f,0.75f);
			                                sphere.DrawSphere(0.3f, 32, 32);  

			                            } GL11.glPopMatrix();
			                        } GL11.glPopMatrix();
			                    } GL11.glPopMatrix();
			                } GL11.glPopMatrix();
			            } GL11.glPopMatrix();

      			 
      			 
      			 
      			 
      			 
        		 }GL11.glPopMatrix();
        	 }GL11.glPopMatrix();
        	 
         }GL11.glPopMatrix();
         
  
     
          
         
         
         
         
         
         
 
        }GL11.glPopMatrix();
        
        }GL11.glPopMatrix();
        
            }GL11.glPopMatrix();
            GL11.glColor3f(blue[0], blue[1], blue[2]);
            GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
            GL11.glPushMatrix();{
            GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-2.7f, 0.0f, 0.0f);
            if(delta<=5.7f&&delta>=5.0f)
                GL11.glRotatef(-LimbRotation*8, 1.0f, 0.0f, 0.0f);
            if(delta>5.7f&&delta<=14.65f) {
                GL11.glRotatef(-185, 1.0f, 0.0f, 0.0f);
                if(delta>13.5f&&delta<=14.65f) {

                    GL11.glRotatef(LimbRotation*8, 1.0f, 0.0f, 0.0f);}}
            sphere.DrawSphere(0.2f, 36, 36);
         	GL11.glColor3f(orange[0], orange[1], orange[2]);
            GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
            GL11.glPushMatrix();{
            GL11.glRotatef(180, 1.0f, 0.0f, 0.0f);
            cylinder.DrawCylinder(0.15f, 0.7f, 36);
            GL11.glColor3f(blue[0], blue[1], blue[2]);
            GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
            GL11.glPushMatrix();{
            	     GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
                     GL11.glTranslatef(-0.7f, 0.0f, 0.0f);
                     sphere.DrawSphere(0.2f, 36, 36);
                 	 GL11.glColor3f(orange[0], orange[1], orange[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
               GL11.glPushMatrix();{
            	 GL11.glRotatef(90, 0.0f, 0.0f,1.0f);
            	 GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            	 GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
            	 GL11.glRotatef(-90, 1.0f, 0.0f, 0.0f);
            	 if(LimbRotation>0&&delta<=4.4)
            	 GL11.glRotatef(-LimbRotation*8/3, 1.0f, 0.0f, 0.0f);
            	 GL11.glRotatef(-20, 0.0f, 0.6f, 0.0f);
            	 cylinder.DrawCylinder(0.15f, 0.7f, 36);
            	  GL11.glColor3f(blue[0], blue[1], blue[2]);
                  GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
            	 GL11.glPushMatrix();{
            		 GL11.glRotatef(90, 0.0f, 1.0f, 0.0f);
                     GL11.glTranslatef(-0.8f, 0.0f, 0.0f);
          
            		 sphere.DrawSphere(0.2f, 36, 36);
            	 }GL11.glPopMatrix();
               }GL11.glPopMatrix();
            }GL11.glPopMatrix();
            }GL11.glPopMatrix();
            }GL11.glPopMatrix();
            
        }
        GL11.glPopMatrix();
        
 }}
        
        

	
	

