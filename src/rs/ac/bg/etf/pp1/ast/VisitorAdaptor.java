// generated with ast extension for cup
// version 0.8
// 24/7/2023 20:47:37


package rs.ac.bg.etf.pp1.ast;

public abstract class VisitorAdaptor implements Visitor { 

    public void visit(Unmatched Unmatched) { }
    public void visit(Mulop Mulop) { }
    public void visit(Matched Matched) { }
    public void visit(Relop Relop) { }
    public void visit(ExprNumConstHlp ExprNumConstHlp) { }
    public void visit(DesignatorOrNoDesig DesignatorOrNoDesig) { }
    public void visit(Var Var) { }
    public void visit(ExtendsTypeHlp ExtendsTypeHlp) { }
    public void visit(StatementList StatementList) { }
    public void visit(Addop Addop) { }
    public void visit(FormParsOrNot FormParsOrNot) { }
    public void visit(Factor Factor) { }
    public void visit(CondTerm CondTerm) { }
    public void visit(VarList VarList) { }
    public void visit(Designator Designator) { }
    public void visit(ExprOrNoExpr ExprOrNoExpr) { }
    public void visit(Term Term) { }
    public void visit(Condition Condition) { }
    public void visit(ConstDeclList ConstDeclList) { }
    public void visit(ActParsList ActParsList) { }
    public void visit(ConstrMethHlp ConstrMethHlp) { }
    public void visit(SQRBrackets SQRBrackets) { }
    public void visit(ExprList ExprList) { }
    public void visit(GlobDeclList GlobDeclList) { }
    public void visit(ConstDeclItem ConstDeclItem) { }
    public void visit(DesignatorStatementItem DesignatorStatementItem) { }
    public void visit(VarDeclList VarDeclList) { }
    public void visit(Expr Expr) { }
    public void visit(ActPars ActPars) { }
    public void visit(MethodTypeName MethodTypeName) { }
    public void visit(DesignatorList DesignatorList) { }
    public void visit(ExprActParsHlp ExprActParsHlp) { }
    public void visit(Statement Statement) { }
    public void visit(VarDecl VarDecl) { }
    public void visit(CondFact CondFact) { }
    public void visit(MethodDeclList MethodDeclList) { }
    public void visit(FormPars FormPars) { }
    public void visit(Mod Mod) { visit(); }
    public void visit(Div Div) { visit(); }
    public void visit(Mul Mul) { visit(); }
    public void visit(Sub Sub) { visit(); }
    public void visit(Add Add) { visit(); }
    public void visit(LessEqual LessEqual) { visit(); }
    public void visit(LessThan LessThan) { visit(); }
    public void visit(GreaterEqual GreaterEqual) { visit(); }
    public void visit(GreaterThan GreaterThan) { visit(); }
    public void visit(NotEqual NotEqual) { visit(); }
    public void visit(IsEqual IsEqual) { visit(); }
    public void visit(Assignop Assignop) { visit(); }
    public void visit(Label Label) { visit(); }
    public void visit(FactorActPars FactorActPars) { visit(); }
    public void visit(FactorExpr FactorExpr) { visit(); }
    public void visit(FactExpr FactExpr) { visit(); }
    public void visit(FuncCall FuncCall) { visit(); }
    public void visit(VarDesig VarDesig) { visit(); }
    public void visit(FactNewInstance FactNewInstance) { visit(); }
    public void visit(FactBoolConst FactBoolConst) { visit(); }
    public void visit(FactCharConst FactCharConst) { visit(); }
    public void visit(FactNumConst FactNumConst) { visit(); }
    public void visit(TermSingle TermSingle) { visit(); }
    public void visit(TermMulti TermMulti) { visit(); }
    public void visit(ExprSingle ExprSingle) { visit(); }
    public void visit(ExprSingleMinus ExprSingleMinus) { visit(); }
    public void visit(ExprMulti ExprMulti) { visit(); }
    public void visit(NoExpr NoExpr) { visit(); }
    public void visit(ExprExists ExprExists) { visit(); }
    public void visit(CondFactExprRelop CondFactExprRelop) { visit(); }
    public void visit(CondFactExpr CondFactExpr) { visit(); }
    public void visit(CondTermSingle CondTermSingle) { visit(); }
    public void visit(CondTermMulti CondTermMulti) { visit(); }
    public void visit(ConditionSingle ConditionSingle) { visit(); }
    public void visit(ConditionMulti ConditionMulti) { visit(); }
    public void visit(ActParsListSingle ActParsListSingle) { visit(); }
    public void visit(ActParsListMulti ActParsListMulti) { visit(); }
    public void visit(NoActuals NoActuals) { visit(); }
    public void visit(ActParsExists ActParsExists) { visit(); }
    public void visit(NoDesignator NoDesignator) { visit(); }
    public void visit(DesignatorExists DesignatorExists) { visit(); }
    public void visit(DesignatorHlp DesignatorHlp) { visit(); }
    public void visit(DesignatorIdent DesignatorIdent) { visit(); }
    public void visit(DesignatorArray DesignatorArray) { visit(); }
    public void visit(DesignatorSingle DesignatorSingle) { visit(); }
    public void visit(DesignatorListSingle DesignatorListSingle) { visit(); }
    public void visit(DesignatorListMulti DesignatorListMulti) { visit(); }
    public void visit(DsgnStmtItemDecr DsgnStmtItemDecr) { visit(); }
    public void visit(DsgnStmtItemIncr DsgnStmtItemIncr) { visit(); }
    public void visit(DsgnStmtItemActPars DsgnStmtItemActPars) { visit(); }
    public void visit(DsgnStmtAssignopErr DsgnStmtAssignopErr) { visit(); }
    public void visit(DsgnStmtFindAny DsgnStmtFindAny) { visit(); }
    public void visit(DsgnStmtAssignop DsgnStmtAssignop) { visit(); }
    public void visit(DesignatorStatement DesignatorStatement) { visit(); }
    public void visit(ExprNumConstHelper ExprNumConstHelper) { visit(); }
    public void visit(ExprHelper ExprHelper) { visit(); }
    public void visit(IfStmt IfStmt) { visit(); }
    public void visit(IfElseStmt IfElseStmt) { visit(); }
    public void visit(ContinueStmt ContinueStmt) { visit(); }
    public void visit(BreakStmt BreakStmt) { visit(); }
    public void visit(ReadStmt ReadStmt) { visit(); }
    public void visit(ForEachStmt ForEachStmt) { visit(); }
    public void visit(MultipleStmt MultipleStmt) { visit(); }
    public void visit(WhileStmt WhileStmt) { visit(); }
    public void visit(PrintStmt PrintStmt) { visit(); }
    public void visit(ReturnStmt ReturnStmt) { visit(); }
    public void visit(DesignatorStmt DesignatorStmt) { visit(); }
    public void visit(NoStmt NoStmt) { visit(); }
    public void visit(StatementListExists StatementListExists) { visit(); }
    public void visit(Type Type) { visit(); }
    public void visit(FormPar FormPar) { visit(); }
    public void visit(FormParsSingle FormParsSingle) { visit(); }
    public void visit(FormParsMulti FormParsMulti) { visit(); }
    public void visit(NoFormPars NoFormPars) { visit(); }
    public void visit(FormParsExists FormParsExists) { visit(); }
    public void visit(MethodVoid MethodVoid) { visit(); }
    public void visit(MethodType MethodType) { visit(); }
    public void visit(MethodDecl MethodDecl) { visit(); }
    public void visit(NoMethodDecl NoMethodDecl) { visit(); }
    public void visit(MethodDeclListExists MethodDeclListExists) { visit(); }
    public void visit(NoConstMethHelper NoConstMethHelper) { visit(); }
    public void visit(ConstrMethHlpExists ConstrMethHlpExists) { visit(); }
    public void visit(NoExtendsTypeHelper NoExtendsTypeHelper) { visit(); }
    public void visit(ExtendsTypeHlpExists ExtendsTypeHlpExists) { visit(); }
    public void visit(ClassName ClassName) { visit(); }
    public void visit(ClassDecl ClassDecl) { visit(); }
    public void visit(NoVarDeclList NoVarDeclList) { visit(); }
    public void visit(VarDeclListExists VarDeclListExists) { visit(); }
    public void visit(NoVarList NoVarList) { visit(); }
    public void visit(VarListExistsErr VarListExistsErr) { visit(); }
    public void visit(VarListExists VarListExists) { visit(); }
    public void visit(NoSQRBrackets NoSQRBrackets) { visit(); }
    public void visit(SQRBracketsExist SQRBracketsExist) { visit(); }
    public void visit(VarNoBrackets VarNoBrackets) { visit(); }
    public void visit(VarBracketsExist VarBracketsExist) { visit(); }
    public void visit(VarDeclErr VarDeclErr) { visit(); }
    public void visit(VarDeclaration VarDeclaration) { visit(); }
    public void visit(ConstDeclItemBool ConstDeclItemBool) { visit(); }
    public void visit(ConstDeclItemChar ConstDeclItemChar) { visit(); }
    public void visit(ConstDeclItemNum ConstDeclItemNum) { visit(); }
    public void visit(ConstDeclListSingle ConstDeclListSingle) { visit(); }
    public void visit(ConstDeclListMulti ConstDeclListMulti) { visit(); }
    public void visit(ConstDecl ConstDecl) { visit(); }
    public void visit(NoGlobDecl NoGlobDecl) { visit(); }
    public void visit(GlobDeclClass GlobDeclClass) { visit(); }
    public void visit(GlobDeclVar GlobDeclVar) { visit(); }
    public void visit(GlobDeclConst GlobDeclConst) { visit(); }
    public void visit(ProgName ProgName) { visit(); }
    public void visit(Program Program) { visit(); }


    public void visit() { }
}
