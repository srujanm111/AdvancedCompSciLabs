package Lab17_HuffmanCoding;

public class Test {

    private static final String GENERATED_PATH = "/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab17_HuffmanCoding/GeneratedFiles/";
    private static final String TEXT_PATH = "/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab17_HuffmanCoding/Text Files/";

    public static void main(String[] args) {
        String txtFileName = "happy hip hop";

        HuffmanTree.compress(TEXT_PATH + txtFileName + ".txt");
        HuffmanTree.expand(GENERATED_PATH + txtFileName + ".code", GENERATED_PATH + txtFileName + ".short", GENERATED_PATH + txtFileName + ".new");
    }

}
