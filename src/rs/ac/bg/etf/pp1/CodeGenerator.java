package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	@Override
	public void visit(MethodType methodTypeName) {
		visitMethodTypeName(methodTypeName);
	}
	
	@Override
	public void visit(MethodVoid methodTypeName) {
		if ("main".equalsIgnoreCase(methodTypeName.getName())) {
			mainPc = Code.pc;
		}
		visitMethodTypeName(methodTypeName);
	}

	private void visitMethodTypeName(MethodTypeName methodTypeName) {
		methodTypeName.obj.setAdr(Code.pc);
		
		Code.put(Code.enter);
		Code.put(0);
		Code.put(methodTypeName.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(ReturnStmt returnStmt) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(DesignatorStatement designatorStatement) {
		Obj obj = designatorStatement.getDesignator().obj;
		if(designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtFindAny) {
			
			DsgnStmtFindAny dsgnStmtFindAny = (DsgnStmtFindAny) designatorStatement.getDesignatorStatementItem();
			Obj arrayObj = dsgnStmtFindAny.getDesignator().obj;
			
			Code.put(Code.enter);
			Code.put(1);
			Code.put(2);
			
			// condition
			int whileStart = Code.pc;
			Code.put(Code.load_1);
			Code.load(arrayObj);
			Code.put(Code.arraylength);
			Code.putFalseJump(Code.lt, 0);
			int whileJumpAdr = Code.pc - 2;
			
			// body
			Code.load(arrayObj);
			Code.put(Code.load_1);
			if (arrayObj.getType().getElemType() == Tab.charType)
				Code.put(Code.baload);
	        else 
	        	Code.put(Code.aload);
			Code.put(Code.load_n);
			Code.putFalseJump(Code.eq, 0);
			int ifElseJumpAdr = Code.pc - 2;
			
			// then
			Code.loadConst(1);
			Code.putJump(0);
			int ifThenJumpAdr = Code.pc - 2;
			
			// if end
			Code.fixup(ifElseJumpAdr);
			
			// ++
			Code.put(Code.load_1);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.put(Code.store_1);
			
			// jump to start of while
			Code.putJump(whileStart);
			
			Code.fixup(whileJumpAdr);
			Code.loadConst(0);
			
			Code.fixup(ifThenJumpAdr);
			
			Code.put(Code.exit);
		} else if(designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtItemIncr) {
			if (obj.getKind() == Obj.Elem)
				Code.put(Code.dup2);
			Code.load(obj);
			Code.loadConst(1);
			Code.put(Code.add);
		}
		else if(designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtItemDecr) {
			if (obj.getKind() == Obj.Elem)
				Code.put(Code.dup2);
			Code.load(obj);
			Code.loadConst(-1);
			Code.put(Code.add);
		}
		Code.store(obj);
	}
	
	@Override
	public void visit(FactNumConst factConst) {
		Code.loadConst(factConst.getValue());
	}
	
	@Override
	public void visit(FactCharConst factConst) {
		Code.loadConst(factConst.getValue());
	}
	
	@Override
	public void visit(FactBoolConst factConst) {
		if (factConst.getValue())
			Code.loadConst(1);
		else
			Code.loadConst(0);
	}
	
	@Override
	public void visit(FactNewInstance factNewInstance) {
		if (factNewInstance.getExprActParsHlp() instanceof FactorExpr) {
			Code.put(Code.newarray);
			if(factNewInstance.getType().struct == Tab.charType)
				Code.put(0);
			else Code.put(1);
		}
	}
	
	@Override
	public void visit(VarDesig varDesig) {
		Code.load(varDesig.getDesignator().obj);
	}
	
	@Override
	public void visit(PrintStmt printStmt) {
		if(printStmt.getExprNumConstHlp() instanceof ExprNumConstHelper)
			Code.loadConst(((ExprNumConstHelper)printStmt.getExprNumConstHlp()).getLen());
		else Code.loadConst(1);
		if(printStmt.getExpr().struct == Tab.charType)
			Code.put(Code.bprint);
		else Code.put(Code.print);
	}
	
	@Override
	public void visit(ReadStmt readStmt) {
		Obj obj = readStmt.getDesignator().obj;
		if(obj.getType() == Tab.charType)
			Code.put(Code.bread);
		else Code.put(Code.read);
		Code.store(obj);
	}
	
	@Override
	public void visit(ExprMulti addExpr) {
		if(addExpr.getAddop() instanceof Add)
			Code.put(Code.add);
		else Code.put(Code.sub);
	}
	
	@Override
	public void visit(TermMulti mulExpr) {
		if(mulExpr.getMulop() instanceof Mul)
			Code.put(Code.mul);
		else if(mulExpr.getMulop() instanceof Div) Code.put(Code.div);
		else Code.put(Code.rem);
	}
	
	@Override
	public void visit(ExprSingleMinus minusExpr) {
		Code.put(Code.neg);
	}
	
	@Override
	public void visit(DesignatorHlp designatorHlp) {
		Code.load(designatorHlp.getDesignator().obj);
	}
}
