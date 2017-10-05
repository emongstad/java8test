package org.erlend.test.java8test.simulator;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class IBANCreator {

    @Test
    public void calculateValidChecksum() throws Exception {
        String countryCode = "AT";
        String bban_part = "1998500000000000";
        System.out.println("Valid IBAN numbers for BBAN: " + bban_part);
        for (int i = 0; i < 100; i++) {
            if (this.validateIBANdoMOD97Only(countryCode + StringUtils.leftPad(i + "", 2, "0") + bban_part)) {
                System.out.println(" - " + countryCode + StringUtils.leftPad(i + "", 2, "0") + bban_part);
            }
        }
    }

    private boolean validateIBANdoMOD97Only(String ibanAccount) {
        return validateMOD97(ibanAccount);
    }

    private boolean validateMOD97(String ibanAccount) {
        return calculateMOD97(reArrangeIbanAccount(ibanAccount)) == 1;
    }

    private String reArrangeIbanAccount(String ibanAccount) {
        String reArranged = StringUtils.right(ibanAccount, ibanAccount.length() - 4) +
                StringUtils.left(ibanAccount, 4);

        char[] reArrangedIbanCharArray = reArranged.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : reArrangedIbanCharArray) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                stringBuilder.append(Character.getNumericValue(c));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Calculate MOD97 for an account recursively
     */
    private int calculateMOD97(String ibanAccount) {
        if (ibanAccount.length() > 9) {
            /*
             * If account is longer than 9 we get the MOD of the first 9 digits
             * and prepend this to the rest before invoking recursive with this
             * value
             */
            String mod97IbanAccount = ibanAccount.substring(0, 9);
            int mod = calculateMOD97(mod97IbanAccount);
            return calculateMOD97(mod + ibanAccount.substring(9));

        } else {
            return Integer.valueOf(ibanAccount) % 97;
        }
    }
}
