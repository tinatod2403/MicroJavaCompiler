// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Designator Designator;
    private DesignatorStatementItem DesignatorStatementItem;

    public DesignatorStatement (Designator Designator, DesignatorStatementItem DesignatorStatementItem) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorStatementItem=DesignatorStatementItem;
        if(DesignatorStatementItem!=null) DesignatorStatementItem.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorStatementItem getDesignatorStatementItem() {
        return DesignatorStatementItem;
    }

    public void setDesignatorStatementItem(DesignatorStatementItem DesignatorStatementItem) {
        this.DesignatorStatementItem=DesignatorStatementItem;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorStatementItem!=null) DesignatorStatementItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorStatementItem!=null) DesignatorStatementItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorStatementItem!=null) DesignatorStatementItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatement(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementItem!=null)
            buffer.append(DesignatorStatementItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement]");
        return buffer.toString();
    }
}
