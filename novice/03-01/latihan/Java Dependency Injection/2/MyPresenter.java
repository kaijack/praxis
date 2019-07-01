public class MyPresenter {
    private EmailService email;

    public MyPresenter(EmailServices services) {
        this.email = services;
    }

    public void processMessages(String msg, String to) {
        this.email.sendEmail(msg, to);
    }
}