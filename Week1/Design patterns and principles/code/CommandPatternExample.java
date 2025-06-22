// Command Interface

interface Command {

    void execute();

}



// Receiver Class

class Light {

    void turnOn() {

        System.out.println("Light is ON");

    }



    void turnOFF() {

        System.out.println("Light is OFF");

    }

}



// Concrete Commands

class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {

        this.light = light;

    }

    public void execute() {

        light.turnOn();

    }

}



class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {

        this.light = light;

    }

    public void execute() {

        light.turnOFF();

    }

}



// Invoker Class

class RemoteControl {

    private Command command;

    public void setCommand(Command command) {

        this.command = command;

    }

    public void pressButton() {

        if (command != null)

            command.execute();

        else

            System.out.println("No command set.");

    }

}



// Test Class

public class CommandPatternExample {

    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand = new LightOnCommand(light);

        Command offCommand = new LightOffCommand(light);



        RemoteControl remote = new RemoteControl();



        remote.setCommand(onCommand);

        remote.pressButton();



        remote.setCommand(offCommand);

        remote.pressButton();

    }

}
