package GraphicsObjects;



public class Vector4f {

	public float x=0;
	public float y=0;
	public float z=0;
	public float a=0;
	
	public Vector4f() 
	{  
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		a = 0.0f;
	}
	 
	public Vector4f(float x, float y, float z,float a) 
	{ 
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
	
	 //implement Vector plus a Vector 
	public Vector4f PlusVector(Vector4f Additonal) 
	{ 
		return new Vector4f(this.x+Additonal.x, this.y+Additonal.y, this.z+Additonal.z,this.a+Additonal.a);
	} 
	
	 //implement Vector minus a Vector 
	public Vector4f MinusVector(Vector4f Minus) 
	{                                              //a-b=a+(-b)=c, supposing that a=(a1,b1), b=(a2,b2),-b=(-a2,-b2) c=(a3,b3), then a3=a1-a2,b3=b1-b2
		float a0 = x - Minus.x;                      //this method is used to get the result of this vector minus Minus vector.
		float b = y - Minus.y;
		float c = z - Minus.z;
		float d= a-Minus.a;
		Vector4f newv = new Vector4f(a0, b, c,d);
		return newv;
	}
	
	//implement Vector plus a Point 
	public Point4f PlusPoint(Point4f Additonal)  //a+A=B, a=B-A, supposing that a=(a,b), A(x1,y1). B(x2,y2), a=x2-x1, b=y2-y1,so x2=x1+a, y2=y1+b
	{ 
		float a0 = Additonal.x +x;                //this method is used to get the result of this vector plus Additonal point.
		float b = Additonal.y + y;
		float c = Additonal.z + z;
		float d=Additonal.a-a;
		Point4f newp = new Point4f(a0, b, c,d);
		return newp;
	} 
	//Do not implement Vector minus a Point as it is undefined 
	
	//Implement a Vector * Scalar 
	public Vector4f byScalar(float scale )//supposing that a=(a,b), x is a scale, a*x==(x*a,x*b)
	{
		float a = x * scale;                       //this method is used to get a result of this vector multiply a scale; 
		float b = y * scale;
		float c = z * scale;
		float d=a*scale;
		Vector4f newv = new Vector4f(a, b, c,d);
		return newv;
	}
	
	//implement returning the negative of a  Vector  
	public Vector4f  NegateVector()
	{ //supposing that a=(a,b), so -a=(-a,-b)
		float a = -x;                            //this method is used to get the negative vector of this vector; 
		float b = -y;
		float c = -z;
		float d=-a;
		Vector4f newv = new Vector4f(a, b, c,d);
		return newv;
	}
	//implement getting the length of a Vector  
	public float length()
	{
	    return (float) Math.sqrt(x*x + y*y + z*z+ a*a);
	}
	
	//Just to avoid confusion here is getting the Normal  of a Vector  
	public Vector4f Normal()
	{
		float LengthOfTheVector=  this.length();
		return this.byScalar(1.0f/ LengthOfTheVector); 
	} 
	
	//implement getting the dot product of Vector.Vector  

	public float dot(Vector4f v)
	{ 
		return ( this.x*v.x + this.y*v.y + this.z*v.z+ this.a*v.a);
	}
	
	// Implemented this for you to avoid confusion 
	// as we will not normally  be using 4 float vector  
	public Vector4f cross(Vector4f v)  
	{ 
    float u0 = (this.y*v.z - z*v.y);
    float u1 = (z*v.x - x*v.z);
    float u2 = (x*v.y - y*v.x);
    float u3 = 0; //ignoring this for now  
    return new Vector4f(u0,u1,u2,u3);
	}
 
}
	 
	   

/*

										MMMM                                        
										MMMMMM                                      
 										MM MMMM                                    
 										MMI  MMMM                                  
 										MMM    MMMM                                
 										MMM      MMMM                              
  										MM        MMMMM                           
  										MMM         MMMMM                         
  										MMM           OMMMM                       
   										MM             .MMMM                     
MMMMMMMMMMMMMMM                        MMM              .MMMM                   
MM   IMMMMMMMMMMMMMMMMMMMMMMMM         MMM                 MMMM                 
MM                  ~MMMMMMMMMMMMMMMMMMMMM                   MMMM               
MM                                  OMMMMM                     MMMMM            
MM                                                               MMMMM          
MM                                                                 MMMMM        
MM                                                                   ~MMMM      
MM                                                                     =MMMM    
MM                                                                        MMMM  
MM                                                                       MMMMMM 
MM                                                                     MMMMMMMM 
MM                                                                  :MMMMMMMM   
MM                                                                MMMMMMMMM     
MM                                                              MMMMMMMMM       
MM                             ,MMMMMMMMMM                    MMMMMMMMM         
MM              IMMMMMMMMMMMMMMMMMMMMMMMMM                  MMMMMMMM            
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM               ZMMMMMMMM              
MMMMMMMMMMMMMMMMMMMMMMMMMMMMM          MM$             MMMMMMMMM                
MMMMMMMMMMMMMM                       MMM            MMMMMMMMM                  
  									MMM          MMMMMMMM                     
  									MM~       IMMMMMMMM                       
  									MM      DMMMMMMMM                         
 								MMM    MMMMMMMMM                           
 								MMD  MMMMMMMM                              
								MMM MMMMMMMM                                
								MMMMMMMMMM                                  
								MMMMMMMM                                    
  								MMMM                                      
  								MM                                        
                             GlassGiant.com */