package vazkii.psi.common.core.helpers;

import net.minecraft.util.math.BlockPos;
import vazkii.psi.api.internal.Vector3;
import vazkii.psi.api.spell.*;

public class SpellHelpers {

	public static double ensurePositiveOrZero(SpellPiece piece, SpellParam<Number> param) throws SpellCompilationException {
		double val = piece.getNonNullParamEvaluation(param).doubleValue();
		if (val < 0)
			throw new SpellCompilationException(SpellCompilationException.NON_POSITIVE_VALUE, piece.x, piece.y);
		return val;
	}

	public static double ensurePositiveAndNonzero(SpellPiece piece, SpellParam<Number> param, double def) throws SpellCompilationException {
		double val = piece.getNonNullParamEvaluation(param).doubleValue();
		if (val <= 0)
			throw new SpellCompilationException(SpellCompilationException.NON_POSITIVE_VALUE, piece.x, piece.y);

		return val;
	}


	public static BlockPos getBlockPos(SpellPiece piece, SpellContext context, SpellParam<Vector3> param) throws SpellRuntimeException {
		Vector3 position = piece.getParamValue(context, param);
		if (position == null)
			throw new SpellRuntimeException(SpellRuntimeException.NULL_VECTOR);
		if (!context.isInRadius(position))
			throw new SpellRuntimeException(SpellRuntimeException.OUTSIDE_RADIUS);
		return position.toBlockPos();
	}

	public static Vector3 getVector3(SpellPiece piece, SpellContext context, SpellParam<Vector3> param) throws SpellRuntimeException {
		return checkPos(piece, context, param, false, false);
	}

	public static Vector3 getVector3(SpellPiece piece, SpellContext context, SpellParam<Vector3> param, boolean check, boolean shouldBeAxial) throws SpellRuntimeException {
		return checkPos(piece, context, param, check, shouldBeAxial);
	}

	public static Vector3 getVector3(SpellPiece piece, SpellContext context, SpellParam<Vector3> param, boolean nonnull, boolean check, boolean shouldBeAxial) throws SpellRuntimeException {
		return checkPos(piece, context, param, nonnull, check, shouldBeAxial);
	}

	public static BlockPos getBlockPos(SpellPiece piece, SpellContext context, SpellParam<Vector3> param, boolean check, boolean shouldBeAxial) throws SpellRuntimeException {
		return checkPos(piece, context, param, check, shouldBeAxial).toBlockPos();
	}

	public static BlockPos getBlockPos(SpellPiece piece, SpellContext context, SpellParam<Vector3> param, boolean nonnull, boolean check, boolean shouldBeAxial) throws SpellRuntimeException {
		return checkPos(piece, context, param, nonnull, check, shouldBeAxial).toBlockPos();
	}

	public static Vector3 checkPos(SpellPiece piece, SpellContext context, SpellParam<Vector3> param, boolean check, boolean shouldBeAxial) throws SpellRuntimeException {
		return checkPos(piece, context, param, true, check, shouldBeAxial);
	}

	public static Vector3 checkPos(SpellPiece piece, SpellContext context, SpellParam<Vector3> param, boolean nonnull, boolean check, boolean shouldBeAxial) throws SpellRuntimeException {
		Vector3 position = piece.getParamValue(context, param);
		if (nonnull && (position == null || position.isZero()))
			throw new SpellRuntimeException(SpellRuntimeException.NULL_VECTOR);
		if (check && !context.isInRadius(position))
			throw new SpellRuntimeException(SpellRuntimeException.OUTSIDE_RADIUS);
		if (shouldBeAxial && !position.isAxial())
			throw new SpellRuntimeException(SpellRuntimeException.NON_AXIAL_VECTOR);
		return position;
	}

}