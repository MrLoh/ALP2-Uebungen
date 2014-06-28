public class ShapesWorld_Main {
	public static void main(String[] args){
	// args contains the name of the shape classes, we want to use in the ShapesWorld-object.
		if( args.length==0 ){
			System.err.println("Bitte Shape-Klassennamen als Argumente eingeben");
		}
		new ShapeFrame(args);
	}
}
