import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

abstract class Passenger {
    private String name;
    private int age;
    private long phoneNumber;
    private String departureAirport;
    private String landingAirport;

    public Passenger(String name, int age, long phoneNumber, String departureAirport, String landingAirport) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.departureAirport = departureAirport;
        this.landingAirport = landingAirport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getLandingAirport() {
        return landingAirport;
    }

    public abstract void displayBoardingPass();

    public abstract String code(String location);

    public abstract double base();

    public abstract double tax();
}

class BusinessClassPassenger extends Passenger {

    public BusinessClassPassenger(String name, int age, long phoneNumber, String departureAirport,
            String landingAirport) {
        super(name, age, phoneNumber, departureAirport, landingAirport);
    }

    public void displayBoardingPass() {

        JFrame boardingPassFrame = new JFrame("Boarding Pass");
        boardingPassFrame.setSize(750, 600);
        boardingPassFrame.getContentPane().setBackground(Color.decode("#1551C5"));

        Font fk = new Font("IBM Plex Sans Medium", Font.PLAIN, 24);
        Font fv = new Font("IBM Plex Sans SemiBold", Font.PLAIN, 28);

        JLabel heroLabel1 = new JLabel(code(getDepartureAirport()) + "  →  " + code(getLandingAirport()));
        heroLabel1.setFont(new Font("IBM Plex Sans Bold", Font.PLAIN, 80));
        heroLabel1.setForeground(Color.decode("#FFFFFF"));
        heroLabel1.setBounds(125, 70, 850, 120);

        JLabel nameLabel1 = new JLabel("Name");
        nameLabel1.setFont(fk);
        nameLabel1.setForeground(Color.decode("#8AA8E1"));
        nameLabel1.setBounds(125, 180, 300, 50);
        JLabel nameLabel2 = new JLabel(getName());
        nameLabel2.setFont(fv);
        nameLabel2.setForeground(Color.decode("#FFFFFF"));
        nameLabel2.setBounds(125, 210, 300, 50);

        JLabel pnrLabel1 = new JLabel("PNR");
        pnrLabel1.setFont(fk);
        pnrLabel1.setForeground(Color.decode("#8AA8E1"));
        pnrLabel1.setBounds(375, 180, 300, 50);
        JLabel pnrLabel2 = new JLabel(pnr());
        pnrLabel2.setFont(fv);
        pnrLabel2.setForeground(Color.decode("#FFFFFF"));
        pnrLabel2.setBounds(375, 210, 300, 50);

        JLabel fromLabel1 = new JLabel("From");
        fromLabel1.setFont(fk);
        fromLabel1.setForeground(Color.decode("#8AA8E1"));
        fromLabel1.setBounds(125, 250, 300, 50);
        JLabel fromLabel2 = new JLabel(getDepartureAirport());
        fromLabel2.setFont(fv);
        fromLabel2.setForeground(Color.decode("#FFFFFF"));
        fromLabel2.setBounds(125, 280, 300, 50);

        JLabel baseLabel1 = new JLabel("Base");
        baseLabel1.setFont(fk);
        baseLabel1.setForeground(Color.decode("#8AA8E1"));
        baseLabel1.setBounds(375, 250, 300, 50);
        double baseValue = base();
        JLabel baseLabel2 = new JLabel(baseValue + "$");
        baseLabel2.setFont(fv);
        baseLabel2.setForeground(Color.decode("#FFFFFF"));
        baseLabel2.setBounds(375, 280, 300, 50);

        JLabel toLabel1 = new JLabel("To");
        toLabel1.setFont(fk);
        toLabel1.setForeground(Color.decode("#8AA8E1"));
        toLabel1.setBounds(125, 320, 300, 50);
        JLabel toLabel2 = new JLabel(getLandingAirport());
        toLabel2.setFont(fv);
        toLabel2.setForeground(Color.decode("#FFFFFF"));
        toLabel2.setBounds(125, 350, 300, 50);

        JLabel taxLabel1 = new JLabel("Tax");
        taxLabel1.setFont(fk);
        taxLabel1.setForeground(Color.decode("#8AA8E1"));
        taxLabel1.setBounds(375, 320, 300, 50);
        double taxValue = baseValue * tax() / 100;
        JLabel taxLabel2 = new JLabel(taxValue + "$");
        taxLabel2.setFont(fv);
        taxLabel2.setForeground(Color.decode("#FFFFFF"));
        taxLabel2.setBounds(375, 350, 300, 50);

        JLabel flightNumberLabel1 = new JLabel("Flight Number");
        flightNumberLabel1.setFont(fk);
        flightNumberLabel1.setForeground(Color.decode("#8AA8E1"));
        flightNumberLabel1.setBounds(125, 390, 300, 50);
        JLabel flightNumberLabel2 = new JLabel(flightNumber());
        flightNumberLabel2.setFont(fv);
        flightNumberLabel2.setForeground(Color.decode("#FFFFFF"));
        flightNumberLabel2.setBounds(125, 420, 300, 50);

        JLabel flightNumberLabel3 = new JLabel("Total");
        flightNumberLabel3.setFont(fk);
        flightNumberLabel3.setForeground(Color.decode("#8AA8E1"));
        flightNumberLabel3.setBounds(375, 390, 300, 50);
        JLabel flightNumberLabel4 = new JLabel((baseValue + taxValue) + "$");
        flightNumberLabel4.setFont(fv);
        flightNumberLabel4.setForeground(Color.decode("#FFFFFF"));
        flightNumberLabel4.setBounds(375, 420, 390, 50);

        JLabel totLabel1 = new JLabel(" ");
        totLabel1.setFont(fk);
        totLabel1.setForeground(Color.decode("#8AA8E1"));
        totLabel1.setBounds(375, 390, 300, 50);
        JLabel totLabel2 = new JLabel("    ");
        totLabel2.setFont(fv);
        totLabel2.setForeground(Color.decode("#FFFFFF"));
        totLabel2.setBounds(375, 420, 390, 50);

        boardingPassFrame.add(heroLabel1);

        boardingPassFrame.add(nameLabel1);
        boardingPassFrame.add(nameLabel2);

        boardingPassFrame.add(pnrLabel1);
        boardingPassFrame.add(pnrLabel2);

        boardingPassFrame.add(fromLabel1);
        boardingPassFrame.add(fromLabel2);

        boardingPassFrame.add(baseLabel1);
        boardingPassFrame.add(baseLabel2);

        boardingPassFrame.add(toLabel1);
        boardingPassFrame.add(toLabel2);

        boardingPassFrame.add(taxLabel1);
        boardingPassFrame.add(taxLabel2);

        boardingPassFrame.add(flightNumberLabel1);
        boardingPassFrame.add(flightNumberLabel2);

        boardingPassFrame.add(flightNumberLabel3);
        boardingPassFrame.add(flightNumberLabel4);

        boardingPassFrame.add(totLabel1);
        boardingPassFrame.add(totLabel2);

        boardingPassFrame.setVisible(true);
    }

