package MarsRover;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Turning {

    public static void main(String[] args)
    {
        //level 1
        Rover rover = new Rover();
        rover.setSteering(1.00, 30.00);
        System.out.println("OOP: " + round(rover.turningRadius, 2));

        rover.setSteering(1.00, 13.76);
        System.out.println("OOP: " + round(rover.turningRadius, 2));

        rover.setSteering(1.00, 2.34);
        System.out.println("OOP: " + round(rover.turningRadius, 2));

        rover.setSteering(1.00, 90.00);
        System.out.println("OOP: " + round(rover.turningRadius, 2));

        rover.setSteering(2.45, 90.00);
        System.out.println("OOP: " + round(rover.turningRadius, 2));



        //level 2
        rover.setSteering(1, 30);
        rover.drive(1);
        output(rover);
        rover.resetPosition();

        rover.setSteering(2.13, 23.00);
        rover.drive(4.30);
        output(rover);
        rover.resetPosition();

        rover.setSteering(1.75, -23.00);
        rover.drive(3.14);
        output(rover);
        rover.resetPosition();

        rover.setSteering(2.70, -34.00);
        rover.drive(45.00);
        output(rover);
        rover.resetPosition();

        rover.setSteering(4.20, 20.00);
        rover.drive(-5.30);
        output(rover);
        rover.resetPosition();

        rover.setSteering(9.53, 0);
        rover.drive(8.12);
        output(rover);
        rover.resetPosition();


        //level 3

        ArrayList<Instruction> instructions = new ArrayList<>();
        Instruction instruction = new Instruction(9.86, 10.0);
        instructions.add(instruction);
        instructions.add(instruction);
        instructions.add(instruction);
        instructions.add(instruction);

        rover.drive(1.09, instructions);
        output(rover);

        rover.resetPosition();
        instructions.clear();

        instruction = new Instruction(5.00, 23.00);
        instructions.add(instruction);
        rover.drive(1.00, instructions);
        output(rover);





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


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

class Instruction
{
    double distance;
    double steeringAngle;

    public Instruction (double distance, double steeringAngle)
    {
        this.distance = distance;
        this.steeringAngle = steeringAngle;
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
    double unmodular = 0;

    private void setRad()
    {
        turningRadius = Math.abs(wheelbase / Math.sin(Math.toRadians(steeringAngle)));
    }

    public void resetPosition()
    {
        x = 0;
        y = 0;
        direction = 0;
        unmodular = 0;
        steeringAngle = 0;
        turningRadius = 0;
    }

    public void setSteering(double wheelbase, double steeringAngle)
    {
        this.wheelbase = wheelbase;
        this.steeringAngle = steeringAngle;
        setRad();
    }

    public void drive(double wheelbase, ArrayList<Instruction> instructions)
    {
        for (Instruction instruction : instructions)
        {
            setSteering(wheelbase, instruction.steeringAngle);
            drive(instruction.distance);
            output();
        }
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
        setDirection(newDirection);
    }

    private void setDirection(double newDirection)
    {
        direction += newDirection;
        if (direction > 360) { direction = direction % 360; }
    }

    private void output()
    {
        System.out.println(" x ="+ x + " y =  " + y + "  newDirection = " + direction);
    }

    private double arcAngle(double arcLength, double radius)
    {
        return Math.toDegrees(arcLength / radius);
    }
}
