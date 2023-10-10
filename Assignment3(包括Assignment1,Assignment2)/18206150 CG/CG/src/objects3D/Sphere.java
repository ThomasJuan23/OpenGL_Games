package objects3D;

import org.lwjgl.opengl.GL11;

public class Sphere {

	
	public Sphere() {

	}
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	// 7b should be your primary source, we will cover more about circles in later lectures to understand why the code works 
	public void DrawSphere(float radius,float nSlices,float nSegments) {
		float inctheta = (float) ((2.0f * Math.PI) / nSlices);
		float incphi = (float) (Math.PI / nSegments);
		GL11.glBegin(GL11.GL_QUADS);  //draw the quads , it need four vertices
		for (float theta = (float)( -Math.PI); theta < Math.PI; theta += inctheta) {
			for (float phi = (float)( -Math.PI / 2.0f); phi < Math.PI / 2.0f; phi += incphi) {
				float x1 = (float) ((float) radius * Math.cos(phi) * Math.cos(theta));   //get the x value  x = r¦Õ*cos¦È = r cos¦Õ cos¦È				
				float y1 = (float) ((float) radius * Math.cos(phi) * Math.sin(theta));   //get the y value y = r ¦Õ*sin¦È = r cos¦Õ sin¦È		
				float z1 = (float) (radius * Math.sin(phi));    //get the z value z = r sin¦Õ
				float x2 = (float) ((float) radius * Math.cos(phi) * Math.cos(theta + inctheta));//get the x value  x = r¦Õ*cos¦È = r cos¦Õ cos¦È				
				float y2 = (float) ((float) radius * Math.cos(phi) * Math.sin(theta + inctheta));//get the y value y = r ¦Õ*sin¦È = r cos¦Õ sin¦È				
				float z2 = (float) (radius * Math.sin(phi)); //get the z value z = r sin¦Õ
				float x3 = (float) ((float) radius * Math.cos(phi+incphi) * Math.cos(theta + inctheta));//get the x value  x = r¦Õ*cos¦È = r cos¦Õ cos¦È			
				float y3 = (float) ((float) radius * Math.cos(phi+incphi) * Math.sin(theta + inctheta));//get the y value y = r ¦Õ*sin¦È = r cos¦Õ sin¦È
				float z3 = (float) (radius * Math.sin(phi + incphi));//get the z value z = r sin¦Õ
				float x4 = (float) ((float) radius * Math.cos(phi+incphi ) * Math.cos(theta));//get the x value  x = r¦Õ*cos¦È = r cos¦Õ cos¦È
				float y4 = (float) ((float) radius * Math.cos(phi+incphi ) * Math.sin(theta));//get the y value y = r ¦Õ*sin¦È = r cos¦Õ sin¦È
				float z4 = (float) (radius * Math.sin(phi+incphi));//get the z value z = r sin¦Õ
				   //draw the quads, the four points of the quad should be sorted in a counter clockwise order
				GL11.glNormal3f(x1, y1, z1);   //glNormal must is in front of of glVertex
				GL11.glVertex3f(x1, y1, z1);
				
				GL11.glNormal3f(x2, y2, z2);
				GL11.glVertex3f(x2, y2, z2);
				
				GL11.glNormal3f(x3, y3, z3);
				GL11.glVertex3f(x3, y3, z3);
				
			    GL11.glNormal3f(x4,y4,z4);
				GL11.glVertex3f(x4, y4, z4);
			
				
				
			 	
			 
			
				
				
			
				

			}

		}
		GL11.glEnd();
	


	}
}

 