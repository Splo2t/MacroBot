package sploit.macrobot;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Serial {

	String port;
	SerialPort macroBotPort;
	public Serial(String port) {
		this.port = port;
		SerialPort macroBotPort = new SerialPort(port);

		// TODO Auto-generated constructor stub
	}
	
	int sendByte(String sendKey) throws SerialPortException{
		macroBotPort.openPort();
		macroBotPort.setParams(SerialPort.BAUDRATE_57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		macroBotPort.writeBytes(sendKey.getBytes());
		macroBotPort.closePort();
		return readByte();
	}
	
	public int readByte() throws SerialPortException{
		macroBotPort.openPort();
		macroBotPort.setParams(SerialPort.BAUDRATE_57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		byte[] returnByte = macroBotPort.readBytes(1);
		macroBotPort.closePort();	
		return returnByte[0];
	}
	
	

}