    Random rand = new Random();

    public String flightNumber() {
        String s = "";
        for (int i = 0; i < 6; i++) {
            if (i == 0 || i == 3) {
                s += (char) (rand.nextInt(57 - 48 + 1) + 48);
            } else {
                s += (char) (rand.nextInt(90 - 65 + 1) + 65);
            }
        }
        return s;
    }

    public String code(String location) {
        if (location == "London") {
            return "LHR";
        } else if (location == "Ahmedabad") {
            return "AMD";
        } else if (location == "Sydney") {
            return "SYD";
        } else if (location == "Tokyo") {
            return "HND";
        } else if (location == "Lagos") {
            return "LOS";
        } else if (location == "New York") {
            return "JFK";
        }
        return "";
    }

    public double base() {

        String dep = getDepartureAirport();
        String arr = getLandingAirport();

        if (dep == "London" && arr == "New York") {
            return 300.0;
        } else if (dep == "London" && arr == "Ahmedabad") {
            return 350.0;
        } else if (dep == "London" && arr == "Sydney") {
            return 400.0;
        } else if (dep == "London" && arr == "Tokyo") {
            return 410.0;
        } else if (dep == "London" && arr == "Lagos") {
            return 270.0;
        } else if (dep == "New York" && arr == "London") {
            return 300.0;
        } else if (dep == "New York" && arr == "Ahmedabad") {
            return 550.0;
        } else if (dep == "New York" && arr == "Sydney") {
            return 500.0;
        } else if (dep == "New York" && arr == "Tokyo") {
            return 575.0;
        } else if (dep == "New York" && arr == "Lagos") {
            return 390.0;
        } else if (dep == "Ahmedabad" && arr == "New York") {
            return 550.0;
        } else if (dep == "Ahmedabad" && arr == "London") {
            return 350.0;
        } else if (dep == "Ahmedabad" && arr == "Sydney") {
            return 475.0;
        } else if (dep == "Ahmedabad" && arr == "Tokyo") {
            return 490.0;
        } else if (dep == "Ahmedabad" && arr == "Lagos") {
            return 460.0;
        } else if (dep == "Sydney" && arr == "New York") {
            return 500.0;
        } else if (dep == "Sydney" && arr == "Ahmedabad") {
            return 475.0;
        } else if (dep == "Sydney" && arr == "London") {
            return 400.0;
        } else if (dep == "Sydney" && arr == "Tokyo") {
            return 310.0;
        } else if (dep == "Sydney" && arr == "Lagos") {
            return 430.0;
        } else if (dep == "Tokyo" && arr == "New York") {
            return 575.0;
        } else if (dep == "Tokyo" && arr == "Ahmedabad") {
            return 490.0;
        } else if (dep == "Tokyo" && arr == "Sydney") {
            return 310.0;
        } else if (dep == "Tokyo" && arr == "London") {
            return 410.0;
        } else if (dep == "Tokyo" && arr == "Lagos") {
            return 495.0;
        } else if (dep == "Lagos" && arr == "New York") {
            return 390.0;
        } else if (dep == "Lagos" && arr == "Ahmedabad") {
            return 460.0;
        } else if (dep == "Lagos" && arr == "Sydney") {
            return 430.0;
        } else if (dep == "Lagos" && arr == "Tokyo") {
            return 495.0;
        } else if (dep == "Lagos" && arr == "London") {
            return 270.0;
        }
        return 0;
    }

