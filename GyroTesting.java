
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;

public class GyroTesting {


	//Adjust as necessary
	RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B); //PORT C IS BROKE AS FUCK
	
	private EV3GyroSensor gyrosensor = new EV3GyroSensor(SensorPort.S3); //still need to add the port and sensor

	public static void main(String[] args) {

		GyroTesting test = new GyroTesting();
		for(int i = 0; i <10; i++){
			test.move();
		}
	}

	public void move() {
		//1. move foraward 20 mm
		//2. measure error
		//3. repeat
		double rotation = 20/(37*Math.PI)*360;

		rightMotor.rotate((int) rotation);
		leftMotor.rotate((int) rotation);
		
		System.out.println(gyrosensor.getAngleAndRateMode());
		//get the actual distance we moved from the gyro
		//display the error
		gyrosensor.reset();

	}


}
