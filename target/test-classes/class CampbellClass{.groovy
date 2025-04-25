public final class CampbellClass{

    private CampbellClass() {
    }

    public static String convertString(double num0) {
       return String.valueOf(num0);
    }

    public static String convertString(int num) {
        return String.valueOf(num);
    }

    public static String convertString(char ch) {
        return String.valueOf(ch);
    }

    public static String convertString(boolean boo) {
        return String.valueOf(boo);
    }

    public int convertMetersToCenti(int meter) {
        return meter*100;
    }

    public double convertMetersToCenti(double meter0) {
        return meter0*100;
    }

    public String removeNonAlpha(String word0, boolean bool){
        String cleaned = word0.replaceAll("[^a-zA-Z]", "");
        if (bool) {
            return cleaned.toUpperCase();
        }
        if (!bool){
            return cleaned.toLowerCase();
        }
        return "";
    }
}