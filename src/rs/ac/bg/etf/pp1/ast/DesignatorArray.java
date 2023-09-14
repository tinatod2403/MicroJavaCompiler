// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArray extends Designator {

    private DesignatorHlp DesignatorHlp;
    private Expr Expr;

    public DesignatorArray (DesignatorHlp DesignatorHlp, Expr Expr) {
        this.DesignatorHlp=DesignatorHlp;
        if(DesignatorHlp!=null) DesignatorHlp.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorHlp getDesignatorHlp() {
        return DesignatorHlp;
    }

    public void setDesignatorHlp(DesignatorHlp DesignatorHlp) {
        this.DesignatorHlp=DesignatorHlp;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHlp!=null) DesignatorHlp.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHlp!=null) DesignatorHlp.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHlp!=null) DesignatorHlp.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArray(\n");

        if(DesignatorHlp!=null)
            buffer.append(DesignatorHlp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorArray]");
        return buffer.toString();
    }
}
