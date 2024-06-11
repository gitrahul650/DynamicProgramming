package designPattern.factory;

public class FactoryPatternDemo {

  public static void main(String[] args) {
    Shape shape1 = ShapeFactory.getShape("circle");
    shape1.draw();
  
    Shape shape2 = ShapeFactory.getShape("square");
    shape2.draw();
  }
}