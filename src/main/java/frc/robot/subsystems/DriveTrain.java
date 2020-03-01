/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{
	protected DifferentialDrive differentialDrive;

	public DriveTrain()
	{
		SpeedController leftMotor = new SpeedControllerGroup( new PWMTalonSRX( Constants.Drive.kLeftMotorPorts[0] ), new PWMTalonSRX( Constants.Drive.kLeftMotorPorts[1] ) );
		leftMotor.setInverted( false );

		SpeedController rightMotor = new SpeedControllerGroup( new PWMTalonSRX( Constants.Drive.kRightMotorPorts[0] ), new PWMTalonSRX( Constants.Drive.kRightMotorPorts[1] ) );
		rightMotor.setInverted( true );

		differentialDrive = new DifferentialDrive( leftMotor, rightMotor );
	}

	@Override
	public void periodic()
	{

	}

	public void drive( double xSpeed, double zRotation, boolean isQuickTurn )
	{
		differentialDrive.curvatureDrive( xSpeed, zRotation, isQuickTurn );
	}

	public void stop()
	{
		differentialDrive.curvatureDrive( 0, 0, false );
	}
}
