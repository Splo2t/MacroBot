package sploit.macrobot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import sploit.macrobot.model.MacroButton;

public class BinaryFile{
	FileInputStream binaryFileIn;
	
	public BinaryFile(FileInputStream binaryFileIn){
		this.binaryFileIn = binaryFileIn;
	}

	public void setButton(MacroButton macroButton) throws IOException {
		if(binaryFileIn.read() == '#'){
			for(int i = 0; i < 6; i++){
				String keyValue[] = new String[3];
				for(int j = 0; j < 3; j++){
					int readByte = binaryFileIn.read();
					switch(readByte){
			          case 'c':
			            keyValue[j] = "KEY_LEFT_CTRL";
			            break;
			          case 'a':
			            keyValue[j]= "KEY_LEFT_ALT";
			            break;
			          case 's':
			            keyValue[j] = "KEY_LEFT_SHIFT";
			            break;
			          case 'd':
			            keyValue[j] = "KEY_DELETE";
			            break;
			          case 't':
			            keyValue[j] = "KEY_TAB";
			            break;
			          case 'k':
			            keyValue[j] = "KEY_ESC";
			            break;
			          case 'r':
			            keyValue[j] = "KEY_RETURN";
			            break;
			          case '!':
			            keyValue[j] = "0";
			            break;
			          case 'p' :
			            keyValue[j] = "32"; //space
			            break;
			          case 'h':
			            keyValue[j] = "KEY_HOME";
			            break;
			          case 'u':
			            keyValue[j]  = "KEY_PAGE_UP";
			            break;
			          case 'n':
			            keyValue[j]  = "KEY_PAGE_DOWN";
			            break;
			          case 'e' :
			            keyValue[j]  = "KEY_END";
			            break;
			          case 'w' :
			            keyValue[j]  = "KEY_LEFT_GUI";
			            break;
			          case 'b' :
			            keyValue[j]  = "KEY_BACKSPACE";
			            break;
			          case 34 :
			            keyValue[j]  = "KEY_F1";
			            break;
			          case 35 :
			            keyValue[j]  = "KEY_F2";
			            break;
			          case 36 :
			            keyValue[j]  = "KEY_F3";
			            break;
			          case 37 :
			            keyValue[j]  = "KEY_F4";
			            break;
			          case 38 :
			            keyValue[j]  = "KEY_F5";
			            break;
			          case 39 :
			            keyValue[j]  = "KEY_F6";
			            break;
			          case 40 :
			            keyValue[j]  = "KEY_F7";
			            break;
			          case 41 :
			            keyValue[j]  = "KEY_F8";
			            break;
			          case 42 :
			            keyValue[j]  = "KEY_F9";
			            break;
			          case 43 :
			            keyValue[j]  = "KEY_F10";
			            break;
			     /*
			          case 45 :
			            btnPressValue  = KEY_F10;
			            break;
			          case 46 :
			            btnPressValue  = KEY_F10;
			            break;
			          case 47 :
			            btnPressValue  = KEY_F10;
			            break;
			          case 59 :
			            btnPressValue  = KEY_F10;
			            break;
			          case 91 :
			            btnPressValue  = KEY_F10;
			            break;
			          case 92 :
			            btnPressValue  = KEY_F10;
			            break;
			          case 93 :
			            btnPressValue  = KEY_F11;
			            break;
			            */
			          case 94 :
			            keyValue[j]  = "KEY_F11";
			            break;
			          case 95 :
			            keyValue[j]  = "KEY_F12";
			            break;
			            /*
			          case 96 :
			            btnPressValue  = KEY_F12;
			            break;
			            */
			          default:
			            keyValue[j] = String.valueOf(keyValue[j]);
			          }
					
				}
				macroButton.setKey(keyValue[0], keyValue[1], keyValue[2]);
			}
		}
	}
	

	

	
	
}
