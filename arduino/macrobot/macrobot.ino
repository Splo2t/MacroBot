#include <Keyboard.h>
#include <Mouse.h>

const int xValue = A0;
const int yValue = A1;

const int btnMouse = 8;
const int btn0 = 2;
const int btn1 = 3;
const int btn2 = 4;
const int btn3 = 5;
const int btn4 = 6;
const int btn5 = 7;

int pre_btnMouseVal;

int pre_btn0Val;
int pre_btn1Val;
int pre_btn2Val;
int pre_btn3Val;
int pre_btn4Val;
int pre_btn5Val;

int btn[6][3];
int btnPressValue[6][3];
void setup() {
  Serial.begin(115200);
  pinMode(btnMouse,INPUT);
  digitalWrite(btnMouse, HIGH);
    
  pinMode(btn0,INPUT);
  pinMode(btn1,INPUT);
  pinMode(btn2,INPUT);
  pinMode(btn3,INPUT);
  pinMode(btn4,INPUT);
  pinMode(btn5,INPUT);

  Mouse.begin();
  // put your setup code here, to run once:

}
void keyboardBtn0(){
    Keyboard.begin();
    Keyboard.press(btnPressValue[0][0]);
    Keyboard.press(btnPressValue[0][1]);
    Keyboard.press(btnPressValue[0][2]);
    delayMicroseconds(1);
    Keyboard.releaseAll();
    Keyboard.end();
}

void keyboardBtn1(){
    Keyboard.begin();
    Keyboard.press(btnPressValue[1][0]);
    Keyboard.press(btnPressValue[1][1]);
    Keyboard.press(btnPressValue[1][2]);
    delayMicroseconds(1);
    Keyboard.releaseAll();
    Keyboard.end();
}

void keyboardBtn2(){
    Keyboard.begin();
    Keyboard.press(btnPressValue[2][0]);
    Keyboard.press(btnPressValue[2][1]);
    Keyboard.press(btnPressValue[2][2]);
    delayMicroseconds(1);
    Keyboard.releaseAll();
    Keyboard.end();
}

void keyboardBtn3(){
    Keyboard.begin();
    Keyboard.press(btnPressValue[3][0]);
    Keyboard.press(btnPressValue[3][1]);
    Keyboard.press(btnPressValue[3][2]);
    delayMicroseconds(1);
    Keyboard.releaseAll();
    Keyboard.end();
}

void keyboardBtn4(){
    Keyboard.begin();
    Keyboard.press(btnPressValue[4][0]);
    Keyboard.press(btnPressValue[4][1]);
    Keyboard.press(btnPressValue[4][2]);
    delayMicroseconds(1);
    Keyboard.releaseAll();
    Keyboard.end();
}

