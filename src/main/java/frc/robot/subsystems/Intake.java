/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase
{
	protected SpeedController speedController;

	public Intake()
	{
		speedController = new SpeedControllerGroup( new PWMTalonSRX( Constants.Intake.kMotorPorts[0] ), new PWMTalonSRX( Constants.Intake.kMotorPorts[1] ) );
	}

	@Override
	public void periodic()
	{

	}

	public void setSpeed( double speed )
	{
		speedController.set( speed );
	}

	public void stop()
	{
		setSpeed( 0 );
	}
}
