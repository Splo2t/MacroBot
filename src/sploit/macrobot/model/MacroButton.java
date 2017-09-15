package sploit.macrobot.model;

public class MacroButton {

	String firstKey = "";
	String secondKey = "";
	String lastKey = "";
	
	public void setFirstKey(String firstKey){
		this.firstKey = firstKey;
	}
	
	public void setSecondKey(String secondKey){
		this.secondKey = secondKey;
	}
	public void setLastKey(String lastKey){
		this.lastKey = lastKey;
	}
	
	public String getFirstKey(){
		return this.firstKey;
	}
	
	public String getSecondKey(){
		return this.secondKey;
	}
	public String getLastKey(){
		return this.lastKey;
	}
	public MacroButton(){
		
	}
	
	public void setKey(String firstkey, String secondKey, String lastKey){
		this.setFirstKey(firstkey);
		this.setSecondKey(secondKey);
		this.setLastKey(lastKey);
	}
	
	public String getKey(){
		String returnString = getFirstKey() + "/" + getSecondKey() + "/"+ getLastKey();
		
			
		return returnString;
	}
}
