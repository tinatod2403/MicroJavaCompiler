// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:36


package rs.ac.bg.etf.pp1.ast;

public class GlobDeclConst extends GlobDeclList {

    private GlobDeclList GlobDeclList;
    private ConstDecl ConstDecl;

    public GlobDeclConst (GlobDeclList GlobDeclList, ConstDecl ConstDecl) {
        this.GlobDeclList=GlobDeclList;
        if(GlobDeclList!=null) GlobDeclList.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public GlobDeclList getGlobDeclList() {
        return GlobDeclList;
    }

    public void setGlobDeclList(GlobDeclList GlobDeclList) {
        this.GlobDeclList=GlobDeclList;
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobDeclList!=null) GlobDeclList.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobDeclList!=null) GlobDeclList.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobDeclList!=null) GlobDeclList.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobDeclConst(\n");

        if(GlobDeclList!=null)
            buffer.append(GlobDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobDeclConst]");
        return buffer.toString();
    }
}
