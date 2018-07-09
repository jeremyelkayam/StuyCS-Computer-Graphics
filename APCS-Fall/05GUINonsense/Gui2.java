import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //needed for pane
public class Gui2 extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,clear;
    private JLabel l;
    private JTextField text;
    private Container buttons;
    private Container textyStuff;
    private JCheckBox box;

    public Gui2() {
				this.setTitle("Who is the doctor!");
				this.setSize(600,100);
				this.setLocation(100,100);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
				pane = this.getContentPane();
				pane.setLayout(new GridLayout(2,1));

				l = new JLabel("Text:",null,JLabel.CENTER);
				b = new JButton("F to C");
				clear = new JButton("C to F");
				text = new JTextField(40);

                                // make the buttons call the actionListener
				b.setActionCommand("FtoC");
				b.addActionListener(this);
				clear.setActionCommand("CtoF");
				clear.addActionListener(this);

				buttons = new Container();
				buttons.setLayout(new FlowLayout());
				buttons.add(clear);
				buttons.add(b);
 				
				textyStuff = new Container();
				textyStuff.setLayout(new FlowLayout());
				textyStuff.add(l);
				textyStuff.add(text);

				//add the 2 containers
				pane.add(textyStuff);
				pane.add(buttons);
				
		}
                                    //look at which command is being executed, and choose an action
    public void actionPerformed(ActionEvent e){
    	String action = e.getActionCommand();
    	//System.out.println(action);
    	if(action.equals("FtoC")){
    		System.out.println(fToC(Double.parseDouble(text.getText()))+" C");
    	}
    	if(action.equals("CtoF")){
    		System.out.println(cToF(Double.parseDouble(text.getText()))+ "F");
    	}
    }
    public static double cToF(double celcius){
    	return (celcius*1.8)+32.0;
    }
    public static double fToC(double fahrenheit){
    	return (fahrenheit-32.0)/1.8;
    }
    public static void main(String[] args) {
    	Gui2 g = new Gui2();
    	g.setVisible(true);
    }

}