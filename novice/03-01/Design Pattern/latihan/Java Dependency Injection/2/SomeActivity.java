public class SomeActivity extends AppCompat {

    private MyPresenter presenter;
    private EmailServices services;

    @Override
    public void onCreate() {
        services = new EmailServices();

        // pass services ke presenter
        presenter = new MyPresenter(services);
    }
}