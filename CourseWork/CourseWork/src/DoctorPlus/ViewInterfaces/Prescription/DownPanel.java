package DoctorPlus.ViewInterfaces.Prescription;

import DoctorPlus.Controllers.MedicineController.MedicineTable;
import DoctorPlus.Controllers.PrescriptionController.TableSearch;
import DoctorPlus.ViewInterfaces.Components.FooterPanel;
import DoctorPlus.ViewInterfaces.Components.RoundedButton;
import DoctorPlus.ViewInterfaces.MedicineViews.MedicineHomePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class DownPanel extends JPanel {
    JPanel rightPanel;
    JPanel leftPanel;

    private JTextField searchField;
    private JButton searchButton;
    private JTable table;
    private TableSearch TableSearch;
    FooterPanel footerPanel;
    JTextField pId;
    JTextField qty;
    JTextField duration;

    public void setQty(JTextField qty) {
        this.qty = qty;
    }

    public void setDuration(JTextField duration) {
        this.duration = duration;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    public JTextField getpId() {
        return pId;
    }

    public JTextField getQty() {
        return qty;
    }

    public JTextField getDuration() {
        return duration;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public TableSearch getTableSearch() {
        return TableSearch;
    }

    public DownPanel() {
        initializedUI();
    }

    private void initializedUI() {
        setLayout(new BorderLayout());
        setSize(new Dimension(800,100));

        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20);
        searchButton = new RoundedButton("Search",Color.black);
        searchButton.setBackground(Color.black);
        searchButton.setForeground(Color.WHITE);

        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        rightPanel.add(searchPanel);

//        add(rightPanel,BorderLayout.NORTH);

        JPanel patientID = new JPanel();
        patientID.setLayout(new FlowLayout());
        patientID.add(new JLabel("Enter Patient ID:"));
        pId = new JTextField(10);
        patientID.add(pId);
        patientID.setBorder(new EmptyBorder(0,0,0,20));

        qty = new JTextField(10);
        patientID.add(new JLabel("Quentity"));
        patientID.add(qty);

        duration = new JTextField(10);
        patientID.add(new JLabel("Duration"));
        patientID.add(duration);

        JPanel setNorth = new JPanel();
        setNorth.setLayout(new BorderLayout());
        setNorth.add(patientID,BorderLayout.WEST);
        setNorth.add(rightPanel,BorderLayout.EAST);
        setNorth.setBorder(new EmptyBorder(0,20,0,20));

        add(setNorth,BorderLayout.NORTH);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(20,20,0,20));
        try {
            TableSearch = new TableSearch();
            tablePanel.add(TableSearch.createMedicineTable(),BorderLayout.CENTER);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        add(tablePanel,BorderLayout.CENTER);

        footerPanel = new FooterPanel("Add");
        footerPanel.getCancelBtn().setText("Remove");

        add(footerPanel,BorderLayout.SOUTH);
        setVisible(true);

    }
}
