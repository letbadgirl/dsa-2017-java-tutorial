package dsa2017.proto.controllers;

import java.awt.event.ActionEvent;

public class Edit_Clear extends __BaseModule 
{
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		useFrame().inspectEvent(arg0);
		useFrame().clearMainView();		
	}

}
