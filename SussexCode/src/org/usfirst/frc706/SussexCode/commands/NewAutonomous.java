package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class NewAutonomous extends CommandGroup {

    public NewAutonomous() {
    	addSequential(new Zero());
    }
}
