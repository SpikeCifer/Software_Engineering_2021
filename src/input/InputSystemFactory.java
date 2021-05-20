package input;

public class InputSystemFactory {

	public IInputSystem createInputSystem(String filename, String encryption){
		try {
			IInputSystem inputSystem = createBaseReader(filename, filename.split("\\.")[1]);
			if (!encryption.equals("None"))
				return addEncryptionLayer(inputSystem, encryption);
			return  inputSystem;
		} catch (Exception e) {
			System.out.println("Could not create Input System");
			e.printStackTrace();
			return null;
		}
	}
	
	private IInputSystem createBaseReader(String filename, String filetype) throws Exception {
		FileReader input = new FileReader(filename);
		switch (filetype) {
			case "docx":
				input.setReadStrategy(new WordReadStrategy());
				break;
			case "xlsx":
				input.setReadStrategy(new ExcelReadStrategy());
				break;
			default:
				throw new Exception("File Type not Supported!");
		}
		return input;
	}
	
	private IInputSystem addEncryptionLayer(IInputSystem input, String encryption) throws Exception {
		DecodeDecorator decoder = new DecodeDecorator(input);
		switch (encryption) {
			case "AtBash":
				decoder.setDecodeStrategy(new AtBashDecodeStrategy());
				break;
			case "Rot13":
				decoder.setDecodeStrategy(new Rot13DecodeStrategy());
				break;
			default:
				throw new Exception("Encryption not Supported!");
		}
		return decoder;
	}
}
