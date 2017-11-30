package manageOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaJFrame {
    private JPanel panelMain;
    private JTabbedPane Tab;
    private JButton viewButton;
    private JButton addButton;
    private JButton changeButton;
    private JButton removeButton;
    private JTextArea reservationText;
    private JButton prepareButton;
    private JButton sendButton;
    private JTextArea sendText;

    OrderLinkedList orderList = new OrderLinkedList();
    ListIterator iterator = orderList.listIterator();

    public PizzaJFrame() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOrder();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrder();
            }
        });
        /*changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeOrder();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeOrder();
            }
        });*/
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("PizzaType App");
        frame.setSize(700,400);
        frame.setContentPane(new PizzaJFrame().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        }

    public void displayOrder() {
        reservationText.setText("Reservations Total: " + orderList.size());
        if(orderList.isEmpty() == false) {
            for (int i = 0; i < orderList.size(); i++) {
                reservationText.append("\n#" + (i+1) + ":  " +
                            orderList.get(i).getTime());
            }
        } else {
            reservationText.setText("List is empty!");
        }
    }

    private void addOrder() {

        JOptionPane jop = new JOptionPane(),jop2 = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Le client existe-t-il?",
                                            "Information client", JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.YES_OPTION){
            System.out.println("selectClient");
        }
        if(option == JOptionPane.NO_OPTION){
            System.out.println("newClient");

            // Construire un nouveau client
            JPanel panel = new JPanel();
            panel.add(new JLabel("Name :"));
            JTextField nameField = new JTextField(20);
            panel.add(nameField);

            panel.add(new JLabel("Address :"));
            JTextField address = new JTextField(20);
            panel.add(address);

            Object[] options = {"Add", "Cancel"};
            int n = JOptionPane.showOptionDialog(null, panel, "Client",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (n == JOptionPane.YES_OPTION) {
                String inputName = nameField.getText();               // Name of client
                String inputAddress = address.getText();              //Address of client
                Client client = new Client(inputName,inputAddress);   //Client variable

                // Remplir une commande
                JPanel panelComm = new JPanel();
                String[] numero = {"1", "2", "3", "4", "5"};
                JComboBox comboPizza = new JComboBox(numero);
                panelComm.add(new JLabel("Nb Pizza :"));
                panelComm.add(comboPizza);

                JComboBox comboDrink = new JComboBox(numero);
                panelComm.add(new JLabel("Nb drink :"));
                panelComm.add(comboDrink);

                String[] hour  = { "12", "13", "14", "15","16","17","18","19","20","21","22","23"};
                String[] minute = {"00","15","30","45"};
                JComboBox comboHour = new JComboBox(hour);
                JComboBox comboMinute = new JComboBox(minute);
                panelComm.add(new JLabel("Time :"));
                panelComm.add(comboHour);
                panelComm.add(comboMinute);

                Object[] options2 = {"Ok", "Cancel"};
                int m = JOptionPane.showOptionDialog(null, panelComm, "Order",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options2, options2[0]);
                if (m == JOptionPane.YES_OPTION) {
                    String inputTime = comboHour.getSelectedItem().toString() + ":" +       // Time variable
                            comboMinute.getSelectedItem().toString();
                    int nbPizza = Integer.parseInt((String) comboPizza.getSelectedItem());   //number of pizza
                    int nbDrink = Integer.parseInt((String) comboPizza.getSelectedItem());   //number of drink

                    // Choose Pizza caracteristic & drink

                    JPanel panelComm2 = new JPanel();
                    int nbRow =nbPizza+nbDrink;
                    panelComm2.setLayout(new GridLayout(nbRow,3));          // GridLayout
                    String[] crust = Crust.names();
                    String[] size  = Size.names();
                    JComboBox comboCrust = new JComboBox(crust);
                    JComboBox comboSize = new JComboBox(size);
                    String[] drink = Drink.names();
                    JComboBox comboChooseDrink = new JComboBox(drink);

                }

            }




                /*
                hours.setModel(new javax.swing.DefaultComboBoxModel(new String[]
                { "12", "13", "14", "15","16","17","18","19","20","21","22","23"}));
        minutes.setModel(new javax.swing.DefaultComboBoxModel(new String[]
                {"00","15","30","45"}));
        panel.add(hours);
        panel.add(minutes);

        panel.add(new JLabel("Pizza:"));
        JComboBox pizza = new javax.swing.JComboBox(PizzaType.values());
        panel.add(pizza);



        Object[] options = {"Add", "Cancel"};
        int n = JOptionPane.showOptionDialog(null, panel, "Reservation",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null, options, options[0]);
        if (n == JOptionPane.YES_OPTION) {
            String inputName = nameField.getText();
            Date inputDate = picker.getDate();
            String inputTime = hours.getSelectedItem().toString() + ":" +
                    minutes.getSelectedItem().toString();
            PizzaType inputPizza = (PizzaType) pizza.getSelectedItem();

            iterator.makeNewReservation(new ReservationInfo(inputName, inputTime, inputDate, inputPizza));
            displayReservation();
        }
                */
            }


            jop2.showMessageDialog(null, "create client","Etat civil", JOptionPane.INFORMATION_MESSAGE);
    }



/*
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nb Pizza :"));
        JTextField nbPizza = new JTextField(2);
        panel.add(nbPizza);


        Object[] options = {"Add", "Cancel"};
        int n = JOptionPane.showOptionDialog(null, panel, "Reservation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        if (n == JOptionPane.YES_OPTION) {
            String inputName = nameField.getText();
            Date inputDate = picker.getDate();
            String inputTime = hours.getSelectedItem().toString() + ":" +
                    minutes.getSelectedItem().toString();
            PizzaType inputPizza = (PizzaType) pizza.getSelectedItem();

            iterator.makeNewReservation(new Order()); // complete constructor
            displayOrder();
        }
        */

}



