// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassName ClassName;
    private ExtendsTypeHlp ExtendsTypeHlp;
    private VarDeclList VarDeclList;
    private ConstrMethHlp ConstrMethHlp;

    public ClassDecl (ClassName ClassName, ExtendsTypeHlp ExtendsTypeHlp, VarDeclList VarDeclList, ConstrMethHlp ConstrMethHlp) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.ExtendsTypeHlp=ExtendsTypeHlp;
        if(ExtendsTypeHlp!=null) ExtendsTypeHlp.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ConstrMethHlp=ConstrMethHlp;
        if(ConstrMethHlp!=null) ConstrMethHlp.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
    }

    public ExtendsTypeHlp getExtendsTypeHlp() {
        return ExtendsTypeHlp;
    }

    public void setExtendsTypeHlp(ExtendsTypeHlp ExtendsTypeHlp) {
        this.ExtendsTypeHlp=ExtendsTypeHlp;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ConstrMethHlp getConstrMethHlp() {
        return ConstrMethHlp;
    }

    public void setConstrMethHlp(ConstrMethHlp ConstrMethHlp) {
        this.ConstrMethHlp=ConstrMethHlp;
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
        if(ClassName!=null) ClassName.accept(visitor);
        if(ExtendsTypeHlp!=null) ExtendsTypeHlp.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ConstrMethHlp!=null) ConstrMethHlp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(ExtendsTypeHlp!=null) ExtendsTypeHlp.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ConstrMethHlp!=null) ConstrMethHlp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(ExtendsTypeHlp!=null) ExtendsTypeHlp.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ConstrMethHlp!=null) ConstrMethHlp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExtendsTypeHlp!=null)
            buffer.append(ExtendsTypeHlp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstrMethHlp!=null)
            buffer.append(ConstrMethHlp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
