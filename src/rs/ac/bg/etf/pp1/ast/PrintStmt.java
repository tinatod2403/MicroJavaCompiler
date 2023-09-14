// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class PrintStmt extends Statement {

    private Expr Expr;
    private ExprNumConstHlp ExprNumConstHlp;

    public PrintStmt (Expr Expr, ExprNumConstHlp ExprNumConstHlp) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.ExprNumConstHlp=ExprNumConstHlp;
        if(ExprNumConstHlp!=null) ExprNumConstHlp.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public ExprNumConstHlp getExprNumConstHlp() {
        return ExprNumConstHlp;
    }

    public void setExprNumConstHlp(ExprNumConstHlp ExprNumConstHlp) {
        this.ExprNumConstHlp=ExprNumConstHlp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(ExprNumConstHlp!=null) ExprNumConstHlp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(ExprNumConstHlp!=null) ExprNumConstHlp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(ExprNumConstHlp!=null) ExprNumConstHlp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStmt(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprNumConstHlp!=null)
            buffer.append(ExprNumConstHlp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStmt]");
        return buffer.toString();
    }
}
