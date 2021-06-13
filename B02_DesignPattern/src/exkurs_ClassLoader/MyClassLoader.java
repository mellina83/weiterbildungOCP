package exkurs_ClassLoader;

public class MyClassLoader extends ClassLoader{
	
	public Class<?> findClass(String qualififiedClassName, byte[] byteCode){
		return defineClass(qualififiedClassName, byteCode, 0, byteCode.length);
	}
}