    public double tax() {
        double tax = rand.nextInt(20 - 15 + 1) + 15;
        return tax;
    }

    public double total() {
        return base() + tax();
    }

    public String pnr() {
        String s = "B";
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 3) {
                s += (char) (rand.nextInt(57 - 48 + 1) + 48);
            } else {
                s += (char) (rand.nextInt(90 - 65 + 1) + 65);
            }
        }
        return s;
    }
}

class EconomyClassPassenger extends Passenger {

    public EconomyClassPassenger(String name, int age, long phoneNumber, String departureAirport,
            String landingAirport) {
        super(name, age, phoneNumber, departureAirport, landingAirport);
    }

    public void displayBoardingPass() {
        JFrame boardingPassFrame = new JFrame("Boarding Pass");
        boardingPassFrame.setSize(750, 600);
        boardingPassFrame.getContentPane().setBackground(Color.decode("#FFFFFF"));
        Font fk = new Font("IBM Plex Sans Medium", Font.PLAIN, 24);
        Font fv = new Font("IBM Plex Sans SemiBold", Font.PLAIN, 28);

        JLabel heroLabel1 = new JLabel(code(getDepartureAirport()) + "  →  " + code(getLandingAirport()));
        heroLabel1.setFont(new Font("IBM Plex Sans Bold", Font.PLAIN, 80));
        heroLabel1.setForeground(Color.decode("#1551C5"));
        heroLabel1.setBounds(125, 70, 850, 120);

        JLabel nameLabel1 = new JLabel("Name");
        nameLabel1.setFont(fk);
        nameLabel1.setForeground(Color.decode("#8AA8E1"));
        nameLabel1.setBounds(125, 180, 300, 50);
        JLabel nameLabel2 = new JLabel(getName());
        nameLabel2.setFont(fv);
        nameLabel2.setForeground(Color.decode("#1551C5"));
        nameLabel2.setBounds(125, 210, 300, 50);

        JLabel pnrLabel1 = new JLabel("PNR");
        pnrLabel1.setFont(fk);
        pnrLabel1.setForeground(Color.decode("#8AA8E1"));
        pnrLabel1.setBounds(375, 180, 300, 50);
        JLabel pnrLabel2 = new JLabel(pnr());
        pnrLabel2.setFont(fv);
        pnrLabel2.setForeground(Color.decode("#1551C5"));
        pnrLabel2.setBounds(375, 210, 300, 50);

        JLabel fromLabel1 = new JLabel("From");
        fromLabel1.setFont(fk);
        fromLabel1.setForeground(Color.decode("#8AA8E1"));
        fromLabel1.setBounds(125, 250, 300, 50);
        JLabel fromLabel2 = new JLabel(getDepartureAirport());
        fromLabel2.setFont(fv);
        fromLabel2.setForeground(Color.decode("#1551C5"));
        fromLabel2.setBounds(125, 280, 300, 50);

        JLabel baseLabel1 = new JLabel("Base");
        baseLabel1.setFont(fk);
        baseLabel1.setForeground(Color.decode("#8AA8E1"));
        baseLabel1.setBounds(375, 250, 300, 50);
        double baseValue = base();
        JLabel baseLabel2 = new JLabel(baseValue + "$");
        baseLabel2.setFont(fv);
        baseLabel2.setForeground(Color.decode("#1551C5"));
        baseLabel2.setBounds(375, 280, 300, 50);

        JLabel toLabel1 = new JLabel("To");
        toLabel1.setFont(fk);
        toLabel1.setForeground(Color.decode("#8AA8E1"));
        toLabel1.setBounds(125, 320, 300, 50);
        JLabel toLabel2 = new JLabel(getLandingAirport());
        toLabel2.setFont(fv);
        toLabel2.setForeground(Color.decode("#1551C5"));
        toLabel2.setBounds(125, 350, 300, 50);

        JLabel taxLabel1 = new JLabel("Tax");
        taxLabel1.setFont(fk);
        taxLabel1.setForeground(Color.decode("#8AA8E1"));
        taxLabel1.setBounds(375, 320, 300, 50);
        double taxValue = baseValue * tax() / 100;
        JLabel taxLabel2 = new JLabel(taxValue + "$");
        taxLabel2.setFont(fv);
        taxLabel2.setForeground(Color.decode("#1551C5"));
        taxLabel2.setBounds(375, 350, 300, 50);

        JLabel flightNumberLabel1 = new JLabel("Flight Number");
        flightNumberLabel1.setFont(fk);
        flightNumberLabel1.setForeground(Color.decode("#8AA8E1"));
        flightNumberLabel1.setBounds(125, 390, 300, 50);
        JLabel flightNumberLabel2 = new JLabel(flightNumber());
        flightNumberLabel2.setFont(fv);
        flightNumberLabel2.setForeground(Color.decode("#1551C5"));
        flightNumberLabel2.setBounds(125, 420, 300, 50);

        JLabel flightNumberLabel3 = new JLabel("Total");
        flightNumberLabel3.setFont(fk);
        flightNumberLabel3.setForeground(Color.decode("#8AA8E1"));
        flightNumberLabel3.setBounds(375, 390, 300, 50);
        JLabel flightNumberLabel4 = new JLabel((baseValue + taxValue) + "$");
        flightNumberLabel4.setFont(fv);
        flightNumberLabel4.setForeground(Color.decode("#1551C5"));
        flightNumberLabel4.setBounds(375, 420, 390, 50);

        JLabel totLabel1 = new JLabel(" ");
        totLabel1.setFont(fk);
        totLabel1.setForeground(Color.decode("#8AA8E1"));
        totLabel1.setBounds(375, 390, 300, 50);
        JLabel totLabel2 = new JLabel("    ");
        totLabel2.setFont(fv);
        totLabel2.setForeground(Color.decode("#1551C5"));
        totLabel2.setBounds(375, 420, 390, 50);

        boardingPassFrame.add(heroLabel1);

        boardingPassFrame.add(nameLabel1);
        boardingPassFrame.add(nameLabel2);

        boardingPassFrame.add(pnrLabel1);
        boardingPassFrame.add(pnrLabel2);

        boardingPassFrame.add(fromLabel1);
        boardingPassFrame.add(fromLabel2);

        boardingPassFrame.add(baseLabel1);
        boardingPassFrame.add(baseLabel2);

        boardingPassFrame.add(toLabel1);
        boardingPassFrame.add(toLabel2);

        boardingPassFrame.add(taxLabel1);
        boardingPassFrame.add(taxLabel2);

        boardingPassFrame.add(flightNumberLabel1);
        boardingPassFrame.add(flightNumberLabel2);

        boardingPassFrame.add(flightNumberLabel3);
        boardingPassFrame.add(flightNumberLabel4);

        boardingPassFrame.add(totLabel1);
        boardingPassFrame.add(totLabel2);

        boardingPassFrame.setVisible(true);
    }

