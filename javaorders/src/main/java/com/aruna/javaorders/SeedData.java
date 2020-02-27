package com.aruna.javaorders;
import com.aruna.javaorders.models.*;
import com.aruna.javaorders.repositories.*;
import com.aruna.javaorders.services.AgentService;
import com.aruna.javaorders.services.CustomerService;
import com.aruna.javaorders.services.OrderService;
import com.aruna.javaorders.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Component
public class SeedData implements CommandLineRunner {
//    @Autowired
//    AgentService agentService;
//    @Autowired
//    CustomerService customerService;
    @Autowired
    OrderService orderService;
//    @Autowired
//    PaymentService paymentService;
    private CustomerRepository custrepos;
    private AgentRepository agentrepos;
    private OrderRepository orderrepos;
    private PaymentRepository paymentrepos;
    public SeedData(CustomerRepository custrepos,
                    AgentRepository agentrepos,
                    OrderRepository orderrepos,
                    PaymentRepository paymentrepos){
        this.custrepos = custrepos;
        this.agentrepos = agentrepos;
        this.orderrepos = orderrepos;
        this.paymentrepos = paymentrepos;
    }
    @Override
    public void run(String[] args) throws Exception {
        Agent a1 = new Agent("Ramasundar", "Bangalore", 0.15, "077-25814763", "");
        Agent a2 = new Agent("Alex", "London", 0.13, "075-12458969", "");
        Agent a3 = new Agent("Alford", "New York", 0.12, "044-25874365", "");
        Agent a4 = new Agent("Ravi", "Bangalore", 0.15, "077-45625874", "");
        Agent a5 = new Agent("Santakumar", "Chennai", 0.14, "007-22388644", "");
        Agent a6 = new Agent("Lucida", "San Jose", 0.12, "044-52981425", "");
        Agent a7 = new Agent("Anderson", "Brisban", 0.13, "045-21447739", "");
        Agent a8 = new Agent("Subbarao", "Bangalore", 0.14, "077-12346674", "");
        Agent a9 = new Agent("Mukesh", "Mumbai", 0.11, "029-12358964", "");
        Agent a10 = new Agent("McDen", "London", 0.15, "078-22255588", "");
        Agent a11 = new Agent("Ivan", "Torento", 0.15, "008-22544166", "");
        Agent a12 = new Agent("Benjamin", "Hampshair", 0.11, "008-22536178", "");
        Customer c1 = new Customer("Holmes", "London", "London", "UK", "2", 6000.00, 5000.00, 7000.00, 4000.00, "BBBBBBB", a3);
        Customer c2 = new Customer("Micheal", "New York", "New York", "USA", "2", 3000.00, 5000.00, 2000.00, 6000.00, "CCCCCCC", a8);
        Customer c3 = new Customer("Albert", "New York", "New York", "USA", "3", 5000.00, 7000.00, 6000.00, 6000.00, "BBBBSBB", a8);
        Customer c4 = new Customer("Ravindran", "Bangalore", "Bangalore", "India", "2", 5000.00, 7000.00, 4000.00, 8000.00, "AVAVAVA", a11);
        Customer c5 = new Customer("Cook", "London", "London", "UK", "2", 4000.00, 9000.00, 7000.00, 6000.00, "FSDDSDF", a6);
        Customer c6 = new Customer("Stuart", "London", "London", "UK", "1", 6000.00, 8000.00, 3000.00, 11000.00, "GFSGERS", a3);
        Customer c7 = new Customer("Bolt", "New York", "New York", "USA", "3", 5000.00, 7000.00, 9000.00, 3000.00, "DDNRDRH", a8);
        Customer c8 = new Customer("Fleming", "Brisban", "Brisban", "Australia", "2", 7000.00, 7000.00, 9000.00, 5000.00, "NHBGVFC", a5);
        Customer c9 = new Customer("Jacks", "Brisban", "Brisban", "Australia", "1", 7000.00, 7000.00, 7000.00, 7000.00, "WERTGDF", a5);
        Customer c10 = new Customer("Yearannaidu", "Chennai", "Chennai", "India", "1", 8000.00, 7000.00, 7000.00, 8000.00, "ZZZZBFV", a10);
        Customer c11 = new Customer("Sasikant", "Mumbai", "Mumbai", "India", "1", 7000.00, 11000.00, 7000.00, 11000.00, "147-25896312", a2);
        Customer c12 = new Customer("Ramanathan", "Chennai", "Chennai", "India", "1", 7000.00, 11000.00, 9000.00, 9000.00, "GHRDWSD", a10);
        Customer c13 = new Customer("Avinash", "Mumbai", "Mumbai", "India", "2", 7000.00, 11000.00, 9000.00, 9000.00, "113-12345678",a2);
        Customer c14 = new Customer("Winston", "Brisban", "Brisban", "Australia", "1", 5000.00, 8000.00, 7000.00, 6000.00, "AAAAAAA", a5);
        Customer c15 = new Customer("Karl", "London", "London", "UK", "0", 4000.00, 6000.00, 7000.00, 3000.00, "AAAABAA", a6);
        Customer c16 = new Customer("Shilton", "Torento", "Torento", "Canada", "1", 10000.00, 7000.00, 6000.00, 11000.00, "DDDDDDD", a4);
        Customer c17 = new Customer("Charles", "Hampshair", "Hampshair", "UK", "3", 6000.00, 4000.00, 5000.00, 5000.00, "MMMMMMM", a9);
        Customer c18 = new Customer("Srinivas", "Bangalore", "Bangalore", "India", "2", 8000.00, 4000.00, 3000.00, 9000.00, "AAAAAAB", a7);
        Customer c19 = new Customer("Steven", "San Jose", "San Jose", "USA", "1", 5000.00, 7000.00, 9000.00, 3000.00, "KRFYGJK", a10);
        Customer c20 = new Customer("Karolina", "Torento", "Torento", "Canada", "1", 7000.00, 7000.00, 9000.00, 5000.00, "HJKORED", a4);
        Customer c21 = new Customer("Martin", "Torento", "Torento", "Canada", "2", 8000.00, 7000.00, 7000.00, 8000.00, "MJYURFD", a4);
        Customer c22 = new Customer("Ramesh", "Mumbai", "Mumbai", "India", "3", 8000.00, 7000.00, 3000.00, 12000.00, "Phone No", a2);
        Customer c23 = new Customer("Rangarappa", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "AAAATGF", a1);
        Customer c24 = new Customer("Venkatpati", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "JRTVFDD", a7);
        Customer c25 = new Customer("Sundariya", "Chennai", "Chennai", "India", "3", 7000.00, 11000.00, 7000.00, 11000.00, "PPHGRTS", a10);
        Order o1 = new Order(1000.00, 600.00, c13, "SOD");
        Order o2 = new Order(3000.00, 500.00, c19, "SOD");
        Order o3 = new Order(4500.00, 900.00, c7, "SOD");
        Order o4 = new Order(2000.00, 0.00, c16, "SOD");
        Order o5 = new Order(4000.00, 600.00, c22, "SOD");
        Order o6 = new Order(2000.00, 0.00, c12, "SOD");
        Order o7 = new Order(3500.00, 2000.00, c2, "SOD");
        Order o8 = new Order(2500.00, 400.00, c3, "SOD");
        Order o9 = new Order(500.00, 0.00, c23, "SOD");
        Order o10 = new Order(4000.00, 700.00, c7, "SOD");
        Order o11 = new Order(1500.00, 600.00, c8, "SOD");
        Order o12 = new Order(2500.00, 0.00, c25, "SOD");
        Payment p1 = new Payment("Cash");
        Payment p2 = new Payment("Gift Card");
        Payment p3 = new Payment("Credit Card");
        Payment p4 = new Payment("Mobile Pay");
        agentrepos.save(a1);
        agentrepos.save(a2);
        agentrepos.save(a3);
        agentrepos.save(a4);
        agentrepos.save(a5);
        agentrepos.save(a6);
        agentrepos.save(a7);
        agentrepos.save(a8);
        agentrepos.save(a9);
        agentrepos.save(a10);
        agentrepos.save(a11);
        agentrepos.save(a12);
        custrepos.save(c1);
        custrepos.save(c2);
        custrepos.save(c3);
        custrepos.save(c4);
        custrepos.save(c5);
        custrepos.save(c6);
        custrepos.save(c7);
        custrepos.save(c8);
        custrepos.save(c9);
        custrepos.save(c10);
        custrepos.save(c11);
        custrepos.save(c12);
        custrepos.save(c13);
        custrepos.save(c14);
        custrepos.save(c15);
        custrepos.save(c16);
        custrepos.save(c17);
        custrepos.save(c18);
        custrepos.save(c19);
        custrepos.save(c20);
        custrepos.save(c21);
        custrepos.save(c22);
        custrepos.save(c23);
        custrepos.save(c24);
        custrepos.save(c25);
        o1 = orderrepos.save(o1);
        o2 = orderrepos.save(o2);
        o3 = orderrepos.save(o3);
        o4 = orderrepos.save(o4);
        o5 = orderrepos.save(o5);
        o6 = orderrepos.save(o6);
        o7 = orderrepos.save(o7);
        o8 = orderrepos.save(o8);
        o9 = orderrepos.save(o9);
        o10 = orderrepos.save(o10);
        o11 = orderrepos.save(o11);
        o12 = orderrepos.save(o12);
        p1 = paymentrepos.save(p1);
        p2 = paymentrepos.save(p2);
        p3 = paymentrepos.save(p3);
        p4 = paymentrepos.save(p4);
        orderService.addOrderPayments(o1.getOrdnum(),p1.getPaymentid());
        orderService.addOrderPayments(o2.getOrdnum(),p2.getPaymentid());
        orderService.addOrderPayments(o3.getOrdnum(),p3.getPaymentid());
        orderService.addOrderPayments(o3.getOrdnum(),p2.getPaymentid());
        orderService.addOrderPayments(o4.getOrdnum(),p4.getPaymentid());
        orderService.addOrderPayments(o5.getOrdnum(),p2.getPaymentid());
        orderService.addOrderPayments(o6.getOrdnum(),p3.getPaymentid());
        orderService.addOrderPayments(o7.getOrdnum(),p4.getPaymentid());
        orderService.addOrderPayments(o8.getOrdnum(),p1.getPaymentid());
        orderService.addOrderPayments(o9.getOrdnum(),p3.getPaymentid());
        orderService.addOrderPayments(o10.getOrdnum(),p4.getPaymentid());
        orderService.addOrderPayments(o11.getOrdnum(),p2.getPaymentid());
        orderService.addOrderPayments(o12.getOrdnum(),p1.getPaymentid());
    }
}
