package pageUIs;

public class ContactUsPageUI {
    public static String contactUsText = "(//h1[normalize-space()=\"Get in Touch and Let's Discuss Your Requirements\"])[1]";
    public static String firstNameTxt = "//input[@name='mf-first-name']";
    public static String lastNameTxt = "//input[@name='mf-last-name']";
    public static String emailTxt = "//input[@name='mf-email']";
    public static String subjectTxt = "//input[@name='mf-subject']";
    public static String sendMessageBtn = "//span[normalize-space()='Send Message']";
    public static String firstName_errMsg = "//input[@name='mf-first-name']//following-sibling::span[@class='mf-error-message']";
    public static String lastName_errMsg = "//input[@name='mf-last-name']//following-sibling::span[@class='mf-error-message']";
    public static String email_errMsg = "//input[@name='mf-email']//following-sibling::span[@class='mf-error-message']";
    public static String subject_errMsg = "//input[@name='mf-subject']//following-sibling::span[@class='mf-error-message']";
    public static String comment_errMsg = "//textarea[@name='mf-comment']//following-sibling::span[@class='mf-error-message']";
    public static String reCaptcha_errMsg = "//input[@name='g-recaptcha-response']//following-sibling::span[@class='mf-error-message']";
}
