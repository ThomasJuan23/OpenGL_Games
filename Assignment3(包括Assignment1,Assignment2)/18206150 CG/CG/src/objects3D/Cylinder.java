package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import java.math.*;

public class Cylinder {

	
	public Cylinder() { 
	}
	
	// remember to use Math.PI isntead PI 
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCylinder(float radius, float height, int nSegments ) 
	{
		for (float i = (float) 0.0; i < nSegments; i += 1.0)
		{ /* a loop around circumference of a tube */
		float angle = (float) (Math.PI * i * 2.0 / nSegments) ;
		double nextAngle = Math.PI * (i + 1.0) * 2.0 / nSegments;
		/* compute sin & cosine */
		float x1 = (float) Math.sin(angle)*radius, y1 = (float) Math.cos(angle)*radius;    //get a position on the circle
		float x2 = (float) Math.sin(nextAngle)*radius, y2 = (float) Math.cos(nextAngle)*radius;
		/* draw the top face */
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glNormal3f(0.0f, 0.0f, -height);    //to make it smoother    
		GL11.glVertex3f(x1, y1, 0.0f);    //draw the triangle
		GL11.glVertex3f(x2, y2, 0.0f);  
		GL11.glVertex3f(0.0f,0.0f, 0.0f);
		GL11.glEnd();
		//draw the bottom face
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glNormal3f(0.0f, 0.0f, height);    //to make it smoother    
		GL11.glVertex3f(x1, y1, height);     //
		GL11.glVertex3f(x2, y2, height);   
		GL11.glVertex3f(0.0f,0.0f, height);
		GL11.glEnd();
		//draw the top triangle
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glNormal3f(x1, y1, 0.0f);    //to make it smoother    //this x1 means x1-0  //y1 means y1-0
		GL11.glVertex3f(x1, y1, 0.0f);    //draw the triangle
		GL11.glNormal3f(x2, y2, 0.0f);     //x2 means x2-0, y2 means y2-0  0 means height-height
		GL11.glVertex3f(x2, y2, height);   //this is the z2 of the top - z1 of the bottom, so z is height
		GL11.glNormal3f(x1, y1, 0.0f); 
		GL11.glVertex3f(x1, y1, height);
		GL11.glEnd();
		//draw the bottom triangle
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glNormal3f(x1, y1, 0.0f);   //to make it smoother    //this x1 means x1-0  //y1 means y1-0
		GL11.glVertex3f(x1, y1, 0.0f);  //draw the triangle
		GL11.glNormal3f(x2, y2, 0.0f); //x2 means x2-0, y2 means y2-0  0 means height-height
		GL11.glVertex3f(x2, y2, 0.0f); //this is the z2 of the top - z1 of the bottom, so z is height
		GL11.glNormal3f(x2, y2, 0.0f); 
		GL11.glVertex3f(x2, y2, height);
		GL11.glEnd();}
	}
}
