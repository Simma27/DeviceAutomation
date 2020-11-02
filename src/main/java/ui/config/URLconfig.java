package ui.config;

public enum URLconfig {

    AUTOMATION_PRACTICE("http://automationpractice.com/index.php");

    String url;

    URLconfig(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
