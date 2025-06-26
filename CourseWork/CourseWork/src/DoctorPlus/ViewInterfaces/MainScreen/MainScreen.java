package DoctorPlus.ViewInterfaces.MainScreen;

import DoctorPlus.Controllers.MainController;
import DoctorPlus.ViewInterfaces.PatientViews.PatientHomePanel;
import DoctorPlus.ViewInterfaces.MedicineViews.MedicineHomePanel;
import DoctorPlus.ViewInterfaces.Prescription.PriscriptionHomePanel;
import DoctorPlus.ViewInterfaces.Settings.SetingsHomePanel;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

//    private JPanel contentArea;
    String userName;
    JPanel tablePanel;
    SliderBar sliderBar;
    PatientHomePanel patientHomePanel;
    MedicineHomePanel medicineHomePanel;
    PriscriptionHomePanel priscriptionHomePanel;
    SetingsHomePanel setingsHomePanel;

    public MainScreen() throws HeadlessException {

        InitializedUI();
    }

    public MainScreen(String title,String userName) throws HeadlessException {
        super(title);
        this.userName =userName;

        sliderBar = new SliderBar();
        patientHomePanel = new PatientHomePanel();
        medicineHomePanel =new MedicineHomePanel();
        priscriptionHomePanel = new PriscriptionHomePanel(userName);
        setingsHomePanel = new SetingsHomePanel();

        InitializedUI();

        new MainController(patientHomePanel,medicineHomePanel,sliderBar,priscriptionHomePanel,this,setingsHomePanel);
    }

    private void InitializedUI() throws HeadlessException{
        Container container = getContentPane();
        setSize(new Dimension(1200,710));
        setLayout(new BorderLayout());

        HeadPanel headPanel = new HeadPanel(userName);
        container.add(headPanel,BorderLayout.NORTH);

        container.add(sliderBar,BorderLayout.WEST);

        container.add(priscriptionHomePanel,BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
