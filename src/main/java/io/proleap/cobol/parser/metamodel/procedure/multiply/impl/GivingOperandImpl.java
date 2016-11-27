/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.multiply.impl;

import io.proleap.cobol.Cobol85Parser.MultiplyGivingOperandContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.multiply.GivingOperand;

public class GivingOperandImpl extends CobolDivisionElementImpl implements GivingOperand {

	protected final MultiplyGivingOperandContext ctx;

	protected Call operandCall;

	public GivingOperandImpl(final ProgramUnit programUnit, final MultiplyGivingOperandContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Call getOperandCall() {
		return operandCall;
	}

	@Override
	public void setOperandCall(final Call operandCall) {
		this.operandCall = operandCall;
	}

}
