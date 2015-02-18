package com.snapdeal.javacore;

public class Clazz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Just loads the class and creates the Class instance in MethodArea. 
			// So here Load, prepare, linking happened. No instance created so only static blocks called on class loading. 
			Class.forName("com.snapdeal.javacore.LoadMe"); 
			//Exception on Runtime InstantiationException since no arg const missing. 
			//Else this would have called Parent Contr and then LoadMe Constr
			//LoadMe.class.newInstance();  
			
			ParentLoadMe.class.newInstance(); //This will print the Parent Constr
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}

class ParentLoadMe{
	//Parent(Object o){} If this is there compile time error for child since default super
	public ParentLoadMe(){
		System.out.println("Parent Constr");
	}
}
class LoadMe extends ParentLoadMe{
	static{System.out.println("static LoadMe");}
	//Default Constr and super added
	LoadMe(int x){
		System.out.println("Constructor Loadme "+x);
	}
}