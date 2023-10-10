package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class TexCuboid {

	
	public TexCuboid() {

	}
	
	// Implement using notes  and looking at TexSphere
	public void DrawTexCuboid(Texture texture, float w, float v0,float h) 
 {

        //get the 8 vertices of the cube
	Point4f vertices[] = { 	new Point4f(-1.0f, -1.0f, -1.0f, 0.0f),     //this is the vertex 0
							new Point4f(-1.0f, -1.0f, 1.0f,  0.0f),     //this is vertex 1
							new Point4f(-1.0f, 1.0f,  -1.0f, 0.0f),       //this is vertex2
							new Point4f(-1.0f, 1.0f,  1.0f,  0.0f),        //this is vertex3
							new Point4f(1.0f, -1.0f,  -1.0f, 0.0f),       //this is vertex4
							new Point4f(1.0f, -1.0f,  1.0f,  0.0f),      //this is vertex5
							new Point4f(1.0f,  1.0f, -1.0f,  0.0f),       //this is vertex6
							new Point4f(1.0f,  1.0f, 1.0f,   0.0f), //this is vertex7
							};
	
	          //the six faces of the cube, each face has one quad
	int[][] faces = {   { 3, 7, 6, 2 },        //The four points of the quad should be sorted in a counter clockwise order
			            { 1, 3, 2, 0 },        
		             	{ 5, 7, 3, 1 },       
			            { 4, 5, 1, 0 },
			            { 6, 4, 0, 2 },          
						{ 6, 7, 5, 4 },            	  						 	  						
						} ;

	   GL11.glBegin(GL11.GL_QUADS);
	for(int face=0; face<6; face++) {
		//texture.bind();
	 
	  
	    Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]); 
		Vector4f w0 = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
		Vector4f normal = v.cross(w0).Normal();  //get the normal vector
	    GL11.glNormal3f(normal.x, normal.y, normal.z);	
	    GL11.glTexCoord2f(0, 0);               // a texture need 4 glTexCoord2f method  //a face is a texture
	    GL11.glVertex3f(vertices[faces[face][0]].x*w, vertices[faces[face][0]].y*v0, vertices[faces[face][0]].z*h); 
	    GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(vertices[faces[face][1]].x*w, vertices[faces[face][1]].y*v0, vertices[faces[face][1]].z*h);
	    GL11.glTexCoord2f(1, 1);
	    GL11.glVertex3f(vertices[faces[face][2]].x*w, vertices[faces[face][2]].y*v0, vertices[faces[face][2]].z*h);
	    GL11.glTexCoord2f(0, 1);
		  //draw the quad
		GL11.glVertex3f(vertices[faces[face][3]].x*w, vertices[faces[face][3]].y*v0, vertices[faces[face][3]].z*h);
	
	}
	
    GL11.glEnd();

		
		

	}
	
	
	
}