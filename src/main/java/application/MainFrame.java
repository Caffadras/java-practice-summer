
package application;


import application.tabs.bank.BankTabPanel;
import application.tabs.contract.ContractTabPanel;
import application.tabs.credit.CreditTabPanel;
import application.tabs.juridicalclient.JClientTabPanel;
import application.tabs.physicalclient.PClientTabPanel;
import initdata.DataLoader;
import model.*;
import services.CrudService;
import services.factory.ServiceFactory;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    static JFrame frame;

    public void addComponentToPane(Container pane) {
        final JTabbedPane tabbedPane = new JTabbedPane();

        DataLoader.run();
        CrudService<Bank> bankService = ServiceFactory.getServiceFor(Bank.class);
        CrudService<Credit> creditService =  ServiceFactory.getServiceFor(Credit.class);
        CrudService<Contract> contractService =  ServiceFactory.getServiceFor(Contract.class);
        CrudService<PhysicalClient> physicalClientService =  ServiceFactory.getServiceFor(PhysicalClient.class);
        CrudService<JuridicalClient> juridicalClientService =  ServiceFactory.getServiceFor(JuridicalClient.class);

        tabbedPane.addTab("Banks", new BankTabPanel(bankService));
        tabbedPane.addTab("Credits", new CreditTabPanel(creditService));
        tabbedPane.addTab("Contracts", new ContractTabPanel(contractService, bankService, creditService));
        tabbedPane.addTab("Physical Clients", new PClientTabPanel(physicalClientService));
        tabbedPane.addTab("Juridical Clients", new JClientTabPanel(juridicalClientService));

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Bank app");
        frame.setPreferredSize(new Dimension(600, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainFrame demo = new MainFrame();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void setNimbusLookAndFeel(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    private static void setMetalLookAndFeel(){
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
    }

    public static void main(String[] args) {

        setMetalLookAndFeel();
        //setNimbusLookAndFeel();

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(MainFrame::createAndShowGUI);
    }
}
