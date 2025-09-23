public class Main {
    public static void main(String[] args) {

        File f1 = new File("report.docx", 5);
        File f2 = new File("data.csv", 2);
        File f3 = new File("image.png", 8);


        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory pics = new Directory("pictures");


        root.addElement(docs);
        root.addElement(pics);
        docs.addElement(f1);
        docs.addElement(f2);
        pics.addElement(f3);


        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");


        SearchVisitor searchVisitor = new SearchVisitor(".docx");
        root.accept(searchVisitor);
        System.out.println("Found files:");
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println(" - " + f.getName());
        }
    }
}