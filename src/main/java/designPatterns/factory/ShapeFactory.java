package designPatterns.factory;

public class ShapeFactory {

    public Shape getShape(String shapeType){
        if (shapeType == null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }else if (shapeType.equalsIgnoreCase("RENTANGLE")){
            return new Rentangle();
        }

        return null;
    }

}
