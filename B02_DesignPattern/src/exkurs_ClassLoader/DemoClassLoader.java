package exkurs_ClassLoader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class DemoClassLoader {
	/*
	 * Eine Klasse in Java wird durch ihren voll qualifizierten Namen und dem
	 * ClassLoader, der sie geladen hat identifiziert.
	 * 
	 * Daher ist es möglich, das mehrere Klassen mit dem selben Namen in einer VM
	 * gleichzeitig existieren, solange sie von unterschiedlichen Classloadern
	 * geladen wurden. Zwei Klassen, die mit verschiedenen ClassLoadern geladen
	 * wurden, sind von verschiedenen Typen, also inkompatibel, selbst wenn sie von
	 * dem selben Class file geladen wurden.
	 */
	
	/*
	 * https://www.geeksforgeeks.org/classloader-in-java/
	 * 
	 * 
	 * Delegation Model: The Java Virtual Machine and the Java ClassLoader use an
	 * algorithm called the Delegation Hierarchy Algorithm to Load the classes into
	 * the Java file.
	 * 
	 * The ClassLoader works based on a set of operations given by the delegation
	 * model. They are: ClassLoader always follows the Delegation Hierarchy
	 * Principle. Whenever JVM comes across a class, it checks whether that class is
	 * already loaded or not. If the Class is already loaded in the method area then
	 * the JVM proceeds with execution. If the class is not present in the method
	 * area then the JVM asks the Java ClassLoader Sub-System to load that
	 * particular class, then ClassLoader sub-system hands over the control to
	 * Application ClassLoader. Application ClassLoader then delegates the request
	 * to Extension ClassLoader and the Extension ClassLoader in turn delegates the
	 * request to Bootstrap ClassLoader. Bootstrap ClassLoader will search in the
	 * Bootstrap classpath(JDK/JRE/LIB). If the class is available then it is
	 * loaded, if not the request is delegated to Extension ClassLoader. Extension
	 * ClassLoader searches for the class in the Extension
	 * Classpath(JDK/JRE/LIB/EXT). If the class is available then it is loaded, if
	 * not the request is delegated to the Application ClassLoader. Application
	 * ClassLoader searches for the class in the Application Classpath. If the class
	 * is available then it is loaded, if not then a ClassNotFoundException
	 * exception is generated.
	 * 
	 * Visibility Principle: The Visibility Principle states that a class loaded by
	 * a parent ClassLoader is visible to the child ClassLoaders but a class loaded
	 * by a child ClassLoader is not visible to the parent ClassLoaders. Suppose a
	 * class GEEKS.class has been loaded by the Extension ClassLoader, then that
	 * class is only visible to the Extension ClassLoader and Application
	 * ClassLoader but not to the Bootstrap ClassLoader. If that class is again
	 * tried to load using Bootstrap ClassLoader it gives an exception
	 * java.lang.ClassNotFoundException. Uniqueness Property: The Uniquesness
	 * Property ensures that the classes are unique and there is no repetition of
	 * classes. This also ensures that the classes loaded by parent classloaders are
	 * not loaded by the child classloaders. If the parent class loader isn’t able
	 * to find the class, only then the current instance would attempt to do so
	 * itself.
	 * 
	 * Methods of Java.lang.ClassLoader
	 * 
	 * After the JVM requests for the class, a few steps are to be followed in order
	 * to load a class. The Classes are loaded as per the delegation model but there
	 * are a few important Methods or Functions that play a vital role in loading a
	 * Class.
	 * 
	 * loadClass(String name, boolean resolve): This method is used to load the
	 * classes which are referenced by the JVM. It takes the name of the class as a
	 * parameter. This is of type loadClass(String, boolean). defineClass(): The
	 * defineClass() method is a final method and cannot be overriden. This method
	 * is used to define a array of bytes as an instance of class. If the class is
	 * invalid then it throws ClassFormatError. findClass(String name): This method
	 * is used to find a specified class. This method only finds but doesn’t load
	 * the class. findLoadedClass(String name): This method is used to verify
	 * whether the Class referenced by the JVM was previously loaded or not.
	 * Class.forName(String name, boolean initialize, ClassLoader loader): This
	 * method is used to load the class as well as initialize the class. This method
	 * also gives the option to choose any one of the ClassLoaders. If the
	 * ClassLoader parameter is NULL then Bootstrap ClassLoader is used.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * Bootstrap Class Loader: It loads standard JDK class files from rt.jar and
		 * other core classes. It is a parent of all class loaders. It doesn't have any
		 * parent. When we call String.class.getClassLoader() it returns null, and any
		 * code based on it throws NullPointerException. It is also called Primordial
		 * ClassLoader. It loads class files from jre/lib/rt.jar. For example, java.lang
		 * package class.
		 * 
		 * Extensions Class Loader: It delegates class loading request to its parent. If
		 * the loading of a class is unsuccessful, it loads classes from jre/lib/ext
		 * directory or any other directory as java.ext.dirs. It is implemented by
		 * sun.misc.Launcher$ExtClassLoader in JVM.
		 * 
		 * System Class Loader: It loads application specific classes from the CLASSPATH
		 * environment variable. It can be set while invoking program using -cp or
		 * classpath command line options. It is a child of Extension ClassLoader. It is
		 * implemented by sun.misc.Launcher$AppClassLoader class. All Java ClassLoader
		 * implements java.lang.ClassLoader.
		 */
		/*
		 * getClassLoader() Beschreibung
		 * Returns the class loader for the class. Some implementations may use null to
		 * represent the bootstrap class loader. This method will return null in such
		 * implementations if this class was loaded by the bootstrapclass loader.
		 */
		System.out.println("ClassLoader von ArrayList: " + ArrayList.class.getClassLoader());
		
		System.out.println("ClassLoader von Katze: " + Katze.class.getClassLoader());
		
		Katze katze = new Katze();
		
		//Bytecode der Katze holen
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bin/exkurs_ClassLoader/Katze.class"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int zahl;
		while((zahl = bis.read()) != -1) {
			baos.write(zahl);
		}
		byte[] bytecode = baos.toByteArray();
		System.out.println(Arrays.toString(bytecode));
		
		MyClassLoader myClassLoader = new MyClassLoader();
		//Class Objekt laden
		Class<?> katzeClass = myClassLoader.findClass("exkurs_ClassLoader.Katze", bytecode);
		
		System.out.println("zweiter ClassLoader von Katze: " + katzeClass.getClassLoader());
		
		Object katze2 = katzeClass.newInstance();
		Katze k2 = new Katze();
		
		System.out.println("ClassLoader von Katze k2: " + k2.getClass().getClassLoader());
		try {
			katze = (Katze)katze2;
		}catch(ClassCastException e) {
			System.err.println(e.getMessage());
		}
		
		System.err.println("Hallo Welt");
		
	}
}
