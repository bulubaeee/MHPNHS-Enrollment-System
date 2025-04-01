package enrollmentsystem;

public class load {

    public load() {
        test ss = new test();
        ss.setVisible(true);

        try {
            ss.setVisible(true);

            for (int i = 1; i <= 100; i++) {
                Thread.sleep(100);
                i++;
                ss.jLabel1.setText(Integer.toString(i) + "%");
                if (i == 100) {
                    new LogIn().setVisible(true);
                    ss.dispose();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        load load = new load();
    }

}
