package pageUIs;

public class ContactUsPageUI {
    public static String contactUsText = "(//h1[normalize-space()=\"Get in Touch and Let's Discuss Your Requirements\"])[1]";
    public static String firstNameTxt = "//input[@name='mf-first-name']";
    public static String lastNameTxt = "//input[@name='mf-last-name']";
    public static String emailTxt = "//input[@name='mf-email']";
    public static String subjectTxt = "//input[@name='mf-subject']";
    public static String sendMessageBtn = "//span[normalize-space()='Send Message']";
    public static String errMessageByName = "//input[@name='%s']//following-sibling::span[@class='mf-error-message']";
    public static String comment_errMsg = "//textarea[@name='mf-comment']//following-sibling::span[@class='mf-error-message']";
}
