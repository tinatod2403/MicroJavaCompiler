// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class ReturnStmt extends Statement {

    private ExprOrNoExpr ExprOrNoExpr;

    public ReturnStmt (ExprOrNoExpr ExprOrNoExpr) {
        this.ExprOrNoExpr=ExprOrNoExpr;
        if(ExprOrNoExpr!=null) ExprOrNoExpr.setParent(this);
    }

    public ExprOrNoExpr getExprOrNoExpr() {
        return ExprOrNoExpr;
    }

    public void setExprOrNoExpr(ExprOrNoExpr ExprOrNoExpr) {
        this.ExprOrNoExpr=ExprOrNoExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprOrNoExpr!=null) ExprOrNoExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprOrNoExpr!=null) ExprOrNoExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprOrNoExpr!=null) ExprOrNoExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStmt(\n");

        if(ExprOrNoExpr!=null)
            buffer.append(ExprOrNoExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStmt]");
        return buffer.toString();
    }
}
