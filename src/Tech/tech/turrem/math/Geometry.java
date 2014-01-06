package tech.turrem.math;

import branch.turrem.BranchAvailable;

public class Geometry extends MathmaticalTech
{
	public Geometry(int pass)
	{
		super(pass);
	}

	@Override
	public void loadBranches()
	{
		(new BranchAvailable(this)).addRequired(Arithmetic.class, 2).push();
	}

	@Override
	public String getName()
	{
		return "Geometry";
	}
}