    Random rand = new Random();

    public String flightNumber() {
        String s = "";
        for (int i = 0; i < 6; i++) {
            if (i == 0 || i == 3) {
                s += (char) (rand.nextInt(57 - 48 + 1) + 48);
            } else {
                s += (char) (rand.nextInt(90 - 65 + 1) + 65);
            }
        }
        return s;
    }

    public String code(String location) {
        if (location == "London") {
            return "LHR";
        } else if (location == "Ahmedabad") {
            return "AMD";
        } else if (location == "Sydney") {
            return "SYD";
        } else if (location == "Tokyo") {
            return "HND";
        } else if (location == "Lagos") {
            return "LOS";
        } else if (location == "New York") {
            return "JFK";
        }
        return "";
    }

    public double base() {

        String dep = getDepartureAirport();
        String arr = getLandingAirport();

        if (dep == "London" && arr == "New York") {
            return 200.0;
        } else if (dep == "London" && arr == "Ahmedabad") {
            return 350.0;
        } else if (dep == "London" && arr == "Sydney") {
            return 300.0;
        } else if (dep == "London" && arr == "Tokyo") {
            return 310.0;
        } else if (dep == "London" && arr == "Lagos") {
            return 170.0;
        } else if (dep == "New York" && arr == "London") {
            return 200.0;
        } else if (dep == "New York" && arr == "Ahmedabad") {
            return 450.0;
        } else if (dep == "New York" && arr == "Sydney") {
            return 400.0;
        } else if (dep == "New York" && arr == "Tokyo") {
            return 475.0;
        } else if (dep == "New York" && arr == "Lagos") {
            return 390.0;
        } else if (dep == "Ahmedabad" && arr == "New York") {
            return 450.0;
        } else if (dep == "Ahmedabad" && arr == "London") {
            return 250.0;
        } else if (dep == "Ahmedabad" && arr == "Sydney") {
            return 375.0;
        } else if (dep == "Ahmedabad" && arr == "Tokyo") {
            return 390.0;
        } else if (dep == "Ahmedabad" && arr == "Lagos") {
            return 360.0;
        } else if (dep == "Sydney" && arr == "New York") {
            return 400.0;
        } else if (dep == "Sydney" && arr == "Ahmedabad") {
            return 375.0;
        } else if (dep == "Sydney" && arr == "London") {
            return 300.0;
        } else if (dep == "Sydney" && arr == "Tokyo") {
            return 210.0;
        } else if (dep == "Sydney" && arr == "Lagos") {
            return 330.0;
        } else if (dep == "Tokyo" && arr == "New York") {
            return 475.0;
        } else if (dep == "Tokyo" && arr == "Ahmedabad") {
            return 390.0;
        } else if (dep == "Tokyo" && arr == "Sydney") {
            return 210.0;
        } else if (dep == "Tokyo" && arr == "London") {
            return 310.0;
        } else if (dep == "Tokyo" && arr == "Lagos") {
            return 395.0;
        } else if (dep == "Lagos" && arr == "New York") {
            return 290.0;
        } else if (dep == "Lagos" && arr == "Ahmedabad") {
            return 360.0;
        } else if (dep == "Lagos" && arr == "Sydney") {
            return 330.0;
        } else if (dep == "Lagos" && arr == "Tokyo") {
            return 395.0;
        } else if (dep == "Lagos" && arr == "London") {
            return 170.0;
        }
        return 0;

    }

