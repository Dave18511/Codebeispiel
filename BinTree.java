
public class BinTree {
    private Object value;
    private BinTree leftson;
    private BinTree rightson;

    public BinTree(Object v, BinTree l, BinTree r) {
        this.value = v;
        this.leftson = l;
        this.rightson = r;
    }

    public Object val() {
        return this.value;
    }

    public BinTree lson() {
        return this.leftson;
    }

    public BinTree rson() {
        return this.rightson;
    }

    public void setVal(Object v) {
        this.value = v;
    }

    public void setLson(BinTree l) {
        this.leftson = l;
    }

    public void setRson(BinTree r) {
        this.rightson = r;
    }

    public boolean isleaf() {
        return (this.leftson == null) && (this.rightson == null);
    }

    public BinTree leftmost() {
        BinTree p = this;
        BinTree q;
        while((q = p.lson()) != null) {
            p = q;
        }

        return p;
    }

    public BinTree rightmost() {
        BinTree p = this;
        BinTree q;
        while((q = p.rson()) != null) {
            p = q;
        }

        return p;
    }
}
