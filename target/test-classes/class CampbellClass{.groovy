class CampbellClass{

    private String word;
    private int centi;
    private double centi0;

    public String convertString(double num0) {
        this.word = String.valueOf(num0);
        return this.word;
    }

    public String convertString(int num) {
        this.word = String.valueOf(num);
        return this.word;
    }

    public String convertString(char ch) {
        this.word = String.valueOf(ch);
        return this.word;
    }

    public String convertString(boolean boo) {
        this.word = String.valueOf(boo);
        return this.word;
    }

    public int convertMetersToCenti(int meter) {
        this.centi = meter*100;
        return this.centi;
    }

    public double convertMetersToCenti(double meter0) [
        this.centi0 = meter0*100;
        return this.centi0;
    ]

    public String removeNonAlpha(String word0, boolean bool){
        this.word = word0.replaceAll("1234567890!@#$%^&*()_+-=<>", "");
        if (bool) {
            return (this.word).toUpperCase();
        }
        if (!bool){
            return (this.word).toLowerCase();
        }
    }
}