    public double tax() {
        double tax = rand.nextInt(20 - 15 + 1) + 15;
        return tax;
    }

    public double total() {
        return base() + tax();
    }

    public String pnr() {
        String s = "E"; // Made by Tathya & Jishan
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 3) {
                s += (char) (rand.nextInt(57 - 48 + 1) + 48);
            } else {
                s += (char) (rand.nextInt(90 - 65 + 1) + 65);
            }
        }
        return s;
    }
}

// homepage

public class MirageAirways2 {
    public static void main(String[] args) {

        JFrame home = new JFrame("Home");

        JButton bookBusinessButton, bookEconomyButton;

        JTextField nameField, ageField, phoneField;

        JComboBox<String> departureAirportComboBox, landingAirportComboBox;

        // super("Airline Booking System");

        home.getContentPane().setBackground(Color.decode("#ffffff"));

        home.setSize(750, 600);

        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f20 = new Font("IBM Plex Sans SemiBold", Font.PLAIN, 20);
        Font f18 = new Font("IBM Plex Sans SemiBold", Font.PLAIN, 18);

        // input fields

        nameField = new JTextField();
        nameField.setBackground(Color.decode("#ffffff"));
        nameField.setForeground(Color.decode("#1551C5"));
        nameField.setBounds(165, 190, 385, 40);
        nameField.setFont(f20);

        ageField = new JTextField();
        ageField.setBackground(Color.decode("#ffffff"));
        ageField.setForeground(Color.decode("#1551C5"));
        ageField.setBounds(165, 275, 80, 40);
        ageField.setFont(f20);

        phoneField = new JTextField();
        phoneField.setBackground(Color.decode("#ffffff"));
        phoneField.setForeground(Color.decode("#1551C5"));
        phoneField.setBounds(260, 275, 290, 40);
        phoneField.setFont(f20);

        // dropdown menus

        String[] airports = { "Ahmedabad", "New York", "London", "Sydney", "Lagos", "Tokyo" };
        departureAirportComboBox = new JComboBox<>(airports);
        departureAirportComboBox.setBackground(Color.decode("#ffffff"));
        departureAirportComboBox.setForeground(Color.decode("#1551C5"));
        departureAirportComboBox.setBounds(165, 360, 175, 40);
        departureAirportComboBox.setFont(f18);

        landingAirportComboBox = new JComboBox<>(airports);
        landingAirportComboBox.setBackground(Color.decode("#ffffff"));
        landingAirportComboBox.setForeground(Color.decode("#1551C5"));
        landingAirportComboBox.setBounds(375, 360, 175, 40);
        landingAirportComboBox.setFont(f18);

        // buttons

        bookBusinessButton = new JButton("Business Class");
        bookBusinessButton.setBackground(Color.decode("#1551C5"));
        bookBusinessButton.setForeground(Color.decode("#ffffff"));
        bookBusinessButton.setBounds(165, 445, 175, 40);
        bookBusinessButton.setFont(f20);

        bookEconomyButton = new JButton("Economy Class");
        bookEconomyButton.setBackground(Color.decode("#1551C5"));
        bookEconomyButton.setForeground(Color.decode("#ffffff"));
        bookEconomyButton.setBounds(375, 445, 175, 40);
        bookEconomyButton.setFont(f20);

        bookBusinessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();

                    int age = Integer.parseInt(ageField.getText());

                    long phone = Long.parseLong(phoneField.getText());

                    String departureAirport = (String) departureAirportComboBox.getSelectedItem();

                    String landingAirport = (String) landingAirportComboBox.getSelectedItem();

                    if (age < 0) {
                        throw new NumberFormatException();
                    }

                    if (departureAirport.equals(landingAirport)) {
                        throw new IllegalArgumentException();
                    }

                    BusinessClassPassenger passenger = new BusinessClassPassenger(name, age, phone, departureAirport,
                            landingAirport);

                    passenger.displayBoardingPass();

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null, "Please enter a valid age and phone number.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(null, "Please enter a valid input.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);

                }
            }

        });

        bookEconomyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();

                    int age = Integer.parseInt(ageField.getText());

                    long phone = Long.parseLong(phoneField.getText());

                    String departureAirport = (String) departureAirportComboBox.getSelectedItem();

                    String landingAirport = (String) landingAirportComboBox.getSelectedItem();

                    if (age < 0) {
                        throw new IllegalArgumentException();
                    }

                    if (departureAirport.equals(landingAirport)) {
                        throw new IllegalArgumentException();
                    }

                    EconomyClassPassenger passenger = new EconomyClassPassenger(name, age, phone, departureAirport,
                            landingAirport);

                    passenger.displayBoardingPass();

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null, "Please enter a valid age and phone number.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(null, "Please enter a valid input.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        home.setLayout(null);

        JLabel labelWelcome = new JLabel("Welcome to");
        labelWelcome.setFont(new Font("IBM Plex Sans SemiBold", Font.PLAIN, 28));
        labelWelcome.setForeground(Color.decode("#1551C5"));
        labelWelcome.setBounds(280, 20, 400, 100);

        JLabel labelHead = new JLabel("MirageAirways");
        labelHead.setFont(new Font("IBM Plex Sans Bold", Font.PLAIN, 55));
        labelHead.setForeground(Color.decode("#1551C5"));
        labelHead.setBounds(165, 60, 400, 100);

        JLabel label1 = new JLabel("NAME");
        label1.setFont(f18);
        label1.setForeground(Color.decode("#8AA8E1"));
        label1.setBounds(165, 165, 250, 25);

        JLabel label2 = new JLabel("AGE");
        label2.setFont(f18);
        label2.setForeground(Color.decode("#8AA8E1"));
        label2.setBounds(165, 250, 250, 25);

        JLabel label3 = new JLabel("PHONE");
        label3.setFont(f18);
        label3.setForeground(Color.decode("#8AA8E1"));
        label3.setBounds(260, 250, 250, 25);

        JLabel label4 = new JLabel("DEPARTURE");
        label4.setFont(f18);
        label4.setForeground(Color.decode("#8AA8E1"));
        label4.setBounds(165, 335, 160, 25);

        JLabel label5 = new JLabel("ARRIVAL");
        label5.setFont(f18);
        label5.setForeground(Color.decode("#8AA8E1"));
        label5.setBounds(375, 335, 250, 25);

        JLabel label6 = new JLabel("WHAT DO YOU PREFER?");
        label6.setFont(f18);
        label6.setForeground(Color.decode("#8AA8E1"));
        label6.setBounds(165, 420, 400, 25);

        JLabel labelTo = new JLabel("to");
        labelTo.setFont(f18);
        labelTo.setForeground(Color.decode("#1551C5"));
        labelTo.setBounds(350, 365, 400, 25);

        JLabel labelOr = new JLabel("or");
        labelOr.setFont(f18);
        labelOr.setForeground(Color.decode("#1551C5"));
        labelOr.setBounds(350, 450, 400, 25);

        home.add(labelWelcome);
        home.add(labelHead);
        home.add(label1);
        home.add(nameField);
        home.add(label2);
        home.add(ageField);
        home.add(label3);
        home.add(phoneField);
        home.add(label4);
        home.add(departureAirportComboBox);
        home.add(label5);
        home.add(landingAirportComboBox);
        home.add(label6);
        home.add(labelTo);
        home.add(labelOr);
        home.add(bookBusinessButton);
        home.add(bookEconomyButton);

        home.setVisible(true);

    }
}