package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor {

	static final Struct boolType = new Struct(Struct.Bool);
	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	Struct lastTypeVisited;

	Logger log = Logger.getLogger(getClass());

	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(ProgName progName) {
		if (Tab.currentScope.findSymbol(progName.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + progName.getName() + "u tekucem opsegu.", progName);
			progName.obj = Tab.noObj;
		} else {
			progName.obj = Tab.insert(Obj.Prog, progName.getName(), Tab.noType);
		}

		Tab.openScope();
	}

	public void visit(Program program) {
		Obj main = Tab.currentScope.findSymbol("main");
		if (main != null) {
			if (main.getType() != Tab.noType || main.getKind() != Obj.Meth) {
				report_error("Simbol" + main.getName() + "nije metoda ili nije tipa void", program);
			}
		} else {
			report_error("Metoda 'Main' ne postoji u tekucem programu.", program);
		}
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(FormParsExists formParsExists) {
		if (currentMethod.getName().equals("main")) {
			report_error("Metoda main ne sme imati parametre!", formParsExists);
		}
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getName() + " u tabeli simbola.", type);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}

		lastTypeVisited = type.struct;
	}

	public void visit(MethodType methodTypeName) {
		if (Tab.currentScope.findSymbol(methodTypeName.getName()) != null) {
			report_error("Vec postoji metoda sa imenom" + methodTypeName.getName() + " u tekucem opsegu.",
					methodTypeName);
			currentMethod = Tab.noObj;
		} else {
			currentMethod = Tab.insert(Obj.Meth, methodTypeName.getName(), methodTypeName.getType().struct);
			methodTypeName.obj = currentMethod;
		}
		Tab.openScope();
	}

	public void visit(MethodVoid methodVoidName) {
		if (Tab.currentScope.findSymbol(methodVoidName.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + methodVoidName.getName() + " u tekucem opsegu.",
					methodVoidName);
			currentMethod = Tab.noObj;
		} else {
			currentMethod = Tab.insert(Obj.Meth, methodVoidName.getName(), Tab.noType);
			methodVoidName.obj = currentMethod;
		}
		Tab.openScope();
	}

	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Funkcija " + currentMethod.getName() + " nema return iskaz, a nije VOID!", methodDecl);
		}

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		returnFound = false;
		currentMethod = null;
	}

	public void visit(ConstDeclItemNum cnst) {
		if (Tab.currentScope.findSymbol(cnst.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + cnst.getName() + " u tekucem opsegu.", cnst);
		} else {
			Tab.insert(Obj.Con, cnst.getName(), lastTypeVisited).setAdr(cnst.getValue());
		}
		if (lastTypeVisited != Tab.intType) {
			report_error("Tip konstante " + cnst.getName() + " nije ekvivalentan tipu int koji se dodeljuje", cnst);
		}
	}

	public void visit(ConstDeclItemChar cnst) {
		if (Tab.currentScope.findSymbol(cnst.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + cnst.getName() + " u tekucem opsegu.", cnst);
		} else {
			Tab.insert(Obj.Con, cnst.getName(), lastTypeVisited).setAdr(cnst.getValue());
		}
		if (lastTypeVisited != Tab.charType) {
			report_error("Tip konstante " + cnst.getName() + " nije ekvivalentan tipu char koji se dodeljuje", cnst);
		}
	}

	public void visit(ConstDeclItemBool cnst) {
		if (Tab.currentScope.findSymbol(cnst.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + cnst.getName() + " u tekucem opsegu.", cnst);
		} else {
			Tab.insert(Obj.Con, cnst.getName(), lastTypeVisited).setAdr(cnst.getValue() ? 1 : 0);
		}
		if (lastTypeVisited != boolType) {
			report_error("Tip konstante " + cnst.getName() + " nije ekvivalentan tipu bool koji se dodeljuje", cnst);
		}
	}

	public void visit(VarBracketsExist varBrackets) {
		if (Tab.currentScope.findSymbol(varBrackets.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + varBrackets.getName() + " u tekucem opsegu.", varBrackets);
		} else {
			Tab.insert(Obj.Var, varBrackets.getName(), new Struct(Struct.Array, lastTypeVisited));
		}
	}

	public void visit(VarNoBrackets varNoBrackets) {
		if (Tab.currentScope.findSymbol(varNoBrackets.getName()) != null) {
			report_error("Vec postoji simbol sa imenom" + varNoBrackets.getName() + " u tekucem opsegu.",
					varNoBrackets);
		} else {
			Tab.insert(Obj.Var, varNoBrackets.getName(), lastTypeVisited);
		}
	}

	public void visit(PrintStmt printStmt) {
		if (printStmt.getExpr().struct != Tab.charType && printStmt.getExpr().struct != Tab.intType
				&& printStmt.getExpr().struct != boolType) {
			report_error("Tip izraza u print funkciji je pogresan", printStmt);
		}
	}

	public void visit(ReturnStmt returnStmt) {
		Struct currMethType = currentMethod.getType();
		if (returnStmt.getExprOrNoExpr() instanceof ExprExists) {
			returnFound = true;
			Struct returnType = ((ExprExists) returnStmt.getExprOrNoExpr()).getExpr().struct;
			if (!returnType.assignableTo(currMethType)) {
				report_error("Tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije "
						+ currentMethod.getName(), returnStmt);
			}
		} else if (currMethType != Tab.noType) {
			report_error("Ako nemamo izraz iza return naredbe metod mora biti void " + currentMethod.getName(),
					returnStmt);
		}
	}

	public void visit(ExprMulti addExpr) {
		Struct t1 = addExpr.getExpr().struct;
		Struct t2 = addExpr.getTerm().struct;
		if (t1 == Tab.intType && t2 == Tab.intType)
			addExpr.struct = Tab.intType;
		else {
			report_error("Nekompatibilni tipovi u izrazu uz addop.", addExpr);
			addExpr.struct = Tab.noType;
		}
	}

	public void visit(ExprSingleMinus singleMinExpr) {
		Struct t1 = singleMinExpr.getTerm().struct;
		if (t1 == Tab.intType)
			singleMinExpr.struct = Tab.intType;
		else {
			report_error("Nekompatibilni tipovi u izrazu uz addop.", singleMinExpr);
			singleMinExpr.struct = Tab.noType;
		}
	}

	public void visit(ExprSingle exprSingle) {
		exprSingle.struct = exprSingle.getTerm().struct;
	}

	public void visit(TermMulti mulExpr) {
		Struct t1 = mulExpr.getTerm().struct;
		Struct t2 = mulExpr.getFactor().struct;
		if (t1 == Tab.intType && t2 == Tab.intType)
			mulExpr.struct = Tab.intType;
		else {
			report_error("Nekompatibilni tipovi u izrazu uz addop.", mulExpr);
			mulExpr.struct = Tab.noType;
		}
	}

	public void visit(TermSingle termSingle) {
		termSingle.struct = termSingle.getFactor().struct;
	}

	public void visit(FactNumConst factNumConst) {
		factNumConst.struct = Tab.intType;
	}

	public void visit(FactCharConst factCharConst) {
		factCharConst.struct = Tab.charType;
	}

	public void visit(FactBoolConst factBoolConst) {
		factBoolConst.struct = boolType;
	}

	public void visit(VarDesig varDesig) {
		varDesig.struct = varDesig.getDesignator().obj.getType();
	}

	public void visit(FactExpr factExpr) {
		factExpr.struct = factExpr.getExpr().struct;
	}

	public void visit(FactNewInstance factNewInstance) {
		if (factNewInstance.getExprActParsHlp() instanceof FactorExpr)
			factNewInstance.struct = new Struct(Struct.Array, factNewInstance.getType().struct);
	}

	public void visit(DesignatorStatement designatorStatement) {
		Designator designator = designatorStatement.getDesignator();
		if ((designator.obj.getKind() != Obj.Elem) && (designator.obj.getKind() != Obj.Fld)
				&& (Obj.Var != designator.obj.getKind())) {
			report_error("Simbol sa imenom " + designator.obj.getName() + " mora biti Elem, Fld ili Var!", designator);
		}
		if (designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtAssignop) {
			if (!((DsgnStmtAssignop) designatorStatement.getDesignatorStatementItem()).getExpr().struct
					.assignableTo(designator.obj.getType())) {
				report_error("Tipovi dodeljenih vrednosti nisu kompatabilni.", designatorStatement);
			}
		} else if (designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtItemIncr
				|| designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtItemDecr) {
			if (designator.obj.getType() != Tab.intType) {
				report_error("Simbol sa imenom " + designator.obj.getName() + " nije validnog tipa int!", designator);

			}
		} else if (designatorStatement.getDesignatorStatementItem() instanceof DsgnStmtFindAny) {
			DsgnStmtFindAny dsgnStmtFindAny = (DsgnStmtFindAny) designatorStatement.getDesignatorStatementItem();
			if(designator.obj.getType() != boolType) {
				report_error("Simbol sa imenom " + designator.obj.getName() + " nije tipa bool!", designator);
			}
			Obj arrayObj = dsgnStmtFindAny.getDesignator().obj;
			if (arrayObj.getType().getKind() != Struct.Array) {
				report_error("Simbol sa imenom " + arrayObj.getName() + " nije niz!", designator);
			}
			if(!arrayObj.getType().getElemType().equals(dsgnStmtFindAny.getExpr().struct)) {
				report_error("Element niza " + arrayObj.getName() + " i vrednost pretrage se ne poklapaju po tipu!", designator);
			}
		}
	}

	public void visit(DesignatorArray designatorArray) {
		Obj designatorObj = designatorArray.getDesignatorHlp().getDesignator().obj;
		designatorArray.obj = new Obj(Obj.Elem, "", designatorObj.getType().getElemType());

		if (designatorObj.getType().getKind() != Struct.Array) {
			designatorArray.obj = Tab.noObj;
			report_error("Identifikator " + designatorObj.getName() + "nije niz.", designatorArray);
		}
		if (!designatorArray.getExpr().struct.equals(Tab.intType)) {
			designatorArray.obj = Tab.noObj;
			report_error("Expr mora biti tipa int.", designatorArray);
		}
	}

	public void visit(DesignatorIdent designatorIdent) {
		Obj obj = Tab.find(designatorIdent.getName());
		if (obj != Tab.noObj) {
			DumpSymbolTableVisitor dstv = new DumpSymbolTableVisitor();
			dstv.visitObjNode(obj);
			String symbolDesc = dstv.getOutput();
			if (obj.getKind() == Obj.Var) {
				if (obj.getLevel() == 0) {
					report_info("Koriscenje globalne promenljive " + symbolDesc, designatorIdent);
				} else {
					report_info("Koriscenje lokalne promenljive " + symbolDesc, designatorIdent);
				}
			} else if (obj.getKind() == Obj.Con) {
				report_info("Koriscenje konstante " + symbolDesc, designatorIdent);
			}
		} else {
			report_error("Simbol sa imenom " + designatorIdent.getName() + " nije deklarisan!", designatorIdent);
		}
		designatorIdent.obj = obj;
	}

	public void visit(ReadStmt readStmt) {
		int designKind = readStmt.getDesignator().obj.getKind();
		if (designKind != Obj.Var && designKind != Obj.Fld && designKind != Obj.Elem) {
			report_error("Identifikator " + readStmt.getDesignator().obj.getName() + " mora biti Var, Fld ili Elem!",
					readStmt);
		}
		Struct designType = readStmt.getDesignator().obj.getType();
		if (designType != Tab.intType && designType != Tab.charType && designType != boolType) {
			report_error(
					"Identifikator " + readStmt.getDesignator().obj.getName() + " mora biti tipa int, char ili bool!",
					readStmt);
		}
	}

	public void visit(VarDeclErr err) {
		report_info("Oporavak od sintaksne greske kod deklaracije promenljive do ';'", err);
	}

	public void visit(VarListExistsErr err) {
		report_info("Oporavak od sintaksne greske kod deklaracije promenljive do ','", err);
	}

	public void visit(DsgnStmtAssignopErr err) {
		report_info("Oporavak od sintaksne greske kod dodele vrednosti do ';'", err);
	}

	public boolean passed() {
		return !errorDetected;
	}

}
