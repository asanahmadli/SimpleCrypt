import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    char cs;
    char cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return "";
    }

    public String encrypt(String f) {
        String text  = f;
        String[] split = text.split(" ");
        StringBuilder sb = new StringBuilder();
        String ch = String.valueOf(cf).toLowerCase();
        String alphabetSmall = "";
        String alphabetCapital = "";
        String encrypt = "";

        //alphabetSmall
        for(int i = 'a'; i <='z';i++ ){
            alphabetSmall+=(char)i;
        }
        //alphabetCapital
        for(int i = 'A'; i <='Z';i++ ){
            alphabetCapital+=(char)i;
        }

        int index = alphabetSmall.indexOf(ch);
        //find sliding alphabet
        String slidingSmall = alphabetSmall.substring(alphabetSmall.length()-index)+alphabetSmall.substring(0,alphabetSmall.length()-index);
        String slidingCapital = alphabetCapital.substring(alphabetCapital.length()-index)+alphabetCapital.substring(0,alphabetCapital.length()-index);

        // System.out.println(slidingCapital);
        // System.out.println(sliding);
        // System.out.println(slidingSmall);
        //loop through string
        for(int s = 0; s<split.length;s++){

            for(int p = 0; p<split[s].length();p++) {
                if (alphabetSmall.contains(split[s].charAt(p) + "")) {
                    int smallLetterIndex = 0;
                    for(int m = 0; m<alphabetSmall.length();m++){
                        if(split[s].charAt(p)==alphabetSmall.charAt(m)){
                            smallLetterIndex = m;
                            break;
                        }
                    }
                    encrypt+=slidingSmall.charAt(smallLetterIndex);
                }
                else if (alphabetCapital.contains(split[s].charAt(p) + "")) {
                    int capitalLetterIndex = 0;
                    for(int m = 0; m<alphabetCapital.length();m++){
                        if(split[s].charAt(p)==alphabetCapital.charAt(m)){
                            capitalLetterIndex = m;
                            break;
                        }
                    }

                    encrypt+=slidingCapital.charAt(capitalLetterIndex);
                }
                else {
                    encrypt+=split[s].charAt(p);
                }
            }//inner loop
            sb.append(encrypt).append(" ");
            encrypt = "";
        }//outer loop

        return sb.toString().trim();

    }

    public String decrypt(String text) {
        return encrypt(text);
    }

    public static String rotate(String f, Character c) {
        String text  = "Gb trg gb gur bgure fvqr!";
        String[] split = text.split(" ");
        StringBuilder sb = new StringBuilder();
        String ch = String.valueOf(c).toLowerCase();
        String alphabetSmall = "";
        String alphabetCapital = "";
        String encrypt = "";

        //alphabetSmall
        for(int i = 'a'; i <='z';i++ ){
            alphabetSmall+=(char)i;
        }
        //alphabetCapital
        for(int i = 'A'; i <='Z';i++ ){
            alphabetCapital+=(char)i;
        }

        int index = alphabetSmall.indexOf(ch);
        //find sliding alphabet
        String slidingSmall = alphabetSmall.substring(alphabetSmall.length()-index)+alphabetSmall.substring(0,alphabetSmall.length()-index);
        String slidingCapital = alphabetCapital.substring(alphabetCapital.length()-index)+alphabetCapital.substring(0,alphabetCapital.length()-index);
        return slidingCapital;
    }

    public static void main(String[] args) {
      String text  = "Gb trg gb gur bgure fvqr!";
      String[] split = text.split(" ");
      StringBuilder sb = new StringBuilder();
      String ch = String.valueOf('n').toLowerCase();
      String alphabetSmall = "";
      String alphabetCapital = "";
      String encrypt = "";

      //alphabetSmall
      for(int i = 'a'; i <='z';i++ ){
          alphabetSmall+=(char)i;
      }
        //alphabetCapital
        for(int i = 'A'; i <='Z';i++ ){
            alphabetCapital+=(char)i;
        }

        int index = alphabetSmall.indexOf(ch);
        //find sliding alphabet
        String slidingSmall = alphabetSmall.substring(alphabetSmall.length()-index)+alphabetSmall.substring(0,alphabetSmall.length()-index);
        String slidingCapital = alphabetCapital.substring(alphabetCapital.length()-index)+alphabetCapital.substring(0,alphabetCapital.length()-index);

        System.out.println(slidingCapital);
        // System.out.println(sliding);
        System.out.println(slidingSmall);
        //loop through string
        for(int s = 0; s<split.length;s++){

            for(int p = 0; p<split[s].length();p++) {
                if (alphabetSmall.contains(split[s].charAt(p) + "")) {
                    int smallLetterIndex = 0;
                    for(int m = 0; m<alphabetSmall.length();m++){
                        if(split[s].charAt(p)==alphabetSmall.charAt(m)){
                            smallLetterIndex = m;
                            break;
                        }
                    }
                    encrypt+=slidingSmall.charAt(smallLetterIndex);
                }
                else if (alphabetCapital.contains(split[s].charAt(p) + "")) {
                    int capitalLetterIndex = 0;
                    for(int m = 0; m<alphabetCapital.length();m++){
                        if(split[s].charAt(p)==alphabetCapital.charAt(m)){
                            capitalLetterIndex = m;
                            break;
                        }
                    }

                    encrypt+=slidingCapital.charAt(capitalLetterIndex);
                }
                else {
                    encrypt+=split[s].charAt(p);
                }
            }//inner loop
            sb.append(encrypt).append(" ");
            encrypt = "";
        }//outer loop

        System.out.println(sb.toString());
    }
}
