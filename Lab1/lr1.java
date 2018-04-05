import org.eclipse.swt.events.*; 
import org.eclipse.swt.layout.*; 
import org.eclipse.swt.widgets.*; 
import org.eclipse.swt.*; 

public class vova { 
private Text textField; 
private Label number; 
private Label simple; 
private Shell shell; 
private Display display; 
private Button button; 
private Label even; 


public vova() { 
display = new Display(); 
shell = new Shell(display); 
GridLayout gridLayout = new GridLayout(); 
shell.setLayout(gridLayout); 
shell.setSize(400, 200); 
gridLayout.numColumns = 2; 
number = new Label(shell, SWT.PUSH); 
number.setText("Enter your number: "); 
textField = new Text(shell, SWT.BORDER); 
textField.setBounds(60, 20, 400, 10); 
simple = new Label(shell, SWT.PUSH); 
simple.setText("Simple? unknown"); 
even = new Label(shell, SWT.PUSH); 
even.setText("Even? unknown"); 
button = new Button(shell, SWT.PUSH); 
button.setText("Check"); 
button.addSelectionListener(new SimpleListener()); 
} 

class SimpleListener implements SelectionListener { 
    public void widgetSelected(SelectionEvent e) { 
        int num = Integer.parseInt(textField.getText()); 
        boolean fl = false; 
        for(int i=2;i<num;i++) {
                if(num%i==0) {
                    fl = true;
                    break;
                }
            }
            if(fl)
            simple.setText("Simple? no");
            else
            simple.setText("Simple? yes");
            if(num%2==0)
            even.setText("Even? yes");
            else even.setText("Even? no"); 
        } 
public void widgetDefaultSelected(SelectionEvent e) {} 
} 

public void start() { 
    shell.open(); 
    while(!shell.isDisposed()) 
    if(!display.readAndDispatch())
    display.sleep(); 
    display.dispose(); 
    textField.dispose(); 
} 

public static void main(String[] args) { 
    vova simpleGUI = new vova(); 
    simpleGUI.start(); 
} 
}