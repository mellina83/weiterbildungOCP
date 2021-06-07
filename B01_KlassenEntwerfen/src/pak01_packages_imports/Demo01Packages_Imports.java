package pak01_packages_imports;

//import pak01_packages_imports.subpak1.*;
//import pak01_packages_imports.subpak2.*;

import static pak01_packages_imports.subpak1.ClassA.goA;
import static pak01_packages_imports.subpak1.ClassA.text;

public class Demo01Packages_Imports {
	public static void main(String[] args) {
		pak01_packages_imports.subpak1.ClassA a1 = new pak01_packages_imports.subpak1.ClassA();
		
		pak01_packages_imports.subpak2.ClassA a2 = new pak01_packages_imports.subpak2.ClassA();
		//SubPakete werden nicht mitimportiert
//		ClassB b1;
		
		goA();
		System.out.println(text);		
//		System.out.println(ClassA.text);
		
	}
}
