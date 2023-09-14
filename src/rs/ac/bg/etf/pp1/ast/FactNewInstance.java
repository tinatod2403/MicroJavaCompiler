// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class FactNewInstance extends Factor {

    private Type Type;
    private ExprActParsHlp ExprActParsHlp;

    public FactNewInstance (Type Type, ExprActParsHlp ExprActParsHlp) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprActParsHlp=ExprActParsHlp;
        if(ExprActParsHlp!=null) ExprActParsHlp.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprActParsHlp getExprActParsHlp() {
        return ExprActParsHlp;
    }

    public void setExprActParsHlp(ExprActParsHlp ExprActParsHlp) {
        this.ExprActParsHlp=ExprActParsHlp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprActParsHlp!=null) ExprActParsHlp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprActParsHlp!=null) ExprActParsHlp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprActParsHlp!=null) ExprActParsHlp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactNewInstance(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprActParsHlp!=null)
            buffer.append(ExprActParsHlp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactNewInstance]");
        return buffer.toString();
    }
}