void keyboardBtn5(){
    Keyboard.begin();
    Keyboard.press(btnPressValue[5][0]);
    Keyboard.press(btnPressValue[5][1]);
    Keyboard.press(btnPressValue[5][2]);
    delayMicroseconds(1);
    Keyboard.releaseAll();
    Keyboard.end();
}
void setButtonValue(){
   for(int i = 0; i < 6; i++){
        for(int j = 0; j < 3; j++){
         switch(btn[i][j]){
          case 'c':
            btnPressValue[i][j] = KEY_LEFT_CTRL;
            break;
          case 'a':
            btnPressValue[i][j] = KEY_LEFT_ALT;
            break;
          case 's':
            btnPressValue[i][j] = KEY_LEFT_SHIFT;
            break;
          case 'd':
            btnPressValue[i][j] = KEY_DELETE;
            break;
          case 't':
            btnPressValue[i][j] = KEY_TAB;
            break;
          case 'k':
            btnPressValue[i][j] = KEY_ESC;
            break;
          case 'r':
            btnPressValue[i][j] = KEY_RETURN;
            break;
          case '!':
            btnPressValue[i][j] = 0;
            break;
          case 'p' :
            btnPressValue[i][j] = 32; //space
            break;
          case 'h':
            btnPressValue[i][j] = KEY_HOME;
            break;
          case 'u':
            btnPressValue[i][j] = KEY_PAGE_UP;
            break;
          case 'n':
            btnPressValue[i][j] = KEY_PAGE_DOWN;
            break;
          case 'e' :
            btnPressValue[i][j] = KEY_END;
            break;
          case 'w' :
            btnPressValue[i][j] = KEY_LEFT_GUI;
            break;
          case 'b' :
            btnPressValue[i][j] = KEY_BACKSPACE;
            break;
          case 34 :
            btnPressValue[i][j] = KEY_F1;
            break;
          case 35 :
            btnPressValue[i][j] = KEY_F2;
            break;
          case 36 :
            btnPressValue[i][j] = KEY_F3;
            break;
          case 37 :
            btnPressValue[i][j] = KEY_F4;
            break;
          case 38 :
            btnPressValue[i][j] = KEY_F5;
            break;
          case 39 :
            btnPressValue[i][j] = KEY_F6;
            break;
          case 40 :
            btnPressValue[i][j] = KEY_F7;
            break;
          case 41 :
            btnPressValue[i][j] = KEY_F8;
            break;
          case 42 :
            btnPressValue[i][j] = KEY_F9;
            break;
          case 43 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 44 :
            btnPressValue[i][j] = KEY_F10;
            break;
            /*
          case 45 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 46 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 47 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 59 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 91 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 92 :
            btnPressValue[i][j] = KEY_F10;
            break;
          case 93 :
            btnPressValue[i][j] = KEY_F11;
            break;
            */
          case 94 :
            btnPressValue[i][j] = KEY_F11;
            break;
          case 95 :
            btnPressValue[i][j] = KEY_F12;
            break;
            /*
          case 96 :
            btnPressValue[i][j] = KEY_F12;
            break;
            */
          default:
            btnPressValue[i][j] = btn[j][i];
          }
        }
      }  
}
void mouseControl(){
  int xVal = analogRead(xValue);
  int xMappingVal = map(xVal,0,1023,-30,30);
  xMappingVal = constrain(xMappingVal,-10,10);
  
  int yVal = analogRead(yValue);
  int yMappingVal = map(yVal,0,1023,-30,30);
  yMappingVal = constrain(yMappingVal,-10,10);

  Mouse.move(-xMappingVal,yMappingVal);
  delay(25);
}

void loop() {
  if(Serial.available()){
    if(Serial.read() == '#'){
      Serial.write('#');
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 3; j++){
          btn[i][j] = Serial.read();
          
        }
       
      }  
      
      if(Serial.read() == *){
        Serial.write(1);
        setButtonValue();
      } else {
        Serial.write(-1);
      }
    }
  }
  
  int btnMouseVal = digitalRead(btnMouse);
  int btn0Val = digitalRead(btn0);
  int btn1Val = digitalRead(btn1);
  int btn2Val = digitalRead(btn2);
  int btn3Val = digitalRead(btn3);
  int btn4Val = digitalRead(btn4);
  int btn5Val = digitalRead(btn5);

  if(pre_btnMouseVal == 0){
    Mouse.press();
    if(btnMouseVal == 1){
    Mouse.release();
    }
  }
  
  if(pre_btn0Val == 0){
    if(btn0Val == 1){
    keyboardBtn0();
    }
  }
  
  if(pre_btn1Val == 0){
    if(btn1Val == 1){
    keyboardBtn0();
    }
  }
    
  if(pre_btn2Val == 0){
    if(btn2Val == 1){
    keyboardBtn0();
    }
  }
    
  if(pre_btn3Val == 0){
    if(btn3Val == 1){
    keyboardBtn0();
    }
  }
    
  if(pre_btn4Val == 0){
    if(btn4Val == 1){
    keyboardBtn0();
    }
  }
    
  if(pre_btn5Val == 0){
    if(btn5Val == 1){
    keyboardBtn0();
    }
  }
pre_btnMouseVal = btnMouseVal;
pre_btn0Val = btn0Val;
pre_btn1Val = btn1Val;
pre_btn2Val = btn2Val;
pre_btn3Val = btn3Val;
pre_btn4Val = btn4Val;
pre_btn5Val = btn5Val;
//Serial.println(btn0val);
//mouseControl();
}
