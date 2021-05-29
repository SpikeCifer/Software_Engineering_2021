package output;

public class OutputSystemFactory {
	public IOutputSystem createOutputSystem(String filename, String encryption) {
		try {
			IOutputSystem outputSystem = createBaseWriter(filename, filename.split("\\.")[1]);
			if (!encryption.equals("None"))
				return addEncryptionLayer(outputSystem, encryption);
			return  outputSystem;
		} catch (Exception e) {
			System.out.println("Could not create Output System!");
			e.printStackTrace();
			return null;
		}
	}
	
	private IOutputSystem createBaseWriter(String filename, String filetype) throws Exception {
		FileWriter output = new FileWriter(filename);
		switch (filetype) {
			case "docx":
				output.setWriteStrategy(new WordWriteStrategy());
				break;
			case "xlsx":
				output.setWriteStrategy(new ExcelWriteStrategy());
				break;
			default:
				throw new Exception("File Type not Supported!");
		}
		return output;
	}

	private IOutputSystem addEncryptionLayer(IOutputSystem outputSystem, String encryption) throws Exception {
		EncodeDecorator encoder = new EncodeDecorator(outputSystem);
		switch (encryption) {
			case "AtBash":
				encoder.setEncodeStrategy(new AtBashEncodeStrategy());
				break;
			case "Rot13":
				encoder.setEncodeStrategy(new Rot13EncodeStrategy());
				break;
			default:
				throw new Exception("Encryption not Supported!");
		}
		return encoder;
	}
}
