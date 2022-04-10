import java.awt.*;
import java.awt.event.*;
class MultiCastingFrameDemo
{
	public static void main(String[] args)
	{
		MultiCastingFrame f11=new MultiCastingFrame();
		f11.show();
	}
}
class MultiCastingFrame extends Frame implements ActionListener
{
	Button newButton,closeAllButton;

	static int flag = 0;
	int i=1,len=70,width=40;
	String title="";

	MultiCastingFrame()
	{
		setSize(320,320);
		setLocation(950,200);
		setTitle("Multi Casting Frame");

		setLayout(new FlowLayout());

		newButton = new Button(" New ");
		closeAllButton = new Button(" Close All ");

		add(newButton);
		add(closeAllButton);

		newButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(flag != 0)
		{
			i = 1;
			len = 70;
			width = 40;
			flag = 0;
		}
		title= "Frame"+i;

		NewFrame f1 = new NewFrame(len,width,title);
		closeAllButton.addActionListener(f1);
		f1.show();

		i=i+1;
		len = len+40;
		width = width+40;
	}
}
class NewFrame extends Frame implements ActionListener
{
	NewFrame(int len , int width , String title)
	{
		setLocation(len,width);
		setTitle(title);
		setSize(250,200);
	}
	public void actionPerformed(ActionEvent ae)
	{
		this.hide();//or this.dispose()
		MultiCastingFrame.flag = 1;
	}
}
