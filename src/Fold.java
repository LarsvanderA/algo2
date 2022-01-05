public class Fold implements Comparable{

    private int currentFolds;
    private String remaining;
    private int foldSize;

    public Fold(int currentFolds, String remaining, int foldSize) {
        this.currentFolds = currentFolds;
        this.remaining = remaining;
        this.foldSize = foldSize;
    }

    public int getCurrentFolds() {
        return currentFolds;
    }

    public void setCurrentFolds(int currentFolds) {
        this.currentFolds = currentFolds;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public int getFoldSize() {
        return foldSize;
    }

    public void setFoldSize(int foldSize) {
        this.foldSize = foldSize;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fold) {
            Fold object = (Fold) obj;
            return (object.getCurrentFolds() == this.getCurrentFolds()) && (object.getFoldSize() == this.getFoldSize()) && (object.getRemaining() == this.getRemaining());
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Fold) {
            Fold o1 = (Fold) o;
            if (o1.getCurrentFolds() < this.getCurrentFolds()) {
                return 1;
            }
            else if ((o1.getCurrentFolds() == this.getCurrentFolds()) && (o1.getFoldSize() > this.getFoldSize())){
                return 1;
            }
            else if (o1 == this) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Fold{" +
                "currentFolds=" + currentFolds +
                ", remaining='" + remaining + '\'' +
                ", foldSize=" + foldSize +
                '}';
    }
}
