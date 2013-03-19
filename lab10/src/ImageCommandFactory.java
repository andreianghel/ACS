abstract class ImageCommand{
	public abstract String execute();
}

class ResizeCommand extends ImageCommand{
	public String execute()	{
		return "RC";	
	}
}

class BlurFilterCommand extends ImageCommand{
	public String execute()	{
		return "BFC";	
	}
}

class CropCommand extends ImageCommand{
	public String execute()	{
		return "CC";	
	}
}

public class ImageCommandFactory{
	enum CommandType{
		ResizeCommand, BlurFilterCommand, CropCommand 
	}
	
	public static ImageCommand createCommand(CommandType commandType){
		switch(commandType)	{
			case ResizeCommand: return new ResizeCommand();
			case BlurFilterCommand: return new BlurFilterCommand();
			case CropCommand: return new CropCommand();
		}
		throw new IllegalArgumentException("The command type " + commandType + " is not recognized.");
	}
	
	public static void main(String[] args){
		for(ImageCommandFactory.CommandType i : ImageCommandFactory.CommandType.values()){
			System.out.println("Command: "+i+", execute() shows: "+createCommand(i).execute());
		}
	}
}