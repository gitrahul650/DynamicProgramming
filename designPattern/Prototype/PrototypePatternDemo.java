package designPattern.Prototype;





public class PrototypePatternDemo {

  public static void main(String[] args) {
    Circle circle = new Circle();
    circle.setRadius(10);

    Circle anotherCircle = (Circle) circle.clone();
    Circle anotherCircle1 = (Circle) circle.clone ();
    System.out.println("anotherCircle ->"+anotherCircle.getRadius());
    System.out.println("anotherCircle1 ->"+anotherCircle1.getRadius());


    Rectangle rectangle = new Rectangle();
    rectangle.setWidth(10);
    rectangle.setHeight(20);

    Rectangle anotherRectangle = (Rectangle) rectangle.clone();
  }

}