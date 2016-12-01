package io.proleap.cobol.gpl.parser.procedure.display;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import io.proleap.cobol.CobolTestSupport;
import io.proleap.cobol.parser.applicationcontext.CobolParserContext;
import io.proleap.cobol.parser.metamodel.CompilationUnit;
import io.proleap.cobol.parser.metamodel.Program;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.parser.metamodel.procedure.display.DisplayStatement;
import io.proleap.cobol.parser.metamodel.procedure.display.Operand;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class DisplayAtStatementTest extends CobolTestSupport {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/gpl/parser/procedure/display/DisplayAtStatement.cbl");
		final Program program = CobolParserContext.getInstance().getParserRunner().analyzeFile(inputFile,
				CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("DisplayAtStatement");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final ProcedureDivision procedureDivision = programUnit.getProcedureDivision();

		{
			final DisplayStatement displayStatement = (DisplayStatement) procedureDivision.getStatements().get(0);
			assertNotNull(displayStatement);

			assertEquals(2, displayStatement.getOperands().size());

			{
				final Operand operand = displayStatement.getOperands().get(0);
				assertNotNull(operand.getOperandCall());
				assertEquals(Call.CallType.UndefinedCall, operand.getOperandCall().getCallType());
			}

			{
				final Operand operand = displayStatement.getOperands().get(1);
				assertNotNull(operand.getOperandCall());
				assertEquals(Call.CallType.UndefinedCall, operand.getOperandCall().getCallType());
			}

			{
				assertNotNull(displayStatement.getAt());

				final Call atCall = displayStatement.getAt().getAtCall();

				assertNotNull(atCall);
				assertEquals(Call.CallType.UndefinedCall, atCall.getCallType());
			}
		}
	}
}