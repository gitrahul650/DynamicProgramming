package designPattern.factory;

public class ShapeFactory {

  public static Shape getShape(String type) {
    if(type == null) {
      return null;
    }		
    if(type.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
  
    } else if(type.equalsIgnoreCase("SQUARE")) {
      return new Square();
    }
  
    return null;
  }
}