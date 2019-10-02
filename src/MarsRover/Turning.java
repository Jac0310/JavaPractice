package MarsRover;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Turning {


    static final double conversionFactor = 57.2957795;

    public static void main(String[] args)
    {
        //level 1
        Rover rover = new Rover();
        rover.setSteering(1.00, 30.00);
        System.out.println("OOP: " + round(rover.turningRadius, 2));
        System.out.println(round(turningRad(1.00, 30.00), 2));

        rover.setSteering(1.00, 13.76);
        System.out.println("OOP: " + round(rover.turningRadius, 2));
        System.out.println(round(turningRad(1.00, 13.76), 2));

        rover.setSteering(1.00, 2.34);
        System.out.println("OOP: " + round(rover.turningRadius, 2));
        System.out.println(round(turningRad(1.00, 2.34), 2));

        rover.setSteering(1.00, 90.00);
        System.out.println("OOP: " + round(rover.turningRadius, 2));
        System.out.println(round(turningRad(1.00, 90.00), 2));

        rover.setSteering(2.45, 90.00);
        System.out.println("OOP: " + round(rover.turningRadius, 2));
        System.out.println(round(turningRad(2.45, 90.00), 2));



        //level 2
        rover.setSteering(1, 30);
        rover.drive(1);
        double[] result = drive(1, 1, 30);
        output(result);
        output(rover);
        rover.resetPosition();

        rover.setSteering(2.13, 23.00);
        rover.drive(4.30);
        result = drive(2.13, 4.30, 23.00);
        output(result);
        output(rover);
        rover.resetPosition();

        rover.setSteering(1.75, -23.00);
        rover.drive(3.14);
        result = drive(1.75, 3.14, -23.00);
        output(result);
        output(rover);
        rover.resetPosition();

        rover.setSteering(2.70, -34.00);
        rover.drive(45.00);
        result = drive(2.70, 45.00, -34.00);
        output(result);
        output(rover);
        rover.resetPosition();

        rover.setSteering(4.20, 20.00);
        rover.drive(-5.30);
        result = drive(4.20, -5.30, 20.00);
        output(result);
        output(rover);
        rover.resetPosition();

        rover.setSteering(9.53, 0);
        rover.drive(8.12);
        result = drive(9.53, 8.12, 0);
        output(result);
        output(rover);
        rover.resetPosition();
    }


    private static void output(double[] result)
    {
        Arrays.stream(result).forEach(n -> System.out.print(round(n, 2) + " "));
        System.out.println();
    }

    private static void output(Rover rover)
    {
        System.out.println(round(rover.x, 2) + " " + round(rover.y, 2) + " " + round(rover.direction, 2));
    }


    private static double turningRad(double wheelbase, double steeringAngle)
    {
        return Math.abs(wheelbase / Math.sin(steeringAngle / conversionFactor));
    }

    private static double[] drive(double wheelbase, double distance, double steeringAngle)
    {
        double deltaX;
        double deltaY;
        double newDirection;
        if (steeringAngle != 0)
        {
            double radius = turningRad(wheelbase, steeringAngle);

            double arcAngle = arcAngle(distance, radius);

            if (arcAngle > 360) { arcAngle = arcAngle % 360; }
            double halfArc = arcAngle / 2;

            double deltaXY = 2 * radius * Math.sin(Math.toRadians(halfArc));

            deltaY = radius * Math.sin(Math.toRadians(arcAngle));

            double deltaXSquared = deltaXY*deltaXY - deltaY*deltaY;
            deltaX = Math.sqrt(deltaXSquared);

            if (steeringAngle < 0) deltaX = - deltaX;

            newDirection = Math.toDegrees(Math.asin(deltaX/deltaXY)) * 2;

            if (newDirection < 0) newDirection = 360 + newDirection;
        }
        else
        {
            deltaX = 0;
            deltaY = distance;
            newDirection = steeringAngle;
        }

        double[] result = { deltaX, deltaY, newDirection};
        return result;



    }

    private static double arcAngle(double arcLength, double radius)
    {
        return Math.toDegrees(arcLength / radius);
    }


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

class Rover
{
    double x = 0;
    double y = 0;
    double steeringAngle;
    double wheelbase;
    double turningRadius;
    double direction = 0;

    private void setRad()
    {
        turningRadius = Math.abs(wheelbase / Math.sin(Math.toRadians(steeringAngle)));
    }

    public void resetPosition()
    {
        x = 0;
        y = 0;
        direction = 0;
    }

    public void setSteering(double wheelbase, double steeringAngle)
    {
        this.wheelbase = wheelbase;
        this.steeringAngle = steeringAngle;
        setRad();
    }

    public void drive(double distance)
    {

        double deltaX;
        double deltaY;
        double newDirection;
        if (steeringAngle != 0)
        {
            double arcAngle = arcAngle(distance, turningRadius);

            if (arcAngle > 360) { arcAngle = arcAngle % 360; }
            double halfArc = arcAngle / 2;

            double deltaXY = 2 * turningRadius * Math.sin(Math.toRadians(halfArc));

            deltaY = turningRadius * Math.sin(Math.toRadians(arcAngle));

            double deltaXSquared = deltaXY*deltaXY - deltaY*deltaY;
            deltaX = Math.sqrt(deltaXSquared);

            if (steeringAngle < 0) deltaX = - deltaX;

            newDirection = Math.toDegrees(Math.asin(deltaX/deltaXY)) * 2;

            if (newDirection < 0) newDirection = 360 + newDirection;
        }
        else
        {
            deltaX = 0;
            deltaY = distance;
            newDirection = steeringAngle;
        }
        x += deltaX;
        y += deltaY;
        direction = newDirection;
    }

    private double arcAngle(double arcLength, double radius)
    {
        return Math.toDegrees(arcLength / radius);
    }
}
