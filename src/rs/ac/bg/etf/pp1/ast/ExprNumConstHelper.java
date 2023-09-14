// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class ExprNumConstHelper extends ExprNumConstHlp {

    private Integer len;

    public ExprNumConstHelper (Integer len) {
        this.len=len;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len=len;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprNumConstHelper(\n");

        buffer.append(" "+tab+len);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprNumConstHelper]");
        return buffer.toString();
    }
}
