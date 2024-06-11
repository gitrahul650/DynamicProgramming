package designPattern.Prototype;

class Circle implements Shape {

  private int radius;

  public Circle() {}

  public Circle(Circle target) {
    this.radius = target.radius;
  }

  @Override
  public Shape clone() {
    return new Circle(this);
  }

  // Getters and setters


  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }
}