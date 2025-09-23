public class SizeCalculatorVisitor implements FileSystemVisitor{

    private int totalSize = 0;

    @Override
    public void visit(File file) {

        totalSize += file.getSize();
    }
    public int getTotalSize() {
        return totalSize;
    }
    @Override
    public void visit(Directory directory) {
        visit(directory);
    }


}
