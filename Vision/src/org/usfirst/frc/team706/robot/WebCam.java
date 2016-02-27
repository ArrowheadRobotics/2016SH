package org.usfirst.frc.team706.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;

public class WebCam {
	String location;
	int session;
	Image frame;
	
	public WebCam(String loc) {
		this.location = loc;
		this.init();
	}
	
	public void init() {
		this.frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		this.session = NIVision.IMAQdxOpenCamera(this.location,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(this.session);
	}
	
	public void operator() {
        NIVision.IMAQdxStartAcquisition(this.session);
	}
	
	public void loop() {
        NIVision.IMAQdxGrab(this.session, this.frame, 1);
        CameraServer.getInstance().setImage(this.frame);
	}
	
	public void stop() {
        NIVision.IMAQdxStopAcquisition(this.session);
	}
}
